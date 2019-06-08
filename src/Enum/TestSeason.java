package Enum;

public class TestSeason {
    public static void main(String[] args) {
        /*Season[] s = Season.values();
        for (Season season : s) {
            System.out.println(season.name());
            System.out.println(season.ordinal());
        }

        Season s1 = Enum.valueOf(Season.class, "AUTUMN");
        System.out.println(s1.name());*/

        System.out.println(Season.SPRING.getName());
        System.out.println(Season.WINTER.getName());

        Season2.SPRING.m();
    }
}
