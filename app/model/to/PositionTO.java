package model.to;

public class PositionTO extends EntityTO {
    private BrandTO brand;
    private ModelTO model;
    private int yearOfIssue;
    private int mileage;
    private int price;

    public BrandTO getBrand() {
        return brand;
    }

    public void setBrand(BrandTO brand) {
        this.brand = brand;
    }

    public ModelTO getModel() {
        return model;
    }

    public void setModel(ModelTO model) {
        this.model = model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
