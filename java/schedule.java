import java.util.*;

class Schedule {
    private Map<String, Day> days;
    private Map<String, Employee> employees;

    public Schedule() {
        days = new HashMap<>();
        employees = new HashMap<>();

        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day: dayNames) {
            days.put(day, new Day(day));
        }
    }

    public void addEmployee(String name) {
        employees.put(name, new Employee(name));
    }

    public void setEmployeePreference(String name, String day, String shift) {
        if (employees.containsKey(name) && days.containsKey(day)) {
            employees.get(name).setPreferences(day, shift);
        }
    }

    public void assignShifts() {
        Random random = new Random();

        for (String dayName: days.keySet()) {
            Day dayObj = days.get(dayName);
            Set<String> assigned = new HashSet<>();

            for (String shift : dayObj.shifts.keySet()) {
                List<Employee> available = new ArrayList<>();

                for (Employee emp : employees.values()) {
                    if (emp.preferences.getOrDefault(dayName, "").equals(shift) && emp.workdays < 5) {
                        available.add(emp);
                    }
                }
                Collections.shuffle(available);

                while (dayObj.shifts.get(shift).size() < 2){
                    if (!available.isEmpty()) {
                        Employee emp = available.remove(0);
                        dayObj.assignEmployee(shift, emp);
                        emp.workdays++;
                        assigned.add(emp.name);
                    } else {
                        List<Employee> remaining = new ArrayList<>();
                        for (Employee e : employees.values()) {
                            if (e.workdays < 5 && !assigned.contains(e.name)) {
                                remaining.add(e);
                            }
                        }

                        if (!remaining.isEmpty()) {
                            Employee emp = remaining.get(random.nextInt(remaining.size()));
                            dayObj.assignEmployee(shift, emp);
                            emp.workdays++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void displaySchedule() {
        System.out.println("\nFinal Schedule:");
        for (String dayName : days.keySet()) {
            Day dayObj = days.get(dayName);
            System.out.println("\n" + dayName + ":");
            for (String shift : dayObj.getAssignedEmployees().keySet()) {
                System.out.println(" " + shift.substring(0, 1).toUpperCase() + shift.substring(1) + ":");
                System.out.println(String.join(", ", dayObj.getAssignedEmployees().get(shift)));
            }
        }
    }

    public static void main(String[] args) {
        Schedule scheduler = new Schedule();
        scheduler.addEmployee("Alice");
        scheduler.addEmployee("Bob");
        scheduler.addEmployee("Charlie");

        scheduler.setEmployeePreference("Alice", "Monday", "morning");
        scheduler.setEmployeePreference("Alice", "Tuesday", "afternoon");
        scheduler.setEmployeePreference("Bob", "Monday", "evening");
        scheduler.setEmployeePreference("Charlie", "Monday", "morning");
        scheduler.setEmployeePreference("Charlie", "Tuesday", "evening");

        scheduler.assignShifts();
        scheduler.displaySchedule();
    }
}

