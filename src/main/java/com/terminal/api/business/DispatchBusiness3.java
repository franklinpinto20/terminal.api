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
import com.terminal.api.service.DispatchService3;
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
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DispatchBusiness3 implements DispatchService3 {
	/*@Autowired
	RolRepository rolRepository;*/
	 @Autowired
	    private JdbcTemplate template;
	 
    public List<EntryDispatchRequest> retrieve(){
    	
    	String rutaBD = "C:/pas.accdb"; // Ruta a tu base de datos
        String url = "jdbc:ucanaccess://" + rutaBD;

        try (Connection conexion = DriverManager.getConnection(url)) {
            // Consulta para obtener las consultas guardadas desde MSysObjects
            String sql = "SELECT Name FROM MSysObjects WHERE Type=5 AND Name NOT LIKE 'MSys%'";
            try (PreparedStatement stmt = conexion.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String nombreConsulta = rs.getString("Name");
                    System.out.println("Consulta encontrada: " + nombreConsulta);

                    // Aquí puedes ejecutar la consulta si lo deseas
                    ejecutarConsultaGuardada(conexion, nombreConsulta);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    private static void ejecutarConsultaGuardada(Connection conexion, String nombreConsulta) {
        String sql = "SELECT * FROM " + nombreConsulta;
        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Procesar el resultado de la consulta
            while (rs.next()) {
                // Supongamos que la consulta devuelve columnas "Columna1" y "Columna2"
                String usuario=rs.getString("usuario"); 
                String clave=rs.getString("clave"); 
                String numeroDespacho= rs.getString("numeroDespacho"); 
			    BigInteger terId=rs.getBigDecimal("terId").toBigInteger();
			    String nitEmpresaTppc1=rs.getString("nitEmpresaTppc1");
			    BigInteger claseVehiculo=rs.getBigDecimal("claseVehiculo").toBigInteger(); 
			    BigInteger nivelServicio=rs.getBigDecimal("nivelServicio").toBigInteger();
				String placa= rs.getString("placa");
				String dptoOrigenRuta=rs.getString("dptoOrigenRuta");
				String municipioOrigenRuta= rs.getString("municipioOrigenRuta"); 
				String dptoDestinoRuta=rs.getString("dptoDestinoRuta");
				String municipioDestinoRuta= rs.getString("municipioDestinoRuta");
				String viaRuta= rs.getString("viaRuta");
				String fechaDespacho=rs.getString("fechaDespacho"); 
				String horaDespacho=rs.getString("horaDespacho");
				String minutoDespacho=rs.getString("minutoDespacho");
				BigInteger pasajerosDespacho=rs.getBigDecimal("pasajerosDespacho").toBigInteger(); 
				BigInteger tipoDespacho=rs.getBigDecimal("tipoDespacho").toBigInteger();
				BigInteger tipoDespachoAutorizado=rs.getBigDecimal("tipoDespachoAutorizado").toBigInteger();
				BigInteger tipoConvenio=rs.getBigDecimal("tipoConvenio").toBigInteger(); 
				BigInteger nitEmpresaTppc2=rs.getBigDecimal("nitEmpresaTppc2").toBigInteger();
				BigInteger nitEmpresaTe=rs.getBigDecimal("nitEmpresaTe").toBigInteger();
				BigInteger terminalesRecorridoRuta=rs.getBigDecimal("terminalesRecorridoRuta").toBigInteger();
				BigInteger valorTasaUso=rs.getBigDecimal("valorTasaUso").toBigInteger(); 
				BigInteger origenPlaca=rs.getBigDecimal("origenPlaca").toBigInteger();
                // Procesar los datos obtenidos
                System.out.println("Columna numeroDespacho: " + numeroDespacho + ", Columna claseVehiculo: " + claseVehiculo);
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta: " + nombreConsulta);
            e.printStackTrace();
        }
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