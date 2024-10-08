package com.terminal.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class RolController {

	 @Autowired
     RolService rolService;



    //@GetMapping(path = RouteConstant.MESSAGE_VALUE_RETRIEVE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
     //
     @GetMapping(path ="/private/v1/rol/retrieve/data", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all properties from message value")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = List.class),
        @ApiResponse(code = 404, message = "Not Found", response = ApiError.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ApiError.class)
    })
    public ResponseEntity<List<RolResponse>> retrieve() {
        return ResponseEntity.ok(this.rolService.retrieve());
    }

   
}
