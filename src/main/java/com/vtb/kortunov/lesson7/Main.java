package com.vtb.kortunov.lesson7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        //Task 1
//        getSpeedAccess(100000);
//                    10     100     10000    100000
//      ArrayList:     1       1         1         0
//      LinkedList:    1       2        93       970

        //Task 2
//        getSpeedRemove(100000);
//                    100     10000     100000
//      ArrayList:      0        2         139
//      LinkedList:     0       34        3434

        //Task 3
        getSpeedMap();

    }

    //Task 1
    public static void getSpeedAccess(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(n / 2);
        }
        System.out.println("Request Lead Time ArrayList : " + (System.currentTimeMillis() - time1));
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(n / 2);
        }
        System.out.println("Request Lead Time LinkedList : " + (System.currentTimeMillis() - time2));
    }

    //Task 2
    public static void getSpeedRemove(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < n / 2; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        System.out.println("Delete Execution Time ArrayList : " + (System.currentTimeMillis() - time1));
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < n / 2; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        System.out.println("Delete Execution Time LinkedList : " + (System.currentTimeMillis() - time2));
    }

    //Task 3
    public static void getSpeedMap() {
        ArrayList<MyEntry> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 50000; i++) {
            Integer value = (int) (Math.random() * 10);
            arrayList.add(new MyEntry(i, value));
            hashMap.put(i, value);
        }
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Integer key = (int) (Math.random() * 50000);
            for (int j = 0; j < arrayList.size(); j++) {
                MyEntry myEntry = arrayList.get(j);
                if (myEntry.getKey().equals(key)){
                    break;
                }
            }
        }
        System.out.println("Time running ArrayList : " + (System.currentTimeMillis() - time1));
        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Integer key = (int) (Math.random() * 50000);
            hashMap.get(key);
        }
        System.out.println("Time running HashMap : " + (System.currentTimeMillis() - time2));
    }
}
