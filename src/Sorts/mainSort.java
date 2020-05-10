package Sorts;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import javax.naming.PartialResultException;

public class mainSort {
    public static void main(String[] args) {
        TypesSorts sort =new TypesSorts();
        int vector1[] = {55,4,43,44,2,2,2,2,10};
        int vector2[] = {2,1,15,7,99,29,100,5,8};
        System.out.println("Arreglo original");
        sort.showArray(vector2);
        //sort.bubbleSortV1(vector1);
        //sort.bUbbleSortV2(vector1);
        //sort.radixSort(vector2);
        //sort.quickSort(vector1,0,vector1.length-1);
        //sort.insercionSort(vector2,vector2.length);
        //sort.shellSort(vector2);
        /*
        Los arreglos recibidos tienen que estar ordenados
        sort.shellSort(vector1);
        sort.shellSort(vector2);
        sort.intercalacion(vector1,vector2);
        */
        /*
        System.out.println("Ordenado por mezcla directa: ");
        vector2=sort.mergeDirecta(vector2);
        sort.showArray(vector2);
         */

        /*System.out.println("Ordenado por mezcla natural");
        sort.mergeNatural(vector2);
        sort.showArray(vector2);
         */
        //sort.sortSuportMerge(vector1);

    }
}
