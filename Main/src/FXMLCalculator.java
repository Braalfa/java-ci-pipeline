import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class FXMLCalculator {


    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eigth;
    @FXML
    private Button nine;
    @FXML
    private Button cero;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button divide;
    @FXML
    private Button multiply;
    @FXML
    private Button coma;
    @FXML
    private Button equal;
    @FXML
    private Label output;

    private Button[] numbers;
    private Button[] buttons;
    private Calculator calculator;

    public FXMLCalculator(){
    }

    /**
     * Metodo para inicializar los botones y el panel de componentes
     */
    @FXML
    public void initialize(){
        numbers= new Button[]{one, two, three, four, five, six, seven, eigth, nine, cero};
        buttons=  new Button[]{plus, minus, multiply, divide};
        calculator = new Calculator();

        for(int i=0; i<numbers.length;i++) {
            numbers[i].setOnMouseReleased(this::numberClicked);
        }

        for(int i=0; i<buttons.length;i++){
            buttons[i].setOnMouseReleased(this::operationClicked);
        }

        equal.setOnMouseReleased(this::equalClicked);
        coma.setOnMouseReleased(this::comaClicked);
        calculator.addNumber("0");
    }

    private void numberClicked(MouseEvent mouseEvent) {
        String number= ((Button)mouseEvent.getSource()).getText();
        calculator.addNumber(number);
        output.setText(calculator.getOutput());
    }

    private void operationClicked(MouseEvent mouseEvent) {
        String operator = ((Button)mouseEvent.getSource()).getText();
        calculator.setOperator(operator);
        output.setText(calculator.getOutput());
    }

    private void equalClicked(MouseEvent mouseEvent) {
        calculator.calculate();
        output.setText(calculator.getOutput());
    }

    private void comaClicked(MouseEvent mouseEvent) {
        calculator.addComa();
        output.setText(calculator.getOutput());
    }
}
