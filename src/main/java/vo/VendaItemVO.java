package vo;

public class VendaItemVO {

    private Integer id = -1;
    private Integer id_venda = -1;
    private Integer id_produto;
    private String descricao;
    private Integer quantidade;
    private Double valorunitario;
    private Double valortotal;

    private VendaVO vendaVO;


    public Integer getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public Double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public VendaVO getVenda() {
        return vendaVO;
    }

    public void setVenda(VendaVO vendaVO) {
        this.vendaVO = vendaVO;
    }

}
