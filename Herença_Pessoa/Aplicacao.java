package Herença_Pessoa;
import java.util.Scanner

public class Aplicacao{
    public static void main (String[]args){
        Scanner s = new Scanner(System.in);
        String nome, info;
        int idade;

        nome = s.next();
        idade = s.nextInt();
        info = s.next();
        Pessoa pf = new PessoaFisica(nome, idade, info);
        Imprimir(pf);

        nome = s.next();
        idade = s.nextInt();
        info = s.next();
        PessoaJuridica pj = new PessoaJuridica(nome, idade, info);
    }

    public static void ImprimirPessoa(PessoFisica p){
        System.out.println("Nome da Pessoa: " + p.getNome);
    }
}