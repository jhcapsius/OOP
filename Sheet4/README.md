# Sheet 4

## Task 4 (a) Memory (Solution in Memory.java)

Implement the method *int[][] generateField(int n)*, that create a memory-field as multidimensional array. Futher print that array on the terminal. Test your implementation with n = 4 and n = 6.

Notes:
* The playing-field only contains integer and every pair of numbers is unique. Start with 1.
* The method *int[][] generateField(int n)* only creates valid playing-fields. (n % 2 == 0)
* The placements of the pairs of numbers is random. Every call of the method *int[][] generateField(int n)* creates a new playing-field 
* You can create random numbers with the *Math.random*  

_________________________________________________________________________________________________________________________
  
  
## Task 4 (b) Shopping cart (Solution in Einkaufswagen.java)

Implement a Einkaufswagen-class with an string arraylist as attribute. You can add items to the cart with the method *addToCart(String item)* and remove items from the cart with the method *removeFromCart(String item)*. With the method *showContent()* you should print the content of the cart.

Notes:
* At the beginning, the shoppingcart is empty.
* You can only put 5 Items in the cart.

_________________________________________________________________________________________________________________________
  

## Task 4 (c) Enlarge image (Solution in EnlargeImage.java)
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