package rotto;
import java.util.Scanner;

public class Winning {

    public static Winning getInstance() {

        return null;
    }
    Scanner sc = new Scanner(System.in);
    String answer = "";
    public void Winning() {
        System.out.println("로또에 당첨되신것을 축하드립니다!\n");
        System.out.println("로또를 판매 하시겠습니까?\n [1]예 [2]아니오");
        for(;;) {
            System.out.print("\n입력 : ");
            answer = sc.next();
        }


    }
}
