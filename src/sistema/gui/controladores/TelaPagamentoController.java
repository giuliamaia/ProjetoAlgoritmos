package sistema.gui.controladores;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import sistema.beans.CCUtils;
import sistema.gui.TerraPlanizer;

public class TelaPagamentoController {

    @FXML
    private JFXTextField tfNumCartao;

    @FXML
    private JFXTextField tfNomeTitular;

    @FXML
    private JFXTextField tfMes;

    @FXML
    private JFXTextField tfAno;

    @FXML
    private Label labelNumero;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelMesAno;

    @FXML
    private JFXTextField tfCVV;

    @FXML
    private Label labelCVV;

    @FXML
    void cancelar() {
    	TerraPlanizer.fecharTelaPagamento();
    }

    @FXML
    void confirmar() {
    	try {
			if(isTudoVálido()) {
				if(confirmaTela()) {
					TerraPlanizer.fecharTelaPagamento();
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }

	private boolean confirmaTela() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Confirme para prosseguir com o pagamento!");
		alert.setHeaderText("Seu cartão é um " + CCUtils.getCardName(CCUtils.getCardID(tfNumCartao.getText()))+", confirma?");
		alert.showAndWait();
		if(alert.getResult()==ButtonType.OK) {
			return true;
		}
		else {
			return false;
		}
		
	}
    @FXML
    void tentaPular() {
    	if(tfAno.getText().length()>=2) {
    		tfAno.setText(tfAno.getText().substring(0, 2));
    		tfCVV.requestFocus();
    	}
    	if(tfMes.getText().length()>=2) {
    		tfMes.setText(tfMes.getText().substring(0, 2));
    		if(tfMes.getText().length() == 2 && tfAno.getText().length()!=2) {
    			tfAno.requestFocus();
    		}
    	}
    	if(tfCVV.getText().length() >= 3) {
    		tfCVV.setText(tfCVV.getText().substring(0, 3));
    	}
    }
	private boolean isTudoVálido() throws Exception {
		
		if(tfNumCartao.getText().isEmpty()||!CCUtils.isNumber(tfNumCartao.getText())) {
			labelNumero.setText("Cartão Inválido, o Salamandra se entristece.");
			return false;
		}
		else if (!CCUtils.validCCNumber(tfNumCartao.getText())){
			labelNumero.setText("Infelizmente não é válido este cartão");
			return false;
		}
		else if (CCUtils.validCCNumber(tfNumCartao.getText())&&!CCUtils.validCC(tfNumCartao.getText())) {
			labelNumero.setText("Infelizmente não aceitamos essa bandeira.");
			return false;
		}
		else if(CCUtils.validCC(tfNumCartao.getText())){
			labelNumero.setText("");
			if(!tfNomeTitular.getText().isEmpty()) {
				labelNome.setText("");
				if(CCUtils.isNumber(tfMes.getText()) && CCUtils.isNumber(tfAno.getText()) && Integer.parseInt(tfMes.getText()) <= 12 && Integer.parseInt(tfMes.getText()) >= 1 &&Integer.parseInt(tfAno.getText()) <= 99 && Integer.parseInt(tfAno.getText()) >= 20) {
					labelMesAno.setText("");
					if(CCUtils.isNumber(tfCVV.getText())&&Integer.parseInt(tfCVV.getText()) <= 999&&Integer.parseInt(tfCVV.getText()) >= 001) {
						labelCVV.setText("");
						return true;
					}
					else {
						labelCVV.setText("CVV inválido");
					}
				}
				else {
					labelMesAno.setText("Data inválida");
				}
			}
			else {
				labelNome.setText("Nome não pode ser vazio");
			}
		}
		return false;
	}
}
