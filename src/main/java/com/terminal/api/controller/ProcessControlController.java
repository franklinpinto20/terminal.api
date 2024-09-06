package com.terminal.api.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terminal.api.client.Principal;
import com.terminal.api.constant.RouteConstant;
import com.terminal.api.entity.EntryDispatchEntity;
import com.terminal.api.exeption.ApiError;
import com.terminal.api.model.ProcessControlRequest;
import com.terminal.api.model.ProcessControlResponse;
import com.terminal.api.service.ProcessControlService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;




/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = RouteConstant.BASE_PATH)
//@RequestMapping(path = "/api")
public class ProcessControlController {

	 @Autowired
	 ProcessControlService processControlService;

	// @Value("${spring.datasource.url}")
	// private String envProperty;
	 
	 private static final Logger logger = LoggerFactory.getLogger(Principal.class);

    //@@PostMapping(path = RouteConstant.MESSAGE_VALUE_RETRIEVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
     //
     @PostMapping(path ="/private/v1/process", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Persiste valores de proceso")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = List.class),
        @ApiResponse(code = 404, message = "Not Found", response = ApiError.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    public ResponseEntity<Void> crear() {
    	 
    	 // Crear un ObjectMapper
         ObjectMapper objectMapper = new ObjectMapper();
         EntryDispatchEntity  entryDispatch= new EntryDispatchEntity(
        		 	"6781721", 
					new BigInteger("15"),
					"800152028", 
					new BigInteger("7"),
					new BigInteger("1"),
					"WLS933"
					,"54",
					"54001000",
					"54", 
					"54001000", 
					"NO ESPECIFICA", 
					"10/08/2024", 
					"5",
					"6", 
					new BigInteger("4"),
					new BigInteger("1"), 
					new BigInteger("1"), 
					null, null, null, 
					new BigInteger("2"), 
					new BigInteger("17700"), 
					new BigInteger("0"));
         String json ="";

         try {
             // Convertir el objeto a JSON
            json = objectMapper.writeValueAsString(entryDispatch);
             System.out.println("JSON Output: " + json);
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         
    	ProcessControlRequest req = new ProcessControlRequest();
    	req.setnConduce(6785227L);
    	req.setRequest(json);
    	req.setResponse("salida2");
    	req.setStatus("OK");
        this.processControlService.create(req);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

   

    // @GetMapping(path = RouteConstant.PROCESS_CONTROL_RETRIEVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    
      @GetMapping(path ="/private/v1/process/retrieve/data", produces = MediaType.APPLICATION_JSON_VALUE)
     @ApiOperation(value = "Get all properties from message value")
     @ApiResponses({
         @ApiResponse(code = 200, message = "Success", response = List.class),
         @ApiResponse(code = 404, message = "Not Found", response = ApiError.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
     })
     public ResponseEntity<List<ProcessControlResponse>> retrieve() {
    	  
    	  logger.trace("Este es un mensaje TRACE");
          logger.debug("Este es un mensaje DEBUG");
       //   logger.info("Este es un mensaje INFO"+envProperty);
          logger.warn("Este es un mensaje WARN");
          logger.error("Este es un mensaje ERROR");
         return ResponseEntity.ok(this.processControlService.getAll());
     }
}
