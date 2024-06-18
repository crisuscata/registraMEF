  CREATE TABLE REGISTRAMEF.DT_USUARIOS_SEDES 
   (	
        ID_USU_SEDE NUMBER(10,0) NOT NULL ENABLE, 	 
	ID_SEDE NUMBER(10,0) NOT NULL ENABLE,
	IDUSUARIO NUMBER(10,0) NOT NULL ENABLE, 
	IDUSSER_CREA NUMBER(10,0), 
	IDUSSER_MODIF NUMBER(10,0), 
	FECHA_CREA DATE, 
	FECHA_MODIF DATE,
        ESTADO NUMBER(10,0), 
	RTMADDRESS VARCHAR2(50), 
	RTMADDRESSRST VARCHAR2(50)
    ); 
 

   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.ID_USU_SEDE IS 'CODIGO UNICO QUE IDENTIFICA A LOS USUARIOS CONTRA LAS SEDES. CÓDIGO';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.IDUSSER_CREA IS 'CODIGO IDENTIFICADOR DEL USUARIO QUE CREA EL REGISTRO. USUARIO QUE CREA, SISTEMA';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.IDUSSER_MODIF IS 'CODIGO IDENTIFICADOR DEL USUARIO QUE MODIFICA EL REGISTRO. USUARIO QUE MODIFICA, SISTEMA';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.FECHA_CREA IS 'FECHA Y HORA EN LA QUE SE CREA EL REGISTRO. FECHA DE CREACIÓN, SISTEMA';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.FECHA_MODIF IS 'FECHA Y HORA EN LA QUE SE MODIFICA EL REGISTRO. FECHA DE MODIFICACIÓN, SISTEMA';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.ID_SEDE IS 'CODIGO UNICO DE LA SEDE. SEDE, NUMBER';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.IDUSUARIO IS 'CÓDIGO ÚNICO QUE IDENTIFICA AL USUARIO. USUARIO, NUMBER';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.ESTADO IS 'CÓDIGO QUE IDENTIFICA AL ESTADOO DEL REGISTRO. ESTADO, NUMBER';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.RTMADDRESS IS 'CONTIENE LA DIRECCIÓN IP DONDE SE REALIZA LA CREACIÓN DEL REGISTRO. IP USUARIO QUE CREA, SISTEMA';
 
   COMMENT ON COLUMN REGISTRAMEF.DT_CAPA_ENTIDADES.RTMADDRESSRST IS 'CONTIENE LA DIRECCIÓN IP DONDE SE REALIZA LA MODIFICACIÓN DEL REGISTRO. IP USUARIO QUE MODIFICA, SISTEMA';
 
   COMMENT ON TABLE REGISTRAMEF.DT_USUARIOS_SEDES  IS 'ALMACENA A LAS SEDES A LAS QUE PUEDEN PERTENECER LOS USUARIOS';

   ALTER TABLE DT_USUARIOS_SEDES ADD CONSTRAINT DT_USUARIOS_SEDES_PK PRIMARY KEY (ID_USU_SEDE) ENABLE;

   CREATE INDEX REGISTRAMEF.INDEX_DT_US_USUARIO ON REGISTRAMEF.DT_USUARIOS_SEDES (IDUSUARIO ASC);

   CREATE SEQUENCE REGISTRAMEF.SQ_DT_USUARIOS_SEDES INCREMENT BY 1 START WITH 1 MINVALUE 1;
 
---PURIBE 25012024
   ALTER TABLE prt_parametros MODIFY DESCRIPCION VARCHAR2(500);

INSERT INTO prt_parametros (IDPARAMETRO,IDPADRE,DESCRIPCION,ESTADO,IDUSER_CREA,IDUSER_MODIF,
FECHA_CREA,FECHA_MODIF,RTMADDRESS,RTMADDRESSMODIF)
VALUES (448,0,'NOTIFICACION',3,1,1,SYSDATE,SYSDATE,'','');

INSERT INTO prt_parametros (IDPARAMETRO,IDPADRE,DESCRIPCION,ESTADO,IDUSER_CREA,IDUSER_MODIF,
FECHA_CREA,FECHA_MODIF,RTMADDRESS,RTMADDRESSMODIF)
VALUES (449,448,'SE TIENE PENDIENTES POR ACTUALIZAR, REVISAR EN EL SISTEMA',3,1,1,SYSDATE,SYSDATE,'','');
