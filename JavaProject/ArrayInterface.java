package com.codegnan.JavaProject;



import java.util.Scanner;


//Interface definition for array operations
interface ArrayOperation {
 void createArray(int initialSize);
 void insert(int index, int element);
 void update(int index, int newElement);
 void delete(int index);
 void retrieve(int index);
 void displayArray();
}

//Implementation of the ArrayOperation interface
class ArrayImpl implements ArrayOperation {
 private int[] array;
 private int size;

 // Constructor to initialize the array with the given size
 public ArrayImpl(int initialSize) {
     createArray(initialSize);
 }

 @Override
 public void createArray(int initialSize) {
     array = new int[initialSize];
     size = 0;
 }

 @Override
 public void insert(int index, int element) {
     // If the index is invalid, check if appending at the end is possible
     if (index < 0 || index > size) {
         System.out.println("Invalid index. Please enter a valid index.");
         return;
     }

     // Check if the array is full, and if so, expand it
     if (size == array.length) {
         int[] newArray = new int[array.length * 2];
         System.arraycopy(array, 0, newArray, 0, size);
         array = newArray;
     }

     // Shift elements to the right to make space for the new element
     System.arraycopy(array, index, array, index + 1, size - index);
     array[index] = element;
     size++;
 }

 @Override
 public void update(int index, int newElement) {
     if (index < 0 || index >= size) {
         System.out.println("Invalid index. Please enter a valid index.");
         return;
     }

     array[index] = newElement;
 }

 @Override
 public void delete(int index) {
     if (index < 0 || index >= size) {
         System.out.println("Invalid index. Please enter a valid index.");
         return;
     }

     // Shift elements to the left to fill the gap created by deletion
     System.arraycopy(array, index + 1, array, index, size - index - 1);
     size--;
 }

 @Override
 public void retrieve(int index) {
     if (index < 0 || index >= size) {
         System.out.println("Invalid index. Please enter a valid index.");
         return;
     }

     System.out.println("Element at index " + index + ": " + array[index]);
 }

 @Override
 public void displayArray() {
     System.out.print("Array elements: ");
     for (int i = 0; i < size; i++) {
         System.out.print(array[i] + " ");
     }
     System.out.println();
 }
}

//Main class to interact with the user
public class ArrayInterface {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.print("Enter the initial size of the array: ");
     int initialSize = scanner.nextInt();

     ArrayOperation array = new ArrayImpl(initialSize);

     while (true) {
         System.out.println("\n--- Array Operations Menu ---");
         System.out.println("1. Create Array");
         System.out.println("2. Insert Element");
         System.out.println("3. Update Element");
         System.out.println("4. Delete Element");
         System.out.println("5. Retrieve Element");
         System.out.println("6. Display Array");
         System.out.println("7. Exit");
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter the initial size of the array: ");
                 initialSize = scanner.nextInt();
                 array.createArray(initialSize);
                 break;
             case 2:
                 System.out.print("Enter index: ");
                 int index = scanner.nextInt();
                 System.out.print("Enter element: ");
                 int element = scanner.nextInt();
                 array.insert(index, element);
                 
                 break;
             case 3:
                 System.out.print("Enter index: ");
                 index = scanner.nextInt();
                 System.out.print("Enter new element: ");
                 element = scanner.nextInt();
                 array.update(index, element);
                 break;
             case 4:
                 System.out.print("Enter index: ");
                 index = scanner.nextInt();
                 array.delete(index);
                 break;
             case 5:
                 System.out.print("Enter index: ");
                 index = scanner.nextInt();
                 array.retrieve(index);
                 break;
             case 6:
                 array.displayArray();
                 break;
             case 7:
                 System.out.println("Exiting the program...");
                 scanner.close();
                 System.exit(0);
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }
}