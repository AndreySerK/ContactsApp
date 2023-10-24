package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Component
@Profile("default")
@PropertySource("classpath:application-default.properties")
public class DefaultContactsLoader implements Loader {

    @Value("${load.path}")
    private String path;

    @Override
    public List<Contact> load() throws IOException {
        return new ArrayList<>();
    }
}
