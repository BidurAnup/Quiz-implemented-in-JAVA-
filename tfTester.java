import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;


public class tfTester
{
   public static void main(String[] args) throws Exception
   {
      Scanner in = new Scanner(new File("tf.txt"));

      TrueFalseQuestion q1 =  TrueFalseQuestion.readQuestion(in);

      QuizAnswer ansTFQ =  q1.administer();
      System.out.println(ansTFQ);
   }
}

