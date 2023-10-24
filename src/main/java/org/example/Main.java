package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactManager manager = context.getBean(ContactManager.class);
        System.out.println("""
                Available commands:
                SHOW -> prints current list of contacts;
                ADD -> adds contact to the current list;
                REMOVE -> removes contact from the current list by user's email;
                SAVE -> saves current list of contacts to file;
                EXIT -> finishes execution;
                """);
        boolean b = true;
        while (b) {
            System.out.println("Input command and press ENTER...");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "SHOW" -> manager.printContactList();
                case "ADD" -> manager.addContactToList(scanner);
                case "REMOVE" -> manager.deleteContactsByEmail(scanner);
                case "SAVE" -> manager.saveContactsToFile();
                case "EXIT" -> b = false;
                default -> System.out.println("No such command detected. Input available command!");
            }
        }
    }

    private static void execute (ContactManager manager) {
        System.out.println("Input command and press ENTER...");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "SHOW" -> manager.printContactList();
            case "ADD" -> manager.addContactToList(scanner);
            case "REMOVE" -> manager.deleteContactsByEmail(scanner);
            case "SAVE" -> manager.saveContactsToFile();
            case "EXIT" -> scanner.close();
            default -> System.out.println("No such command detected. Input available command!");
        }
    }

}
