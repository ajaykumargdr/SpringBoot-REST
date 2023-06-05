package com.akprojects.restdemo.services;

import java.util.List;
import com.akprojects.restdemo.model.CloudVendor;

public interface CloudVendorService {
	
	public String CreateCloudVendor(CloudVendor cloudVendor);
	
	public String updateCloudVendor(CloudVendor cloudVendor);
	
	public String deleteCloudVendor(String cloudVendorId);
	
	public CloudVendor getCloudVendor(String cloudVendorId);
	
	public List<CloudVendor> getAllCloudVendors();
	
}
