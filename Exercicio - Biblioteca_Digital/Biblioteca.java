import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Usuario> listaClientes = new ArrayList<>();
    private List<Material> acervo = new ArrayList<>();
    private List<Emprestimo> registrosAtivos = new ArrayList<>();
    private int geradorDeIds = 5000;

    public void adicionarCliente(Usuario u) { listaClientes.add(u); }
    public void inserirNoAcervo(Material m) { acervo.add(m); }

    public Usuario localizarCliente(int mat) {
        for (Usuario u : listaClientes) {
            if (u.getMatricula() == mat) return u;
        }
        return null;
    }

    public Material localizarObra(int id) {
        for (Material m : acervo) {
            if (m.getIdItem() == id) return m;
        }
        return null;
    }

    public Emprestimo encontrarRegistro(int idReg) {
        for (Emprestimo emp : registrosAtivos) {
            if (emp.getNumeroRegistro() == idReg) return emp;
        }
        return null;
    }

    private int checarPendenciasDoCliente(Usuario u) {
        int totalPendentes = 0;
        for (Emprestimo emp : registrosAtivos) {
            if (emp.getCliente().equals(u) && !emp.foiEncerrado()) {
                totalPendentes++;
            }
        }
        return totalPendentes;
    }

    public Emprestimo processarRetirada(int matCliente, int idObra, LocalDate dataAgendamento) throws ExcecaoBiblioteca {
        Usuario cliente = localizarCliente(matCliente);
        if (cliente == null) throw new ExcecaoBiblioteca("Cadastro de cliente não encontrado.");

        Material obra = localizarObra(idObra);
        if (obra == null) throw new ExcecaoBiblioteca("Item não catalogado no acervo.");

        if (!obra.temNoAcervo()) throw new ExcecaoBiblioteca("Infelizmente não há exemplares disponíveis no momento.");

        if (checarPendenciasDoCliente(cliente) >= cliente.limiteDeItens()) {
            throw new ExcecaoBiblioteca("Limite máximo de itens simultâneos atingido por este usuário.");
        }

        obra.baixarEstoque();
        Emprestimo novoRegistro = new Emprestimo(geradorDeIds++, cliente, obra, dataAgendamento);
        registrosAtivos.add(novoRegistro);
        return novoRegistro;
    }

    public void processarEntrega(int numReg, LocalDate dataHoje) throws ExcecaoBiblioteca {
        Emprestimo emp = encontrarRegistro(numReg);
        if (emp == null) throw new ExcecaoBiblioteca("Número do ticket inválido ou inexistente.");
        emp.efetuarEntrega(dataHoje);
    }

    public void mostrarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ATIVOS ---");
        for (Usuario u : listaClientes) System.out.println(u.exibirResumo());
    }

    public void mostrarAcervo() {
        System.out.println("\n--- ACERVO DA BIBLIOTECA ---");
        for (Material m : acervo) System.out.println(m.exibirResumo());
    }

    public void mostrarPendentes() {
        System.out.println("\n--- RETIRADAS PENDENTES ---");
        for (Emprestimo e : registrosAtivos) {
            if (!e.foiEncerrado()) System.out.println(e.exibirResumo());
        }
    }

    public void mostrarConcluidos() {
        System.out.println("\n--- HISTORICO DE ENTREGAS ---");
        for (Emprestimo e : registrosAtivos) {
            if (e.foiEncerrado()) System.out.println(e.exibirResumo());
        }
    }
}