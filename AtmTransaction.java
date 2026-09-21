import java.util.Scanner;

public class AtmTransaction {
    static final int CORRECT_PIN = 1234;
    static final double DAILY_LIMIT = 20000.0;
    static final int[] NOTES = {2000, 500, 200, 100};
    static double[] history = new double[3];
    static int historyCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 50000.0;
        int attempts = 0;
        boolean isBlocked = false;

        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            int inputPin = sc.nextInt();
            if (authenticate(inputPin)) {
                break;
            } else {
                attempts++;
                System.out.println("Incorrect.");
                if (attempts == 3) isBlocked = true;
            }
        }

        if (isBlocked) {
            System.out.println("Card Blocked.");
            return;
        }

        boolean active = true;
        while (active) {
            displayMenu();
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Balance: " + balance);
            } else if (choice == 2) {
                System.out.print("Amount: ");
                double amount = sc.nextDouble();
                balance = withdraw(amount, balance);
            } else if (choice == 4) {
                printStatement();
            } else if (choice == 5) {
                active = false;
            } else {
                System.out.println("Invalid.");
            }
        }
    }

    public static boolean authenticate(int pin) {
        return pin == CORRECT_PIN;
    }

    public static void displayMenu() {
        System.out.println("\n1.Balance 2.Withdraw 4.Statement 5.Exit");
    }

    public static double withdraw(double amount, double currentBalance) {
        if (amount <= 0 || amount > DAILY_LIMIT || amount > currentBalance || amount % 100 != 0) {
            System.out.println("Denied.");
            return currentBalance;
        }

        int remaining = (int) amount;
        System.out.println("Dispensing:");
        for (int i = 0; i < NOTES.length; i++) {
            int count = remaining / NOTES[i];
            if (count > 0) {
                System.out.println(NOTES[i] + " x " + count);
            }
            remaining %= NOTES[i];
        }

        if (historyCount < 5) {
            history[historyCount++] = amount;
        }

        return currentBalance - amount;
    }

    public static void printStatement() {
        System.out.println("History:");
        for (int i = 0; i < historyCount; i++) {
            System.out.println(history[i]);
        }
    }
}