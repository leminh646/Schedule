import java.util.*;

class Employee {
    String name;
    Map<String, String> preferences;
    int workdays;

    public Employee(String name) {
        this.name = name;
        this.preferences = new HashMap<>();
        this.workdays = 0;
    }

    public void setPreferences(String day, String shift) {
        preferences.put(day, shift);
    }
}