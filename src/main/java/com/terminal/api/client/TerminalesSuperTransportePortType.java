
package com.terminal.api.client;

import java.math.BigInteger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TerminalesSuperTransportePortType", targetNamespace = "urn:SPTCDAwsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface TerminalesSuperTransportePortType {


    /**
     * Permite ingresar Despacho de automovil
     * 
     * @param nitEmpresaTe
     * @param nivelServicio
     * @param claseVehiculo
     * @param nitEmpresaTppc1
     * @param nitEmpresaTppc2
     * @param terId
     * @param tipoDespacho
     * @param viaRuta
     * @param origenPlaca
     * @param municipioDestinoRuta
     * @param dptoDestinoRuta
     * @param fechaDespacho
     * @param placa
     * @param clave
     * @param terminalesRecorridoRuta
     * @param numeroDespacho
     * @param municipioOrigenRuta
     * @param tipoConvenio
     * @param dptoOrigenRuta
     * @param horaDespacho
     * @param pasajerosDespacho
     * @param minutoDespacho
     * @param valorTasaUso
     * @param usuario
     * @param tipoDespachoAutorizado
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "IngresoDespacho", action = "urn:SPTCDAwsdl#IngresoDespacho")
    @WebResult(partName = "return")
    public String ingresoDespacho(
        @WebParam(name = "usuario", partName = "usuario")
        String usuario,
        @WebParam(name = "clave", partName = "clave")
        String clave,
        @WebParam(name = "numero_despacho", partName = "numero_despacho")
        String numeroDespacho,
        @WebParam(name = "ter_id", partName = "ter_id")
        BigInteger terId,
        @WebParam(name = "nit_empresa_tppc1", partName = "nit_empresa_tppc1")
        String nitEmpresaTppc1,
        @WebParam(name = "clase_vehiculo", partName = "clase_vehiculo")
        BigInteger claseVehiculo,
        @WebParam(name = "nivel_servicio", partName = "nivel_servicio")
        BigInteger nivelServicio,
        @WebParam(name = "placa", partName = "placa")
        String placa,
        @WebParam(name = "dpto_origen_ruta", partName = "dpto_origen_ruta")
        String dptoOrigenRuta,
        @WebParam(name = "municipio_origen_ruta", partName = "municipio_origen_ruta")
        String municipioOrigenRuta,
        @WebParam(name = "dpto_destino_ruta", partName = "dpto_destino_ruta")
        String dptoDestinoRuta,
        @WebParam(name = "municipio_destino_ruta", partName = "municipio_destino_ruta")
        String municipioDestinoRuta,
        @WebParam(name = "via_ruta", partName = "via_ruta")
        String viaRuta,
        @WebParam(name = "fecha_despacho", partName = "fecha_despacho")
        String fechaDespacho,
        @WebParam(name = "hora_despacho", partName = "hora_despacho")
        String horaDespacho,
        @WebParam(name = "minuto_despacho", partName = "minuto_despacho")
        String minutoDespacho,
        @WebParam(name = "pasajeros_despacho", partName = "pasajeros_despacho")
        BigInteger pasajerosDespacho,
        @WebParam(name = "tipo_despacho", partName = "tipo_despacho")
        BigInteger tipoDespacho,
        @WebParam(name = "tipo_despacho_autorizado", partName = "tipo_despacho_autorizado")
        BigInteger tipoDespachoAutorizado,
        @WebParam(name = "tipo_convenio", partName = "tipo_convenio")
        BigInteger tipoConvenio,
        @WebParam(name = "nit_empresa_tppc2", partName = "nit_empresa_tppc2")
        BigInteger nitEmpresaTppc2,
        @WebParam(name = "nit_empresa_te", partName = "nit_empresa_te")
        BigInteger nitEmpresaTe,
        @WebParam(name = "terminales_recorrido_ruta", partName = "terminales_recorrido_ruta")
        BigInteger terminalesRecorridoRuta,
        @WebParam(name = "valor_tasa_uso", partName = "valor_tasa_uso")
        BigInteger valorTasaUso,
        @WebParam(name = "origen_placa", partName = "origen_placa")
        BigInteger origenPlaca);

    /**
     * Permite ingresar Alcoholimetrias positivas
     * 
     * @param tipoDocumentoConductor
     * @param clave
     * @param horaPrueba
     * @param numeroDespacho
     * @param nitOperador
     * @param fechaPrueba
     * @param minutoPrueba
     * @param terId
     * @param resultadosPrueba
     * @param minutoExamen
     * @param gradoAlcoholemia
     * @param resultadoExamen
     * @param nombreConductor
     * @param horaExamen
     * @param examenMedico
     * @param usuario
     * @param razonSocialOperador
     * @param numeroDocumentoConductor
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "IngresoAlcoholimetria", action = "urn:SPTCDAwsdl#IngresoAlcoholimetria")
    @WebResult(partName = "return")
    public String ingresoAlcoholimetria(
        @WebParam(name = "usuario", partName = "usuario")
        String usuario,
        @WebParam(name = "clave", partName = "clave")
        String clave,
        @WebParam(name = "numero_despacho", partName = "numero_despacho")
        String numeroDespacho,
        @WebParam(name = "nit_operador", partName = "nit_operador")
        String nitOperador,
        @WebParam(name = "razon_social_operador", partName = "razon_social_operador")
        String razonSocialOperador,
        @WebParam(name = "ter_id", partName = "ter_id")
        String terId,
        @WebParam(name = "tipo_documento_conductor", partName = "tipo_documento_conductor")
        BigInteger tipoDocumentoConductor,
        @WebParam(name = "numero_documento_conductor", partName = "numero_documento_conductor")
        String numeroDocumentoConductor,
        @WebParam(name = "nombre_conductor", partName = "nombre_conductor")
        String nombreConductor,
        @WebParam(name = "fecha_prueba", partName = "fecha_prueba")
        String fechaPrueba,
        @WebParam(name = "hora_prueba", partName = "hora_prueba")
        String horaPrueba,
        @WebParam(name = "minuto_prueba", partName = "minuto_prueba")
        String minutoPrueba,
        @WebParam(name = "resultados_prueba", partName = "resultados_prueba")
        BigInteger resultadosPrueba,
        @WebParam(name = "grado_alcoholemia", partName = "grado_alcoholemia")
        BigInteger gradoAlcoholemia,
        @WebParam(name = "examen_medico", partName = "examen_medico")
        BigInteger examenMedico,
        @WebParam(name = "hora_examen", partName = "hora_examen")
        String horaExamen,
        @WebParam(name = "minuto_examen", partName = "minuto_examen")
        String minutoExamen,
        @WebParam(name = "resultado_examen", partName = "resultado_examen")
        BigInteger resultadoExamen);

    /**
     * Permite ingresar Llegadas de automovil
     * 
     * @param clave
     * @param municipioOrigenRuta
     * @param nitEmpresaTppc
     * @param dptoOrigenRuta
     * @param terId
     * @param pasajerosLlegada
     * @param fechaLlegada
     * @param horaLlegada
     * @param municipioDestinoRuta
     * @param dptoDestinoRuta
     * @param usuario
     * @param minutoLlegada
     * @param placa
     * @param tipoLlegada
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "IngresoLlegadas", action = "urn:SPTCDAwsdl#IngresoLlegadas")
    @WebResult(partName = "return")
    public String ingresoLlegadas(
        @WebParam(name = "usuario", partName = "usuario")
        String usuario,
        @WebParam(name = "clave", partName = "clave")
        String clave,
        @WebParam(name = "ter_id", partName = "ter_id")
        BigInteger terId,
        @WebParam(name = "nit_empresa_tppc", partName = "nit_empresa_tppc")
        String nitEmpresaTppc,
        @WebParam(name = "placa", partName = "placa")
        String placa,
        @WebParam(name = "tipo_llegada", partName = "tipo_llegada")
        BigInteger tipoLlegada,
        @WebParam(name = "fecha_llegada", partName = "fecha_llegada")
        String fechaLlegada,
        @WebParam(name = "hora_llegada", partName = "hora_llegada")
        String horaLlegada,
        @WebParam(name = "minuto_llegada", partName = "minuto_llegada")
        String minutoLlegada,
        @WebParam(name = "pasajeros_llegada", partName = "pasajeros_llegada")
        BigInteger pasajerosLlegada,
        @WebParam(name = "dpto_origen_ruta", partName = "dpto_origen_ruta")
        String dptoOrigenRuta,
        @WebParam(name = "municipio_origen_ruta", partName = "municipio_origen_ruta")
        String municipioOrigenRuta,
        @WebParam(name = "dpto_destino_ruta", partName = "dpto_destino_ruta")
        String dptoDestinoRuta,
        @WebParam(name = "municipio_destino_ruta", partName = "municipio_destino_ruta")
        String municipioDestinoRuta);

}
