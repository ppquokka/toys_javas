import java.util.Scanner;

public class MaxMins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("A값을 입력하세요 : " );
        int A = in.nextInt();
        System.out.print("B값을 입력하세요 : " );
        int B = in.nextInt();

        int Middle = (A + B)/2 ;

        System.out.print("중간값은 " + Middle + " 입니다." );
        

    }
}
