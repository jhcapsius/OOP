# Sheet 3

## Task 3 (a) Median (Solution in Median.java)

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
  
  
## Task 3 (b) Compare arrays (Solution in CompareArrays.java)

Implement a method *boolean isEqual(int[] a, int[] b)*, that compares two arrays with each other. Test your method with positive and negative examples where the result of *boolean isEqual(int[] a, int[] b)* is true or false.

Notes:
* Two arrays are equal, when they have the same length and all components are equal in pairs.
* The order of the entrys should not matter. For example, the array1 {1,2,3} is equal to array2 {3,2,1}
* The same entries are allowed. Eg array1  {1,1,1}
* Do not use the *sort* method of the array-class  

_________________________________________________________________________________________________________________________
  
  
## Task 3 (c) Linear algebra (Solution in LinearAlgebra.java)

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