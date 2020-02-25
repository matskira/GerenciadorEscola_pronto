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

import model.Aluno;
import model.Cidade;

public class CidadeController {

	public void consistirDados(String nome) {
		Cidade c1 = new Cidade();
		c1.setNome(nome);
		inserirCidade(c1);
		JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso");
	}
	
	public void inserirCidade(Cidade cidade) {

		try {
			File arquivo = new File("cidade.txt");
			FileOutputStream arquivoOutput;
			arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			//gravador.print("--Escolha uma opção--"+";");
			gravador.print(cidade.getNome().toUpperCase() + ";");
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
			InputStream is = new FileInputStream("cidade.txt");
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
