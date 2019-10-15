package model.to;

import model.Brand;

public class BrandTO {
    private String link;
    private Long id;
    private String name;
    private String country;

    public BrandTO(){}

    public BrandTO(Brand brand) {

        this.id = brand.getId();
        this.name = brand.getName();
        this.country = brand.getCountry();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Brand toBrand() {
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(name);
        brand.setCountry(country);
        return brand;
    }
}
