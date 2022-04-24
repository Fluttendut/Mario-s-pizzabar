package Pizzasystem;
public class Pizza
{

    private String name;
    private int number;
    private double price;
    private String[] ingredients;


    public Pizza(String name, int number, double price, String[] ingredients)
    {
        this.name = name;
        this.number = number;
        this.price = price;
        this.ingredients = ingredients;

    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }
}
