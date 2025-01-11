package coding_challenges_java;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CustomClassHashmap {
    public static class Employee {
        int id;
        String name;

        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Employee employee = (Employee) obj;
            return id == employee.id && Objects.equals(name, employee.name);
        }      
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "John");
        Employee emp2 = new Employee(2, "Sam");
        Employee emp3 = new Employee(1, "John");

        Map<Employee, String> employeeMap = new HashMap<>();
        employeeMap.put(emp1, "India");
        employeeMap.put(emp2, "US");
        
        System.out.println(employeeMap.get(emp3));

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(emp1);
        employeeSet.add(emp2);
        employeeSet.add(emp3);
        System.out.println(employeeSet.size());
    }


}
