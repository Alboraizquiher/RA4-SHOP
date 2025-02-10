package model;

import java.util.ArrayList;
import java.util.List;

/*9. MODIFY THE CLASS SALE WITH CLIENT
9.A Modify the attribute Client type class String to Client
9.B Realice the neccesay adaptation*/

public class Sale {
    private Client client;
    private List<Product> products;
    private double amount;

    public Sale(Client client, List<Product> products, double amount) {
        this.client = client;
        this.products = products;
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sale [client=" + client.getName() + ", products=" + products + ", amount=" + amount + "]";
    }
}