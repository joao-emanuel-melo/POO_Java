public class Ebook extends Material {
    private String extensao;
    private double pesoMegaBytes;

    public Ebook(int idItem, String nomeDaObra, int anoLancamento, int estoqueAtual, String extensao, double pesoMegaBytes) {
        super(idItem, nomeDaObra, anoLancamento, estoqueAtual);
        this.extensao = extensao;
        this.pesoMegaBytes = pesoMegaBytes;
    }

    @Override
    public String informacaoExtra() {
        return "Arquivo: " + extensao + " (" + pesoMegaBytes + "MB)";
    }
}