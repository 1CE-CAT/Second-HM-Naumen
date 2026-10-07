// task 3
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Employee {
    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    public Employee(String fullName, int age, String department, double salary){
        setFullName(fullName);
        setAge(age);
        setDepartment(department);
        setSalary(salary);
    }

    public String getFullName(){ return fullName; }
    public Integer getAge(){ return age; }
    public String getDepartment(){ return department; }
    public Double getSalary(){ return salary; }

    public void setFullName(String fullName){
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.fullName = fullName;
    }

    public void setAge(Integer age){
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Возраст может быть от 0 и до 120");
        }
        this.age = age;
    }

    public void setDepartment(String department){
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Имя отдела не может быть пустым");
        }
        this.department = department;
    }

    public void setSalary(double salary){
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть меньше нуля");
        }
        this.salary = salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иванов Иван Иванович",   30, "IT",       80000),
            new Employee("Петрова Анна Сергеевна", 25, "HR",       60000),
            new Employee("Сидоров Пётр Алексеевич",45, "Finance",  120000),
            new Employee("Кузнецова Мария Ивановна",35, "IT",       95000),
            new Employee("Смирнов Алексей Петрович",28, "Marketing", 70000)
        ));

        System.out.println("Enter Department");
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        sc.close();
    
        double avg = employees.stream()
            .collect(Collectors.filtering(
            e -> e.getDepartment().equals(n),
            Collectors.averagingDouble(Employee::getSalary)
        ));
        System.out.println(avg);
    }
}

