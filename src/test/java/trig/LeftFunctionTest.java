package trig;

import log.UpperFunction;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class LeftFunctionTest {
    private static final double delta = 0.5;
    private static final double eps = 0.001;

    private final Sin sinMock = TriMocks.sinMock();
    private final Cos cosMock = TriMocks.cosMock();
    private final Csc cscMock = TriMocks.cscMock();
    private final Sec secMock = TriMocks.secMock();
    private final Tan tanMock = TriMocks.tanMock();
    private final Cot cotMock = TriMocks.cotMock();

    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Csc csc = new Csc(sin);
    private final Sec sec = new Sec(cos);
    private final Tan tan = new Tan(cos, sin);
    private final Cot cot = new Cot(cos, sin);

    private LowerFunction leftFunction;
    private static final String file = "src/main/resources/csv/out/LeftFunctionOut.csv";

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void allMockTest(double value, double expected) {
        leftFunction = new LowerFunction(cosMock, secMock, tanMock, sinMock, cscMock, cotMock);
        double result = leftFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void cosStubTest(double value, double expected) {
        leftFunction = new LowerFunction(cos, secMock, tanMock, sinMock, cscMock, cotMock);
        double result = leftFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void secStubTest(double value, double expected) {
        leftFunction = new LowerFunction(cosMock, sec, tanMock, sinMock, cscMock, cotMock);
        double result = leftFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void tanStubTest(double value, double expected) {
        leftFunction = new LowerFunction(cosMock, secMock, tan, sinMock, cscMock, cotMock);
        double result = leftFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void sinStubTest(double value, double expected) {
        leftFunction = new LowerFunction(cosMock, secMock, tanMock, sin, cscMock, cotMock);
        double result = leftFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void cscStubTest(double value, double expected) {
        leftFunction = new LowerFunction(cosMock, secMock, tanMock, sinMock, csc, cotMock);
        double result = leftFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void cotStubTest(double value, double expected) {
        leftFunction = new LowerFunction(cosMock, secMock, tanMock, sinMock, cscMock, cot);
        double result = leftFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/in/LeftFunctionIn.csv")
    public void allStubTest(double value, double expected) {
        leftFunction = new LowerFunction(cos, sec, tan, sin, csc, cot);
        double result = leftFunction.system(value, eps);
        assertEquals(expected, result, delta);
        Utils.writeResToCsv(value, result, file);
    }
}
