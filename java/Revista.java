public class Revista extends ItemBiblioteca {

    private int edicao;

    public Revista(int codigo, String titulo, int edicao) {
        super(codigo, titulo);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public int getPrazoDias() {
        return 7;
    }

    @Override
    public double getMultaPorDia() {
        return 1.00;
    }

    @Override
    public void exibirInfo() {
        System.out.println("[REVISTA]");
        super.exibirInfo();
        System.out.println("   Edicao: " + edicao);
    }
}
