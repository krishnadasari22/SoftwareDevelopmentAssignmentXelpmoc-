package com.assignmentpgms;
import java.util.*;

public class Main {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter How many Numbers you Want and enter the number");
    
    int n =0;
    n = sc.nextInt();
    System.out.println("Enter the numbers");
    
    int arr[] = new int[n];
    int sum = 0;
    for(int i=0;i<n; i++)
    {
         arr[i] = sc.nextInt();
         sum += arr[i]; 
    }
    System.out.println("Mean value is:"+(double)sum/n); 
    Arrays.sort(arr);
    int val = arr.length/2;
    System.out.println("Median value is: "+(arr[val]+arr[val-1])/2.0); 
    int maxValue=0;
    int maxCount=0;

    for(int i=0; i<n; ++i)
    {
        int count=0;

        for(int j=0; j<n; ++j)
        {
            if(arr[j] == arr[i])
            {
                ++count;
            }

            if(count > maxCount)
            {
                maxCount = count;
                maxValue = arr[i];
            }
        }
    } 
    System.out.println("Mode value is: "+maxValue);

  }

}


