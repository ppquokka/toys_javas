import java.util.Scanner;

public class MaxMins {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.print("A값을 입력하세요 : " ); 
            int A = in.nextInt(); //A값 받기
            System.out.print("B값을 입력하세요 : " );
            int B = in.nextInt(); //B값 받기
    
            int Middle = (A + B)/2 ; //중간값 펑션
    
            System.out.print("중간값은 " + Middle + " 입니다." ); 
        
        } catch (Exception e) {
            // TODO: handle exception
        }
        // return 0;
        
    }
}
