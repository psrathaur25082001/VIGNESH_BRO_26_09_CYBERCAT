package com.cybercat.user.service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.cybercat.user.entity.AttackLibraryEntity;
import com.cybercat.user.entity.Response;

public interface AttackLibraryService {

	List<AttackLibraryEntity> attackdata();

	Optional<AttackLibraryEntity> attackid(String id);

	AttackLibraryEntity addAttackLibrarydata(AttackLibraryEntity attackques);

	void importCsvData(MultipartFile file);

	void exportToCsv(String filePath);
	int getAttackCount(String attackName);

}

