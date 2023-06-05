package com.akprojects.restdemo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.akprojects.restdemo.model.CloudVendor;
import com.akprojects.restdemo.services.CloudVendorService;
import org.springframework.http.ResponseEntity;
import com.akprojects.restdemo.responseHandler.*;

@RestController
@RequestMapping("/cloudvendor") // [D]
public class CloudVendorAPIController { // controllers are also called services
// ###############################################################################################
	
	CloudVendorService cloudVendorService; // local object to storing purpose
	
	public CloudVendorAPIController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}

// ###############################################################################################
	
// get details without any input (vendor's Id, information)
	
//	@GetMapping("/getcloudvendordetails")
//	public CloudVendor getCloudVendorDetails(String vendorId) {
//		return new CloudVendor("C1", "Ajay Kumar", "Gdr Nilgiri", "xxxx");
//	}
	
// With getting vendor(who is vending the cloud) Id
// here we don't need to call the request just by passing the Id
	// we'll be getting the response
	
	// getting data with http request url
	/// mvc will bind both vendorId cz same name (we'll get error if it differ)
	// you can use @PathVariable annotation to extract variable from URL
	// this method is good when you have only single data to receive

// ==============================================================================================
	
	@GetMapping("{vendorId}") 
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable String vendorId) {
		
		// it is just a function
		return ResponseHandler.responseBuilder(
				"Requested Vendor Details are given here", 
				HttpStatus.OK,
				cloudVendorService.getCloudVendor(vendorId)  // local object
				);
	}

// ==============================================================================================
	
// ==============================================================================================

	@GetMapping
	public List<CloudVendor> getAllCloudVendorDetails() {
		
		return this.cloudVendorService.getAllCloudVendors(); // local object
		
	}

// ==============================================================================================
		
		
// ###############################################################################################
	
//@RequestBody annotation is required if you want
//	to receive the data as an object from the request body.

// here instead of getting it through URL we use to HTML body passing the data	
// this method is good when you want to receive an object from client
	
// ==============================================================================================
	
	@PostMapping
	public String createCloudVendor(@RequestBody CloudVendor cloudvendor) {
		
		// storing the data into the db(local)
		
		cloudVendorService.CreateCloudVendor(cloudvendor);
			
		
		return "Cloud Vendor Created Successfully";
	}

// ==============================================================================================
	
	
// ###############################################################################################	

	// rest controller method to get vendorId, VendorObject
	// which we use? @PathVariable / @RequestParam [D]

// ==============================================================================================
		
	@PutMapping()
	public String updateCloudVendor(@RequestParam("vendorId") String vendorId ,@RequestBody CloudVendor cloudVendor) {
		
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud Vendor Updated Successfully";
	}

// ==============================================================================================
		
// ###############################################################################################

// ==============================================================================================
		
	@DeleteMapping
	public String deleteCloudVendor(@RequestParam("vendorId") String vendorId) {
		
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Cloud Vendor Deleted Successfully";
	}

// ==============================================================================================
	
// ###############################################################################################	

}
