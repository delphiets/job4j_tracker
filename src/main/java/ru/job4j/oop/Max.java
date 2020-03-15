package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        int result = left >= right? left: right;
        return result;
    }

    public static int max(int left, int right, int center) {
        int result = max(left,right) >= center? max(left,right): center;
        return result;
    }
    public static int max(int left, int right, int center, int middle) {
        int result = max(left,right,center) >= middle? max(left,right,center): middle;
        return result;
    }
}
