package labmda;

import org.junit.Test;
import ru.job4j.lambda.RangeCount;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = RangeCount.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = RangeCount.diapason(2, 6, x -> 3 * Math.pow(x, 2) + 4 * x + 1);
        List<Double> expected = Arrays.asList(21D, 40D, 65D, 96D);
        assertThat(result, is(expected));
    }
    @Test
    public void w1henIndicativeFunctionThenIndicativeResults() {
        List<Double> result = RangeCount.diapason(2, 4, x -> Math.pow(4, x));
        List<Double> expected = Arrays.asList(16D, 64D);
        assertThat(result, is(expected));
    }
}
