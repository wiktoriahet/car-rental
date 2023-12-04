package pl.hetman.wiktoria.solvd.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Generics and collections task
public class CarList {
    private static final Logger LOGGER = LogManager.getLogger(CarList.class);


    private Long id;
    private List<CarModel> cars;

    public CarList() {
        LOGGER.info("CarList()");
        cars = new ArrayList<>();
        LOGGER.info("CarList(...)");
    }

    public CarList(List<CarModel> cars) {
        LOGGER.info("CarList(" + cars + ")");
        this.cars = cars;
        LOGGER.info("CarList(...)");
    }

    public CarList(Long id, List<CarModel> cars) {
        this.id = id;
        this.cars = cars;
    }

    public void printCarList() {
        LOGGER.info("printCarList(" + cars + ")");
        System.out.println(cars);
        LOGGER.info("printCarList(...)");
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CarModel> getCars() {
        return cars;
    }

    public void setCars(List<CarModel> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarList carList)) return false;
        return getId().equals(carList.getId()) && getCars().equals(carList.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCars());
    }

    @Override
    public String toString() {
        return "CarList{" +
                "id=" + id +
                ", cars=" + cars +
                '}';
    }
}
