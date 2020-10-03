class Friends {
    protected String name;
    protected String phone;

    public Friends(String na, String ph) {
        name=na;
        phone=ph;
    }
    public void showInfo() {
        System.out.println("이름 : "+name);
        System.out.println("전화번호 : "+phone);
    }
}

class UnivFriend extends Friends {
    private String major;

    public UnivFriend(String na, String ma, String ph) {
        super(na,ph);
        major=ma;
    }
    public void showInfo() {
        super.showInfo();
        System.out.println("전공 : "+major);
    }
}

class CompFriend extends Friends {
    private String department;

    public CompFriend(String na, String de, String ph) {
        super(na, ph);
        department=de;
    }
    public void showInfo() {
        super.showInfo();
        System.out.println("부서 : "+department);
    }
}

class MyFriends2 {
    public static void main(String[] args) {
        Friends[] frns=new Friends[10];
        int cnt=0;

        frns[cnt++]=new UnivFriend("Lee", "Computer", "01012345678");
        frns[cnt++]=new UnivFriend("Seo", "Electronics", "01087654321");
        frns[cnt++]=new CompFriend("Yoon", "R&D 1", "021234567");
        frns[cnt++]=new CompFriend("Park", "R&D 2", "027654321");

        //모든 동창 및 동료의 정보 전체 출력
        for(int i=0;i<cnt;i++) {
            frns[i].showInfo();     //오버라이딩한 메소드 출력
            System.out.println();
        }
    }
}
