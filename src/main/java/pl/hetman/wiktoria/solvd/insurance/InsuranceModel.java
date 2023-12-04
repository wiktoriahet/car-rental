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
    private InsuranceCatalogue insuranceCatalogue;

    public InsuranceModel() {
    }

    public InsuranceModel(InsuranceCatalogue insuranceCatalogue){
        LOGGER.info("InsuranceModel(" + insuranceCatalogue.getPackageName() + ")");

        switch (insuranceCatalogue) {
            case BASIC:
                this.id = UniqueIdGenerator.generateId();
                this.insurancePackageName =insuranceCatalogue.getPackageName();
                this.theftInsurance = false;
                this.accidentsInsurance =false;
                this.destructionInsurance =false;
                break;

            case EXTRA:
                this.id = UniqueIdGenerator.generateId();
                this.insurancePackageName =insuranceCatalogue.getPackageName();
                this.theftInsurance = false;
                this.accidentsInsurance =true;
                this.destructionInsurance =false;
                break;

            case DELUXE:
                this.id = UniqueIdGenerator.generateId();
                this.insurancePackageName =insuranceCatalogue.getPackageName();
                this.theftInsurance = true;
                this.accidentsInsurance =true;
                this.destructionInsurance =true;
                break;
        }

        LOGGER.info("InsuranceModel(...)");
    }

    @Override
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

    public InsuranceCatalogue getInsuranceCatalogue() {
        return insuranceCatalogue;
    }

    public void setInsuranceCatalogue(InsuranceCatalogue insuranceCatalogue) {
        this.insuranceCatalogue = insuranceCatalogue;
    }

    @Override
    public String toString() {
        return "InsuranceModel{" +
                "id=" + id +
                ", insurancePackageName='" + insurancePackageName + '\'' +
                ", theftInsurance=" + theftInsurance +
                ", accidentsInsurance=" + accidentsInsurance +
                ", destructionInsurance=" + destructionInsurance +
                ", insuranceCatalogue=" + insuranceCatalogue +
                '}';
    }

}
