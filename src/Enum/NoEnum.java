package Enum;

public class NoEnum {
    public static String getGender(char c) {
        if (c == 'f')
            return "女";
        else if (c == 'm')
            return "男";
        else
            return "";
    }

    public static void main(String[] args) {
        System.out.println(getGender('f'));
        System.out.println(getGender('m'));
        System.out.println(getGender('n'));
    }
}
