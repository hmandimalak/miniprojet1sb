package com.malak.medecins.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.malak.medecins.entities.Medecin;
import com.malak.medecins.service.MedecinService;

@Controller
public class MedecinController {
	@Autowired
	MedecinService medecinService;

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
	public String showCreate() {
		return "createMedecin";
	}

@RequestMapping("/saveMedecin")
public String saveMedecin(@ModelAttribute("Medecin") Medecin medecin,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateDiplome = dateformat.parse(String.valueOf(date));
 medecin.setDateDiplome(dateDiplome);

Medecin saveMedecin = medecinService.saveMedecin(medecin);
String msg ="Medecin enregistré avec Id "+saveMedecin.getIdMedecin();
modelMap.addAttribute("msg", msg);
return "createMedecin";
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
	public String editerMedecin(@RequestParam("id") Long id, ModelMap modelMap) {
		Medecin m = medecinService.getMedecin(id);
		modelMap.addAttribute("Medecin", m);
		return "editerMedecin";
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

}