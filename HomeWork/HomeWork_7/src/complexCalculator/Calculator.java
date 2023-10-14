package complexCalculator;

public class Calculator implements Calculable{

    @Override
    public ComplexNumber sum(ComplexNumber numberA, ComplexNumber numberB) {
        double real = numberA.getReal() + numberB.getReal();
        double imagine = numberA.getImaginary() + numberB.getImaginary();
        ComplexNumber result = new ComplexNumber(real, imagine);
        return result;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber numberA, ComplexNumber numberB) {
        double real = numberA.getReal() * numberB.getReal() - numberA.getImaginary() * numberB.getImaginary();
        double imagine = numberA.getReal() * numberB.getImaginary() + numberA.getImaginary() * numberB.getReal();
        ComplexNumber result = new ComplexNumber(real, imagine);
        return result;
    }

    @Override
    public ComplexNumber divide(ComplexNumber numberA, ComplexNumber numberB) {
        double denominator = numberB.getReal() * numberB.getReal() + numberB.getImaginary() * numberB.getImaginary();
        double real = (numberA.getReal() * numberB.getReal() + numberA.getImaginary() * numberB.getImaginary()) / denominator;
        double imagine = (numberA.getImaginary() * numberB.getReal() - numberA.getReal() * numberB.getImaginary()) / denominator;
        ComplexNumber result = new ComplexNumber(real, imagine);
        return result;
    }
}
