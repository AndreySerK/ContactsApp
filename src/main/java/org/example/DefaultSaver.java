package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Component
@Profile("init")
@PropertySource("classpath:application-init.properties")
public class DefaultSaver implements Saver{

    @Value("${save.path}")
    private String savePath;

    @Override
    public void save(List<Contact> contactList) {
        contactList.forEach(c -> {
            try {
                String strToWright = "\n" + c.getFullName() + ";" + c.getPhoneNumber() + ";" + c.getEmail();
                Files.write(Path.of(savePath), strToWright.getBytes(), StandardOpenOption.APPEND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
