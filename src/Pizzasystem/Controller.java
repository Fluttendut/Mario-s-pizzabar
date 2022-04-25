package Pizzasystem;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private final UserInterface ui = new UserInterface();
    private final Menu menu = new Menu();

    private boolean isRunning = true;
    private ArrayList<Order> pizzaOrderList = new ArrayList<>();
    private ArrayList<Pizza> pizzaList = new ArrayList<>(); //Bruges til opbevaring af Pizza-listen fra Menu-klassen


    void go() {
        pizzaList = menu.getPizzas();
        ui.mariosPizza(); //Titel

        while (isRunning) {
            isRunning = options();
        }
    }

    boolean options() {
        orderList();
        ui.printOptions();
        String input = ui.returnsUserInputString();
        input.trim();


        switch (input) {
            case "1":
                newOrder();
                break;
            case "2":
                deleteOrder();
                break;
            case "3":
                return false;
            default:
                ui.answerNotValid();
                break;
        }
        return true;
    }

    void orderList() {
        ui.printOrderList();

        Collections.sort(pizzaOrderList);

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

        boolean askForPizza = true;
        String input;
        int pizzaNum;

        while (askForPizza) {
            ui.enterOrder();
            pizzaNum = ui.returnsUserInputInt();

            addCustomerPizzaOrders(pizzaNum, currentPizzaOrder);  //Metoden modtager det tomme array, og tilføjer pizzaer til det

            //Ny loop for at fejltjekke svaret til moreThanOnePizza()
            //TODO loop skal nok laves om, da det er dårlig kode
            boolean morePizza = false;
            while (!morePizza) {
                ui.moreThanOnePizza();
                input = ui.returnsUserInputString();

                switch (input) {
                    case "yes", "y":
                        morePizza = true;
                        break;
                    case "no", "n":
                        morePizza = true; //Hvorfor fungere det ikke uden den her
                        askForPizza = false;
                        break;
                }
            }
        }
        return currentPizzaOrder; //Returnere kundens pizza-array
    }

    void createOrder(ArrayList<Pizza> pizzaPutInOrder, String pickUpTime, String costumerNum, String costumerName) {
        Order order = new Order(pickUpTime, pizzaPutInOrder, costumerNum, costumerName);
        pizzaOrderList.add(order);
    }

    void addCustomerPizzaOrders(int pizzaNum, ArrayList<Pizza> currentPizzaOrder) {

        //Finder pizzaerne ved at bruge Pizzanummeret og tilføjer dem til en pizza liste
        for (Pizza pizza : pizzaList) { //for each pizza in pizzaList
            if (pizzaNum == pizza.getNumber()) {
                currentPizzaOrder.add(pizza);
            }
        }
    }

    void deleteOrder() {
        orderList();
        ui.deleteOrder();
        String name = ui.returnsUserInputString();
        removeCustomerPizzaOrders(name);
    }

    void removeCustomerPizzaOrders(String customerName) {


        for (int i = 0; i < pizzaOrderList.size(); i++) {
            if (customerName.equals(pizzaOrderList.get(i).getCustomerName())) {
                pizzaOrderList.remove(i);
                i=-2; //to break out of loop
            }
            else if(i ==pizzaOrderList.size()-1)
                ui.nameNotFound();


        }
    }

}
