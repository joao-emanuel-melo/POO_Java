public class Professor extends Usuario {
    public Professor(int matricula, String nomeCompleto, String contato) {
        super(matricula, nomeCompleto, contato);
    }

    @Override
    public int limiteDeItens() { return 5; }

    @Override
    public int diasParaDevolver() { return 14; }

    @Override
    public double taxaPorAtrasoDiario() { return 1.00; } // Regra fixa do PDF

    @Override
    public String categoriaUsuario() { return "Professor"; }
}