public class CheckService {

    private static final String validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    private static boolean checkCharacters(String s) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (validCharacters.contains(Character.toString(aChar))) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    private static void validatePasswords (String password, String confirmPassword) throws WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
    public static void check(Authentication authentication) {
        boolean success = true;
        try {
            validateLogin(authentication.getLogin());
            validatePassword(authentication.getPassword());
            validatePasswords(authentication.getPassword(), authentication.getConfirmPassword());
        } catch (WrongLoginException | WrongPasswordException e) {
            success = false;
            System.out.println("Проверка не пройдена: " + e.getMessage());
        }
        if (success) {
            System.out.println("Проверка пройдена успешно");
        }
    }


    private static boolean checkLength(String s) {
        return s.length() <= 20;
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (!checkCharacters(login)){
            throw new WrongLoginException("Неправильные символы логина");
        } if (!checkLength(login)) {
            throw new WrongLoginException("Неправильная длина логина");
        }

    }

    private static void validatePassword(String password) throws WrongPasswordException {
        if (!checkCharacters(password)){
            throw new WrongPasswordException("Неправильные символы пароля");
        } if (!checkLength(password)) {
            throw new WrongPasswordException("Неправильная длина пароля");
        }
    }
}