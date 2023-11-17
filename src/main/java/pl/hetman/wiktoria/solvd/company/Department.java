package pl.hetman.wiktoria.solvd.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Department {
    private static final Logger LOGGER = LogManager.getLogger(Department.class);

    private Long id;
    private String departmentName;

    public Department(String departmentName) {
        LOGGER.info("Department()");
        this.departmentName = departmentName;
        LOGGER.info("Department(...)");
    }

    public Department(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
