import DTO.ImportedProduct;
import DTO.Product;
import DTO.UsedProduct;

import java.util.Scanner;

public class program {

    static Object vet[] = new Object[10];

    public static void main(String[] args) {
        insertProduct();



    }

    public static void insertProduct(){
        int x;
        char type;
        String name;
        double price;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the number of products: ");
            x = sc.nextInt();
        }while(x<=0);

        for(int i = 0 ; i<x ; i++){

            System.out.println("\nProduct #"+Product.id+" data:");

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

            switch (type){
                case 'c':
                    vet[Product.id] = new Product(name,price);
                    break;

                case 'u':
                    int day,month,year;

                    System.out.println("Manufacture date:");
                    System.out.print("Day: ");
                    day = sc.nextInt();

                    System.out.print("Month: ");
                    month = sc.nextInt();

                    System.out.print("Year: ");
                    year = sc.nextInt();

                    vet[Product.id] = new UsedProduct(name,price,day,month,year);
                    break;

                case 'i':
                    double customFee;
                    System.out.print("Customs fee: ");
                    customFee = sc.nextDouble();
                    vet[Product.id] = new ImportedProduct(name,price,customFee);
                    break;
            }


        }
    }
    public void showProducts() throws NoSuchMethodException {
        for (int i=0;i<vet.length;i++) {
            System.out.println(vet[i].getClass().getMethod("priceTag",null));
        }
    }

}
