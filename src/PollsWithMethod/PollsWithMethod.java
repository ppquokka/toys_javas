/* 아래 작성 사항 중 import 되어야 할 사항
 */


/*
 강사님이 말씀하신 작성방법 : '①하나의 파일로 작성' 또는 '② method(function)으로 작성'
 위 두 작성방법 중 ①로 우선 작성하였습니다 
 */

 
package PollsWithMethod;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class PollsWithMethod {
public static void main(String[] args) {
    try {
        // - MySQL workbench 실행 : JDBC
        // - user, password와 접속  IP:port 접속
        String url = "JDBC:MySQL://127.0.0.1:3306/DB_a";  // 기존 MySQL 그대로 사용. DB만 변경(우선 DB_'이름'작성)
        String user = "root";
        String password = "!yojulab*";
        
        Connection connection = DriverManager.getConnection(url, user, password);  
        System.out.println("DB연결 성공!"); 

        // - Editor 띄우기
        Statement statement = connection.createStatement();   
        String query = "";

        // 작동 키 입력
        Scanner scanner = new Scanner();
        String workKey = 




        } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e.getMessage());                  // error message print
    }
    System.out.println();                                    // 기본 형식이라고 생각되어 작성
}
}