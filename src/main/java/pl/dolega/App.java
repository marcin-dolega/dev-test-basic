package pl.dolega;


import java.util.*;


public class App {

    public static void main(String[] args) {

        GraphCounter graphCounter = new GraphCounter();

        String input = graphCounter.getInput();

        graphCounter.run(input);

        System.out.println("\nfinal number of graphs: " + graphCounter.numberOfGraphs);

    }

}
