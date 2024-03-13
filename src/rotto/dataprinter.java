package rotto;
import java.util.Calendar;
public class dataprinter {

    public static void printdatetime( Calendar cal) {

        // 캘린더 클래스를 피라미터로 전달받아
        // 그 객체가 포함하고 있는 시각을 출력하는 메소드

        //년 월 일 시간 분 초 ==>24시간제
        int yy = cal.get(Calendar.YEAR);
        int mm = cal.get(Calendar.MONTH);
        int dd = cal.get(Calendar.DAY_OF_MONTH);
        int hh = cal.get(Calendar.HOUR_OF_DAY);
        int mi = cal.get(Calendar.MINUTE);
        int ss = cal.get(Calendar.SECOND);

    }

}
