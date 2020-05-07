package com.GeekJob.concoursDEV.controller;

import java.awt.print.Printable;
import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.Blob;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.GeekJob.concoursDEV.entity.Adresse;
import com.GeekJob.concoursDEV.entity.Candidat;
import com.GeekJob.concoursDEV.entity.Ville;

import com.GeekJob.concoursDEV.entity.Candidat;

import com.GeekJob.concoursDEV.entity.concours;

import com.GeekJob.concoursDEV.repository.VilleI;
import com.GeekJob.concoursDEV.service.AdresseService;

import com.GeekJob.concoursDEV.service.CandidatService;
import com.GeekJob.concoursDEV.service.ConcoursService;
import com.GeekJob.concoursDEV.service.VilleService;

import ch.qos.logback.core.Context;


@Controller
public class ControllerConcours {

	@Autowired
	private ConcoursService service;

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
		List<concours> listConcours = service.listAll();
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
	public ModelAndView editConcours(@PathVariable(name = "id") int id) {
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
	public String saveconcours(@ModelAttribute("concours") concours concours) {
		service.save(concours);
		return "redirect:/concoursListe";
	}

	@RequestMapping("/delete/{id}")
	public String deleteconcours(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/concoursListe";
	}

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
			// Get the file and save it somewhere
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
