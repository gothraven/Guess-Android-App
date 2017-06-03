package guess.guess;

import java.util.Random;

import static android.R.attr.max;
import static java.lang.String.valueOf;

/**
 * Author by goth-raven
 * Date 03/06/17 04:59.
 */

public class Puzzle {
    private int values[];
    private String hints[];
    private int unknown;

    public Puzzle(int unknown){

        Random generator = new Random();

        //creating the values table and generating values
        this.values = new int[10];
        for (int i = 0; i <this.values.length ; i++) {
            this.values[i] = generator.nextInt(10);
        }
        this.values[0] = 0;

        if ((unknown > 0) && (unknown < 10)) this.unknown = unknown;
        else if ((unknown >= 10)) this.unknown = 9;
        else if ((unknown <= 0 )) this.unknown = 1;
        build_hints();
    }

    private void build_hints() {
        this.hints = new String[4];

        this.hints[0] = arePrimes()+"prime number(s)";
        this.hints[1] = areEven()+"even number(s)";
        this.hints[2] = biggest()+"is the biggest number";
        this.hints[3] = smallest()+"is the smallest number";
    }

    public String toString(){
        String puzzle = "";
        for (int i = 0; i < this.values.length ; i++) {
            if (i > 0 && i <= this.unknown) puzzle = puzzle + "X ";
            else puzzle = puzzle + String.valueOf(values[i]) + " ";
        }
        return puzzle;
    }


    public String getHints(){
        String hints = "";
        for (String hint: this.hints) {
            hints = hints + hint +"\n\n";
        }
        return hints;
    }

    private boolean isPrime(int value){
        for (int i = 2; i <value/2 ; i++) {
            if(value % i == 0)
                return false;
        }
        return true;
    }

    private String arePrimes(){
        String primes = "";
        for (int i = 1; i <this.unknown ; i++) {
            if(isPrime(this.values[i])){
                primes = primes + "X("+(i+1)+") ";
            }
        }
        if(primes.equals("")) {
            return "no ";
        }else {
            return primes;
        }
    }

    private String areEven(){
        String even = "";
        for (int i = 1; i <this.unknown ; i++) {
            if(this.values[i] % 2 == 0){
                even = even + "X("+(i+1)+") ";
            }
        }
        if(even.equals("")) {
            return "no ";
        }else {
            return even;
        }

    }

    private String biggest(){
        int max = this.values[1];
        int index = 1;
        for (int i = 1; i < this.unknown; i++) {
            if (this.values[i] > max) {
                max = this.values[i];
                index = i;
            }
        }
        return "X("+index+") ";
    }

    private String smallest(){
        int min = this.values[1];
        int index = 0;
        for (int i = 1; i < this.unknown; i++) {
            if (this.values[i] < min) {
                min = this.values[i];
                index = i;
            }
        }
        return "X("+index+") ";
    }
}
