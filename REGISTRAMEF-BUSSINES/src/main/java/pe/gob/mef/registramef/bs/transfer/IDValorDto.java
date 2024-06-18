/**
 * 
 */
package pe.gob.mef.registramef.bs.transfer;

import java.io.Serializable;

/**
 * @author CARLOS
 *
 */
public class IDValorDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2070827567912857969L;
	private Long id = null;
	private String valor = null;
	
	
	
	public IDValorDto(Long id, String valor) {
		super();
		this.id = id;
		this.valor = valor;
	}
	//MPINARES 14022024 - INICIO
		public IDValorDto() {
		}
		//MPINARES 14022024 - FIN

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
