package Pizzasystem;
import java.util.ArrayList;


public class Order implements Comparable{

    private String pickUpTime;
    private ArrayList<Pizza> pizzaPutInOrder = new ArrayList<>(); //hvor mange pizzaer kunden vil have
    private String customerNum;
    private String customerName;


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


    @Override
    public int compareTo(Object o) {
        Order order = ((Order)o);

        if(pickUpTime.equalsIgnoreCase("now") && order.pickUpTime.equalsIgnoreCase("now"))
            return 0;
        else if(pickUpTime.equalsIgnoreCase("now"))
            return -1;
        else if(order.pickUpTime.equalsIgnoreCase("now"))
            return 1;
        else {
            int pickUpTimeInt =  Integer.parseInt(pickUpTime);
            int pickUpTimeIntOrder = Integer.parseInt(order.pickUpTime);
            if (pickUpTimeInt>pickUpTimeIntOrder)
                return 1;
            else if (pickUpTimeInt<pickUpTimeIntOrder)
                return -1;
            else
                return 0;
        }

    }
}
