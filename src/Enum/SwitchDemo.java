package Enum;

public class SwitchDemo {
    public static String getSeason(Season s) {
        switch (s) {
            case SPRING:
                return "spring";
            case SUMMER:
                return "summer";
            case AUTUMN:
                return "autumn";
            case WINTER:
                return "winter";
            default:
                return "null";
        }
    }

    public static void main(String[] args) {
        System.out.println(getSeason(Season.SPRING));
        System.out.println(getSeason(Season.SUMMER));
    }
}
