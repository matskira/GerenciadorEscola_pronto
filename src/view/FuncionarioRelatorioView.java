package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.FuncionarioController;

public class FuncionarioRelatorioView {
	//Atributos(Inicio)
		private JFrame janela;
		private JTabbedPane painelComAbas;
		//Paineis
		private JPanel painelDaJanela;
		private JPanel abaProfessor;
		private JPanel abaSecretaria;
		private JPanel abaFaxineira;
		//tabela
		private JTable tabelaProfessor;
		private JTable tabelaSecretaria;
		private JTable tabelaFaxineira;
		private String [] colunas = new String [] {"Nome do funcionario","Data Nascimento", "Telefone"};
//		//private String[][] dados = new String[] [] {
//			{"teste","teste","teste"},
//			{"teste","teste","teste"},
//			{"teste","teste","teste"}};
		FuncionarioController f1 = new FuncionarioController();
		//Scroll Pane
		private JScrollPane painelDeScrollProfessor;
		private JScrollPane painelDeScrollSecretaria;
		private JScrollPane painelDeScrollFaxineira;
		//botao
		private JButton btnOk;
		
		public void iniciarGui() {
			//Instanciar
			janela = new JFrame("Relatorio de Funcionarios");
			painelDaJanela = (JPanel) janela.getContentPane();
			painelComAbas = new JTabbedPane();
			abaProfessor = new JPanel();
			abaSecretaria = new JPanel();
			abaFaxineira = new JPanel();
			btnOk = new JButton();
			
			//configurando botao
			btnOk.setText("OK!");
			btnOk.setBounds(220, 420, 100, 20);
			
			//colocando acao do botao ok
			btnOk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					janela.dispose();
				}
			});
			
			//Criando o painel com abas
			painelComAbas.addTab("Professores", abaProfessor);
			painelComAbas.addTab("Secretaria", abaSecretaria);
			painelComAbas.addTab("Faxineira", abaFaxineira);
			painelComAbas.setBounds(14, 10, 550, 400);
			//configurando a tabela e o scroll pane na aba professor
			DefaultTableModel modeloProfessor = new DefaultTableModel(colunas,0);
			tabelaProfessor = new JTable(modeloProfessor);
			tabelaProfessor.setEnabled(true);
			painelDeScrollProfessor = new JScrollPane(tabelaProfessor);
			painelDeScrollProfessor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			tabelaProfessor.setBounds(10, 10, 100, 90);
			painelDeScrollProfessor.setBounds(15, 10, 200, 200);

			//configurando a tabela e o scroll pane na aba secretaria
			DefaultTableModel modeloSecretaria = new DefaultTableModel(colunas,0);
			tabelaSecretaria = new JTable(modeloSecretaria);
			tabelaSecretaria.setEnabled(true);
			painelDeScrollSecretaria = new JScrollPane(tabelaSecretaria);
			painelDeScrollSecretaria.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			tabelaSecretaria.setBounds(10, 10, 100, 90);
			painelDeScrollSecretaria.setBounds(15, 10, 200, 200);

			//configurando a tabela e o scroll pane na aba faxineira
			DefaultTableModel modeloFaxineira = new DefaultTableModel(colunas,0);
			tabelaFaxineira = new JTable(modeloFaxineira);
			tabelaFaxineira.setEnabled(true);
			painelDeScrollFaxineira = new JScrollPane(tabelaFaxineira);
			painelDeScrollFaxineira.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			tabelaFaxineira.setBounds(10, 10, 100, 90);
			painelDeScrollFaxineira.setBounds(15, 10, 200, 200);
			
			//setando o caminho do para tabela
			String dadosFuncionario[] = f1.listarTodos().split(",");
			int i=0;
			while(i<dadosFuncionario.length) {
				
				String nomeFuncionario[] = dadosFuncionario[i].split(";");
				
				if (nomeFuncionario[3].equals("1")) {
					modeloProfessor.addRow(nomeFuncionario);
				}else if (nomeFuncionario[3].equals("2")) {
					modeloSecretaria.addRow(nomeFuncionario);
				}else if (nomeFuncionario[3].equals("3")) {
					modeloFaxineira.addRow(nomeFuncionario);
				}
	
				i++;
			}
			//configurando o painel
			painelDaJanela.setLayout(null);
			painelDaJanela.add(painelComAbas);
			painelDaJanela.add(btnOk);
			painelDaJanela.setBackground(Color.DARK_GRAY);
			abaProfessor.add(painelDeScrollProfessor);
			abaSecretaria.add(painelDeScrollSecretaria);
			abaFaxineira.add(painelDeScrollFaxineira);
			
			//configurando tela
			//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setSize(600, 500);;
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			janela.setResizable(false);
			
			
			
			
			
			
			
			
			
			
		}
		
}
