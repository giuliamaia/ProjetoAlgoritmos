
package sistema.gui.controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.graphstream.graph.Graph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sistema.beans.CCUtils;
import sistema.beans.Grafo;
import sistema.beans.UsuarioTerraplanista;
import sistema.controlador.Controlador;
import sistema.gui.TerraPlanizer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TelaLogadaController {
	
	
	Controlador controlador = Controlador.getInstancia();
	UsuarioTerraplanista contaLogada = controlador.getUsuarioLogado();
	Grafo grafo= Grafo.getInstancia();
	List <String> listaInteresses = copiandoListasDoRep2(controlador.getUsuarioLogado().getInteresses());
	List <UsuarioTerraplanista> listaAmigos = copiandoListasDoRep(controlador.getUsuarioLogado().getAmigos());
	List <UsuarioTerraplanista> listausuarios = copiandoListasDoRep(controlador.getUsuarios());
	List <UsuarioTerraplanista> listaDeUsuarios = recriandoListaUsuarios(listausuarios);
	List <UsuarioTerraplanista> recomendados = controlador.recomendacoesPara(contaLogada);
	List <UsuarioTerraplanista> convites = controlador.convitesPara(contaLogada);
	
	private String imageAux ="/images/user.png";
	private boolean arestasBonitas = true;
	
	
	
    
	@FXML
    private JFXButton bnt_grafo;

    @FXML
    private JFXButton bnt_amigos;

    @FXML
    private JFXButton bnt_doaçao;

    @FXML
    private JFXButton bnt_perfil;

    @FXML
    private JFXButton bnt_contrato;
    
    @FXML
    private JFXButton bntConvite;
    
    @FXML
    private Pane paneConvites;
    
    @FXML
    private Pane pane_perfil;
    
    @FXML
    private Pane pane_editar;

    @FXML
    private Circle circleFoto;

    @FXML
    private Label label_name;

    @FXML
    private Label label_login;

    @FXML
    private Label lavel_data;

    @FXML
    private JFXListView<String> lvInteresses;

    @FXML
    private FontAwesomeIconView removeInteresses;
    
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
    private FontAwesomeIconView addInteresses;

    @FXML
    private JFXButton bnt_minimizar;

    @FXML
    private JFXButton bnt_sair;

    @FXML
    private ComboBox<String> comboboxInteresses;

    @FXML
    private JFXTextField tfOutro;

    @FXML
    private JFXButton bnt_editar;

    @FXML
    private JFXPasswordField pf_senha;

    @FXML
    private Label labelAvisoInteresses;

    @FXML
    private Pane pane_grafo;

    @FXML
    private Pane painel;

    @FXML
    private Pane pane_contrato;

    @FXML
    private Pane pane_doaçao;

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
    private  Pane pane_amigos;
    
    @FXML
    private Label label_name1;

    @FXML
    private Label label_login1;

    @FXML
    private Label lavel_data1;

    @FXML
    private Label label_senha1;

    @FXML
    private JFXListView<UsuarioTerraplanista> lv_amigos;

    @FXML
    private JFXTextField tf_pesquisa;

    @FXML
    private JFXListView<UsuarioTerraplanista> lv_pesquisa;

    @FXML
    private JFXButton bnt_remover;

    @FXML
    private JFXButton bnt_add;

    @FXML
    private Label labelAvisoAmigos;
    
    @FXML
    private JFXTextField tfRecomendacaoGrafo;

    @FXML
    private JFXButton bnt_removeGeral;

    @FXML
    private JFXButton bnt_addGeral;
    
    @FXML
    private JFXTextField tfNovoNome;

    @FXML
    private JFXTextField tfNovoLogin;

    @FXML
    private JFXTextField pfNovaSenha;

    @FXML
    private DatePicker dpDataNascimentoNova;
    
    @FXML
    private Label labelNaoAchouLoginGrafo;
	
    @FXML
    private JFXListView<UsuarioTerraplanista> lvRecomendacaoAmigos;

    @FXML
    private JFXListView<UsuarioTerraplanista> lvConvites;
    
    @FXML
    private JFXButton bntRecomendacao;

    @FXML
    private JFXButton bntRecomendacaoTodos;
    
    @FXML
    private Label labelNumConvites;
    
    @FXML
    private JFXToggleButton toggleArestasBonitas;

    @FXML
    private JFXRadioButton toggleSeitasGrafo;

    @FXML
    private JFXRadioButton toggleVerPastores;

    @FXML
    private JFXRadioButton toggleRecomendacao;

    Callback<ListView<UsuarioTerraplanista>, ListCell<UsuarioTerraplanista>> callback = new Callback<ListView<UsuarioTerraplanista>, ListCell<UsuarioTerraplanista>>() {
	
		@Override
		public ListCell<UsuarioTerraplanista> call(ListView<UsuarioTerraplanista> arg0) {
			ListCell<UsuarioTerraplanista> cell = new ListCell<UsuarioTerraplanista>() {
				@Override
				protected void updateItem(UsuarioTerraplanista usuario, boolean btl) {
					super.updateItem(usuario, btl);
					if(usuario!=null) {
						Circle circulo = new Circle(15, Color.BLUE);
						Image img = new Image(usuario.getImage());
						ImageView imgView = new ImageView(img);
						imgView.resize(25, 25);
						if(isAmigo(usuario)) {
							
							circulo.setStroke(Color.GREEN);
							
						}
						else {
							
							circulo.setStroke(Color.DARKORANGE);
							
						}
						circulo.setFill(new ImagePattern(imgView.snapshot(null, null)));
						//setTextFill(Color.AQUAMARINE);
						setText(usuario.getNome().concat(" ("+usuario.getLogin()+")"));
						setGraphic(circulo);
					}
					else {
						 setText(null);
				         setGraphic(null);
					}
				}
			
			};
			return cell;
		}
	};

	@FXML
	private JFXTextField tfAddPastor;
	
	@FXML
	private Label labelSetarPastor;
	
    @FXML
    private Label labelAvisoConvites;

    @FXML
    private JFXSlider sliderSeita;

    @FXML
    void AddPastor(ActionEvent event) {
    	if(controlador.pesquisarPorLogin(tfAddPastor.getText())!=null) {
    		labelSetarPastor.setText("");
    		controlador.pesquisarPorLogin(tfAddPastor.getText()).setPastor(true);
    		controlador.salvar();
    		if(toggleRecomendacao.isSelected()) {
				verRecomendacaoGrafo(null);
			}
			else if (toggleSeitasGrafo.isSelected()){
				verSeitasGrafo(null);
			}
			else {
				verPastoresGrafo(null);
			}
    	}
    	else {
    		labelSetarPastor.setText("Não existe usuário com esse login");
    	}
    }
    public void setarContaLogada(UsuarioTerraplanista contaLogada) {
		this.contaLogada = contaLogada;
	}
	
    @FXML
    void sair(ActionEvent e) {
    	TerraPlanizer.trocarTela("login");
    	controlador.setUsuarioLogado(null);
    	controlador.salvar();
    }
    
    @FXML
    void minimizar(ActionEvent e) {
    	TerraPlanizer.minimizarTela();
    }
    
    @FXML
    void telaFuncional(ActionEvent e) {
    	if(e.getSource() == bnt_grafo) {
			if(contaLogada.isPastor()==true) {
				pane_grafo.toFront();
				if(toggleRecomendacao.isSelected()) {
					verRecomendacaoGrafo(null);
				}
				else if (toggleSeitasGrafo.isSelected()){
					verSeitasGrafo(null);
				}
				else {
					verPastoresGrafo(null);
				}
			}
			else {
				
				Alert alerta = new Alert(AlertType.WARNING);
				alerta.setContentText("Deixe de ser mão de vaca, SrSalamandra não gosta disso.");
				alerta.setHeaderText("Você ainda não doou o suficiente para obter essa função.");
				alerta.setTitle("Sr Salamandra ainda não deixa você visualizar essa página, doe mais!");
				((Stage)alerta.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/images/icon1.png"));
				alerta.showAndWait();
				pane_doaçao.toFront();
			}
		}
		else if(e.getSource() == bnt_amigos) {
			pane_amigos.toFront();
			recomendados = controlador.recomendacoesPara(contaLogada);
			atualizarRecomendados();
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
    //PAGAMENTO ABAIXO
    @FXML
    void confirmar() {
    	try {
			if(isTudoVálido()) {
				if(confirmaTela()) {
					tfAno.setText("");
					tfCVV.setText("");
					tfMes.setText("");
					tfNomeTitular.setText("");
					tfNumCartao.setText("");
					Alert alerta = new Alert(AlertType.INFORMATION);
					alerta.setHeaderText("Você alcançou o sossego, a concentração e a paz interior.");
					((Stage)alerta.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/images/icon1.png"));
					alerta.setContentText("Obrigado por garantir seu lugar no reino dos anfíbios.\nNosso sistema não possui nenhum tipo de burocracia, já roubamos todas suas informações automaticamente e descontaremos 15% do seu salário todo mês pelo seu cartão, tudo isso pensado para seu conforto e praticidade.");
					alerta.setTitle("Bem-Vindo, novo Salamandrista. Kifflom.");
					alerta.showAndWait();
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
    	//TODO
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
				if(!tfAno.getText().isEmpty()&&!tfMes.getText().isEmpty()&&CCUtils.isNumber(tfMes.getText()) && CCUtils.isNumber(tfAno.getText()) && Integer.parseInt(tfMes.getText()) <= 12 && Integer.parseInt(tfMes.getText()) >= 1 &&Integer.parseInt(tfAno.getText()) <= 99 && Integer.parseInt(tfAno.getText()) >= 20) {
					labelMesAno.setText("");
					if(!tfCVV.getText().isEmpty()&&CCUtils.isNumber(tfCVV.getText())&&Integer.parseInt(tfCVV.getText()) <= 999&&Integer.parseInt(tfCVV.getText()) >= 001) {
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
	
    //PAGAMENTO ACIMA
    @FXML
    void initialize() {
    	controlador.pesquisarPorLogin("adm").setPastor(true);
    	recomendados = controlador.recomendacoesPara(contaLogada);
    	pane_perfil.toFront();
    	inicializaAmigos();
    	inicializaComboBoxInteresses();
    	inicializaPerfil();
    	inicializaPane();
    	inicializaEditar();
    	inicializaFotos();
    	atualizarRecomendados();
    	atualizarListaConvites();
    	sliderSeita.setMax(controlador.seitasDe3Pessoas().size());
    	toggleArestasBonitas.setSelected(true);
    	listaDeUsuarios = recriandoListaUsuarios(listausuarios);
    	
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
        imageView.setFitWidth(256);
        imageView.setFitHeight(256);
    	if (arquivo != null && arquivo.exists()) {
    		circuloImg.setFill(new ImagePattern(imageView.snapshot(null, null)));
    	}
    	imageAux = arquivo.toURI().toString();
    
    }
    private void inicializaEditar() {
    	label_name1.setText(controlador.getUsuarioLogado().getNome());
    	label_login1.setText(controlador.getUsuarioLogado().getLogin());
    	label_senha1.setText(controlador.getUsuarioLogado().getSenha());
    	lavel_data1.setText(controlador.getUsuarioLogado().getDataNascimento().toString());
    	tfNovoLogin.setPromptText("Digite seu novo login");
    	tfNovoNome.setPromptText("Digite seu novo nome");
    	pfNovaSenha.setPromptText("Digite sua nova senha");
    }
    
    private void inicializaAmigos() {
    	for(UsuarioTerraplanista u : controlador.convitesEnviadosPor(contaLogada)) {
    		listaAmigos.add(u);
    	}
    	
    	lv_amigos.setCellFactory(callback);
    	lv_amigos.setItems(FXCollections.observableList(listaAmigos));
    	lv_pesquisa.setCellFactory(callback);
    	lv_pesquisa.setItems(FXCollections.observableList(listaDeUsuarios));
    	
    }
    
    private List<UsuarioTerraplanista> copiandoListasDoRep(List<UsuarioTerraplanista> lista){
    	
    	List<UsuarioTerraplanista> ret = new ArrayList<UsuarioTerraplanista>();
    	for(int i=0; i<lista.size(); i++) {
    		ret.add(lista.get(i));
    	}
    	return ret;
    }
    
    private List<String> copiandoListasDoRep2(List<String> lista){
    	List<String> ret = new ArrayList<String>();
    	for(int i=0; i<lista.size(); i++) {
    		ret.add(lista.get(i));
    	}
    	return ret;
    }
    
    private void inicializaPerfil() {
    	
    	label_name.setText(controlador.getUsuarioLogado().getNome());
    	label_login.setText(controlador.getUsuarioLogado().getLogin());
    	pf_senha.setText(controlador.getUsuarioLogado().getSenha());
    	pf_senha.setDisable(true);
    	circleFoto.setStroke(Color.LIGHTSKYBLUE);
    	
    	lavel_data.setText(controlador.getUsuarioLogado().getDataNascimento().toString());
    	if(controlador.getUsuarioLogado().getImage()==null) {
        	circleFoto.setFill(new ImagePattern(new Image("/images/user.png")));
    	}
    	else {
    		if(contaLogada.getImage().contains("128.png"))circleFoto.setFill(new ImagePattern(new Image(controlador.getUsuarioLogado().getImage())));
    		else {
    			
    			ImageView imageView = new ImageView(new Image(contaLogada.getImage()));
    	        imageView.setPreserveRatio(true);
    	        imageView.setSmooth(true);
    	        imageView.setFitWidth(256);
    	        imageView.setFitHeight(256);
    	    	circleFoto.setFill(new ImagePattern(imageView.snapshot(null, null)));
    		}
    	}
    	lvInteresses.setItems(FXCollections.observableList(listaInteresses));
    }
    
	private void inicializaPane() {
		Graph g = grafo.getGrafo();
		FxViewer v = new FxViewer(g, FxViewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
		atualizarListaAmigos();
		g.setAttribute("ui.antialias");
		g.setAttribute("ui.quality");
		g.setAttribute("ui.stylesheet", "graph {fill-color: white; padding: 60px;}");
		v.enableAutoLayout();
		FxViewPanel panel = (FxViewPanel)v.addDefaultView(false, new FxGraphRenderer());
		panel.setPrefHeight(361);
		panel.setPrefWidth(634);
		Pane newLoadedPane =  panel;
		painel.getChildren().add(newLoadedPane);	
		
	}
	
    @FXML
    void abrirGrafoGrande(MouseEvent event) {
    	TerraPlanizer.abrirGrafo();
    }
    
	private void inicializaComboBoxInteresses() {
		addInteresses.setDisable(true);
		tfOutro.setDisable(true);
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
    	comboboxInteresses.setItems(FXCollections.observableList(lista));		
	}
	
	@FXML
    void addInteresse(ActionEvent event) {
		
		labelAvisoInteresses.setText("");
    	if(comboboxInteresses.getSelectionModel().getSelectedItem().contentEquals("Outro...")) {
    		addInteresses.setDisable(false);
    		tfOutro.setDisable(false);
    		controlador.salvar();
    	}
    	else if (!verificaSeJaTem(comboboxInteresses.getSelectionModel().getSelectedItem())) {
    		
    		controlador.getUsuarioLogado().getInteresses().add(comboboxInteresses.getSelectionModel().getSelectedItem());
    		controlador.salvar();
    		listaInteresses.add(comboboxInteresses.getSelectionModel().getSelectedItem());
    		atualizarListaInteresses();
    		addInteresses.setDisable(true);
    		tfOutro.setDisable(true);
    	}
    	
    }
	
	private boolean verificaSeJaTem(String usuario) {
    	for (String aux : listaInteresses) {
    		if (aux.toUpperCase().contentEquals(usuario.toUpperCase())) {
    			return true;
    		}
    	}
		return false;
	}
	
	@FXML
    void addOutroInteresse() {
    	if (!verificaSeJaTem(tfOutro.getText())&&!tfOutro.getText().isEmpty()) {
    		controlador.getUsuarioLogado().getInteresses().add(tfOutro.getText());
    		controlador.salvar();
    		listaInteresses.add(tfOutro.getText());
    		atualizarListaInteresses();
    		tfOutro.setText("");
    	}
    }
    
    void atualizarListaInteresses() {
    	Collections.sort(listaInteresses);
    	lvInteresses.setItems(FXCollections.observableList(listaInteresses));
    }
    
    @FXML
    void removerInteresse(MouseEvent event) {
    	labelAvisoInteresses.setText("");
    	if(lvInteresses.getSelectionModel().getSelectedItem()!=null) {
    		controlador.getUsuarioLogado().getInteresses().remove(lvInteresses.getSelectionModel().getSelectedItem());
    		controlador.salvar();
    		listaInteresses.remove(lvInteresses.getSelectionModel().getSelectedItem());
        	atualizarListaInteresses();
        	
        	
    	}
    	else {
    		labelAvisoInteresses.setText("");
    		labelAvisoInteresses.setText("Tem que selecionar um interesse!");
    	}
    }

    void atualizarRecomendados() {
    	
    	
    	
    	for(UsuarioTerraplanista u:recomendados) {
    		for(UsuarioTerraplanista a:listaAmigos) {
    			if(u.getLogin().contentEquals(a.getLogin())) {
    				recomendados.remove(u);
    			}
    		}
    	}
    	try{
    		lvRecomendacaoAmigos.setCellFactory(callback);
    		lvRecomendacaoAmigos.setItems(FXCollections.observableList(recomendados));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	grafo.construirgrafo(arestasBonitas);
		lvRecomendacaoAmigos.refresh();
	}

	
    private List<UsuarioTerraplanista> recriandoListaUsuarios(List<UsuarioTerraplanista> e) {
    	
    	List<UsuarioTerraplanista> ret = e;
    	
    	for(int o=0; o<e.size(); o++) {
    		if(e.get(o).getLogin().isEmpty()||e.get(o).getSenha().isEmpty()||e.get(o).getLogin()==null||e.get(o).getSenha()==null) {
    			e.remove(o);
    		}
    	}
    	
    	if(e.contains(contaLogada)){
    		e.remove(contaLogada);
    	}
    	
    	for(int i=0; i<listaAmigos.size(); i++) {
    		if(e.contains(listaAmigos.get(i))) {
    			e.remove(listaAmigos.get(i));
    		}
    	}
    	
    	
    	return ret;
    }
    void atualizarListaAmigos() {
    	
    	Collections.sort(listaAmigos, new Comparator<UsuarioTerraplanista>()
        {
            public int compare(UsuarioTerraplanista f1, UsuarioTerraplanista f2)
            {
                return f1.toString().compareTo(f2.toString());
            }        
        });
    	lv_amigos.setCellFactory(callback);
    	lv_amigos.setItems(FXCollections.observableList(listaAmigos));
    	sliderSeita.setMax(controlador.seitasDe3Pessoas().size());
    	grafo.construirgrafo(arestasBonitas);
    	lv_amigos.refresh();
    }
    
    void atualizarListaConvites() {
    	labelNumConvites.setText(""+controlador.numeroDeConvitesPara(controlador.getUsuarioLogado()));
    	if(controlador.numeroDeConvitesPara(controlador.getUsuarioLogado())>0) {
    		labelNumConvites.setStyle("-fx-background-color: #fcba03");
    	}
    	else {
    		labelNumConvites.setStyle("-fx-background-color: #47cad1");
    	}
    	Collections.sort(convites, new Comparator<UsuarioTerraplanista>()
        {
            public int compare(UsuarioTerraplanista f1, UsuarioTerraplanista f2)
            {
                return f1.toString().compareTo(f2.toString());
            }        
        });
    	lvConvites.setCellFactory(callback);
    	lvConvites.setItems(FXCollections.observableList(convites));
    	grafo.construirgrafo(arestasBonitas);
    	lvConvites.refresh();
    }
    
    void atualizarListaUsuarios() {
    	
    	Collections.sort(listaDeUsuarios, new Comparator<UsuarioTerraplanista>()
        {
            public int compare(UsuarioTerraplanista f1, UsuarioTerraplanista f2)
            {
                return f1.toString().compareTo(f2.toString());
            }        
        });
    	lv_pesquisa.setCellFactory(callback);
    	lv_pesquisa.setItems(FXCollections.observableList(listaDeUsuarios));
    	grafo.construirgrafo(arestasBonitas);
    	lv_pesquisa.refresh();
    }
    
    boolean isAmigo(UsuarioTerraplanista usuario) {
    	for(int i=0; i<contaLogada.getAmigos().size(); i++) {
    		if(contaLogada.getAmigos().get(i).equals(usuario)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    @FXML
    void pesquisar() {
    	
    	if(tf_pesquisa.getText()!=null && !tf_pesquisa.getText().isEmpty()) {
    		lv_pesquisa.setItems(FXCollections.observableList(pesquisando(tf_pesquisa.getText(), listaDeUsuarios)));
    	
    	}
    	else {
    		atualizarListaUsuarios();
    		labelAvisoAmigos.setText("Para procurar você precisa escrever o nome ou login de alguem!");
    	}
    }

    List<UsuarioTerraplanista> pesquisando(String nomeoulogin, List<UsuarioTerraplanista> lista){
    	List<UsuarioTerraplanista> ret = new ArrayList<UsuarioTerraplanista>();
    	for(int i=0; i<lista.size(); i++) {
    		lista.get(i).getLogin().toUpperCase();
    		lista.get(i).getNome().toUpperCase();
    		nomeoulogin.toUpperCase();
    		if(lista.get(i).getLogin().contains(nomeoulogin)||lista.get(i).getNome().contains(nomeoulogin)) {
    			ret.add(lista.get(i));
    		}
    	}
    	return ret;
    }
    private void inicializaFotos() {
		circuloImg.setStroke(Color.LIGHTSKYBLUE);
		retangulo1.setStroke(Color.LIGHTSKYBLUE);
		retangulo2.setStroke(Color.LIGHTSKYBLUE);
		retangulo3.setStroke(Color.LIGHTSKYBLUE);
		retangulo4.setStroke(Color.LIGHTSKYBLUE);
		retangulo5.setStroke(Color.LIGHTSKYBLUE);
		if(controlador.getUsuarioLogado().getImage() == null || controlador.getUsuarioLogado().getImage().isEmpty())
			circuloImg.setFill(new ImagePattern(new Image("/images/user.png")));
		else {
			circuloImg.setFill(new ImagePattern(new Image(controlador.getUsuarioLogado().getImage())));
			imageAux=controlador.getUsuarioLogado().getImage();
			
		}
		retangulo5.setFill(new ImagePattern(new Image("/images/pastor64.png")));
		retangulo4.setFill(new ImagePattern(new Image("/images/mannegro64.png")));
		retangulo3.setFill(new ImagePattern(new Image("/images/manbigode64.png")));
		retangulo2.setFill(new ImagePattern(new Image("/images/man64.png")));
		retangulo1.setFill(new ImagePattern(new Image("/images/woman64.png")));
	}

    @FXML
    void editar() {
    	pane_editar.toFront();
    	tfNovoNome.setText(contaLogada.getNome());
    	tfNovoLogin.setText(contaLogada.getLogin());
    	pfNovaSenha.setText(contaLogada.getSenha());
    	
    	dpDataNascimentoNova.setValue(contaLogada.getDataNascimento());
    }
    
    
    @FXML
    void cancelar() {
    	
    	pane_perfil.toFront();
    	tfNovoNome.setText("");
    	tfNovoLogin.setText("");
    	pfNovaSenha.setText("");
    	
    }
    
    @FXML
    void confirmarEdiçao() {
    	
    	try{
    		UsuarioTerraplanista editadoTerraplanista = new UsuarioTerraplanista(contaLogada.getAmigos(), 
    				contaLogada.getInteresses(), 
    				tfNovoNome.getText(), 
    				tfNovoLogin.getText(), 
    				pfNovaSenha.getText(),
    				dpDataNascimentoNova.getValue(), 
    				contaLogada.getHoraCriaçãoConta(), 
        			imageAux,
        			contaLogada.getRecomendacoes(), 
        			contaLogada.isPastor());
    		if(tfNovoLogin.getText().isEmpty()) {
    			tfNovoLogin.setText(contaLogada.getLogin());
    		}
    		else if(tfNovoNome.getText().isEmpty()) {
    			tfNovoNome.setText(contaLogada.getNome());
    		}
    		else if(pfNovaSenha.getText().isEmpty()) {
    			pfNovaSenha.setText(contaLogada.getSenha());
    		}
    		controlador.editarUsuario(contaLogada, editadoTerraplanista);
    	}catch(NullPointerException e) {
    		e.printStackTrace();
    	}
    	
    	inicializaPerfil();
    	
    	controlador.salvar();
    	pane_perfil.toFront();
    }

    

    @FXML
    void recomendarAmigosGrafo(ActionEvent event) {
    	//grafo.construirgrafo(arestasBonitas);
    	if(!tfRecomendacaoGrafo.getText().isEmpty()) {
    		if(controlador.pesquisarPorLogin(tfRecomendacaoGrafo.getText() )!= null){
    			grafo.setarNosRecomendacao(controlador.pesquisarPorLogin(tfRecomendacaoGrafo.getText()));
    		}
    		else {
    			labelNaoAchouLoginGrafo.setText("Não foi possivel achar usuario com esse login");
    		}
    	}
    }

    @FXML
    void abrirTelaConvite() {
    	paneConvites.toFront();
    	lvConvites.setCellFactory(callback);
    	lvConvites.setItems(FXCollections.observableList(controlador.convitesPara(contaLogada)));
    }
    
    @FXML
    void aceitarConvite() {
    	if(lvConvites.getSelectionModel().getSelectedItem()==null) {
    		labelAvisoConvites.setText("Selecione algum convite!");
    	}
    	else {
    		labelAvisoConvites.setText("");
    		contaLogada.addAmigo(lvConvites.getSelectionModel().getSelectedItem());
    		convites.remove(lvConvites.getSelectionModel().getSelectedItem());
    		controlador.removerConvite(lvConvites.getSelectionModel().getSelectedItem(), contaLogada);
    		if(controlador.removerConvite(contaLogada, lvConvites.getSelectionModel().getSelectedItem())) listaAmigos.remove(lvConvites.getSelectionModel().getSelectedItem());;
    		controlador.salvarConvites();
    		controlador.salvar();
    		listaAmigos.add(lvConvites.getSelectionModel().getSelectedItem());
    		listaDeUsuarios.remove(lvConvites.getSelectionModel().getSelectedItem());
    		if(recomendados.contains(lvConvites.getSelectionModel().getSelectedItem()))recomendados.remove(lvConvites.getSelectionModel().getSelectedItem());
    		atualizarListaAmigos();
    		atualizarListaUsuarios();
    		atualizarRecomendados();
    		atualizarListaConvites();
    		//grafo.construirgrafo(arestasBonitas);
    		
    	}
    }
    
    @FXML
    void recusarConvite() {
    	if(lvConvites.getSelectionModel().getSelectedItem()==null) {
    		labelAvisoConvites.setText("Selecione algum convite!");
    	}
    	else {
    		
    		if(mostrarAlerta(1, lvConvites.getSelectionModel().getSelectedItem())) {
        		labelAvisoConvites.setText("");
        		controlador.removerConvite(lvConvites.getSelectionModel().getSelectedItem(), contaLogada);
        		controlador.salvarConvites();
        		convites.remove(lvConvites.getSelectionModel().getSelectedItem());
        		atualizarListaConvites();
        		atualizarListaAmigos();
        		atualizarListaUsuarios();
        		atualizarRecomendados();
        		atualizarListaConvites();
    		}
    	}
    }
    
    private boolean mostrarAlerta(int tipo, UsuarioTerraplanista usuarioTerraplanista) {
    	switch (tipo) {
    	case 1:{
    		Alert alerta = new Alert(AlertType.CONFIRMATION);
    		alerta.setTitle("Remover convite");
    		((Stage)alerta.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/images/icon1.png"));
    		alerta.setHeaderText("Deseja realmente excluir o convite de " + usuarioTerraplanista.toString() + "?");
    		alerta.setContentText("Confirme a remoção do convite.");
    		alerta.getButtonTypes().remove(ButtonType.CANCEL);
    		alerta.getButtonTypes().remove(ButtonType.OK);
    		alerta.getButtonTypes().add(ButtonType.YES);
    		alerta.getButtonTypes().add(ButtonType.NO);
    		alerta.showAndWait();
    		if(alerta.getResult() == ButtonType.YES) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
		case 2:{
			Alert alerta1 = new Alert(AlertType.CONFIRMATION);
    		alerta1.setTitle("Remover amigo");
    		alerta1.setHeaderText("Deseja realmente excluir "+usuarioTerraplanista.toString()+"?");
    		alerta1.setContentText("Confirme a remoção do amigo.");
    		alerta1.getButtonTypes().remove(ButtonType.CANCEL);
    		((Stage)alerta1.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/images/icon1.png"));
    		alerta1.getButtonTypes().remove(ButtonType.OK);
    		alerta1.getButtonTypes().add(ButtonType.YES);
    		alerta1.getButtonTypes().add(ButtonType.NO);
    		alerta1.showAndWait();
    		if(alerta1.getResult() == ButtonType.YES) {
    			return true;
    		}
    		else {
    			return false;
    		}
		}
		case 3:{
			Alert alerta1 = new Alert(AlertType.CONFIRMATION);
    		alerta1.setTitle("Remover todo mundo");
    		alerta1.setHeaderText("Deseja realmente excluir tudo?");
    		alerta1.setContentText("Confirme a remoção de tudo.");
    		((Stage)alerta1.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/images/icon1.png"));
    		alerta1.getButtonTypes().remove(ButtonType.CANCEL);
    		alerta1.getButtonTypes().remove(ButtonType.OK);
    		alerta1.getButtonTypes().add(ButtonType.YES);
    		alerta1.getButtonTypes().add(ButtonType.NO);
    		alerta1.showAndWait();
    		if(alerta1.getResult() == ButtonType.YES) {
    			return true;
    		}
    		else {
    			return false;
    		}
		}
		case 4:{
			Alert alerta1 = new Alert(AlertType.CONFIRMATION);
    		alerta1.setTitle("Confirmar convite");
    		alerta1.setHeaderText(usuarioTerraplanista.toString()+" já te enviou um convite, deseja aceitar o convite?");
    		((Stage)alerta1.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/images/icon1.png"));
    		alerta1.setContentText("Confirme o convite.");
    		alerta1.getButtonTypes().remove(ButtonType.CANCEL);
    		alerta1.getButtonTypes().remove(ButtonType.OK);
    		alerta1.getButtonTypes().add(ButtonType.YES);
    		alerta1.getButtonTypes().add(ButtonType.NO);
    		alerta1.showAndWait();
    		if(alerta1.getResult() == ButtonType.YES) {
    			
    			return true;
    		}
    		else {
    			
    			return false;
    		}
		}
    	default:
    		return false;
    	}
	}

	@FXML
    void enviarConvite() {
    	if(lv_pesquisa.getSelectionModel().getSelectedItem()!=null) {
    		if(controlador.convitesPara(contaLogada).contains(lv_pesquisa.getSelectionModel().getSelectedItem())) {
    			if(mostrarAlerta(4,lv_pesquisa.getSelectionModel().getSelectedItem())) {
    				contaLogada.addAmigo(lv_pesquisa.getSelectionModel().getSelectedItem());
            		convites.remove(lv_pesquisa.getSelectionModel().getSelectedItem());
            		
            		controlador.removerConvite(lv_pesquisa.getSelectionModel().getSelectedItem(), contaLogada);
            		if(controlador.removerConvite(contaLogada, lv_pesquisa.getSelectionModel().getSelectedItem())) listaAmigos.remove(lv_pesquisa.getSelectionModel().getSelectedItem());
            		controlador.salvarConvites();
            		controlador.salvar();
            		listaAmigos.add(lv_pesquisa.getSelectionModel().getSelectedItem());
            		listaDeUsuarios.remove(lv_pesquisa.getSelectionModel().getSelectedItem());
            		if(recomendados.contains(lv_pesquisa.getSelectionModel().getSelectedItem()))recomendados.remove(lv_pesquisa.getSelectionModel().getSelectedItem());
            		atualizarListaAmigos();
            		atualizarListaUsuarios();
            		atualizarRecomendados();
            		atualizarListaConvites();
    			}
    			else {
    				controlador.removerConvite(lv_pesquisa.getSelectionModel().getSelectedItem(), contaLogada);
            		controlador.salvarConvites();
            		convites.remove(lv_pesquisa.getSelectionModel().getSelectedItem());
            		recomendados = controlador.recomendacoesPara(contaLogada);
            		atualizarListaConvites();
            		atualizarListaAmigos();
            		atualizarListaUsuarios();
            		atualizarRecomendados();
            		atualizarListaConvites();
    			}
    			return;
    		}
    		labelAvisoConvites.setText("");
    		controlador.enviarConvite(contaLogada, lv_pesquisa.getSelectionModel().getSelectedItem());
        	controlador.salvarConvites();
        	listaAmigos.add(lv_pesquisa.getSelectionModel().getSelectedItem());
        	listaDeUsuarios.remove(lv_pesquisa.getSelectionModel().getSelectedItem());
        	recomendados.remove(lv_pesquisa.getSelectionModel().getSelectedItem());
        	atualizarListaAmigos();
        	atualizarListaUsuarios();
        	atualizarRecomendados();
    	}
    	else {
    		labelAvisoAmigos.setText("Selecione alguém!");
    	}
    	
    }

    @FXML
    void enviarConviteGeral() {
    	if(!listaDeUsuarios.isEmpty()) {
    		labelAvisoConvites.setText("");
    		for(int i = 0; i < listaDeUsuarios.size(); i++) {
    			if(controlador.convitesPara(contaLogada).contains(listaDeUsuarios.get(i))) {
    				if(mostrarAlerta(4, listaDeUsuarios.get(i))) {
    					
        				contaLogada.addAmigo(listaDeUsuarios.get(i));
                		convites.remove(listaDeUsuarios.get(i));
                		controlador.removerConvite(listaDeUsuarios.get(i), contaLogada);
                		if(controlador.removerConvite(contaLogada, listaDeUsuarios.get(i))) listaAmigos.remove(listaDeUsuarios.get(i));
                		controlador.salvarConvites();
                		controlador.salvar();
                		listaAmigos.add(listaDeUsuarios.get(i));
                		if(recomendados.contains(listaDeUsuarios.get(i)))recomendados.remove(listaDeUsuarios.get(i));
                		listaDeUsuarios.remove(listaDeUsuarios.get(i));
                		
                		atualizarListaAmigos();
                		atualizarListaUsuarios();
                		atualizarRecomendados();
                		atualizarListaConvites();
        			}
        			else {
        				controlador.removerConvite(listaDeUsuarios.get(i), contaLogada);
                		controlador.salvarConvites();
                		convites.remove(listaDeUsuarios.get(i));
                		atualizarListaConvites();
                		atualizarListaAmigos();
                		atualizarListaUsuarios();
                		atualizarRecomendados();
                		atualizarListaConvites();
        			}
        			
        		}
    			else
    				controlador.enviarConvite(contaLogada, listaDeUsuarios.get(i));
    			
    		}
    		controlador.salvarConvites();
    		listaAmigos.addAll(listaDeUsuarios);
    		listaDeUsuarios.removeAll(listaDeUsuarios);
    		recomendados.removeAll(listaDeUsuarios);
    		atualizarListaAmigos();
    		atualizarListaUsuarios();
    		atualizarRecomendados();
    	}
    	else {
    		labelAvisoAmigos.setText("Você já enviou convites para todo mundo!");
    	}
    }

    @FXML
    void enviarConviteRecomendados() {
    	if(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem()!=null) {
    		if(controlador.convitesPara(contaLogada).contains(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem())) {
    			if(mostrarAlerta(4,lvRecomendacaoAmigos.getSelectionModel().getSelectedItem())) {
    				contaLogada.addAmigo(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
            		convites.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
            		controlador.removerConvite(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem(), contaLogada);
            		if(controlador.removerConvite(contaLogada, lvRecomendacaoAmigos.getSelectionModel().getSelectedItem())) listaAmigos.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
            		controlador.salvarConvites();
            		controlador.salvar();
            		listaAmigos.add(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
            		listaDeUsuarios.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
            		if(recomendados.contains(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem()))recomendados.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
            		atualizarListaAmigos();
            		atualizarListaUsuarios();
            		atualizarRecomendados();
            		atualizarListaConvites();
    			}
    			else {
    				controlador.removerConvite(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem(), contaLogada);
            		controlador.salvarConvites();
            		convites.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
            		atualizarListaConvites();
            		atualizarListaAmigos();
            		atualizarListaUsuarios();
            		atualizarRecomendados();
            		atualizarListaConvites();
    			}
    			return;
    		}
    		labelAvisoAmigos.setText("");
    		controlador.enviarConvite(contaLogada, lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
    		controlador.salvarConvites();
    		listaAmigos.add(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
    		recomendados.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
    		listaDeUsuarios.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
    		atualizarListaAmigos();
    		atualizarRecomendados();
    		atualizarListaUsuarios();
    		atualizarListaConvites();
    	}
    	else {
    		labelAvisoAmigos.setText("Selecione alguém!");
    	}
    }

    @FXML
    void enviarConviteGeralRecomendados() {
    	if(!recomendados.isEmpty()) {
    		labelAvisoConvites.setText("");
    		for(int i = 0; i < recomendados.size(); i++) {
    			if(controlador.convitesPara(contaLogada).contains(recomendados.get(i))) {
    				if(mostrarAlerta(4, recomendados.get(i))) {
    					
        				contaLogada.addAmigo(recomendados.get(i));
                		convites.remove(recomendados.get(i));
                		controlador.removerConvite(recomendados.get(i), contaLogada);
                		if(controlador.removerConvite(contaLogada, recomendados.get(i))) listaAmigos.remove(recomendados.get(i));
                		controlador.salvarConvites();
                		controlador.salvar();
                		listaAmigos.add(recomendados.get(i));
                		listaDeUsuarios.remove(recomendados.get(i));
                		if(recomendados.contains(recomendados.get(i)))recomendados.remove(recomendados.get(i));
                		atualizarListaAmigos();
                		atualizarListaUsuarios();
                		atualizarRecomendados();
                		atualizarListaConvites();
        			}
        			else {
        				controlador.removerConvite(recomendados.get(i), contaLogada);
                		controlador.salvarConvites();
                		convites.remove(recomendados.get(i));
                		atualizarListaConvites();
                		atualizarListaAmigos();
                		atualizarListaUsuarios();
                		atualizarRecomendados();
                		atualizarListaConvites();
        			}
        			
        		}
    			else
    			controlador.enviarConvite(contaLogada, recomendados.get(i));
    			
    		}
    		controlador.salvarConvites();
    		listaAmigos.addAll(recomendados);
    		listaDeUsuarios.removeAll(recomendados);
    		recomendados.removeAll(recomendados);
    		atualizarListaAmigos();
    		atualizarListaUsuarios();
    		atualizarRecomendados();
    	}
    	else {
    		labelAvisoAmigos.setText("Você já enviou convites para todo mundo!");
    	}
    }
    
    @FXML
    void removerAmigo() {
    	if(lv_amigos.getSelectionModel().getSelectedItem()!=null) {
    		labelAvisoAmigos.setText("");
    		if(controlador.convitesEnviadosPor(contaLogada).contains(lv_amigos.getSelectionModel().getSelectedItem())) {
    			if(mostrarAlerta(1, lv_amigos.getSelectionModel().getSelectedItem())) {
        			controlador.removerConvite(contaLogada, lv_amigos.getSelectionModel().getSelectedItem());
        			listaAmigos.remove(lv_amigos.getSelectionModel().getSelectedItem());
            		listaDeUsuarios.add(lv_amigos.getSelectionModel().getSelectedItem());
        			controlador.salvar();
        			recomendados = controlador.recomendacoesPara(contaLogada);
        			atualizarListaAmigos();
            		atualizarListaUsuarios();
            		atualizarRecomendados();
    			}
    		}
    		else {
    			if(mostrarAlerta(2,lv_amigos.getSelectionModel().getSelectedItem())) {
            		controlador.getUsuarioLogado().removerAmigo(lv_amigos.getSelectionModel().getSelectedItem());
            		controlador.salvar();
            		listaAmigos.remove(lv_amigos.getSelectionModel().getSelectedItem());
            		listaDeUsuarios.add(lv_amigos.getSelectionModel().getSelectedItem());
            		recomendados = controlador.recomendacoesPara(contaLogada);
            		atualizarListaAmigos();
            		atualizarListaUsuarios();
            		atualizarRecomendados();
    			}
    		}
    		
    	}
    	else {
    		labelAvisoAmigos.setText("Selecione alguém para remover!");
    		
    	}
    }
    
    @FXML 
    void removeGeral() {
    	if(!listaAmigos.isEmpty()) {
    		if(mostrarAlerta(3, null)) {
    			for(UsuarioTerraplanista u : listaAmigos) {
        			if(contaLogada.getAmigos().contains(u))contaLogada.removerAmigo(u);
        			else controlador.removerConvite(contaLogada, u);
        			
        		}
        		controlador.salvar();
    			
    			listaDeUsuarios.addAll(listaAmigos);
            	listaAmigos.removeAll(listaAmigos);
            	recomendados = controlador.recomendacoesPara(contaLogada);
            	atualizarListaAmigos();
            	atualizarListaUsuarios();
        		atualizarRecomendados();
    		}
    		
    		
    	}
    	else {
    		labelAvisoAmigos.setText("Sua lista de amigos já está vazia!");
    	}
    	
    }

    @FXML
    void verArestasBonitas(ActionEvent event) {
    	arestasBonitas=toggleArestasBonitas.isSelected();
    	grafo.mudarAresta(arestasBonitas);
    	//grafo.setarArestas(arestasBonitas);
    	grafo.construirgrafo(arestasBonitas);
    	if(toggleVerPastores.isSelected()) {
    		grafo.setarNosPossiveisPastores();
    	}
    	else if(toggleRecomendacao.isSelected()) {
    		verRecomendacaoGrafo(null);
    	}
    	else {
    		verSeitasGrafo(null);
    	}
    }

    @FXML
    void verPastoresGrafo(ActionEvent event) {
    	grafo.setarNos();
    	toggleRecomendacao.setSelected(false);
    	toggleSeitasGrafo.setSelected(false);
    	tfRecomendacaoGrafo.setDisable(true);
    	sliderSeita.setDisable(true);
    	grafo.setarNosPossiveisPastores();
    	if(!toggleVerPastores.isSelected()) {
    		toggleVerPastores.setSelected(true);
    		return;
    	}
    }

    @FXML
    void verRecomendacaoGrafo(ActionEvent event) {
    	toggleVerPastores.setSelected(false);
    	toggleSeitasGrafo.setSelected(false);
    	tfRecomendacaoGrafo.setDisable(false);
    	sliderSeita.setDisable(true);
    	if(!toggleRecomendacao.isSelected()) {
    		toggleRecomendacao.setSelected(true);
    		return;
    	}
    	if(!tfRecomendacaoGrafo.getText().isEmpty() && controlador.pesquisarPorLogin(tfRecomendacaoGrafo.getText())!=null) {
    		recomendarAmigosGrafo(null);
    	}
    	else {
    		grafo.setarNos();
    		//grafo.construirgrafo(arestasBonitas);
    	}
    }

    @FXML
    void verSeitasGrafo(ActionEvent event) {
    	toggleRecomendacao.setSelected(false);
    	toggleVerPastores.setSelected(false);
    	tfRecomendacaoGrafo.setDisable(true);
    	sliderSeita.setDisable(false);
    	if(!toggleSeitasGrafo.isSelected()) {
    		toggleSeitasGrafo.setSelected(true);
    		return;
    	}
        if(toggleSeitasGrafo.isSelected()) {
        	escolherSeitaGrafo();
        }
        
    }

    @FXML
    void escolherSeitaGrafo() {
    	grafo.setarNos();
    	if(controlador.seitasDe3Pessoas().size()>0)grafo.setarSeitas(controlador.seitasDe3Pessoas().get((int) (Math.round(sliderSeita.getValue())-1)));
    }
}

