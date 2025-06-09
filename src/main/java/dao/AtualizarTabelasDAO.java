package dao;

public class AtualizarTabelasDAO {

    public static void AtualizarTabelas() {
        try {
            CriarTabelasDAO criarTabelas = new CriarTabelasDAO();

            criarTabelas.criarTabelaProduto();

            criarTabelas.criarTabelaCliente();

            criarTabelas.criarTabelaVenda();

            criarTabelas.criarTabelaVendaItem();

            criarTabelas.criarTabelaSituacaoCadastro();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
