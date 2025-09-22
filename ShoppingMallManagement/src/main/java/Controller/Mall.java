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

import com.tns.cg.smms.entities.Mall;
import com.tns.cg.smms.services.MallService;

@RestController
public class MallController {
@Autowired
MallService mService;

//Retrieve operation (retrieving all malls)
	@GetMapping("/api/Malls") // used to retrieve resource from server.
	public List<Mall> list() {
		return mService.getAll();
	}

	// Retrieve Operation (retrieving mall by id)
	@GetMapping("/api/Malls/{id}")
	public ResponseEntity<Mall> get(@PathVariable Integer id) {
		try {
			Mall c1 = mService.getMallById(id);
			return new ResponseEntity<Mall>(c1, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Mall>(HttpStatus.NOT_FOUND);
		}

	}

	// Create Operation
	@PostMapping("/api/Malls") // annotation ensures that HTTP POST requests to /Malls are mapped to add()
								// method.
	public void add(@RequestBody Mall mall) {
		mService.save(mall);
	}

	// Update Operation
	@PutMapping("/api/Malls/{id}") // It maps the HTTP PUT requests
	public ResponseEntity<?> update(@RequestBody Mall emp, @PathVariable Integer id) {
		/*
		 * @RequestBody: it is used to bind HTTP request with an object in a method
		 * parameter
		 * 
		 * @PathVariable: it is used to extract the values from the uri.
		 */

		try {
			mService.save(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete Operation // It Maps the HTTP DELETE requests
	@DeleteMapping("/api/Malls/{id}")
	public void delete(@PathVariable Integer id) {
		mService.delete(id);
	}

}
