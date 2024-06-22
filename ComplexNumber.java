public class ComplexNumber {
    
    private double realNumber;
    private double imaginNumber;

    public ComplexNumber(double realNumber, double imaginNumber){
        this.realNumber = realNumber;
        this.imaginNumber = imaginNumber;
    }

    public double getRealNumber(){
        return realNumber;
    }

    public double getImaginNumber(){
        return imaginNumber;
    }

    public void setRealNumber(double realNum){
        realNumber = realNum;
    }

    public void setImaginNumber(double imaginNum){
        imaginNumber = imaginNum;
    }

    @Override
    public String toString() {
        return realNumber + " " + imaginNumber + "i";
    }

}
