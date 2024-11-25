import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "j";
        String password = "e";
        String confirmPassword = "e";

        try {
            checkParameters(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка окончена");
        }

    }
    public static void checkParameters(String login, String password, String confirmPassword) {
        if (login.length() > 20 || !login.matches("[a-zA-Z0-9_] {1,20}$")) {
            throw new WrongLoginException("Неверно введен логин");
        }
        if (password.length() > 20 || !password.matches("[a-zA-Z0-9_] {1,20}$"))
            throw new WrongPasswordException("Неверно введен пароль");
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Неверно введен пароль");
        }
    }
}