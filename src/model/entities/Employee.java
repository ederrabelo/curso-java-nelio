package model.entities;

public class Employee implements Comparable<Employee>{
    private Integer id;
    private String name;
    private Double salary;

    public Employee() {

    }

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void salaryIncrease(int percentage) {
        salary += salary * percentage / 100;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + salary;
    }

    @Override
    public int compareTo(Employee o) {
//        return name.compareTo(o.getName());
//        return salary.compareTo(o.getSalary());
        return -salary.compareTo(o.getSalary());
    }
}
