package pl.hetman.wiktoria.solvd.insurance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.hetman.wiktoria.solvd.idgenerator.UniqueIdGenerator;

public class InsuranceModel implements IInsurance {
    private static final Logger LOGGER = LogManager.getLogger(InsuranceModel.class);

    private Long id;
    private String insurancePackageName;
    private boolean theftInsurance;
    private boolean accidentsInsurance;
    private boolean destructionInsurance;

    public InsuranceModel() {
    }

    public InsuranceModel(Long id, String insurancePackageName, boolean theftInsurance, boolean accidentsInsurance, boolean destructionInsurance) {
        this.id = id;
        this.insurancePackageName = insurancePackageName;
        this.theftInsurance = theftInsurance;
        this.accidentsInsurance = accidentsInsurance;
        this.destructionInsurance = destructionInsurance;
    }

    @Override
    public String chooseInsurance(InsuranceCatalogue insuranceCatalogue) {
        LOGGER.info("chooseInsurance(" + insuranceCatalogue.getPackageName() + ")");

        switch (insuranceCatalogue) {
            case BASIC:
                setId(UniqueIdGenerator.generateId());
                setInsurancePackageName(insuranceCatalogue.getPackageName());
                setTheftInsurance(false);
                setAccidentsInsurance(false);
                setDestructionInsurance(false);
                break;

            case EXTRA:
                setId(UniqueIdGenerator.generateId());
                setInsurancePackageName(insuranceCatalogue.getPackageName());
                setTheftInsurance(false);
                setAccidentsInsurance(true);
                setDestructionInsurance(false);
                break;
            case DELUXE:
                setId(UniqueIdGenerator.generateId());
                setInsurancePackageName(insuranceCatalogue.getPackageName());
                setTheftInsurance(true);
                setAccidentsInsurance(true);
                setDestructionInsurance(true);
                break;
        }

        LOGGER.info("chooseInsurance(...)");
        return insuranceCatalogue.getPackageName();
    }

    public StringBuilder printInsuranceInformation(InsuranceCatalogue insuranceCatalogue) {
        LOGGER.info("printInsuranceInformation(" + insuranceCatalogue.getPackageName() + ")");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Package name: ")
                .append(insuranceCatalogue.getPackageName())
                .append("\n")
                .append("Theft Insurance: ")
                .append(isTheftInsurance())
                .append("\n")
                .append("Accidents Insurance: ")
                .append(isAccidentsInsurance())
                .append("\n")
                .append("Destruction Insurance: ")
                .append(isDestructionInsurance())
                .append("\n");

        LOGGER.info("printInsuranceInformation(...)");
        return stringBuilder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInsurancePackageName() {
        return insurancePackageName;
    }

    public void setInsurancePackageName(String insurancePackageName) {
        this.insurancePackageName = insurancePackageName;
    }

    public boolean isTheftInsurance() {
        return theftInsurance;
    }

    public void setTheftInsurance(boolean theftInsurance) {
        this.theftInsurance = theftInsurance;
    }

    public boolean isAccidentsInsurance() {
        return accidentsInsurance;
    }

    public void setAccidentsInsurance(boolean accidentsInsurance) {
        this.accidentsInsurance = accidentsInsurance;
    }

    public boolean isDestructionInsurance() {
        return destructionInsurance;
    }

    public void setDestructionInsurance(boolean destructionInsurance) {
        this.destructionInsurance = destructionInsurance;
    }

    @Override
    public String toString() {
        return "InsuranceModel{" +
                "id=" + id +
                ", insurancePackageName='" + insurancePackageName + '\'' +
                ", theftInsurance=" + theftInsurance +
                ", accidentsInsurance=" + accidentsInsurance +
                ", destructionInsurance=" + destructionInsurance +
                '}';
    }

}
