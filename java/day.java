import java.util.*;

class Day {
    String name;
    Map<String, List<String>> shifts;

    public Day(String name) {
        this.name = name;
        this.shifts = new HashMap<>();
        shifts.put("morning", new ArrayList<>());
        shifts.put("afternoon", new ArrayList<>());
        shifts.put("evening", new ArrayList<>());
    }

    public void assignEmployee(String shift, Employee employee) {
        shifts.get(shift).add(employee.name);
    }

    public Map<String, List<String>> getAssignedEmployees() {
        return shifts;
    }
}