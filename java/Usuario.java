// Classe abstrata para quem pega itens emprestados
public abstract class Usuario {

    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    // cada tipo de usuario tem o seu limite
    public abstract int getLimiteItens();

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    // o contador so deve mudar pelo emprestar() e devolver() da Biblioteca
    void aumentarQuantidade() {
        quantidadeEmprestada++;
    }

    void diminuirQuantidade() {
        quantidadeEmprestada--;
    }

    public boolean atingiuLimite() {
        return quantidadeEmprestada >= getLimiteItens();
    }
}
