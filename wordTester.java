import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;


public class wordTester
{
   public static void main(String[] args) throws Exception
   {
      Scanner in = new Scanner(new File("word.txt"));

      WordQuestion q1 =  WordQuestion.readQuestion(in);

      QuizAnswer ansW =  q1.administer();
      System.out.println(ansW);
   }
}

