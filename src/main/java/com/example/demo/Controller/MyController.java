package com.example.demo.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.MyRepo;
import com.example.demo.pojo.Laptop;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyController {
	
	@Autowired
	private MyRepo repo;
	
	//MAPPINGS
	@PostMapping("/save")
	public String insert(@RequestBody Laptop laptop) throws ClassNotFoundException, SQLException {
		
		return repo.insert(laptop);
			
	}
	

	@GetMapping("/getv2")
	public List<Laptop> getDatav2() throws ClassNotFoundException, SQLException{
		
		return repo.getDatav2();
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) throws ClassNotFoundException, SQLException {
		
		return repo.delete(id);
		
	}
	
	
	@PutMapping("/update")
	public String update(@RequestBody Laptop laptop) throws ClassNotFoundException, SQLException {
		
		return repo.update(laptop);
		
	}
	
	
	
	 // Search operation
    @GetMapping("/search/{brand}")
    public List<Laptop> searchByBrand(@PathVariable String brand) throws ClassNotFoundException, SQLException {
        return repo.searchByBrand(brand);
    }
	
	
    
    
    @GetMapping("/search1/{price}")
    public List<Laptop> searchByPrice(@PathVariable String price) throws ClassNotFoundException, SQLException {
        return repo.searchByPrice(price);
    }
	
	

    
    
		
	}
	


