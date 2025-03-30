import java.util.*;

class Schedule {
    private Map<String, Day> days;
    private Map<String, Employee> employees;

    public Schedule() {
        days = new LinkedHashMap<>();
        employees = new HashMap<>();

        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : dayNames) {
            days.put(day, new Day(day));
        }
    }

    public void addEmployee(String name) {
        employees.put(name, new Employee(name));
    }

    public void setEmployeePreference(String name, String day, String shift) {
        if (!employees.containsKey(name)) {
            System.out.println("Error: Employee " + name + " does not exist.");
            return;
        }
        if (!days.containsKey(day)) {
            System.out.println("Error: Invalid day " + day);
            return;
        }
        employees.get(name).setPreferences(day, shift);
    }

    public void assignShifts() {
        Random random = new Random();
    
        for (String dayName : days.keySet()) {
            Day dayObj = days.get(dayName);
            Set<String> assignedForDay = new HashSet<>();
    
            for (String shift : dayObj.shifts.keySet()) {
                List<Employee> available = new ArrayList<>();
    
                // Find employees who prefer this shift
                for (Employee emp : employees.values()) {
                    if (emp.preferences.getOrDefault(dayName, "").equals(shift) && emp.workdays < 5 && !assignedForDay.contains(emp.name)) {
                        available.add(emp);
                    }
                }
    
                // Shuffle to randomize selection
                Collections.shuffle(available);
    
                // Assign employees who prefer this shift
                while (dayObj.shifts.get(shift).size() < 2) {
                    if (!available.isEmpty()) {
                        Employee emp = available.remove(0);
                        dayObj.assignEmployee(shift, emp);
                        emp.workdays++;
                        assignedForDay.add(emp.name);
                    } else {
                        // If no preferred employees are available, pick from the remaining pool
                        List<Employee> remaining = new ArrayList<>();
                        for (Employee e : employees.values()) {
                            if (e.workdays < 5 && !assignedForDay.contains(e.name)) {
                                remaining.add(e);
                            }
                        }
    
                        if (!remaining.isEmpty()) {
                            // Prioritize employees with fewer assigned workdays
                            remaining.sort(Comparator.comparingInt(e -> e.workdays));
                            Employee emp = remaining.get(0);
                            dayObj.assignEmployee(shift, emp);
                            emp.workdays++;
                            assignedForDay.add(emp.name);
                        } else {
                            // No more employees available for this shift
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
                List<String> assignedEmployees = dayObj.getAssignedEmployees().get(shift);
                System.out.print(" " + Character.toUpperCase(shift.charAt(0)) + shift.substring(1) + ": ");
    
                if (assignedEmployees.isEmpty()) {
                    System.out.println("No employees scheduled");
                } else {
                    System.out.println(String.join(", ", assignedEmployees));
                }
            }
        }
    }
    

    public void run() {
        assignShifts();
        displaySchedule();
    }
}
