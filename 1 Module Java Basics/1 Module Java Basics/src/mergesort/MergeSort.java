package mergesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws IOException{
        System.out.println("Enter 10 integer numbers:");
        int[] numbers = userInput();
        System.out.println("Your entered numbers:");
        System.out.println(Arrays.toString(numbers));
        
        numbers = mergeSort(numbers);//sorting array using merge sort

        System.out.println();
        System.out.println("Numbers after merge sorting:");

        System.out.println(Arrays.toString(numbers));
    }

    private static int[] userInput() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] resultArray = new int[10];
        for(int i = 0; i < 10; i++){
            String inputString = reader.readLine();
            try{
                int number = Integer.parseInt(inputString);
                resultArray[i] = number;
            } catch(NumberFormatException e){
                System.out.println(e);
            }
        }
        return resultArray;
    }

    private static int[] mergeSort(int[] unsortedArray){
        if(unsortedArray.length <= 1){
            return unsortedArray;
        }
        int halfArray = unsortedArray.length / 2;
        int[] leftArray = new int[halfArray];
        int[] rightArray;
        if(unsortedArray.length % 2 == 0){
            rightArray = new int[halfArray];
        }
        else{
            rightArray = new int[halfArray + 1];
        }
        int[] result = new int[unsortedArray.length];
        for(int i = 0; i < halfArray; i++){
            leftArray[i] = unsortedArray[i];
        }

        int position = 0;
        for(int j = halfArray; j < unsortedArray.length; j++){
            if(position < rightArray.length){
                rightArray[position] = unsortedArray[j];
                position++;
            }
        }

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        result = merge(leftArray, rightArray);
        return result;
    }

    private static int[] merge (int[] left, int[] right){
        int lengthResult = left.length + right.length;
        int[] result = new int[lengthResult];
        int indexLeft = 0;
        int indexRight = 0;
        int indexRes = 0;

        while(indexLeft < left.length || indexRight < right.length){
            if(indexLeft < left.length && indexRight < right.length){
                if(left[indexLeft] <= right[indexRight]){
                    result[indexRes] = left[indexLeft];
                    indexLeft++;
                    indexRes++;
                }
                else{
                    result[indexRes] = right[indexRight];
                    indexRight++;
                    indexRes++;
                }
            }
            else if(indexLeft < left.length){
                result[indexRes] = left[indexLeft];
                indexLeft++;
                indexRes++;
                }
            else if(indexRight < right.length){
                result[indexRes] = right[indexRight];
                indexRight++;
                indexRes++;
            }
        }
        return result;
    }
}
