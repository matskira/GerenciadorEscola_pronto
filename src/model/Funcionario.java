package model;

public class Funcionario {
	private String id;
	private String nome;
	private String sexo;
	private String cpf;
	private String rg;
	private String salario;
	private Data dataNascimento;
	private String telefone;
	private Endereco funcionarioEndereco;
	
	public Funcionario() {
		System.out.println("Funcionário criado! ");
	}

	public Funcionario(String id, String nome, String sexo, String cpf, String rg, String salario, Data dataNascimento,
			String telefone, Endereco funcionarioEndereco) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.rg = rg;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.funcionarioEndereco = funcionarioEndereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getFuncionarioEndereco() {
		return funcionarioEndereco;
	}

	public void setFuncionarioEndereco(Endereco funcionarioEndereco) {
		this.funcionarioEndereco = funcionarioEndereco;
	}



	
}

