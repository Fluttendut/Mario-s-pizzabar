import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface
{
    Scanner in = new Scanner(System.in);

    private Menu pizzaList;

    void showMenu(ArrayList<Pizza> pizzaList){

        for (int i = 0; i < pizzaList.size(); i++) {
            System.out.println(pizzaList.get(i).getNumber() + " " + pizzaList.get(i).getName());
        }

    }
    void deleteOrder(){

    }

    void viewOrder(){

    }
    void newOrder(){
        showMenu();

    }

    void options(){
        System.out.println("1) Order Pizza\n 2) Delete order\n 3) View orders");
        int input = in.nextInt();

        switch (input){
            case 1 -> newOrder();
            case 2 -> deleteOrder();
            case 3 -> viewOrder();
        }

    }

}
