
public abstract class QuizAnswer
{
   private QuizQuestion quizQuestion;
   private String userAnswer;
   private char result;

   public QuizAnswer(QuizQuestion question, String userAnswer, char result)
   {
      this.quizQuestion = question;
      this.userAnswer = userAnswer;
      this.result = result;
   }

   public char getResult()
   {
      return result;
   }

   public String toString()
   {
      return quizQuestion + "You answer is: " + userAnswer + "\nIt is " + ((result == 'C')? "": "in" ) + "correct."; // I have written explanatory toString method in each quizQuestion classes
   }
}
