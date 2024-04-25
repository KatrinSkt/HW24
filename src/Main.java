public class Main {
    public static void main(String[] args) {
        String login = "katrin";
        String password = "123456789";
        String confirmPassword = "123456789";
    CheckService.check(new Authentication(login, password, confirmPassword));

    }
}