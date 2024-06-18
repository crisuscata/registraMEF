/**
 * ExpedienteSACCDto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.mef.std.bs.web.ws;
//SPRINT01.2 NUEVO
public class ExpedienteSACCDto  implements java.io.Serializable {
    private java.lang.String anexos;

    private java.lang.String asunto;

    private java.lang.String expedienteiddoc;

    private java.lang.String fechahoradeiniciodetramite;

    private java.lang.String fechahoradeldocumento;

    private java.lang.String fechahorafindocumento;

    private java.lang.String fechahorarecepcion;

    private pe.gob.mef.std.bs.web.ws.MovimientoSACCDto[] movimientos;

    private java.lang.String noexpediente;

    private java.lang.String numerodedocumento;

    private java.lang.String numerodefolios;

    private java.lang.String observacionfindocumento;

    private java.lang.String situacionactual;

    private java.lang.String tipodedocumento;

    public ExpedienteSACCDto() {
    }

    public ExpedienteSACCDto(
           java.lang.String anexos,
           java.lang.String asunto,
           java.lang.String expedienteiddoc,
           java.lang.String fechahoradeiniciodetramite,
           java.lang.String fechahoradeldocumento,
           java.lang.String fechahorafindocumento,
           java.lang.String fechahorarecepcion,
           pe.gob.mef.std.bs.web.ws.MovimientoSACCDto[] movimientos,
           java.lang.String noexpediente,
           java.lang.String numerodedocumento,
           java.lang.String numerodefolios,
           java.lang.String observacionfindocumento,
           java.lang.String situacionactual,
           java.lang.String tipodedocumento) {
           this.anexos = anexos;
           this.asunto = asunto;
           this.expedienteiddoc = expedienteiddoc;
           this.fechahoradeiniciodetramite = fechahoradeiniciodetramite;
           this.fechahoradeldocumento = fechahoradeldocumento;
           this.fechahorafindocumento = fechahorafindocumento;
           this.fechahorarecepcion = fechahorarecepcion;
           this.movimientos = movimientos;
           this.noexpediente = noexpediente;
           this.numerodedocumento = numerodedocumento;
           this.numerodefolios = numerodefolios;
           this.observacionfindocumento = observacionfindocumento;
           this.situacionactual = situacionactual;
           this.tipodedocumento = tipodedocumento;
    }


    /**
     * Gets the anexos value for this ExpedienteSACCDto.
     * 
     * @return anexos
     */
    public java.lang.String getAnexos() {
        return anexos;
    }


    /**
     * Sets the anexos value for this ExpedienteSACCDto.
     * 
     * @param anexos
     */
    public void setAnexos(java.lang.String anexos) {
        this.anexos = anexos;
    }


    /**
     * Gets the asunto value for this ExpedienteSACCDto.
     * 
     * @return asunto
     */
    public java.lang.String getAsunto() {
        return asunto;
    }


    /**
     * Sets the asunto value for this ExpedienteSACCDto.
     * 
     * @param asunto
     */
    public void setAsunto(java.lang.String asunto) {
        this.asunto = asunto;
    }


    /**
     * Gets the expedienteiddoc value for this ExpedienteSACCDto.
     * 
     * @return expedienteiddoc
     */
    public java.lang.String getExpedienteiddoc() {
        return expedienteiddoc;
    }


    /**
     * Sets the expedienteiddoc value for this ExpedienteSACCDto.
     * 
     * @param expedienteiddoc
     */
    public void setExpedienteiddoc(java.lang.String expedienteiddoc) {
        this.expedienteiddoc = expedienteiddoc;
    }


    /**
     * Gets the fechahoradeiniciodetramite value for this ExpedienteSACCDto.
     * 
     * @return fechahoradeiniciodetramite
     */
    public java.lang.String getFechahoradeiniciodetramite() {
        return fechahoradeiniciodetramite;
    }


    /**
     * Sets the fechahoradeiniciodetramite value for this ExpedienteSACCDto.
     * 
     * @param fechahoradeiniciodetramite
     */
    public void setFechahoradeiniciodetramite(java.lang.String fechahoradeiniciodetramite) {
        this.fechahoradeiniciodetramite = fechahoradeiniciodetramite;
    }


    /**
     * Gets the fechahoradeldocumento value for this ExpedienteSACCDto.
     * 
     * @return fechahoradeldocumento
     */
    public java.lang.String getFechahoradeldocumento() {
        return fechahoradeldocumento;
    }


    /**
     * Sets the fechahoradeldocumento value for this ExpedienteSACCDto.
     * 
     * @param fechahoradeldocumento
     */
    public void setFechahoradeldocumento(java.lang.String fechahoradeldocumento) {
        this.fechahoradeldocumento = fechahoradeldocumento;
    }


    /**
     * Gets the fechahorafindocumento value for this ExpedienteSACCDto.
     * 
     * @return fechahorafindocumento
     */
    public java.lang.String getFechahorafindocumento() {
        return fechahorafindocumento;
    }


    /**
     * Sets the fechahorafindocumento value for this ExpedienteSACCDto.
     * 
     * @param fechahorafindocumento
     */
    public void setFechahorafindocumento(java.lang.String fechahorafindocumento) {
        this.fechahorafindocumento = fechahorafindocumento;
    }


    /**
     * Gets the fechahorarecepcion value for this ExpedienteSACCDto.
     * 
     * @return fechahorarecepcion
     */
    public java.lang.String getFechahorarecepcion() {
        return fechahorarecepcion;
    }


    /**
     * Sets the fechahorarecepcion value for this ExpedienteSACCDto.
     * 
     * @param fechahorarecepcion
     */
    public void setFechahorarecepcion(java.lang.String fechahorarecepcion) {
        this.fechahorarecepcion = fechahorarecepcion;
    }


    /**
     * Gets the movimientos value for this ExpedienteSACCDto.
     * 
     * @return movimientos
     */
    public pe.gob.mef.std.bs.web.ws.MovimientoSACCDto[] getMovimientos() {
        return movimientos;
    }


    /**
     * Sets the movimientos value for this ExpedienteSACCDto.
     * 
     * @param movimientos
     */
    public void setMovimientos(pe.gob.mef.std.bs.web.ws.MovimientoSACCDto[] movimientos) {
        this.movimientos = movimientos;
    }

    public pe.gob.mef.std.bs.web.ws.MovimientoSACCDto getMovimientos(int i) {
        return this.movimientos[i];
    }

    public void setMovimientos(int i, pe.gob.mef.std.bs.web.ws.MovimientoSACCDto _value) {
        this.movimientos[i] = _value;
    }


    /**
     * Gets the noexpediente value for this ExpedienteSACCDto.
     * 
     * @return noexpediente
     */
    public java.lang.String getNoexpediente() {
        return noexpediente;
    }


    /**
     * Sets the noexpediente value for this ExpedienteSACCDto.
     * 
     * @param noexpediente
     */
    public void setNoexpediente(java.lang.String noexpediente) {
        this.noexpediente = noexpediente;
    }


    /**
     * Gets the numerodedocumento value for this ExpedienteSACCDto.
     * 
     * @return numerodedocumento
     */
    public java.lang.String getNumerodedocumento() {
        return numerodedocumento;
    }


    /**
     * Sets the numerodedocumento value for this ExpedienteSACCDto.
     * 
     * @param numerodedocumento
     */
    public void setNumerodedocumento(java.lang.String numerodedocumento) {
        this.numerodedocumento = numerodedocumento;
    }


    /**
     * Gets the numerodefolios value for this ExpedienteSACCDto.
     * 
     * @return numerodefolios
     */
    public java.lang.String getNumerodefolios() {
        return numerodefolios;
    }


    /**
     * Sets the numerodefolios value for this ExpedienteSACCDto.
     * 
     * @param numerodefolios
     */
    public void setNumerodefolios(java.lang.String numerodefolios) {
        this.numerodefolios = numerodefolios;
    }


    /**
     * Gets the observacionfindocumento value for this ExpedienteSACCDto.
     * 
     * @return observacionfindocumento
     */
    public java.lang.String getObservacionfindocumento() {
        return observacionfindocumento;
    }


    /**
     * Sets the observacionfindocumento value for this ExpedienteSACCDto.
     * 
     * @param observacionfindocumento
     */
    public void setObservacionfindocumento(java.lang.String observacionfindocumento) {
        this.observacionfindocumento = observacionfindocumento;
    }


    /**
     * Gets the situacionactual value for this ExpedienteSACCDto.
     * 
     * @return situacionactual
     */
    public java.lang.String getSituacionactual() {
        return situacionactual;
    }


    /**
     * Sets the situacionactual value for this ExpedienteSACCDto.
     * 
     * @param situacionactual
     */
    public void setSituacionactual(java.lang.String situacionactual) {
        this.situacionactual = situacionactual;
    }


    /**
     * Gets the tipodedocumento value for this ExpedienteSACCDto.
     * 
     * @return tipodedocumento
     */
    public java.lang.String getTipodedocumento() {
        return tipodedocumento;
    }


    /**
     * Sets the tipodedocumento value for this ExpedienteSACCDto.
     * 
     * @param tipodedocumento
     */
    public void setTipodedocumento(java.lang.String tipodedocumento) {
        this.tipodedocumento = tipodedocumento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExpedienteSACCDto)) return false;
        ExpedienteSACCDto other = (ExpedienteSACCDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anexos==null && other.getAnexos()==null) || 
             (this.anexos!=null &&
              this.anexos.equals(other.getAnexos()))) &&
            ((this.asunto==null && other.getAsunto()==null) || 
             (this.asunto!=null &&
              this.asunto.equals(other.getAsunto()))) &&
            ((this.expedienteiddoc==null && other.getExpedienteiddoc()==null) || 
             (this.expedienteiddoc!=null &&
              this.expedienteiddoc.equals(other.getExpedienteiddoc()))) &&
            ((this.fechahoradeiniciodetramite==null && other.getFechahoradeiniciodetramite()==null) || 
             (this.fechahoradeiniciodetramite!=null &&
              this.fechahoradeiniciodetramite.equals(other.getFechahoradeiniciodetramite()))) &&
            ((this.fechahoradeldocumento==null && other.getFechahoradeldocumento()==null) || 
             (this.fechahoradeldocumento!=null &&
              this.fechahoradeldocumento.equals(other.getFechahoradeldocumento()))) &&
            ((this.fechahorafindocumento==null && other.getFechahorafindocumento()==null) || 
             (this.fechahorafindocumento!=null &&
              this.fechahorafindocumento.equals(other.getFechahorafindocumento()))) &&
            ((this.fechahorarecepcion==null && other.getFechahorarecepcion()==null) || 
             (this.fechahorarecepcion!=null &&
              this.fechahorarecepcion.equals(other.getFechahorarecepcion()))) &&
            ((this.movimientos==null && other.getMovimientos()==null) || 
             (this.movimientos!=null &&
              java.util.Arrays.equals(this.movimientos, other.getMovimientos()))) &&
            ((this.noexpediente==null && other.getNoexpediente()==null) || 
             (this.noexpediente!=null &&
              this.noexpediente.equals(other.getNoexpediente()))) &&
            ((this.numerodedocumento==null && other.getNumerodedocumento()==null) || 
             (this.numerodedocumento!=null &&
              this.numerodedocumento.equals(other.getNumerodedocumento()))) &&
            ((this.numerodefolios==null && other.getNumerodefolios()==null) || 
             (this.numerodefolios!=null &&
              this.numerodefolios.equals(other.getNumerodefolios()))) &&
            ((this.observacionfindocumento==null && other.getObservacionfindocumento()==null) || 
             (this.observacionfindocumento!=null &&
              this.observacionfindocumento.equals(other.getObservacionfindocumento()))) &&
            ((this.situacionactual==null && other.getSituacionactual()==null) || 
             (this.situacionactual!=null &&
              this.situacionactual.equals(other.getSituacionactual()))) &&
            ((this.tipodedocumento==null && other.getTipodedocumento()==null) || 
             (this.tipodedocumento!=null &&
              this.tipodedocumento.equals(other.getTipodedocumento())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAnexos() != null) {
            _hashCode += getAnexos().hashCode();
        }
        if (getAsunto() != null) {
            _hashCode += getAsunto().hashCode();
        }
        if (getExpedienteiddoc() != null) {
            _hashCode += getExpedienteiddoc().hashCode();
        }
        if (getFechahoradeiniciodetramite() != null) {
            _hashCode += getFechahoradeiniciodetramite().hashCode();
        }
        if (getFechahoradeldocumento() != null) {
            _hashCode += getFechahoradeldocumento().hashCode();
        }
        if (getFechahorafindocumento() != null) {
            _hashCode += getFechahorafindocumento().hashCode();
        }
        if (getFechahorarecepcion() != null) {
            _hashCode += getFechahorarecepcion().hashCode();
        }
        if (getMovimientos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMovimientos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMovimientos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNoexpediente() != null) {
            _hashCode += getNoexpediente().hashCode();
        }
        if (getNumerodedocumento() != null) {
            _hashCode += getNumerodedocumento().hashCode();
        }
        if (getNumerodefolios() != null) {
            _hashCode += getNumerodefolios().hashCode();
        }
        if (getObservacionfindocumento() != null) {
            _hashCode += getObservacionfindocumento().hashCode();
        }
        if (getSituacionactual() != null) {
            _hashCode += getSituacionactual().hashCode();
        }
        if (getTipodedocumento() != null) {
            _hashCode += getTipodedocumento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExpedienteSACCDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.web.bs.std.mef.gob.pe/", "expedienteSACCDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anexos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anexos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asunto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "asunto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expedienteiddoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "expedienteiddoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechahoradeiniciodetramite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechahoradeiniciodetramite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechahoradeldocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechahoradeldocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechahorafindocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechahorafindocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechahorarecepcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechahorarecepcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("movimientos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "movimientos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.web.bs.std.mef.gob.pe/", "movimientoSACCDto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noexpediente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noexpediente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numerodedocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numerodedocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numerodefolios");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numerodefolios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observacionfindocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "observacionfindocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("situacionactual");
        elemField.setXmlName(new javax.xml.namespace.QName("", "situacionactual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipodedocumento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipodedocumento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
