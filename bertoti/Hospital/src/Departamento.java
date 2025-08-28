import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nome;
    private List<Medico> medicos = new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    //Getters e Setters dos atributos
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    //Get e Set do medico
    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }
    public List<Medico> getMedicos() {
        return medicos;
    }
}
