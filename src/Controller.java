import java.util.ArrayList;

public class Controller
{
    public static void main(String[] args)
    {

    ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    pizzas.add(new Pizza("Magaritta", 1, 69.99, new String[]{"Tomatoes", "Cheese", "Oregano"}));

    //ikke færdig
    System.out.println(pizzas[0]);
    }
}
