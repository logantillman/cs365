// Author: Logan Tillman

import java.util.Scanner;
import java.util.ArrayList;

public class Salary {
    public class Person {
        private String name;
        private double salary;

        public Person(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return this.name;
        }

        public double getSalary() {
            return this.salary;
        }

        public void printInfo() {
            boolean isAboveAverage = this.salary > avgSalary;
            System.out.printf("%-15s %,10.2f %b %n", this.name, this.salary, isAboveAverage);
        }
    }

    double avgSalary = 0;

    public Salary(ArrayList<String> inputArray) {
        Person[] peopleArray = parseArray(inputArray);
        calculateAverageSalary(peopleArray);
        
        System.out.printf("average salary = %,-10.2f %n %n", avgSalary);

        for (Person person : peopleArray) {
            person.printInfo();
        }
    }

    private Person[] parseArray(ArrayList<String> inputArray) {
        Person[] peopleArray = new Person[inputArray.size() / 2];

        for (int i = 0; i < inputArray.size() / 2; i++) {
            String name = inputArray.get(i * 2);
            double salary = Double.parseDouble(inputArray.get((i * 2) + 1));
            peopleArray[i] = new Person(name, salary);
        }

        return peopleArray;
    }

    private void calculateAverageSalary(Person[] peopleArray) {
        for (Person person : peopleArray) {
            avgSalary += person.getSalary();
        }

        avgSalary /= peopleArray.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputArray = new ArrayList<String>();
        
        while (scanner.hasNext()) {
            inputArray.add(scanner.next());
        }

        new Salary(inputArray);
    }
}
