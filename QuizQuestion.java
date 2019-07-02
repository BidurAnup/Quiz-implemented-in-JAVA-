public abstract class QuizQuestion
{
   private String question;
   private String correctAnswer;

   // Every methods are too simple hope no need to comment in each of them
   public QuizQuestion(String question, String answer)
   {
      this.question = question;
      this.correctAnswer = answer;
   }
   public abstract QuizAnswer administer();

   public String getQuestion()
   {
      return question;
   }
   public String getCorrectAnswer()
   {
      return correctAnswer;
   }

   public String toString()
   {
      return question;
   }
}
