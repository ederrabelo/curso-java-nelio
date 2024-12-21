package model.entities;

public class PessoaJuridica extends Pessoa {
    private Integer qtdFuncionarios;

    public PessoaJuridica() {

    }

    public PessoaJuridica(Double rendaAnual, String nome, Integer qtdFuncionarios) {
        super(rendaAnual, nome);
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public Integer getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(Integer qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public Double calculaTaxas() {
        double imposto = (getQtdFuncionarios() > 10) ? 0.14 : 0.16;

        return getRendaAnual() * imposto;
    }
}
