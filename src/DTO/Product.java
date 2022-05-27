package DTO;

public class Product {
    public String name;
    public double price;
    public static int id = 1;

    public Product(String name,double price){

        this.name = name;
        this.price = price;
        id++;
    }

    public String priceTag(){
        return name + " $ " + String.format("%.2f",price);
    }

}
