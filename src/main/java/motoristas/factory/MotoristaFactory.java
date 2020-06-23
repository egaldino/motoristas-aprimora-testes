package motoristas.factory;

import java.util.Arrays;
import java.util.HashSet;

import motoristas.exception.ValidacaoException;
import motoristas.model.Carro;
import motoristas.model.Motorista;
import motoristas.model.Seguro;
import motoristas.validator.MotoristaValidator;

public class MotoristaFactory {

	public static Motorista semCarro(Long cnh, String nome) throws ValidacaoException {
//		MotoristaValidator.validaCnh(cnh);
		return new Motorista(cnh, nome);
	}
	
	public static Motorista comCarro(Long cnh, String nome, Carro carro) throws ValidacaoException {
		Motorista motorista = semCarro(cnh, nome);
		motorista.setCarros(new HashSet<>(Arrays.asList(carro)));
		return motorista;
	}
	
	public static Motorista comUmCarroSegurado(Long cnh, String nome, Carro carro, Seguro seguro) throws ValidacaoException {
		carro.setSeguro(seguro);
		return comCarro(cnh, nome, carro);
	}
	
}
