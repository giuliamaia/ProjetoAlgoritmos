
package sistema.gui.controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class TelaLogadaController {

    @FXML
    private JFXButton bnt_chat;

    @FXML
    private JFXButton bnt_amigos;

    @FXML
    private JFXButton bnt_doaçao;

    @FXML
    private JFXButton bnt_perfil;

    @FXML
    private JFXButton bnt_contrato;

    @FXML
    private Pane pane_contrato;

    @FXML
    private Pane pane_amigos;

    @FXML
    private JFXListView<?> llv_amigos;

    @FXML
    private JFXTextField tf_pesquisa;

    @FXML
    private JFXListView<?> lv_pesquisa;

    @FXML
    private FontAwesomeIconView icon_lupa;

    @FXML
    private JFXButton bnt_remover;

    @FXML
    private JFXButton bnt_add;

    @FXML
    private Pane pane_chat;

    @FXML
    private Pane pane_doaçao;

    @FXML
    private Pane pane_perfil;

    @FXML
    private Label label_name;

    @FXML
    private Label label_login;

    @FXML
    private Label label_senha;

    @FXML
    private Label lavel_data;

    @FXML
    private JFXButton bnt_minimizar;

    @FXML
    private JFXButton bnt_sair;

    @FXML
    void sair(ActionEvent e) {
    	
    }
    
    @FXML
    void minimizar(ActionEvent e) {
    	
    }
    
    @FXML
    void telaFuncional(ActionEvent e) {
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
