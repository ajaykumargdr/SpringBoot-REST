package com.akprojects.restdemo.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akprojects.restdemo.model.CloudVendor;
import com.akprojects.restdemo.repository.CloudVendorRepository;
import com.akprojects.restdemo.services.CloudVendorService;
import com.akprojects.restdemo.exception.*;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
	
	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		super();
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String CreateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Sucess";
	}
	
	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Sucess";
	}
	
	@Override
	public String deleteCloudVendor(String vendorId) {
		cloudVendorRepository.deleteById(vendorId);
		return "Success";
	}

	@Override
	public CloudVendor getCloudVendor(String vendorId) {
		
		if(cloudVendorRepository.findById(vendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		
		return cloudVendorRepository.findById(vendorId).get();
		
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		return cloudVendorRepository.findAll();
	}

}
