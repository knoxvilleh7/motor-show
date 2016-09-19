package project.model;

import net.sf.oval.constraint.*;
import project.util.VinCheck;

import java.sql.Date;

public class Car {

   private Integer id;

    @NotNull(message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private String model;

    @DateRange (max = "today", message = "Wrong date")
    @NotNull (message = "Field is empty")
    @NotEmpty (message = "Field is empty")
    private Date productionDate;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    private String manufacturer;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Email (message = "E-mail is not real")
    private String manufacturerEmail;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 0, message = "Negative value")
    private Integer motorShowId;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 0, message = "Negative value")
    private Double price;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Min(value = 0, message = "Negative value")
    private Double engineVolume;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @CheckWith(value = VinCheck.class, message = "Car already exists")
    private String vinCode;

    private MotorShow motorShow;

    public Car(String model, Date productionDate, String manufacturer, String manufacturerEmail, Integer motorShowId,
               Double price, Double engineVolume, String vinCode, MotorShow motorShow) {
        this.model = model;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.manufacturerEmail = manufacturerEmail;
        this.motorShowId = motorShowId;
        this.price = price;
        this.engineVolume = engineVolume;
        this.vinCode = vinCode;
        this.motorShow = motorShow;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getManufacturerEmail() {
        return manufacturerEmail;
    }

    public void setManufacturerEmail(String manufacturerEmail) {
        this.manufacturerEmail = manufacturerEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMotorShowId() {
        return motorShowId;
    }

    public void setMotorShowId(Integer motorShowId) {
        this.motorShowId = motorShowId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public MotorShow getMotorShow() {
        return motorShow;
    }

    public void setMotorShow(MotorShow motorShow) {
        this.motorShow = motorShow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!id.equals(car.id)) return false;
        if (!model.equals(car.model)) return false;
        if (!productionDate.equals(car.productionDate)) return false;
        if (!manufacturer.equals(car.manufacturer)) return false;
        if (!manufacturerEmail.equals(car.manufacturerEmail)) return false;
        if (!motorShowId.equals(car.motorShowId)) return false;
        if (!price.equals(car.price)) return false;
        if (!engineVolume.equals(car.engineVolume)) return false;
        if (!vinCode.equals(car.vinCode)) return false;
        return motorShow.equals(car.motorShow);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + productionDate.hashCode();
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + manufacturerEmail.hashCode();
        result = 31 * result + motorShowId.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + engineVolume.hashCode();
        result = 31 * result + vinCode.hashCode();
        result = 31 * result + motorShow.hashCode();
        return result;
    }
}
