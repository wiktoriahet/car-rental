package pl.hetman.wiktoria.solvd;

import java.util.Objects;

public class InsuranceModel implements Insurance{

    private Long id;
    private String packageName;
    boolean theftInsurance;
    boolean accidentsInsurance;
    boolean destructionInsurance;
    private double price;

    @Override
    public String chooseInsurance(String packageName) {
        setPackageName(packageName);
        return packageName;
    }

    public InsuranceModel(Long id, String packageName, boolean theftInsurance, boolean accidentsInsurance, boolean destructionInsurance, double price) {
        this.id = id;
        this.packageName = packageName;
        this.theftInsurance = theftInsurance;
        this.accidentsInsurance = accidentsInsurance;
        this.destructionInsurance = destructionInsurance;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsuranceModel that)) return false;
        return isTheftInsurance() == that.isTheftInsurance() && isAccidentsInsurance() == that.isAccidentsInsurance() && isDestructionInsurance() == that.isDestructionInsurance() && Double.compare(that.getPrice(), getPrice()) == 0 && getId().equals(that.getId()) && getPackageName().equals(that.getPackageName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPackageName(), isTheftInsurance(), isAccidentsInsurance(), isDestructionInsurance(), getPrice());
    }

    @Override
    public String toString() {
        return "InsuranceModel{" +
                "id=" + id +
                ", packageName='" + packageName + '\'' +
                ", theftInsurance=" + theftInsurance +
                ", accidentsInsurance=" + accidentsInsurance +
                ", destructionInsurance=" + destructionInsurance +
                ", price=" + price +
                '}';
    }
}
