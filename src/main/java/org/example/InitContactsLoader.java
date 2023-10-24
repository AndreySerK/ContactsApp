package org.example;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Component
@Profile("init")
@PropertySource("classpath:application-init.properties")
public class InitContactsLoader implements Loader{

    @Value("${load.path}")
    private String path;

    @Override
    public List<Contact> load() throws IOException {

            return Files.lines(Path.of(path))
                    .map(str -> {
                        String name = str.split(";")[0];
                        String phone = str.split(";")[1];
                        String email = str.split(";")[2];
                        return new Contact(name,phone,email);
                    })
                    .collect(Collectors.toList());
    }
}
