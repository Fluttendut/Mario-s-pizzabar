package Pizzasystem;
import java.util.ArrayList;
import java.util.Collections;

public class Menu
{

    //                                  Navn/ Num/ Pris/ Ingredienser /
    private Pizza pizza1 = new Pizza("Vesuvio", 1,57,new String[]{"tomatsouce", "ost", "skinke", "oregano"});
    private Pizza pizza2 = new Pizza("Amerikaner", 2,53,new String[]{"tomatsouce", "ost", "oksefars", "oregano"});
    private Pizza pizza3 = new Pizza("Cacciatore", 3,57,new String[]{"tomatsouce", "ost", "pepperoni", "oregano"});
    private Pizza pizza4 = new Pizza("Carbona", 4,63,new String[]{"tomatsouce", "ost", "kødsauce", "spaghetti","cocktailpølser","oregano"});
    private Pizza pizza5 = new Pizza("Dennis", 5,65,new String[]{"tomatsouce", "ost", "skinke","pepperoni", "cocktailpølser","oregano"});
    private Pizza pizza6 = new Pizza("Bertil", 6,57,new String[]{"tomatsouce", "ost", "bacon", "oregano",});
    private Pizza pizza7 = new Pizza("Silvia", 7,61,new String[]{"tomatsouce", "ost", "pepperoni", "rød peber", "løg", "oregano"});
    private Pizza pizza8 = new Pizza("Victoria", 8,61,new String[]{"tomatsouce", "ost", "skinke", "ananas","champignon", "løg","oregano"});

    private ArrayList<Pizza> pizzas = new ArrayList<>();

    void pizzaList(){
        Collections.addAll(pizzas, pizza1,pizza2,pizza3,pizza4,pizza5,pizza6,pizza7,pizza8);

    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
}
