import java.util.ArrayList;
import java.util.Scanner;

public class CashManagement {
    private final ArrayList<Integer> denominations;

    public CashManagement(ArrayList<Integer> denominations) {
        this.denominations = denominations;
    }

    public void addCash() {
        Scanner scanner = new Scanner(System.in);
        int toAdd = scanner.nextInt();

        int total = 0;
        for (int i = 0; i < denominations.size(); i++) {
            int denomination = denominations.get(i);
            System.out.println("Enter the number of " + denomination + " bills:");
            int count = scanner.nextInt();
            denominations.set(i, denominations.get(i) + count);
            total += denomination * count;
        }
        System.out.println("Total amount added: " + total);
    }

    public void checkCash() {
        int total = 0;
        for (int i = 0; i < denominations.size(); i++) {
            total += denominations.get(i) * getDenomination(i);
        }
        System.out.println("Denominations and counts: " + denominations);
        System.out.println("Total cash: " + total);
    }

    private int getDenomination(int index) {
        int[] denominationsArray = {2000, 500, 200, 100};
        return denominationsArray[index];
    }
}
