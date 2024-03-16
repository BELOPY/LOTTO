package rotto;

import java.util.Calendar;
import java.util.Scanner;
public class Membership {
    // 싱글톤 객체 생성
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
    purchase p = purchase.getInstance();
    public static boolean isDataEntered;


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
        Scanner sc1 = new Scanner(System.in);

        System.out.println(
                " \n\n ##        ####    ######   ######   ######   #####    ##  ##  \r\n"
                        + " ##       ##  ##     ##       ##     ##       ##  ##   ##  ##  \r\n"
                        + " ##       ##  ##     ##       ##     #####    #####    ###### \r\n"
                        + " ##       ##  ##     ##       ##     ##       ## ##      ##    \r\n"
                        + " ######    ####      ##       ##     ######   ##  ##     ##");

        System.out.println("\n[INFO] 안녕하세요 로또입니다.\n"
                + "로또 구입을 위해선 회원가입이 필요합니다.\n"
                + "회원가입을 진행하시겠습니까?\n"
                + "[1] 예\t[2] 아니요\n"
                + "[3] 회원 정보열람\t [4]로또 당첨금액");

        String answer = "";
        String answer2 = "";

        for (; ; ) {
            System.out.print("\n입력 : ");
            answer = sc.next();

            if (answer.equals("1") || answer.equals("예")) {
                if(!isDataEntered){
                    personalData();
                    break;
                } else if (isDataEntered) {
                    System.out.println("이미 가입된 회원입니다\n");
                    System.out.println("회원 정보창으로 이동하여 로또를 구매하여주십시오");
                    membershipGuide();
                }
            } else if (answer.equals("2") || answer.equals("아니요")) {
                System.out.println("\n[ERROR] 회원이 아니면 로또를 구매할 수 없습니다.");
                System.exit(0);
            } else if (answer.equals("3") || answer.equals("회원 정보열람")) {
                if (isDataEntered){ // 회원 정보가 있는지 검증함
                    persondata();
                    System.out.println("[INFO]로또를 구매하시겠습니까?\n[1]예 [2]아니오");
                    answer2 = sc.next();
                    if (answer2.equals("1") || answer2.equals("예")) {
                        p.purchaseQuestion();
                    } else if (answer2.equals("2") || answer2.equals("아니오")) {
                        System.exit(0);
                    }

                } else { // 없으면 에러 출력
                    System.out.println("\n[ERROR] 회원 정보가 입력되지 않았습니다.");
                    System.out.println("[INFO] 메인 메뉴로 돌아갑니다.");
                    membershipGuide(); // 메인 메뉴로 자동으로 돌아감
                }
            } else if (answer.equals("4") || answer.equals("로또 당첨금액")) {
                System.out.println("\n현재 로또 당첨 금액은:50억원 입니다");
                if (isDataEntered){
                    System.out.println("회원가입이 이미 완료된 유저입니다.");
                    p.purchaseQuestion();
                } else {
                    System.out.println("회원가입이 완료되지 않은 유저입니다.");
                    System.out.println("[INFO] 메인 메뉴로 돌아갑니다.");
                    membershipGuide(); // 메인 메뉴로 자동으로 돌아감
                }
            } else {
                System.out.println("\n[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
            }

        }

    }

    public void personalData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=================================================================\n");
        System.out.println("[INFO] 회원가입을 위해 아래의 양식을 채워주세요.\n");

        System.out.print("* 이름 : ");
        this.name = sc.next();


        // 미성년자는 가입할 수 없다.
        // 생년월일은 조건에 맞지 않으면 다시 입력을 해야된다.
        int personalYYnum = 0;
        int personalMMnum = 0;
        int personalDDnum = 0;

        // 입력하는 연도가 올해를 넘기지 않게 만든다.
        Calendar cal = Calendar.getInstance();
        int yy = cal.get(Calendar.YEAR);

        for (; ; ) {

            System.out.print("* 태어난 연도 : ");
            this.personalYY = sc.next();

            personalYYnum = Integer.parseInt(personalYY);


            if (personalYYnum == yy || personalYYnum > yy - 20 && personalYYnum < yy) {
                System.out.println("[ERROR] 미성년자는 로또를 구매할 수 없습니다."
                        + "\n회원가입이 종료됩니다.");
                System.exit(0);
            } else if (personalYYnum < 1900 || personalYYnum > yy) {
                System.out.println("[ERROR] 잘못된 입력입니다."
                        + "\n태어난 연도를 다시 입력해주세요.\n");
            } else {
                break;
            }


        }

        for (; ; ) {

            System.out.print("* 태어난 월 : ");
            this.personalMM = sc.next();

            personalMMnum = Integer.parseInt(personalMM);

            if (personalMMnum == 0 || personalMMnum > 12) {
                System.out.println("[ERROR] 잘못된 입력입니다."
                        + "\n태어난 월을 다시 입력해주세요.\n");
            } else {
                break;
            }
        }

        // 입력한 월에 따른 일의 변화
        dataprinter.printdatetime(cal);
        cal.set(Calendar.DAY_OF_MONTH, personalMMnum);
        int day_count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (; ; ) {

            System.out.print("* 태어난 일 : ");
            this.personalDD = sc.next();

            personalDDnum = Integer.parseInt(personalDD);

            if (personalDDnum == 0 || personalDDnum > day_count + 1) {
                System.out.println("[ERROR] 잘못된 입력입니다."
                        + "\n태어난 일을 다시 입력해주세요.\n");
            } else {
                break;
            }

        }

        System.out.print("* 주소 : ");
        this.address = sc.next();

        System.out.print("* 결제 비밀번호 : ");
        sc.nextLine(); // next() 오류 방지
        this.pw = sc.next();
        this.isDataEntered = true;

        System.out.println("\n[INFO] 회원가입이 완료되었습니다.");


        System.out.println("\n=================================================================");

    }
    public void persondata() {
        System.out.println(name +"님의 가입정보\n"
                + "이름:"+name+"\n 생년월일:"+personalYY+"년"+personalMM+"월"+personalDD+"일\n"
        + "주소:" + address);
    }
}