# Sheet 2

## Task 2 (a) (Solution in Sanduhr.java)

Implement a method *printSanduhr(int width)* that prints an hourglass in the console. output. The size is to be specified 
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
  
  
## Task 2 (b)   

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
-The program creates a new task each time the *getExercise()* method is called.  
-The *getExercise()* method outputs the generated task to the console as follows:  
 Operand1 Operator Operand2 = ?  
 Examples: 13 * 8 = ? , 5 / 7 = ? , 20 + 1 = ?  
-A task is valid if the result is greater than 0. Invalid tasks are discarded in the method *getExercise()*, and a new random   
task is created directly before the before the method ends.  