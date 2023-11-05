package pl.hetman.wiktoria.solvd.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.logs.FileLogger;

import java.util.List;
import java.util.Objects;

public class Employee extends PersonModel {
    private static final Logger LOGGER = LogManager.getLogger(Employee.class);

    private Long id;
    private String name;
    private String surname;
    private String department;
    private List<Customer> customers;

    public Employee(Long id, String name, String surname, String department, List<Customer> customers)throws PersonException {
        LOGGER.always().log("Employee("+id+", "+name+", "+surname+", "+department+", "+customers+")");
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.customers = customers;
        printInformation();
        LOGGER.always().log("Employee(...)");
    }

    @Override
    void printInformation() throws PersonException {
        LOGGER.always().log("printInformation()");
        if(id==null){
            PersonException personException = new PersonException("Employee doesn't exist");
            FileLogger.logToFile(personException.getMessage());
            LOGGER.error(personException.getMessage());
            throw personException;
        }
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
        LOGGER.always().log("printInformation(...)");

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
