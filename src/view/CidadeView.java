package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CidadeController;

public class CidadeView {
	//atributos
	private JFrame janela;
	private JPanel painelDaJanela;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JLabel lblNome;
	private JTextField jtfNome;
	
	public void iniciarGui() {
		//Instancias
		janela = new JFrame("Cadastro de Cidade");
		painelDaJanela = (JPanel) janela.getContentPane();
		btnCadastrar = new JButton();
		btnCancelar = new JButton();
		lblNome = new JLabel();
		jtfNome = new JTextField();
		//configurando botao
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.setBackground(Color.LIGHT_GRAY);
		btnCadastrar.setBounds(200, 120, 110, 20);
		
		//acao do botao configurar
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CidadeController novaCidade = new CidadeController();
				novaCidade.consistirDados(jtfNome.getText());
				jtfNome.setText("");
			}
		});
		
		btnCancelar.setText("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(340, 120, 110, 20);
		//acao do botao cancelar
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				janela.dispose();			
			}
		});
		
		//Configurando JLabel
		lblNome.setText("Nome da Cidade: ");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(50, 40, 140, 20);
		
		//Configurando campo de texto
		jtfNome.setBounds(150, 40, 300, 20);
		
		//adicionando no painel
		painelDaJanela.add(btnCadastrar);
		painelDaJanela.add(btnCancelar);
		painelDaJanela.add(jtfNome);
		painelDaJanela.add(lblNome);
		painelDaJanela.setBackground(Color.DARK_GRAY);
		//configurando a tela
		janela.getContentPane().setLayout(null);
		janela.setSize(500, 200);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setResizable(false);
		
	}
	
}
