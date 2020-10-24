
import java.util.Calendar;
import java.util.GregorianCalendar;
//연/월/일 을 리턴하는 메서드
//시:분:초 를 리턴하는 메서드
class Today {
    Today(){}
    GregorianCalendar gc=new GregorianCalendar();       //create gregorian calendar instance
    String yyyymmdd(){                                  //return method that returns the year/month/day
        String ymd="";                                  //create temporary method ymd
        ymd = ymd + gc.get(Calendar.YEAR) + "/";
        ymd = ymd + (gc.get(Calendar.MONTH)+1) + "/";
        ymd = ymd + gc.get(Calendar.DATE);
        return ymd;
    }
    String hhmmss(){                                    //return method that returns the hour/minute/second
        String hms="";                                  //create temporary method hms
        int h = gc.get(Calendar.HOUR);//시
        if(h < 10) hms = "0" + h + ":";                 //notation for hour like '09:00:00'
        else hms = hms + h + ":";
        int m = gc.get(Calendar.MINUTE);//분
        if(m < 10) hms = hms + "0" + m + ":";           //notation for minute like '09:00:00'
        else hms = hms + m + ":";
        int s = gc.get(Calendar.SECOND);//초
        if(s < 10) hms = hms + "0" + s;                 //notation for second like '09:00:00'
        else hms = hms + s;
        return hms;
    }
}
public class DateAndTime {
    public static void main(String[] args) {
        Today today = new Today();
        String a = today.yyyymmdd();
        System.out.println(a);
        String b = today.hhmmss();
        System.out.println(b);
//		GregorianCalendar gc =
//				new GregorianCalendar();
//		int y=gc.get(Calendar.YEAR);//년도를 가져온다.
//		int m=gc.get(Calendar.MONTH)+1;
//		int d=gc.get(Calendar.DATE);
//		//월을 가져온다.단,0부터11이므로 1을 더해야한다.
//		System.out.println(y+"/"+m+"/"+d);
//		boolean flag = gc.isLeapYear(Calendar.YEAR);
//		//윤년이면true, 유년이 아니면 false
//		if(flag) System.out.println("윤년임");
//		else System.out.println("윤년이 아님");
//		int amPm = gc.get(Calendar.AM_PM);//0:오전
//		if(amPm == 0) System.out.println("오전");
//		else System.out.println("오후");
//		String time = "";//시분초용 문자열 변수
//		int hh=gc.get(Calendar.HOUR);//시간을 불러옴
//		if(hh < 10) {
//			time = "0"+hh;//10보다 작으면 0을 붙인다.
//		}else {
//			time = hh+"";//10보다 크면 문자열로 바꾼다.
//		}
//		int mm=gc.get(Calendar.MINUTE);//분을 불러옴
//		if(mm < 10) {//10보다 작으면 0을 붙인다.
//			time = time + ":0" + mm ;
//		}else {
//			time = time + ":" + mm;
//		}
//		int ss=gc.get(Calendar.SECOND);//초를 불러옴
//		if(ss < 10) {
//			time = time + ":0" + ss;
//		}else {
//			time = time + ":" +ss;
//		}
//		System.out.println(time);
    }
}