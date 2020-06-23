package motoristas.model;

import java.util.Optional;
import java.util.Set;

public class Motorista {

	private Long cnh;
	private String nome;
	private Set<Carro> carros;
	
	public Motorista(Long cnh, String nome) {
		this.cnh = cnh;
		this.nome = nome;
	}
	public Long getCnh() {
		return cnh;
	}
	public void setCnh(Long cnh) {
		this.cnh = cnh;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Optional<Set<Carro>> getCarros() {
		return Optional.ofNullable(carros);
	}
	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}
	
	@Override
	public String toString() {
		return "Motorista [cnh=" + cnh + ", nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnh == null) ? 0 : cnh.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorista other = (Motorista) obj;
		if (cnh == null) {
			if (other.cnh != null)
				return false;
		} else if (!cnh.equals(other.cnh))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
