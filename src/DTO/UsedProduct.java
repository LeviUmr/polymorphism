package DTO;

import javax.xml.crypto.Data;
import java.util.Date;

public class UsedProduct extends Product{
    public int day,month,year;

    public UsedProduct(String name, double price, int day,int month, int year) {
        super(name, price);
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public String date(){
        return day + "/" + month + "/" + year;
    }
    @Override
    public String priceTag(){
        return name+"(used) $ "+price+" (Manufacture date: "+date()+")";
    }
}
