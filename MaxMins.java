import java.util.Scanner;

public class MaxMins {
    public static void main(String[] args) {
        try {
            Scanner myObj = new Scanner(System.in); //스캔과 변수는 SKY 코드

            System.out.println("number1을 입력하세요."); //스캐너로 number1값 입력받기
            int number1 = myObj.nextInt();

            System.out.println("number2을 입력하세요."); //스캐너로 number2값 입력받기
            int number2 = myObj.nextInt();

            if (number1 > number2) {  //min값 구하기
                System.out.println("최소값은" + number2 + "입니다.");
            } else {
                System.out.println("최소값은" + number1 + "입니다.");
            }
    
            int Middle = (number1 + number2)/2 ; //Goni의 입력받는 변수 A,B를 SKY가 number1,2로 바꿈
    
            System.out.print("중간값은 " + Middle + " 입니다." ); //Goni의 코드 middle값 구하기
        
        } catch (Exception e) {
            // TODO: handle exception
        }
        // return 0;
        


    }
}
