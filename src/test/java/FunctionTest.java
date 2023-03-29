import log.Ln;
import log.Log;
import log.UpperFunction;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trig.LowerFunction;
import trig.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class FunctionTest {
    private static final double delta = 0.5;
    private static final double eps = 0.001;

    private final LowerFunction leftFunctionMock = FunMocks.leftFunctionMock();
    private final UpperFunction rightFunctionMock = FunMocks.rightFunctionMock();

    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Csc csc = new Csc(sin);
    private final Sec sec = new Sec(cos);
    private final Tan tan = new Tan(cos, sin);
    private final Cot cot = new Cot(cos, sin);

    private final Ln ln = new Ln();
    private final Log log2 = new Log(ln, 2);
    private final Log log5 = new Log(ln, 5);
    private final Log log10 = new Log(ln, 10);
    private final LowerFunction leftFunction = new LowerFunction(cos, sec, tan, sin, csc, cot);
    private final UpperFunction rightFunction = new UpperFunction(ln, log2, log5, log10);

    private Function function;

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SystemIn.csv")
    public void allMockTest(double value, double expected) {
        function = new Function(leftFunctionMock, rightFunctionMock);
        double result = function.system(value, eps);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SystemIn.csv")
    public void leftFunctionStubTest(double value, double expected) {
        function = new Function(leftFunction, rightFunctionMock);
        double result = function.system(value, eps);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SystemIn.csv")
    public void rightFunctionStubTest(double value, double expected) {
        function = new Function(leftFunctionMock, rightFunction);
        double result = function.system(value, eps);
        assertEquals(expected, result, delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/SystemIn.csv")
    public void allStubTest(double value, double expected) {
        function = new Function(leftFunction, rightFunction);
        double result = function.system(value, eps);
        assertEquals(expected, result, delta);
    }
}
