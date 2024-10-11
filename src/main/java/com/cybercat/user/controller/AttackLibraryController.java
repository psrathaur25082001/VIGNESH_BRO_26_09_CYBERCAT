package com.cybercat.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cybercat.user.entity.AttackLibraryEntity;
import com.cybercat.user.entity.Response;
import com.cybercat.user.service.AttackLibraryService;

@RestController
@RequestMapping("/attack")
@CrossOrigin
public class AttackLibraryController {

	@Autowired
	AttackLibraryService attackLibraryService;

	@GetMapping("/getAllData")
	public List<AttackLibraryEntity> attackdata() {
		return attackLibraryService.attackdata();
	}

	@GetMapping("/getByid")
	public Optional<AttackLibraryEntity> attackid(@RequestParam String id) {
		return attackLibraryService.attackid(id);
	}

	@PostMapping("/addAttackData")
	public Response addAttackLibrarydata(@RequestBody AttackLibraryEntity attackques) {
		AttackLibraryEntity attackLibrary = attackLibraryService.addAttackLibrarydata(attackques);
		Response res = new Response();
		res.setMessage("Attack Data Added Successfully!");
		res.setResponseCode(200);
		res.setResponsedata(attackLibrary);
		res.setStatus(true);
		return res;
	}
	
	@PostMapping("/import-csv")
    public String importCsv(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        }
        
        try {
        	attackLibraryService.importCsvData(file); // Pass MultipartFile directly
            return "CSV data imported successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while importing CSV data";
        }
    }
	
    @GetMapping("/export-csv")
    public String exportCsv() {
        String filePath = "home/file.csv"; // Specify the path where you want to save the CSV file
        attackLibraryService.exportToCsv(filePath);

        // Return a response indicating the export was successful
        return "Export completed: " + filePath;
    }
}
