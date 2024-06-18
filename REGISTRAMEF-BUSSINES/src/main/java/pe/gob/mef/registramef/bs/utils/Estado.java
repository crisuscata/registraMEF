package pe.gob.mef.registramef.bs.utils;

/*
 
public enum Demarcacion{PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO}
Demarcacion delantero = Demarcacion.DELANTERO;    // Instancia de un enum de la clase Demarcación
delantero.name();    // Devuelve un String con el nombre de la constante (DELANTERO)
delantero.toString();    // Devuelve un String con el nombre de la constante (DELANTERO)
delantero.ordinal();    // Devuelve un entero con la posición del enum según está declarada (3).
delantero.compareTo(Enum otro);    // Compara el enum con el parámetro según el orden en el que están declarados lo enum
Demarcacion.values();    // Devuelve un array que contiene todos los enum
 
 */

public enum Estado {

	ELIMINADO("Eliminado",2L),ACTIVO("Activo",3L), ASISTENCIACERO("Asistencia cero",200L), FINALIZADO("Finalizado",148L), ACUMULADO("Acumulado",149L);
	
	private String descripcion = null;
	private long valor = 0;
	
	private Estado (String descripcion, long valor){
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public long getValor() {
		return valor;
	}
}
