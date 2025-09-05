import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- Configuração dos dados iniciais ---
        Departamento departamento = new Departamento("Saúde");
        List<Medico> medicosDisponiveis = new ArrayList<>();
        medicosDisponiveis.add(new Medico("Dr. Ronaldo Alves", "392710", departamento));
        medicosDisponiveis.add(new Medico("Dra. Carla Souza", "481516", departamento));
        medicosDisponiveis.add(new Medico("Dr. João Pereira", "234234", departamento));
        Paciente paciente = new Paciente("Rafael Matesco", "401.103.048-50");

        // --- Interação com o usuário ---
        System.out.println("Olá, " + paciente.getNome() + "! Vamos iniciar o agendamento de uma consulta.");
        System.out.print("Digite a data que deseja (dd/mm/aaaa): ");
        String data = input.nextLine();

        System.out.println("\n--- Médicos Disponíveis para esta data ---");
        for (Medico medico : medicosDisponiveis) {
            System.out.println("- Nome: " + medico.getNome() + " | CRM: " + medico.getCrm());
        }

        System.out.print("\nDigite o CRM do médico que deseja escolher: ");
        String crmEscolhido = input.nextLine();

        System.out.print("Digite a descrição do assunto da consulta: ");
        String desc = input.nextLine();

        // --- Execução da Lógica de Negócio ---
        AgendadorDeConsultas agendador = new AgendadorDeConsultas();
        try {
            Consulta consulta = agendador.agendar(data, desc, crmEscolhido, medicosDisponiveis);

            System.out.println("\n\n--- Consulta Agendada com Sucesso! ---");
            System.out.println("Dados da sua consulta: \n- Data: " + consulta.getData() + "\n- Médico: " + consulta.getMedico().getNome() + "\n- Assunto a ser tratado: " + consulta.getDescricao());

        } catch (IllegalArgumentException e) {
            System.out.println("\nErro ao agendar consulta: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}