package com.rupesh.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rupesh.app.entities.Product;
import com.rupesh.app.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public String showForm(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "view-product";
	}
	
	@GetMapping("/add-product")
	public String addProductForm(Model model) {
		model.addAttribute("product",new Product());
		return "index";
	}
	
	@PostMapping("/save")
	public String processProduct(@ModelAttribute("product") Product product) {
		productService.registerProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{productID}")
	public String deleteProduct(@PathVariable(name = "productID") Integer productID) {
		productService.deleteProduct(productID);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{productId}")
	public String editForm(@PathVariable("productId") Integer productId, Model model) {
		model.addAttribute("product",productService.getProductById(productId));
		return "edit-product";
	}
	
}
