import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface
{
    Scanner in = new Scanner(System.in);
    private ArrayList<Pizza> pizzaOrderList = new ArrayList<>();


    void showMenu(ArrayList<Pizza> pizzaList){

        for (int i = 0; i < pizzaList.size(); i++) {
            System.out.println("#" + pizzaList.get(i).getNumber() + " "
                    + pizzaList.get(i).getName() + " "
                    + Arrays.toString(pizzaList.get(i).getIngredients()) + " "
                    + pizzaList.get(i).getPrice() + "kr.");
        }

    }
    void deleteOrder(){
        orderList();
        System.out.print("Enter the order which you would like to remove: ");
        int pizzaNum = in.nextInt();

        removePizzaFromOrderList(pizzaNum, pizzaOrderList);
    }

    void viewOrder(){
        orderList();
    }

    void orderList(){
        System.out.println("\nPIZZA ORDERS:");
        for (int i = 0; i < pizzaOrderList.size(); i++) {
            System.out.println("#" + pizzaOrderList.get(i).getNumber() + " " + pizzaOrderList.get(i).getName());
        }
    }

    void newOrder(ArrayList<Pizza> pizzaList){
        showMenu(pizzaList);
        System.out.print("Enter order: ");
        int pizzaNum = in.nextInt();

        addPizzaToOrderList(pizzaNum, pizzaList);


    }

    void addPizzaToOrderList( int pizzaNum, ArrayList<Pizza> pizzaList){

        for (int i = 0; i < pizzaList.size(); i++) {
            if (pizzaNum == pizzaList.get(i).getNumber()){
                pizzaOrderList.add(pizzaList.get(i));
            }

        }

    }
    void removePizzaFromOrderList( int pizzaNum, ArrayList<Pizza> pizzaList){

        for (int i = 0; i < pizzaList.size(); i++) {
            if (pizzaNum == pizzaList.get(i).getNumber()){
                pizzaOrderList.remove(pizzaList.get(i));
            }

        }

    }


    void options(ArrayList<Pizza> pizzaList){
        System.out.print("\n1) Order Pizza\n2) Delete order\n3) View orders\n: ");
        int input = in.nextInt();

        switch (input){
            case 1 -> newOrder(pizzaList);
            case 2 -> deleteOrder();
            case 3 -> viewOrder();
        }

    }

}
