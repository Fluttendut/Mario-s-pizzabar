package Pizzasystem;
import java.util.ArrayList;


public class Order {

    private String pickUpTime;
    private ArrayList<Pizza> pizzaPutInOrder = new ArrayList<>(); //hvor mange pizzaer kunden vil have
    private String costumerNum;
    private String costumerName;


    public Order(String pickUpTime, ArrayList<Pizza> pizza, String costumerNum, String costumerName){
        this.costumerName = costumerName;
        this.costumerNum = costumerNum;
        this.pickUpTime = pickUpTime;
        this.pizzaPutInOrder = pizza;

    }

    public ArrayList<Pizza> getPizzaPutInOrder() {
        return pizzaPutInOrder;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public String getCostumerNum() {
        return costumerNum;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }


}
