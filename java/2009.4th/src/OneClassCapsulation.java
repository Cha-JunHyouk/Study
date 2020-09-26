class SinusCap {
    void sniTake() {
        System.out.println("콧물약");
    }
    void sneTake() {
        System.out.println("재채기약");
    }
    void snuTake() {
        System.out.println("코막힘약");
    }
    void take() {
        sniTake();
        sneTake();
        snuTake();
    }
}

class ColdPatient2 {
    void takeSinus(SinusCap cap) {
        cap.take();
    }
}

public class OneClassCapsulation {
    public static void main(String[] args) {
        ColdPatient2 suf=new ColdPatient2();
        suf.takeSinus(new SinusCap());
    }
}
