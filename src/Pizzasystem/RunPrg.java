package Pizzasystem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class RunPrg {

    public static void main(String[] args) {
        new RunPrg().sortArray();
        new Controller().go();


    }

    void sortArray(){
        ArrayList<String> tid = new ArrayList<>();

        tid.add("2");
        tid.add("1");
        tid.add("3");

        Collections.sort(tid);

        System.out.println(tid);
    }

}
