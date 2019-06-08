package Enum;

public enum Season2 {
    SPRING("spring") {
        @Override
        public void m(){
            System.out.println("spring m");
        }
    },
    SUMMER("summer") {
        @Override
        public void m(){
            System.out.println("summer m");
        }
    },
    AUTUMN {
        @Override
        public void m(){
            System.out.println("autumn m");
        }
    },
    WINTER {
        @Override
        public void m(){
            System.out.println("winter m");
        }
    };
    String name;
    private Season2(){
        System.out.println("season");
    }
    private Season2(String name){
        System.out.println("season name");
    }
    public abstract void m();
}
