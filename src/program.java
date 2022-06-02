import DAO.ConnectioDAO;
import Model.entities.ImportedProduct;
import Model.entities.Product;
import Model.entities.UsedProduct;
import Model.exceptions.DomainException;
import View.SystemGUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class program {
    List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        try {
            new ConnectioDAO().getConnection();
        }catch(Exception e){
            System.out.println(e);
        }


    }

    private void showProducts() {
        System.out.println("\nPrice Tag: ");
        for (Product prod : products) {
            System.out.println(prod.priceTag());
        }
    }

    private void insertProduct() {
        int x;
        char type;
        String name;
        double price;
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Enter the number of products: ");
            x = sc.nextInt();
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
                    case 'c' -> products.add(new Product(name, price));
                    case 'u' -> {

                        System.out.print("Manufacture date(dd/MM/yyyy):");
                        date = sdf.parse(sc.next());
                        products.add(new UsedProduct(name, price, date));
                    }
                    case 'i' -> {
                        double customFee;
                        System.out.print("Customs fee: ");
                        customFee = sc.nextDouble();
                        products.add(new ImportedProduct(name, price, customFee));
                    }
                    default -> throw new DomainException("invalid Type");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (DomainException e) {
            System.out.println("\n"+e.getMessage()+"\n");
            insertProduct();
            if(e.getClass().getName()=="UsedProduct"){

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        showProducts();
    }
}



