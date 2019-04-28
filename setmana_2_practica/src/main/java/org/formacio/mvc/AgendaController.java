package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(path = "/")
public class AgendaController {

	@Autowired
	AgendaService agenda;

	@RequestMapping(path = "/nombre")
	@ResponseBody
	public int cantidadContactos() {

		return agenda.nombreContactes();
	}

	@RequestMapping(path = "/telefon")
	@ResponseBody
	public String getTelefono(@RequestParam String id) {

		return agenda.recupera(id).getTelefon();
	}

	@RequestMapping(path = "/contacte/{id}")
	@ResponseBody
	public Persona getPersona(@PathVariable String id) {
		
		if(agenda.recupera(id)!= null) {
			
			return agenda.recupera(id);
		}
		else {
			return null;
		}

	}
	
}
