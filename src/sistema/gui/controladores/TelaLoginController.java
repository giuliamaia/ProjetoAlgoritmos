package sistema.gui.controladores;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sistema.controlador.Controlador;
import sistema.gui.TerraPlanizer;

public class TelaLoginController {
	Controlador controlador = Controlador.getInstancia();
    @FXML
    private JFXTextField tfNome;
	
    @FXML
    private Label labelTopo;
    
    @FXML
    private JFXPasswordField pfSenha;

    @FXML
    private Label labelDown;
    
    @FXML
    void abrirRegistrarConta(ActionEvent event) {
    	TerraPlanizer.trocarTela("registro");
    }

    @FXML
    void fecharTela(MouseEvent event) {
    	TerraPlanizer.fecharTela();
    }

    @FXML
    void logar(ActionEvent event) {
    	if(controlador.pesquisarPorLogin(tfNome.getText())!= null && !tfNome.getText().isEmpty()) {
    		labelTopo.setText("");
    		if (controlador.pesquisarPorLogin(tfNome.getText()).getSenha().contentEquals(pfSenha.getText())) {
    			labelDown.setText("");
    			//TODO : Logar
    			
    			
    		}
    		else {
    			labelDown.setText("Sua senha não corresponde");
        		labelDown.setTextFill(Color.DARKRED);
    		}
    		
    	}
    	else {
    		labelDown.setText("");
    		labelTopo.setText("Não existe esse login");
    		labelTopo.setTextFill(Color.DARKRED);
    	}
    }
    
    @FXML
    void minimizarTela(MouseEvent event) {
    	TerraPlanizer.minimizarTela();
    }
    @FXML
    void pagarDinheiros(MouseEvent event) {
    	TerraPlanizer.abrirPagamentoDialog();
    }
}
