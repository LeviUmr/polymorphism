package DTO;

public class ImportedProduct extends Product{
    public double customsFee;

    public ImportedProduct(String name, double price,double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    private double totalPrice(){
        return price + customsFee;
    }

    @Override
    public String priceTag(){
        return name+" $ "+String.format("%.2f",totalPrice())+" (Customs fee: $ "+customsFee+")";
    }
}
