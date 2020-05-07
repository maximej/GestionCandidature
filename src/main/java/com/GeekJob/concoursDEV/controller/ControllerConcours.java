package com.GeekJob.concoursDEV.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.GeekJob.concoursDEV.entity.Adresse;
import com.GeekJob.concoursDEV.entity.Candidat;
import com.GeekJob.concoursDEV.entity.Utilisateur;
import com.GeekJob.concoursDEV.entity.Ville;
import com.GeekJob.concoursDEV.entity.concours;
import com.GeekJob.concoursDEV.service.CandidatService;
import com.GeekJob.concoursDEV.service.ConcoursService;
import com.GeekJob.concoursDEV.service.UtilisateurService;
import com.GeekJob.concoursDEV.service.VilleService;

@Controller
public class ControllerConcours {

	///////////////////////////////////////////////// Maragatham/////////////////////////////////////////////////
	@Autowired
	private ConcoursService service;
	private UtilisateurService serviceUtil;

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}

	@RequestMapping(value = "/logo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage() throws IOException {

		ClassPathResource imgFile = new ClassPathResource("static/Logo.png");
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}

	@RequestMapping("/concoursListe")
	public String viewListeConcours(Model model) {
		List<concours> listConcours = service.listAll();
		model.addAttribute("listConcours", listConcours);
		return "ConcoursListBack";
	}

	@RequestMapping("/concoursListecadidat")
	public String viewListeConcourfront(Model model) {
		List<concours> listConcours = service.listAllCda();
		model.addAttribute("listConcours", listConcours);
		return "ConcoursListFront";
	}

	@RequestMapping("/details/{id}")
	public ModelAndView detailsConcours(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("detailsConcours");
		concours concoursDemande = service.get(id);
		mav.addObject("concoursDemande", concoursDemande);
		return mav;
	}

	@RequestMapping(value = "/image/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getImage(@PathVariable(name = "id") int id) throws IOException {
		concours cImageDemande = service.get(id);
		byte[] imageContent = null;
		try {
			Blob b = cImageDemande.getImage_css();
			imageContent = b.getBytes(1, (int) b.length());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView ModifieConcours(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("ModifieConcours");
		concours concoursDemande = service.get(id);
		mav.addObject("concoursDemande", concoursDemande);
		return mav;
	}

	@RequestMapping("/new")
	public String NewconcoursPage(Model model) {
		concours concours = new concours();
		model.addAttribute("concours", concours);
		return "NouveauConcours";
	}

	@RequestMapping(value = "/save/{imgblob}", method = RequestMethod.POST)
	public String saveconcours(@ModelAttribute("concours") concours concours,
			@PathVariable(name = "imgblob") Blob imgblob) {
		concours.setImage_css((Blob) imgblob);
		service.save(concours);
		return "redirect:/concoursListe";
	}

	@RequestMapping("/delete/{id}")
	public String deleteconcours(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/concoursListe";
	}

	@Controller
	@RequestMapping("/sessionattributes")
	@SessionAttributes("login")
	public class LoginControllerWithSessionAttributes {
	    // ... other methods
	}
	
	@GetMapping("/login")
	public String showForm(
	  Model model,
	  @ModelAttribute("login") Utilisateur user) {
	  
//	    if (user != null) {
//	        model.addAttribute("todo", todos.peekLast());
//	    } else {
//	        model.addAttribute("todo", new TodoItem());
//	    }
	    return "sessionattributesform";
	}
	
	@RequestMapping("/loginCda/{email}/{mdp}")
	public ModelAndView validUser(@PathVariable(name = "email") String email, @PathVariable(name = "mdp") String mdp) {
		ModelAndView mav = new ModelAndView("AccueilCda");
		Utilisateur vUtil = serviceUtil.getValidCda(email, mdp);
		if(vUtil != null) {
			mav.addObject(vUtil);
			return mav;
		}
		mav = new ModelAndView("index");
		mav.addObject("msg", "Email ou Mot de passe Invalide");
		return mav;
	}
	
	@RequestMapping("/loginRcu/{email}/{mdp}")
	public ModelAndView validRecruteur(@PathVariable(name = "email") String email, @PathVariable(name = "mdp") String mdp) {
		ModelAndView mav = new ModelAndView("AccueilRcu");
		Utilisateur vUtil = serviceUtil.getValidCda(email, mdp);
		if(vUtil != null) {
			mav.addObject(vUtil);
			return mav;
		}
		mav = new ModelAndView("index");
		mav.addObject("msg", "Email ou Mot de passe Invalide");
		return mav;
	}

/////////////////////////////////////////////////Maxime/////////////////////////////////////////////////

	@Autowired
	private CandidatService serviceCda;
	private VilleService serviceVilles;


	
	@RequestMapping("/cdaListe")
	public String listeCda(Model model) {
		model.addAttribute("listCda", serviceCda.listAll());
		return "CandidatListBack";
	}
	
	@RequestMapping("/ville")
	public String listeV(Model model) {
		VilleService serviceVilles = new VilleService();
		model.addAttribute("listVilles", serviceVilles.listAll());
		return "VilleListBack";
	}
	
	@RequestMapping("/profil")
	public String vueProfilCandidat() {

		return "profil";
	}

	@RequestMapping("/nouveauCandidat")
	public String NouveauCandidatPage(Model model) {
		Candidat monCda = new Candidat();
		Adresse monAdresse = new Adresse();
		Ville maVille = new Ville();
		monAdresse.setVille(maVille);
		monCda.setMonAdresse(monAdresse);

		model.addAttribute("Candidat", monCda);
		
	//	List<Ville> mesVilles = serviceVilles.listAll();
	 //   model.addAttribute("mesVilles", serviceVilles.listAll());
	    
		return "NouveauCandidat";
	}

	@RequestMapping(value = "/saveCda", method = RequestMethod.POST)
	public String saveCda(@ModelAttribute("Candidat") Candidat monCda) {
		serviceCda.save(monCda);
		return "redirect:/profil";
	}
	
	@RequestMapping("/updateCda/{id}")
	public ModelAndView updateCda(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("NouveauCandidat");
		Candidat monCda = serviceCda.get(id);
		mav.addObject("Candidat", monCda);
		return mav;
	}
	
	@RequestMapping(value = "/uploadCv", method = RequestMethod.POST)
	public String updateCv(@ModelAttribute("Candidat") Candidat monCda) {
		serviceCda.save(monCda);
		return "redirect:/profil";
	}
}
