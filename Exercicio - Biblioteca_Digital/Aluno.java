public class Aluno extends Usuario {
    public Aluno(int matricula, String nomeCompleto, String contato) {
        super(matricula, nomeCompleto, contato);
    }

    @Override
    public int limiteDeItens() { return 3; }

    @Override
    public int diasParaDevolver() { return 7; }

    @Override
    public double taxaPorAtrasoDiario() { return 2.50; }

    @Override
    public String categoriaUsuario() { return "Aluno"; }
}