public class Livro extends Material {
    private String escritor;

    public Livro(int idItem, String nomeDaObra, int anoLancamento, int estoqueAtual, String escritor) {
        super(idItem, nomeDaObra, anoLancamento, estoqueAtual);
        this.escritor = escritor;
    }

    @Override
    public String informacaoExtra() {
        return "Autor(a): " + escritor;
    }
}