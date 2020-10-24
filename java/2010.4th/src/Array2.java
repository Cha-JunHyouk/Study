class Flower{Flower(){}}
public class Array2 {
    public static void main(String[] args) {
        //Flower가 5개 저장될 수 있는 배열 생성
        Flower[] f = new Flower[5];
        f[0] = new Flower(); f[1] = new Flower();
        //Flower가 3개 저장되어 있는 배열 생성
        Flower[] f2 = {new Flower(), new Flower(),
                new Flower()};
    }
}
