package motoristas.validator;

import motoristas.exception.ValidacaoException;

public class MotoristaValidator {

	public static void validaCnh(Long cnh) throws ValidacaoException {
		if(cnh == null) {
			throw new ValidacaoException("CNH não pode ser vazia");
		}
		
		if(cnh.toString().length() != 11) {
			throw new ValidacaoException("CNH deve ter 11 digitos");
		}
	}

}
