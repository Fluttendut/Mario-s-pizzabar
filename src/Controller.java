import java.util.ArrayList;

public class Controller
{
    public static void main(String[] args)
    {

    ArrayList<Pizza> pizzas = new ArrayList<>();
    Pizza pizza1 = new Pizza("Magaritta", 1, 69.99, new String[]{"Tomatoes", "Cheese", "Oregano"});
    Pizza pizza2 = new Pizza("Vesuvio", 2,57,new String[]{"tomatsouce", "ost", "skinke", "oregano"});
    pizzas.add(pizza1);
    pizzas.add(pizza2);


    //ikke færdig
    System.out.println(pizza1);
    System.out.println(pizzas);
    }
}
