package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public Persona encontrarPersona(@PathVariable String id) throws Exception {
		Exception error = new Exception();
		Persona contacto = agenda.recupera(id);

		if (contacto != null) {
			
			return contacto;
			
		} else {
			
			throw error;
		}

	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Página no encontrada")
	@ExceptionHandler()
	public String error(Exception error) {
		
		return error.getMessage();
	}
	
	@RequestMapping(path = "/afegir",method = RequestMethod.POST)
    @ResponseBody
    public void cumplimentarUsuario(@RequestParam String id,String nom,String telefon){
        
		agenda.inserta(id,nom,telefon);

    }
	
	

}
