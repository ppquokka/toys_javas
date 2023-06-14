package terminalpolls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PollStatistics {
    private String[] answers;

    public PollStatistics(String[] answers) {
        this.answers = answers;
    }

    public static void main(String[] args) {
        PollStatistics pollStatistics = new PollStatistics(new String[] { "2", "2", "3", "4" });
        pollStatistics.statistic();
    }

    public void statistic() {
        try {
            // MySQL workbench 실행: JDBC
            // User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://127.0.0.1:3306/db_b";
            String user = "root";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");

            // Query Edit
            Statement statement = connection.createStatement();
            String query = "";

            // 작업 키 입력
            Scanner scanner = new Scanner(System.in);
            System.out.println("작업 키를 입력하세요 (S: 통계 시작, P: 작업 종료):");
            String workKey = scanner.nextLine();

            if (workKey.equals("S")) {
                System.out.println("- 통계 시작 -");
                query = "SELECT sq.*, ans.answer\n" +
                        "FROM (SELECT su.*, q.QUESTION\n" +
                        "      FROM (SELECT sur.*, user.user_name\n" +
                        "            FROM survey AS sur\n" +
                        "                     INNER JOIN USER\n" +
                        "                                ON sur.user_id = user.user_id) AS su\n" +
                        "               INNER JOIN question AS q\n" +
                        "                          ON su.QUESTION_ID = q.QUESTION_ID) AS sq\n" +
                        "         INNER JOIN answer AS ans\n" +
                        "                    ON sq.ANSWER_ID = ans.ANSWER_ID";

                ResultSet resultSet = statement.executeQuery(query);
                int totalRespondents = answers.length;
                System.out.println("-- 총 설문자: " + totalRespondents + "명");

                System.out.println("-- 문항 내에 가장 많이 답한 갯수 번호의 최대값 산출");
                for (int i = 1; i <= answers.length; i++) {
                    int maxAnswerNum = getMaxAnswerNum(i);
                    System.out.println(i + ". " + getQuestion(i) + "\t--> " + maxAnswerNum);
                }

                System.out.println("-- 답항 중심");
                String[] answerOptions = { "(1)전혀 아니다.", "(2)아니다.", "(3)그렇다.", "(4)매우그렇다." };
                int[] answerCounts = countAnswerOptions();

                for (int i = 0; i < answerOptions.length; i++) {
                    if (answerCounts[i] != totalRespondents) {
                        System.out.println(answerOptions[i] + "\t--> " + answerCounts[i]);
                    }
                }
            } else {
                System.out.println("--- 작업 키 확인 : 입력한 값 : " + workKey);
            }
            System.out.println("----- 작업종료 ------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    private String getQuestion(int questionNum) {
        switch (questionNum) {
            case 1:
                return "교수는 수업 전 강의 목표를 명확히 제시하였습니까?";
            case 2:
                return "강의의 내용은 체계적이고 성의있게 구성되었는가?";
            case 3:
                return "교수는 강의 내용에 대해 전문적 지식이 있었는가?";
            case 4:
                return "강의 진행 속도는 적절하였는가?";
            default:
                return "Unknown Question";
        }
    }

    private int getMaxAnswerNum(int questionNum) {
        int maxAnswerNum = 0;
        for (String answer : answers) {
            int answerNum = Integer.parseInt(answer);
            if (answerNum == questionNum && answerNum > maxAnswerNum) {
                maxAnswerNum = answerNum;
            }
        }
        return maxAnswerNum;
    }

    private int[] countAnswerOptions() {
        int[] answerCounts = new int[4];
        for (String answer : answers) {
            int answerNum = Integer.parseInt(answer);
            answerCounts[answerNum - 1]++;
        }
        return answerCounts;
    }
}
