import java.util.Scanner;

public class BBSCreation {
    public static void main(String[] args) {
        BBSSystem system = new BBSSystem();
        system.init();
        system.inputBBS();
        system.find();
    }
}
class BBSSystem{//게시글 처리 시스템 객체
    BBSSystem(){}
    BBS[] bbs;//
    Scanner scan = new Scanner(System.in);
    void find() {//작성자 이름으로 게시글 검색
        System.out.println("*******************");
        System.out.println("작성자 명을 입력하세요.");
        String name = scan.nextLine();
        for(int i=0; i<bbs.length; i++) {
            if(name.equals(bbs[i].writer)) {
                System.out.println(
                        "#글제목:"+bbs[i].title);
                System.out.println(
                        "#글내용:"+bbs[i].content);
                System.out.println(
                        "#작성일:"+bbs[i].bbsDate);
                break;//찾았으므로 출력 후 반복 종료
            }//입력한 이름과 게시글의 작성자가 동일한경우
        }//배열의 길이 만큼 반복하면서 동일한 이름을 찾는다.
    }
    void init() {//반드시 처음에 호출해야 한다.
        System.out.println("* 게시글 관리 시스템 ver1.0 *");
        System.out.println("-작성하실 게시글의 수를 "
                + "입력하세요.");
        int number = scan.nextInt();
        scan.nextLine();//숫자를 입력한 후 Enter처리
        bbs = new BBS[number];//배열 생성 완료
    }
    void inputBBS() {
        for(int i=0; i<bbs.length; i++) {
            Today today = new Today();
            BBS bbs = new BBS();//게시글 객체 생성
            System.out.println("작성자를 입력하세요.");
            String name = scan.nextLine();
            System.out.println("글 제목을 입력하세요.");
            String title = scan.nextLine();
            System.out.println("글 내용을 입력하세요.");
            String content = scan.nextLine();
            bbs.writer = name;
            bbs.title = title;
            bbs.content = content;
            bbs.bbsDate = today.yyyymmdd()+ " " +
                    today.hhmmss();
            this.bbs[i] = bbs;//게시글을 배열에 저장
        }//배열의 길이 만큼 반복
    }
}
class BBS {//게시글 객체
    BBS(){}
    String writer;//작성자
    String title;//글 제목
    String content;//글 내용
    String bbsDate;//작성일
}

// 작성하실 게시글의 수를 입력하세요.
// 3
// 작성자 이름을 입력하세요.
// 홍길동
// 글 제목을 입력하세요.
// 공지사항
// 글 내용을 입력하세요.
// 모두 건강에 유의하세요.
// ** 두 번 더 반복 **
// 검색할 작성자의 이름을 입력하세요.
// 홍길동
// 글 제목 : 공지사항
// 글 내용 : 모두 건강에 유의하세요.
// 작성일 : 2020/10/20 오후 04:10:23


