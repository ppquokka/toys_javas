import polls.PollInitailArrays;
import polls.PollScanners;
import polls.PollStatistics;
import java.util.Scanner;

public class PollsWithMethod {
    public static void main(String[] args) {
        try {
            // 객체 생성
            Scanner myObj = new Scanner(System.in);
            // 변수 선언 (초기화)
            
            String answer = "";
            String[] answers = {"", "", "", ""};
            
            PollInitailArrays pollInitailArrays = new PollInitailArrays();
            String[][] initail = pollInitailArrays.init();
            System.out.println(initail.length);
            
            // 설문 출력 & 답안 입출력 & 범위내의 숫자를 입력 (입출력)
            
            PollScanners pollScanners = new PollScanners();
            int pollscan = pollScanners.();
            System.out.println(pollscan);

            // 입력값을 프린트아웃 (통계)

            PollStatistics pollStatistics = new PollStatistics();
            int stat = pollStatistics.statistic();
            System.out.println(stat);

        } catch (Exception e) {
            // TODO: handle exception
        }
        
        // return 0;
    }
}
