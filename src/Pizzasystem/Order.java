package Pizzasystem;
import java.util.ArrayList;


public class Order {

    private String pickUpTime;
    private ArrayList<Pizza> pizzaPutInOrder = new ArrayList<>(); //hvor mange pizzaer kunden vil have
    private String customerNum;
    private String customerName;
    private Pizza pizza;


    public Order(String pickUpTime, ArrayList<Pizza> pizza, String customerNum, String customerName){
        this.customerName = customerName;
        this.customerNum = customerNum;
        this.pickUpTime = pickUpTime;
        this.pizzaPutInOrder = pizza;

    }

    public ArrayList<Pizza> getPizzaPutInOrder() {
        return pizzaPutInOrder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }


    public void setPizza(Pizza pizza){
        this.pizza = pizza;

    }

    public Pizza getPizza() {
        return pizza;
    }
}
