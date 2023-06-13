package polls; 

public class PollStatistics {
  public String statistic (int Qnum){
    int count = 0;
    try {
         System.out.println("---------------------설문 종료---------------------");
         System.out.println("---------------------설문 결과---------------------");

         for (int first=0; first < answers.length; first = first + 1 ){
          System.out.print(answers[first]+",");
       }
          // 답항 출력
           System.out.print("답하기 : ");
           answers[count] = myObj.nextLine();
           count = count + 1;
          System.out.println();
      }
    } catch (Exception e) {
      // TODO: handle exception
     
  }
}
