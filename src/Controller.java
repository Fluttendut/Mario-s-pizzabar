import java.util.ArrayList;

public class Controller
{
    private UserInterface ui = new UserInterface();
    private Menu menu = new Menu();
    private boolean isRunning=true;


    public static void main(String[] args)
    {

        new Controller().go();
    }

    void go() {
        menu.pizzaList();

        while (isRunning) {
            isRunning = ui.options(menu.getPizzas());

        }
    }


}
