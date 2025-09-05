import java.util.List;

public class AgendadorDeConsultas {

    /**
     * Encontra um médico em uma lista a partir do CRM fornecido.
     *
     * @param crm                O CRM a ser buscado.
     * @param medicosDisponiveis A lista de médicos onde a busca será feita.
     * @return O objeto Medico se encontrado, caso contrário, null.
     */
    public Medico encontrarMedicoPorCrm(String crm, List<Medico> medicosDisponiveis) {
        for (Medico medico : medicosDisponiveis) {
            if (medico.getCrm().equals(crm)) {
                return medico;
            }
        }
        return null;
    }

    /**
     * Realiza o agendamento de uma consulta.
     *
     * @param data               A data da consulta.
     * @param descricao          A descrição/assunto da consulta.
     * @param crmEscolhido       O CRM do médico escolhido.
     * @param medicosDisponiveis A lista de médicos disponíveis.
     * @return Um objeto Consulta preenchido.
     * @throws IllegalArgumentException se o CRM não for encontrado na lista de médicos.
     */

    public Consulta agendar(String data, String descricao, String crmEscolhido, List<Medico> medicosDisponiveis) {
        Medico medicoSelecionado = encontrarMedicoPorCrm(crmEscolhido, medicosDisponiveis);

        if (medicoSelecionado == null) {
            throw new IllegalArgumentException("CRM inválido ou médico não encontrado.");
        }

        return new Consulta(data, descricao, medicoSelecionado);
    }
}