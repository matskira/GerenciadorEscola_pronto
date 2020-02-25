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
import controller.EstadoController;

public class EstadoView {
	//atributos
		private JFrame janela;
		private JPanel painelDaJanela;
		private JButton btnCadastrar;
		private JButton btnCancelar;
		private JLabel lblNome;
		private JLabel lblUf;
		private JTextField jtfNome;
		private JTextField jtfUf;
		
		public void iniciarGui() {
			//Instancias
			janela = new JFrame("Cadastro de Cidade");
			painelDaJanela = (JPanel) janela.getContentPane();
			btnCadastrar = new JButton();
			btnCancelar = new JButton();
			lblNome = new JLabel();
			jtfNome = new JTextField();
			lblUf = new JLabel();
			jtfUf = new JTextField();
			//configurando botao
			btnCadastrar.setText("Cadastrar");
			btnCadastrar.setBackground(Color.LIGHT_GRAY);
			btnCadastrar.setBounds(200, 120, 110, 20);
			
			//acao do botao configurar
			btnCadastrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					EstadoController novoEstado = new EstadoController();
					novoEstado.consistirDados(jtfUf.getText(), jtfNome.getText());
					jtfUf.setText("");
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
			lblNome.setText("Nome do Estado: ");
			lblNome.setForeground(Color.WHITE);
			lblNome.setBounds(50, 25, 140, 20);
			
			lblUf.setText("UF: ");
			lblUf.setForeground(Color.WHITE);
			lblUf.setBounds(50, 50, 140, 20);
			//Configurando campo de texto
			jtfNome.setBounds(150, 25, 300, 20);
			
			try {
				javax.swing.text.MaskFormatter uf = new javax.swing.text.MaskFormatter("UU");
				jtfUf = new javax.swing.JFormattedTextField(uf);
			} catch (Exception e) {
			}
			jtfUf.setBounds(150, 50, 30, 20);
			//adicionando no painel
			painelDaJanela.add(btnCadastrar);
			painelDaJanela.add(btnCancelar);
			painelDaJanela.add(jtfNome);
			painelDaJanela.add(lblNome);
			painelDaJanela.add(jtfUf);
			painelDaJanela.add(lblUf);
			painelDaJanela.setBackground(Color.DARK_GRAY);
			//configurando a tela
			janela.getContentPane().setLayout(null);
			janela.setSize(500, 200);
			janela.setLocationRelativeTo(null);
			janela.setVisible(true);
			janela.setResizable(false);
			
		}
		
	}


