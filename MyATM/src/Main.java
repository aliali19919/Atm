public class Main{

    public static User user = new User();
    public static String numberHolder;
    public static String updatedBalance = user.balance;

    public static void main(String[] args) {
        SignIn signIn = new SignIn("Sign In");
        signIn.Run();
    }
}