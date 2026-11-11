public class Biblioteca {

    // arrays de tamanho fixo
    private ItemBiblioteca[] acervo = new ItemBiblioteca[20];
    private int totalItens = 0;

    private Usuario[] usuarios = new Usuario[10];
    private int totalUsuarios = 0;

    public void cadastrarItem(ItemBiblioteca item) {
        if (totalItens >= acervo.length) {
            System.out.println("Acervo cheio, nao da pra cadastrar: " + item.getTitulo());
            return;
        }
        acervo[totalItens] = item;
        totalItens++;
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (totalUsuarios >= usuarios.length) {
            System.out.println("Lista de usuarios cheia: " + usuario.getNome());
            return;
        }
        usuarios[totalUsuarios] = usuario;
        totalUsuarios++;
    }

    public boolean emprestar(Usuario usuario, ItemBiblioteca item) {
        if (!item.isDisponivel()) {
            System.out.println("RECUSADO: '" + item.getTitulo() + "' ja esta emprestado.");
            return false;
        }
        if (usuario.atingiuLimite()) {
            System.out.println("RECUSADO: " + usuario.getNome() + " atingiu o limite de "
                    + usuario.getLimiteItens() + " itens.");
            return false;
        }

        item.marcarComoEmprestado();
        usuario.aumentarQuantidade();
        System.out.println("OK: " + usuario.getNome() + " pegou '" + item.getTitulo()
                + "' por " + item.getPrazoDias() + " dias.");
        return true;
    }

    // devolve o item e retorna o valor da multa (0 se nao tiver atraso)
    public double devolver(Usuario usuario, ItemBiblioteca item, int diasAtraso) {
        if (item.isDisponivel()) {
            System.out.println("Esse item nao esta emprestado: " + item.getTitulo());
            return 0;
        }

        item.marcarComoDevolvido();
        usuario.diminuirQuantidade();

        double multa = 0;
        if (diasAtraso > 0) {
            multa = diasAtraso * item.getMultaPorDia();
        }
        System.out.println("DEVOLVIDO: " + usuario.getNome() + " devolveu '" + item.getTitulo()
                + "'. Multa: R$ " + String.format("%.2f", multa));
        return multa;
    }

    public void listarAcervo() {
        System.out.println("===== ACERVO =====");
        for (int i = 0; i < totalItens; i++) {
            acervo[i].exibirInfo();
        }
        System.out.println("==================");
    }
}
