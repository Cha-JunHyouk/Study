class Box3 {
    private String conts;

    Box3(String cont) {
        this.conts=cont;
    }
    public String toString() {
        return conts;
    }
}

class BoxArray {
    public static void main(String[] args) {
        Box3[] ar= new Box3[3];

        //배열에 인스턴스 저장
        ar[0]=new Box3("First");
        ar[1]=new Box3("Second");
        ar[2]=new Box3("Third");

        //저장된 인스턴스의 참조
        System.out.println(ar[0]);
        System.out.println(ar[1]);
        System.out.println(ar[2]);
    }
}
