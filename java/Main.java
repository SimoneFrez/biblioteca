public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        // cadastro dos itens
        Livro livro1 = new Livro(1, "Dom Casmurro", "Machado de Assis");
        Livro livro2 = new Livro(2, "O Cortico", "Aluisio Azevedo");
        Livro livro3 = new Livro(3, "Capitaes da Areia", "Jorge Amado");
        Revista revista1 = new Revista(4, "Superinteressante", 450);
        Revista revista2 = new Revista(5, "Veja", 2800);

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(livro3);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);

        // cadastro dos usuarios
        Aluno aluna = new Aluno("Maria");
        Professor professor = new Professor("Carlos");

        biblioteca.cadastrarUsuario(aluna);
        biblioteca.cadastrarUsuario(professor);

        biblioteca.listarAcervo();

        // emprestimos que dao certo (aluno pode ter ate 3)
        System.out.println();
        System.out.println("--- Emprestimos ---");
        biblioteca.emprestar(aluna, livro1);
        biblioteca.emprestar(aluna, livro2);
        biblioteca.emprestar(aluna, revista1);

        // este deve ser recusado, a Maria ja esta com 3 itens
        biblioteca.emprestar(aluna, livro3);

        // professor pegando um item que ja esta emprestado
        biblioteca.emprestar(professor, livro1);

        // professor pegando um item livre
        biblioteca.emprestar(professor, revista2);

        System.out.println();
        biblioteca.listarAcervo();

        // devolucao com atraso
        System.out.println();
        System.out.println("--- Devolucao ---");
        biblioteca.devolver(aluna, revista1, 3); // revista: 3 dias x R$ 1,00

        // agora a Maria consegue pegar o livro que foi recusado
        biblioteca.emprestar(aluna, livro3);

        System.out.println();
        biblioteca.listarAcervo();
    }
}
