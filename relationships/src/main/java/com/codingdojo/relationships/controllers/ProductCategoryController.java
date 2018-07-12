package com.codingdojo.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;
import com.codingdojo.relationships.services.ProductCategoryService;

@Controller
public class ProductCategoryController {
	private final ProductCategoryService serv;
	
	public ProductCategoryController(ProductCategoryService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("products/new")
	public String newProd(Model model) {
		model.addAttribute("product", new Product());
		return "productcategory/newprod.jsp";
	}
	@RequestMapping(value="products/new", method=RequestMethod.POST)
	public String createProd(@Valid @ModelAttribute("product") Product prod, BindingResult res) {
		if (res.hasErrors()) return "productcategory/newprod.jsp";
		serv.createProduct(prod);
		return "redirect:/products/new";
	}
	@RequestMapping("products/{id}")
	public String showProd(Model model, @PathVariable("id") Long id) {
		Product p = serv.findProduct(id);
		if (p == null) {
			return "redirect:/products/new";
		}
		List<Category> allcats = serv.allCategories();
		for (int i = 0; i < allcats.size(); i++) {
			if (allcats.get(i).getProducts().contains(p)) allcats.remove(allcats.get(i));
		}
		model.addAttribute("product", p);
		model.addAttribute("allcats", allcats);
		return "productcategory/showprod.jsp";
	}
	@RequestMapping(value="products/{id}", method=RequestMethod.POST)
	public String addCat(Model model, @PathVariable("id") Long id, @RequestParam("cat") Long catid) {
		serv.updateProduct(id, catid);
		return "redirect:/products/"+id;
	}
	
	
	@RequestMapping("categories/new")
	public String newCat(Model model) {
		model.addAttribute("category", new Category());
		return "productcategory/newcat.jsp";
	}
	@RequestMapping(value="categories/new", method=RequestMethod.POST)
	public String createCat(@Valid @ModelAttribute("category") Category cat, BindingResult res) {
		if (res.hasErrors()) return "productcategory/newcat.jsp";
		serv.createCategory(cat);
		return "redirect:/categories/new";
	}
	@RequestMapping("categories/{id}")
	public String showDojo(Model model, @PathVariable("id") Long id) {
		Category c = serv.findCategory(id);
		if (c == null) {
			return "redirect:/categories/new";
		}
		List<Product> allprods = serv.allProducts();
		for (int i = 0; i < allprods.size(); i++) {
			if (allprods.get(i).getCategories().contains(c)) allprods.remove(allprods.get(i));
		}
		model.addAttribute("category", c);
		model.addAttribute("allprods", allprods);
		return "productcategory/showcat.jsp";
	}
	@RequestMapping(value="categories/{id}", method=RequestMethod.POST)
	public String addProd(Model model, @PathVariable("id") Long id, @RequestParam("prod") Long prodid) {
		serv.updateCategory(id, prodid);
		return "redirect:/categories/"+id;
	}
	
}
