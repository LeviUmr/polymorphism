import DTO.ImportedProduct;
import DTO.Product;
import DTO.UsedProduct;
import View.SystemGUI;

import java.util.*;

public class program {
    List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
       new SystemGUI();

    }

    protected void insertProduct() {
        int x;
        char type;
        String name;
        double price;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the number of products( 1-20 ): ");
            x = sc.nextInt();
        } while (x <= 0 || x > 20);

        for (int i = 1; i <= x; i++) {

            System.out.println("\nProduct #" + i + " data:");

            System.out.print("Common,used or imported (c/u/i)? ");
            sc.nextLine();
            type = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            name = sc.nextLine();

            System.out.print("Price: ");
            price = sc.nextInt();
            switch (type) {

                case 'c' -> {
                    try {
                        products.add(new Product(name, price));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                case 'u' -> {
                    int day, month, year;
                    System.out.println("Manufacture date:");
                    System.out.print("Day: ");
                    day = sc.nextInt();
                    System.out.print("Month: ");
                    month = sc.nextInt();
                    System.out.print("Year: ");
                    year = sc.nextInt();

                    try {
                        products.add(new UsedProduct(name, price, day, month, year));
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }

                case 'i' -> {
                    double customFee;
                    System.out.print("Customs fee: ");
                    customFee = sc.nextDouble();
                    try {
                        products.add(new ImportedProduct(name, price, customFee));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

            }
        }
    }

    protected void showProducts() {
        System.out.println("\nPrice Tag: ");
        for (Product prod : products) {
            System.out.println(prod.priceTag());
        }
    }
}



