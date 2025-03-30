class Main {
    public static void main(String[] args) {
        // Create a new schedule
        Schedule scheduler = new Schedule();

        // Add employees
        scheduler.addEmployee("Alice");
        scheduler.addEmployee("Bob");
        scheduler.addEmployee("Charlie");

        // Set employee preferences for shifts
        scheduler.setEmployeePreference("Alice", "Monday", "morning");
        scheduler.setEmployeePreference("Alice", "Tuesday", "afternoon");
        scheduler.setEmployeePreference("Bob", "Monday", "evening");
        scheduler.setEmployeePreference("Charlie", "Monday", "morning");
        scheduler.setEmployeePreference("Charlie", "Tuesday", "evening");

        // Run the scheduling and display the schedule
        scheduler.run();
    }
}
