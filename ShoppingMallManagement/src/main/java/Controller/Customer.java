package Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.cg.smms.entities.Customer;
import com.tns.cg.smms.services.CustomerService;

@RestController // This annotation specifies class as a controller class, which will accepts
				// requests from rest clients.
public class Customer {
	@Autowired // It Injects objects of Customerservice implementations into variable
				// "cService".
	CustomerService cService;

	// Retrieve operation (retrieving all customers)
	@GetMapping("/Customers") // used to retrieve resource from server.
	public List<Customer> list() {
		return cService.getAllCustomers();
	}

	// Retrieve Operation (retrieving customer by id)
	@GetMapping("/Customers/{id}")
	public ResponseEntity<Customer> get(@PathVariable Integer id) {
		try {
			Customer c1 = cService.getCustomerById(id);
			return new ResponseEntity<Customer>(c1, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}

	}

	// Create Operation
	@PostMapping("/Customers") // annotation ensures that HTTP POST requests to /customers are mapped to add()
								// method.
	public void add(@RequestBody Customer customer) {
		cService.save(customer);
	}

	// Update Operation
	@PutMapping("/Customers/{id}") // It maps the HTTP PUT requests
	public ResponseEntity<?> update(@RequestBody Customer emp, @PathVariable Integer id) {
		/*
		 * @RequestBody: it is used to bind HTTP request with an object in a method
		 * parameter
		 * 
		 * @PathVariable: it is used to extract the values from the uri.
		 */

		try {
			cService.save(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete Operation // It Maps the HTTP DELETE requests
	@DeleteMapping("/Customers/{id}")
	public void delete(@PathVariable Integer id) {
		cService.delete(id);
	}
}
