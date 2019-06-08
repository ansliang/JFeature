package Enum;

public enum Season {
    SPRING("spring"), SUMMER("summer"), AUTUMN("autumn"), WINTER;

    String name;
    private Season(){
        System.out.println("season");
    }

    private Season(String name){
        this.name = name;
        System.out.println("season name");
    }

    public String getName(){
        return name;
    }
}
