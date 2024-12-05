package org.example.donmachos;

public class orders {

    private String name;
    private String address;
    private String city;
    private String cellphone;

    public orders(String name, String address, String city, String cellphone) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCellphone() {
        return cellphone;
    }

    @Override
    public String toString() {
        return "Order{name='" + name + "', address='" + address + "', city='" + city + "', cellphone='" + cellphone + "'}";
    }
}
