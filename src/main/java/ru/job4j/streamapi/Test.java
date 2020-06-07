package ru.job4j.streamapi;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Test {
    public static void main(String[] args) {
        Optional<Optional<String>> name = Optional.of(Optional.of("JOHN"));
        Optional<String> lowerCaseName = name.flatMap(o -> o.map(String::toLowerCase));
        System.out.println(lowerCaseName);

        Optional<String> name1 = Optional.of("JOHN");
        System.out.println(name1.map(String::toLowerCase));  //output Optional[john]
    }
}
