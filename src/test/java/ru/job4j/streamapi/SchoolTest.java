package ru.job4j.streamapi;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {


    @Test
    public void classA() {
        List<Student> students = List.of(new Student("Antonov", 100), new Student("Bogdan", 70), new Student("Pupkin", 30));
        Predicate<Student> predicate = p -> p.getScore() >= 70 && p.getScore() <= 100;
        List<Student> list = new School().collect(students, predicate);
        assertThat(list, is(List.of(new Student("Antonov", 100), new Student("Bogdan", 70))));
    }
    @Test
    public void classB() {
        List<Student> students = List.of(new Student("Antonov", 100), new Student("Bogdan", 50), new Student("Pupkin", 30));
        Predicate<Student> predicate = p -> p.getScore() >= 50 && p.getScore() < 70;
        List<Student> list = new School().collect(students, predicate);
        assertThat(list, is(List.of(new Student("Bogdan", 50))));
    }
    @Test
    public void classC() {
        List<Student> students = List.of(new Student("Antonov", 100), new Student("Bogdan", 70), new Student("Pupkin", 30));
        Predicate<Student> predicate = p -> p.getScore() >= 0 && p.getScore() < 50;
        List<Student> list = new School().collect(students, predicate);
        assertThat(list, is(List.of(new Student("Pupkin", 30))));
    }
}
