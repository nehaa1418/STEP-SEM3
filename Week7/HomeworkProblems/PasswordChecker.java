public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker p1 = new PasswordChecker("cat");
        PasswordChecker p2 = new PasswordChecker("hello123");
        PasswordChecker p3 = new PasswordChecker("SecurePassword");

        System.out.println("Password 1 strength: " + p1.getStrength());
        System.out.println("Password 2 strength: " + p2.getStrength());
        System.out.println("Password 3 strength: " + p3.getStrength());
    }
}