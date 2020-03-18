package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        int result = left >= right? left: right;
        return result;
    }

    public static int max(int left, int right, int center) {
        return Math.max(max(left,right),center);
    }
    public static int max(int left, int right, int center, int middle) {
        return Math.max(max(left,right,center),middle);
    }
}
