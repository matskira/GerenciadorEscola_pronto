package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JOptionPane;

import model.Cidade;
import model.Estado;

public class EstadoController {

		public void consistirDados(String uf, String nomeEstado) {
			Estado novoEstado = new Estado();
			novoEstado.setUf(uf);
			novoEstado.setNome(nomeEstado);
			inserirEstado(novoEstado);
			JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso");
		}
		
		public void inserirEstado(Estado estado) {

			try {
				File arquivo = new File("estado.txt");
				FileOutputStream arquivoOutput;
				arquivoOutput = new FileOutputStream(arquivo, true);
				PrintStream gravador = new PrintStream(arquivoOutput);
				//gravador.print("--Escolha uma opção--"+";");
				gravador.print(estado.getUf().toUpperCase() +"-"+ estado.getNome().toUpperCase() + ";");
				gravador.print("\n");
				gravador.close();
				arquivoOutput.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public String listarTodos() {
			String dados = "";
					
			try {
				InputStream is = new FileInputStream("estado.txt");
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader leitor = new BufferedReader(isr);
				String texto = leitor.readLine();
				while (texto != null) {
					String separaDados[] = texto.split(";");
					dados+=separaDados[0]+";";				
					texto = leitor.readLine();
					
				}
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo de entrada não encontrada");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Arquivo de entrada não encontrada");
				e.printStackTrace();
			}
			return dados;
		}
}
