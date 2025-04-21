package swissreass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class CompanyAnalysis {

    public static void main(String[] args) throws Exception {
        String filePath = "src/main/resources/employees.csv"; // Path to the input CSV file
        List<Employee> employees = readCSVEmployeeData(filePath);

        Map<Integer, List<Employee>> managerToSubordinates = empHierarchy(employees);
        Map<Integer, Integer> depthCache = calculateDepths(employees, managerToSubordinates);

        salaries(employees, managerToSubordinates);
        reportingLines(employees, depthCache);
    }

    private static List<Employee> readCSVEmployeeData(String filePath) throws Exception {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                Integer managerId = (fields.length > 4 && !fields[4].isEmpty()) ? Integer.parseInt(fields[4]) : null;

                employees.add(new Employee(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        Double.parseDouble(fields[3]),
                        managerId
                ));
            }
        }
        return employees;
    }


    private static Map<Integer, List<Employee>> empHierarchy(List<Employee> employees) {
        return employees.stream()
                .filter(emp -> emp.getManagerId() != null)
                .collect(Collectors.groupingBy(Employee::getManagerId));
    }

    // calculates depths for each employee and caches the results
    private static Map<Integer, Integer> calculateDepths(List<Employee> employees, Map<Integer, List<Employee>> hierarchy) {
        Map<Integer, Integer> depthCache = new HashMap<>();
        for (Employee employee : employees) {
            calculateDepth(employee.getId(), hierarchy, depthCache);
        }
        return depthCache;
    }

    private static int calculateDepth(int id, Map<Integer, List<Employee>> hierarchy, Map<Integer, Integer> cache) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        }
        Optional<Integer> managerId = hierarchy.keySet().stream()
                .filter(mgrId -> hierarchy.get(mgrId).stream().anyMatch(e -> e.getId() == id))
                .findFirst();
        int depth = managerId.map(mgrId -> 1 + calculateDepth(mgrId, hierarchy, cache)).orElse(0);
        cache.put(id, depth);
        return depth;
    }


    private static void salaries(List<Employee> employees, Map<Integer, List<Employee>> hierarchy) {
        for (Employee manager : employees) {
            if (!hierarchy.containsKey(manager.getId())) {
                continue;
            }
            List<Employee> subordinates = hierarchy.get(manager.getId());
            double avgSalary = subordinates.stream().mapToDouble(Employee::getSalary).average().orElse(0);
            double lowerLimit = avgSalary * 1.2;
            double upperLimit = avgSalary * 1.5;

            if (manager.getSalary() < lowerLimit) {
                System.out.printf("Manager %s earns less by %.2f%n", manager.getFullName(), lowerLimit - manager.getSalary());
            } else if (manager.getSalary() > upperLimit) {
                System.out.printf("Manager %s earns more by %.2f%n", manager.getFullName(), manager.getSalary() - upperLimit);
            }
        }
    }


    private static void reportingLines(List<Employee> employees, Map<Integer, Integer> depthCache) {
        for (Employee employee : employees) {
            int depth = depthCache.getOrDefault(employee.getId(), 0);
            if (depth > 4) {
                System.out.printf("Employee %s has a reporting line too long by %d levels%n", employee.getFullName(), depth - 4);
            }
        }
    }

}
