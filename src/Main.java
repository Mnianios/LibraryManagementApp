public class Main {
    public static void main(String[] args) {
        IDandPasswords idAndPasswords = new IDandPasswords();
        new LoginPage(idAndPasswords.getLoginInfo());
    }
}