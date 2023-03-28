package trig;

public class LowerFunction {
    private final Cos cos;
    private final Sec sec;
    private final Tan tan;
    private final Sin sin;
    private final Csc csc;
    private final Cot cot;

    public LowerFunction(Cos cos, Sec sec, Tan tan, Sin sin, Csc csc, Cot cot) {
        this.cos = cos;
        this.sec = sec;
        this.tan = tan;
        this.csc = csc;
        this.sin = sin;
        this.cot = cot;
    }

    public double system(double x, double eps) {
        return Math.pow(((((Math.pow(((cos.cos(x, eps) * sec.sec(x, eps)) * tan.tan(x, eps)), 3)) -
                (((Math.pow(sin.sin(x, eps), 2)) / tan.tan(x, eps)) * (csc.csc(x, eps) * csc.csc(x, eps)))) +
                ((Math.pow(Math.pow(sin.sin(x, eps), 3), 3)) + cot.cot(x, eps))) - (((cos.cos(x, eps) / sin.sin(x, eps)) +
                sin.sin(x, eps)) / ((csc.csc(x, eps) + sec.sec(x, eps)) - (sin.sin(x, eps) - sin.sin(x, eps))))), 2);
    }
}