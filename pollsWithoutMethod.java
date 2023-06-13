package toys_javas;
import java.util.Scanner;

public class pollsWithoutMethod {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String userName;
    String[][] QnA = {
        { "1. 교수는 수업 전 강의 목표를 명확히 제시하였습니까?", "2. 강의의 내용은 체계적이고 성의있게 구성되었는가?", "3. 교수는 강의 내용에 대해 전문적 지식이 있었는가?",
            "4. 강의 진행 속도는 적절하였는가?" },
        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우 그렇다." } };
    
    int userAnswer;
    int[] totalAnswers = new int[QnA[0].length];

    System.out.println("> 이름을 입력하세요.");
    System.out.print("이름) ");
    userName = sc.nextLine();
    System.out.println();
    for (int first = 0; first < QnA[0].length; first = first + 1) {
      System.out.println(QnA[0][first]);
      for (int second = 0; second < QnA[1].length; second = second + 1) {
        System.out.print(QnA[1][second] + " ");
      }
      System.out.println(" -답은 한가지만 선택가능.");
      System.out.println();
    
      System.out.print("답) ");
      userAnswer = sc.nextInt();
      totalAnswers[first] = userAnswer;
      System.out.println();
    }
    System.out.println("---------------------설문 종료--------------------------");
    System.out.println();
    System.out.println("---------------------설문 결과--------------------------");
    for (int first = 0; first < QnA[0].length; first = first + 1) {
      System.out.print((first+1)+". ");
      System.out.print("("+totalAnswers[first]+")");
      if (first!=QnA[0].length-1) {
        System.out.print(", ");
      }
    }

    // return 0;
  };
}