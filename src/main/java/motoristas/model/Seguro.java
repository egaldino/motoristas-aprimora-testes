package motoristas.model;

public class Seguro {

	private Long codigo;
	private Boolean total;
	
	public Seguro(Long codigo, Boolean total) {
		super();
		this.codigo = codigo;
		this.total = total;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Boolean getTotal() {
		return total;
	}
	public void setTotal(Boolean total) {
		this.total = total;
	}
	
}
