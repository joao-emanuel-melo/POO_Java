import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo implements Exibivel, CalculavelMulta {
    private int numeroRegistro;
    private Usuario cliente;
    private Material obraEmprestada;
    private LocalDate diaRetirada;
    private LocalDate prazoFinal;
    private LocalDate diaEntregue;

    public Emprestimo(int numeroRegistro, Usuario cliente, Material obraEmprestada, LocalDate diaRetirada) {
        this.numeroRegistro = numeroRegistro;
        this.cliente = cliente;
        this.obraEmprestada = obraEmprestada;
        this.diaRetirada = diaRetirada;
        this.prazoFinal = diaRetirada.plusDays(cliente.diasParaDevolver());
    }

    public int getNumeroRegistro() { return numeroRegistro; }
    public Usuario getCliente() { return cliente; }
    public Material getObraEmprestada() { return obraEmprestada; }
    
    public boolean foiEncerrado() { 
        return diaEntregue != null; 
    }

    public void efetuarEntrega(LocalDate diaDaDevolucao) throws ExcecaoBiblioteca {
        if (foiEncerrado()) throw new ExcecaoBiblioteca("Operação negada: Material já consta como entregue.");
        this.diaEntregue = diaDaDevolucao;
        this.obraEmprestada.reporEstoque();
    }

    public long verificarDiasPassados() {
        if (!foiEncerrado()) return 0;
        long dias = ChronoUnit.DAYS.between(prazoFinal, diaEntregue);
        return dias > 0 ? dias : 0;
    }

    @Override
    public double calcularMulta() {
        return verificarDiasPassados() * cliente.taxaPorAtrasoDiario();
    }

    @Override
    public String exibirResumo() {
        String estadoAtual = foiEncerrado() ? "Concluído em " + diaEntregue : "Em aberto";
        return "Ticket #" + numeroRegistro + " | Cliente: " + cliente.getNomeCompleto() + " | Item: " + obraEmprestada.getNomeDaObra() + " | Prazo: " + prazoFinal + " | Status: " + estadoAtual;
    }
}