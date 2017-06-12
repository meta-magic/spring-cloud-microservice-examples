package com.metamagic.desire;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> 
{

	public List<Employee> findByLastname(String lastname);
	
	public List<Employee> findByFirstnameAndLastname(String firstName, String lastName);
	
	public List<Employee> findByAddress_Country(String country);
}
