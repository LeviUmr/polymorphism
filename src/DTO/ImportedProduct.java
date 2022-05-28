package DTO;

public class ImportedProduct extends Product {
    private double customsFee;

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);

        if (name.isEmpty()) {
            throw new RuntimeException("Invalid name! ");
        } else if (price <= 0) {
            throw new RuntimeException("The price must be greater than zero! ");
        }else if(customsFee<0){
            throw new RuntimeException("Customs fee cannot be less than zero! ");
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
