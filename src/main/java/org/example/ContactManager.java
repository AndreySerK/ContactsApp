package org.example;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class ContactManager {

    private final Saver contactsSaver;

    @Getter
    private final List<Contact> contactList;

    public ContactManager(Loader contactsLoader, Saver contactsSaver) {
        this.contactsSaver = contactsSaver;
        try {
            contactList = contactsLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printContactList() {
        if (contactList.isEmpty())
            System.out.println("Contact list is empty...");
        contactList.forEach(System.out::println);
        System.out.println();
    }

    public void addContactToList(Scanner scanner) {
        Contact contact = new Contact();

        System.out.println("Input full name... (for example: John Smith), then press Enter");
        String fullName = scanner.nextLine();
        if (fullName.matches("^[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*$"))
            contact.setFullName(fullName);
        else {
            System.out.println("Name has invalid format");
            return;
        }

        System.out.println("Input phone number... (for example: +81234567890), then press Enter");
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.matches("^\\+?[1-9][0-9]{7,14}$"))
            contact.setPhoneNumber(phoneNumber);
        else {
            System.out.println("Phone number has invalid format");
            return;
        }

        System.out.println("Input email... (for example: someEmail3@example.example), then press Enter");
        String email = scanner.nextLine();
        if (email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"))
            contact.setEmail(email);
        else {
            System.out.println("Email has invalid format");
            return;
        }

        contactList.add(contact);
        System.out.println("Contact:\n" + contact + "\nwas added to contact list!\n");
    }

    public void saveContactsToFile() {
        contactsSaver.save(contactList);
        System.out.println("Contacts was saved to file !\n");
    }

    public void deleteContactsByEmail(Scanner scanner) {
        System.out.println("Input email (for example: email@dot.com), then press ENTER\n");
        contactList.forEach(c -> {
            if (c.getEmail().equals(scanner.next()))
                contactList.remove(c);
        });

    }
}
