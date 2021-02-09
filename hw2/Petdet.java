// Author: Logan Tillman

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Petdet {
    public class Edge implements Comparable<Edge> {
        public int toVertex;
        public int distance;

        @Override
        public int compareTo(Edge edge) {
            return this.distance - edge.distance;
        }
    }

    final int INFINITY = 1000;
    int gasPoints;
    ArrayList<String> verticesArray = new ArrayList<String>();
    HashMap<String, Integer> verticesMap = new HashMap<String, Integer>();
    ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<ArrayList<Integer>>();
    Edge[][] shortestDistances;

    private void readInput() {
        Scanner scanner = new Scanner(System.in);

        gasPoints = scanner.nextInt();

        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            // System.out.println(inputLine);
            String[] splitString = inputLine.split(" ");
            if (splitString.length == 3) {
                String from = splitString[0];
                String to = splitString[1];
                int num = Integer.parseInt(splitString[2]);
                // System.out.printf("%s %s %s%n", from, to, num);

                if (!verticesMap.containsKey(from)) {
                    verticesMap.put(from, verticesArray.size());
                    verticesArray.add(from);
                    increaseAdjMatrix();
                }
                if (!verticesMap.containsKey(to)) {
                    verticesMap.put(to, verticesArray.size());
                    verticesArray.add(to);
                    increaseAdjMatrix();
                }
                adjMatrix.get(verticesMap.get(from)).set(verticesMap.get(to), num);
                adjMatrix.get(verticesMap.get(to)).set(verticesMap.get(from), num);
            }
        }
    }

    private void increaseAdjMatrix() {
        adjMatrix.add(new ArrayList<Integer>());

        for (int i = 0; i < adjMatrix.size(); i++) {
            while (adjMatrix.get(i).size() != adjMatrix.size()) {
                adjMatrix.get(i).add(0);
            }
        }
    }

    private void initializeshortestDistances() {
        for (int i = 0; i < adjMatrix.size(); i++) {
            for (int j = 0; j < adjMatrix.get(i).size(); j++) {
                Edge tempEdge = new Edge();

                tempEdge.toVertex = j;
                if (i == j){ 
                    tempEdge.distance = 0;
                }
                else if (adjMatrix.get(i).get(j) == 0) {
                    tempEdge.distance = INFINITY;
                }
                else {
                    tempEdge.distance = adjMatrix.get(i).get(j);
                }

                shortestDistances[i][j] = tempEdge;
            }
        }
    }

    private void findShortestDistances() {
        for (int k = 0; k < shortestDistances.length; k++) {
            for (int i = 0; i < shortestDistances.length; i++) {
                for (int j = 0; j < shortestDistances.length; j++) {
                    if (shortestDistances[i][j].distance > shortestDistances[i][k].distance + shortestDistances[k][j].distance) {
                        shortestDistances[i][j].distance = shortestDistances[i][k].distance + shortestDistances[k][j].distance;
                    }
                }
            }
        }
    }

    private void sortShortestDistances() {
        for (int i = 0; i < shortestDistances.length; i++) {
            Arrays.sort(shortestDistances[i]);
        }
    }

    private void printAdjMatrix() {
        System.out.printf("%nAdj - %d x %d%n", adjMatrix.size(), adjMatrix.get(0).size());

        for (int i = 0; i < adjMatrix.size(); i++) {
            for (int j = 0; j < adjMatrix.get(i).size(); j++) {
                System.out.printf("%d ", adjMatrix.get(i).get(j));
            }
            System.out.println();
        }
    }

    private void printshortestDistances() {
        System.out.printf("%nEdge - %d x %d%n", shortestDistances.length, shortestDistances[0].length);

        for (int i = 0; i < shortestDistances.length; i++) {
            for (int j = 0; j < shortestDistances[i].length; j++) {
                System.out.printf("%2d ", shortestDistances[i][j].toVertex);
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < shortestDistances.length; i++) {
            for (int j = 0; j < shortestDistances[i].length; j++) {
                System.out.printf("%d ", shortestDistances[i][j].distance);
            }
            System.out.println();
        }
    }

    Petdet() {
        readInput();

        shortestDistances = new Edge[adjMatrix.size()][adjMatrix.get(0).size()];

        initializeshortestDistances();

        findShortestDistances();

        // printshortestDistances();

        sortShortestDistances();

        // printAdjMatrix();

        printshortestDistances();
    }

    public static void main(String[] args) {
        new Petdet();
    }
}