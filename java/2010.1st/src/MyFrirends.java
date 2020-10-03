class UnivFriends {
    private String name;
    private String major;
    private String phone;

    public UnivFriends(String na, String ma, String ph) {
        name=na;
        major=ma;
        phone=ph;
    }
    public void showInfo() {
        System.out.println("이름 : "+name);
        System.out.println("전공 : "+major);
        System.out.println("전화 : "+phone);
    }
}

class CompFriends {
    private String name;
    private String department;
    private String phone;

    public CompFriends(String na, String de, String ph) {
        name=na;
        department=de;
        phone=ph;
    }
    public void showInfo() {
        System.out.println("이름 : "+name);
        System.out.println("부서 : "+department);
        System.out.println("전화번호 : "+phone);
    }
}

class MyFrirends {
    public static void main(String[] args) {
        //대학 동창의 관리를 위한 배열과 변수
        UnivFriends[] ufrns=new UnivFriends[5];
        int ucnt=0;

        //직장 동료의 관리를 위한 배열관 변수
        CompFriends[] cfrns=new CompFriends[5];
        int ccnt=0;

        //대학 동창의 정보 저장
        ufrns[ucnt++]=new UnivFriends("Lee", "Computer", "01012345678");
        ufrns[ucnt++]=new UnivFriends("Seo", "Electronics", "01087654321");

        //직장 동료의 정보 저장
        cfrns[ccnt++]=new CompFriends("Yoon", "R&D 1", "021234567");
        cfrns[ccnt++]=new CompFriends("Park", "R&D 2", "027654321");

        //모든 동창 및 동료의 정보 전체 출력
        for(int i=0;i<ucnt;i++) {
            ufrns[i].showInfo();
            System.out.println();
            }
        for(int i=0;i<ccnt;i++) {
            cfrns[i].showInfo();
            System.out.println();
        }
    }
}

