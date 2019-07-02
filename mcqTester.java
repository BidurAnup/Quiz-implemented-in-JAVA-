import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;


public class mcqTester
{
   public static void main(String[] args) throws Exception
   {
      Scanner in = new Scanner(new File("mcq.txt"));

      MultipleChoiceQuestion q1 =  MultipleChoiceQuestion.readQuestion(in);

      QuizAnswer ansMCQ =  q1.administer();
      System.out.println(ansMCQ);
   }
}
