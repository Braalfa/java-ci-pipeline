public class Calculator {
    private String firstNumber;
    private String secondNumber;
    private String operator;
    private boolean isResult;
    private boolean isOperand;
    private boolean firstComa;
    private boolean secondComa;
    private SimpleCalculator calc;
    public Calculator(){
        firstNumber="";
        secondNumber="";
        operator="";
        isResult=false;
        isOperand=false;
        firstComa=false;
        secondComa = false;
    }

    public  void addComa(){
        if(operator.equals("")){
            if(!firstNumber.equals("") && !firstComa && !isResult){
                firstNumber+=".";
                firstComa=true;
            }
        }else{
            if(!secondNumber.equals("") && !secondComa && !isOperand){
                secondNumber+=".";
                secondComa=true;
            }
        }
    }

    public void addNumber(String number){
        if(operator.equals("")){
            if(firstNumber.equals("0")|| isResult){
                firstNumber=number;
                isResult=false;
            }else {
                firstNumber += number;
            }
        }else {
            if(secondNumber.equals("0")){
                secondNumber=number;
            }else {
                secondNumber += number;
            }
        }
        isOperand=false;
    }

    public void setOperator(String operator){
        if(!this.operator.equals("")){
            this.calculate();
        }
        this.operator=operator;
        isResult=false;
        isOperand=true;
    }

    public void calculate(){
        double result=0;
        double firstNumber=0;
        double secondNumber=0;

        if(!isOperand){
            try {
                firstNumber= Double.parseDouble(this.firstNumber);
                secondNumber= Double.parseDouble(this.secondNumber);
            }catch (NumberFormatException e){
            }
            switch (operator){
                case "+":
                    result = calc.sum(firstNumber, secondNumber);
                    break;
                case "-":
                    result=calc.rest(firstNumber, secondNumber);
                    break;
                case "x":
                    result= calc.multiplication(firstNumber, secondNumber);
                    break;
                case "/":
                    result= calc.divide(firstNumber, secondNumber);
                    break;
                default:
                    return ;
            }
            setUpReboot(result);
        }

        operator="";
    }

    public void setUpReboot(double result){
        isResult=true;
        this.firstNumber=trimmer(result);
        this.secondNumber="";
        secondComa=false;
        if(this.firstNumber.contains(".")){
            firstComa=true;
        }else {
            firstComa=false;
        }
    }

    public String getOutput(){
        return firstNumber+" "+ operator+" "+secondNumber;
    }

    public static String trimmer(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }


}
