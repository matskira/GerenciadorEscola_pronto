package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuView {
	//atributos
	private JFrame janela;
	private JMenuBar barraMenu;
	private JMenu menuCadastrar;
	private JMenu menuRelatorio;
	private JMenuItem itemMenu1CadastrarAluno;
	private JMenuItem itemMenu2CadastrarFuncionario;
	private JMenuItem itemMenu3CadastrarEstado;
	private JMenuItem itemMenu4CadastrarCidade;
	private JMenuItem itemMenu5RelatorioAluno;
	private JMenuItem itemMenu6RelatorioFuncionario;
	private JPanel painelDaJanela;
	
	
	public void iniciaGui() {
		//criar instancias
		janela = new JFrame();
		barraMenu = new JMenuBar();
		painelDaJanela = (JPanel) janela.getContentPane();
		painelDaJanela.setBackground(Color.LIGHT_GRAY);
		menuCadastrar = new JMenu("Cadastrar");
		menuCadastrar.setForeground(Color.WHITE);
		menuRelatorio = new JMenu("Relatorios");
		menuRelatorio.setForeground(Color.WHITE);
		itemMenu1CadastrarAluno = new JMenuItem("Cadastro de Aluno");
		itemMenu2CadastrarFuncionario = new JMenuItem("Cadastro de Funcionarios");
		itemMenu3CadastrarEstado = new JMenuItem("Cadastro de Estado");
		itemMenu4CadastrarCidade= new JMenuItem("Cadastro de Cidade");
		itemMenu5RelatorioAluno= new JMenuItem("Relatorio de Alunos");
		itemMenu6RelatorioFuncionario = new JMenuItem("Relatorio de Funcionarios");
		
		//Acrescentar menus na barra de menu
		barraMenu.add(menuCadastrar);
		barraMenu.add(menuRelatorio);
		barraMenu.setBackground(Color.DARK_GRAY);
		
		//Acrescentar itens de menu nos menus
		menuCadastrar.add(itemMenu1CadastrarAluno);
		menuCadastrar.add(itemMenu2CadastrarFuncionario);
		menuCadastrar.add(itemMenu3CadastrarEstado);
		menuCadastrar.add(itemMenu4CadastrarCidade);
		menuRelatorio.add(itemMenu5RelatorioAluno);
		menuRelatorio.add(itemMenu6RelatorioFuncionario);
		
		//Configurando acao do menu cadastrar aluno
		itemMenu1CadastrarAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AlunoView().iniciarGui();
			}
		});
		
		//Configurando acao do menu cadastrar funcionario
		itemMenu2CadastrarFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioView().iniciarGui();
			}
		});
		
		//Configurando acao do menu cadastrar estado
		itemMenu3CadastrarEstado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EstadoView().iniciarGui();
			}
		});
		
		//Configurando acao do menu cadastrar cidade
		itemMenu4CadastrarCidade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CidadeView().iniciarGui();
			}
		});
		
		//Configurando acao do menu relatorio alunos
		itemMenu5RelatorioAluno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AlunoRelatorioView().iniciarGui();
			}
		});
		
		//Configurando acao do menu relatorio funcionarios
		itemMenu6RelatorioFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioRelatorioView().iniciarGui();
			}
		});
		
		//configurando o painel da tela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(barraMenu);
	
		//config de tela
		janela.setJMenuBar(barraMenu);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(350, 350);
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		
		
	}
}
