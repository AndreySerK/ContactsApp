package org.example;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class ContactManager {

    private final Loader contactsLoader;
    private final Saver contactsSaver;

    @Getter
    private final List<Contact> contactList;

    public ContactManager(Loader contactsLoader, Saver contactsSaver) {
        this.contactsLoader = contactsLoader;
        this.contactsSaver = contactsSaver;
        try {
            contactList = contactsLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printDefaultContactList() {
        try {
            contactsLoader.load()
                    .forEach(System.out::println);
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printContactList() {
        contactList.forEach(System.out::println);
        System.out.println();
    }

    public void addContactToList(Scanner scanner) {
        Contact contact = new Contact();
        System.out.println("Input full name... (for example: John Smith), then press Enter");
            if (scanner.hasNext())
                contact.setFullName(scanner.nextLine());
            System.out.println("Input phone number... (for example: +890999999), then press Enter");
            if (scanner.hasNext())
                contact.setPhoneNumber(scanner.nextLine());
            System.out.println("Input email... (for example: someEmail3@example.example), then press Enter");
            if (scanner.hasNext())
                contact.setEmail(scanner.nextLine());
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
