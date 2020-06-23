package motoristas.service;

import java.util.List;
import java.util.stream.Collectors;

import motoristas.model.Motorista;
import motoristas.repository.MotoristasRepository;

public class MotoristaService {

	private MotoristasRepository motoristasRepository;

	public MotoristaService(MotoristasRepository motoristasRepository) {
		this.motoristasRepository = motoristasRepository;
	}
	
	public List<Motorista> recuperarMotoristasComSeguroTotal () {
		List<Motorista> motoristas = motoristasRepository.findAll();
		return motoristas.stream()
				.filter(motorista -> motorista.getCarros().isPresent())
				.filter(motorista -> motorista.getCarros().get().stream()
											.anyMatch(carro -> carro.getSeguro().
													filter(seguro -> seguro.getTotal()).isPresent()))
				.collect(Collectors.toList());
	}

	public boolean salvar(Motorista motorista) {
		return motoristasRepository.salvar(motorista);
	}
	
}
