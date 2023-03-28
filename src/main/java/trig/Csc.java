package trig;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Csc {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double csc(double x, double eps) {
        double sinVal = sin.sin(x, eps);
        if (Double.POSITIVE_INFINITY == sinVal) return Double.POSITIVE_INFINITY;
        if (Double.isNaN(sinVal) || Double.NEGATIVE_INFINITY == sinVal) return Double.NaN;
        return 1 / sinVal;
    }
}
