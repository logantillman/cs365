// Author: Logan Tillman

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
    }

    public Salary(String[] args) {
        Person[] peopleArray = parseArray(args);
        double avgSalary = findAverageSalary(peopleArray);
        
        System.out.printf("average salary = %,-10.2f %n %n", avgSalary);

        for (Person person : peopleArray) {
            boolean isAboveAverage = person.getSalary() > avgSalary;
            System.out.printf("%-15s %,10.2f %b %n", person.getName(), person.getSalary(), isAboveAverage);
        }
    }

    private Person[] parseArray(String[] args) {
        Person[] peopleArray = new Person[args.length / 2];

        for (int i = 0; i < args.length / 2; i++) {
            String name = args[i * 2];
            double salary = Double.parseDouble(args[(i * 2) + 1]);
            peopleArray[i] = new Person(name, salary);
        }

        return peopleArray;
    }

    private double findAverageSalary(Person[] peopleArray) {
        double avgSalary = 0;

        for (Person person : peopleArray) {
            avgSalary += person.getSalary();
        }

        return avgSalary / peopleArray.length;
    }

    public static void main(String[] args) {
        if (args.length == 0 || args.length % 2 != 0) {
            System.out.println("Usage: java Salary <name1> <salary1> <name2> <salary2> ...");
            return;
        }
        
        new Salary(args);
    }
}
