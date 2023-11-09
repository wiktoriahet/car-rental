package pl.hetman.wiktoria.solvd.company;

import pl.hetman.wiktoria.solvd.person.Employee;

import java.util.List;

public class Department {

    private Long id;
    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(Long id, String departmentName, List<Employee> employees) {
        this.id = id;
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
