package sistema.gui.controladores;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import sistema.beans.Grafo;
import sistema.beans.UsuarioTerraplanista;
import sistema.controlador.Controlador;
import sistema.gui.TerraPlanizer;

public class TelaRegistroController {
	private static final int AlturaELargura = 256;
	Controlador controlador = Controlador.getInstancia();
	List <String> arrayListInteresses = new ArrayList<String>(); 
	String imageAux = "/images/user.png";
	
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
    private Label labelErroNome;
    @FXML
    private Circle circuloImg;

    @FXML
    private Rectangle retangulo1;

    @FXML
    private Rectangle retangulo2;
    @FXML
    private Label labelErroTermos;

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
    	TerraPlanizer.abrirTermosDeUso();
    }
    @FXML
    void alterarFoto1(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/woman128.png")));
    	imageAux = "/images/woman128.png";
    }

    @FXML
    void alterarFoto2(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/man128.png")));
    	imageAux = "/images/man128.png";
    }

    @FXML
    void alterarFoto3(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/manbigode128.png")));
    	imageAux = "/images/manbigode128.png";
    }

    @FXML
    void alterarFoto4(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/mannegro128.png")));
    	imageAux = "/images/mannegro128.png";
    }

    @FXML
    void alterarFoto5(MouseEvent event) {
    	circuloImg.setFill(new ImagePattern(new Image("/images/pastor128.png")));
    	imageAux = "/images/pastor128.png";
    }

    @FXML
    void alterarFotoOutra(MouseEvent event) {
    	File arquivo = TerraPlanizer.abrirFileChooser();
    	if(arquivo == null) {
    		return;
    	}
    	ImageView imageView = new ImageView(new Image(arquivo.toURI().toString()));
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setFitWidth(AlturaELargura);
        imageView.setFitHeight(AlturaELargura);
    	if (arquivo != null && arquivo.exists()) {
    		circuloImg.setFill(new ImagePattern(imageView.snapshot(null, null)));
    	}
    	imageAux = arquivo.toURI().toString();
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
    	if (!verificaSeJaTem(tfOutroInteresse.getText())&&!tfOutroInteresse.getText().isEmpty()) {
    		arrayListInteresses.add(tfOutroInteresse.getText());
    		atualizarListaInteresses();
    		tfOutroInteresse.setText("");
    	}
    }
    
    void atualizarListaInteresses() {
    	Collections.sort(arrayListInteresses);
    	listaInteresses.setItems(FXCollections.observableList(arrayListInteresses));
    }
    
    @FXML
    void cancelar(ActionEvent event) {
    	limparTelaDeRegistro();
    	TerraPlanizer.trocarTela("login");
    }

    @FXML
    void confirmar(ActionEvent event) {
    	if(isTudoPreenchido()) {
    		Grafo grafo = Grafo.getInstancia();
    		
    		UsuarioTerraplanista user = new UsuarioTerraplanista(new ArrayList<UsuarioTerraplanista>(), 
    				arrayListInteresses, tfNome.getText(), 
    				tfLogin.getText(), 
    				pfSenha.getText(), 
    				datePickerDataNascimento.getValue(), 
    				LocalDateTime.now(), 
    				imageAux, 
    						0, 
    						false);
    		controlador.adicionarUsuario(user);
    		grafo.construirgrafo(true);
    		TerraPlanizer.trocarTela("login");
    		limparTelaDeRegistro();
    	}
    }
    
    private void limparTelaDeRegistro() {
    	inicializaFotos();
		tfLogin.setText("");
    	tfNome.setText("");
    	tfOutroInteresse.setText("");
    	tfRecomendacao.setText("");
    	pfSenha.setText("");
    	datePickerDataNascimento.setValue(null);
    	listaInteresses.setItems(FXCollections.emptyObservableList());
    	arrayListInteresses = new ArrayList<>();
    	labelErroData.setText("");
    	labelErroGeral.setText("");
    	labelErroLogin.setText("");
    	labelErroNome.setText("");
    	labelErroRecomedacao.setText("");
    	labelErroTermos.setText("");
    	imageAux = "/images/user.png";
    }
    private boolean isTudoPreenchido() {
    	if (tfNome.getText().isEmpty()) {
    		labelErroNome.setText("Adicione um nome válido");
    		labelErroNome.setTextFill(Color.INDIANRED);
    		return false;
    	}
    	labelErroNome.setText("");
    	if(tfLogin.getText().isEmpty()) {
    		labelErroLogin.setText("Adicione um login válido");
    		labelErroLogin.setTextFill(Color.INDIANRED);
    		return false;
    	}
    	if(controlador.pesquisarPorLogin(tfLogin.getText())!=null)
    	{
    		labelErroLogin.setText("Já existe esse login!");
    		labelErroLogin.setTextFill(Color.INDIANRED);
    		return false;
    	}
    	labelErroLogin.setText("");
    	if(datePickerDataNascimento.getValue() == null||datePickerDataNascimento.getValue().isAfter(LocalDate.now())) {
    		labelErroData.setText("Sua data não é válida");
    		labelErroData.setTextFill(Color.INDIANRED);
    		return false;
    	}
    	labelErroData.setText("");
    	if(!checkTermos.isSelected()) {
    		labelErroTermos.setText("Você deve assinar esse pacto.");
    		labelErroTermos.setTextFill(Color.INDIANRED);
    		return false;
    	}
    	labelErroTermos.setText("");
    	if (!tfNome.getText().isEmpty() && !tfLogin.getText().isEmpty() && !pfSenha.getText().isEmpty() && checkTermos.isSelected()&&datePickerDataNascimento.getValue() != null) {
			if(pesquisaRecomendacao()) {
				controlador.pesquisarPorLogin(tfRecomendacao.getText()).addRecomendacao();
			}
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
    boolean pesquisaRecomendacao() {
    	
    	if (!tfRecomendacao.getText().isEmpty()) {
    		if(controlador.pesquisarPorLogin(tfRecomendacao.getText())!=null) {
    			labelErroRecomedacao.setText("Adicionado com sucesso.");
    			labelErroRecomedacao.setTextFill(Color.DARKSEAGREEN);
    			return true;
    		}
    		else{
    			labelErroRecomedacao.setText("Não existe esse login");
    			labelErroRecomedacao.setTextFill(Color.INDIANRED);
    		}
    	}
    	return false;
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
    @FXML
    void pagarDinheiros(MouseEvent event) {
    	TerraPlanizer.abrirPagamentoDialog();
    }
}
