package com.cybercat.user.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.cybercat.user.entity.PolicySumInsured;
import com.cybercat.user.exception.UserNotFoundException;
import com.cybercat.user.helper.TreatyCapacity;
import com.cybercat.user.payload.PolicyTreatyPercentageDto;
import com.cybercat.user.payload.SolvencyRiskDto;
import com.cybercat.user.service.PolicySumInsuredService;
import com.cybercat.user.service.PremiumChargedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybercat.user.entity.TriggerEntity;
import com.cybercat.user.entity.EntityList;
import com.cybercat.user.entity.InsuranceEntity;
import com.cybercat.user.repository.EntityRepo;
import com.cybercat.user.repository.InsuranceRepo;
import com.cybercat.user.repository.TriggerRepo;
import com.cybercat.user.service.EntityService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EntityServiceImpl implements EntityService {

	@Autowired
	EntityRepo entityRepo;
	
	@Autowired
    InsuranceRepo insRepo;

	@Autowired
	TriggerRepo triggerRepo;
	@Autowired
	private PolicySumInsuredService policySumInsuredService;
	@Autowired
	private PremiumChargedService premiumChargedService;

//	public EntityComponentEntity getTotalNumberOfClients() {
//		TriggerEntity trigger = triggerRepo.findByName("underwriter");
//		int count = (int) analysisComponentRepo.count();
//		EntityComponentEntity result = new EntityComponentEntity();
//		result.setId(count);
//		triggerRepo.save(trigger);
//		return result;
//	}

	public int getTotalNumberOfClients() {
		return (int) entityRepo.count();
	}

//	public EntityList createEntity(EntityList underwriter) {
//		TriggerEntity trigger = triggerRepo.findByName("analysis");
//		underwriter.setId(trigger.getCount() + 1);
//		underwriter.setInitiatedDate(LocalDate.now().toString());
//		String formattedTime = formatLocalTime(LocalTime.now());
//		underwriter.setLocaltime(formattedTime);
//		entityRepo.save(underwriter);
//		trigger.setCount(trigger.getCount() + 1);
//		triggerRepo.save(trigger);
//		return underwriter;
//	}
	
//	private static final String BASE_DIR = "F:\\VIGNESH_BRO_31_05_CYBERCAT\\src\\main\\resources\\static\\uploads\\";
	
	private static final String BASE_DIR = "F:\\VIGNESH_BRO_31_05_CYBERCAT\\src\\main\\resources\\static\\uploads\\";
	
	 public EntityList createEntity(EntityList underwriter, MultipartFile file) throws IOException {
	        TriggerEntity trigger = triggerRepo.findByName("entity");
	        underwriter.setId(trigger.getCount() + 1);
	        underwriter.setInitiatedDate(LocalDate.now().toString());
	        String formattedTime = formatLocalTime(LocalTime.now());
	        underwriter.setLocaltime(formattedTime);
	        entityRepo.save(underwriter);
	        trigger.setCount(trigger.getCount() + 1);
	        triggerRepo.save(trigger);

	        int clientId = underwriter.getId();  

	        String clientDirectoryPath = BASE_DIR + clientId + "\\";
	        File directory = new File(clientDirectoryPath);
	        if (!directory.exists()) {
	            if (directory.mkdirs()) {
	                System.out.println("Directory created: " + clientDirectoryPath);
	            } else {
	                throw new IOException("Failed to create directory: " + clientDirectoryPath);
	            }
	        }

	        if (!directory.exists()) {
	            throw new IOException("Directory does not exist after creation attempt: " + clientDirectoryPath);
	        }

	        String originalFilename = file.getOriginalFilename();
	        if (originalFilename != null) {
	            File destinationFile = new File(clientDirectoryPath + "\\" + originalFilename);
	            try {
	                file.transferTo(destinationFile);
	                System.out.println("File uploaded successfully to: " + destinationFile.getAbsolutePath());
	                underwriter.setCompanyLogo(destinationFile.getAbsolutePath());
	            } catch (IOException e) {
	                System.err.println("File upload failed: " + e.getMessage());
	                throw new IOException("File upload failed", e);
	            }
	        } else {
	            throw new IllegalArgumentException("No file uploaded");
	        }

	        return underwriter;
	    }




	public EntityList editEntity(EntityList underwriter, int id) throws Exception {
		EntityList underwriter1 = entityRepo.findById(id).get();		
		InsuranceEntity insuranceEntity = insRepo.findById(id).orElseThrow();
		
		underwriter1.setCompanyName(underwriter.getCompanyName());
		underwriter1.setAddress(underwriter.getAddress());
		underwriter1.setCompanyLogo(underwriter.getCompanyLogo());
		underwriter1.setContactNo(underwriter.getContactNo());
		underwriter1.setContactNo1(underwriter.getContactNo1());
		underwriter1.setContactNo2(underwriter.getContactNo2());
		underwriter1.setLinkExpiryDate(underwriter.getLinkExpiryDate());
		underwriter1.setAdminCostPercentage(underwriter.getAdminCostPercentage());
		underwriter1.setAcquisitionCostPercentage(underwriter.getAcquisitionCostPercentage());
		underwriter1.setMarginPercentage(underwriter.getMarginPercentage());
		underwriter1.setMinimum(underwriter.getMinimum());
		underwriter1.setMaximum(underwriter.getMaximum());
		underwriter1.setObligatoryToGic(underwriter.getObligatoryToGic());
		underwriter1.setNetRentation(underwriter.getNetRentation());
		underwriter1.setQst(underwriter.getQst());
		underwriter1.setCedentCommission(underwriter.getCedentCommission());
		underwriter1.setDurationOfSubscription(underwriter.getDurationOfSubscription());
		underwriter1.setNoOfAgents(underwriter.getNoOfAgents());
		underwriter1.setPaymentMode(underwriter.getPaymentMode());
		
		if ("BINS".equals(insuranceEntity.getInsuranceType())) {
			int currentTokens = Integer.parseInt(underwriter1.getNoOfTokens());
			if (currentTokens > 0) {
				underwriter1.setNoOfTokens(String.valueOf(currentTokens - 1));
				return entityRepo.save(underwriter1);
			} else {
				System.out.println("Insurance type not found");
			}
		} 
		else if ("INSURER-TBD".equals(insuranceEntity.getInsuranceType())) {
			int currentTokens = Integer.parseInt(underwriter1.getNoOfTokens());
			if (currentTokens > 0) {
				underwriter1.setNoOfTokens(String.valueOf(currentTokens - 1));
				return entityRepo.save(underwriter1);
			} else {
				System.out.println("Insurance type not found");
			}
		} 
		if ("MINET".equals(insuranceEntity.getInsuranceType())) {
			int currentTokens = Integer.parseInt(underwriter1.getNoOfTokens());
			if (currentTokens > 0) {
				underwriter1.setNoOfTokens(String.valueOf(currentTokens - 1));
				return entityRepo.save(underwriter1);
			} else {
				System.out.println("Insurance type not found");
			}
		} 
		if ("TBA-INS".equals(insuranceEntity.getInsuranceType())) {
			int currentTokens = Integer.parseInt(underwriter1.getNoOfTokens());
			if (currentTokens > 0) {
				underwriter1.setNoOfTokens(String.valueOf(currentTokens - 1));
				return entityRepo.save(underwriter1);
			} else {
				System.out.println("Insurance type not found");
			}
		} 
		if ("TBD".equals(insuranceEntity.getInsuranceType())) {
			int currentTokens = Integer.parseInt(underwriter1.getNoOfTokens());
			if (currentTokens > 0) {
				underwriter1.setNoOfTokens(String.valueOf(currentTokens - 1));
				return entityRepo.save(underwriter1);
			} else {
				System.out.println("Insurance type not found");
			}
		} 		
		else {
			System.out.println("Insurance not found");
		}	
		   
//		underwriter1.setNoOfTokens(underwriter.getNoOfTokens());	
		underwriter1.setInitiatedDate(underwriter.getInitiatedDate());
//		underwriter1.setModifiedDate(LocalDate.now().toString());
		String formattedTime = formatLocalTime(LocalTime.now());
		underwriter1.setLocaltime(formattedTime);
		System.out.println(underwriter1);
		return entityRepo.save(underwriter1);
	}

	
	public EntityList deleteEntity(int id) {
		EntityList deletedEntity = entityRepo.findById(id).orElse(null);
		if (deletedEntity != null) {
			TriggerEntity trigger = triggerRepo.findByName("analysis");
			if (trigger != null) {
				trigger.setCount(trigger.getCount() - 1);
				triggerRepo.save(trigger);
			}
			entityRepo.deleteById(id);
		}
		return deletedEntity;
	}

	private static String formatLocalTime(LocalTime time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
		return time.format(formatter);
	}

	public List<EntityList> getEntity() {
		return entityRepo.findAll();
	}

//	public EntityList createEntity(EntityList entity) {
//		TriggerEntity trigger = triggerRepo.findByName("entity");
//		entity.setId(trigger.getCount() + 1);
//		entity.setLocaltime(LocalTime.now().toString());
//		String formattedTime = formatLocalTime(LocalTime.now());
//		entity.setLocaltime(formattedTime);
//		entityRepo.save(entity);
//		trigger.setCount(trigger.getCount() + 1);
//		System.out.println(trigger);
//		triggerRepo.save(trigger);
//		return entity;
//	}

	@Override
	public TreatyCapacity getTreatyByEntityId(int entityId) {
		EntityList entityList = entityRepo.findById(entityId).orElseThrow(
				() -> new UserNotFoundException("entity not found with this id:" + entityId)
		);
		PolicySumInsured policySumInsured=policySumInsuredService.getPolicySumInsuredByEntityId(entityId);

		TreatyCapacity treatyCapacity=new TreatyCapacity();
		long treatyLimit = Long.valueOf(entityList.getMaximum()) - Long.valueOf(entityList.getMinimum());
		long sumInsuredAmount=Long.valueOf(policySumInsured.getSumInsuredAmount());
		long treatLimitUtilized=treatyLimit-sumInsuredAmount;
		treatyCapacity.setTreatyLimit(String.valueOf(treatyLimit));
		treatyCapacity.setTreatLimitUtilized(String.valueOf(treatLimitUtilized));
		treatyCapacity.setTreatyLimitOutStating(String.valueOf(treatyLimit-treatLimitUtilized));
		double utilize = (treatyLimit % (treatLimitUtilized)) * 100;
		treatyCapacity.setTreatyLimitPercentage(String.valueOf(utilize));
		if (utilize >= 0 && utilize < 70) {
			treatyCapacity.setTreatyPercentageMessage("All good - " + utilize + "% LIMIT USED");
		} else if (utilize >= 70 && utilize < 90) {
			treatyCapacity.setTreatyPercentageMessage("WARNING - " + utilize + "% LIMIT USED");
		} else if (utilize >= 90 && utilize < 100) {
			treatyCapacity.setTreatyPercentageMessage("WARNING - " + utilize + "% LIMIT USED");
		} else if (utilize == 100) {
			treatyCapacity.setTreatyPercentageMessage("EXCEEDED, PLEASE INCREASE LIMIT OR ADD TREATY – OR SELECT FAC");
		}

		return treatyCapacity;
	}

	@Override
	public EntityList updatePolicyTreatyPercentage(PolicyTreatyPercentageDto dto) {
		EntityList entityList = entityRepo.findById(dto.getEntityId()).orElseThrow(
				() -> new UserNotFoundException("entity not found with this id:" + dto.getEntityId())
		);
		entityList.setAcquisitionCostPercentage(dto.getACQCost());
		entityList.setObligatoryToGic(dto.getOBLIGATORYTOGIC());
		entityList.setNetRentation(dto.getNetRetention());
		entityList.setQst(dto.getQST());
		entityList.setCedentCommission(dto.getCEDANTCommission());
		EntityList saveEntityList = entityRepo.save(entityList);
		return saveEntityList;
	}

	@Override
	public SolvencyRiskDto calculateSolvencyRisk(int entityId) {
		EntityList entityList = entityRepo.findById(entityId).orElseThrow(
				()-> new UserNotFoundException("entity not found with this id:"+entityId)
		);
		long premiumChargedAmount = Long.valueOf(premiumChargedService.getPremiumChargedAmountByEntityId(entityId).getPremiumChargedAmount());
		long sumInsuredAmount = Long.valueOf(policySumInsuredService.getPolicySumInsuredByEntityId(entityId).getSumInsuredAmount());
		//Highest primium we need to calculate and put below variable
		long highestPremium=11865978;

		SolvencyRiskDto solvencyRisk=new SolvencyRiskDto();
		solvencyRisk.setChargedPremium(String.valueOf(premiumChargedAmount));
		solvencyRisk.setSolvencyIncreasedRisk(String.valueOf(highestPremium/premiumChargedAmount*sumInsuredAmount));

		return solvencyRisk;

	}

}
