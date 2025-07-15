package startcode;
/*
 * Author: Stanley Pieda
 * Date: Nov 28, 2020
 * Description: Initial orange-juice making program, with array.
 */
import java.util.Random;

public class MakeOrangeJuice{
    public static void main(String[] args){
        Random random = new Random();
        Orange[] oranges = new Orange[10];
        // Make a mixed orange juice at random
        for(int index = 0; index < oranges.length; index++){
            if(random.nextInt(2) == 0){ // (2) is zero or one
                oranges[index] = new Orange("Big Orange", random.nextInt(8) + 1);
            }
            else{
                oranges[index] = new Orange("Tangerine", random.nextInt(8) + 1);
            }
            System.out.println(oranges[index].createReport());
        }
    }
}