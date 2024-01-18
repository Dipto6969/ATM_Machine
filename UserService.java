import java.util.Scanner;
public class UserService implements BankService {
    private final Scanner scanner;
    private final AccountManagement accountManagement;

    public UserService(Scanner scanner, AccountManagement accountManagement) {
        this.scanner = scanner;
        this.accountManagement = accountManagement;
    }

    @Override
    public void execute() {
        int choice;
        do {

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    accountManagement.withdraw();
                    break;
                case 2:
                    accountManagement.checkBalance();
                    break;
                case 3:
                    accountManagement.changePin(scanner);
                    break;
                case 4:
                    accountManagement.moneyTransfer(scanner);
                    break;
                case 5:
                    accountManagement.deposit(scanner);
                    break;
                case 6:
                    accountManagement.miniReport();
                    break;
            }
        } while (choice != 7);
    }
}
