package tn.essat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.dao.ICategorie;
import tn.essat.dao.IPfe;
import tn.essat.model.Categorie;
import tn.essat.model.Pfe;

@RestController
@CrossOrigin("*")
public class AppRest {
	
	@Autowired
	ICategorie dao_cat;

	@Autowired
	IPfe dao_pfe;

	public void setDao_cat(ICategorie dao_cat) {
		this.dao_cat = dao_cat;
	}

	public void setDao_pfe(IPfe dao_pfe) {
		this.dao_pfe = dao_pfe;
	}
	
	@GetMapping("/pfes")
	public List<Pfe> f() {
		return dao_pfe.findAll();
	}
	@GetMapping("/categories")
	public List<Categorie> ff() {
		return dao_cat.findAll();
	}

	@GetMapping("pfebycat/{id}")
	public List<Pfe> f1(@PathVariable("id") int id) {
		return dao_pfe.getAllPfeByCategorie(id);
	}

	@GetMapping("/pfebytitre/{titre}")
	public List<Pfe> f2(@PathVariable("titre") String titre) {
		return dao_pfe.getAllPfeByTitre(titre);
	}
	
	@PostMapping("/add")
	public Pfe f3(@RequestBody Pfe pfe) {
		return dao_pfe.save(pfe);
	}
	
	@GetMapping("/delete/{id}")
	public void f4(@PathVariable("id") Integer id) {
		dao_pfe.deleteById(id);
	}
}
