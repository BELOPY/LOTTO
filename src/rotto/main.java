package rotto;

public class main {

    static boolean purchaseCompleted = false;
    public static void main(String[] args) {
        ROTTORI isDataEntered1 = new ROTTORI();
        boolean dataEntered = isDataEntered1.isDataEntered1;

            // 환영인사 및 회원가입 진행 여부
            Membership m = Membership.getInstance();
            m.membershipGuide();
            // 회원가입을 한다.

            // 로또를 구매
            purchase p = purchase.getInstance();
            // 로또 구매 여부를 묻고 로또를 구매한다.
            p.purchaseQuestion();

            // 로또 추첨 로딩
            Loading l = new Loading();
            l.loading();

            // 로또 번호를 추첨한다.
            ROTTORI lt = new ROTTORI();

            // 랜덤으로 로또 번호를 생성한다.
            ROTTORI.generateLottoNumbers();

            // 당첨된 로또 번호를 출력한다.
            ROTTORI.lottorynum();

            // 당첨 결과를 출력한다.
            lt.result();
            if (ROTTORI.isDataEntered1) { // isDataEntered1 변수에 직접 접근
                Winning w = Winning.getInstance();
                w.Winning();
            }
        }
    }