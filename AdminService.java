import java.util.Scanner;
public class AdminService implements BankService {
    private final Scanner scanner;
    private final CashManagement cashManagement;

    public AdminService(Scanner scanner, CashManagement cashManagement) {
        this.scanner = scanner;
        this.cashManagement = cashManagement;
    }

    @Override
    public void execute() {
        System.out.println("Enter password: ");
        String password = scanner.next();
        if (!password.equals("admin")) {
            System.out.println("Incorrect password");
            return;
        } else {
            System.out.println("1. Add Cash");
            System.out.println("2. Check Total Cash");
            System.out.println("3. Exit");
        }
        int choice;
        do {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cashManagement.addCash();
                    break;
                case 2:
                    cashManagement.checkCash();
                    break;
            }
        } while (choice != 3);
    }
}
