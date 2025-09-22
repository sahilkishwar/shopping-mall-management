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

import com.tns.cg.smms.entities.ShopOwner;
import com.tns.cg.smms.services.ShopOwnerService;

@RestController
public class ShopOwnerController {
@Autowired
ShopOwnerService ownerService;

//Retrieve operation (retrieving all Owners)
	@GetMapping("/api/Owners") // used to retrieve resource from server.
	public List<ShopOwner> list() {
		return ownerService.getAllOwners();
	}

	// Retrieve Operation (retrieving Owner by id)
	@GetMapping("/api/Owners/{id}")
	public ResponseEntity<ShopOwner> get(@PathVariable Integer id) {
		try {
			ShopOwner c1 = ownerService.getOwnerById(id);
			return new ResponseEntity<ShopOwner>(c1, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<ShopOwner>(HttpStatus.NOT_FOUND);
		}

	}

	// Create Operation
	@PostMapping("/api/Owners") // annotation ensures that HTTP POST requests to /Owner are mapped to add()
								// method.
	public void add(@RequestBody ShopOwner owner) {
		ownerService.save(owner);
	}

	// Update Operation
	@PutMapping("/api/Owners/{id}") // It maps the HTTP PUT requests
	public ResponseEntity<?> update(@RequestBody ShopOwner emp, @PathVariable Integer id) {
		/*
		 * @RequestBody: it is used to bind HTTP request with an object in a method
		 * parameter
		 * 
		 * @PathVariable: it is used to extract the values from the uri.
		 */

		try {
			ownerService.save(emp);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete Operation // It Maps the HTTP DELETE requests
	@DeleteMapping("/api/Owners/{id}")
	public void delete(@PathVariable Integer id) {
		ownerService.delete(id);
	}
}
