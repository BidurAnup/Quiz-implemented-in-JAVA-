import java.util.*;
public class WordQuestion extends QuizQuestion
{
   private boolean caseSensitive;

   public WordQuestion(String question, String answer, boolean caseSensitive)
   {
      super(question, answer);   
      this.caseSensitive = caseSensitive;
   }

   public static WordQuestion readQuestion(Scanner in) throws Exception
   {
      boolean caseSensitive = false;
      String question = in.nextLine().trim();
//      String answerSentence = in.nextLine().trim();
      ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(in.nextLine().trim().split("//")));
      // tokens =  in.nextLine().trim().split("//");
      String answer = tokens.get(0).substring(2);

      if(tokens.get(tokens.size()-1).equals("CS"))
      {
         caseSensitive = true;
      }

      in.nextLine(); // consumes line with .

      WordQuestion WQ = new WordQuestion(question, answer, caseSensitive);
      return WQ;
   }


   public WordAnswer administer()
   {  
      String question = getQuestion();
      Scanner answerEntered = new Scanner(System.in);
      System.out.print(question + "\n" + "Type your answer: ");
      String input = answerEntered.nextLine();

      char result;
      if (!caseSensitive)
      {
         if(input.equalsIgnoreCase(getCorrectAnswer()))
         {
            result = 'C';
         }
         else
         {
            result = 'I';
         }
      }

      else
      {
         if(input.equals(getCorrectAnswer()))
         {
            result = 'C';
         }
         else
         {
            result = 'I';
         }
      }
      WordAnswer ansOne = new WordAnswer( this , input, result);

      return ansOne ;
   }

   public boolean getCaseSensitive()
   {
      return caseSensitive;
   }

   public String toString()
   {
      return getQuestion() + "\n" + "Correct Answer: " +  getCorrectAnswer() + "\n" + "Answer is " +((getCaseSensitive())?" ": "not ") + "Case Sensitive \n";
   }
}
