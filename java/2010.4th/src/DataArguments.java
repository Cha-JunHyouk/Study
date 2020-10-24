import java.util.Scanner;


class BusinessSalesSystem {
    BusinessSalesSystem() {}
    void doIt() {
        System.out.println("영업관리 시스템");
    }
}

class PublicRelationSystem {
    PublicRelationSystem() {}
    void doIt() {
        System.out.println("공공기관 관리 시스템");
    }
}

class HumanResourceSystem {
    HumanResourceSystem() {}
    void doIt() {
        System.out.println("인사관리 시스템");
    }
}

public class DataArguments {
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("번호가 누락되었습니다.");
        } else {
            int num=Integer.parseInt(args[0]);
            switch(num) {
                case 1:new BusinessSalesSystem().doIt();
                    break;
                case 2:new PublicRelationSystem().doIt();
                    break;
                case 3:new HumanResourceSystem().doIt();
                    break;
            }
        }
    }
}