import java.util.*;

public class MultipleChoiceQuestion extends QuizQuestion
{
   private ArrayList<String> choices;
   private int numberOfChoices;

   public static MultipleChoiceQuestion readQuestion(Scanner in)
   {
      String question = in.nextLine().trim();

      ArrayList<String> choices = new ArrayList<String>();
      int count = 0;
      String answer = "";
      for(int i = 0; i <= 10; i++)
      {
         String line = in.nextLine().trim();
         if(line.equals("."))//checking if the multiple choice question is finished
         {
            break;
         }
         if(line.charAt(0) == '+')//checking if the choice is one of the correct answer/choice
         {
            answer += (char)('a'+count);
         }

         String processedChoice = (char)('a' + count)+ ") " + line.substring(2); //Taking off the + and space and adding alphabets    
         choices.add(processedChoice);//add choices with a), b) and without + - to answerChoices array
         count++;
      }

      return new MultipleChoiceQuestion(question, choices, answer, choices.size());
   }

   public MultipleChoiceQuestion(String question, ArrayList<String> choices, String answer, int noChoices) // No use of noChoices anywhere when using ArrayList?
   {
      super(question, answer);
      this.choices = choices;
      this.numberOfChoices = noChoices;
   }

   public MultipleChoiceAnswer administer()
   {
      String question = getQuestion();// quizQuestion is just a question taken from quizQuestion object. It is not the object itself.
      Scanner answerEntered = new Scanner(System.in);
      System.out.println(question);
      //int count = 0;
      for (String c: choices )
      { 
         System.out.println(c);//Displying the choices 
         //count++;
      }
      System.out.print("Type in a string of letters from a to d (in alphabetical order): ");

      String input = answerEntered.nextLine().trim();

      char result;
      if(input.equals(getCorrectAnswer())) // Verifying result
      {
         result = 'C';
      }
      else
      {
         result = 'I';
      }

      MultipleChoiceAnswer ansMCQ = new MultipleChoiceAnswer(this, input,result);   
      return ansMCQ;
   }

   public String toString()
   {
      int count = 0;
      String choicesProcessed = "";//choicesProcessed not same as above. done just to concatenate and display
      for (String c: choices)
      {
         choicesProcessed += c + "\n"; //(char)('a'+ count++) + ")" + c.substring(2) + "\n"; 
      }
      return getQuestion() + "\n" + choicesProcessed  +  "Correct Answer/s: " +getCorrectAnswer() + "\n";
   }
}
