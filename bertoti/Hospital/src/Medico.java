public class Medico {
    private String nome;
    private String crm;
    private Departamento departamento;

    public Medico(String nome, String crm, Departamento departamento) {
        this.nome = nome;
        this.crm = crm;
        this.departamento = departamento;
    }

    //Getters e Setters dos atributos
    public String getNome() {
        return nome;
    }
    public String getCrm() {
        return crm;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    //Get e Set do departamento
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public Departamento getDepartamento() {
        return departamento;
    }
}
