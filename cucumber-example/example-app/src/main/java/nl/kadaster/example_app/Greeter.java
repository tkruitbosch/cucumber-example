package nl.kadaster.example_app;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple service that greets its users.
 */
public class Greeter {
    private final Set<String> greeted = new HashSet<String>();

    public String greet(String name) {
        boolean seenOnce = greeted.contains(name);
        if (!seenOnce) {
            greeted.add(name);
            return "Hello, " + name + '!';
        } else {
            return "Hello again, " + name + '!';
        }
    }
}
