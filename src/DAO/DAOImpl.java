package DAO;

import DAO.enums.Gender;
import Models.User;
import db.DateBase;

import java.util.Arrays;
import java.util.Scanner;

public class DAOImpl implements DAO {
    Scanner scannerStr = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);

    DateBase dateBase = new DateBase();

    @Override
    public void register(User user) {
        try {
            System.out.print("Напиши имя: ");
            String name = scannerStr.nextLine();
            for (User user1 : dateBase.users) {
                if (!user1.getUserName().equals(name)) {
                    user.setUserName(name);
                } else {
                    throw new RuntimeException("Такое имя уже существует!");

                }
            }
            System.out.print("Телефон номер (+996/13 цифр): ");
            String phoneNumber = scannerStr.nextLine();
            if (phoneNumber.startsWith("+996") && phoneNumber.length() == 13) {
                user.setPhoneNumber(phoneNumber);
            } else {
                throw new RuntimeException("Неправильный формат цифр!");
            }
            System.out.print("Email (@gmail.com): ");
            String email = scannerStr.nextLine();
            if (email.contains("@gmail.com")) {
                user.setGmail(email);
            } else {
                throw new RuntimeException("Неправильный gmail!");
            }
            System.out.print("Пороль: ");
            String password = scannerStr.nextLine();
            if (password.length() > 4) {
                user.setPassword(password);
            } else {
                throw new RuntimeException("Неправильное длина!");
            }
            System.out.print("Пол (1.М/2.Ж): ");
            String gender = scannerStr.nextLine();
            if (gender.equals("1") || gender.equals("М")) {
                user.setGender(Gender.MALE);
            } else if (gender.equals("2") || gender.equals("Ж")) {
                user.setGender(Gender.FEMALE);
            } else {
                throw new RuntimeException("Неправильный символ!");
            }

            dateBase.users = Arrays.copyOf(dateBase.users, dateBase.users.length + 1);
            dateBase.users[dateBase.users.length - 1] = user;

            System.out.println("Регистрация прошла успешно!");
            System.out.println(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void login() {
        try {
            if (dateBase.users.length==0) {
                System.out.println("Пока зарегистрированных пользователей нет!");
            }
            else {

                System.out.print("Gmail: ");
                String gmail = scannerStr.nextLine();
                System.out.print("Пороль: ");
                String password = scannerStr.nextLine();

                for (User user : dateBase.users) {
                    if (gmail.equals(user.getGmail()) && password.equals(user.getPassword())) {
                        System.out.println("Добро пожаловать в аккаунт!");
                    } else {
                        throw new RuntimeException("Неправильный логин или пороль!");
                    }

                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
