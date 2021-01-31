public class SalaryList {
    public class Person {
        String name;
        double salary;
        Person next = null;
        Person prev = null;

        public Person(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
    }

    Person sentinelNode;
    Person cursor = null;

    {
        sentinelNode = new Person("", 0);
        sentinelNode.next = sentinelNode;
        sentinelNode.prev = sentinelNode;
    }

    void insertAfter(Person target, String name, double salary) {
        Person tempPerson = target.next;
        Person newPerson = new Person(name, salary);

        target.next = newPerson;
        newPerson.next = tempPerson;

        newPerson.prev = target;
        tempPerson.prev = newPerson;
    }

    public SalaryList(String[] args) {
        cursor = createList(args);
        double avgSalary = findAverageSalary(args);

        while (cursor != sentinelNode) {
            String personName = cursor.name;
            double personSalary = cursor.salary;
            boolean isAboveAverage = personSalary > avgSalary;
            System.out.printf("%-15s %10.2f %b %n", personName, personSalary, isAboveAverage);
            cursor = cursor.next;
        }
    }

    public Person createList(String[] args) {

        for (int i = 0; i < args.length/2; i++) {
            String name = args[i*2];
            double salary = Double.parseDouble(args[(i*2) + 1]);
            cursor = sentinelNode.next;
            while(salary > cursor.salary && cursor != sentinelNode) {
                cursor = cursor.next;
            }
            insertAfter(cursor.prev, name, salary);
        }

        cursor = sentinelNode.next;
        return cursor;
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
            System.out.println("Usage: java SalaryList <name1> <salary1> <name2> <salary2> ...");
            return;
        }
        
        new SalaryList(args);
    }

}
