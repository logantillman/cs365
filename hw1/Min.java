public class Min {
    public Min(String[] strings) {
        String minString = strings[0];
        for (String currString : strings) {
            if (currString.compareTo(minString) < 0) {
                minString = currString;
            }
        }
        System.out.println(minString);
    }

    public static void main(String[] args) {
        new Min(args);
    }
}