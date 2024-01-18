import java.util.ArrayList;
import java.util.Scanner;

public class AccountManagement {
    private final ArrayList<Account> accounts;
    private int currentUserIndex;

    public AccountManagement(ArrayList<Account> accounts) {
        this.accounts = accounts;
        this.currentUserIndex = -1;
    }

    public int findUserIndexByUsername(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public void setCurrentUserIndex(int index) {
        this.currentUserIndex = index;
    }

    public void withdraw() {
        if (currentUserIndex != -1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the amount to withdraw:");
            int amount = scanner.nextInt();

            Account currentAccount = accounts.get(currentUserIndex);
            int balance = currentAccount.getBalance();

            if (balance >= amount) {
                currentAccount.setBalance(balance - amount);

                System.out.println("Amount withdrawn: " + amount);
                MiniReport.addToReport("Amount withdrawn: " + amount);
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            System.out.println("User not logged in");
        }
    }

    public void checkBalance() {
        if (currentUserIndex != -1) {
            Account currentAccount = accounts.get(currentUserIndex);
            int balance = currentAccount.getBalance();
            System.out.println("Balance Amount is: " + balance);
            MiniReport.addToReport("Balance Checked: " + balance);
        } else {
            System.out.println("User not logged in");
        }
    }

    public void changePin(Scanner scanner) {
        if (currentUserIndex != -1) {
            Account currentAccount = accounts.get(currentUserIndex);

            System.out.println("Enter the new Pin:");
            int newPin = scanner.nextInt();

            System.out.println("Type CONFIRM:");
            scanner.nextLine();
            String confirm = scanner.nextLine();

            if (confirm.equals("CONFIRM")) {
                currentAccount.setPin(new int[]{newPin});
                System.out.println("Pin changed Successfully");
                MiniReport.addToReport("Pin changed Successfully");
            } else {
                System.out.println("Operation canceled");
            }
        } else {
            System.out.println("User not logged in");
        }
    }

    public void moneyTransfer(Scanner scanner) {
        if (currentUserIndex != -1) {
            System.out.println("Enter the user Name:");
            scanner.nextLine();
            String recipientUserName = scanner.nextLine();

            Account currentAccount = accounts.get(currentUserIndex);
            Account recipientAccount = findAccountByUsername(recipientUserName);

            if (recipientAccount != null) {
                System.out.println("Enter the amount to transfer:");
                int transferAmount = scanner.nextInt();

                if (currentAccount.getBalance() >= transferAmount) {
                    currentAccount.setBalance(currentAccount.getBalance() - transferAmount);
                    recipientAccount.setBalance(recipientAccount.getBalance() + transferAmount);

                    System.out.println("Money transferred successfully");
                    MiniReport.addToReport("Money transferred Successfully " +
                            currentAccount.getUserName() + " to " + recipientAccount.getUserName());
                } else {
                    System.out.println("Insufficient Balance");
                }
            } else {
                System.out.println("Recipient user not found");
            }
        } else {
            System.out.println("User not logged in");
        }
    }

    public void deposit(Scanner scanner) {
        if (currentUserIndex != -1) {
            System.out.println("Enter the deposit Amount:");
            int depositAmount = scanner.nextInt();

            Account currentAccount = accounts.get(currentUserIndex);
            currentAccount.setBalance(currentAccount.getBalance() + depositAmount);

            System.out.println("Deposit Amount is: " + depositAmount +
                    " Now Balance is: " + currentAccount.getBalance());
            MiniReport.addToReport("Deposit Amount is: " + depositAmount +
                    " Now Balance is: " + currentAccount.getBalance());
        } else {
            System.out.println("User not logged in");
        }
    }

    public void miniReport() {
        MiniReport.printReport();
    }

    private Account findAccountByUsername(String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;
    }
}
