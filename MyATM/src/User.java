import java.util.ArrayList;

public class User {
    private String cardNumber = "1";
    public String balance = "54321";
    public ArrayList<String> transactionHistory = new ArrayList<>();

    // card number getter
    public String getCardNumber() {
        return cardNumber;
    }
}