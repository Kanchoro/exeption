import DAO.DAOImpl;
import Models.User;
import Service.UserService;
import Service.UserServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DAOImpl dao = new DAOImpl();
        UserServiceImpl userService = new UserServiceImpl(dao);


        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("""
                        1.Регистрация
                        2.Войти
                        """);
                System.out.print("Твой выбор: ");
                int number = scannerInt.nextInt();
                switch (number) {
                    case 1 -> {
                        User user = new User();
                        userService.register(user);
                    }
                    case 2 -> {
                        userService.login();
                    }
                    default -> throw new RuntimeException("Неправильный формат!");
                }
            } catch (Exception e) {
                System.out.println("Неправильный формат");
            }
        }
    }
}