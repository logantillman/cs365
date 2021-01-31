public class ZodiacTest {
    public ZodiacTest() {
        ChineseZodiac year = ChineseZodiac.RABBIT;
        System.out.printf("The last year of the %s occurred in %d%n", year, year.getYear());

        for (ChineseZodiac sign : ChineseZodiac.values()) {
            System.out.printf("The year of the %s last occurred in %d%n", sign, sign.getYear());
        }
    }

    public static void main(String[] args) {
        new ZodiacTest();
    }
}
