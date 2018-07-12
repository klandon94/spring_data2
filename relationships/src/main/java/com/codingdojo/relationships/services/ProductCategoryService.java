package com.codingdojo.relationships.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Category;
import com.codingdojo.relationships.models.Product;
import com.codingdojo.relationships.repositories.CategoryRepository;
import com.codingdojo.relationships.repositories.ProductRepository;


@Service
public class ProductCategoryService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	
	public ProductCategoryService(ProductRepository productRepo, CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	
	public ArrayList<Product> allProducts(){
		return productRepo.findAll();
	}
	public Product createProduct(Product d) {
		return productRepo.save(d);
	}
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else return null;
	}
	public void updateProduct(Long id, Long cid) {
		Optional<Product> prod = productRepo.findById(id);
		if (prod.isPresent()) {
			Optional<Category> cat = categoryRepo.findById(cid);
			List<Category> cats = prod.get().getCategories();
			cats.add(cat.get());
			prod.get().setCategories(cats);
			productRepo.save(prod.get());			
		}
	}
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	public ArrayList<Category> allCategories(){
		return categoryRepo.findAll();
	}
	public Category createCategory(Category n) {
		return categoryRepo.save(n);
	}
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else return null;
	}
	public void updateCategory(Long id, Long pid) {
		Optional<Category> cat = categoryRepo.findById(id);
		if (cat.isPresent()) {
			Optional<Product> prod = productRepo.findById(pid);
			List<Product> prods = cat.get().getProducts();
			prods.add(prod.get());
			cat.get().setProducts(prods);
			categoryRepo.save(cat.get());			
		}
	}
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
	
}
