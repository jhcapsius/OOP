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