package com.metamagic.desire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	//http://localhost:8080/employee/save
	@RequestMapping(value="/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void save()
	{
		this.deteleAll();
		Employee emp = new Employee("John", "Doe", new Address("India", "Lane 26"));
		Employee emp2 = new Employee("John-1", "Doe", new Address("USA", "Lane 26"));
		
		employeeRepo.save(emp);
		employeeRepo.save(emp2);

	}
	
	//http://localhost:8080/employee/findall
	@RequestMapping(value="/findall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Employee>> findAll()
	{
		Iterable<Employee> employees = employeeRepo.findAll();
		return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
	}
	
	//http://localhost:8080/employee/lastname/Doe
	@RequestMapping(value="/lastname/{lastname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Employee>> findByLastName(@PathVariable("lastname") String lastName){
		Iterable<Employee> employees = employeeRepo.findByLastname(lastName);
	 
		return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
	}
	
	//http://localhost:8080/employee/first/John/last/Doe
	@RequestMapping(value="/first/{firstname}/last/{lastname}")
	public ResponseEntity<List<Employee>> findByFirstNameAndLastName(@PathVariable("firstname") String firstname
																	,@PathVariable("lastname") String lastname)
	{
		List<Employee> employees = employeeRepo.findByFirstnameAndLastname(firstname, lastname);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	//http://localhost:8080/employee/country/India
	@RequestMapping(value="/country/{country}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Employee>> findByCountry(@PathVariable("country") String country){
		
		System.out.println(country);
		
		Iterable<Employee> employees = employeeRepo.findByAddress_Country(country);
	 
		return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
	}
	
	
	private void deteleAll(){
		Iterable<Employee> deleteData = employeeRepo.findAll();
		for (Employee employee : deleteData) {
			System.out.println(employee);
			employeeRepo.delete(employee);	
		}
		
	}
}
