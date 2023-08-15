package JavaStartExamples;

import java.util.Arrays;
import java.util.Random;

public class Ja1 {
    public static void main(String[] args) {
       //Random r = new Random();
        //Scanner sc = new Scanner(System.in);
        //int x = 7;//sc.nextInt();
        //int y = 7;//r.nextInt(3, 9);
        //sc.close();
        //nums(1400);
        //printArr(arra(x, y));
        //ar(24);
        /*int [] a= {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i=0;i<=a.length-1;i++){
            if (a[i] < 6){
                   a[i] *= 2;
            }
        }
        System.out.print(Arrays.toString(a));*/


    }
    public static int [] arA(int len){
        Random r = new Random();
        int arr[] = new int[12];
        for (int i = 0; i < len; i++) {
            arr[i] = r.nextInt(99);
        } return arr;
    }
    public static void cou(int [] arr){

    }
    public static int [] ar(int [] arr){

        System.out.println(Arrays.toString(arr));
        int max = 0, min = 99;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]<min){
                min = arr[i];
            }
        } int [] a = {max, min};
        System.out.printf("max num: %d\nmin num: %d", max, min);
        return a;
    }

    //doubleArray wth x-rows y-cols
    public static int [][] arra(int x, int y){
        //int counter = 1;
        int [][] arr = new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                arr[i][j] = 0;
                if (i==j || i==x-j-1){
                    arr[i][j] = 1;
                }
                //counter++;
            }
        }   return arr;
    }
    public static void printArr(int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

     /*year: every 4th & 400th-true, 100th-false*/
    public static boolean nums (int x){
        if ((x%4==0 && x%100!=0) || (x%400==0)) {
            System.out.println(true);
            return true;
        }else {
            System.out.println(false);
            return false;
        }
    }
}
