package pl.dolega;


import java.util.ArrayList;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter integers:");

        Scanner scanner = new Scanner(System.in);

        String line;
        do {
            line = scanner.nextLine();
            list.add(line);
        } while (!line.equals(""));

        list.remove("");

        System.out.println(list);

    }
}
