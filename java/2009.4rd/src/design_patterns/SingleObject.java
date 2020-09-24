package design_patterns;

public class SingleObject {
    public static SingleObject instance=new SingleObject();     //SingleObject라는 method 내에서 instance라는 객체 생성
    //객체를 사용하기 위해서는 method를 호출하기 전에 객체를 호출해야 한다.
    //생성자는 값을 반환하지 않는다
    //클래스의 이름과 생성자의 이름은 동일하다
    //생성자는 인스턴스를 생성해주는 역할을 하는 특수한 메소드
    private SingleObject(){}            //생성자는 내부에서만 호출되도록 한다
    public static SingleObject getInstance() {
        return instance;
    }
}
