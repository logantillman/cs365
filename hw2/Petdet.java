// Author: Logan Tillman
// I've noticed that my program doesn't always work. I'm hoping for partial credit.

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
    
    // Parse the input and create the dynamic array and map to hold the vertices
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
        scanner.close();
    }

    // Increases the size of the Adjacency matrix by 1 row and 1 column
    private void increaseAdjMatrix() {
        adjMatrix.add(new ArrayList<Integer>());

        for (int i = 0; i < adjMatrix.size(); i++) {
            while (adjMatrix.get(i).size() != adjMatrix.size()) {
                adjMatrix.get(i).add(0);
            }
        }
    }

    // Initializes the shortestDistances array by filling in infinity (1000) for the unknown distances
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

    // Performs the Floyd Warshall algorithm to find the shortest distances between all vertices
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

    // Sorts the shortestDistances array
    private void sortShortestDistances() {
        for (int i = 0; i < shortestDistances.length; i++) {
            Arrays.sort(shortestDistances[i]);
        }
    }

    // Recursive Depth-First Search function
    private void recursiveDFS(int vertex, int gasPoints) {
        if (foundSolution) {
            return;
        }

        else if (gasPoints < 0) {
            return;
        }

        stack.push(vertex);

        // If the stack is full and we're not out of gas, we've found a solution
        if (stack.size() == verticesArray.size()) {
            foundSolution = true;
        }

        for (int i = 0; i < shortestDistances[vertex].length; i++) {

            // Check if each vertex is a valid move. If it is, call DFS on it
            if (isValidMove(vertex, i)) {
                recursiveDFS(shortestDistances[vertex][i].toVertex, gasPoints - shortestDistances[vertex][i].distance);
            }
        }

        // Pop off the stack if we haven't found a solution
        if (!foundSolution) {
            stack.pop();
        }
    }

    // Unsuccessfully checks if each traversal of the DFS is a valid move
    private boolean isValidMove(int fromVertex, int toVertex) {
        int toVertexIndex = shortestDistances[fromVertex][toVertex].toVertex;
        int toVertexDistance = shortestDistances[fromVertex][toVertex].distance;
        boolean isCarEmpty = animalsInCar.size() == 0;
        boolean isCarFull = animalsInCar.size() == 4;
        boolean isAnimal = !verticesArray.get(toVertexIndex).contains("_home");
        boolean isAnimalHome = !isAnimal;

        // If we've already visited the vertex, return
        if (stack.contains(toVertexIndex)) {
            return false;
        }

        // If the vertex is itself, return
        if (toVertexDistance == 0) {
            return false;
        }

        // If car is empty, we can't go to an animalHome
        else if (isCarEmpty) {
            if (isAnimalHome) {
                return false;
            }
        }

        // If car is full, we can only drop off an animal
        else if (isCarFull) {
            String typeOfHome = verticesArray.get(toVertexIndex);

            if (isAnimalHome && carContainsAnimal(typeOfHome)) {
                return true;
            }
            return false;
        }

        // Checking to make sure we have an animal in the car that belongs to the home
        else if (isAnimalHome) {
            String typeOfHome = verticesArray.get(toVertexIndex);

            if (carContainsAnimal(typeOfHome)) {
                return true;
            }
            return false;
        }

        // Otherwise, it's an animal and we add it to the car
        String typeOfAnimal = verticesArray.get(toVertexIndex);
        animalsInCar.add(typeOfAnimal);
        return true;
    }

    // Checking to see if the car contains the animal belonging to the type of home
    private boolean carContainsAnimal(String typeOfHome) {
        for (String animal : animalsInCar) {
            if (typeOfHome.contains(animal)) {
                animalsInCar.remove(animal);
                return true;
            }
        }
        return false;
    }

    // Printing out the path by reversing the stack
    private void printPath() {
        ArrayDeque<String> outputStack = new ArrayDeque<String>();
        while (!stack.isEmpty()) {
            outputStack.push(verticesArray.get(stack.pop()));
        }
        outputStack.pop();
        while (!outputStack.isEmpty()) {
            System.out.println(outputStack.pop());
        }
    }

    Petdet() {

        // Read the input and create the verticesArray and VerticesMap
        readInput();

        // Creating the shortestDistances array based on the size of the Adj matrix
        shortestDistances = new Edge[adjMatrix.size()][adjMatrix.get(0).size()];

        // Initializes the matrix by filling in unknowns with infinity (1000)
        initializeshortestDistances();

        // Performs the Floyd-Warshall algorithm to find the shortest distances between vertices
        findShortestDistances();

        // Sorts the array
        sortShortestDistances();

        // Performs DFS recursively starting with the car
        recursiveDFS(0, gasPoints);

        if (!foundSolution) {
            System.out.println("No solution found");
        }
        else {
            printPath();
        }
    }

    public static void main(String[] args) {
        new Petdet();
    }
}