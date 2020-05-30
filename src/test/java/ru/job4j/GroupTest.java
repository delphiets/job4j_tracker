package ru.job4j;

import org.junit.Test;
import ru.job4j.lambda.Group;
import ru.job4j.lambda.Student;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GroupTest {

    @Test
    public void hobbyGroups() {
        List<Student> list = List.of(
                new Student("Mark", Set.of("Boxing")),
                new Student("Ivan", Set.of("Wrestling")),
                new Student("Eve", Set.of("Yoga")),
                new Student("Maya", Set.of("Muay thai", "Athletics")),
                new Student("Maxim", Set.of("Yoga")),
                new Student("Sergei", Set.of("Boxing", "Athletics")),
                new Student("Sasha", Set.of("Wrestling")),
                new Student("Ira", Set.of("Boxing", "Yoga"))
        );
        Map<String, Set<String>> map = Group.sections(list);
        Map<String, Set<String>> result = Map.of(
                "Muay thai", Set.of("Maya"),
                "Athletics", Set.of("Maya", "Sergei"),
                "Boxing", Set.of("Mark", "Ira", "Sergei"),
                "Yoga", Set.of("Maxim", "Eve", "Ira"),
                "Wrestling", Set.of("Sasha", "Ivan")
        );
        assertThat(map, is(result));

    }
}
