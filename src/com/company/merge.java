package com.company;

public class merge {

    public int[] dividir(int [] arr){
        // caso base.
        if(arr.length <= 1){
            return arr;
        }

        //caso recursivo.
        int medio = arr.length/2;

        int []inferior = new int[medio];
        int []superior = new int[arr.length-medio];

        for (int i = 0; i<medio;i++){
            inferior[i] = arr[i];
        }
        for (int i = 0; i<superior.length;i++){
            superior[i] = arr[i+ inferior.length];
        }
        return unir(dividir(inferior),dividir(superior));
    }


    public int[] unir(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (j < a.length && k < b.length) {
            if (a[j] < b[k]) {
                c[i++] = a[j++];
            } else {
                c[i++] = b[k++];
            }

        }

        while (j < a.length) {
            c[i++] = a[j++];
        }
        while (k < b.length) {
            c[i] = b[k++];
        }

        return c;
    }


}

