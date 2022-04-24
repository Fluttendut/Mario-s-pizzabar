package Pizzasystem;

import java.util.ArrayList;

//TODO tilføj sortering,tilføj while loop i ny ordre, skal opdateres til at fjerne ordre fra pizzaOrderList
public class Controller {
    private final UserInterface ui = new UserInterface();
    private final Menu menu = new Menu();

    private boolean isRunning = true;
    private ArrayList<Order> pizzaOrderList = new ArrayList<>();
    private ArrayList<Pizza> pizzaList = new ArrayList<>(); //Bruges til opbevaring af Pizza-listen fra Menu-klassen


    public static void main(String[] args) {
        new Controller().go();

    }

    void go() {
        pizzaList = menu.getPizzas();
        ui.mariosPizza(); //Titel

        while (isRunning) {
            isRunning = options();
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

            ArrayList<Pizza> pizzaPutInOrder = pizzaOrderList.get(i).getPizzaPutInOrder();

            for (int j = 0; j < pizzaPutInOrder.size(); j++) { //for loop for hvert [pizza], i hvert element i [order]
                ui.printPizzaNameAndNumber(pizzaPutInOrder, j);
            }

            ui.printCustomerInfo(pizzaOrderList, i);
        }
    }

    void newOrder() {

        //MENU
        ui.showMenu(pizzaList);
        ui.printNewOrder();

        //BESTILLING
        ArrayList<Pizza> currentPizzaOrder = takeOrder();

        //KUNDE INFO
        ui.customerPickUpTime();
        String pickUpTime = ui.returnsUserInputString();
        ui.customerName();
        String customerName = ui.returnsUserInputString();
        ui.customerPhoneNumber();
        String customerPhoneNumber = ui.returnsUserInputString();

        //NY ORDRE OBJEKT
        createOrder(currentPizzaOrder, pickUpTime, customerPhoneNumber, customerName);


    }

    ArrayList<Pizza> takeOrder() {

        ArrayList<Pizza> currentPizzaOrder = new ArrayList<>(); //Oprettede et nyt array, da vi gerne vil have individuelle pizza-array for hver kunde

        boolean moreOrders = true;
        String input;
        int pizzaNum;

        while (moreOrders) {
            ui.enterOrder();
            //TODO; find ud af hvordan den bevarer flere ordre (fejl i customerPizzaOrders) ----DONE!
            pizzaNum = ui.returnsUserInputInt();
            customerPizzaOrders(pizzaNum, currentPizzaOrder); //Metoden modtager det tomme array, og tilføjer pizzaer til det
            ui.moreThanOneOrder();
            input = ui.returnsUserInputString();

            switch (input) {
                case "yes", "y" -> moreOrders = true;
                case "no", "n" -> moreOrders = false;
                default -> ui.answerNotValid();
            }
        }
        return currentPizzaOrder; //Returnere kundens pizza-array

    }

    void createOrder(ArrayList<Pizza> pizzaPutInOrder, String pickUpTime, String costumerNum, String costumerName) {
        Order order = new Order(pickUpTime, pizzaPutInOrder, costumerNum, costumerName);
        pizzaOrderList.add(order);
    }


    void customerPizzaOrders(int pizzaNum, ArrayList<Pizza> currentPizzaOrder) {

        //Finder pizzaerne ved at bruge Pizzanummeret og tilføjer dem til en pizza liste
        for (Pizza pizza : pizzaList) { //for each pizza in pizzaList
            if (pizzaNum == pizza.getNumber()) {
                currentPizzaOrder.add(pizza);
            }
        }
    }


    boolean options() {
        ui.printOptions();
        int input = ui.returnsUserInputInt();

        switch (input) {
            case 1:
                newOrder();
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
                ui.answerNotValid();
                break;
        }
        return true;
    }

}
