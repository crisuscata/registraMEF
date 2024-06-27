/**
 * 
 */
//PURIBE 16042024 - INICIO-->
package pe.gob.mef.registramef.web.controller.rs.data;

import java.io.Serializable;

/**
 * @author puribe
 *
 */
public class ColumnModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1344358909855787745L;
	private String header;  
    private String property;  
    private int tipo =0;
    private String filterMatchMode = "startsWith"; //"startsWith"(default), "endsWith", "contains" and "exact".
    private int width = 30;//SPRINT60
    private int idColumn = 0;
    private String leyenda = null;
    private String priority="";
    private String exportable="true";
 
	public ColumnModel(String header, String property, int tipo) {  
        this.header = header;  
        this.property = property;  
        this.tipo = tipo;
    }  

    public String getHeader() {  
        return header;  
    }  

    public String getProperty() {  
        return property;  
    }

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getFilterMatchMode() {
		return filterMatchMode;
	}

	public void setFilterMatchMode(String filterMatchMode) {
		this.filterMatchMode = filterMatchMode;
	}

	public String getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getIdColumn() {
		return idColumn;
	}

	public void setIdColumn(int idColumn) {
		this.idColumn = idColumn;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getExportable() {
		return exportable;
	}

	public void setExportable(String exportable) {
		this.exportable = exportable;
	}	
	
	
	   public String getPropertyTxt() {  
			if(tipo==8){
				return property+"Txt";
			}else{
				return property;
			}          
	    }
	
	 //PURIBE 16042024 - FIN-->
	
	
}
