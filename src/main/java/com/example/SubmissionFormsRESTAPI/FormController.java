	package com.example.SubmissionFormsRESTAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@Autowired
	CustomerRepo repo;
	@RequestMapping("/")
	public String edureka() {
		return "edureka";
	}
	
	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		return "edureka";
		
	}
	
	@RequestMapping("/getdetails")
	public String getDetails() {
		return "ViewCustomers";
		
	}
	
	
	/*
	@PostMapping("/getdetails")
	public String viewdetails(@RequestParam("cid") String cid, @RequestParam("cname") String cname,
			@RequestParam("cemail") String cemail, ModelMap modelMap) {
		modelMap.put("cid", cid);
		modelMap.put("cname", cname);
		modelMap.put("cemail", cemail);
		return "ViewCustomers";
	}*/
	
	@PostMapping("/getDetails")
	public ModelAndView getDetails(@RequestParam("cid") int cid) {
		ModelAndView mView = new ModelAndView("retrieve");
		Customers customers = repo.findById(cid).orElse(null);
		mView.addObject(customers);
		return mView;
		
	}
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomers() {
		
		return repo.findAll();
		
	}
	
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomers2(@PathVariable("cid") int cid){
		
		return repo.findById(cid);
	
	}
	
	@PostMapping("/customers")
	public Customers getCustomer3(@RequestBody Customers customers) {
		
		repo.save(customers);
		return customers;
		
	}
	
	
	@DeleteMapping("/customers/{cid}")
	public Customers getCustomer4(@PathVariable("cid") int cid) {
		
		Customers cust = repo.getById(cid);
		repo.delete(cust);
		return cust;
	
	}
	
	@PutMapping(path ="/customers",consumes= {"application/json"})
	public Customers getCustomer5(@RequestBody Customers customers) {
		
		repo.save(customers);
		return customers;
		
	}
	
}
