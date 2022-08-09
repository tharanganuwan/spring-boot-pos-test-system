package com.pos.system.point_of_sell.dto.request;

import java.util.ArrayList;

public class CustomerSaveRequestDTO {

    private String customerName;
    private String customerAddress;
    private double customer_salary;
    private ArrayList contactNumbers;
    private String nic;

    public CustomerSaveRequestDTO() {
    }

    public CustomerSaveRequestDTO(String customerName, String customerAddress, double customer_salary, ArrayList contactNumbers, String nic) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customer_salary = customer_salary;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
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

    @Override
    public String toString() {
        return "CustomerSaveRequestDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customer_salary=" + customer_salary +
                ", contactNumbers=" + contactNumbers +
                ", nic='" + nic + '\'' +
                '}';
    }
}
