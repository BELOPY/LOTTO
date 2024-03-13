package rotto;
import java.util.Calendar;
import java.util.Scanner;

public class Membership {
    private static Membership m;

    public static Membership getInstance() {
        if (m == null) {
            m = new Membership();
        }
        return m;
    }

    public static void freeInstance() {
        m = null;
    }

    private Membership() {
    }

    String name;        // 이름
    String personalYY;    // 태어난 년도
    String personalMM;    // 태어난 월
    String personalDD;    // 태어난 일
    String email;        // 이메일
    String address;        // 주소
    String pw;            // 카드 비밀번호

    // 회원가입 양식
    public void membershipGuide() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ##        ####    ######   ######   ######   #####    ##  ## \r\n"
                + " ##       ##  ##     ##       ##     ##       ##  ##   ##  ##  \r\n"
                + " ##       ##  ##     ##       ##     #####    #####    ###### \r\n"
                + " ##       ##  ##     ##       ##     ##       ## ##      ##    \r\n"
                + " ######    ####      ##       ##     ######   ##  ##     ##");
        System.out.println("\n[INFO] 안녕하세요. 로또입니다.\n"
                + "로또 구입을 위해선 회원가입이 필요합니다.\n"
                + "회원가입을 진행하시겠습니까?\n"
                + "[1] 예\t[2] 아니요");
        String answer = "";

        for(;;) {
            System.out.println("\n입력 :");
            answer = sc.next();

            if(answer.equals("2") || answer.equals("아니요")){
                System.out.println("\n [ERROR]회원이 아니라면 로또를 구입하실수 없습니다");
                System.exit(0);
            }else {
                System.out.println("\n [ERROR]잘못된 입력입니다. 다시입력해주세요");
            }
        }
        }
    }
