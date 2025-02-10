package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import model.Product;
import model.Sale;
import java.util.Scanner;
import model.Client;
import model.Employee;

public class Shop {

    private double cash = 100.00;
    /*1 MODIFY THE ACTUAL DECLARATION WITH THE ATRIBUTS [] TO ARRAYLIST
    AND FIT HIS CREATION,READING,ACTUALIZATION AND REMOVE
    1.A Shop.inventory, list the prodcuts of the Shop
    1.B Shop.sales, done sales 
    1.C Sale.products, list the products of each sale*/

 /*private Product[] inventory;*/
    private ArrayList<Product> inventory;
    /* 
    
      Modify the actual declaration of the atributs [] to a arrayList and adaptate his creation,reading,actualization ad delete if this aply
     */
    private int numberProducts;

    /*EXERCISE 1.B*/
    private ArrayList<Sale> sales;

    /*private Sale[] sales;*/
    final static double TAX_RATE = 1.04;

    public Shop() {

        inventory = new ArrayList<>();

        sales = new ArrayList<>();
        //inventory = new Product[10];
    }

    public static void main(String[] args) {
        Shop shop = new Shop();

        /*IN THERE IMPLEMENTS THE CODE INITSESSION*/
        shop.loadInventory();
        shop.initSession();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean exit = false;

        do {
            System.out.println(" SHOP MENU ");
            System.out.println("===========================");
            System.out.println("1) COUNT MONEY BOX");
            System.out.println("2) ADD PRODUCT");
            System.out.println("3) ADD STOCK");
            System.out.println("4) MARK PRODUCT NEARLY EXPIRY ");
            System.out.println("5) VIEW INVENTORY");
            System.out.println("6) SALE");
            System.out.println("7) SEE SALES");
            System.out.println("8) DELETE PRODUCT");
            System.out.println("10) EXIT");
            System.out.println("SELECT ONE OPTION: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    shop.showCash();
                    break;

                case 2:
                    shop.addProduct();
                    break;

                case 3:
                    shop.addStock();
                    break;

                case 4:
                    shop.setExpired();
                    break;

                case 5:
                    shop.showInventory();
                    break;

                case 6:
                    shop.sale();
                    break;

                case 7:
                    shop.showSales();
                    break;
                /*2 MODIFY THE CLASS SHOP TO REMOVE THE PRODUCT
                    2.A Add a new option in the menu 
                    2.B Add a new method to eliminate a product in the inventory
                    The option to eliminate products*/
                case 8:
                    shop.deleteProduct();
                    break;

                case 10:
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    /*6. MODIFY THE CLASS Shop with Employee
    6.A Modify the method main for include a new method initSession() before the
    menu
    6.B Implements the method initSession() asking a employee numbber and a password
    6.C Create the object type employee and invoque the method login() to validate his dates
    6.D If the login is false, asking for new dates, if is true continue, with his 
    respective messages to the user*/
    public void initSession() {

        Scanner scanner = new Scanner(System.in);

        boolean login = false;
        Employee employee;
        do {

            System.out.println("Introduce the employee number :");
            int id = scanner.nextInt();
            System.out.println("Introduce the password");
            String passw = scanner.next();
            employee = new Employee("test", 123, "test");
            if (employee.login(id, passw)) {
                login = true;
            } else {
                System.out.println("ACCES DENIED ");
            }

        } while (login == false);

    }

    /**
     * load initial inventory to shop
     */
    public void loadInventory() {

        inventory.add(new Product("Apple", 10.00, true, 10));
        inventory.add(new Product("Pear", 20.00, true, 20));
        inventory.add(new Product("Hamburguer", 30.00, true, 30));
        inventory.add(new Product("Strawberry", 5.00, true, 20));

    }

    private void showCash() {

        for (Sale sale : sales) {

            System.out.println(sale.getAmount());

        }

    }

   public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        String name;

        while (true) {
            System.out.println("Introduce the product, write 0 to finish:");
            System.out.print("Name: ");
            name = scanner.nextLine();

            if (name.equals("0")) {
                break;  
            }

            System.out.print("Wholesale price: ");
            while (!scanner.hasNextDouble()) { 
                System.out.println("Please enter a valid price:");
                scanner.next(); 
            }
            double wholesalerPrice = scanner.nextDouble();

            System.out.print("Stock: ");
            while (!scanner.hasNextInt()) { 
                System.out.println("Please enter a valid stock number:");
                scanner.next();
            }
            int stock = scanner.nextInt();
            scanner.nextLine(); 

            inventory.add(new Product(name, wholesalerPrice, true, stock));

            System.out.println("Product added!");
        }
 
    }
            
       

        
        
    

    /**
     * add stock for a specific product
     */
    public void addStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a product name: ");
        String name = scanner.next();
        Product product = findProduct(name);

        if (product != null) {
            // ask for stock
            System.out.print("Select the quantity to add ");
            int stock = scanner.nextInt();
            // update stock product
            product.setStock(stock);
            System.out.println("The productstock  " + name + " has been updated  " +  product.getStock());

        } else {
            System.out.println("the product with the name: " + name + " has not been found");
        }
    }

    /**
     * set a product as expired
     */
    private void setExpired() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a product name: ");
        String name = scanner.next();

        Product product = findProduct(name);

        if (product != null) {
            System.out.println("The product stock " + name + " has been updated " + product.getexpire());

        }
    }

