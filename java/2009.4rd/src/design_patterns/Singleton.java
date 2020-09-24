package design_patterns;

public class Singleton {
    public static void main(String[] args) {
        //항상 게터로 객체를 받아와야 함
        SingleObject object=SingleObject.getInstance();

    }
}
