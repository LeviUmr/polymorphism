import DTO.ImportedProduct;
import DTO.Product;
import DTO.UsedProduct;

import java.lang.reflect.Method;
import java.util.*;

public class program {

    List<Product> products = new ArrayList<>();


    public static void main(String[] args) {
        program pg = new program();
        pg.insertProduct();
        pg.showProducts();


    }

    protected void insertProduct() {


        int x;
        char type;
        String name;
        double price;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the number of products: ");
            x = sc.nextInt();
        } while (x <= 0);

        for (int i = 0; i < x; i++) {

            System.out.println("\nProduct #" + Product.id + " data:");

            // c/u/i
            System.out.print("Common,used or imported (c/u/i)? ");
            sc.nextLine();

            type = sc.nextLine().charAt(0);


            //name
            System.out.print("Name: ");
            name = sc.nextLine();


            //price
            System.out.print("Price: ");
            price = sc.nextInt();

            switch (type) {

                case 'c' -> products.add(new Product(name, price));
                case 'u' -> {
                    int day, month, year;
                    System.out.println("Manufacture date:");
                    System.out.print("Day: ");
                    day = sc.nextInt();
                    System.out.print("Month: ");
                    month = sc.nextInt();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    products.add(new UsedProduct(name, price, day, month, year));
                }
                case 'i' -> {
                    double customFee;
                    System.out.print("Customs fee: ");
                    customFee = sc.nextDouble();
                    products.add(new ImportedProduct(name, price, customFee));
                }
            }

        }

    }

    protected void showProducts() {

        for(Product prod: products){
            System.out.println(prod.priceTag());
        }
    }
}



