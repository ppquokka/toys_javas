package PollsWithMethod.terminalpolls;
import java.util.Scanner;

public class answersanner {
   
    public static int[] getAnswers(int length, Scanner scanner) {
        int[] answers = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.println(PollInitailArrays.getQuestions()[i]);
            System.out.println("(1) 전혀 아니다. (2) 아니다. (3) 그렇다. (4) 매우 그렇다.");
            System.out.println();

            while (true) {
                System.out.print("답) ");
                int answer = scanner.nextInt();

                if (answer >= 1 && answer <= 4) {
                    answers[i] = answer;
                    System.out.println();
                    break;
                }
            }
        }

        return answers;
    }
}

    



