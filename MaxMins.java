import java.util.Scanner;

// min값을 출력하는 SKY입니다.
public class MaxMins {
    public static void main(String[] args) {
        try {
            Scanner myObj = new Scanner(System.in); //값은 외부에서 입력받겠습니다. 스캔과 변수는 SKY 코드

            System.out.println("첫번째 값을 입력하세요"); //스캐너로 number1값 입력받기
            int number1 = myObj.nextInt();

            System.out.println("두번째 값을 입력하세요"); //스캐너로 number2값 입력받기
            int number2 = myObj.nextInt();

            if (number1 > number2) {  //입력받은 값을 비교해 작은 값을 출력합니다.
                System.out.println("최소값은 " + number2 + "입니다.");
            } else {
                System.out.println("최소값은 " + number1 + "입니다.");
            }
    
            int Middle = (number1 + number2)/2 ; //Goni의 입력받는 변수 A,B를 SKY가 number1,2로 바꿈
    
            System.out.println("중간값은 " + Middle + " 입니다." ); //Goni의 코드 middle값 구하기

           
            if (number1 > number2){
            System.out.println( "최대값은 " + number1 +" 입니다.");  //Max 값 산출  
            } else{
            System.out.println( "최대값은 " + number2 +" 입니다.");    
            }            
        } catch (Exception e) {
            // TODO: handle exception
        } 
        // return 0;
    }
}
