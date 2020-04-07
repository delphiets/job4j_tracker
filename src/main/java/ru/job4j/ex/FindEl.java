package ru.job4j.ex;

import java.util.Arrays;

public class FindEl {

    public static void main(String[] args) {
        String[] name = {"1", "4", "10"};
        try {
            System.out.println(indexOf(name, "11"));
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String element: value) {
            if (element.equals(key)) {
                rsl = Arrays.asList(value).indexOf(element);
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("No item");
        }
             return rsl;

    }
}
