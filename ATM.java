import java.util.Scanner;
class ATM {
    private static final String USER_ID = "user1";
    private static final int USER_PIN = 1234;
    private static final double INITIAL_BALANCE = 1000.0;
    private static double balance = INITIAL_BALANCE;
    private static boolean isLoggedIn = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!isLoggedIn) {
                System.out.println("Welcome to ATM!");
                System.out.println("Please enter your user ID:");
                String userId = scanner.nextLine();
               System.out.println("Please enter your user PIN:");
                int userPin = scanner.nextInt();
                scanner.nextLine(); 

                if (authenticate(userId, userPin)) {
                    isLoggedIn = true;
                } else {
                    System.out.println("Authentication failed. Please try again.");
                }
            } else {
                System.out.println("Please select an option:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                int option = scanner.nextInt();
                scanner.nextLine(); 

                switch (option) {
                    case 1:
                        transactionHistory();
                        break;
                    case 2:
                        withdraw(scanner);
                        break;
                    case 3:
                        deposit(scanner);
                        break;
                    case 4:
                        transfer(scanner);
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
    private static boolean authenticate(String userId, int userPin) {
        return userId.equals(USER_ID) && userPin == USER_PIN;
    }
    private static void transactionHistory() {
        System.out.println("Transaction history:");
        System.out.println("Initial balance: " + INITIAL_BALANCE);
        // ...
    }
    private static void withdraw(Scanner scanner) {
        System.out.println("Withdraw:");
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }
    private static void deposit(Scanner scanner) {
        System.out.println("Deposit:");
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }
    private static void transfer(Scanner scanner) {
        System.out.println("Transfer:");
        System.out.println("Enter amount to transfer:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Transfer successful. New balance: " + balance);
        }
    }
}