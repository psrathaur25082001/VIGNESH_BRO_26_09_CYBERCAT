package com.cybercat.user.serviceImpl;

import com.cybercat.user.config.IndustryConfig;
import com.cybercat.user.entity.ClientInfo;
import com.cybercat.user.entity.StrategicResponseEntity;
import com.cybercat.user.exception.UserNotFoundException;
import com.cybercat.user.payload.ClientInfoDto;
import com.cybercat.user.repository.ClientInfoRepository;
import com.cybercat.user.repository.StrategicResponseRepo;
import com.cybercat.user.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ClientInfoServiceImpl implements ClientInfoService {

	private static final double USD_TO_INR_CONVERSION_RATE = 83.0;
	private static final double INR_TO_USD_CONVERSION_RATE = 1 / USD_TO_INR_CONVERSION_RATE;
	private static final double AED_TO_INR_CONVERSION_RATE = 22.5;
	private static final double INR_TO_AED_CONVERSION_RATE = 1 / AED_TO_INR_CONVERSION_RATE;

	@Autowired
	private ClientInfoRepository clientInfoRepository;

	@Autowired
	private StrategicResponseRepo strategicRepo;

//	public String getStrategicResponseById(int id, int index) {
//		Optional<StrategicResponseEntity> optionalEntity = strategicRepo.findById(id);
//		StrategicResponseEntity entity = optionalEntity.get();
//		return entity.getStrResponses().get(index).getAnswer();
//	}
//
//	public ClientInfoDto calculateAndSaveClientInfo(ClientInfoDto clientInfoDto) {
//		long revenue = clientInfoDto.getRevenue();
//		String region = clientInfoDto.getRegion();
//
//		double[] ranges;
//		switch (region.toUpperCase()) {
//		case "USD":
//			double revenueInINR = revenue * USD_TO_INR_CONVERSION_RATE;
//			ranges = calculateInINR(revenueInINR, clientInfoDto.getIndustryName());
//			ranges[0] = ranges[0] * INR_TO_USD_CONVERSION_RATE;
//			ranges[1] = ranges[1] * INR_TO_USD_CONVERSION_RATE;
//			break;
//		case "INR":
//			ranges = calculateInINR(revenue, clientInfoDto.getIndustryName());
//			break;
//		case "AED":
//			double revenueInINRFromAED = revenue * AED_TO_INR_CONVERSION_RATE;
//			ranges = calculateInINR(revenueInINRFromAED, clientInfoDto.getIndustryName());
//			ranges[0] = ranges[0] * INR_TO_AED_CONVERSION_RATE;
//			ranges[1] = ranges[1] * INR_TO_AED_CONVERSION_RATE;
//			break;
//
//		default:
//			throw new IllegalArgumentException("Unsupported region: " + region);
//		}
//
//		clientInfoDto.setStartingRange(ranges[0]);
//		clientInfoDto.setEndingRange(ranges[1]);
//
//		ClientInfo clientInfo = new ClientInfo();
//		clientInfo.setClientId(clientInfoDto.getClientId());
//		clientInfo.setIndustryId(clientInfoDto.getIndustryId());
//		clientInfo.setIndustryName(clientInfoDto.getIndustryName());
//		clientInfo.setRevenue(clientInfoDto.getRevenue());
//		clientInfo.setRegion(clientInfoDto.getRegion());
//		clientInfo.setStartingRange(clientInfoDto.getStartingRange());
//		clientInfo.setEndingRange(clientInfoDto.getEndingRange());
//		clientInfoRepository.save(clientInfo);
//
//		return clientInfoDto;
//	}

	public ClientInfoDto getStrategicResponseAndSaveClientInfo(int id, int index, ClientInfoDto clientInfoDto) {
		Optional<StrategicResponseEntity> optionalEntity = strategicRepo.findById(id);
		if (!optionalEntity.isPresent()) {
			throw new RuntimeException("StrategicResponseEntity not found for id :: " + id);
		}

		StrategicResponseEntity entity = optionalEntity.get();
		String strategicAnswer = entity.getStrResponses().get(index).getAnswer();

		long revenue;

		try {
			revenue = Long.parseLong(strategicAnswer);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid revenue format in strategicAnswer: " + strategicAnswer, e);
		}

		String industryName = strategicAnswer;

		System.out.println("strategicAnswer " + strategicAnswer);

		clientInfoDto.setRevenue(revenue);
		clientInfoDto.setIndustryName(industryName);

		String region = clientInfoDto.getRegion();
		double[] ranges;

		switch (region.toUpperCase()) {
		case "USD":
			double revenueInINR = revenue * USD_TO_INR_CONVERSION_RATE;
			ranges = calculateInINR((long) revenueInINR, industryName);
			ranges[0] = ranges[0] * INR_TO_USD_CONVERSION_RATE;
			ranges[1] = ranges[1] * INR_TO_USD_CONVERSION_RATE;
			break;
		case "INR":
			ranges = calculateInINR(revenue, industryName);
			break;
		case "AED":
			double revenueInINRFromAED = revenue * AED_TO_INR_CONVERSION_RATE;
			ranges = calculateInINR((long) revenueInINRFromAED, industryName);
			ranges[0] = ranges[0] * INR_TO_AED_CONVERSION_RATE;
			ranges[1] = ranges[1] * INR_TO_AED_CONVERSION_RATE;
			break;
		default:
			throw new IllegalArgumentException("Unsupported region: " + region);
		}

		clientInfoDto.setStartingRange(ranges[0]);
		clientInfoDto.setEndingRange(ranges[1]);

		// Step 3: Create and save the ClientInfo entity
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setClientId(clientInfoDto.getClientId());
		clientInfo.setIndustryId(clientInfoDto.getIndustryId());
		clientInfo.setIndustryName(clientInfoDto.getIndustryName());
		clientInfo.setRevenue(clientInfoDto.getRevenue());
		clientInfo.setRegion(clientInfoDto.getRegion());
		clientInfo.setStartingRange(clientInfoDto.getStartingRange());
		clientInfo.setEndingRange(clientInfoDto.getEndingRange());
		clientInfoRepository.save(clientInfo);

		return clientInfoDto;
	}

	private double[] calculateInINR(long revenue, String industryName) {
		String revenueRange;
		if (revenue <= 1000000000) {
			revenueRange = "0-1000000000";
		} else if (revenue <= 5000000000L) {
			revenueRange = "1000000000-5000000000";
		} else if (revenue <= 10000000000L) {
			revenueRange = "5000000000-10000000000";
		} else if (revenue <= 25000000000L) {
			revenueRange = "10000000000-25000000000";
		} else if (revenue <= 50000000000L) {
			revenueRange = "25000000000-50000000000";
		} else if (revenue <= 100000000000L) {
			revenueRange = "50000000000-100000000000";
		} else {
			revenueRange = ">100000000000";
		}
//		System.out.println("Industry: " + industryName);
//		System.out.println("Revenue Range: " + revenueRange);
		Double[] percentages = IndustryConfig.getPercentages(industryName, revenueRange);
//		System.out.println("Percentages: " + Arrays.toString(percentages));
		double startingRange = revenue * percentages[0] / 100;
		double endingRange = revenue * percentages[1] / 100;
		return new double[] { startingRange, endingRange };
	}

	@Override
	public ClientInfoDto getClientInfoById(String clientId) {
		ClientInfo clientInfo = clientInfoRepository.findById(clientId)
				.orElseThrow(() -> new UserNotFoundException("ClientInfo not found for id: " + clientId));
		ClientInfoDto clientInfoDto = new ClientInfoDto();
		clientInfoDto.setClientId(clientInfo.getClientId());
		clientInfoDto.setIndustryId(clientInfo.getIndustryId());
		clientInfoDto.setIndustryName(clientInfo.getIndustryName());
		clientInfoDto.setRevenue(clientInfo.getRevenue());
		clientInfoDto.setRegion(clientInfo.getRegion());
		clientInfoDto.setStartingRange(clientInfo.getStartingRange());
		clientInfoDto.setEndingRange(clientInfo.getEndingRange());
		return clientInfoDto;
	}

}
