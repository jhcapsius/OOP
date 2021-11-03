# OOP Exercises
  
  
  
## Sheet 1

### Task 1 (a) a^b - Error in the program (Solution in Power.java)

Given the following Java program, which contains some syntactical and content errors.
Correct these errors, and implement the class and method correctly.Test your solution.
Note: Pay attention not only to syntactic correctness, but also to semantic correctness. 
I.e. make sure not only that the program can be executed, but also that the program does 
what it is supposed to do (the calculation of a^b).

```public Class Power{

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
  
  
### Task 1 (b) Quadratic equation (Solution in CalcZeropoints.java)

Write a method berechneNullstellen() that computes the zeros of the quadratic equation ax2+bx+c=0. 
Output the solution to four decimal places in the console. The zeros are determined by the 
following formula :  
![Formula](https://i.gyazo.com/6fb139baa01ffa90f1a78813cc394b4c.png)

Use the Math.sqrt() function from the Math class to calculate the root. Output only real solutions, 
i.e. no solutions where the root is less than zero.
  
_________________________________________________________________________________________________________________________
  
  
### Task 1 (c) GuessingGame (Solution in GuessingGame.java)

Program a guessing game inside a method rateNumber(). The program initially generates an int random 
number between 0 and 100. Then the user should try to guess this number. The program outputs in each 
case whether the number entered by the user is too large, too small, or correct. In the latter case the 
program shall stop and output the number of guessing attempts output.

For random number calculation, use the Math.random command, which generates double random numbers between 
0.0 (inclusive) and 1.0 (exclusive).

```
int randomNumber = (int)(Math.random() * 101.0); 
```

The input of the numbers via the console is done by the function nextInt() from the class scanner. This must 
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
  
  
  
_________________________________________________________________________________________________________________________
  
  
  
  
## Sheet 2

### Task 2 (a) (Solution in Sanduhr.java)

Implement a method printSanduhr(int width) that prints an hourglass in the console. output. The size is to be specified 
by the width parameter. This sets the width of the first line in number of characters, where in each line the number of 
characters decreases or and indented accordingly (see examples). 
Test your program for width=3,4,9. The method should work for any value of width.

Examples: witdh = 3, width = 4, width = 5

```
***    ****      *****
 *      **        ***
***    ****        *
                  ***
                 ***** 
```


_________________________________________________________________________________________________________________________
  
  
### Task 2 (b)   

In this task, a program is to be developed that generates random arithmetic problems with two operands. The operands are 
in the range [1,20]. As operators for each task a random selection of the four basic arithmetic operations +,-,*,/.

First, design a class diagram for a class CalculationQuiz, whose objects generate random arithmetic tasks and provide correct 
results for them. Use the notation from the from the lecture. Then implement your class and test it. Use a separate test class.
The class RechenQuiz should be able to be used as follows:
  
```Rechenquiz quiz = new Rechenquiz();
quiz.getExercised;
int result = quiz.getResult();
System.out.println("Result: " + result);
```
  
Notes:
-The program creates a new task each time the getExercise() function is called.  
-The getExercise()function outputs the generated task to the console as follows:  
 Operand1 Operator Operand2 = ?  
 Examples: 13 * 8 = ? , 5 / 7 = ? , 20 + 1 = ?  
-A task is valid if the result is greater than 0. Invalid tasks are discarded in the function getExercise(), and a new random   
task is created directly before the before the method ends.  
  
  
  
_________________________________________________________________________________________________________________________
  
  
  
  
## Sheet 3

tbd