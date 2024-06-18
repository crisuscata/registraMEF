package pe.gob.mef.std.bs.web.ws;
//SPRINT01.2 NUEVO
public class ConsultasstdProxy implements pe.gob.mef.std.bs.web.ws.Consultasstd_PortType {
  private String _endpoint = null;
  private pe.gob.mef.std.bs.web.ws.Consultasstd_PortType consultasstd_PortType = null;
  
  public ConsultasstdProxy() {
    _initConsultasstdProxy();
  }
  
  public ConsultasstdProxy(String endpoint) {
    _endpoint = endpoint;
    _initConsultasstdProxy();
  }
  
  private void _initConsultasstdProxy() {
    try {
      consultasstd_PortType = (new pe.gob.mef.std.bs.web.ws.Consultasstd_ServiceLocator()).getConsultasSTDPort();
      if (consultasstd_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)consultasstd_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)consultasstd_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (consultasstd_PortType != null)
      ((javax.xml.rpc.Stub)consultasstd_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.gob.mef.std.bs.web.ws.Consultasstd_PortType getConsultasstd_PortType() {
    if (consultasstd_PortType == null)
      _initConsultasstdProxy();
    return consultasstd_PortType;
  }
  
  public pe.gob.mef.std.bs.web.ws.ExpedienteRegWSDto consultaExpedienteReg(int anio, java.lang.String numero) throws java.rmi.RemoteException, pe.gob.mef.std.bs.web.ws.ErrorInfo{
    if (consultasstd_PortType == null)
      _initConsultasstdProxy();
    return consultasstd_PortType.consultaExpedienteReg(anio, numero);
  }
  
  public pe.gob.mef.std.bs.web.ws.ExpedienteSACCDto consultaExpediente(int anio, java.lang.String numero) throws java.rmi.RemoteException, pe.gob.mef.std.bs.web.ws.ErrorInfo{
    if (consultasstd_PortType == null)
      _initConsultasstdProxy();
    return consultasstd_PortType.consultaExpediente(anio, numero);
  }
  
  
}