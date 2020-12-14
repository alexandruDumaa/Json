package com.cmc.hibernate.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.objetos.ObjOrigen;
import com.cmc.hibernate.modelo.Gestion_DAO;


@RestController
@Controller
@RequestMapping("/historico/v0/")
public class Controlador {

	
	// ******************* MÉTODOS PROPIOS *******************
	@Autowired
	private Gestion_DAO gestion_datos;
	
	
	
	@GetMapping("/datosHistoricos/")
    public ResponseEntity<Boolean> datosHistoricos(@Valid @RequestBody ObjOrigen objeto) {
        return ResponseEntity.ok().body(gestion_datos.cargarHistorico(objeto));
    }
	
	
	
	
	
}
