package model.to;

public class ModelTO extends EntityTO {
    private String name;
    private int productionStart;
    private int productionStop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductionStart() {
        return productionStart;
    }

    public void setProductionStart(int productionStart) {
        this.productionStart = productionStart;
    }

    public int getProductionStop() {
        return productionStop;
    }

    public void setProductionStop(int productionStop) {
        this.productionStop = productionStop;
    }
}
