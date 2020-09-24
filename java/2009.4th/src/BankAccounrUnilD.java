public class BankAccounrUnilD {

}

class BankAccount {
    String accNumber;
    String ssNumber;
    int balance=0;

    //초기화를 위한 메소드
    public BankAccount(String acc,String ss,int bal) { //인스턴스 초기화 메소드. 인스턴스 생성시 반드시 한 번 호출하여 초기화할 것
        accNumber=acc;
        ssNumber=ss;
        balance=bal;        //계좌 개설 시 예금액으로 초기화
    }

    public int deposit(int amount) {    //입금
        balance+=amount;
        return balance;
    }

    public int withdraw(int amount) {   //출금
        balance-=amount;
        return balance;
    }

    public int checkMyBalance() {
        System.out.println("계좌번호 : "+accNumber);
        System.out.println("주민번호 : "+ssNumber);
        System.out.println("잔   액 : "+balance+'\n');
        return balance;
    }
}

class BankAccountID {
    public static void main(String[] args) {
        BankAccount yoon=new BankAccount("12-34-56","930101-1000000",10000);

        BankAccount park=new BankAccount("78-90-00","900101-1000303",10000);

        yoon.deposit(5000);
        park.deposit(3000);
        yoon.withdraw(2000);
        park.withdraw(2000);
        yoon.checkMyBalance();
        park.checkMyBalance();
    }
}
