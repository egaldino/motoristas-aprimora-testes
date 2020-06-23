package motoristas.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import motoristas.factory.MotoristaFactory;
import motoristas.model.Carro;
import motoristas.model.Motorista;
import motoristas.model.Seguro;

public class MotoristaServiceTest {

	@Test
	public void deveFiltrarMotoristasComSeguroTotal() {
		Motorista toretto = assertDoesNotThrow(() -> MotoristaFactory.comUmCarroSegurado(70189847679L,
				"Dominic Toretto", new Carro("2JRI424", "Dodge Charger R/T"), new Seguro(1234L, true)));

		Motorista brian = assertDoesNotThrow(() -> MotoristaFactory.comUmCarroSegurado(28374652431L,
				"Brian O'Conner", new Carro("T4U 842", "Nissan Skyline R34 GT-R"), new Seguro(4321L, false)));

		Motorista johnny = assertDoesNotThrow(() -> MotoristaFactory.comUmCarroSegurado(90476382763L,
				"Johnny Tran", new Carro("4KDU696", "2000 Honda S2000"), new Seguro(1234L, true)));

		Motorista agostinho = new Motorista(9047638237463L, "Agostinho Carrara");

		List<Motorista> morotistas = Arrays.asList(toretto, brian, johnny, agostinho);

		MotoristaService motoristaService = new MotoristaService();
		List<Motorista> listaFiltrada = motoristaService.filtrarMotoristasComSeguroTotal(morotistas);

		assertThat(listaFiltrada, hasItems(toretto, johnny));
	}

}
