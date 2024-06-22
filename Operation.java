public interface Operation {

    void sum(ComplexNumber num1, ComplexNumber num2);
    void subtraction(ComplexNumber num1, ComplexNumber num2);
    void multiply (ComplexNumber num1, ComplexNumber num2);
    void divide (ComplexNumber num1, ComplexNumber num2);
    ComplexNumber result();
    void clear();
}
