package Herença_Pessoa;
public class Pessoa{
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade){
        this.idade = idade;
        this.nome = nome;
        }

    public int getIdade(){
        return idade;
    }

    public String getNome(){
        return nome;
    }
}