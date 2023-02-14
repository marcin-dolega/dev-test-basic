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
            if (intsString.matches("[0-9 ]+")) {
                break;
            } else {
                System.out.println("Invalid input, try again:");
            }
        }
        scanner.close();

        List<Integer> ints = Arrays.stream(intsString.split(" ")).map(Integer::parseInt).toList();

        ints.stream().distinct().sorted().forEach(i -> System.out.print(i + " "));

        System.out.println(
                "\ncount: " + (long) ints.size() +
                        "\ndistinct: " + (long) ints.stream().distinct().toList().size() +
                        "\nmin: " + ints.stream().sorted().toList().get(0) +
                        "\nmax: " + ints.stream().sorted().toList().get(ints.size() - 1));

    }
}
