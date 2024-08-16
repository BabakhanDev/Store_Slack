import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static AbstractList<User> users = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Commands:
                    Press 1: Register
                    Press 2: Login
                    Press 3: Exit
                    Wtite command:
                    """);
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1: {
                    registerUser(scanner);
                    break;
                }

                case 2: {
                    loginUser(scanner);
                    break;
                }
                case 3: {
                    System.out.println("Программа жабылды.");

                    return;
                }
                default:
                    System.out.println("Туура эмес буйрук.");
            }
        }


    }

    // Метод Регистрация
    private static void registerUser(Scanner scanner) {
        System.out.println("Write name:");
        String firstName = scanner.nextLine();
        System.out.println("Write surName:");
        String lastName = scanner.nextLine();
        if (firstName.isEmpty() || lastName.isEmpty()) {
            System.out.println("FirstName жана LastName бош болбошу керек!:");
            return;
        }
        System.out.println("Write Email: ");
        String email = scanner.nextLine();
        if (isEmailTaken(email)) {
            System.out.println(" Бул email  мурунтан бар!");
            return;
        }
        System.out.println("Write password: ");
        String password = scanner.nextLine();
        if (password.length() <= 4) {
            System.out.println(" Пароль 4 символдон узун болушу керек!: ");
            return;
        }
        User newUser = new User(firstName, lastName, email, password);
        users.add(newUser);
        System.out.println("Колдонуучу ийгиликтүү катталды: " + newUser);
    }

    // уникален ли Емейл
    private static boolean isEmailTaken(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;

        }
        return false;
    }

    // Метод логин
    private static void loginUser(Scanner scanner) {
        System.out.println("Write Email: ");
        String email = scanner.nextLine();
        System.out.println("Write password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.checkPassword(password)) {
                System.out.println("Кош келиңиз, " + user.getEmail() + "!");
                return;
            }

        }
        System.out.println("Email же пароль туура эмес.");
    }

}