package DTO;


public class UsedProduct extends Product {

    private int day, month, year;

    public UsedProduct(String name, double price, int day, int month, int year) {
        super(name, price);

        if (name.isEmpty()) {
            throw new RuntimeException("Invalid name");
        } else if (price <= 0) {
            throw new RuntimeException("The price must be greater than zero");
        } else if (day <= 0 || day > 31) {
            throw new RuntimeException("Invalid day ");
        } else if (month <= 0 || month > 12) {
            throw new RuntimeException("Invalid Month ");
        } else if (year < 1900 || year > 2022) {
            throw new RuntimeException("Invalid Year ");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String date() {
        return day + "/" + month + "/" + year;
    }

    @Override
    public String priceTag() {
        return getName()
                + " (used) $ "
                + String.format("%.2f", getPrice())
                + " (Manufacture date: "
                + date() + ")";
    }
}
