package pl.hetman.wiktoria.solvd.company;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.carrental.rent.CarRentalModel;
import pl.hetman.wiktoria.solvd.exceptions.DepartmentException;
import pl.hetman.wiktoria.solvd.exceptions.PersonException;
import pl.hetman.wiktoria.solvd.logs.FileLogger;
import pl.hetman.wiktoria.solvd.person.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
//third task review
//Generics and collections task
public class CompanyStructure {
    private static final Logger LOGGER = LogManager.getLogger(CarRentalModel.class);

    private Map<Long, String> companyStructure;

    public CompanyStructure() {
        LOGGER.info("CompanyStructure()");
        this.companyStructure = new HashMap<>();
        LOGGER.info("CompanyStructure(...)");
    }

    public CompanyStructure(Map<Long, String> companyStructure) {
        LOGGER.info("CompanyStructure(" + companyStructure + ")");
        this.companyStructure = companyStructure;
        LOGGER.info("CompanyStructure(...)");
    }

    public void addToCompanyStructure(Employee employee, Department department) throws PersonException, DepartmentException {
        LOGGER.info("addToCompanyStructure()");
        if (employee == null) {
            PersonException personException = new PersonException("Employee doesn't exist");
            FileLogger.logToFile(personException.getMessage());
            LOGGER.error(personException.getMessage());
            throw personException;
        } else if (department == null) {
            DepartmentException departmentException = new DepartmentException("Department doesn't exist");
            FileLogger.logToFile(departmentException.getMessage());
            LOGGER.error(departmentException.getMessage());
            throw departmentException;
        }
        companyStructure.put(employee.getId(), department.getDepartmentName());
        LOGGER.info("addToCompanyStructure(...)");
    }

    public void printCompanyStructure() {
        LOGGER.info("printCompanyStructure()");
        System.out.println(companyStructure);
        LOGGER.info("printCompanyStructure(...)");
    }


    public Map<Long, String> getCompanyStructure() {
        return companyStructure;
    }

    public void setCompanyStructure(Map<Long, String> companyStructure) {
        this.companyStructure = companyStructure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyStructure that)) return false;
        return Objects.equals(getCompanyStructure(), that.getCompanyStructure());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompanyStructure());
    }

    @Override
    public String toString() {
        return "CompanyStructure{" +
                "companyStructure=" + companyStructure +
                '}';
    }
}
