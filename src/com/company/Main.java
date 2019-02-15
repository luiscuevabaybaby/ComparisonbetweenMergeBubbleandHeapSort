package com.company;

import java.util.Timer;
public class Main {

    public static void main(String[] args) {
        // write your code here

        int[] arreglo1 = new int[100];
        int[] arreglo2 = new int[100];



        for (int i = 0; i<arreglo1.length;i++){
            int temp = (int)(Math.random()*99)+1;
            arreglo1[i] = temp;
            arreglo2[i] = temp;
        }

        arreglo1 = mergeSort(arreglo1);
        arreglo2 = bubbleSort(arreglo1);

        Timer timer = new Timer();

        System.out.println("-----------------MERGE SORT-----------------");
        for (int i = 0; i < arreglo1.length; i++) {
            long Time = System.currentTimeMillis();
            System.out.print(arreglo1[i]+", ");
            System.out.println(Time+" Miliseconds");

        }


        System.out.println("------------------BUBBLE SORT--------------");
        for (int i = 0; i< arreglo2.length;i++){
            long TIME = System.currentTimeMillis();
            System.out.print(arreglo2[i]+", ");
            System.out.println(TIME+" Miliseconds");
        }
    }


    public static int[] bubbleSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]< arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public  static int[] mergeSort(int[] arr){
        //caso base.
        if(arr.length <= 1){
            return arr;
        }
        // caso recursivo.

        int medio = arr.length /2;

        int[] inferior = new int[medio];
        int[] superior = new int[arr.length - medio];
        for (int i = 0; i < medio; i++) {
            inferior[i] = arr[i];
        }

        for (int i = 0; i < superior.length ; i++) {
            superior[i] = arr[i + inferior.length];
        }
        return  merge(mergeSort(inferior), mergeSort(superior));
    }


    public static int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+ b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < a.length && k < b.length ){
            if(a[j] < b[k]){
                retval[i++] = a[j++];
            }else{
                retval[i++] = b[k++];
            }
        }

        while (j < a.length){
            retval[i++] = a[j++];
        }

        while (k < b.length){
            retval[i++] = b[k++];
        }
        return retval;

    }
            }