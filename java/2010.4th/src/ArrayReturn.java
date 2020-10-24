class Medic {
    Medic(){}
}

public class ArrayReturn {
    public static Medic[] method2() {
        Medic[] m = new Medic[10];//배열 생성
        for (int i = 0; i < m.length; i++) {
            m[i] = new Medic();
        }
        return m;
    }

    public static Medic[] method1() {
//		return new Medic[5];
        Medic[] m = new Medic[5];
        return m;
    }

    public static void main(String[] args) {
        Medic[] m1 = method1();
        Medic[] m2 = method2();
    }
}