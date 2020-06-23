package motoristas;

import java.util.List;
import java.util.stream.Collectors;

import motoristas.model.Motorista;
import motoristas.repository.MotoristasRepository;

public class Main {

	public static void main(String[] args) {
		List<Motorista> motoristas = MotoristasRepository.findAll();

		List<Motorista> motoristasComSeguroTotal = motoristas.stream()
				.filter(motorista -> motorista.getCarros().isPresent())
				.filter(motorista -> motorista.getCarros().get().stream()
											.anyMatch(carro -> carro.getSeguro().
													filter(seguro -> seguro.getTotal()).isPresent()))
				.collect(Collectors.toList());

		System.out.println(motoristasComSeguroTotal);
	}

}
