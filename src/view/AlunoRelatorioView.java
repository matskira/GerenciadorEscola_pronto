package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.accessibility.internal.resources.accessibility;

import controller.AlunoController;
import jdk.nashorn.internal.ir.WhileNode;
import model.Aluno;

public class AlunoRelatorioView {
	
	//Atributos(Inicio)
	private JFrame janela;
	private JPanel painelDaJanela;
	//Botoes
	private JButton btnOk;
	//Dados
	private String[] colunas = new String [] {"Nome Aluno","Numero Matricula", "Data Nascimento"};
	AlunoController a1 = new AlunoController();
//	String[] listaDados = a1.listarTodos().split(";");
//	String listaNome = listaDados[0];
//	String listaMatricula = listaDados[1];
//	String listaDataNascimento = listaDados[2];

//	private String[][] linha = new String[] []{
//			{listaNome,listaMatricula,listaDataNascimento}};
			
	//Tabela;
	private JTable tabela;
	//Scroll table
	private JScrollPane painelDeScroll;
	
	
	public void iniciarGui() {
		
		
		//instanciando
		janela = new JFrame("Relatorio de Alunos");
		painelDaJanela = (JPanel) janela.getContentPane();
		btnOk = new JButton();
		//criar tabela
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		String dadosAluno[] = a1.listarTodos().split(",");
		int i=0;
		while(i<dadosAluno.length) {
				String nomeAluno[] = dadosAluno[i].split(";");
				modelo.addRow(nomeAluno);				
				i++;
		}
		tabela = new JTable(modelo);
		tabela.setEnabled(true);
		//adicionando no ScrollPane
		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setBackground(Color.LIGHT_GRAY);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScroll.setBounds(20, 10, 560, 370);
		tabela.setBounds(20, 30, 300, 370);
		tabela.setBackground(Color.LIGHT_GRAY);
		
		//configuracao do botao OK
		btnOk.setText("OK!");
		btnOk.setBounds(200, 400, 200, 50);
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();	
				
			}
		});
		//Configuracao do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(painelDeScroll);
		painelDaJanela.add(btnOk);
		painelDaJanela.setBackground(Color.DARK_GRAY);
		
		//configuração da janela
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		
		
	}
	
}

