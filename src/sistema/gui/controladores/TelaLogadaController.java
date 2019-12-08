package sistema.gui.controladores;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import sistema.controlador.Controlador;


public class TelaLogadaController {
		Controlador controlador = Controlador.getInstancia();
		
		@FXML
		private JFXButton bnt_chat,bnt_amigos,bnt_doaçao,bnt_perfil, bnt_contrato;

		@FXML
		private Pane pane_chat,pane_amigos,pane_doaçao,pane_perfil, pane_contrato;
		
		@FXML
		private void telaFuncional(ActionEvent e) {
			if(e.getSource() == bnt_chat) {
				pane_chat.toFront();
			}
			else if(e.getSource() == bnt_amigos) {
				pane_amigos.toFront();
			}
			else if(e.getSource() == bnt_contrato) {
				pane_contrato.toFront();
			}
			else if(e.getSource() == bnt_perfil) {
				pane_perfil.toFront();
			}
			else if(e.getSource() == bnt_doaçao) {
				pane_doaçao.toFront();
			}
		}
		
	   
}
