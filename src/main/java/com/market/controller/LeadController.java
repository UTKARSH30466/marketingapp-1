package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.market.dto.LeadData;
import com.market.entities.Lead;
import com.market.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	//Handler Methods
	@RequestMapping("/create")
	public String viewCreateLeadPage() {
		return "Create_lead";
	}
	
//	@RequestMapping("/A")
//	public String saveOneLead(@ModelAttribute("lead") Lead lead , ModelMap model) {
//		leadService.saveLead(lead);
//		model.addAttribute("msg","Lead is saved!!");
//		return "Create_lead";
//	}
	
	// Second optation to read form data.
	
//	@RequestMapping("/A")
//	public String saveOneLead(@RequestParam("name") String fname, @RequestParam("lastName") String lName, @RequestParam("emailId") String email, @RequestParam("mobileNumber") String mobile) {
//	Lead l = new Lead();
//	l.setFirstName(fname);
//	l.setLastName(lName);
//	l.setEmail(email);
//	l.setMobile(mobile);
//	
//	leadService.saveLead(l);
//		return "Create_lead";
//	}
	@RequestMapping("/A")
	public String saveOneLead(LeadData data , ModelMap model) {
		
		Lead lead = new Lead();
		lead.setFirstName(data.getFirstName());
		lead.setLastName(data.getLastName());
		lead.setEmail(data.getEmail());
		lead.setMobile(data.getMobile());	
		leadService.saveLead(lead);
		model.addAttribute("msg","Lead is saved!!");
		return "Create_lead";
	}

}
