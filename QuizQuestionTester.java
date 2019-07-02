import java.util.*;
import java.util.ArrayList.*;


public class QuizQuestionTester
{
   public static void main(String[] args)
   {  
      ArrayList<QuizQuestion> questionArray = new ArrayList<QuizQuestion>();//array to stroe all the questions
      ArrayList<QuizAnswer> answerArray = new ArrayList<QuizAnswer>();// array to store all the administered questions and user answers

      // Administers the test and displays the result of word question
      // WORD QUESTIONS
      questionArray.add( new WordQuestion("What is the key word to define constants?", "final", true));
      questionArray.add( new WordQuestion("ArithmeticException is a/an _____ exception. Fill in the blank.", "unchecked", false));
//TRUE FALSE QUESTION
      questionArray.add( new TrueFalseQuestion("A checked exceptioin must be caught or declared.", "true"));
      
      //MULTIPLE CHOICE QUESTIONS
      ArrayList<String> choices = new ArrayList<String>();// array to store choices for multiple choice questions
      choices.add("a) implements");
      choices.add("b) extends");
      choices.add("c) subclass");
      choices.add("d) interface");
      questionArray.add( new MultipleChoiceQuestion("What is the keyword used to declare a class to be a subclass of another class?", choices, "b", 4));
      
      ArrayList<String> choices2 = new ArrayList<String>();
      choices2.add("a) public");
      choices2.add("b) protected");
      choices2.add("c) package");
      choices2.add("d) private");
      choices2.add("e) local");
      questionArray.add( new MultipleChoiceQuestion("Which of the following are keywords to specify access level ?", choices2, "abd", 5));

      //******************ADMNISTERING THE TEST*************************
      System.out.println("******************ADMINISTERING TEST*****************");
      int countOne = 1;
      for(QuizQuestion question: questionArray)
      {  
         System.out.println("\nQUESTION " + countOne++);
         QuizAnswer administeredAnswer = question.administer();
         answerArray.add(administeredAnswer);
      }
      
      System.out.println("\n****************DISPLAYING RESULT**********************");
      int countTwo = 1;
      for(QuizAnswer a: answerArray)
      {
         System.out.println("\nQUESTION " + countTwo++);
         System.out.println(a);
      }
   }
}
