package com.malak.medecins.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.malak.medecins.entities.Faculte;
import com.malak.medecins.entities.Medecin;
import com.malak.medecins.service.MedecinService;

import jakarta.validation.Valid;

@Controller
public class MedecinController {
	@Autowired
	MedecinService medecinService;

	@GetMapping("/accessDenied")
	public String error() {
		return "accessDenied";
	}
	


	@RequestMapping("/listeMedecins")
	public String listeMedecins(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Page<Medecin> meds = medecinService.getAllMedecinsParPage(page, size);
		modelMap.addAttribute("medecins", meds);
		 modelMap.addAttribute("pages", new int[meds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeMedecins";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Faculte> facs = medecinService.getAllFacultes();
		modelMap.addAttribute("medecin", new Medecin());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("facultes", facs);
		return "formMedecin";
	}

	@RequestMapping("/saveMedecin")
	public String saveMedecin(@Valid Medecin medecin,
			 BindingResult bindingResult,
			 @RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
	{
		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors()) return "formMedecin";
		if (medecin.getIdMedecin()==null) //ajout
			isNew=true;

		medecinService.saveMedecin(medecin);
		if (isNew) //ajout
		{
		Page<Medecin> meds = medecinService.getAllMedecinsParPage(page, size);
		currentPage = meds.getTotalPages()-1;
		}
		else //modif
		currentPage=page;

	//return "formMedecin";
		return ("redirect:/listeMedecins?page="+currentPage+"&size="+size);

	}
	@RequestMapping("/supprimerMedecin")
	public String supprimerMedecin(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		medecinService.deleteMedecinById(id);
		Page<Medecin> meds = medecinService.getAllMedecinsParPage(page, size);
		modelMap.addAttribute("medecins", meds);
		modelMap.addAttribute("pages", new int[meds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeMedecins";
	}

	@RequestMapping("/modifierMedecin")
	public String editerMedecin(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		List<Faculte> facs = medecinService.getAllFacultes();
		Medecin m = medecinService.getMedecin(id);
		modelMap.addAttribute("medecin", m);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("facultes", facs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formMedecin";
	}

	@RequestMapping("/updateMedecin")
	public String updateMedecin(@ModelAttribute("Medecin") Medecin medecin, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateDiplome = dateformat.parse(String.valueOf(date));
		medecin.setDateDiplome(dateDiplome);

		medecinService.updateMedecin(medecin);
		List<Medecin> meds = medecinService.getAllMedecins();
		modelMap.addAttribute("Medecins", meds);
		return "listeMedecins";
	}
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}

}