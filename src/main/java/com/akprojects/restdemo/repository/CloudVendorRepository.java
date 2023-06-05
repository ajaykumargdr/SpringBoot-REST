package com.akprojects.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.akprojects.restdemo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}
