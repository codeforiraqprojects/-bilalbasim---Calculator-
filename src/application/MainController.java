package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

	Double	num = 0.0;
	Double temp = 0.0;
	String operator = "";
	boolean resultstxt;

	@FXML
	TextField resultsTF;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void NumberClick(ActionEvent event) {

		Button btn = (Button) event.getSource();
		if (resultstxt) {
			resultsTF.setText(btn.getText());
		} else {
			resultsTF.setText(resultsTF.getText() + btn.getText());
		}
		resultstxt = false;
	}

	@FXML
	private void OperatorClick(ActionEvent event) {
		Button btn = (Button) event.getSource();
		if (!resultsTF.getText().isEmpty()) {
			temp = Double.valueOf(resultsTF.getText());
			if (btn.getText().equals("%")) {
				temp = num * temp / 100;
			}
			switch (operator) {
			case "X":
				num *= temp;
				break;
			case "-":
				num -= temp;
				break;
			case "+":
				num += temp;
				break;
			case "/":
				num /= temp;
				break;
			default:
				num = temp;
			}
		}

		if (btn.getText().equals("=") || btn.getText().equals("%")) {
			resultsTF.setText(String.valueOf(num));
			operator = "";
		} else {
			resultsTF.setText("");
			operator = btn.getText();
		}
		resultstxt = true;
	}

	@FXML
	private void C_Click(ActionEvent event) {
		if (resultsTF.getText().length() > 0) {
			resultsTF.setText(resultsTF.getText(0, resultsTF.getText().length() - 1));
		}
	}

	@FXML
	private void DeleteClick(ActionEvent event) {
		resultsTF.setText("");
		temp = 0.0;
		num = 0.0;
		resultstxt = false;
		operator = "";
	}

	@FXML
	private void MinusNumber(ActionEvent event) {
		resultsTF.setText("-");
	}

}
