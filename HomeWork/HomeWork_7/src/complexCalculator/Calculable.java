package complexCalculator;

public interface Calculable {
    ComplexNumber sum(ComplexNumber numberA, ComplexNumber numberB);
    ComplexNumber multiply(ComplexNumber numberA, ComplexNumber numberB);
    ComplexNumber divide(ComplexNumber numberA, ComplexNumber numberB);
}
