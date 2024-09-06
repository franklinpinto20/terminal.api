SELECT top 1
c.Nconduce AS NUMERO_DESPACHO,
15 AS TER_ID,
e.Nit AS NIT_EMPRESA_TPPC1,
tt.Clase_vehiculo AS CLASE_VEHICULO,
ev.Nivel_Servicio AS NIVEL_SERVICIO,
v.Placa AS PLACA,

(select d1.RuDpto from Destino AS d1, Conduce AS c4 where d1.Id_destino = c4.Origen2  and c.Nconduce = c4.Nconduce) AS DPTO_ORIGEN_RUTA,
(select d1.RuCodMun from Destino AS d1, Conduce AS c4 where d1.Id_destino = c4.Origen2  and c.Nconduce = c4.Nconduce) AS MUNICIPIO_ORIGEN_RUTA,
(select d1.RuDpto from Destino AS d1, Conduce AS c4 where d1.Id_destino = c4.Destino  and c.Nconduce = c4.Nconduce) AS DPTO_DESTINO_RUTA,
(select d1.RuCodMun from Destino AS d1, Conduce AS c4 where d1.Id_destino = c4.Destino  and c.Nconduce = c4.Nconduce) AS MUNICIPIO_DESTINO_RUTA,
"NO ESPECIFICA" AS VIA_RUTA,
c.Fecha_conduce AS FECHA_DESPACHO,
	c.Hora_conduce AS HORA_DESPACHO,
	c.Minuto_conduce AS MINUTO_DESPACHO,
4 AS PASAJEROS_DESPACHO,
SWITCH ( c.Origen = "5", '1', c.Origen <> "5", '2' ) AS TIPO_DESPACHO,
1 AS TIPO_DESPACHO_AUTORIZADO,
"" AS TIPO_CONVENIO,
"" AS NIT_EMPRESA_TPPC2,
"" AS NIT_EMPRESA_TE,
e.TerminalRecorridoRuta  AS TERMINALES_RECORRIDO_RUTA,
c.Total AS VALOR_TASA_USO,
v.Origen_Placa AS ORIGEN_PLACA

from Empresas AS e, Vehiculo AS v, Empresa_vehiculo AS ev, Tipo_transporte AS tt, Conduce AS c, Destino AS d --, Destino AS dd
where c.Fecha_salida Between ? AND ?
and v.Placa = ev.Placa 
and e.id_Empresa = ev.Id_Empresa
and tt.Id_tipo_transporte = v.Tipo_transporte
And c.Destino = d.Id_destino 
--and c.Origen2 = dd.Id_destino
and c.Estado = "-Activo-"
and v.Placa = c.Placa
and d.RuCodMun not in ( '0', '518' )
--and dd.RuCodMun not in ( '0', '518' )
