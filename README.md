# AtmTransaction.java
The ATM Transaction Simulator project is essentially about managing a digital "conversation" between a cardholder and a bank terminal
. Following the SEE-SPECIFY-DESIGN-PROVE-IMPLEMENT workflow, the goal is to observe exactly what information enters the system—like a PIN or a withdrawal amount—and what observable evidence comes out, such as dispensed notes or a mini-statement
. By defining a clear boundary, we focus on the core logic of transactions while keeping complex hardware or network encryption outside the first version of the program
.
The heart of the simulator is the Greedy Algorithm used for note dispensing
. This logic follows a precise, ordered procedure where the system tries to fulfill a withdrawal using the fewest notes possible by prioritizing the largest denominations first (like ₹2000, then ₹500)
. A key rule is that if an exact mix cannot be made from the available stock, the transaction must be refused entirely rather than part-dispensed
.
When writing the Java code, we use a modular design to keep it organized
. Instead of one giant block of code, we use helper methods where each one has a "focused responsibility," like authenticate() for PINs or withdraw() for the math
. We use specific data types to keep the values safe: int for whole numbers like PINs and note counts, double for decimal measurements like account balances, and boolean for the "blocked" status of a card
.
The project is considered "done" when it handles edge cases correctly, such as locking the card after three wrong PIN attempts or rejecting a transaction that exceeds the daily limit
. To make sure the logic actually works before running it, we use trace tables to "desk-check" the plan by hand, which is much easier and cheaper to fix than debugging broken Java code later
.
