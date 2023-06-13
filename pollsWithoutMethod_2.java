package toys_javas;

import java.util.Scanner;

public class pollsWithoutMethod_2 {
  public static void main(String[] args) {
    // 객체 생성
    Scanner sc = new Scanner(System.in);

    // 변수 선언
    String userName;
    String[][] QnA = {
        { "1. 교수는 수업 전 강의 목표를 명확히 제시하였습니까?" },
        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우 그렇다." },
        { "2. 강의의 내용은 체계적이고 성의있게 구성되었는가?" },
        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우 그렇다." },
        { "3. 교수는 강의 내용에 대해 전문적 지식이 있었는가?" },
        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우 그렇다." },
        { "4. 강의 진행 속도는 적절하였는가?" },
        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우 그렇다." } };
    int userAnswer;
    int[] totalAnswers = new int[QnA.length/2];
    int Cnt = 0;

    // 이름 입출력
    System.out.println("> 이름을 입력하세요.");
    System.out.print("이름) ");
    userName = sc.nextLine();
    System.out.println();

    // 설문 출력 & 답안 입출력
    for (int first = 0; first < QnA.length; first = first + 2) {
      System.out.println(QnA[first][0]);
      for (int second = 0; second < QnA[first+1].length; second = second + 1) {
        System.out.print(QnA[first + 1][second] + " ");
      }
      System.out.println(" -답은 한가지만 선택가능.");
      System.out.println();
      
    // 범위 내의 숫자를 입력하게 하기
    while (true) {
      System.out.print("답) ");
      userAnswer = sc.nextInt();
      if (userAnswer>=1 && userAnswer <= QnA[first+1].length) {
        totalAnswers[Cnt] = userAnswer;
        System.out.println();
        Cnt = Cnt + 1;
        break;
    }
      }
    }
    System.out.println("---------------------설문 종료--------------------------");
    System.out.println();
    System.out.println("---------------------설문 결과--------------------------");
    for (int Qnum = 0; Qnum < Cnt; Qnum = Qnum + 1) {
      System.out.print((Qnum + 1) + ".");
      System.out.print("(" + totalAnswers[Qnum] + ")");
      if (Qnum != Cnt - 1) {
        System.out.print(",  ");
      }
    }

    // return 0;
  };
}