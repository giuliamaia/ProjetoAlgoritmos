package sistema.gui.controladores;

import java.io.IOException;

import com.google.common.graph.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sistema.beans.Grafo;

public class TelaLoginController {
	Grafo grafo = Grafo.getInstance();
	String texto = "";
	 @FXML
	    private Label label;

	    @FXML
	    private TextField tfVertice;

	    @FXML
	    private TextField tfa2;

	    @FXML
	    private TextField tfa1;


    @FXML
    void addAresta(ActionEvent event) {
    	try {
			grafo.addAresta(tfa1.getText(), tfa2.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void addVertice(ActionEvent event) {
    	System.out.println(tfVertice.getText());
    	try {
			grafo.addVertice(tfVertice.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	texto = texto.concat(" -- " + tfVertice.getText());
    	label.setText(texto);
    }

}
