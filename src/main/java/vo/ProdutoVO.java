package vo;

public class ProdutoVO {

    private Integer id =  -1;
    private String descricao = "";
    private double valorunitario = 0;
    private Integer situacaocadastro = -1;


    public Integer getSituacaocadastro() {
        return situacaocadastro;
    }

    public void setSituacaocadastro(Integer situacaocadsatro) {
        this.situacaocadastro = situacaocadsatro;
    }

    public double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(double valorpadrao) {
        this.valorunitario = valorpadrao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
