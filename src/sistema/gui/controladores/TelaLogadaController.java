
package sistema.gui.controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.graphstream.graph.Graph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
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
	Callback<ListView<UsuarioTerraplanista>, ListCell<UsuarioTerraplanista>> callback = new Callback<ListView<UsuarioTerraplanista>, ListCell<UsuarioTerraplanista>>() {
		
		@Override
		public ListCell<UsuarioTerraplanista> call(ListView<UsuarioTerraplanista> arg0) {
			ListCell<UsuarioTerraplanista> cell = new ListCell<UsuarioTerraplanista>() {
				@Override
				protected void updateItem(UsuarioTerraplanista usuario, boolean btl) {
					super.updateItem(usuario, btl);
					if(usuario!=null) {
						Image img = new Image(usuario.getImage());
						ImageView imgView = new ImageView(img);
						imgView.setFitHeight(25);
						imgView.setFitWidth(25);
						setGraphic(imgView);
						setText(usuario.getNome());
						
					}
				}
			
			};
			return cell;
		}
	};
	
    
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
    private JFXToggleButton toggleSeitasGrafo;

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
    private JFXToggleButton toggleArestasBonitas;

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
    private Label labelAvisoConvites;
    
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
			}
			else {
				pane_doaçao.toFront();
				Alert alerta = new Alert(AlertType.WARNING);
				alerta.setContentText("Enquanto isso, faça uma doação... Vai que Ele fica feliz e lhe dá autorização. :)");
				alerta.setHeaderText("Para ele deixar, você precisa ser uma pessoa influente na comunidade.");
				alerta.setTitle("Sr Salamandra ainda não deixa você visualizar essa página!");
				alerta.showAndWait();
			}
		}
		else if(e.getSource() == bnt_amigos) {
			pane_amigos.toFront();
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
    	
    	pane_perfil.toFront();
    	inicializaComboBoxInteresses();
    	inicializaPerfil();
    	inicializaPane();
    	inicializaAmigos();
    	inicializaEditar();
    	inicializaFotos();
    	atualizarRecomendados();
    	toggleArestasBonitas.setSelected(true);
    	
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
    	lv_pesquisa.setCellFactory(callback);
    	//lv_amigos.setCellFactory(callback);
    	lv_amigos.setItems(FXCollections.observableList(listaAmigos));
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
    		System.out.println(comboboxInteresses.getSelectionModel().getSelectedItem());
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
    	
    	
    	recomendados = controlador.recomendacoesPara(contaLogada);
    	try{
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
    	recomendados = controlador.recomendacoesPara(contaLogada);
    	/*System.out.println(recomendados);
    	System.out.println(e);
    	for(UsuarioTerraplanista u : recomendados) {
    		if(e.contains(u)) {
    			e.remove(u);
    		}
    	}
    	*/
    	
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
    	//lv_amigos.setCellFactory(callback);
    	lv_amigos.setItems(FXCollections.observableList(listaAmigos));
    	grafo.construirgrafo(arestasBonitas);
    	lv_amigos.refresh();
    }
    
    void atualizarListaConvites() {
    	
    	Collections.sort(convites, new Comparator<UsuarioTerraplanista>()
        {
            public int compare(UsuarioTerraplanista f1, UsuarioTerraplanista f2)
            {
                return f1.toString().compareTo(f2.toString());
            }        
        });
    	//lvConvites.setCellFactory(callback);
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
    	//lv_pesquisa.setCellFactory(callback);
    	lv_pesquisa.setItems(FXCollections.observableList(listaDeUsuarios));
    	grafo.construirgrafo(arestasBonitas);
    	lv_pesquisa.refresh();
    }
    
    boolean isAmigo(UsuarioTerraplanista usuario) {
    	for(int i=0; i<listaAmigos.size(); i++) {
    		if(listaAmigos.get(i).equals(usuario)) {
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
    void verSeitasGrafo(ActionEvent event) {
    	if(toggleSeitasGrafo.isSelected()) {
    		grafo.construirgrafo(arestasBonitas);
    		//TODO pesquisar
    	}
    }

    @FXML
    void recomendarAmigosGrafo(ActionEvent event) {
    	grafo.construirgrafo(arestasBonitas);
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
    void verArestasBonitas() {
    	arestasBonitas=toggleArestasBonitas.isSelected();
    	grafo.setarArestas(arestasBonitas);
    	grafo.construirgrafo(toggleArestasBonitas.isSelected());
    }
    
    @FXML
    void abrirTelaConvite() {
    	paneConvites.toFront();
    	//lvConvites.setCellFactory(callback);
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
    		controlador.salvar();
    		//TODO deixar esse nome verde na lista de amigos
    		listaAmigos.add(lvConvites.getSelectionModel().getSelectedItem());
    		listaDeUsuarios.remove(lvConvites.getSelectionModel().getSelectedItem());
    		recomendados.remove(lvConvites.getSelectionModel().getSelectedItem());
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
    		labelAvisoConvites.setText("");
    		controlador.removerConvite(lvConvites.getSelectionModel().getSelectedItem(), contaLogada);
    		controlador.salvarConvites();
    		atualizarListaConvites();
    	}
    }
    
    @FXML
    void enviarConvite() {
    	if(lv_pesquisa.getSelectionModel().getSelectedItem()!=null) {
    		labelAvisoConvites.setText("");
    		controlador.enviarConvite(contaLogada, lv_pesquisa.getSelectionModel().getSelectedItem());
        	controlador.salvarConvites();
        	listaAmigos.add(lv_pesquisa.getSelectionModel().getSelectedItem());
        	//TODO trocar a cor do texto pra amarelo
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
    			controlador.enviarConvite(contaLogada, listaDeUsuarios.get(i));
    			controlador.salvarConvites();
    		}
    		//TODO trocar cor do nome pra amarelo
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
    		labelAvisoAmigos.setText("");
    		controlador.enviarConvite(contaLogada, lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
    		controlador.salvarConvites();
    		listaAmigos.add(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
    		//TODO troca cor do nome pra amarelo
    		recomendados.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
    		listaDeUsuarios.remove(lvRecomendacaoAmigos.getSelectionModel().getSelectedItem());
    		atualizarListaAmigos();
    		atualizarRecomendados();
    		atualizarListaUsuarios();
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
    			controlador.enviarConvite(contaLogada, recomendados.get(i));
    			controlador.salvarConvites();
    		}
    		//TODO trocar cor do nome pra amarelo
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
    		/*if(texto amarelo) {
    			
    		}
    		else if(texto verde) {
    			if(recomendados.contains(lv_amigos.getSelectionModel().getSelectedItem())) {
        			recomendados.remove(lv_amigos.getSelectionModel().getSelectedItem());
        		}
        		controlador.getUsuarioLogado().getAmigos().remove(lv_amigos.getSelectionModel().getSelectedItem());
        		controlador.salvar();
        		listaAmigos.remove(lv_amigos.getSelectionModel().getSelectedItem());
        		listaDeUsuarios.add(lv_amigos.getSelectionModel().getSelectedItem());
        		atualizarListaAmigos();
        		atualizarListaUsuarios();
        		atualizarRecomendados();
    		}*/
    		
    	}
    	else {
    		labelAvisoAmigos.setText("Selecione alguém para remover!");
    		
    	}
    }
    
    @FXML 
    void removeGeral() {
    	if(!listaAmigos.isEmpty()) {
    		//TODO adaptar para o esquema de convites
    		
    		/*labelAvisoAmigos.setText("");
    		controlador.getUsuarioLogado().getAmigos().removeAll(listaAmigos);
    		controlador.salvar();
    		for(UsuarioTerraplanista u : listaAmigos) {
    			if(recomendados.contains(u)) {
    				recomendados.remove(u);
    			}
    		}
    		listaDeUsuarios.addAll(listaAmigos);
        	listaAmigos.removeAll(listaAmigos);
        	atualizarListaAmigos();
        	atualizarListaUsuarios();
    		atualizarRecomendados();*/
    	}
    	else {
    		labelAvisoAmigos.setText("Sua lista de amigos já está vazia!");
    	}
    	
    }
}

