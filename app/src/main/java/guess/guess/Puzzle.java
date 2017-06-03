package guess.guess;

import java.util.Random;

/**
 * Author by goth-raven
 * Date 03/06/17 04:59.
 */

public class Puzzle {
    private int values[];
    private String hints[];

    public Puzzle(){
        Random generator = new Random();

        //creating the values table and generating values
        this.values = new int[10];
        for (int i = 0; i <this.values.length ; i++) {
            this.values[i] = generator.nextInt(10);
        }
        this.values[0] = 0;

        this.hints = new String[2];
        for (int i = 0; i <this.hints.length ; i++) {
            this.hints[i] = "this is the "+String.valueOf(i+1)+" hint";
        }
    }

    public String toString(){
        String puzzle = "";
        int i = 0;
        for (int value : this.values) {
            switch (i){
                case 4:
                    puzzle = puzzle + "A ";
                    break;
                case 5:
                    puzzle = puzzle + "B ";
                    break;
                case 6:
                    puzzle = puzzle + "C ";
                    break;
                case 7:
                    puzzle = puzzle + "D ";
                    break;
                default:
                    puzzle = puzzle + String.valueOf(value) + " ";
                    break;
            }
            i++;
        }
        return puzzle;
    }

    public String getHint(int i){ //this should be changed
        return this.hints[i];
    }

}
