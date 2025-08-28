import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Departamento departamento = new Departamento("Saúde");

        List<Medico> medicosDisponiveis = new ArrayList<>();
        medicosDisponiveis.add(new Medico("Dr. Ronaldo Alves", "392710", departamento));
        medicosDisponiveis.add(new Medico("Dra. Carla Souza", "481516", departamento));
        medicosDisponiveis.add(new Medico("Dr. João Pereira", "234234", departamento));
        Paciente paciente = new Paciente("Rafael Matesco", "401.103.048-50");

        //Input da DATA
        System.out.println("Olá, " + paciente.getNome() + "! Vamos iniciar o agendamento de uma consulta.");
        System.out.print("Digite a data que deseja (dd/mm/aaaa): ");
        String data = input.nextLine();

        //Lista de médicos
        System.out.println("\n--- Médicos Disponíveis para esta data ---");
        for (Medico medico : medicosDisponiveis) {
            System.out.println("- Nome: " + medico.getNome() + " | CRM: " + medico.getCrm());
        }

        //Input do CRM
        System.out.print("\nDigite o CRM do médico que deseja escolher: ");
        String crmEscolhido = input.nextLine();
        Medico medicoSelecionado = null;
        for (Medico medico : medicosDisponiveis) {
            if (medico.getCrm().equals(crmEscolhido)) {
                medicoSelecionado = medico;
                break; // Encontrou o médico, pode parar o loop
            }
        }
        if (medicoSelecionado == null) {
            System.out.println("\nCRM inválido ou não encontrado. O programa será encerrado.");
            input.close();
            return; // Encerra o método main
        }
        System.out.println("\nVocê selecionou: " + medicoSelecionado.getNome());

        //Input da descrição
        System.out.print("Digite a descrição do assunto da consulta: ");
        String desc = input.nextLine();


        Consulta consulta = new Consulta(data, desc, medicoSelecionado);

        System.out.println("\n\nDados da sua consulta: \n- Data: " +consulta.getData() + "\n- Médico:" + consulta.getMedico().getNome() + "\n- Assunto a ser tratado: " + consulta.getDescricao() );

        input.close();
    }
}
