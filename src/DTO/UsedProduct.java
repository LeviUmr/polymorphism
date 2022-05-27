package DTO;


public class UsedProduct extends Product {
    public int day, month, year;

    public UsedProduct(String name, double price, int day, int month, int year) {
        super(name, price);
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public String date() {
        return day + "/" + month + "/" + year;
    }

    @Override
    public String priceTag() {
        return name
                + "(used) $ "
                + String.format("%.2f", price)
                + " (Manufacture date: "
                + date() + ")";
    }
}
