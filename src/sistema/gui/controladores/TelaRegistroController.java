package sistema.gui.controladores;

import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sistema.beans.UsuarioTerraplanista;
import sistema.controlador.Controlador;
import sistema.gui.TerraPlanizer;

public class TelaRegistroController {
	Controlador controlador = Controlador.getInstancia();
	List <String> arrayListInteresses = new ArrayList<String>(); 
	Image imageAux;
    @FXML
    private JFXTextField tfNome;

    @FXML
    private JFXPasswordField pfSenha;

    @FXML
    private Label labelErroLogin;

    @FXML
    private Label labelErroData;

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
    private Label labelErroRecomedacao;

    @FXML
    private Rectangle retangulo4;

    @FXML
    private Rectangle retangulo5;

    @FXML
    private Label labelErroGeral;

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
    @FXML
    void abrirTermosDeUso(MouseEvent event) {

    }
    @FXML
    void alterarFoto1(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/woman128.png")));
    	imageAux = new Image("/images/woman128.png");
    }

    @FXML
    void alterarFoto2(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/man128.png")));
    	imageAux = new Image("/images/man128.png");
    }

    @FXML
    void alterarFoto3(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/manbigode128.png")));
    	imageAux = new Image("/images/manbigode128.png");
    }

    @FXML
    void alterarFoto4(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/mannegro128.png")));
    	imageAux = new Image("/images/mannegro128.png");
    }

    @FXML
    void alterarFoto5(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/pastor128.png")));
    	imageAux = new Image("/images/pastor128.png");
    }

    @FXML
    void alterarFotoOutra(MouseEvent event) {
    	File arquivo = TerraPlanizer.abrirFileChooser();
    	if (arquivo != null && arquivo.exists()) {
    		circuloImg.setFill(new ImagePattern(new Image(arquivo.toURI().toString())));
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
    	if(isTudoPreenchido()) {
    		System.out.println(arrayListInteresses);
    		System.out.println(tfNome.getText());
    		System.out.println(tfLogin.getText());
    		System.out.println(pfSenha.getText());
    		System.out.println(datePickerDataNascimento.getValue());
    		UsuarioTerraplanista user = new UsuarioTerraplanista(arrayListInteresses, tfNome.getText(), tfLogin.getText(), pfSenha.getText(), datePickerDataNascimento.getValue(), imageAux);
    		controlador.adicionarUsuario(user);
    		TerraPlanizer.trocarTela("login");
    	}
    }

    private boolean isTudoPreenchido() {
    	/*
    	if(tfLogin.getText().contains(" ")||!tfLogin.getText().matches("[A-Z][a-z][1-9] ")) {
			labelErroLogin.setText("Seu login não deve possuir caracteres especiais");
			return false;
		}
		*/
    	labelErroLogin.setText("");
    	if(datePickerDataNascimento.getValue() == null) {
    		labelErroData.setText("Sua data não é válida");
    		return false;
    	}
    	labelErroData.setText("");
    	//if(tfRecomendacao.getText())
    	labelErroRecomedacao.setText("");
    	if (!tfNome.getText().isEmpty() && !tfLogin.getText().isEmpty() && !pfSenha.getText().isEmpty() && checkTermos.isSelected()&&datePickerDataNascimento.getValue() != null) {
			return true;
		}

    	labelErroGeral.setText("Algo deu errado, revise se tudo está preenchido.");
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
    	inicializaFotos();
    	atualizarListaInteresses();
    }

	private void inicializaFotos() {
		circuloImg.setStroke(Color.LIGHTSKYBLUE);
		retangulo1.setStroke(Color.LIGHTSKYBLUE);
		retangulo2.setStroke(Color.LIGHTSKYBLUE);
		retangulo3.setStroke(Color.LIGHTSKYBLUE);
		retangulo4.setStroke(Color.LIGHTSKYBLUE);
		retangulo5.setStroke(Color.LIGHTSKYBLUE);
		circuloImg.setFill(new ImagePattern(new Image("/images/user.png")));
		retangulo5.setFill(new ImagePattern(new Image("/images/pastor64.png")));
		retangulo4.setFill(new ImagePattern(new Image("/images/mannegro64.png")));
		retangulo3.setFill(new ImagePattern(new Image("/images/manbigode64.png")));
		retangulo2.setFill(new ImagePattern(new Image("/images/man64.png")));
		retangulo1.setFill(new ImagePattern(new Image("/images/woman64.png")));
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
