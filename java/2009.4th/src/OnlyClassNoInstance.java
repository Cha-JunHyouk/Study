class InstCnt2 {
    static int instNum=100;

    InstCnt2() {
        instNum++;
        System.out.println("인스턴스 생성"+instNum);
    }
}

class OnlyClassNoInstance {
    public static void main(String[] args) {
        InstCnt2.instNum-=15;        //인스턴스 생성 없이 instNum에 접근
        System.out.println(InstCnt2.instNum);
    }
}
