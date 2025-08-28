public class Consulta {
    private String data;
    private String descricao;
    private Medico medico;

    public Consulta(String data, String descricao, Medico medico) {
        this.data = data;
        this.descricao = descricao;
        this.medico = medico;
    }

    //Getters e Setters dos atributos
    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Get e Set do medico
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }
}
