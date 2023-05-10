package com.gl.inventorymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.inventorymanagement.entity.Customer;
import com.gl.inventorymanagement.entity.User;
import com.gl.inventorymanagement.service.CustomerService;
import com.gl.inventorymanagement.service.SellerService;
import com.gl.inventorymanagement.service.UserService;



@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	SellerService sellerService;
	
	@Autowired
	CustomerService customerService;
	@PostMapping("/register/user")
	//@PreAuthorize("ROLE_ADMIN")
	public ResponseEntity<String> register( @RequestBody User user) {
		//return new ResponseEntity<Admin>(adminService.registerAdmin(admin),HttpStatus.CREATED);
		userService.registerUser(user);
		return new ResponseEntity<String>("Customer Registered with User Id :" + user.getUserId(),
				HttpStatus.ACCEPTED);
	}

//	@PostMapping("/add/seller")
//	public ResponseEntity<String> addSeller(@RequestBody Seller seller) {
//		// return new ResponseEntity<Customer>(customerService.addCustomer(customer),
//		// HttpStatus.CREATED);
//		sellerService.addSeller(seller);
//		return new ResponseEntity<String>("Seller Registered with Seller Id :" + seller.getSellerId(),
//				HttpStatus.ACCEPTED);
//	}
	@PostMapping("/register/customer")
	public ResponseEntity<String> registerCustomer( @RequestBody Customer customer) {
		//return new ResponseEntity<Admin>(adminService.registerAdmin(admin),HttpStatus.CREATED);
		customerService.addCustomer(customer);
		return new ResponseEntity<String>("Customer Registered with User Id :" + customer.getId(),
				HttpStatus.ACCEPTED);
	}
	
//	@GetMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String name, @RequestParam String password) {
//        // Check if the user is registered by querying the database
//		
//        User user1 = userService.authenticate(name,password);
//        System.out.println(name);
//        System.out.println(password);
//        
//       
//        if (user1 == null) {
//            //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong credentials.Please try again!!!");
//        	return new ResponseEntity<String>("Wrong credentials.Please try again!!!" ,
//    				HttpStatus.ACCEPTED);
//        }
//        
//        return ResponseEntity.ok(" Admin Login successful");
//       
//    }
}


