package pl.dolega;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
