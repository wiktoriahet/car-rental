package pl.hetman.wiktoria.solvd.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.logs.FileLogger;

import java.util.List;
import java.util.Objects;

//Generics and collections task
public class Employee extends PersonModel {
    private static final Logger LOGGER = LogManager.getLogger(Employee.class);

    private Long id;
    private String name;
    private String surname;
    private List<Customer> customers;

    public Employee(Long id, String name, String surname, List<Customer> customers)throws PersonException {
        LOGGER.info("Employee("+id+", "+name+", "+surname+", "+customers+")");
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.customers = customers;
        printInformation();
        LOGGER.info("Employee(...)");
    }

    public Employee(List<Customer> customers) {
        LOGGER.info("Employee("+customers+")");
        this.customers = customers;
        LOGGER.info("Employee(...)");
    }

    @Override
    void printInformation() throws PersonException {
        LOGGER.info("printInformation()");
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
                .append("\n")
                .append("Customers: " + customers.toString());

        System.out.println(stringBuilder);
        LOGGER.info("printInformation(...)");

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
        return getId().equals(employee.getId()) && getName().equals(employee.getName()) && getSurname().equals(employee.getSurname()) && getCustomers().equals(employee.getCustomers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getCustomers());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", customers=" + customers +
                '}';
    }
}
