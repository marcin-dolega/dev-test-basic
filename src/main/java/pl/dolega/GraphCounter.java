package pl.dolega;

import java.util.*;

public class GraphCounter {

    public int numberOfGraphs = 1;

    public void run(String input) {
        List<Integer> vertices = getVertices(input);
        if (vertices.stream().distinct().toList().size() == vertices.size()) {
            numberOfGraphs = vertices.size() / 2;
            return;
        }
        List<List<Integer>> pairs = getPairs(vertices);
        Set<Integer> graph = new HashSet<>(pairs.get(0));
        countGraphs(graph, pairs);
    }

    public void countGraphs(Set<Integer> graph, List<List<Integer>> startingPairs) {

        if (startingPairs.size() == 0) {
            return;
        }

        List<List<Integer>> remainingPairs = new ArrayList<>();


        for (int i = 0; i < startingPairs.size(); i++) {
            List<Integer> pair = startingPairs.get(i);
            if (graph.stream().anyMatch(n -> Objects.equals(n, pair.get(0)) || Objects.equals(n, pair.get(1)))) {
                graph.add(pair.get(0));
                graph.add(pair.get(1));
            } else {
                remainingPairs.add(startingPairs.get(i));
            }
        }

        if (remainingPairs.equals(startingPairs)) {
            numberOfGraphs++;
            countGraphs(new HashSet<>(startingPairs.get(0)), remainingPairs);
        } else {
            countGraphs(graph, remainingPairs);
        }

    }

    public List<List<Integer>> getPairs(List<Integer> vertices) {
        Set<List<Integer>> pairsSet = new HashSet<>();
        List<List<Integer>> pairsList = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i = i + 2) {
            pairsSet.add(Arrays.asList(vertices.get(i), vertices.get(i + 1)).stream().sorted().toList());
        }
        for (int i = 0; i < pairsSet.size(); i++) {
            pairsList.add(pairsSet.stream().toList().get(i));
        }
        return pairsList;
    }

    public List<Integer> getVertices(String input) {
        List<Integer> vertices = Arrays.stream(input.split(" ")).map(Integer::parseInt).toList();
        return vertices.subList(1, vertices.size());
    }

    public String getInput() {
        System.out.println("Enter integers:");
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        do {
            line = scanner.nextLine();
            stringBuilder.append(line + " ");
        } while (!line.equals(""));
        return stringBuilder.toString();
    }
}
