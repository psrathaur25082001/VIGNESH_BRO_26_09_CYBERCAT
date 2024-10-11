package com.cybercat.user.serviceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cybercat.user.entity.AttackLibraryEntity;
import com.cybercat.user.entity.StrategicTriggerQuestionEntity;
import com.cybercat.user.repository.AttackLibraryRepo;
import com.cybercat.user.repository.StrategicTriggerQuestionRepo;
import com.cybercat.user.service.AttackLibraryService;

@Service
public class AttackLibraryServiceImpl implements AttackLibraryService{

	@Autowired AttackLibraryRepo attackLibraryRepo;
	
	@Autowired StrategicTriggerQuestionRepo strategicTriggerQuestionRepo;
	
	public List<AttackLibraryEntity> attackdata() {
		return attackLibraryRepo.findAll();
}

	@Override
	public Optional<AttackLibraryEntity> attackid(String id) {
		return null;
		//return attackLibraryRepo.findById(id);
	}	
	

	@Override
	public AttackLibraryEntity addAttackLibrarydata(AttackLibraryEntity attackques) {
		StrategicTriggerQuestionEntity trigger = strategicTriggerQuestionRepo.findByName("AddAttackLibrary");
		int count = trigger.getCount() + 1;
		attackques.setId(trigger.getCount() + 1);		
		System.out.print(attackques);
		attackLibraryRepo.save(attackques);
		trigger.setCount(count);
		strategicTriggerQuestionRepo.save(trigger);
		return attackques;
	}
	@Override
	public void importCsvData(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<AttackLibraryEntity> csvToBean = new CsvToBeanBuilder<AttackLibraryEntity>(reader)
                    .withType(AttackLibraryEntity.class)
                    .build();

            List<AttackLibraryEntity> attackLibraryEntities = csvToBean.parse();
            
            int maxId = findMaxId();

          
            for (int i = 0; i < attackLibraryEntities.size(); i++) {
                AttackLibraryEntity entity = attackLibraryEntities.get(i);
                entity.setId(maxId + i + 1); 
            }
            
            attackLibraryRepo.saveAll(attackLibraryEntities);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	public void exportToCsv(String filePath) {
        List<AttackLibraryEntity> entities = attackLibraryRepo.findAll();
        
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Write CSV header
            String[] header = { "id", "date", "author", "target", "description", "type", "industrytarget", "industry", "attack", "country", "criticality" };
            writer.writeNext(header);

            // Write data
            for (AttackLibraryEntity entity : entities) {
                String[] data = {
                    String.valueOf(entity.getId()),
                    entity.getDate(),
                    entity.getAuthor(),
                    entity.getTarget(),
                    entity.getDescription(),
                    entity.getType(),
                    entity.getIndustrytarget(),
                    entity.getIndustry(),
                    entity.getAttack(),
                    entity.getCountry(),
                    entity.getCriticality()
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception properly (e.g., log it or rethrow it)
        }
    }

    @Override
    public int getAttackCount(String attackName) {
        return attackLibraryRepo.findByAttack(attackName).size();
    }

    public Integer findMaxId() {
        return attackLibraryRepo.findAll(Sort.by(Sort.Order.desc("id")))
                .stream()
                .findFirst()
                .map(AttackLibraryEntity::getId)
                .orElse(0); 
    }
	
	 
}
