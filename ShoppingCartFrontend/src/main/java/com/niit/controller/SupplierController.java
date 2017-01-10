/*package com.niit.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;

	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}

	public void setSupplierDAO(SupplierDAO supplierDAO) {
		this.supplierDAO = supplierDAO;
	}

	@Autowired
	Supplier supplier;

	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public String getSupplierModel(Model model) {
		model.addAttribute("supplierDAO", new Supplier());
		return "add_supplier";
	}

	//-------------------- ADD CATEGORY [ START ] ---------------------------
	
	@RequestMapping(value = "/add_supplier", method = RequestMethod.GET)
	public String getSupplierForm(Model model) {
		model.addAttribute("supplierDAO", new Supplier());
		return "add_supplier";
	}

	@RequestMapping(value = "/add_supplier", method = RequestMethod.POST)
	public String supplierAddAction(@ModelAttribute("supplierDAO") Supplier cotegory, Map<String, Object> map,
			HttpServletRequest request) {
		String supplierName = request.getParameter("name");
		if (!supplierName.isEmpty()) {
			map.put("supplierDAO", new Supplier());
			if (supplierDAO.isSupplier(cotegory)) {
				map.put("message", "This supplier name is already present into database.");
			} else {
				if (supplierDAO.save(cotegory)) {
					map.put("message", "Add supplier successfully!!..");
				} else {
					map.put("message", "Somthing is wrong!!!");
				}
			}
		} else {
			map.put("message", "Please fill up all fields.");
		}
		return "add_supplier";
	}

	//-------------------- ADD CATEGORY [ END ] ---------------------------
	
	@RequestMapping(value = "/view_all_supplier", method = RequestMethod.GET)
	public String getSupplierList(Model model){
		
		model.addAttribute("supplierDAO" , supplierDAO.list());
		return "view_all_supplier";
	}
	
	//---------------------- UPDATE CATEGORY [ START ]-------------------------
	
	@RequestMapping(value="/update_supplier", method=RequestMethod.GET)
	public String getUpdateSupplierForm(Model model, HttpServletRequest request){
		String supplierId = request.getParameter("id");
		String supplierName = request.getParameter("name");
		Supplier supplier = new Supplier();
		 System.out.println("Supplier Id : "+supplierId+" supplier Name : "+supplierName);
		if(supplierId != null  && supplierName != null){
			supplier.setSupplierId(supplierId);
			supplier.setSupplierName(supplierName);
			model.addAttribute("message", "Ready for updation!!..");
		}
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierDAO", supplierDAO.list());
		return "update_supplier";
	}
	
	@RequestMapping(value = "update_supplier", method = RequestMethod.POST)
	public String updateSupplierAction(@ModelAttribute("supplier") Supplier supplier, Map<String,Object> map, 
			                 HttpServletRequest request){
		String supplierId = request.getParameter("id");
		String supplierName = request.getParameter("name");
		if(!supplierId.isEmpty() && !supplierName.isEmpty()){
			supplierDAO.update(supplier);
			supplier.setId("");
			supplier.setName("");
			map.put("message", "Update supplier successfully!!..");
		}else{
			map.put("message", "All fileds are necessary!!..");
		}
		
		map.put("supplier", supplier);
		map.put("supplierDAO", supplierDAO.list());
		return "update_supplier";
	}
	
	//-------------- UPDATE CATEGORY [ END ] ----------------------------------------
	
	//-------------- DELETE CATEGORY [ START ] --------------------------------------
	@RequestMapping(value="/delete_supplier", method = RequestMethod.GET)
	public String getDeleteSupplierForm(Model model, HttpServletRequest request){
		String supplierId = request.getParameter("id");
		String supplierName = request.getParameter("name");
		Supplier supplier = new Supplier();
		 System.out.println("Supplier Id : "+supplierId+" supplier Name : "+supplierName);
		if(supplierId != null  && supplierName != null){
			supplier.setId(supplierId);
			supplier.setName(supplierName);
			model.addAttribute("message", "This record is ready for delete!!..");
		}
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierDAO", supplierDAO.list());
		return "delete_supplier";
	}
	
	@RequestMapping(value="/delete_supplier", method = RequestMethod.POST)
	public String deleteSupplierAction(@ModelAttribute("supplier") Supplier supplier, Map<String,Object> map,
			HttpServletRequest request) {
		String supplierId = request.getParameter("id");
		String supplierName = request.getParameter("name");
		if(!supplierId.isEmpty() && !supplierName.isEmpty()){
			supplierDAO.delete(supplier);
			supplier.setId("");
			supplier.setName("");
			map.put("message", "Delete supplier successfully!!..");
		}else{
			map.put("message", "All fileds are necessary!!..");
		}
		
		map.put("supplier", supplier);
		map.put("supplierDAO", supplierDAO.list());
		return "delete_supplier";
	}
	//-------------- DELETE CATEGORY [ END ] ----------------------------------------
	
	@RequestMapping(value="/staticSupplierList", method=RequestMethod.GET)
	public String getSuppliers(Model model){
		model.addAttribute("supplierList" , supplierDAO.list());
		return "temp";
	}
}
*/