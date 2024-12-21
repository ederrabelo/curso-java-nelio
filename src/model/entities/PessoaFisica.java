package model.entities;

public class PessoaFisica extends Pessoa {
    private Double gastosSaude;

    public PessoaFisica() {

    }

    public PessoaFisica(Double rendaAnual, String nome, Double gastosSaude) {
        super(rendaAnual, nome);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    public Double calculaTaxas() {
        double imposto = (getRendaAnual() < 20000.00) ? 0.15 : 0.25;
        boolean teveGastoComSaude = getGastosSaude() != null;

        if (teveGastoComSaude) {
            return (getRendaAnual() * imposto) - (getGastosSaude() * 0.5);
        } else {
            return getRendaAnual() * imposto;
        }
    }

}
