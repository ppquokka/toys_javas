package terminalpolls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class PollsWithMethod {
    private String[] answers;
    private boolean pollInProgress; // 설문 진행 중인지 여부를 나타내는 변수

    public PollsWithMethod(String[] answers) {
        this.answers = answers;
        this.pollInProgress = false;
    }

    public static void main(String[] args) {
        PollsWithMethod pollList = new PollsWithMethod(new String[] { "1", "2", "3", "4" });
        pollList.run();
    }

    public void run() {
        try {
            // MySQL workbench 실행: JDBC
            // User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://127.0.0.1:3306/db_b";
            String user = "root";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공!");

            Statement statement = connection.createStatement();
            String query = "";

            Scanner scanner = new Scanner(System.in);
            String workKey = "P";
            while (!workKey.equals("E")) {
                System.out.print("선택 입력: ");
                workKey = scanner.nextLine();
                if (workKey.equals("P")) {
                    if (pollInProgress) { // 설문이 이미 진행 중인 경우
                        System.out.println("-- 설문이 이미 진행 중입니다. 이전 설문 내용이 삭제됩니다.");
                    } else {
                        System.out.println("- 설문자 가능 명단(가입 완료)");
                        query = "SELECT USER_NAME FROM USER";
                        ResultSet resultSet = statement.executeQuery(query);

                        int number = 1;
                        HashMap<Integer, String> userIdMap = new HashMap<>();
                        while (resultSet.next()) {
                            String userName = resultSet.getString("USER_NAME");
                            userIdMap.put(number, userName);
                            System.out.println(number + ". " + userName);
                            number++;
                        }

                        System.out.print("- 설문자 번호 입력: ");
                        int pollNumber;
                        while (!scanner.hasNextInt()) {
                            System.out.println("- Error - 숫자를 입력해야 합니다.");
                            System.out.print("- 설문자 번호 입력: ");
                            scanner.nextLine();
                        }
                        pollNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (userIdMap.containsKey(pollNumber)) {
                            String selectedUser = userIdMap.get(pollNumber);
                            System.out.println("-- 설문 시작: " + selectedUser);
                            pollInProgress = true; // 설문 진행 중 표시
                            // 설문 시작 후 처리할 내용 추가

                            query = "SELECT * FROM QUESTION";
                            ResultSet resultSet2 = statement.executeQuery(query);
                            int num = 1;

                            Statement statement2 = connection.createStatement();
                            ResultSet resultSet3;
                            String query2;
                            HashMap<String, String> questionNumMap = new HashMap<>();
                            while (resultSet2.next()) {
                                System.out.println(num + ". " + resultSet2.getString("QUESTION"));
                                String answerId = resultSet2.getString("QUESTION_ID");
                                questionNumMap.put(String.valueOf(num), answerId);

                                query2 = "SELECT ANSWER FROM answer";
                                resultSet3 = statement2.executeQuery(query2);
                                while (resultSet3.next()) {
                                    System.out.println(resultSet3.getString("ANSWER"));
                                }
                                System.out.print("답) ");
                                int answer;
                                while (!scanner.hasNextInt()) {
                                    System.out.println("- Error - 숫자를 입력해야 합니다.");
                                    System.out.print("답) ");
                                    scanner.nextLine();
                                }
                                answer = scanner.nextInt();
                                scanner.nextLine();
                                num++;
                                System.out.println();
                            }
                            pollInProgress = false; // 설문 종료 표시
                        } else {
                            System.out.println("- Error - 확인 후 입력 필요");
                        }
                    }
                } else if (workKey.equals("S")) {
                    System.out.println("- 통계 시작 -");
                    query = "SELECT sq.*, ans.answer " +
                            "FROM (SELECT su.*, q.QUESTION " +
                            "      FROM (SELECT sur.*, user.user_name " +
                            "            FROM survey AS sur " +
                            "                     INNER JOIN USER " +
                            "                                ON sur.user_id = user.user_id) AS su " +
                            "               INNER JOIN question AS q " +
                            "                          ON su.QUESTION_ID = q.QUESTION_ID) AS sq " +
                            "         INNER JOIN answer AS ans " +
                            "                    ON sq.ANSWER_ID = ans.ANSWER_ID";

                    ResultSet resultSet = statement.executeQuery(query);
                    int totalRespondents = answers.length;
                    System.out.println("-- 총 설문자: " + totalRespondents + "명");

                    System.out.println("-- 문항 내에 가장 많이 답한 갯수 번호의 최대값 산출");
                    for (int i = 1; i <= 4; i++) {
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
                    System.out.println("--- 작업 키 확인: 입력한 값: " + workKey);
                }
            }

            System.out.println("----- 작업 종료 ------");
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