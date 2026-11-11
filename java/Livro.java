public class Livro extends ItemBiblioteca {

    private String autor;

    public Livro(int codigo, String titulo, String autor) {
        super(codigo, titulo);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public int getPrazoDias() {
        return 14;
    }

    @Override
    public double getMultaPorDia() {
        return 0.50;
    }

    @Override
    public void exibirInfo() {
        System.out.println("[LIVRO]");
        super.exibirInfo();
        System.out.println("   Autor: " + autor);
    }
}
