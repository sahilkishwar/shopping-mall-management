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

import com.tns.cg.smms.entities.MallAdmin;
import com.tns.cg.smms.services.MallAdminService;

@RestController
public class MallAdminController {
	@Autowired
	MallAdminService cService;

//Retrieve operation (retrieving all Admins)
	@GetMapping("/api/Admins") // used to retrieve resource from server.
	public List<MallAdmin> list() {
		return cService.getAllAdmins();
	}

	// Retrieve Operation (retrieving Admin by id)
	@GetMapping("/api/Admins/{id}")
	public ResponseEntity<MallAdmin> get(@PathVariable Integer id) {
		try {
			MallAdmin c1 = cService.getAdminById(id);
			return new ResponseEntity<MallAdmin>(c1, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<MallAdmin>(HttpStatus.NOT_FOUND);
		}

	}

	// Create Operation
	@PostMapping("/api/Admins") // annotation ensures that HTTP POST requests to /Admins are mapped to add()
							// method.
	public void add(@RequestBody MallAdmin admin) {
		cService.save(admin);
	}

	// Update Operation
	@PutMapping("/api/Admins/{id}") // It maps the HTTP PUT requests
	public ResponseEntity<?> update(@RequestBody MallAdmin emp, @PathVariable Integer id) {
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
	@DeleteMapping("/api/Admins/{id}")
	public void delete(@PathVariable Integer id) {
		cService.delete(id);
	}
}
