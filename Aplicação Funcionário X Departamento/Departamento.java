public class Departamento {
   private int codigo; // Atributo privado
   // Método get para acessar o código do dp
   public int getCodigo() {
       return codigo;
   }
   // Método set para modificar o codigo
   public void setCodigo(int codigo) {
       this.codigo = codigo;
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
}