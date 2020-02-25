package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.FuncionarioController;

import controller.AlunoController;
import controller.CidadeController;
import controller.EstadoController;

public class FuncionarioView {
	//ATRIBUTOS(inicio):
		private JFrame janela;
		private JPanel painelDaJanela;
		private JPanel painelProfessor;
		private JPanel painelSecretaria;
		private JPanel painelFaxineira;
		//Rotulos da parte Info Basicas:
		private JLabel lblInfoBasicas;
		private JLabel lblNome;
		private JLabel lblSexo; //vai ser um radioButton
		private JLabel lblSalario;
		private JLabel lblDataNascimento;//vai ter mascara
		private JLabel lblRg;//mascara
		private JLabel lblCpf;//mascara
		private JLabel lblTelefone;//mascara
		private JLabel lblSenha;
		private JLabel lblEspaco;
		//Rotulo da parte info endereco
		private JLabel lblInfoEndereco;
		private JLabel lblLogradouro;
		private JLabel lblCidade;//box
		private JLabel lblEstado;//box
		private JLabel lblBairro;
		private JLabel lblNumero;
		private JLabel lblComplemento;
		private JLabel lblCep;//mascara
		private JLabel lblUf;
		//Rotulo Professor
		private JLabel lblMateria;
		//Rotulo Secretaria
		private JLabel lblRamal;
		//Rotulo Faxineira
		private JLabel lblTurno;
		//Rotulo da parte info tipo
		private JLabel lblFuncionario;
		//Campos Basicos de info basicas
		private JTextField campoNome;
		private JTextField campoDataNascimento;//vai ter mascara
		private JTextField campoSalario;
		private JTextField campoRg;//vai ter mascara
		private JTextField campoCpf;//vai ter mascara
		private JTextField campoTelefone;//vai ter mascara
		//Campos Basicos de info Endereco;
		private JTextField campoLogradouro;
		private JTextField campoNumero;
		private JTextField campoComplemento;
		private JTextField campoCep;//vai ter mascara
		private JTextField campoBairro;
		private JTextField campoUf;
		//Campo Professor
		private JTextField campoMateria;
		//Campo Secretaria
		private JTextField campoRamal;
		//Campos Especiais de info basicas
		private JRadioButton rbtSexoMasculino;//Radio Button do genero
		private JRadioButton rbtSexoFeminino;
		private JPasswordField jpwSenha;
		//Campo turno faxineira
		private JRadioButton rbtMatutino;
		private JRadioButton rbtNoturno;
		//Campos Especiais de info endereco
		private JComboBox cboxCidade;
		private JComboBox cboxEstado;
		//Combo Box do tipo;
		private JComboBox cboxTipo;
		//Botoes
		private JButton btnSalvar;
		private JButton btnCancelar;
		private JButton btnEscolher;
		private JButton btnIncluirMateria;
		//Area de texto materia
		private JTextArea areaMateria;
		//Grupo botoes
		private ButtonGroup grpRadio;
		private ButtonGroup grpRadioTurno;
		//Vetor com Cidades e Estado
		EstadoController estado = new EstadoController();
		String nomeEstado[] = estado.listarTodos().split(";");
		CidadeController cidade = new CidadeController();
		String nomeCidade[] = cidade.listarTodos().split(";");
		//private String [] Estado = {"--Escolha uma op��o--","SP - S�o Paulo", "RJ - Rio de Janeiro", "MG - Minas Gerais", "RS - Rio Grande Do Sul", "BH - Bahia" };
		//private String [] Cidade = {"--Escolha uma op��o--","Osasco", "Barueri", "B�zios", "Belo Horizonte", "S�o Jos� dos Pinhais" };
		//Vetor tipos de funcionarios
		private String [] Funcionarios = {"--Escolha uma op��o--","Professor", "Secretaria","Faxineira"};
		//ATRIBUTOS(FIM)
		
		
		
