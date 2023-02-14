package pl.dolega;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main( String[] args ) {

        String intsString;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integers:");
        while (true) {
            intsString = scanner.nextLine();
            if (intsString.matches("[-?0-9 ]+")) {
                break;
            } else {
                System.out.println("Invalid input, try again:");
            }
        }
        scanner.close();

        List<Integer> ints = Arrays.stream(
                intsString.split(" "))
                .map(Integer::parseInt)
                .toList();

        ints.stream().sorted().forEach(i -> {
            if ((i < 7) && ints.contains(13 - i)) {
                System.out.println(i + " " + (13 - i));
            }
        });
    }
}

