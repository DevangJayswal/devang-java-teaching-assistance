package com.example;

import java.util.ArrayList;
import java.util.List;

// NOT WORKING YET
public class Java003LongestEvenList {
    public static List<Integer> getLongestEvenNumberList(List<Integer> list) {
        List list1 = new ArrayList<>();
        List list2 = new ArrayList<>();
        int c = 0;
        // 0 = don't know, 1 = list 1 is bigger. 2 = list 2 is bigger
        boolean list1Bigger = false;

        for (int i = 0; i < list.size(); i++) {
            System.out.println("------------------ index " + i);
            // if even
            if (list.get(i) % 2 == 0) {
                // check if it's first element or not to avoid ArrayOutOfBound Exception
                // because on each iteration we are checking whether previous element is even or not
                // if we check the previous element with index 0 then it will throw an exception
                if (i == 0) {
                    c++;
                } else {
                    // checking whether previous element is even or not
                    int pE = list.get(i - 1);
                    // if previous element is not even then we increment counter
                    if (pE % 2 != 0) {
                        // true = List 1 bigger; false = List 2 bigger
                        list1Bigger = list1.size() > list1.size();
                        if (list1Bigger) {
                            list2.clear();
                        } else {
                            list1.clear();
                        }
                        c++;
                    }
                }
                if (c == 1) {
                    // adding first even set of element
                    list1.add(list.get(i));
                } else if (c == 2) {
                    // adding second even set of element
                    list2.add(list.get(i));
                } else if (c > 2) {
                    // from second onward set of even element we will have to check both the list 1 and list 2
                    // out of both the list 1 and list 2 whichever is bigger we will keep that
                    // other we will clear in order to store next set of even elements

                    int element = list.get(i);

                    if (list1Bigger) {
                        list2.add(element);
                    } else {
                        list1.add(element);
                    }
                }
            }
        }
        if (list1.size() > list2.size()) {
            return list1;
        } else {
            return list2;
        }
    }
}


//                    else {
//                        if (j == 1) {
//                            list1.clear();
//                        }
//                        list1.add(element);
//                    }


//                    if (list1.size() > list2.size()) {
//                        list2.clear();
//                        list2.add(list.get(i));
//                    } else {
//                        list1.clear();
//                        list1.add(list.get(i));
//                    }

//            System.out.println("list1: " + list1.size());
//            System.out.println("list2: " + list2.size());
//        System.out.println(pc);
//        return longestList;

//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) % 2 == 0) {
//                list1.add(list.get(i));
//            } else {
//                c++;
//                if(c==1){
//                    list2.add(list.get(i));
//                }
//            }
//            if(c==2){
//                if(list1.size()>list2.size()){
//                    list2.clear();
//                }else{
//                    list1.clear();
//                }
//                c=0;
//            }
//
//        }

//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) % 2 == 0) {
//                longestList.add(list.get(i));
//                c++;
//            } else {
//                if (pc < c) {
//                    System.out.println("list: " + longestList + "clearing pc");
//                    tempList.clear();
//                    tempList.addAll(longestList);
//                    longestList.clear();
//                    pc = c;
//                    c = 0;
//                }
//            }
//
//        }