		public void iniciarGui() {//iniciar metodo iniciarGui
			//CRIAR AS INSTANCIAS
			//instancias do painel e da janela
			//instancias da janela e to painel
			janela = new JFrame("Cadastro de Funcionario");
			painelDaJanela = (JPanel) janela.getContentPane();
			painelProfessor = new JPanel();
			painelSecretaria = new JPanel();
			painelFaxineira = new JPanel();
			//instancias parte info basica(rotulo)
			lblInfoBasicas = new JLabel();
			lblNome = new JLabel();
			lblSexo = new JLabel();
			lblSalario = new JLabel();
			lblDataNascimento = new JLabel();
			lblRg = new JLabel();
			lblCpf = new JLabel();
			lblTelefone = new JLabel();
			lblSenha = new JLabel();
			lblEspaco = new JLabel();
			//instancias parte info endereco(rotulo)
			lblInfoEndereco = new JLabel();
			lblLogradouro = new JLabel();
			lblCidade = new JLabel();
			lblEstado = new JLabel();
			lblNumero = new JLabel();
			lblComplemento = new JLabel();
			lblCep = new JLabel();
			lblUf = new JLabel();
			lblBairro = new JLabel();
			lblFuncionario = new JLabel();
			//instancias campo basico info basica
			campoNome = new JTextField();
			campoSalario = new JTextField();
			campoDataNascimento = new JTextField();
			campoRg = new JTextField();
			campoCpf = new JTextField();
			campoTelefone = new JTextField();
			//instancias campo basico info endereco
			campoLogradouro = new JTextField();
			campoNumero = new JTextField();
			campoComplemento = new JTextField();
			campoCep = new JTextField();
			campoUf = new JTextField();
			campoBairro = new JTextField();
			//instancias campo especial info basica
			rbtSexoMasculino = new JRadioButton();
			rbtSexoFeminino = new JRadioButton();
			rbtMatutino = new JRadioButton();
			rbtNoturno = new JRadioButton();
			jpwSenha = new JPasswordField();
			//instancias campo especial info endereco
			cboxCidade = new JComboBox();
			cboxCidade.setModel(new DefaultComboBoxModel(nomeCidade));
			cboxEstado = new JComboBox();
			cboxEstado.setModel(new DefaultComboBoxModel(nomeEstado));
			//Instancia comboBox
			cboxTipo = new JComboBox(Funcionarios);
			//instanciar botoes
			btnSalvar = new JButton("Salvar");
			btnCancelar = new JButton("Cancelar");
			btnEscolher = new JButton("Escolher");
			//instanciar grupo de botoes
			grpRadio = new ButtonGroup();
			grpRadioTurno = new ButtonGroup();
			//FIM INSTANCIAS
			
			//Adicionar o radiobutton no grupo de botoes
			grpRadio.add(rbtSexoMasculino);
			grpRadio.add(rbtSexoFeminino);
			grpRadioTurno.add(rbtMatutino);
			grpRadioTurno.add(rbtNoturno);
		
			
			//CONFIGURACAO INFO BASICA
			lblInfoBasicas.setText("REGISTRO DE FUNCION�RIO");
			lblInfoBasicas.setBounds(20, 5, 300, 30);
			lblInfoBasicas.setForeground(Color.ORANGE);
			
			//CONFIGURACAO ROTULO E CAMPO NOME
			lblNome.setText("*Nome: ");
			lblNome.setForeground(Color.WHITE);
			lblNome.setBounds(20, 30, 50, 30);
			campoNome.setBounds(70, 36, 220, 19);
			campoNome.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO DO RADIO BUTTON()
			lblSexo.setText("*Sexo do funcion�rio: ");
			lblSexo.setBounds(20, 60, 150, 30);
			lblSexo.setForeground(Color.WHITE);
			rbtSexoMasculino.setText("Masculino");
			rbtSexoMasculino.setBounds(145, 61, 100, 30);
			rbtSexoMasculino.setBackground(Color.DARK_GRAY);
			rbtSexoMasculino.setForeground(Color.WHITE);
			rbtSexoFeminino.setText("Feminino");
			rbtSexoFeminino.setBounds(145, 90, 100, 30);
			rbtSexoFeminino.setBackground(Color.DARK_GRAY);
			rbtSexoFeminino.setForeground(Color.WHITE);
			
			//CONFIGURACAO DO NUMERO DE MATRICULA
			lblSalario.setText("*Sal�rio: ");
			lblSalario.setBounds(20, 115, 100, 30);
			lblSalario.setForeground(Color.WHITE);
			campoSalario.setBounds(90, 120, 200, 19);
			campoSalario.setBackground(Color.LIGHT_GRAY);
			
			
			//CONFIGURACAO DA DATA DE NASCIMENTO
			lblDataNascimento.setText("*Data de nascimento: ");
			lblDataNascimento.setBounds(20, 150, 150, 30);
			lblDataNascimento.setForeground(Color.WHITE);
			
			try {
				javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
				campoDataNascimento = new javax.swing.JFormattedTextField(dt);
			} catch (Exception e) {
			}
			campoDataNascimento.setBackground(Color.LIGHT_GRAY);
			campoDataNascimento.setBounds(150, 155, 140, 19);
			
			//CONFIGURACAO DO RG
			lblRg.setText("*RG: ");
			lblRg.setBounds(340, 30, 50, 30);
			lblRg.setForeground(Color.WHITE);		
			try {
				javax.swing.text.MaskFormatter rg = new javax.swing.text.MaskFormatter("##.###.###-H");
				campoRg = new javax.swing.JFormattedTextField(rg);
			} catch (Exception e) {
			}
			campoRg.setBackground(Color.LIGHT_GRAY);
			campoRg.setBounds(375, 36, 200, 19);
					
			//CONFIGURACAO CPF
			lblCpf.setText("*CPF: ");
			lblCpf.setBounds(340, 70, 50, 30);
			lblCpf.setForeground(Color.WHITE);
			
			try {
				javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
				campoCpf = new javax.swing.JFormattedTextField(cpf);
			} catch (Exception e) {
			}
			campoCpf.setBackground(Color.LIGHT_GRAY);
			campoCpf.setBounds(375, 75, 200, 19);
			
			//CONFIGURACAO TELEFONE
			lblTelefone.setText("*Telefone: ");
			lblTelefone.setBounds(340, 110, 80, 30);
			lblTelefone.setForeground(Color.WHITE);
			campoTelefone.setBackground(Color.LIGHT_GRAY);
			campoTelefone.setBounds(400, 115, 175, 19);
			try {
				javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##)#####-####");
				campoTelefone = new javax.swing.JFormattedTextField(telefone);
			} catch (Exception e) {
			}
			campoTelefone.setBackground(Color.LIGHT_GRAY);
			campoTelefone.setBounds(400, 115, 175, 19);
			
//			//CONFIGURACAO SENHA
//			lblSenha.setText("*Senha: ");
//			lblSenha.setBounds(340, 150, 50, 30);
//			lblSenha.setForeground(Color.WHITE);
//			jpwSenha.setBounds(390, 155, 185, 19);
//			jpwSenha.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO INFO ENDERECO
			lblInfoEndereco.setText("ENDERE�O DO FUNCIONARIO");
			lblInfoEndereco.setBounds(20, 200, 300, 30);
			lblInfoEndereco.setForeground(Color.ORANGE);
			lblEspaco.setText("-------------------------------------------------------------------------------------------------"
					+ "------------------------------------------");
			lblEspaco.setBounds(20, 180, 565, 30);
			lblEspaco.setForeground(Color.WHITE);
			
			//CONFIGURACAO LOGRADOURO
			lblLogradouro.setText("*Logradouro: ");
			lblLogradouro.setBounds(20, 225, 100, 30);
			lblLogradouro.setForeground(Color.WHITE);
			campoLogradouro.setBounds(110, 230, 180, 19);
			campoLogradouro.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO BOX CIDADE
			lblCidade.setText("*Cidade: ");
			lblCidade.setBounds(20, 263, 60, 30);
			lblCidade.setForeground(Color.WHITE);
			cboxCidade.setSelectedIndex(0);
			cboxCidade.setBounds(70, 270, 220, 19);
			cboxCidade.setMaximumRowCount(10);
			cboxCidade.setBackground(Color.LIGHT_GRAY);
		//	cboxCidade.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO BOX ESTADO
			lblEstado.setText("*Estado: ");
			lblEstado.setBounds(20, 305, 60, 30);
			lblEstado.setForeground(Color.WHITE);
			cboxEstado.setSelectedIndex(0);
			cboxEstado.setBounds(70, 313, 220, 19);
			cboxEstado.setMaximumRowCount(10);
			cboxEstado.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO NUMERO
			lblNumero.setText("*Numero: ");
			lblNumero.setBounds(340, 225, 60, 30);
			lblNumero.setForeground(Color.WHITE);
			campoNumero.setBounds(400, 230, 175, 19);
			campoNumero.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO COMPLEMENTO
			lblComplemento.setText("Complemento: ");
			lblComplemento.setBounds(340, 263, 90, 30);
			lblComplemento.setForeground(Color.WHITE);
			campoComplemento.setBounds(430, 270, 145, 19);
			campoComplemento.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO CEP
			lblCep.setText("*CEP: ");
			lblCep.setBounds(340, 305, 50, 30);
			lblCep.setForeground(Color.WHITE);
			campoCep.setBackground(Color.LIGHT_GRAY);
			campoCep.setBounds(380, 310, 195, 19);
			try {
				javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
				campoCep = new javax.swing.JFormattedTextField(cep);
			} catch (Exception e) {
			}
			campoCep.setBackground(Color.LIGHT_GRAY);
			campoCep.setBounds(380, 310, 195, 19);
			
//			//CONFIGURACAO DO UF
//			lblUf.setText("UF: ");
//			lblUf.setBounds(20, 342, 30, 30);
//			lblUf.setForeground(Color.WHITE);
//			campoUf.setBounds(50, 348, 50, 19);
//			campoUf.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO DO BAIRRO
			lblBairro.setText("*Bairro: ");
			lblBairro.setBounds(20, 345, 50, 30);
			lblBairro.setForeground(Color.WHITE);
			campoBairro.setBounds(70, 350, 221, 19);
			campoBairro.setBackground(Color.LIGHT_GRAY);
			
			//CONFIGURACAO COMBO BOX FUNCIONARIO
			lblFuncionario.setText("*TIPO DE FUNCIONARIO");
			lblFuncionario.setBounds(680, 30, 150, 30);
			lblFuncionario.setForeground(Color.WHITE);
			cboxTipo.setSelectedIndex(0);
			cboxTipo.setBounds(650, 60, 220, 19);
			cboxTipo.setMaximumRowCount(10);
			cboxTipo.setBackground(Color.LIGHT_GRAY);
			// CONFIGURACAO DO BOTAO SALVAR
			btnSalvar.setText("SALVAR");
			btnSalvar.setBounds(340, 400, 100, 28);
			btnSalvar.setBackground(Color.LIGHT_GRAY);
			btnSalvar.setForeground(Color.DARK_GRAY);
			//ACAO DO BOTAO Salvar
			btnSalvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					FuncionarioController f1 = new FuncionarioController();
					String id = "0";
					String sexo = selecionarSexo();
					String cidadeU = selecionarBoxCidade();
					String estadoU = selecionarBoxEstado();
					if(cboxTipo.getSelectedItem().toString() == "--Escolha uma op��o--") {
						id = "0";
						JOptionPane.showMessageDialog(null, "Selecione o tipo de funcionario!","ERRORx0290",JOptionPane.ERROR_MESSAGE);
					}else {
						if(cboxTipo.getSelectedItem().toString() == "Professor") {
							id = "1";
						}
						if(cboxTipo.getSelectedItem().toString() == "Secretaria") {
							id = "2";
						}
						if(cboxTipo.getSelectedItem().toString() == "Faxineira") {
							id = "3";
						}
						f1.consistirDados(id,campoNome.getText(), sexo, campoSalario.getText(), campoDataNascimento.getText(), campoRg.getText()
								, campoCpf.getText(), campoTelefone.getText(), campoLogradouro.getText(), cidadeU, estadoU, 
								campoBairro.getText(), campoNumero.getText(), campoComplemento.getText(), campoCep.getText());
						campoNome.setText("");
						sexo = "";
						campoSalario.setText("");;
						campoDataNascimento.setText("");
						campoRg.setText("");
						campoCpf.setText("");
						campoTelefone.setText("");
						jpwSenha.setText("");
						campoLogradouro.setText("");
						cidadeU = "";
						estadoU = "";
						campoBairro.setText("");
						campoNumero.setText("");
						campoComplemento.setText("");
						campoCep.setText("");
						cboxCidade.setSelectedIndex(0);
						cboxEstado.setSelectedIndex(0);	
						cboxTipo.setSelectedIndex(0);
					}
				}
			});
			
			// CONFIGURACAO DO BOTAO CANCELAR
			btnCancelar.setText("CANCELAR");
			btnCancelar.setBounds(475, 400, 100, 28);
			btnCancelar.setBackground(Color.LIGHT_GRAY);
			btnCancelar.setForeground(Color.DARK_GRAY);
			
			//ACAO DO BOTAO CANCELAR
			btnCancelar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					janela.dispose();	
					
				}
			});
			
			// CONFIGURACAO DO BOTAO ESCOLHER
			btnEscolher.setText("ESCOLHER");
			btnEscolher.setBounds(880, 60, 100, 19);
			btnEscolher.setBackground(Color.LIGHT_GRAY);
			btnEscolher.setForeground(Color.DARK_GRAY);
			
			//adicionando coisas no painel professor
			lblMateria = new JLabel();
			lblMateria.setText("Mat�ria:");
			lblMateria.setBounds(5, 15, 100, 19);
			lblMateria.setForeground(Color.WHITE);
			campoMateria = new JTextField();
			campoMateria.setBounds(55, 15, 200, 20);
			campoMateria.setBackground(Color.LIGHT_GRAY);
			btnIncluirMateria = new JButton();
			btnIncluirMateria.setText("ADD");
			btnIncluirMateria.setBounds(260, 15, 60, 19);
			btnIncluirMateria.setBackground(Color.LIGHT_GRAY);
			btnIncluirMateria.setForeground(Color.DARK_GRAY);
			areaMateria = new JTextArea();
			areaMateria.setBounds(15, 45, 300, 240);
			areaMateria.setBorder(BorderFactory.createEtchedBorder());
			areaMateria.setBackground(Color.LIGHT_GRAY);
			areaMateria.setEditable(false);
			//acao do botao add (dps ver em gravar essa info em uma arrayList)
			btnIncluirMateria.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					areaMateria.append(campoMateria.getText().toUpperCase() + "\n");				
					campoMateria.setText("");
				}
			});			
			//config painel professor
			painelProfessor.setLayout(null);
			painelProfessor.setBackground(Color.DARK_GRAY);
			painelProfessor.setBorder(BorderFactory.createRaisedBevelBorder());
			painelProfessor.setBounds(650, 90, 330, 300);
			painelProfessor.setVisible(false);
			painelProfessor.add(lblMateria);
			painelProfessor.add(campoMateria);
			painelProfessor.add(btnIncluirMateria);
			painelProfessor.add(areaMateria);
			
			//colocando os componentes do secretaria
			lblRamal = new JLabel();
			lblRamal.setText("Ramal:");
			lblRamal.setBounds(20, 30, 60, 20);
			lblRamal.setForeground(Color.WHITE);
			campoRamal = new JTextField();
			campoRamal.setBounds(70, 30, 120, 20);
			campoRamal.setBackground(Color.LIGHT_GRAY);
			//config painel secretaria
			painelSecretaria.setLayout(null);
			painelSecretaria.setBackground(Color.DARK_GRAY);
			painelSecretaria.setBorder(BorderFactory.createRaisedBevelBorder());
			painelSecretaria.setBounds(650, 90, 220, 100);
			painelSecretaria.setVisible(false);
			painelSecretaria.add(lblRamal);
			painelSecretaria.add(campoRamal);
			
			//Adicionando componentes painel secretaria
			lblTurno = new JLabel();
			lblTurno.setText("Turno:");
			lblTurno.setForeground(Color.WHITE);
			lblTurno.setBounds(20, 30, 60, 20);
			rbtMatutino.setText("Matutino");
			rbtMatutino.setBounds(70, 30, 120, 20);
			rbtMatutino.setBackground(Color.DARK_GRAY);
			rbtMatutino.setForeground(Color.WHITE);
			rbtNoturno.setText("Noturno");
			rbtNoturno.setBounds(70, 70, 120, 20);
			rbtNoturno.setBackground(Color.DARK_GRAY);
			rbtNoturno.setForeground(Color.WHITE);
			//Config painel Faxineira
			painelFaxineira.setLayout(null);
			painelFaxineira.setBackground(Color.DARK_GRAY);
			painelFaxineira.setBorder(BorderFactory.createRaisedBevelBorder());
			painelFaxineira.setBounds(650, 90, 220, 150);
			painelFaxineira.setVisible(false);
			painelFaxineira.add(lblTurno);
			painelFaxineira.add(rbtMatutino);
			painelFaxineira.add(rbtNoturno);
			// CONFIGURACAO DO BOTAO ESCOLHER
			btnEscolher.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(cboxTipo.getSelectedItem().toString() == "--Escolha uma op��o--") {
						painelProfessor.setVisible(false);
						painelSecretaria.setVisible(false);
						painelFaxineira.setVisible(false);
					} 
					if(cboxTipo.getSelectedItem().toString() == "Professor") {
							
						painelProfessor.setVisible(true);
						painelSecretaria.setVisible(false);
						painelFaxineira.setVisible(false);
					}
					if(cboxTipo.getSelectedItem().toString() == "Secretaria") {
						painelSecretaria.setVisible(true);
						painelProfessor.setVisible(false);
						painelFaxineira.setVisible(false);
					}
					if(cboxTipo.getSelectedItem().toString() == "Faxineira") {
						painelFaxineira.setVisible(true);
						painelSecretaria.setVisible(false);
						painelProfessor.setVisible(false);
					}
				}
			});
			
			
			
						
			//Configuracao do Painel Da Tela
			painelDaJanela.setLayout(null);
			painelDaJanela.setBackground(Color.DARK_GRAY);
			//CONFIGURACAO DO PAINEL PROFESSOR
			
			//Adicionando no painel
			painelDaJanela.add(lblInfoBasicas);
			painelDaJanela.add(lblNome);
			painelDaJanela.add(campoNome);
			painelDaJanela.add(lblSexo);
			painelDaJanela.add(rbtSexoMasculino);
			painelDaJanela.add(rbtSexoFeminino);
			painelDaJanela.add(lblSalario);
			painelDaJanela.add(campoSalario);
			painelDaJanela.add(lblDataNascimento);
			painelDaJanela.add(campoDataNascimento);
			painelDaJanela.add(lblRg);
			painelDaJanela.add(campoRg);
			painelDaJanela.add(lblCpf);
			painelDaJanela.add(campoCpf);
			painelDaJanela.add(lblTelefone);
			painelDaJanela.add(campoTelefone);
			painelDaJanela.add(lblSenha);
			painelDaJanela.add(jpwSenha);
			painelDaJanela.add(lblEspaco);
			painelDaJanela.add(lblInfoEndereco);
			painelDaJanela.add(lblLogradouro);
			painelDaJanela.add(campoLogradouro);
			painelDaJanela.add(lblCidade);
			painelDaJanela.add(cboxCidade);
			painelDaJanela.add(lblEstado);
			painelDaJanela.add(cboxEstado);
			painelDaJanela.add(lblNumero);
			painelDaJanela.add(campoNumero);
			painelDaJanela.add(lblComplemento);
			painelDaJanela.add(campoComplemento);
			painelDaJanela.add(lblCep);
			painelDaJanela.add(campoCep);
			painelDaJanela.add(lblUf);
			painelDaJanela.add(campoUf);
			painelDaJanela.add(lblBairro);
			painelDaJanela.add(campoBairro);
			painelDaJanela.add(btnSalvar);
			painelDaJanela.add(btnCancelar);
			painelDaJanela.add(btnEscolher);
			painelDaJanela.add(lblFuncionario);
			painelDaJanela.add(cboxTipo);
			painelDaJanela.add(painelProfessor);
			painelDaJanela.add(painelSecretaria);
			painelDaJanela.add(painelFaxineira);
			
			
			//Configuracao da tela
			//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setSize(1000, 500);
			janela.setVisible(true);
			janela.setResizable(false);
			janela.setLocationRelativeTo(null);
			
			
			
		}//fim metodo iniciarGui
		public String selecionarSexo() {//inicio do verificar qual radio button foi selecionado
			String respostaSexo = "";
			if(rbtSexoMasculino.isSelected()) {
				respostaSexo += rbtSexoMasculino.getText();
			}
			if(rbtSexoFeminino.isSelected()) {
				respostaSexo += rbtSexoFeminino.getText();
			}
			return respostaSexo;
		}//fim do verificar qual radioButton foi selecionado
		
		public String pegarRamal() {
			String respostaRamal = "";
			respostaRamal += campoRamal.getText();
			return respostaRamal;
		}
		
		public String selecionarTurno() {//inicio do verificar qual radio button foi selecionado
			String respostaTurno = "";
			if(rbtMatutino.isSelected()) {
				respostaTurno += rbtMatutino.getText();
			}
			if(rbtNoturno.isSelected()) {
				respostaTurno += rbtNoturno.getText();
			}
			return respostaTurno;
			
		}//fim do verificar qual radioButton foi selecionado
		
		public List<String> pegarAreaMaterias() {
			List<String> listaMateriais = new ArrayList<String>();
			listaMateriais.add(areaMateria.getText());
			return listaMateriais;
		}
		
		public String selecionarBoxCidade() {//Inicio do verificar qual CBox foi selecionado
			String respostaBoxCidade = cboxCidade.getSelectedItem().toString();
			if (respostaBoxCidade == "--Escolha uma op��o--" ) {
				return "";
			}
			return respostaBoxCidade;
		}//Fim do verificar qual CBox foi selecionado
		
		
		public String selecionarBoxEstado() {//Inicio do verificar qual CBox foi selecionado
			
			String respostaBoxEstado = cboxEstado.getSelectedItem().toString();
			if (respostaBoxEstado == "--Escolha uma op��o--" ) {
				return "";
			}
			return respostaBoxEstado;
		}//Fim do verificar qual CBox foi selecionado
}