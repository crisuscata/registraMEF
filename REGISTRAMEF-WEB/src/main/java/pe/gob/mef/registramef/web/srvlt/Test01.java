package pe.gob.mef.registramef.web.srvlt;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {

		List<String> perfilesSistema = new ArrayList<>();
		
		
		perfilesSistema.add("REGISTRAMEF_USUARIO_OGC");
		perfilesSistema.add("REGISTRAMEF_GESTOR_CENTRO");
		perfilesSistema.add("REGISTRAMEF_ADMIN_REPORTES");
		perfilesSistema.add("REGISTRAMEF_USUARIO_EXTERNO_OGC");
		perfilesSistema.add("REGISTRAMEF_ADMINISTRADOR_OGTI");
		
		String perfilTest= "REGISTRAMEF_USUARIO_OGC2";
		
		if(perfilesSistema.contains(perfilTest)) {
			System.out.println("Esta en el perfil");
		}
		
		
		

	}

}
