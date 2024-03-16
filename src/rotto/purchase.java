package rotto;
import java.util.Scanner;

import javax.xml.namespace.QName;

public class purchase {
    private static purchase p;
    private purchase() {
        // private 생성자로 외부에서 인스턴스 생성을 방지합니다.
    }
    private Membership m;
    public static purchase getInstance() {
        if (p == null) {
            p = new purchase();
        }
        return p;
    }
    public static void freeInstance(){
        p = null;
    }

    public static int[] customeNum = new int[6]; // 각각의 로또 번호를 저장할 배열

    public void purchaseQuestion(){
        Membership m = Membership.getInstance();

        Scanner sc = new Scanner(System.in);

        System.out.println("\n[INFO]" + m.name + "님, 안녕하세요."
                + "\n로또를 구매하시겠습니까?"
                + "\n[1] 예 \t [2] 아니요");
        Membership.getInstance().isDataEntered = true;
        String answer = "";
        for(;;) {
            System.out.print("\n입력 : ");
            answer = sc.next();

            boolean purchaseCompleted = false;
            if(answer.equals("1") || answer.equals("예")) {
                letsLottery();
                System.out.println("\n=================================================================");
                purchaseCompleted = true;
                break;
            }else if(answer.equals("2") || answer.equals("아니요")){
                System.out.println("\n[ERROR] 로또 구매가 종료되었습니다.");
                System.out.println("[INFO] 메인 메뉴로 돌아갑니다.");
                m.membershipGuide();
            }else {
                System.out.println("\n[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
            }

        }
    }


    public void letsLottery() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n[INFO] 1에서 45까지의 수로 총 6개의 로또 번호를 입력해주세요.");

        // 각 숫자를 따로 저장
        for (int i = 0; i < 6; i++) {
            int num = 0;
            for (;;) {
                System.out.print((i+1) + "번째 번호 입력 : ");
                num = Integer.parseInt(sc.next());
                if (num < 1 || num > 45) {
                    System.out.println("1부터 45까지의 숫자를 입력해주세요.");
                } else {
                    customeNum[i] = num; // 입력된 숫자를 배열에 저장
                    break;
                }
            }
        }

        System.out.print("\n[INFO] 입력하신 번호는");
        for (int i = 0; i < 6; i++) {
            System.out.print(" [" + customeNum[i] + "]");
        }
        System.out.println(" 입니다.");

        System.out.println("\n입력하신 번호로 로또 구매 진행하시겠습니까?"
                + "\n[1] 예 \t [2] 아니요");

        String answer = "";

        for(;;) {
            System.out.print("\n입력 : ");
            answer = sc.next();

            if(answer.equals("1") || answer.equals("예")) {
                order();
                break;
            }else if(answer.equals("2") || answer.equals("아니요")){
                System.out.println("\n[ERROR] 로또 구매가 종료되었습니다.");
                System.exit(0);
            }else {
                System.out.println("\n[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
            }

        }
    }

    public void order() {
        Membership m = Membership.getInstance();
        Scanner sc = new Scanner(System.in);

        String pw = "";

        for(;;) {
            System.out.println("\n[INFO] 결제 비밀번호를 입력해주세요.");
            System.out.print("입력 : ");
            pw = sc.next();

            if(pw.equals(m.pw)) {
                System.out.println("\n[INFO] 결제가 완료되었습니다.");
                System.out.println("\n[INFO] 3초 후에 로또 추첨이 진행됩니다.");
                break;
            }else {
                System.out.println("\n[ERROR] 결제 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            }
        }

    }

}