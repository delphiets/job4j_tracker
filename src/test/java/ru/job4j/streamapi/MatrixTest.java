package ru.job4j.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void conversionMatrixToList() {
        Integer[][] matrix = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        List<Integer> list =  new Matrix().listInt(matrix);
        assertThat(list, is(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
    }

}
