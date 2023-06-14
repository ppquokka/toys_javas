package PollsWithMethod.terminalpolls;

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
            String url = "jdbc:mysql://127.0.0.1:3306/db_a"; // 기존 MySQL 그대로 사용. DB만 변경(우선 DB_'이름'작성)
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
                    HashMap<String, String> USER_ID = new HashMap<>();

                    while (resultSet.next()) {
                        System.out.print(number + "." + resultSet.getString("USER_NAME"));
                        number = number + 1;
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