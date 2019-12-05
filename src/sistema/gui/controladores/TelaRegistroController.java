package sistema.gui.controladores;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import sistema.gui.TerraPlanizer;

public class TelaRegistroController {

    @FXML
    private JFXTextField tfNome;

    @FXML
    private JFXPasswordField pfSenha;

    @FXML
    private JFXCheckBox checkTermos;

    @FXML
    private JFXTextField tfLogin;

    @FXML
    private ComboBox<?> comboInteresses;

    @FXML
    private Text abrirTermosDeUso;

    @FXML
    void addInteresse(ActionEvent event) {

    }

    @FXML
    void cancelar(ActionEvent event) {
    	TerraPlanizer.trocarTela("login");
    }

    @FXML
    void confirmar(ActionEvent event) {

    }

    @FXML
    void fecharTela(MouseEvent event) {
    	TerraPlanizer.fecharTela();
    }

    @FXML
    void minimizarTela(MouseEvent event) {
    	TerraPlanizer.minimizarTela();
    }

    @FXML
    void removerInteresse(MouseEvent event) {

    }

}
