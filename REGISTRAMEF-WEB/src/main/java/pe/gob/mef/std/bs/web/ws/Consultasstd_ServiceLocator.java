/**
 * Consultasstd_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.gob.mef.std.bs.web.ws;
//SPRINT01.2 NUEVO
public class Consultasstd_ServiceLocator extends org.apache.axis.client.Service implements pe.gob.mef.std.bs.web.ws.Consultasstd_Service {

    public Consultasstd_ServiceLocator() {
    }


    public Consultasstd_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Consultasstd_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ConsultasSTDPort
    private java.lang.String ConsultasSTDPort_address = "http://10.5.115.48:8080/tramite/webservice/consultasstd";

    public java.lang.String getConsultasSTDPortAddress() {
        return ConsultasSTDPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConsultasSTDPortWSDDServiceName = "ConsultasSTDPort";

    public java.lang.String getConsultasSTDPortWSDDServiceName() {
        return ConsultasSTDPortWSDDServiceName;
    }

    public void setConsultasSTDPortWSDDServiceName(java.lang.String name) {
        ConsultasSTDPortWSDDServiceName = name;
    }

    public pe.gob.mef.std.bs.web.ws.Consultasstd_PortType getConsultasSTDPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConsultasSTDPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConsultasSTDPort(endpoint);
    }

    public pe.gob.mef.std.bs.web.ws.Consultasstd_PortType getConsultasSTDPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.gob.mef.std.bs.web.ws.ConsultasSTDPortBindingStub _stub = new pe.gob.mef.std.bs.web.ws.ConsultasSTDPortBindingStub(portAddress, this);
            _stub.setPortName(getConsultasSTDPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConsultasSTDPortEndpointAddress(java.lang.String address) {
        ConsultasSTDPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.gob.mef.std.bs.web.ws.Consultasstd_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.gob.mef.std.bs.web.ws.ConsultasSTDPortBindingStub _stub = new pe.gob.mef.std.bs.web.ws.ConsultasSTDPortBindingStub(new java.net.URL(ConsultasSTDPort_address), this);
                _stub.setPortName(getConsultasSTDPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ConsultasSTDPort".equals(inputPortName)) {
            return getConsultasSTDPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.web.bs.std.mef.gob.pe/", "consultasstd");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.web.bs.std.mef.gob.pe/", "ConsultasSTDPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ConsultasSTDPort".equals(portName)) {
            setConsultasSTDPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
