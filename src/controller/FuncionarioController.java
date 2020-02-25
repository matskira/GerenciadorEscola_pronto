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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;
import model.Funcionario;
import model.Professor;

public class FuncionarioController {

	public void consistirDados(String id, String nome, String sexo, String salario, String dataNascimento, String rg, String cpf,
			String telefone, String logradouro, String cidade, String estado, String bairro,
			String numero, String complemento, String cep) {
		
		if (nome.equals(null) || nome.equals("") || sexo.equals(null) || sexo.equals("") || salario.equals(null)
				|| salario.equals("") || dataNascimento.equals(null) || dataNascimento.equals("") || rg.equals(null)
				|| rg.equals("") || cpf.equals(null) || cpf.equals("") || telefone.equals(null) || telefone.equals("")
				|| logradouro.equals(null) || logradouro.equals("")
				|| cidade.equals(null) || cidade.equals("") || estado.equals(null) || estado.equals("")
				|| bairro.equals(null) || bairro.equals("") || numero.equals(null) || numero.equals("")
				|| cep.equals(null) || cep.equals("")) {

			JOptionPane.showMessageDialog(null, "Favor preencher os campos obrigatórios!", "ERRORx001",
					JOptionPane.ERROR_MESSAGE);

		}else {
				String data1[] = dataNascimento.split("/");
				if (Integer.parseInt(data1[2]) > 2500) {
					JOptionPane.showMessageDialog(null, "Ano Inválido!", "ERRORx109", JOptionPane.ERROR_MESSAGE);
				} else {
					if (Integer.parseInt(data1[1]) > 12) {
						JOptionPane.showMessageDialog(null, "Mês inválido", "ERRORx109", JOptionPane.ERROR_MESSAGE);
					} else {
						if (Integer.parseInt(data1[0]) > 31) {
							JOptionPane.showMessageDialog(null, "Dia inválido", "ERRORx109", JOptionPane.ERROR_MESSAGE);
						} else {
							Funcionario f1 = new Funcionario();
							Endereco e1 = new Endereco();
							e1.setLogradouro(logradouro);
							Cidade c1 = new Cidade();
							c1.setNome(cidade);
							e1.setCidade(c1);
							Estado et1 = new Estado();
							e1.setEstado(et1);
							e1.setBairro(bairro);
							e1.setNumero(Integer.parseInt(numero));
							e1.setComplemento(complemento);
							e1.setCep(cep);				
							f1.setId(id);
							f1.setNome(nome);
							String separaData[] = dataNascimento.split("/");
							Data novaD1 = new Data();
							novaD1.setMes(Integer.parseInt(separaData[1]));
							novaD1.setAno(Integer.parseInt(separaData[2]));
							novaD1.setDia(Integer.parseInt(separaData[0]));
							f1.setDataNascimento(novaD1);
							f1.setSexo(sexo);
							f1.setSalario(salario);
							f1.setRg(rg);
							f1.setCpf(cpf);
							f1.setTelefone(telefone);
							f1.setFuncionarioEndereco(e1);
							inserirFuncionario(f1);
							
							JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
						//	dados(id);
						  }
					 }	
				}
		}
		
	}
//	public void dados(String id) {
//		if (id == "0") {
//			JOptionPane.showMessageDialog(null, "Favor escolher o tipo de funcionario! ", "ERRORx002",JOptionPane.ERROR_MESSAGE);
//		}
//		if (id == "1") {
//			Professor p1 = new Professor();
//			p1.setMateria();
//		}
//		if(id == "2") {
//			
//		}
//	}
	
	public void inserirFuncionario(Funcionario funci) {

		try {
			File arquivo = new File("funcionarios.txt");
			FileOutputStream arquivoOutput;
			arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			gravador.print(funci.getId());
			gravador.print(";");
			gravador.print(funci.getNome());
			gravador.print(";");
			gravador.print(funci.getSalario());
			gravador.print(";");
			gravador.print(funci.getSexo());
			gravador.print(";");
			gravador.print(funci.getRg());
			gravador.print(";");
			gravador.print(funci.getCpf());
			gravador.print(";");
			gravador.print(funci.getDataNascimento());
			gravador.print(";");
			gravador.print(funci.getTelefone());
			gravador.print(";");
			gravador.print(funci.getFuncionarioEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(funci.getFuncionarioEndereco().getNumero());
			gravador.print(";");
			gravador.print(funci.getFuncionarioEndereco().getComplemento());
			gravador.print(";");
			gravador.print(funci.getFuncionarioEndereco().getBairro());
			gravador.print(";");
			gravador.print(funci.getFuncionarioEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(funci.getFuncionarioEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.print(funci.getFuncionarioEndereco().getEstado().getUf());
			gravador.print(";");
			gravador.print(funci.getFuncionarioEndereco().getCep());
			
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
			InputStream is = new FileInputStream("funcionarios.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				String separaDados[] = texto.split(";");
				dados+=separaDados[1]+";";				
				dados+=separaDados[6]+";";				
				dados+=separaDados[7]+";";
				dados+=separaDados[0]+";";
				dados+=",";
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

