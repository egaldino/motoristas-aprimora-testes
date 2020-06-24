package motoristas.factory;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import motoristas.exception.ValidacaoException;
import motoristas.model.Carro;
import motoristas.model.Motorista;
import motoristas.model.Seguro;

public class MotoristaFactoryTest {

	@Test
	@DisplayName("Criar Motorista Sem Carro")
	public void deveCriarMotoristaSemCarroComSucesso() {
		// Cenario (Dado que)
		Long cnh = 70189847679L;
		String nome = "Dominic Toretto";

		// Execucao (Ao executar)
		Motorista motorista = assertDoesNotThrow(() -> MotoristaFactory.semCarro(cnh, nome),
				"Lançou exception não esperada");

		// Validação do retorno (Espero que)
		assertEquals(cnh, motorista.getCnh(), "CNH não adicionada ao motorista");
		assertEquals(nome, motorista.getNome(), "Nome não adicionado ao motorista");
	}

	@Test
	@DisplayName("Criar Motorista com 1 carro")
	public void deveCriarMotoristaComUmCarroComSucesso() {
		// Cenario (Dado que)
		Long cnh = 70189847679L;
		String nome = "Dominic Toretto";
		Carro dodge = new Carro("2JRI424", "Dodge Charger R/T");
		Seguro seguroDodge = new Seguro(1234L, true);

		// Execucao (Ao executar)
		Motorista motorista = assertDoesNotThrow(
				() -> MotoristaFactory.comUmCarroSegurado(cnh, nome, dodge, seguroDodge),
				"Lançou exception não esperada");

		// Validação do retorno (Espero que)
		assertEquals(cnh, motorista.getCnh(), "CNH não adicionada ao motorista");
		assertEquals(nome, motorista.getNome(), "Nome não adicionado ao motorista");

		assertTrue(motorista.getCarros().filter(carros -> carros.contains(dodge)).isPresent(),
				"Carro esperado não encontrado");

		assertTrue(motorista.getCarros()
				.filter(carros -> carros.stream()
						.anyMatch(carro -> carro.getSeguro().filter(seguro -> seguro.equals(seguroDodge)).isPresent()))
				.isPresent(), "Seguro esperado não encontrado");
	}

	@Test
	@DisplayName("Validar CNH Vazia")
	public void deveLancarExceptionAoReceberCNHVazia() {
		// Cenario (Dado que)
		Long cnh = null;
		String nome = "Dominic Toretto";

		// Execucao (Ao executar)
		ValidacaoException exception = assertThrows(ValidacaoException.class, () -> {
			MotoristaFactory.semCarro(cnh, nome);
		}, "Exception esperada não lançada");

		// Validação do retorno (Espero que)
		String mensagemEsperada = "CNH não pode ser vazia";
		String mensagemRecebida = exception.getMessage();
		assertEquals(mensagemEsperada, mensagemRecebida, "Mensagem incorreta");
	}
	
	@Test
	@DisplayName("Validar CNH Menor Que 11")
	public void deveLancarExceptionAoReceberCNHMenorQueOnzeDigitos() {
		// Cenario (Dado que)
		Long cnh = 1234567890L;
		String nome = "Dominic Toretto";

		// Execucao (Ao executar)
		ValidacaoException exception = assertThrows(ValidacaoException.class, () -> {
			MotoristaFactory.semCarro(cnh, nome);
		}, "Exception esperada não lançada");

		// Validação do retorno (Espero que)
		String mensagemEsperada = "CNH deve ter 11 digitos";
		String mensagemRecebida = exception.getMessage();
		assertTrue(mensagemEsperada.equals(mensagemRecebida), "Mensagem incorreta");
	}
}
