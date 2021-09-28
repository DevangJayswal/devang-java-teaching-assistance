package com.example;


class Random {
    int value;
}

public class Playground {

    public static void main(String[] args) {
        Integer i = 10;
        int j = 20;
        Integer k = Integer.valueOf(50);
        j=k;

        System.out.println(j);


//        System.out.println("i: " + i + " j: " + j);
//        change(i, j);
//        System.out.println("i: " + i + " j: " + j);



    }

    static void change(int i, Integer j) {
        i = 30;
        j = 40;
    }
}


//        int primitiveInt = 10;
//        Integer objectInt = 20;
//        Number number = new Number();
//        number.value = 5;
//
//        change(primitiveInt);
//        System.out.println(primitiveInt);
//
//        change(objectInt);
//        System.out.println(objectInt);

//    public static int[] random(int[] x, int y) {
//        int[] array = new int[3];
//        for (int i = 0; i < x.length; i++) {
//            if (x[i] == y) {
//                array[0] = x[i] + 1;
//                array[1] = x[i] + 2;
//                array[2] = x[i] + 3;
//                break;
//            }
//        }
//        return array;
//    }
//
//    int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//    int resultArray[] = random(sortedArray, 6);
//        for(int i=0;i<resultArray.length;i++){
//        System.out.println(resultArray[i]);
//        }


// at the time of declaring the final variable or in constructor we must define the value
// otherwise it will give an error
//    private final int i;
//    Playground(){
//        this.i = 10;
//    }

//        System.out.println(new Playground().i);
//        System.out.println(0>0);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(4);
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.addAll(list);

