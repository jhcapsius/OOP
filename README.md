# OOP Exercises
  
  
  
## Sheet 1

### Task 1 (a) a^b - Error in the program (Solution in Power.java)

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
  
  
### Task 1 (b) Quadratic equation (Solution in CalcZeropoints.java)

Write a method *berechneNullstellen()* that computes the zeros of the quadratic equation ax2+bx+c=0. 
Output the solution to four decimal places in the console. The zeros are determined by the 
following formula :  
![Formula](https://i.gyazo.com/6fb139baa01ffa90f1a78813cc394b4c.png)

Use the *Math.sqrt()* method from the Math class to calculate the root. Output only real solutions, 
for example no solutions where the root is less than zero.
  
_________________________________________________________________________________________________________________________
  
  
### Task 1 (c) GuessingGame (Solution in GuessingGame.java)

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
  
  
  
_________________________________________________________________________________________________________________________
  
  
  
  
## Sheet 2

### Task 2 (a) (Solution in Sanduhr.java)

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
-The program creates a new task each time the *getExercise()* method is called.  
-The *getExercise()* method outputs the generated task to the console as follows:  
 Operand1 Operator Operand2 = ?  
 Examples: 13 * 8 = ? , 5 / 7 = ? , 20 + 1 = ?  
-A task is valid if the result is greater than 0. Invalid tasks are discarded in the method *getExercise()*, and a new random   
task is created directly before the before the method ends.  
  
  
  
_________________________________________________________________________________________________________________________
  
  
  
  
## Sheet 3

### Task 3 (a) Median (Solution in Median.java)

Implement the method *int median(int[] array)*, that determines the median of an array. Use the method *sort* from the array-class to
sort the array. Test your implentation with the following examples:

Array1: {12,16,2,63,55,8}
Array2: {42, 7, 543, 77, 87, 876, 143}

Median definition:
if n%2 != 0
    x = (xn +1)/2
else
    x = (1/2) * ( (xn/2) + (xn/2) + 1)

x is the index of the median  
  
_________________________________________________________________________________________________________________________
  
  
### Task 3 (b) Compare arrays (Solution in CompareArrays.java)

Implement a method *boolean isEqual(int[] a, int[] b)*, that compares two arrays with each other. Test your method with positive and negative examples where the result of *boolean isEqual(int[] a, int[] b)* is true or false.

Notes:
* Two arrays are equal, when they have the same length and all components are equal in pairs.
* The order of the entrys should not matter. For example, the array1 {1,2,3} is equal to array2 {3,2,1}
* The same entries are allowed. Eg array1  {1,1,1}
* Do not use the *sort* method of the array-class  

_________________________________________________________________________________________________________________________
  
  
### Task 3 (c) Linear algebra (Solution in LinearAlgebra.java)

Implement a class LinearAlgebra with following methods:
* print a vektor with *void ausgabe(double a[])*. It have to look like this: [1 2 3 4]
* print a matrix with *void ausgabe(double a [][])*. It have to look like this:  
<p>[ <br>
1 2 3 4 <br>  
1 2 3 4 <br>  
]</p>

* multiply two vektors pairwise with the method *double[] prodkt(double a[], double b[])*
* multiply a mxn matrix with a nx1 vektor with the method *double[] produkt(double a[][], double a[])*
* addition of two matrices pairwise with the method *double[] add(double a[][], double b[][])*


_________________________________________________________________________________________________________________________
  
  
    
## Sheet 4

### Task 4 (a) Memory (Solution in Memory.java)

Implement the method *int[][] generateField(int n)*, that create a memory-field as multidimensional array. Futher print that array on the terminal. Test your implementation with n = 4 and n = 6.

Notes:
* The playing-field only contains integer and every pair of numbers is unique. Start with 1.
* The method *int[][] generateField(int n)* only creates valid playing-fields. (n % 2 == 0)
* The placements of the pairs of numbers is random. Every call of the method *int[][] generateField(int n)* creates a new playing-field 
* You can create random numbers with the *Math.random*  

_________________________________________________________________________________________________________________________
  
  
### Task 4 (b) Shopping cart (Solution in Einkaufswagen.java)

Implement a Einkaufswagen-class with an string arraylist as attribute. You can add items to the cart with the method *addToCart(String item)* and remove items from the cart with the method *removeFromCart(String item)*. With the method *showContent()* you should print the content of the cart.

Notes:
* At the beginning, the shoppingcart is empty.
* You can only put 5 Items in the cart.

_________________________________________________________________________________________________________________________
  

### Task 4 (c) Enlarge image (Solution in EnlargeImage.java)
Given is a binary image with the two colors black and white. The pixels are in a 2D-array and the number 1 is for white and the 0 for black. Goal of the task is to elnarge the picture with an integer factor f. Every pixel should enlarged with the factor f.

Implement a methode *int[][] zoom(int[][] input, int[] f)*. Input is the picture and f the zoom factor. In addition, implement a method to print the enlarged image.

Example
```
Original        f = 2       f = 3
1 0             1 1 0 0     1 1 1 0 0 0
0 0             1 1 0 0     1 1 1 0 0 0
                0 0 0 0     1 1 1 0 0 0
                0 0 0 0     0 0 0 0 0 0
                            0 0 0 0 0 0
                            0 0 0 0 0 0
```

Notes:
* only nxn matrices are allowed


_________________________________________________________________________________________________________________________
  
  
    
## Sheet 5

Implement a class MyList, that imitates an Arraylist. Do not use Java Collection Framework or methods from the Array class. The class MyList should have an attribute int[] array.

### Task 5 (a) Add new elements (Solution in MyList.java)

Implement a method *addToList(int index, int item)* for the class MyList which adds the element item to the array at the index position index. Thereby the element at this position is (and the following) moved to the right (its index is increased by one). The value of the index must not be greater than the end of the the list. (0 <= index <= length of the array). For larger values of the index an rerror message will be issued. The resulting array will be extended by one element.

_________________________________________________________________________________________________________________________
  

### Task 5 (b) Remove elements (Solution in MyList.java)

Implement a method *removeFromList(int index)* for the class MyList, that removes the element of the array at index position. The length of the new array ist reduced by one.If the list is already empty before, the method does not perform the operation.

Write an additional method *int removeDuplicates()*, which deletes multiple values. Return value is number the of deleted entries.

_________________________________________________________________________________________________________________________
  

### Task 5 ( c ) Kombizahl (Solution in MyList.java)

Implement a method *kombiZahl(int zahl)* for the class MyList, which prints every Kombination of three numbers, whose sum is equal to zahl. You only need to print one kombination of a tripel.


_________________________________________________________________________________________________________________________
  
  
    
## Sheet 6

tbd