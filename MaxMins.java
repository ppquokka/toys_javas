import java.util.Scanner;

public class MaxMins {

  // Max() Method 생성
  public int Max(int x, int y) {
    int result = 0; // Max값 변수 선언

    try {
      if (x > y) {
        result = x;
      } else {
        result = y;
      }
    }

    catch (Exception e) {
      // TODO: handle exception
    }
    return result;

  }

  public int min(int A, int B) { // main에서 받은 값을 넣어 작은값을 찾아냄
    int result = 0;
    try {
        if (A<B) {
            result = A;
        } else if (B<A) {
            result = B;
        }
    } catch (Exception e) {
        // TODO: handle exception
    }
    return result; //결과인 작은값을 다시 main으로 보내줌
}

  // main
  public static void main(String[] args) {

    try {
      int MaxNumber = 0; // 결과값 변수 선언
      int first = 0; // 입력 받을 정수 변수 선언
      int second = 0; // 입력 받을 정수 변수 선언
      boolean loop = true; // while문 loop 변수 선언

      MaxMins mm = new MaxMins(); // Method Max() 호출

      Scanner sc = new Scanner(System.in); // 스캐너 호출

      while (loop) {
        System.out.print("정수 2개 입력: "); // 안내 문구
        first = sc.nextInt(); // 스캐너로 정수 입력받기
        second = sc.nextInt();

        if (first == second) { // 두 값이 같을 경우 다시 입력 받기
          System.out.println("※ 서로 다른 값을 입력하세요.");
        } else {
          MaxNumber = mm.Max(first, second); // result 값에 큰 수가 저장된다.
          loop = false;
        }

      }
      System.out.println("Max Number is: " + MaxNumber); // 결과 출력

      // Min 값 구하기
      
      MaxMins maxmins = new MaxMins();
      int result = maxmins.min(first, second); //입력된 값을 fuction min으로 보냄
      System.out.println("작은 값: " + result); //2개의 값 중 작은 값을 출력

    } catch (Exception e) {
      // TODO: handle exception
    }
    // return 0;
  }
}