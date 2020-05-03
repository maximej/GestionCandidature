package com.GeekJob.concoursDEV;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerConcours {

	@Autowired
	private ConcoursService service;

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
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

		// Conversion de blob au image
		java.sql.Blob b = concoursDemande.getImage_css();
		mav.addObject("concoursImage", b);
		byte barr[];
		try {
			barr = b.getBytes(1,(int)b.length());
			FileOutputStream fout=new FileOutputStream("concours_image.png");
			fout.write(barr);
			fout.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		
		return mav;
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editConcours(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("ModifieConcours");
		concours concoursDemande = service.get(id);
		mav.addObject("concoursDemande", concoursDemande);

		// Conversion de blob au image
		java.sql.Blob blob = concoursDemande.getImage_css();
		mav.addObject("concoursImage", blob);
		// InputStream in;
		// try {
		// in = blob.getBinaryStream();
		// BufferedImage img = ImageIO.read(in);
		// File outputfile = new File("image.jpg");
		// ImageIO.write(img, "jpg", outputfile);
		// mav.addObject("concoursImage", outputfile.getPath());
		// System.out.println(outputfile.getPath());
		// } catch (SQLException | IOException e) {
		// e.printStackTrace();
		// }

		return mav;
	}

	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		concours concours = new concours();
		model.addAttribute("concours", concours);
		return "NouveauConcours";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveconcours(@ModelAttribute("product") concours concours) {
		service.save(concours);
		return "redirect:/";
	}


	@RequestMapping("/delete/{id}")
	public String deleteconcours(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
}
