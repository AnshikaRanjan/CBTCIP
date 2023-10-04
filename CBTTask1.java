package CBTTasks;
import java.util.*;
class Game{
    public int number;
    public int InputNumber;
    public int NoOfGuesses=0 ;

    public int getNoOfGuesses(){
        return NoOfGuesses;
    }
    public void setNoOfGuesses(int NoOfGuesses){
        this.NoOfGuesses= NoOfGuesses;
    }

    Game(){
        Random rand= new Random();
        this.number=rand.nextInt(100);
    }

    void TakeUserInput(){
        System.out.println("Guess the number: ");
        Scanner sc= new Scanner(System.in);
        InputNumber=sc.nextInt();
    }

    boolean IsCorrectNumber(){
        NoOfGuesses++;
        if(InputNumber==number){
            System.out.println("You guessed the answer in " + NoOfGuesses + " attempts.");
            return true;
        }
        else if(InputNumber<number){
            System.out.println("It is too Low");
        }
        else if(InputNumber>number){
            System.out.println("It is too High");
        }
        return false;
    }
}


public class CBTTask1 {
    public static void main(String[] args) {
        Game g= new Game();
        boolean b=false;
        while (!b) {
            g.TakeUserInput();
           b = g.IsCorrectNumber();
            System.out.println(b);
        }
    }
}
