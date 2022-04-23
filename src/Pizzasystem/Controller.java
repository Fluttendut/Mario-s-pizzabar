package Pizzasystem;
import java.util.ArrayList;

//TODO tilføj sorteing,tilføj whileloop i ny ordre, skal opdateres til at fjernd ordre fra pizzaOrderList
public class Controller {
    private UserInterface ui = new UserInterface();
    private Menu menu = new Menu();
    private Order order;
    private boolean isRunning = true;
    private ArrayList<Order> pizzaOrderList = new ArrayList<>();
    private ArrayList<Pizza> currentPizzaOrder = new ArrayList<>();


    public static void main(String[] args) {

        new Controller().go();

    }

    void go() {
        menu.pizzaList();
        ui.mariosPizza();

        while (isRunning) {
            isRunning = options(menu.getPizzas());
        }
    }

    void deleteOrder() {
        orderList();
    }

    void viewOrder() {
        orderList();
    }

    void orderList() {
        ui.printOrderList();

        for (int i = 0; i < pizzaOrderList.size(); i++) {
            System.out.println("#" + currentPizzaOrder.get(i).getNumber() + " "
                    + currentPizzaOrder.get(i).getName() + ", "
                    + pizzaOrderList.get(i).getPickUpTime() + ", "
                    + pizzaOrderList.get(i).getCostumerName() + ", "
                    + pizzaOrderList.get(i).getCostumerNum());
        }
    }

    void newOrder(ArrayList<Pizza> pizzaList) {
        ui.showMenu(pizzaList);
        orderSize(pizzaList);

        //int pizzaNum = ui.returnsUserInputInt();
       // customerPizzaOrders(pizzaNum, pizzaList);

        ui.costumerPickUpTime();
        String pickUpTime = ui.returnsUserInputString();
        ui.costumerName();
        String customerName = ui.returnsUserInputString();
        ui.costumerPhoneNumber();
        String customerPhoneNumber = ui.returnsUserInputString();

        createOrder(currentPizzaOrder, pickUpTime, customerPhoneNumber, customerName);

    }

    void orderSize(ArrayList<Pizza> pizzaList) {

        boolean moreOrders = true;
        String input;
        int pizzaNum;


        while (moreOrders) {
            ui.enterOrder(); //Tilføj loop
            //TODO; find ud af hvordan den bevarer flere ordre (fejl i customerPizzaOrders)
            pizzaNum = ui.returnsUserInputInt();
            customerPizzaOrders(pizzaNum, pizzaList);
            ui.moreThanOneOrder();
            input = ui.returnsUserInputString();

            switch (input) {
                case "yes","y":
                    moreOrders = true;
                    break;
                case "no","n":
                    moreOrders = false;
                    break;
                default:
                    System.out.println("Answer not valid");
                    break;
            }
        }

    }

    void createOrder(ArrayList<Pizza> pizzaPutInOrder, String pickUpTime, String costumerNum, String costumerName) {
        Order order = new Order(pickUpTime, pizzaPutInOrder, costumerNum, costumerName);
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


    boolean options(ArrayList<Pizza> pizzaList) {
        ui.printOptions();
        int input = ui.returnsUserInputInt();

        switch (input) {
            case 1:
                newOrder(pizzaList);
                break;
            case 2:
                deleteOrder();
                break;
            case 3:
                viewOrder();
                break;
            case 4:
                return false;

            default:
        }
        return true;
    }

}
