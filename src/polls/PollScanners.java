package polls; // 답항 입력 묶음

import java.util.Scanner;

public class PollScanners { // class scanner
    public int scanner(int first) {
        int second = 0;
        try {
                Scanner myObj = new Scanner(System.in);
                System.out.println(">이름을 입력하세요"); // 이름 입력요청
                String Fix = "이름) "; // 이름 출력
                String UserName = myObj.nextLine();
                System.out.println(Fix + UserName);
                String answer = "";
                String[] answers = { "", "" };
                String[][] polls = {
                        { "1. 교수는 수업 전 강의 목표를 명확히 제시하였습니까?" },
                        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우그렇다.", "-답은 한가지만 선택가능" },
                        { "2. 강의의 내용은 체계적이고 성의있게 구성되었는가?" },
                        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우그렇다.", "-답은 한가지만 선택가능" },
                        { "3. 교수는 강의 내용에 대해 전문적 지식이 있었는가?" },
                        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우그렇다.", "-답은 한가지만 선택가능" },
                        { "4. 강의 진행 속도는 적절하였는가?" },
                        { "(1) 전혀 아니다.", "(2) 아니다.", "(3) 그렇다.", "(4) 매우그렇다.", "-답은 한가지만 선택가능" },
                };
                int QNumb = 0; // 질문할 문항 값
                for (int Qfirst = 0; Qfirst < polls.length; Qfirst = Qfirst + 2) {
                    System.out.println(polls[Qfirst][0]); // 답항 출력
                    System.out.print("답하기 : ");
                    answers[QNumb] = myObj.nextLine();
                    QNumb = QNumb + 1;
                    System.out.println();
                }

            } catch (Exception e) {
                // TODO: handle exception
            }
            // return 0;
        return second;
    }
}