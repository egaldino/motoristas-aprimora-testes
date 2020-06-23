package motoristas.service;

import java.util.List;
import java.util.stream.Collectors;

import motoristas.model.Motorista;
import motoristas.repository.MotoristasRepository;

public class MotoristaService {

	public List<Motorista> filtrarMotoristasComSeguroTotal (List<Motorista> lista) {
		List<Motorista> motoristas = MotoristasRepository.findAll();

		return motoristas.stream()
				.filter(motorista -> motorista.getCarros().isPresent())
				.filter(motorista -> motorista.getCarros().get().stream()
											.anyMatch(carro -> carro.getSeguro().
													filter(seguro -> seguro.getTotal()).isPresent()))
				.collect(Collectors.toList());
	}
	
}
