public class Account {
    private int balance;
    private int[] pin;
    private final String userName;

    public Account(String userName, int initialBalance, int[] pin) {
        this.userName = userName;
        this.balance = initialBalance;
        this.pin = pin.clone();
    }

    public String getUserName() {
        return userName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int[] getPin() {
        return pin.clone();
    }

    public void setPin(int[] pin) {
        this.pin = pin.clone();
    }
}

