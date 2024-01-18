import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Integer> money = new ArrayList<>();

    public static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Account account1 = new Account("user1", 1000, new int[]{1234});
        Account account2 = new Account("user2", 2000, new int[]{5678});

        accounts.add(account1);
        accounts.add(account2);

        AccountManagement accountManagement = new AccountManagement(accounts);
        CashManagement cashManagement = new CashManagement(money);

        boolean flag = true;
        while (flag) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("1.ADMIN");
            System.out.println("2.USER");
            System.out.println("3.EXIT");
            System.out.println("Enter Your Choice:");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    BankService adminService = new AdminService(sc, cashManagement);
                    adminService.execute();
                    break;
                case 2:
                    System.out.println("Enter your username:");
                    sc.nextLine();
                    String username = sc.nextLine();
                    System.out.println("Enter your password");
                    sc.nextLine();
                    System.out.println("Choice:");

                    int userIndex = accountManagement.findUserIndexByUsername(username);

                    if (userIndex != -1) {
                        AccountManagement userAccountManagement = new AccountManagement(accounts);
                        userAccountManagement.setCurrentUserIndex(userIndex);

                        BankService userService = new UserService(sc, userAccountManagement);
                        userService.execute();
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}

