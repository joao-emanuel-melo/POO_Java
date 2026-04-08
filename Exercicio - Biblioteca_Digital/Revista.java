public class Revista extends Material {
    private int numeroEdicao;

    public Revista(int idItem, String nomeDaObra, int anoLancamento, int estoqueAtual, int numeroEdicao) {
        super(idItem, nomeDaObra, anoLancamento, estoqueAtual);
        this.numeroEdicao = numeroEdicao;
    }

    @Override
    public String informacaoExtra() {
        return "Edição de nº " + numeroEdicao;
    }
}