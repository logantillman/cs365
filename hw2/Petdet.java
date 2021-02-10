// Author: Logan Tillman

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayDeque;

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
    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    boolean foundSolution = false;
    ArrayList<String> animalsInCar = new ArrayList<String>();

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

    private void printVerticesArray() {
        System.out.printf("%nVertices Array:%n");
        for (int i = 0; i < verticesArray.size(); i++) {
            System.out.printf("%d - %s%n", i, verticesArray.get(i));
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

    private void recursiveDFS(int vertex, int gasPoints) {
        if (foundSolution) {
            return;
        }

        else if (gasPoints < 0) {
            return;
        }

        // System.out.printf("%n:: CURRENT ANIMALS IN CAR ::%n");
        // for (String animal : animalsInCar) {
        //     System.out.printf("%10s%n", animal);
        // }
        // System.out.println();

        stack.push(vertex);

        if (stack.size() == verticesArray.size()) {
            foundSolution = true;
            // System.out.println("Found a solution");
            // System.out.printf("Stack Size: %d%n", stack.size());
            // System.out.printf("Final gas points: %d%n", gasPoints);
        }

        for (int i = 0; i < shortestDistances[vertex].length; i++) {
            if (isValidMove(vertex, i)) {
                recursiveDFS(shortestDistances[vertex][i].toVertex, gasPoints - shortestDistances[vertex][i].distance);
            }
        }

        if (!foundSolution) {
            stack.pop();
        }
    }

    private boolean isValidMove(int fromVertex, int toVertex) {
        int toVertexIndex = shortestDistances[fromVertex][toVertex].toVertex;
        int toVertexDistance = shortestDistances[fromVertex][toVertex].distance;
        boolean isCarEmpty = animalsInCar.size() == 0;
        boolean isCarFull = animalsInCar.size() == 4;
        boolean isAnimal = !verticesArray.get(toVertexIndex).contains("_home");
        boolean isAnimalHome = !isAnimal;

        // System.out.println("Checking " + toVertexIndex);

        if (stack.contains(toVertexIndex) || animalsInCar.contains(verticesArray.get(toVertexIndex))) {
            // System.out.println("Already exists in stack/car");
            return false;
        }

        // If the vertex is itself
        if (toVertexDistance == 0) {
            // System.out.println("The vertex is itself");
            return false;
        }

        // If car is empty, we can't go to an animalHome
        else if (isCarEmpty) {
            if (isAnimalHome) {
                // System.out.println("Can't go to home without animals");
                return false;
            }
        }

        // If car is full, we can only drop off an animal
        else if (isCarFull) {
            String typeOfHome = verticesArray.get(toVertexIndex);
            // System.out.printf("%nType of home: %s%n", typeOfHome);
            if (isAnimalHome && carContainsAnimal(typeOfHome)) {
                return true;
            }
            // System.out.println("Car is full, can't pick up animal");
            return false;
        }

        // Check to see if we have the animal that belongs to animalHome
        else if (isAnimalHome) {
            String typeOfHome = verticesArray.get(toVertexIndex);

            if (carContainsAnimal(typeOfHome)) {
                return true;
            }
            // System.out.println("We don't have the animal in the car for the home");
            return false;
        }

        // Otherwise, it's an animal and we add it to the car
        String typeOfAnimal = verticesArray.get(toVertexIndex);
        animalsInCar.add(typeOfAnimal);
        return true;
    }

    private boolean carContainsAnimal(String typeOfHome) {
        for (String animal : animalsInCar) {
            if (typeOfHome.contains(animal)) {
                animalsInCar.remove(animal);
                return true;
            }
        }
        return false;
    }

    private void printStack() {
        ArrayDeque<String> outputStack = new ArrayDeque<String>();
        // System.out.printf("%nStack size: %d%n", stack.size());
        while (!stack.isEmpty()) {
            outputStack.push(verticesArray.get(stack.pop()));
        }
        outputStack.pop();
        while (!outputStack.isEmpty()) {
            System.out.println(outputStack.pop());
        }
    }

    Petdet() {
        readInput();

        shortestDistances = new Edge[adjMatrix.size()][adjMatrix.get(0).size()];

        initializeshortestDistances();

        findShortestDistances();

        // printshortestDistances();

        sortShortestDistances();

        // printVerticesArray();

        // printAdjMatrix();

        // printshortestDistances();

        recursiveDFS(0, gasPoints);

        if (!foundSolution) {
            System.out.println("No solution found");
        }
        else {
            printStack();
        }
    }

    public static void main(String[] args) {
        new Petdet();
    }
}