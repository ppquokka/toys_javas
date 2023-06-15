package terminalpolls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class PollPeople {
    public static void main(String[] args) {
        try {
            // - MySQL workbench 실행 : JDBC
            // - user, password와 접속  IP:port 접속
            String url = "jdbc:mysql://127.0.0.1:3306/db_b"; // 기존 MySQL 그대로 사용. DB만 변경(우선 DB_'이름'작성)
            String user = "root";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공!");

            // - Editor 띄우기
            Statement statement = connection.createStatement();
            String query = "";

            // 작동 키 입력
            Scanner scanner = new Scanner(System.in);
            String workKey = "P";
            while (!workKey.equals("E")) {
                System.out.print("선택입력 : ");
                workKey = scanner.nextLine();
                if (workKey.equals("P")) {
                    //- 설문자 가능 명단
                    System.out.println("- 설문자 가능명단(가입완료)");
                    query = "SELECT USER_NAME " +
                            "FROM USER";
                    ResultSet resultSet = statement.executeQuery(query);

                    int number = 1;
                    HashMap<Integer, String> userIdMap = new HashMap<>();
                    while (resultSet.next()) {
                        String userName = resultSet.getString("USER_NAME");
                        userIdMap.put(number, userName);
                        System.out.println(number + ". " + userName);
                        number++;
                    }

                    System.out.print("- 설문자 번호 입력 : ");
                    int pollNumber;
                    while (!scanner.hasNextInt()) {
                        System.out.println("-Error- 숫자를 입력해야 합니다.");
                        System.out.print("- 설문자 번호 입력 : ");
                        scanner.nextLine();
                    }
                    pollNumber = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 처리

                    if (userIdMap.containsKey(pollNumber)) {
                        String selectedUser = userIdMap.get(pollNumber);
                        System.out.println("-- 설문 시작");
                        // 설문 시작 후 처리할 내용 추가
                    } else {
                        System.out.println("-Error- 확인 후 입력 필요");
                    }
                    // 설문 시작 <<<<<<

                query = "SELECT * " +
                        "FROM QUESTION";
                ResultSet resultSet2 = statement.executeQuery(query);
                int num = 1;

                Statement statement2 = connection.createStatement();
                ResultSet resultSet3;
                String query2;
                HashMap<String, String> quetionnumMap = new HashMap<>();
                while (resultSet2.next()) {
                        System.out.print(num + ". " +
                        resultSet2.getString("QUESTION"));
                        String answerId = resultSet2.getString("QUESTION_ID");
                        quetionnumMap.put(String.valueOf(number), answerId);

                        query2 = "SELECT ANSWER\n" + //
                                "FROM answer\n";
                        resultSet3 = statement2.executeQuery(query2);
                        while(resultSet3.next()){
                        System.out.print(resultSet3.getString("ANSWER"));
                        }          
                     num = num +1;
                     System.out.println();
                        
                    }
                } else if (workKey.equals("S")) {


                } else {
                    System.out.println("--- 작업 키 확인 : 입력한 값 : " + workKey);
                }
            }
      

            System.out.println("----- 작업종료 ------");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage()); // error message print
        }
        System.out.println(); // 기본 형식이라고 생각되어 작성

     }
}
