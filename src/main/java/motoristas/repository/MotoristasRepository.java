package motoristas.repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import motoristas.model.Carro;
import motoristas.model.Motorista;
import motoristas.model.Seguro;

public class MotoristasRepository {

	public List<Motorista> findAll(){
		Motorista toretto = new Motorista(70189847679L, "Dominic Toretto");
		Motorista brian = new Motorista(28374652431L, "Brian O'Conner");
		Motorista johnny = new Motorista(90476382763L, "Johnny Tran");
		Motorista agostinho = new Motorista(9047638237463L, "Agostinho Carrara");

		
		Carro dodge = new Carro("2JRI424", "Dodge Charger R/T");	
		Carro skyline = new Carro("T4U 842", "Nissan Skyline R34 GT-R");
		Carro honda = new Carro("4KDU696", "2000 Honda S2000");

		Seguro seguroDodge = new Seguro(1234L, true);
		Seguro seguroSkyline = new Seguro(4321L, false);
		Seguro seguroHonda = new Seguro(1432L, true);

		dodge.setSeguro(seguroDodge);
		skyline.setSeguro(seguroSkyline);
		honda.setSeguro(seguroHonda);

		toretto.setCarros(new HashSet<>(Arrays.asList(dodge)));
		brian.setCarros(new HashSet<>(Arrays.asList(skyline)));
		johnny.setCarros(new HashSet<>(Arrays.asList(honda)));
		
		return Arrays.asList(toretto, brian, johnny, agostinho);
	}

	public boolean salvar(Motorista motorista) {
		
		return false;
	}
	
}
