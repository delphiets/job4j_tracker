package ru.job4j.stragery;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        // Тут выходит мы ссылке stdout присваиваем System.out ?
        PrintStream stdout = System.out;
        // тут все понятно
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(new String(out.toByteArray()), is(new StringJoiner(System.lineSeparator())
                                .add("***********")
                                .add("***     ***")
                                .add("***     ***")
                                .add("***********")
                                .add("***********")
                                .toString()));
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
    @Test
    public void whenDrawTriangle() {
        /**
         * 1) Тут выходит мы ссылке stdout присваиваем System.out ?
         */
        PrintStream stdout = System.out;

        /**
         * 2) создаем массив байт как я понял?
         */
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        /**
         * 3) тут мы массив байт передаем в конструктор класса PrintStream ?
         * Мне не понятно как работает метод System.setOut принимает он обьект PrintStream(out) и что происходит? Что делат System.setOut ?
         */
        System.setOut(new PrintStream(out));

        /**
         * 4) тут мы создали обьект Paint() и в его метод передали new Triangle()
         * но дальше я не вижу где мы его используем, это мне тоже не понятно
         */
        new Paint().draw(new Triangle());


        /**
         * 5) тут если я правильно понял мы создали обьект String но не понятно что мы передали в его конструктор? И что он делает с out.toByteArray()?
         * 6) я так понял мы создаем новый StringJoiner? с треугольником? И сравниваем его с new String(out.toByteArray() нашим выводом информации.
         * Но так и не понятно как наша информация с консоли попала сюда new String(out.toByteArray()) ведь как я вижу не передали обьект Paint() сюда
         */
        assertThat(new String(out.toByteArray()), is(new StringJoiner(System.lineSeparator())
                        .add("     *")
                        .add("    ***")
                        .add("   *****")
                        .add("  *******")
                        .add(" *********")
                .toString()));

        /**
         * 7) не совсем понятно зачем обратно возвращать стандартный вывод в консоль.
         */
        System.setOut(stdout);
    }
}