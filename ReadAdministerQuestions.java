import java.util.*;
import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;

// If asked why all three programs/methods execute without asking, add if
// statements. "Do you want to check the test?" "Do you want to administer the
// test?" "Do you want to display the result?" using scanner(System.in)

public class ReadAdministerQuestions
{
   public static void main(String [] args) throws Exception
   {
      ArrayList<QuizQuestion> questionArray = new ArrayList<QuizQuestion>();//array to stroe all the questions 
      ArrayList<QuizAnswer> answerArray = new ArrayList<QuizAnswer>();// array to store all the administered questions and user answers

      Scanner in = new Scanner(new File("questions.txt"));

      while(in.hasNext())
      {
         //read letter
         String line = in.nextLine().trim();

         if(line.equalsIgnoreCase("T"))
         {
            questionArray.add(TrueFalseQuestion.readQuestion(in)); // question object is added to the question array
            // call readQuestion method
            // call the administer method now
         }

         else if(line.equalsIgnoreCase("W"))
         {
            questionArray.add(WordQuestion.readQuestion(in));
            // create wordType question object
         }

         else//if(line.equalsIgnoreCase("M"))
         {
            questionArray.add(MultipleChoiceQuestion.readQuestion(in));
            //create multiple Choice question object
         }
      }
   
      // Method to check if all the questions and answeres are correctly read
      System.out.println("**************VERIFYING THE CORRECTNESS OF TEST*****************");
      int countTwo = 1;
      for(QuizQuestion q: questionArray)
      {
         System.out.println("QUESTION " + countTwo++); 
         System.out.println(q);
      }

      // Method to administer test
      System.out.println("Task 2: Q2:************** ADMINISTER TEST******************* : ");
      int count = 1;
      for(QuizQuestion q: questionArray)
      {  
         System.out.println("\nQUESTION " + count++);
         QuizAnswer  administeredAnswer = q.administer();
         answerArray.add(administeredAnswer);
      }

      // Method to Display the test result
      System.out.println("\n\n\nTask 2: Question3:*********** DISPLAYING RESULTS WITH CORRECT ANSWERS*****************");
      int countThree = 1;
      for(QuizAnswer ans: answerArray )
      {
         System.out.println("\nQUESTION " + countThree++);
         System.out.println(ans);
      }
   }
}
