package rotto;
import javax.xml.crypto.KeySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.LocalDate;

public class ROTTORI {
    private static List<Integer> lottoNumbers;
    public static void main(String[] args) {
        // generateLottoNumbers() 메서드를 호출하여 로또 번호를 생성
        lottoNumbers = generateLottoNumbers();
        lottorynum();
    }
    // 로또 번호를 생성하는 메서드
    public static List<Integer> generateLottoNumbers() {
        // 1부터 45까지의 숫자를 담을 리스트 생성
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i); // 리스트에 숫자 추가
        }

        Collections.shuffle(numbers); // 리스트를 섞음

        // 섞인 숫자 중에서 첫 6개를 선택하여 로또 번호로 사용
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers); // 로또 번호를 오름차순으로 정렬

        return lottoNumbers; // 생성된 로또 번호를 반환
    }

    public static void lottorynum() {
        System.out.println("\n 로또 당첨 번호를 안내드립니다");
        System.out.println("\n *****************************************************");
        System.out.println("\n ************************" + lottoNumbers + "********************");
        System.out.println("\n 로또 당첨 번호를 안내드립니다");

        SimpleDateFormat format1 = new SimpleDateFormat( " yyyy-mm-dd HH:mi:ss");

        Calendar time = Calendar.getInstance();

        String format_time1 = format1.format(time.getTime());
        System.out.println("\n========================================================================");
    }

    //로또 결과 출력
    public void result() {
        Membership m = Membership.getInstance();
        Purchase p = Purchase.getInstance();

        System.out.println("[INFO] \" + m.name + \"님의 당첨 결과 3초 후에 안내드립니다.");
        System.out.println("\n=================================================================\n");
        Loding l = new Loading();
        l.loding();

        if ( p.customeNum.equals(randomNum) ) {
            System.out.println("[INFO] " + m.name + "님의 로또번호는 "+ p.customerNum + "입니다.");
            System.out.println("[INFO] 축하드립니다. 로또에 당첨됐습니다.");
        }else {
            System.out.println("[INFO] " + m.name + "님의 로또번호는 "+ p.customerNum + "입니다.");
            System.out.println("[INFO] 낙첨입니다. 다음 기회를 노려보세요.");
        }
        System.out.println("\n=================================================================\n");
        System.out.println("[INFO] 로또 추첨이 완료됐습니다. 감사합니다.");
        System.out.println("\n=================================================================");
    }
}