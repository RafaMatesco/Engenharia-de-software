import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgendadorDeConsultasTest {

    private AgendadorDeConsultas agendador;
    private List<Medico> medicosDisponiveis;
    private Medico medicoRonaldo;

    @BeforeEach
    void setUp() {
        // Este método roda antes de cada teste, preparando o ambiente.
        agendador = new AgendadorDeConsultas();
        Departamento departamento = new Departamento("Cardiologia");

        medicoRonaldo = new Medico("Dr. Ronaldo Alves", "392710", departamento);
        Medico medicoCarla = new Medico("Dra. Carla Souza", "481516", departamento);

        medicosDisponiveis = new ArrayList<>();
        medicosDisponiveis.add(medicoRonaldo);
        medicosDisponiveis.add(medicoCarla);
    }

    @Test
    @DisplayName("Deve agendar uma consulta com sucesso para um CRM válido")
    void deveAgendarConsultaQuandoCrmForValido() {
        // Arrange (Preparação)
        String data = "25/12/2025";
        String descricao = "Check-up anual";
        String crmValido = "392710";

        // Act (Ação)
        Consulta consulta = agendador.agendar(data, descricao, crmValido, medicosDisponiveis);

        // Assert (Verificação)
        assertNotNull(consulta);
        assertEquals(data, consulta.getData());
        assertEquals(descricao, consulta.getDescricao());
        assertEquals(medicoRonaldo.getNome(), consulta.getMedico().getNome());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar agendar com CRM inválido")
    void deveLancarExcecaoQuandoCrmForInvalido() {
        // Arrange (Preparação)
        String data = "25/12/2025";
        String descricao = "Check-up anual";
        String crmInvalido = "999999";

        // Act & Assert (Ação e Verificação)
        // Verifica se a exceção esperada (IllegalArgumentException) é lançada
        // ao executar o método agendar com dados inválidos.
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> agendador.agendar(data, descricao, crmInvalido, medicosDisponiveis)
        );

        // Verifica se a mensagem de erro é a que esperamos
        assertEquals("CRM inválido ou médico não encontrado.", excecao.getMessage());
    }

    @Test
    @DisplayName("Deve retornar nulo ao buscar médico com CRM inexistente")
    void deveRetornarNuloQuandoCrmNaoExistir() {
        // Arrange
        String crmInexistente = "123456";

        // Act
        Medico medico = agendador.encontrarMedicoPorCrm(crmInexistente, medicosDisponiveis);

        // Assert
        assertNull(medico);
    }

    @Test
    @DisplayName("Deve encontrar e retornar o médico correto para um CRM existente")
    void deveEncontrarMedicoQuandoCrmExistir() {
        // Arrange
        String crmExistente = "392710";

        // Act
        Medico medico = agendador.encontrarMedicoPorCrm(crmExistente, medicosDisponiveis);

        // Assert
        assertNotNull(medico);
        assertEquals("Dr. Ronaldo Alves", medico.getNome());
        assertEquals(crmExistente, medico.getCrm());
    }
}