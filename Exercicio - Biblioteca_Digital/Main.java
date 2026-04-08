import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Biblioteca central = new Biblioteca();

        Usuario estudante = new Aluno(1024, "Lucas Almeida", "lucas.dev@universidade.br");
        Usuario docente = new Professor(2048, "Dra. Mariana Costa", "mariana.pesquisa@universidade.br");
        central.adicionarCliente(estudante);
        central.adicionarCliente(docente);

        Material obra1 = new Livro(100, "Clean Code: Habilidades Práticas", 2008, 3, "Robert C. Martin");
        Material obra2 = new Livro(101, "Padrões de Projetos", 1994, 2, "Gang of Four");
        Material rev = new Revista(200, "National Geographic Brasil", 2023, 5, 275);
        Material livroDigital = new Ebook(300, "Entendendo Algoritmos", 2017, 999, "EPUB", 14.5);
        
        central.inserirNoAcervo(obra1);
        central.inserirNoAcervo(obra2);
        central.inserirNoAcervo(rev);
        central.inserirNoAcervo(livroDigital);

        central.mostrarClientes();
        central.mostrarAcervo();

        LocalDate dataAtual = LocalDate.now();
        
        System.out.println("\n--- INICIANDO REGISTROS DE LOCACAO ---");
        try {
            central.processarRetirada(1024, 100, dataAtual); 
            central.processarRetirada(1024, 101, dataAtual); 
            central.processarRetirada(1024, 200, dataAtual); 
            central.processarRetirada(2048, 300, dataAtual); 
            System.out.println("Locações registradas com sucesso.");
        } catch (ExcecaoBiblioteca ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        System.out.println("\n--- TESTANDO TRAVAS DE SEGURANCA ---");
        try {
            central.processarRetirada(1024, 300, dataAtual); 
        } catch (ExcecaoBiblioteca ex) {
            System.out.println("Bloqueio esperado (Cota): " + ex.getMessage());
        }

        try {
            Material obraRara = new Livro(999, "Livro Raro", 1950, 1, "Autor Desconhecido");
            central.inserirNoAcervo(obraRara);
            central.processarRetirada(2048, 999, dataAtual); 
            central.processarRetirada(1024, 999, dataAtual); 
        } catch (ExcecaoBiblioteca ex) {
            System.out.println("Bloqueio esperado (Estoque): " + ex.getMessage());
        }

        central.mostrarPendentes();

        System.out.println("\n--- PROCESSANDO DEVOLUCOES ---");
        try {
            central.processarEntrega(5000, dataAtual.plusDays(15)); 
            central.processarEntrega(5003, dataAtual.plusDays(5));  
            System.out.println("Baixas realizadas com sucesso.");
        } catch (ExcecaoBiblioteca ex) {
            System.out.println("Erro na devolução: " + ex.getMessage());
        }

        System.out.println("\n--- BALANCO FINANCEIRO (MULTAS) ---");
        Emprestimo registroAtraso = central.encontrarRegistro(5000);
        Emprestimo registroEmDia = central.encontrarRegistro(5003);
        
        System.out.printf("Ticket #%d: R$ %.2f\n", registroAtraso.getNumeroRegistro(), registroAtraso.calcularMulta());
        System.out.printf("Ticket #%d: R$ %.2f\n", registroEmDia.getNumeroRegistro(), registroEmDia.calcularMulta());

        System.out.println("\n--- RESUMO FINAL DO SISTEMA ---");
        central.mostrarAcervo();
        central.mostrarConcluidos();
        central.mostrarPendentes();
    }
}