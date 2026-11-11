// Classe abstrata que representa qualquer item do acervo
public abstract class ItemBiblioteca {

    private int codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true; // todo item novo comeca disponivel
    }

    // cada tipo de item tem o seu prazo e a sua multa
    public abstract int getPrazoDias();

    public abstract double getMultaPorDia();

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // nao sao public de proposito (nao existe setDisponivel).
    // A disponibilidade so deve mudar pelo emprestar() e devolver() da Biblioteca.
    void marcarComoEmprestado() {
        disponivel = false;
    }

    void marcarComoDevolvido() {
        disponivel = true;
    }

    // mostra os dados do item no console
    public void exibirInfo() {
        String situacao;
        if (disponivel) {
            situacao = "Disponivel";
        } else {
            situacao = "Emprestado";
        }
        System.out.println("Codigo: " + codigo + " | Titulo: " + titulo + " | " + situacao);
        System.out.println("   Prazo: " + getPrazoDias() + " dias | Multa: R$ " + String.format("%.2f", getMultaPorDia()) + " por dia");
    }
}
