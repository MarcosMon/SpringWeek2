package org.formacio.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(path = "/personal")
@Controller
public class PersonalController {

	// no toqueu la declaracio de baseDeDades ni el metode getBaseDeDades
	//
	// als metodes que anau afegint, tracteu aquest array com si fos la base de
	// dades
	//
	// per exemple, obtenir la persona amb id 1 sera fer baseDeDades.get(1), etc etc

	private List<String> baseDeDades = new ArrayList<>(Arrays.asList("Joana", "Antonia", "Pere"));

	public List<String> getBaseDeDades() {
		return baseDeDades;
	}

	// Poseu a partir d'aqui els vostre metodes

	@RequestMapping(path = "/info")
	@ResponseBody
	public String info() {

		return "Hi ha " + getBaseDeDades().size() + " persones";

	}

	@RequestMapping("/consulta")
	@ResponseBody
	public String getIDParam(@RequestParam(defaultValue = "0") int id) {

		return this.getBaseDeDades().get(id);

	}

	@RequestMapping("/persona/{id}")
	@ResponseBody
	public String getIDPath(@PathVariable int id) {

		return this.getBaseDeDades().get(id);

	}

	@RequestMapping(value = "/afegir", method = RequestMethod.POST)
	@ResponseBody
	public String getMethodPost(@RequestParam(value = "nom") String nom) {

		this.getBaseDeDades().add(nom);
		
		if (nom != null) {
			
			return "ok";
		}
		return null;

	}

}
