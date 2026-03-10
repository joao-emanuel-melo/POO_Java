public class Funcionario {
   private int matricula; // Atributo privado
   // Método get para acessar a matricula
   public int getMatricula() {
       return matricula;
   }
   // Método set para modificar a matricula
   public void setMatricula(int matricula) {
       this.matricula = matricula;
   }
   
   
   private String nome;
   // Método get para acessar o nome
   public String getNome() {
       return nome;
   }
   // Método set para modificar o nome
   public void setNome(String nome) {
       this.nome = nome;
   }

   private Departamento depart; // Atributo privado
   // Método get para acessar o departamento
   public String getDepart() {
       return nome;
   }
   // Método set para modificar o departamento
   public void setDepart(String depart) {
       this.nome = depart;
   }
}