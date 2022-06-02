package Model.entities;

import Model.exceptions.DomainException;

public class ImportedProduct extends Product {
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee) throws DomainException {
        super(name, price);
        if(customsFee<0){
            throw new DomainException("Customs fee cannot be less than zero! ");
        }

        this.customsFee = customsFee;

    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    private double totalPrice() {
        return getPrice() + getCustomsFee();
    }

    @Override
    public String priceTag() {
        return getName()
                + " $ "
                + String.format("%.2f", totalPrice())
                + " (Customs fee: $ "
                + getCustomsFee()
                + ")";
    }
}
