package trig;

public class Cot {
    private final Cos cos;
    private final Sin sin;

    public Cot(Cos cos, Sin sin) {
        this.cos = cos;
        this.sin = sin;
    }

    public double cot(double x, double eps) {
        double cosVal = cos.cos(x, eps);
        double sinVal = sin.sin(x, eps);
        if (Double.POSITIVE_INFINITY == cosVal || Double.POSITIVE_INFINITY == sinVal) return Double.POSITIVE_INFINITY;
        if (Double.isNaN(cosVal) || cosVal == Double.NEGATIVE_INFINITY ||
                Double.isNaN(sinVal) || sinVal == Double.NEGATIVE_INFINITY) return Double.NaN;
        return cosVal / sinVal;
    }
}
