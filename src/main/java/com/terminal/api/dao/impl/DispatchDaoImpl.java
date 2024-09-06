package com.terminal.api.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.terminal.api.client.EntryDispatchResponse;
import com.terminal.api.dao.IDispatchDao;
import com.terminal.api.entity.EntryDispatchEntity;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */

@Service
public class DispatchDaoImpl implements IDispatchDao {
	
	 @Value("${app.path.access.datasource.url}")
	 private String rutaBD;
	 
	 @Value("${app.path.file.sql}")
	 private String rutaArchivoSql;
	 
    public List<EntryDispatchEntity> retrieve(){
    	
    	
        String url = "jdbc:ucanaccess://" + rutaBD;

     // Fechas que pasarás como parámetros (puedes obtenerlas de tu aplicación)
        String fechaInicio = "2024-09-01";
        String fechaFin = "2024-09-10";
        
        EntryDispatchEntity entryDispatch=null;
        List<EntryDispatchEntity>  dispatchList=new ArrayList<>();
        
        try (Connection conexion = DriverManager.getConnection(url)) {

            // Invocar la consulta guardada         
            String query =obtenerQuery();
            
         // Conexión a la base de datos
            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                // Formato de fecha para Access
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                // Convertir fechas a tipo Date
                Date inicio = sdf.parse(fechaInicio);
                Date fin = sdf.parse(fechaFin);

                // Pasar los parámetros de fecha
                pstmt.setDate(1, new java.sql.Date(inicio.getTime()));
                pstmt.setDate(2, new java.sql.Date(fin.getTime()));
               // pstmt.setDate(3, new java.sql.Date(inicio.getTime()));
               // pstmt.setDate(4, new java.sql.Date(fin.getTime()));
                
                // Ejecutar la consulta
                ResultSet rs = pstmt.executeQuery();
               
                // Procesar los resultados
                while (rs.next()) {
                	
               
                	String numeroDespacho= rs.getString("numero_Despacho"); 
     			    int terId=rs.getInt("ter_Id");
     			    String nitEmpresaTppc1=rs.getString("nit_Empresa_Tppc1");
     			    int claseVehiculo=rs.getInt("clase_Vehiculo"); 
     			    int nivelServicio=rs.getInt("nivel_Servicio");
     				String placa= rs.getString("placa");
     				String dptoOrigenRuta=rs.getString("dpto_Origen_Ruta");
     				String municipioOrigenRuta= rs.getString("municipio_Origen_Ruta"); 
     				String dptoDestinoRuta=rs.getString("dpto_Destino_Ruta");
     				String municipioDestinoRuta= rs.getString("municipio_Destino_Ruta");
     				String viaRuta= rs.getString("via_Ruta");
     				String fechaDespacho=rs.getString("fecha_Despacho"); 
     				String horaDespacho=rs.getString("hora_Despacho");
     				String minutoDespacho=rs.getString("minuto_Despacho");
     				int pasajerosDespacho=rs.getInt("pasajeros_Despacho"); 
     				int tipoDespacho=rs.getInt("tipo_Despacho");
     				int tipoDespachoAutorizado=rs.getInt("tipo_Despacho_Autorizado");
     				String tipoConvenio=rs.getString("tipo_Convenio"); 
     				String nitEmpresaTppc2=rs.getString("nit_Empresa_Tppc2");
     				String nitEmpresaTe=rs.getString("nit_Empresa_Te");
     				int terminalesRecorridoRuta=rs.getInt("terminalRecorridoRuta");
     				int valorTasaUso=rs.getInt("total"); 
     				int origenPlaca=rs.getInt("origen_Placa");
                    
     				entryDispatch= new EntryDispatchEntity(
     						numeroDespacho,
     						BigInteger.valueOf(Integer.valueOf(terId)),
     						nitEmpresaTppc1,
     						BigInteger.valueOf(Integer.valueOf(claseVehiculo)),
     						BigInteger.valueOf(Integer.valueOf(nivelServicio)),
     						placa,
     						dptoOrigenRuta,
     						municipioOrigenRuta,
     						dptoDestinoRuta,
     						municipioDestinoRuta,
     	     				viaRuta,
     	     				fechaDespacho, 
     	     				horaDespacho,
     	     				minutoDespacho,
     	     				BigInteger.valueOf(Integer.valueOf(pasajerosDespacho)),
     	     				BigInteger.valueOf(Integer.valueOf(tipoDespacho)),
     	     				BigInteger.valueOf(Integer.valueOf(tipoDespachoAutorizado)),
     	     				tipoConvenio,
     	     				nitEmpresaTppc2,
     	     				nitEmpresaTe,
     	     				BigInteger.valueOf(Integer.valueOf(terminalesRecorridoRuta)),
     	     				BigInteger.valueOf(Integer.valueOf(valorTasaUso)),
     	     				BigInteger.valueOf(Integer.valueOf(origenPlaca)));
                }
                dispatchList.add(entryDispatch);

            } catch (SQLException | java.text.ParseException e) {
                e.printStackTrace();
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dispatchList;
    }

  /*  private Rol toEntity(RolRequest request) {
        return new ModelMapper().map(request, Rol.class);
    }
*/
    private EntryDispatchResponse toDto(EntryDispatchEntity entity) {
        return new ModelMapper().map(entity, EntryDispatchResponse.class);
    }
    
    public String obtenerQuery() {
    	
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoSql))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convertir StringBuilder a String
        String textoCompleto = contenido.toString();
        return textoCompleto;
        
    }
}