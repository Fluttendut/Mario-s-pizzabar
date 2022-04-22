import java.util.ArrayList;

public class Controller
{
    private UserInterface ui = new UserInterface();
    private Menu menu = new Menu();
    private Order order;
    private boolean isRunning=true;
    private ArrayList<Order> pizzaOrderList = new ArrayList<>();
    private ArrayList<Pizza> currentPizzaOrder = new ArrayList<>();


    public static void main(String[] args)
    {

        new Controller().go();

        /*
    ArrayList<Pizza> pizzas = new ArrayList<>();
    Pizza pizza1 = new Pizza("Magaritta", 1, 69.99, new String[]{"Tomatoes", "Cheese", "Oregano"});
    Pizza pizza2 = new Pizza("Vesuvio", 2,57,new String[]{"tomatsouce", "ost", "skinke", "oregano"});
    pizzas.add(pizza1);
    pizzas.add(pizza2);


    //ikke færdig
    System.out.println(pizza1);
    System.out.println(pizzas);

         */
    }

    void go() {
        menu.pizzaList();

        while (isRunning) {
            options(menu.getPizzas());
        }
    }

    void deleteOrder(){
        orderList();
    }

    void viewOrder(){
        orderList();
    }

    void orderList(){
       ui.printOrderList();
        for (int i = 0; i < pizzaOrderList.size(); i++) {
           // System.out.println(pizzaOrderList.get(i).getName());
        }
    }

    void newOrder(ArrayList<Pizza> pizzaList){
        ui.showMenu(pizzaList);

        ui.enterOrder(); //Tilføj loop

        int pizzaNum = ui.returnsUserInputInt();
        customerPizzaOrders(pizzaNum, pizzaList);

        ui.costumerPickUpTime();
        String pickUpTime = ui.returnsUserInputString();
        ui.costumerName();
        String customerName = ui.returnsUserInputString();
        ui.costumerPhoneNumber();
        String customerPhoneNumber = ui.returnsUserInputString();

        createOrder(currentPizzaOrder, pickUpTime,customerPhoneNumber,customerName);

    }

    void createOrder(ArrayList<Pizza> pizzaPutInOrder, String pickUpTime, String costumerNum, String costumerName){
        Order order = new Order(pickUpTime, pizzaPutInOrder, costumerNum,costumerName);
        pizzaOrderList.add(order);

    }


    void customerPizzaOrders(int pizzaNum, ArrayList<Pizza> pizzaList) {

        //Finder pizzaerne og tilføjer dem til en pizza liste
        for (int i = 0; i < pizzaList.size(); i++) {
            if (pizzaNum == pizzaList.get(i).getNumber()) {
                currentPizzaOrder.add(pizzaList.get(i));
            }
        }
    }


    void options(ArrayList<Pizza> pizzaList){
        ui.printOptions();
        int input = ui.returnsUserInputInt();

        switch (input){
            case 1 -> newOrder(pizzaList);
            case 2 -> deleteOrder();
            case 3 -> viewOrder();
        }

    }

}
