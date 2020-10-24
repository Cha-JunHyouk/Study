//다음과 같이 동작하는 게임관리 시스템을 작성합니다.
//게임캐릭터의 갯수를 입력하세요.
//
//등록할 전직를 입력하세요.
//
//등록할 무기을 입력하세요.
//
//등록할 캐릭터의 스탯을 입력하세요.
//예)힘,민첩,방어,마나등등
//--2번 더 반복--
//******************************
//검색할 전직를 입력하세요.
//
//전직 이름:
//전직 무기:
//캐릭터 스탯
//등록일 :
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class GameSystem {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Dates dates =new Dates();
        Date today=new Date();
        Weapons selectW=new Weapons();
        Status selectS=new Status();
        Job selectJ=new Job();
        System.out.print("insert name : ");
        System.out.println("name : "+s.nextLine());
        System.out.println("Job : "+selectJ.selectJob());
        System.out.println("Weapon : "+selectW.selectWeapon());
        selectS.printStatus();
        String a= dates.yyyymmdd();
        SimpleDateFormat formatTime;
        formatTime=new SimpleDateFormat("HH:mm:ss");
        System.out.print("Created in : "+a);
        System.out.println("."+formatTime.format(today));
    }
}

class Job {
    Job() {}
    String[] sortOfJob=new String[] {"Fighter", "Archer", "Berserker", "Magician"};
    public String selectJob() {
        String job=sortOfJob[(int)(Math.random()*3)];
        return job;
    }
}

class Weapons extends Job {
    Weapons() {}
    String[] sortOfWeapon=new String[] {"Sword", "Axe", "Mace", "Spear", "Bow", "Crossbow", "Staff", "Wand", "Book"};
    String[] fighterWeapons=Arrays.copyOfRange(sortOfWeapon, 0, 3);
    String[] archerWeapons=Arrays.copyOfRange(sortOfWeapon, 4, 5);
    String[] berserkerWeapons=Arrays.copyOfRange(sortOfWeapon, 1, 2);
    String[] magicianWeapons=Arrays.copyOfRange(sortOfWeapon, 6, 8);
    String selectWeapon() {
        String weapon="";
        if(selectJob()=="Fighter")
            weapon=(fighterWeapons[(int)(Math.random()*3)]);
        else if (selectJob()=="Archer")
            weapon=(archerWeapons[(int)(Math.random()*2)]);
        else if (selectJob()=="Berserker")
            weapon=(berserkerWeapons[(int)(Math.random()*2)]);
        else if (selectJob()=="Magician")
            weapon=(magicianWeapons[(int)(Math.random()*3)]);
        return weapon;
    }
}

class Status {
    Status() {}
    int[] sortOfStatus=new int[] {(int)(Math.random()*900)+100, (int)(Math.random()*900)+100, (int)(Math.random()*100), (int)(Math.random()*100), (int)(Math.random()*100)};
    void printStatus() {
        System.out.println("HP : "+sortOfStatus[0]);
        System.out.println("MP : "+sortOfStatus[1]);
        System.out.println("STR : "+sortOfStatus[2]);
        System.out.println("INT : "+sortOfStatus[3]);
        System.out.println("AGI : "+sortOfStatus[4]);
    }
}

class Dates {
    Dates() {}
    GregorianCalendar gc=new GregorianCalendar();
    String yyyymmdd() {
        String ymd="";
        ymd=ymd+gc.get(Calendar.YEAR)+"/";
        ymd=ymd+(gc.get(Calendar.MONTH)+1)+"/";
        ymd=ymd+gc.get(Calendar.DATE);
        return ymd;
    }
    String hhmmdd() {
        String hms="";
        int h=gc.get(Calendar.HOUR);
        if(h<10)
            hms="0"+h+":";
        else
            hms=hms+h+":";
        int m=gc.get(Calendar.MINUTE);
        if(m<10)
            hms=hms+"0"+m+":";
        else
            hms=hms+m+":";
        int s=gc.get(Calendar.SECOND);
        if(s<10)
            hms=hms+"0"+s;
        else
            hms=hms+s;
        return hms;
    }
}