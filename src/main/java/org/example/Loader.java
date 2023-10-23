package org.example;

import java.io.IOException;
import java.util.List;

public interface Loader {
    List<Contact> load() throws IOException;
}
