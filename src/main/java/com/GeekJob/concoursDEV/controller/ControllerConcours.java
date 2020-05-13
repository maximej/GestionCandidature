package com.GeekJob.concoursDEV.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import com.GeekJob.concoursDEV.entity.Candidat;
import com.GeekJob.concoursDEV.entity.Recruteur;
import com.GeekJob.concoursDEV.entity.Utilisateur;
import com.GeekJob.concoursDEV.entity.concours;
import com.GeekJob.concoursDEV.service.CandidatService;
import com.GeekJob.concoursDEV.service.ConcoursService;
import com.GeekJob.concoursDEV.service.RecruteurService;
import com.GeekJob.concoursDEV.service.UtilisateurService;
import com.GeekJob.concoursDEV.service.VilleService;

@Controller
public class ControllerConcours {

	///////////////////////////////////////////////// Maragatham/////////////////////////////////////////////////
	@Autowired
	private ConcoursService service;

	@Autowired
	private UtilisateurService serviceUtil;

	@Autowired
	private RecruteurService serviceRcu;

	@RequestMapping(value = "/logo", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage() throws IOException {

		ClassPathResource imgFile = new ClassPathResource("static/Logo.png");
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		return "index";
	}

/////////Login check methods/////////
	@RequestMapping(value = "/loginCda", method = RequestMethod.POST)
	public String validUser(@RequestParam String email, @RequestParam String motdepasse, HttpSession session,
			Model model) {
		if (session.getAttribute("CdaLogin") != null) {
			session.removeAttribute("CdaLogin");
		}
		if (session.getAttribute("RcuLogin") != null) {
			session.removeAttribute("RcuLogin");
		}
		Utilisateur vUtil = serviceUtil.getValidCda(email, motdepasse);
		if (vUtil != null) {
			session.setAttribute("CdaLogin", vUtil);
			return "redirect:/concoursListecadidat";
		}
		if (vUtil == null) {
			model.addAttribute("msg", "Invalide");
		}
		return "index";
	}

	@RequestMapping(value = "/loginRcu", method = RequestMethod.POST)
	public String validRcu(@RequestParam String email, @RequestParam String motdepasse, HttpSession session,
			Model model) {
		if (session.getAttribute("CdaLogin") != null) {
			session.removeAttribute("CdaLogin");
		}
		if (session.getAttribute("RcuLogin") != null) {
			session.removeAttribute("RcuLogin");
		}
		Utilisateur vUtil = serviceUtil.getValidRcu(email, motdepasse);
		if (vUtil != null) {
			session.setAttribute("RcuLogin", vUtil);
			return "redirect:/concoursListe";
		}
		model.addAttribute("msg", "Invalide");
		return "index";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		if (session.getAttribute("CdaLogin") != null) {
			session.removeAttribute("CdaLogin");
		}
		if (session.getAttribute("RcuLogin") != null) {
			session.removeAttribute("RcuLogin");
		}
		return "index";
	}

/////////Login check methods/////////

/////////Concours methods/////////
	@RequestMapping("/concoursListe")
	public String viewListeConcours(Model model) {
		List<concours> listConcours = service.listAll();
		model.addAttribute("listConcours", listConcours);
		return "ConcoursListBack";
	}

	@RequestMapping("/sortBydate")
	public String sortBydate(Model model) {
		List<concours> listConcours = service.sortBydate();
		model.addAttribute("listConcours", listConcours);
		return "ConcoursListBack";
	}

	@RequestMapping("/sortByStatut")
	public String sortByStatut(Model model) {
		List<concours> listConcours = service.sortByStatut();
		model.addAttribute("listConcours", listConcours);
		return "ConcoursListBack";
	}
	
	@RequestMapping(value = "/rechercheccs")
	public String rechercheccs(@RequestParam("nom") String nom, Model model) {
		List<concours> searchResult = service.findByNom(nom);
		model.addAttribute("listConcours", searchResult);
		return "ConcoursListFront";
	}
			

	@RequestMapping("/concoursListeActive")
	public String viewListeConcourActive(Model model) {
		List<concours> listConcours = service.listAllCda();
		model.addAttribute("listConcours", listConcours);
		return "ConcoursListBack";
	}

	@RequestMapping("/concoursListecadidat")
	public String viewListeConcourfront(Model model) {
		List<concours> listConcours = service.listAllCda();
		model.addAttribute("listConcours", listConcours);
		return "ConcoursListFront";
	}

	@RequestMapping("/concoursListeCdaSortByNom")
	public String viewListeConcourfrontSortByNom(Model model) {
		List<concours> listConcours = service.listAllCdaNom();
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveconcours(@ModelAttribute("concours") concours concours,
			@RequestParam("imgfile") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (!file.isEmpty()) {
			try {
				byte[] imageInByte = file.getBytes();
				concours.setImage_css(new javax.sql.rowset.serial.SerialBlob(imageInByte));
			} catch (IOException | SQLException e) {
				e.printStackTrace();
			}
		}else if(service.get(concours.getCcs_ID()) != null) {
			concours.setImage_css(service.get(concours.getCcs_ID()).getImage_css());
		}
		service.save(concours);
		return "redirect:/concoursListe";
	}

	@RequestMapping("/delete/{id}")
	public String deleteconcours(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/concoursListe";
	}
	
	@RequestMapping("/deleteperm/{id}")
	public String deletePermCcs(@PathVariable(name = "id") int id) {
		service.deletePerm(id);
		return "redirect:/concoursListe";
	}

/////////Concours methods/////////

///////// Recruteur/////////
	@RequestMapping("/nouveauRcu")
	public String newRcu(Model model) {
		Recruteur recruteur = new Recruteur();
		model.addAttribute("recruteur", recruteur);
		return "NouveauRecruteur";
	}

	@RequestMapping("/rcuListe")
	public String viewListeRcuByID(Model model) {
		List<Recruteur> listRcu = serviceRcu.listByID();
		model.addAttribute("listRcu", listRcu);
		return "RecruteursListBack";
	}

	@RequestMapping("/rcuListeByEmail")
	public String viewListeRcuByEmail(Model model) {
		List<Recruteur> listRcu = serviceRcu.listByEmail();
		model.addAttribute("listRcu", listRcu);
		return "RecruteursListBack";
	}

	@RequestMapping("/rcuListeByStatut")
	public String viewListeRcuByStatut(Model model) {
		List<Recruteur> listRcu = serviceRcu.listByStatut();
		model.addAttribute("listRcu", listRcu);
		return "RecruteursListBack";
	}

	@RequestMapping("/editRcu/{id}")
	public ModelAndView ModifieRecruteur(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("ModifieRecruteur");
		Recruteur recruteurDemande = serviceRcu.get(id);
		mav.addObject("recruteurDemande", recruteurDemande);
		return mav;
	}

	@RequestMapping(value = "/saveRcu", method = RequestMethod.POST)
	public String saveRcu(@ModelAttribute("recruteur") Recruteur recruteur) {
		// Check existing user
		if (serviceUtil.findByEmailIgnoreCase(recruteur.getUtilRcu().getEmail()) == null) {
			recruteur.getUtilRcu().setStatut_util(recruteur.getStatutrcu());
			Utilisateur u = serviceUtil.save(recruteur.getUtilRcu());
			recruteur.setUtilisateurId(u.getUtilisateurId());
			serviceRcu.save(recruteur);
		} else {
			serviceUtil.findByEmailIgnoreCase(recruteur.getUtilRcu().getEmail())
					.setStatut_util(recruteur.getStatutrcu());
			serviceRcu.findByRcuID(recruteur.getRcuID()).setStatutrcu(recruteur.getStatutrcu());
			serviceUtil.findByEmailIgnoreCase(recruteur.getUtilRcu().getEmail())
					.setMotdepasse(recruteur.getUtilRcu().getMotdepasse());
			serviceUtil.findByEmailIgnoreCase(recruteur.getUtilRcu().getEmail())
					.setStatut_util(recruteur.getStatutrcu());
		}
		return "redirect:/rcuListe";
	}

	@RequestMapping("/deleteRcu/{id}")
	public String deleterecruteur(@PathVariable(name = "id") int id) {
		serviceRcu.delete(id);
		return "redirect:/rcuListe";
	}
///////// Recruteur/////////

///////////////////////////////////////////////// Maxime/////////////////////////////////////////////////

	@Autowired
	private CandidatService serviceCda;

	@Autowired
	private VilleService serviceVilles;

// Save the uploaded file to this folder
	@Value("${upload.path}")
	private String img_path;
	@Value("${application.folder}")
	private String appli_path;

	@RequestMapping("/cdaListe")
	public String listeCda(Model model) {
		model.addAttribute("listCda", serviceCda.listAll());
		return "CandidatListBack";
	}

	@RequestMapping("/profil")
	public String vueProfilCandidat() {

		return "profil";
	}

	@RequestMapping("/nouveauCandidat")
	public String NouveauCandidatPage() {
		Candidat monCda = new Candidat();
		monCda.setStatut_cda(201);
		serviceCda.save(monCda);
		return "redirect:/infoCda/" + monCda.getCda_ID();
	}

	@RequestMapping("/infoCda/{id}")
	public String updateCda(@PathVariable(name = "id") int id, Model model) {
		Candidat monCda = serviceCda.get(id);
		model.addAttribute("Candidat", monCda);
		model.addAttribute("mesVilles", serviceVilles.listAll());
		return "FicheCandidat";
	}

	@RequestMapping(value = "/saveCda", method = RequestMethod.POST)
	public String saveCda(@ModelAttribute("Candidat") Candidat monCda) {
		System.out.println("saveCda id: " + monCda.getCda_ID());
		serviceCda.save(monCda);
		return "redirect:/profil";
	}

	@RequestMapping("/deleteAccount/{id}")
	public String deleteCda(@PathVariable(name = "id") int id) {
		Candidat monCda = serviceCda.get(id);
		monCda.setStatut_cda(203);
		serviceCda.save(monCda);
		return "redirect:/profil";
	}

	@PostMapping("/uploadCv") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}

		try {

			byte[] bytes = file.getBytes();
			ClassPathResource imgFile = new ClassPathResource("static/Logo.png");
			DateFormat dateFormat = new SimpleDateFormat("yy_MM_dd_HH_mm_ss");

			int index = file.getOriginalFilename().lastIndexOf(".");
			String extention = file.getOriginalFilename().substring(index, file.getOriginalFilename().length())
					.toLowerCase();

			String fileNameString = dateFormat.format(new Date()) + extention;

			Path path = Paths.get(appli_path + img_path + fileNameString);
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {

		return "profil";
	}
}
