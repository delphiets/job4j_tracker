package ru.job4j.ex;

import java.util.Arrays;

public class FindEl {

    public static void main(String[] args) {
        String[] name = {"1", "4", "10"};
        try {
            System.out.println(indexOf(name, "10"));
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("No item");
        }
        return rsl;
    }
}
