package Pizzasystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    String RESET = "\033[0m";
    String RED_DARK= "\u001b[38;5;88m";
    String ORANGE ="\u001b[38;5;172m";
    String BACKGROUND = "\u001b[48;5;231m";
    String BOLD="\u001b[1m";
    String UNDERLINE = "\u001b[4m";
    String WHITE_BOLD = "\033[1;97m";


    Scanner in = new Scanner(System.in);


    int returnsUserInputInt() {
        int userInput = in.nextInt();
        in.nextLine();
        return userInput;
    }
    String returnsUserInputString() {

        String userInput = in.nextLine();

        return userInput;
    }

    void mariosPizza(){
        System.out.println("\n"+BOLD+RED_DARK+BACKGROUND+" MARIOS PIZZABAR\n"+RESET);
    }

    void showMenu(ArrayList<Pizza> pizzaList) {

        System.out.println("\nMENU:");
        System.out.println(BACKGROUND+BOLD+ORANGE +"\n  PIZZAER");
        for (int i = 0; i < pizzaList.size(); i++) {
            System.out.println( BOLD + RED_DARK+"  #"+ pizzaList.get(i).getNumber() + " "
                    + pizzaList.get(i).getName() + ": "+ RESET + BACKGROUND + RED_DARK
                    + Arrays.toString(pizzaList.get(i).getIngredients()) + ".... " + BOLD
                    + pizzaList.get(i).getPrice() + "kr." + RESET+ BACKGROUND);
        }
        System.out.println("\n"+RESET);
    }


    void printOptions() {
        System.out.print("\n1) Order Pizza\n2) Delete order\n3) View orders\n4) Exit program \n: ");
    }
    void enterOrder() {
        System.out.print("Enter order: ");
    }
    void printNewOrder(){
        System.out.println(BOLD+"NEW ORDER"+RESET);
    }
    void printOrderList(){
        System.out.println("\nPIZZA ORDERS:");
    }

    void customerPickUpTime(){
        System.out.print(BOLD+"\nCUSTOMER INFO"+RESET+"\nPick up time:");

    }
    void customerName(){
        System.out.print("Customer name: ");
    }
    void customerPhoneNumber(){
        System.out.print("Customer phonenumber: ");
    }

    void moreThanOnePizza(){
        System.out.print("Order more (yes/no): ");
    }

    void answerNotValid(){
        System.out.println("Answer not valid");
    }

    void printPizzaNameAndNumber(ArrayList<Pizza> pizzaPutInOrder, int index ){
        System.out.print(WHITE_BOLD + "#" +pizzaPutInOrder.get(index).getNumber() + " "
                + pizzaPutInOrder.get(index).getName()+ ", ");
    }

    void printCustomerInfo(ArrayList<Order> pizzaOrderList, int index){
        System.out.println( "kl: "+pizzaOrderList.get(index).getPickUpTime() + ", " +RESET
                + pizzaOrderList.get(index).getCustomerName() + ", "
                + pizzaOrderList.get(index).getCustomerNum());
    }

    void deleteOrder(){
        System.out.println("Enter customer name: ");
    }

    void nameNotFound(){
        System.out.println("Name not found");
    }
}

