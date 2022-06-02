package Model.entities;


import Model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

    private Date date;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct(String name, double price, Date date) throws DomainException {
        super(name, price);
        Date now = new Date();
        if(date.before(now)){
            throw new DomainException("Manufacture date must be before today");
        }
        this.date = date;



    }

    @Override
    public String priceTag() {
        return getName()
                + " (used) $ "
                + String.format("%.2f", getPrice())
                + " (Manufacture date: "
                + sdf.format(date) + ")";
    }
}