    /**
     * show all inventory
     */
    public void showInventory() {
        System.out.println("Content of the shop:");
        for (Product product : inventory) {
            if (product != null) {
                System.out.println(product.getName());
            }
        }
    }

    /**
     * make a sale of products to a client
     */
    /*10 MODIFY THE CLASS SHOP WITH CLIENT
    10.A Modify the method Sale() to create the object type Client
    and invoke the method pay() with the total of the buying
    10.B if pay() is true continue, if is false continue and
    show the message with the type of amount that the client need to pay*/
    public void sale() {
        Scanner sc = new Scanner(System.in);
        System.out.println("make the sale , enter the customer's name");
        String clientName = sc.nextLine();
        
        Client client = new Client(clientName, 1, 50.00);
        System.out.println("You have this money: "+client.getBalance());
        double totalAmount = 0.0;
        String name = "";
        List<Product> productsSold = new ArrayList<>();

        while (!name.equals("0")) {
            System.out.println("Introduce the product name, write 0 to finish:");
            name = sc.nextLine();
            

            if (name.equals("0")) {
                break;
            }

            Product product = findProduct(name);
            if (product != null && product.isAvailable()) {
                totalAmount += product.getWholesalerPrice();
                product.setStock(product.getStock() - 1);
                productsSold.add(product);

                if (product.getStock() == 0) {
                    product.setAvailable(false);
                }
                System.out.println("Product added");
            } else {
                System.out.println("Product not found ");
            }
        }

        // show cost total
        totalAmount = totalAmount * TAX_RATE;
        if (client.pay(totalAmount)) {
            cash += totalAmount;
            System.out.println("Product added , total: " + totalAmount);
            System.out.println("Now you have this money : " + (client.getBalance() - totalAmount));
        } else {
            System.out.println(" The client doesn`t have the neccesary amount of money. Needs to pay: " + (totalAmount - client.getBalance()));
        }

        sales.add(new Sale(client, productsSold, totalAmount));
    }

    /**
     * show all sales
     */
    private void showSales() {
        System.out.println("Sale list:");
        for (Sale sale : sales) {
            if (sale != null) {
                System.out.println(sale.getClient().getname() +","+ sale.getAmount());
            }
        }
    }

    /**
     * add a product to inventory
     *
     * @param product
     */
    public void addProduct(Product product) {

        inventory.set(numberProducts, product);
        numberProducts++;
    }

    /**
     * find product by name
     *
     * @param name
     * @return product found by name
     */
    public Product findProduct(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i) != null && inventory.get(i).getName().equalsIgnoreCase(name)) {
                return inventory.get(i);
            }
        }
        return null;
    }

    /*
    2.B
    This is the method to eliminate the product*/
    public void deleteProduct() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce the name of the product that you want to delete");
        String name = scanner.nextLine();

        Product product = findProduct(name);
        if (product != null) {
            inventory.remove(product);
            System.out.println("The product now are eliminated");

        } else {

            System.out.println("This product doesn't exist");
        }

    }

}
