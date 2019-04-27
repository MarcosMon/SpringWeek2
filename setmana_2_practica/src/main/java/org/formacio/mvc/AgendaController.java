package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
