package com.terminal.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terminal.api.exeption.ApiError;
import com.terminal.api.model.RolResponse;
import com.terminal.api.service.RolService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;




/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
@RestController
@RequiredArgsConstructor
//@RequestMapping(path = RouteConstant.BASE_PATH)
@RequestMapping(path = "/api")
public class CorreoController {

	 @Autowired
     RolService rolService;

	 @GetMapping(path ="/enviarmail", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<String> retrieve() {
	        return new ResponseEntity<>("Correo Enviado",HttpStatus.OK);
	    }

	   
	}
