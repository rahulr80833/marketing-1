package com.marketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;



@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	//Handler Methods
	@RequestMapping("/createLead")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute ("lead") Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		model.addAttribute("msg","Lead is saved !!");
	
		return "create_lead";
		
	}
	@RequestMapping("/listall")
	public String listAllLeads(ModelMap model ) {
		 List<Lead> leads = leadService.listLeads();
		 model.addAttribute("leads",leads);
		 return "lead_search_result";
	}
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id, ModelMap model) {
		
		leadService.deleteLeadById(id);
		
		List<Lead> leads = leadService.listLeads();
		 model.addAttribute("leads",leads);
		 return "lead_search_result";
	}
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead",lead);
		 return "update_lead";
	} 
	
	@RequestMapping("/updateLead")
	public String updateOneLeadData(LeadData data, ModelMap model ) {
		
		Lead lead = new Lead();
		lead.setId(data.getId());
		lead.setFirstName(data.getFirstName());
		lead.setLastName(data.getLastName());
		lead.setEmail(data.getEmail());
		lead.setMobile(data.getMobile());
		
		leadService.saveLead(lead);
		
		List<Lead> leads = leadService.listLeads();
		 model.addAttribute("leads",leads);
		 return "lead_search_result";
		
	}
	
	/////**** Below two method will be used if entity class is not available*****////
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("name") String fName,@RequestParam("lastName") String lName,@RequestParam("emailId") String email,@RequestParam("mobileNumber") long mobile) {
////		System.out.println(fName);
////		System.out.println(lName);
////		System.out.println(email);
////		System.out.println(mobile);
//		
//		Lead l = new Lead();
//		l.setFirstName(fName);
//		l.setLastName(lName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		
//		leadService.saveLead(l);
//		
//		return "create_lead";
		
//	}
	
   //DTO - Data Transfer Object 	
	
//	@RequestMapping("/saveLead")
//		public String saveOneLead(LeadData data, ModelMap model) {
////			System.out.println(data.getFirstName());
////			System.out.println(data.getLastName());
////			System.out.println(data.getEmail());
////			System.out.println(data.getMobile());
//		
//		// ---NOW FOR SAVING DATA CODE IS HERE ---
//		
//		Lead lead = new Lead();
//		lead.setFirstName(data.getFirstName());
//	    lead.setLastName(data.getLastName());
//	    lead.setEmail(data.getEmail());
//	    lead.setMobile(data.getMobile());
//	    
//	    leadService.saveLead(lead);
//		
//		
//		model.addAttribute("msg","Lead is saved !!");
//		
//			return "create_lead";
//			
//		}

}
