public abstract class Material implements Exibivel {
    private int idItem;
    private String nomeDaObra;
    private int anoLancamento;
    private int estoqueAtual;

    public Material(int idItem, String nomeDaObra, int anoLancamento, int estoqueAtual) {
        this.idItem = idItem;
        this.nomeDaObra = nomeDaObra;
        this.anoLancamento = anoLancamento;
        this.estoqueAtual = estoqueAtual;
    }

    public int getIdItem() { return idItem; }
    public String getNomeDaObra() { return nomeDaObra; }
    public int getEstoqueAtual() { return estoqueAtual; }

    public boolean temNoAcervo() { return estoqueAtual > 0; }

    public void baixarEstoque() {
        if (temNoAcervo()) estoqueAtual--;
    }

    public void reporEstoque() { estoqueAtual++; }

    public abstract String informacaoExtra();

    @Override
    public String exibirResumo() {
        return "Cód: " + idItem + " | " + nomeDaObra + " (" + anoLancamento + ") | " + informacaoExtra() + " | Estoque: " + estoqueAtual;
    }
}