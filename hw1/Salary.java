public class Salary {
    public class Person {
        String name;
        double salary;

        public Person(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
    }

    public Salary(String[] args) {
        Person[] people = parseArray(args);
        double avgSalary = findAverageSalary(args);
        
        System.out.printf("average salary = %,.2f %n %n", avgSalary);

        for (Person person : people) {
            boolean isAboveAverage = person.salary > avgSalary;
            System.out.printf("%-15s %,10.2f %b %n", person.name, person.salary, isAboveAverage);
        }
    }

    private Person[] parseArray(String[] args) {
        Person[] people = new Person[args.length/2];

        for (int i = 0; i < args.length/2; i++) {
            String name = args[i * 2];
            double salary = Double.parseDouble(args[(i * 2) + 1]);
            people[i] = new Person(name, salary);
        }

        return people;
    }

    private double findAverageSalary(String[] args) {
        double avgSalary = 0;
        for (int i = 1; i < args.length; i+=2) {
            avgSalary += Double.parseDouble(args[i]);
        }
        avgSalary /= (args.length / 2);
        return avgSalary;
    }
    public static void main(String[] args) {
        if (args.length < 2 || args.length % 2 != 0) {
            System.out.println("Usage: java Salary <name1> <salary1> <name2> <salary2> ...");
            return;
        }
        
        new Salary(args);
    }
}
