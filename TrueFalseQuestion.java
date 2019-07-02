import java.util.*;
//import util.Scanner.*;

public class TrueFalseQuestion extends QuizQuestion
{

   public TrueFalseQuestion(String question, String answer)
   {
      super(question, answer);
   }

   public static TrueFalseQuestion readQuestion(Scanner in) throws Exception
   {
         String question = in.nextLine().trim();
         String tokens = in.nextLine().trim();
         String answer = tokens.substring(2);
         in.nextLine();// Consume .
         TrueFalseQuestion TFQ = new TrueFalseQuestion(question, answer);
         return TFQ;
   }

   public TrueFalseAnswer administer()
   {
      String question = getQuestion(); // It is a string of question not the question object
      Scanner answerEntered = new Scanner(System.in);
      System.out.print(question + "\nType true or false: ");
      String input = answerEntered.nextLine();
      char result;
      if(input.equals(getCorrectAnswer())) 
      {
         result = 'C';
      }
      else
      {
         result = 'I';
      }

      TrueFalseAnswer ansTF = new TrueFalseAnswer(this, input, result);

      return ansTF;
   }

   public String toString()
   {
      return getQuestion() + "\n" + "Correct Answer: " +  getCorrectAnswer() + "\n";
   }
}
