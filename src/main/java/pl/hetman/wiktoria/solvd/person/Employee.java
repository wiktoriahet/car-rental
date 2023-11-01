package pl.hetman.wiktoria.solvd.person;

import java.util.List;
import java.util.Objects;

public class Employee extends PersonModel {

    private Long id;
    private String name;
    private String surname;
    private String department;
    private List<Customer> customers;

    public Employee(Long id, String name, String surname, String department, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.customers = customers;
        printInformation();
    }

    @Override
    void printInformation() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Employee ID: " + id)
                .append("\n")
                .append("Name and surname: " + name + " " + surname)
                .append("\n")
                .append("Department: " + department)
                .append("\n")
                .append("Customers: " + customers.toString());

        System.out.println(stringBuilder);

    }

    @Override
    public void createAPerson() {
        System.out.println("Create an employee");
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getId().equals(employee.getId()) && getName().equals(employee.getName()) && getSurname().equals(employee.getSurname()) && getDepartment().equals(employee.getDepartment()) && getCustomers().equals(employee.getCustomers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getDepartment(), getCustomers());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", customers=" + customers +
                '}';
    }
}
