public class Calculator implements Operation {

    private ComplexNumber result;

    public Calculator(){
        this.result = new ComplexNumber(0, 0);
    }

    @Override
    public void sum(ComplexNumber num1, ComplexNumber num2) {
        double resultRealNumber = num1.getRealNumber() + num2.getRealNumber();
        double resultImaginNumber = num1.getImaginNumber() + num2.getImaginNumber();
        result.setRealNumber(resultRealNumber);
        result.setImaginNumber(resultImaginNumber);
        
    }

    @Override
    public void subtraction(ComplexNumber num1, ComplexNumber num2) {
        double resultRealNumber = num1.getRealNumber() - num2.getRealNumber();
        double resultImaginNumber = num1.getImaginNumber() - num2.getImaginNumber();
        result.setRealNumber(resultRealNumber);
        result.setImaginNumber(resultImaginNumber);
    }

    @Override
    public void multiply(ComplexNumber num1, ComplexNumber num2) {
        double resultRealNumber = (num1.getRealNumber() * num2.getRealNumber()) + (num1.getImaginNumber() * num2.getImaginNumber() * -1);
        double resultImaginNumber = (num1.getRealNumber() * num2.getImaginNumber()) + (num1.getImaginNumber() * num2.getRealNumber());
        result.setRealNumber(resultRealNumber);
        result.setImaginNumber(resultImaginNumber);
    }

    @Override
    public void divide(ComplexNumber num1, ComplexNumber num2) {
        double denominator = (num2.getRealNumber() * num2.getRealNumber()) + (num2.getImaginNumber() * num2.getImaginNumber());
        double resultRealNumber = ((num1.getRealNumber() * num2.getRealNumber()) + (num1.getImaginNumber() * (num2.getImaginNumber() * -1) * -1)) / denominator;
        double resultImaginNumber = ((num1.getRealNumber() * (num2.getImaginNumber() * -1)) + (num1.getImaginNumber() * num2.getRealNumber())) / denominator;
        result.setRealNumber(resultRealNumber);
        result.setImaginNumber(resultImaginNumber);
    }

    @Override
    public ComplexNumber result() {
        System.out.printf("Результат: %s%n", result);
        return result;
    }

    @Override
    public void clear() {
        this.result = new ComplexNumber(0, 0);
    }



}
