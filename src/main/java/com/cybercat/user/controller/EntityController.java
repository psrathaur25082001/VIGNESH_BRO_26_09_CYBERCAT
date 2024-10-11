package com.cybercat.user.controller;

import java.io.IOException;
import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cybercat.user.entity.EntityList;
import com.cybercat.user.service.EntityService;

@RestController
@RequestMapping("/entity")
@CrossOrigin
@Tag(name = "Entity Controller", description = "Entity Management")
public class EntityController {

	@Autowired
	EntityService entityService;

	@GetMapping("/count")
	public int getTotalNumberOfClients() {
		return entityService.getTotalNumberOfClients();
	}

    @PostMapping("/createEntity")
    public ResponseEntity<?> createEntity(
            @RequestPart("underwriter") EntityList underwriter,
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        EntityList savedEntity = entityService.createEntity(underwriter, file);
		return ResponseEntity.ok().body(savedEntity);
    }
    
//	@PostMapping("/createEntity")
//	public EntityList createEntity(@RequestBody EntityList underwriter, @RequestPart(value = "logo", required = false) MultipartFile logo) {
//		return entityService.createEntity(underwriter,logo);
//	}
	
	@PostMapping("/editEntity")
	public EntityList editEntity(@RequestBody EntityList underwriter, @RequestParam int id)
			throws Exception {
		return entityService.editEntity(underwriter, id);
	}

	@DeleteMapping("deleteEntity/{id}")
	public EntityList deleteEntity(@PathVariable int id) {
		return entityService.deleteEntity(id);
	}

	@GetMapping("/getEntity")
	public List<EntityList> getEntity() {
		return entityService.getEntity();
	}


}
