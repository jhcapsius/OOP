# Sheet 1

## Task 1 (a) a^b - Error in the program (Solution in Power.java)

Given the following Java program, which contains some syntactical and content errors.
Correct these errors, and implement the class and method correctly. Test your solution.
Note: Pay attention not only to syntactic correctness, but also to semantic correctness. 
I.e. make sure not only that the program can be executed, but also that the program does 
what it is supposed to do (the calculation of a^b).

```
public Class Power{

    public static void main(String [] args){
        integer a = 2
        integer b = 4
        //calculate a to the power of b (a^b)
        integer result = 0;
        repeat (integer i < b){
            result * a;
        }
        //output result of 2^4
        println(result)
    }
}

```
  
  
_________________________________________________________________________________________________________________________
  
  
## Task 1 (b) Quadratic equation (Solution in CalcZeropoints.java)

Write a method *berechneNullstellen()* that computes the zeros of the quadratic equation ax2+bx+c=0. 
Output the solution to four decimal places in the console. The zeros are determined by the 
following formula :  
![Formula](https://i.gyazo.com/6fb139baa01ffa90f1a78813cc394b4c.png)

Use the *Math.sqrt()* method from the Math class to calculate the root. Output only real solutions, 
for example no solutions where the root is less than zero.
  
_________________________________________________________________________________________________________________________
  
  
## Task 1 (c) GuessingGame (Solution in GuessingGame.java)

Program a guessing game inside a method *rateNumber()*. The program initially generates an int random 
number between 0 and 100. Then the user should try to guess this number. The program outputs in each 
case whether the number entered by the user is too large, too small, or correct. In the latter case the 
program shall stop and output the number of guessing attempts output.

For random number calculation, use the Math.random command, which generates double random numbers between 
0.0 (inclusive) and 1.0 (exclusive).

```
int randomNumber = (int)(Math.random() * 101.0); 
```

The input of the numbers via the console is done by the method *nextInt()* from the class scanner. This must 
first be imported with import java.util.Scanner;

```Scanner sc = new Scanner(System.in);
int readInt = sc.nextInt();
```

Example of program flow (user input in <>):  
Number: <50>  
Random number is smaller!  
Number: <25>  
Random number is bigger!  
Number: <37>  
Random number is bigger!  
Number: <45>  
Random number is bigger!  
Number: <48>  
Done! Random number was 48  
Number of tries = 5  