public abstract class Usuario implements Exibivel {
    private int matricula;
    private String nomeCompleto;
    private String contato;

    public Usuario(int matricula, String nomeCompleto, String contato) {
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.contato = contato;
    }

    public int getMatricula() { return matricula; }
    public String getNomeCompleto() { return nomeCompleto; }

    public abstract int limiteDeItens();
    public abstract int diasParaDevolver();
    public abstract double taxaPorAtrasoDiario();
    public abstract String categoriaUsuario();

    @Override
    public String exibirResumo() {
        return "[" + categoriaUsuario() + "] " + nomeCompleto + " | Matrícula: " + matricula + " | Email: " + contato;
    }
}