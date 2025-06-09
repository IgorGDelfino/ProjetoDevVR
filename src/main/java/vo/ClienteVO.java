package vo;

public class ClienteVO {

    private Integer id = -1;
    private String nome = "";
    private Integer situacaocadastro = -1;
    private Integer diafechamento = -1;
    private Double limitecompra;

    public Double getLimitecompra() {
        return limitecompra;
    }

    public void setLimitecompra(Double limitecompra) {
        this.limitecompra = limitecompra;
    }

    public Integer getDiafechamento() {
        return diafechamento;
    }

    public void setDiafechamento(Integer diafechamento) {
        this.diafechamento = diafechamento;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSituacaocadastro() {
        return situacaocadastro;
    }

    public void setSituacaocadastro(Integer situacaocadsatro) {
        this.situacaocadastro = situacaocadsatro;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
