import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {


    Scanner in = new Scanner(System.in);

    int returnsUserInputInt() {
        int userInput = in.nextInt();
        System.out.println();
        return userInput;
    }
    String returnsUserInputString() {
        String userInput = in.nextLine();
        System.out.println();
        return userInput;
    }


    void showMenu(ArrayList<Pizza> pizzaList) {

        for (int i = 0; i < pizzaList.size(); i++) {
            System.out.println(pizzaList.get(i).getNumber() + " " + pizzaList.get(i).getName());
        }
    }


    void printOptions() {
        System.out.print("\n1) Order Pizza\n2) Delete order\n3) View orders\n: ");
    }

    void enterOrder() {
        System.out.print("Enter order: ");
    }


    void printOrderList(){
        System.out.println("\nPIZZA ORDERS:");
    }

    void costumerPickUpTime(){
        System.out.print("Enter pick up time:");

    }

    void costumerName(){
        System.out.print("Costumer name: ");
    }

    void costumerPhoneNumber(){
        System.out.print("Costumer phonenumber: ");
    }



}

