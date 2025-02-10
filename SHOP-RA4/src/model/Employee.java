/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import main.Logable;

/**
 *
 * @author Usuario 1
 */
/*5 NEW CLASS EMPLOYEE 
5.A Create a class employee in the package model
5.B  Extends the class Person
5.C Define the attributs employeeId and password 
5.D define the final constants EMPLOYEE_ID = 123, PASSWORD= test
5.E Implement the interface Logable
5.F Implement the method login, if user (employee number) and password are fixed
values (123,test) return true or false*/
public class Employee extends Person implements Logable {

    private int employeeId;
    private String password;

    public Employee(String name, int employeeId, String password) {
        super(name);
        this.employeeId = employeeId;
        this.password = password;
    }

    @Override
    public boolean login(int user, String password) {
        if (this.employeeId == user && this.password.equalsIgnoreCase(password)) {
            return true;
        } else {
            return false;
        }
    }

}
