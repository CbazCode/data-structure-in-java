package Sorts;

import java.awt.font.MultipleMaster;
import java.util.ArrayList;

public class TypesSorts {
    int i, j, temporal;

    public TypesSorts() {
        i = j = temporal = 0;
    }

    //-----------------------------------------------Mostrar arrays--------------------------------------------------
    public void showArray(int[] array) {
        int index;
        for (index = 0; index < array.length; index++) {
            System.out.print(" [" + array[index] + "] ");
        }
        System.out.println();
    }

    //-----------------------------------------------Metodo Burbuja--------------------------------------------------
    public void bubbleSortV1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temporal = array[i];
                    array[i] = array[j];
                    array[j] = temporal;
                }
            }
        }
        System.out.println("Ordenado por burbuja v1");
        showArray(array);
    }

    public void bubbleSortV2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temporal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporal;
                }
            }
        }
        System.out.println("Ordenado por burbuja v2");
        showArray(array);
    }

    //-----------------------------------------------Metodo Insercion--------------------------------------------------
    public void insercionSort(int[] array, int size) {
        int i, j, auxiliar;
        for (i = 1; i < size; i++) {
            auxiliar = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > auxiliar) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = auxiliar;
        }
        System.out.println("Ordenado por insercion");
        showArray(array);
    }

    //-------------------------------------------------Metodo Radix--------------------------------------------------
    public void radixSort(int[] array) {
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            int auxiliar[] = new int[array.length];
            j = 0;
            for (i = 0; i < array.length; i++) {
                boolean move = array[i] << x >= 0;
                if (x == 0 ? !move : move) {
                    auxiliar[j] = array[i];
                    j++;
                } else {
                    array[i - j] = array[i];
                }
            }
            for (i = j; i < auxiliar.length; i++) {
                auxiliar[i] = array[i - j];
            }
            array = auxiliar;
        }
        System.out.println("Ordenado por Radix: ");
        showArray(array);
    }

    //-------------------------------------------------Metodo Quick--------------------------------------------------
    public void quickSort(int[] array, int start, int end) {
        int i, j, pivote, auxiliar;
        i = start;
        j = end;
        pivote = array[(start + end) / 2];
        do {
            while (array[i] < pivote) {
                i++;
            }
            while (array[j] > pivote) {
                j--;
            }
            //Aqui hacemos el intercambio
            if (i <= j) {
                auxiliar = array[i];
                array[i] = array[j];
                array[j] = auxiliar;
                i++;
                j--;
            }
        } while (i <= j);
        if (start < j) {
            quickSort(array, start, j);
        }
        if (i < end) {
            quickSort(array, i, end);
        }
        System.out.println("Ordeando por quick");
        showArray(array);
    }

    //-------------------------------------------------Metodo Shell-----------------------------------------------------
    public void shellSort(int[] array) {
        int jump, i, j, k, auxiliar;
        jump = array.length / 2;
        while (jump > 0) {
            for (i = jump; i < array.length; i++) {
                j = i - jump;
                while (j >= 0) {
                    k = j + jump;
                    if (array[j] <= array[k]) {
                        j = -1;
                    } else {
                        auxiliar = array[j];
                        array[j] = array[k];
                        array[k] = auxiliar;
                        j = j - 1;
                    }
                }
            }
            jump = jump / 2;
        }
        System.out.println("Ordeando por shell");
        showArray(array);
    }

    //--------------------------------------------Metodo de intercalacion-----------------------------------------------
    public void intercalacion(int[] arrayA, int[] arrayB) {
        int i, j, k;
        int arrayC[] = new int[arrayA.length + arrayB.length];
        //Repetir mientras los arreglos A y B tengan elementos que comparar
        for (i = j = k = 0; i < arrayA.length && j < arrayB.length; k++) {
            if (arrayA[i] < arrayB[j]) {
                arrayC[k] = arrayA[i];
                i++;
            } else {
                arrayC[k] = arrayB[j];
                j++;
            }
        }
        //Para añadir los elementos  del arregloA sobrantes en caso haberlo
        for (; i < arrayA.length; i++, k++) {
            arrayC[k] = arrayA[i];
        }
        //Para añadir los elementos  del arregloB sobrantes en caso haberlo
        for (; j < arrayB.length; j++, k++) {
            arrayC[k] = arrayB[j];
        }
        System.out.println("Intercalando: ");
        showArray(arrayC);
    }

    //--------------------------------------------Metodo de mezcla directa-----------------------------------------------
    public int[] mezclaDirecta(int[] arreglo) {
        int i, j, k;
        if (arreglo.length > 1) {
            int nElementosIzq = arreglo.length / 2;
            int nElementosDer = arreglo.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
            //Copiando elementos de parte primera al arregloIzq
            for (i = 0; i < nElementosIzq; i++) {
                arregloIzq[i] = arreglo[i];
            }
            //Copiando elementos de parte segunda al arregloDer
            for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
                arregloDer[i - nElementosIzq] = arreglo[i];
            }
            //Recursividad
            arregloIzq = mezclaDirecta(arregloIzq);
            arregloDer = mezclaDirecta(arregloDer);
            i = 0;
            j = 0;
            k = 0;
            while (arregloIzq.length != j && arregloDer.length != k) {
                if (arregloIzq[j] < arregloDer[k]) {
                    arreglo[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    arreglo[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            //Arreglo final
            while (arregloIzq.length != j) {
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }
            while (arregloDer.length != k) {
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }//Fin if
        return arreglo;
    }

    //------------------------------------------------Mezcla natural----------------------------------------------------
    public void mergeNatural(int arreglo[]) {
        int left = 0, lft = 0, right = arreglo.length - 1, rgt = right;
        boolean sort = false;
        do {
            sort = true;
            left = 0;
            while (left < right) {
                lft = left;
                while (lft < right && arreglo[lft] <= arreglo[lft + 1]) {
                    lft++;
                }
                rgt = lft + 1;
                while (rgt == right - 1 || rgt < right && arreglo[rgt] <= arreglo[rgt + 1]) {
                    rgt++;
                }
                if (rgt <= right) {
                    mergeDirecta2(arreglo);
                    sort = false;
                }
                left = lft;
            }
        } while (!sort);
    }

    //--------------------------------------Metodo de mezcla directa utilizado por mezcla natural-----------------------------
    public int[] mergeDirecta2(int[] arreglo) {
        int i, j, k;
        if (arreglo.length > 1) {
            int nElementosIzq = arreglo.length / 2;
            int nElementosDer = arreglo.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
            //Copiando elementos de parte primera al arregloIzq
            for (i = 0; i < nElementosIzq; i++) {
                arregloIzq[i] = arreglo[i];
            }
            //Copiando elementos de parte segunda al arregloDer
            for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
                arregloDer[i - nElementosIzq] = arreglo[i];
            }
            //Recursividad
            arregloIzq = mergeDirecta2(arregloIzq);
            arregloDer = mergeDirecta2(arregloDer);
            i = 0;
            j = 0;
            k = 0;
            while (arregloIzq.length != j && arregloDer.length != k) {
                if (arregloIzq[j] < arregloDer[k]) {
                    arreglo[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    arreglo[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            //Arreglo final
            while (arregloIzq.length != j) {
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }
            while (arregloDer.length != k) {
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }//Fin if
        return arreglo;
    }

    //---------------------------------------------------------------Merge by:Antonio Sarosi---------------------------------------------------------------------------------
    public void sortSuportMerge(int[] arreglo) {
        if (arreglo.length > 1) {
            int nElementosIzq = arreglo.length / 2;
            int nElementosDer = arreglo.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];
            //Copiando elementos de parte primera al arregloIzq
            for (i = 0; i < nElementosIzq; i++) {
                arregloIzq[i] = arreglo[i];
            }
            //Copiando elementos de parte segunda al arregloDer
            for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
                arregloDer[i - nElementosIzq] = arreglo[i];
            }
            //Recursividad
            arregloIzq = mezclaDirecta(arregloIzq);
            arregloDer = mezclaDirecta(arregloDer);
            ArrayList<Integer> merged = merge(arregloIzq,arregloDer);
            for(int x=0; x<arreglo.length;x++){
                arreglo[x]= (int)merged.get(x);
            }
            showArray(arreglo);
        }
    }

    public ArrayList<Integer> merge(int[] arregloIzq, int[] arregloDer) {
        int i=0, j=0;
        ArrayList<Integer> arrayAux = new ArrayList<Integer>();
        while (i<arregloIzq.length && j<arregloDer.length) {
            if (arregloIzq[i] < arregloDer[j]) {
                arrayAux.add(arregloIzq[i]);
                i++;
            } else {
                arrayAux.add(arregloDer[j]);
                j++;
            }
        }
        //Arreglo final
        while (i < arregloIzq.length) {
            arrayAux.add(arregloIzq[i]);
            i++;
        }
        while (j < arregloDer.length) {
            arrayAux.add(arregloDer[j]);
            j++;
        }
        return arrayAux;
    }
}

