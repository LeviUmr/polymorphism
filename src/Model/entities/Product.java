package Model.entities;

import Model.exceptions.DomainException;

public class Product {
    private String name;
    private double price;
    private int id;

    public Product(String name, double price) throws DomainException{

        if (name.isEmpty()) {
            throw new DomainException("Invalid name");

        }
        if (price <= 0) {
            throw new DomainException("The price must be greater than zero");
        }

        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String priceTag() {
        return getName()
                + " $ "
                + String.format("%.2f", getPrice());
    }

}
