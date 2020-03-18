package ru.job4j.oop;

public class Reduce {
    /**
     * @param array Объявление массива класса.
     */
    private int[] array;

    /**
     * Метод принимает массив array, и передает его в переменную массива array.
     * @param array принимает массив из метода main.
     * Что бы указать переменную массива класса нужно перед ним указать слово this.
     * Если написать просто array = array; то мы просто переменной метода присваивам его же данные.
     */
    public void to(int[] array) {
        this.array = array;
    }

    /**
     * Метод выводит содержимое массива класса array
     */
    public void print() {
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }

    /**
     * @param args
     * Создаем массив из 3 элементов.
     * Создаем объект класса Reduce.
     * Созданной переменной на объект, вызываем метод to, и передаем в него массив array;
     * Вызываем метод print. Что бы он вывел содержание переменной array объекта
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}