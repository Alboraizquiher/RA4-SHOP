/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import main.Payable;

/**
 *
 * @author Usuario 1
 */
/*8 NEW CLASS CLIENT
8.A Create the class Client in the package model
8.B Extenss the class Person
8.C Define the attribute memberId(int) and the balance(Amount)like the 
inicial amount of money.
8.D Define the final constants MEMBER_ID = 456, BALANCE= 50.00$
8.E Implements interface Payable
8.F Implements the pay method,get the inicial amount of money of the sale,
substact the inicial amount of money, if inicial amount of money return true
if not return false
*/


public class Client extends Person implements Payable {
    private int memberId;
    private double balance;

    public Client(String name, int memberId, double balance) {
        super(name);
        this.memberId = memberId;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    
    public String getname(){
    
    return name;
    
    }

    public double getBalance() {
        return balance;
    }
}
