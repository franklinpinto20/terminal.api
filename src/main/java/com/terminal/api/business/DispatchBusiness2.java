package com.terminal.api.business;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.terminal.api.client.EntryDispatchRequest;
import com.terminal.api.entity.RolEntity;
import com.terminal.api.model.RolResponse;
import com.terminal.api.repository.RolRepository;
import com.terminal.api.service.DispatchService;
import com.terminal.api.service.DispatchService2;
import com.terminal.api.service.RolService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DispatchBusiness2 implements DispatchService2 {
	/*@Autowired
	RolRepository rolRepository;*/
	 @Autowired
	    private JdbcTemplate template;
	 
    public List<EntryDispatchRequest> retrieve(){
    	
    	String rutaBD = "C:/pas2.accdb"; // Ruta a tu base de datos
        String url = "jdbc:ucanaccess://" + rutaBD;

     // Fechas que pasarás como parámetros (puedes obtenerlas de tu aplicación)
        String fechaInicio = "2024-09-01";
        String fechaFin = "2024-09-10";
        
        
        try (Connection conexion = DriverManager.getConnection(url)) {
            // Nombre de la consulta guardada
            String consultaGuardada = "sql_FEX_Depachos_Definitivo_LRV_v2";

            // Invocar la consulta guardada
            //String sql = "SELECT * FROM " + consultaGuardada;
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
                	/* String Nconduce=rs.getString("Nconduce");
                	System.out.println("Nconduce"+Nconduce); */
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
                     // Procesar los datos obtenidos
                     System.out.println("Columna numeroDespacho: " + numeroDespacho + ", Columna claseVehiculo: " + claseVehiculo);
                }

            } catch (SQLException | java.text.ParseException e) {
                e.printStackTrace();
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

  /*  private Rol toEntity(RolRequest request) {
        return new ModelMapper().map(request, Rol.class);
    }
*/
    private RolResponse toDto(RolEntity entity) {
        return new ModelMapper().map(entity, RolResponse.class);
    }
    
    public String obtenerQuery() {
    	String rutaArchivo = "C:/Users/Usuario/Documents/workspace/terminal.api/src/main/resources/view.sql"; // Especifica la ruta del archivo aquí
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
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