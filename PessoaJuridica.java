public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaFisica(String nome, int idade, String cnpj){
        this.cnpj = cnpj
    }
    public int getCnpj(){
        return cnpj;
    }

    public String getNome(){
        return super.GetNome();
    }

    public int GetIdade(){
        return idade;
    }
}