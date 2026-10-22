// task 3
package org.yourcompany.yourproject;

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
}

