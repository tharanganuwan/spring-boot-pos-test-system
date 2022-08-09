package com.pos.system.point_of_sell.dto;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.util.ArrayList;

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customer_salary;
    private ArrayList contactNumbers;
    private String nic;
    private boolean activeState;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, double customer_salary, ArrayList contactNumbers, String nic, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customer_salary = customer_salary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.activeState = activeState;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomer_salary() {
        return customer_salary;
    }

    public void setCustomer_salary(double customer_salary) {
        this.customer_salary = customer_salary;
    }

    public ArrayList getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }
}
