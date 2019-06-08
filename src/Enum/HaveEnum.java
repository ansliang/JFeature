package Enum;

enum Gender {
    MALE,FEMALE
}

public class HaveEnum {
    public static String getGender(Gender gender) {
        if(gender.compareTo(Gender.MALE)==1){
            return "男";
        } else if(gender.compareTo(Gender.FEMALE)==0){
            return "女";
        } else
            return "";

    }

    public static void main(String[] args) {
        System.out.println(getGender(Gender.MALE));
        System.out.println(getGender(Gender.FEMALE));
    }
}
