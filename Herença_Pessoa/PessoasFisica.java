package Herença_Pessoa;
public class PessoasFisica extends Pessoa{
    private String cpf;

    public PessoaFisica(String nome, int idade, String cpf){
        this.cpf = cpf
    }
    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return super.GetNome();
    }

    public int GetIdade(){
        return idade;
    }

}