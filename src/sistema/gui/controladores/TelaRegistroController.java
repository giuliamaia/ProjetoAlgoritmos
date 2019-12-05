package sistema.gui.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import sistema.controlador.Controlador;
import sistema.gui.TerraPlanizer;

public class TelaRegistroController {
	Controlador controlador = Controlador.getInstancia();
	List <String> arrayListInteresses = new ArrayList<String>(); 
	
    @FXML
    private JFXTextField tfNome;

    @FXML
    private JFXPasswordField pfSenha;

    @FXML
    private DatePicker datePickerDataNascimento;
    @FXML
    private FontAwesomeIconView iconeMais;
    @FXML
    private JFXCheckBox checkTermos;

    @FXML
    private JFXTextField tfLogin;

    @FXML
    private ComboBox<String> comboInteresses;

    @FXML
    private Text abrirTermosDeUso;
    
    @FXML
    private Rectangle escolherImagemPC;

    @FXML
    private JFXTextField tfOutroInteresse;
    
    @FXML
    private JFXListView<String> listaInteresses;
    
    @FXML
    private JFXTextField tfRecomendacao;
    
    @FXML
    private Circle circuloImg;

    @FXML
    private Rectangle retangulo1;

    @FXML
    private Rectangle retangulo2;

    @FXML
    private Rectangle retangulo3;

    @FXML
    private Rectangle retangulo4;

    @FXML
    private Rectangle retangulo5;
    @FXML
    void addInteresse(ActionEvent event) {
    	if(comboInteresses.getSelectionModel().getSelectedItem().contentEquals("Outro...")) {
    		iconeMais.setDisable(false);
    		tfOutroInteresse.setDisable(false);
    	}
    	else if (!verificaSeJaTem(comboInteresses.getSelectionModel().getSelectedItem())) {
    		arrayListInteresses.add(comboInteresses.getSelectionModel().getSelectedItem());
    		atualizarListaInteresses();
    		iconeMais.setDisable(true);
    		tfOutroInteresse.setDisable(true);
    	}
    	
    }
    
    private boolean verificaSeJaTem(String usuario) {
    	for (String aux : arrayListInteresses) {
    		if (aux.toUpperCase().contentEquals(usuario.toUpperCase())) {
    			return true;
    		}
    	}
		return false;
	}

	@FXML
    void addOutroInteresse() {
    	if (!verificaSeJaTem(tfOutroInteresse.getText())) {
    		arrayListInteresses.add(tfOutroInteresse.getText());
    		atualizarListaInteresses();
    	}
    }
    
    void atualizarListaInteresses() {
    	Collections.sort(arrayListInteresses);
    	listaInteresses.setItems(FXCollections.observableList(arrayListInteresses));
    }
    
    @FXML
    void cancelar(ActionEvent event) {
    	TerraPlanizer.trocarTela("login");
    }

    @FXML
    void confirmar(ActionEvent event) {
    	System.out.println(isTudoPreenchido());
    }

    private boolean isTudoPreenchido() {
		if (!tfNome.getText().isEmpty() && !tfLogin.getText().isEmpty() && !pfSenha.getText().isEmpty() && checkTermos.isSelected()) {
			return true;
		}
		return false;
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
    	if(listaInteresses.getSelectionModel().getSelectedItem()!=null) {
    		arrayListInteresses.remove(listaInteresses.getSelectionModel().getSelectedItem());
        	atualizarListaInteresses();
    	}
    	else {
    		//Avisar em alguma label que tem q selecionar
    	}
    }
    
    @FXML
    void pesquisaRecomendacao(MouseEvent event) {
    	
    	if (!tfRecomendacao.getText().isEmpty()) {
    		//pesquisar se existe esse cara no controlador
    	}
    }
    @FXML
    void initialize() {
    	
    	inicializaComboBoxInteresses();
    	//inicializaFotos();
    	atualizarListaInteresses();
    }

	private void inicializaFotos() {
		Image imagem = new Image("/images/educator.png");
		circuloImg.setStroke(Color.LIGHTSKYBLUE);
		circuloImg.setFill(new ImagePattern(imagem));
		//retangulo1.setFill(new ImagePattern(imagem));
	}

	private void inicializaComboBoxInteresses() {
		iconeMais.setDisable(true);
		tfOutroInteresse.setDisable(true);
		List<String> lista = new ArrayList<String>();
    	lista.add("Domo terrestre");
    	lista.add("Densidade");
    	lista.add("Tratado da Antártida");
    	lista.add("Resfriamento global");
    	lista.add("FlatCon");
    	lista.add("Geocentrismo");
    	lista.add("Salamandras");
    	Collections.sort(lista);
    	lista.add("Outro...");
    	comboInteresses.setItems(FXCollections.observableList(lista));		
	}
}
