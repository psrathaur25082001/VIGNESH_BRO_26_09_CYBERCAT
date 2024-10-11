package com.cybercat.user.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybercat.user.entity.ClientEntity;
import com.cybercat.user.entity.ControlsCountEntity;
import com.cybercat.user.entity.HippaQuestionEntity;
import com.cybercat.user.entity.HippaQuestionResponseEntity;
import com.cybercat.user.entity.HippaResponseEntity;
import com.cybercat.user.entity.IndustryQuesCountEntity;
import com.cybercat.user.entity.IndustryQuestionEntity;
import com.cybercat.user.entity.IndustryQuestionResponseEntity;
import com.cybercat.user.entity.IndustryResponseEntity;
//import com.cybercat.user.entity.RecordsOfAustralia;
import com.cybercat.user.entity.StrQuesCountEntity;
import com.cybercat.user.entity.StrategicQuestionEntity;
import com.cybercat.user.entity.TechQuesCountEntity;
import com.cybercat.user.entity.TechnicalQuestionEntity;
import com.cybercat.user.entity.StrategicQuestionResponseEntity;
import com.cybercat.user.entity.StrategicResponseEntity;
import com.cybercat.user.entity.StrategicTriggerQuestionEntity;
//import com.cybercat.user.entity.TPCEntity;
import com.cybercat.user.entity.TechnicalQuestionResponseEntity;
import com.cybercat.user.entity.TechnicalResponseEntity;
import com.cybercat.user.helper.ClientSendMailOTP;
import com.cybercat.user.repository.TechnicalResponseRepo;
import com.cybercat.user.repository.ClientRepo;
import com.cybercat.user.repository.HippaQuestionRepository;
import com.cybercat.user.repository.HippaResponseRepo;
import com.cybercat.user.repository.IndustryQuestionRepository;
import com.cybercat.user.repository.IndustryResponseRepo;
import com.cybercat.user.repository.StrategicQuestionRepository;
import com.cybercat.user.repository.StrategicResponseRepo;
import com.cybercat.user.repository.StrategicTriggerQuestionRepo;
//import com.cybercat.user.repository.TPCRepo;
import com.cybercat.user.repository.TechnicalQuestionRepo;
import com.cybercat.user.service.QuestionMasterService;

@Service
public class QuestionMasterServiceImpl implements QuestionMasterService {

	@Autowired
	TechnicalResponseRepo technicalRepo;

	@Autowired
	StrategicResponseRepo strategicRepo;

	@Autowired
	IndustryResponseRepo industryRepo;

	@Autowired
	HippaResponseRepo hippaRepo;

	@Autowired
	ClientRepo clientRepo;

//	@Autowired
//	TPCRepo tPCRepo;

	@Autowired
	StrategicQuestionRepository strategicQuestionRepo;

	@Autowired
	StrategicTriggerQuestionRepo strategicTriggerQuestionRepo;

	@Autowired
	TechnicalQuestionRepo technicalQuestionRepo;

	@Autowired
	IndustryQuestionRepository industryQuestionRepo;

	@Autowired
	HippaQuestionRepository hippaQuestionRepo;

//	@Autowired
//	TechnicalTriggerQuestionRepo technicalTriggerQuestionRepo;

	public List<String> getHeadAndScores() {
		List<IndustryResponseEntity> industryResponses = industryRepo.findAll();

		return industryResponses.stream()
				.flatMap(industryResponse -> industryResponse.getIndResponses().stream()
						.map(response -> "Head: " + response.getHead() + ", Score: " + response.getScore()))
				.collect(Collectors.toList());
	}

	public StrQuesCountEntity getStrQuesCountTeam(int clientID) {
		StrategicResponseEntity tech = strategicRepo.findById(clientID).get();
		StrQuesCountEntity qc = new StrQuesCountEntity();

		int generalQuestions = 0, informationQuestions = 0, managementQuestions = 0, iTQuestions = 0,
				financeManagementQuestions = 0, operationsITQuestions = 0, operationsQuestions = 0,
				financeQuestions = 0, legalManagementQuestions = 0, complianceLegalQuestions = 0,
				riskManagementQuestions = 0, legalQuestions = 0, boardQuestions = 0, iTLegalQuestions = 0,
				hRQuestions = 0;

		int generalAnswer = 0, informationAnswer = 0, managementAnswer = 0, iTAnswer = 0, financeManagementAnswer = 0,
				operationsITAnswer = 0, operationsAnswer = 0, financeAnswer = 0, legalManagementAnswer = 0,
				complianceLegalAnswer = 0, riskManagementAnswer = 0, legalAnswer = 0, boardAnswer = 0,
				iTLegalAnswer = 0, hRAnswer = 0;

		for (StrategicQuestionResponseEntity q : tech.getStrResponses()) {
			if (q.getTeam().equals("GENERAL")) {
				generalQuestions++;
				if (q.getAnswer().length() > 0) {
					generalAnswer++;
				}
			} else if (q.getTeam().equals("INFORMATION TECHNOLOGY")) {
				informationQuestions++;
				if (q.getAnswer().length() > 0) {
					informationAnswer++;
				}
			} else if (q.getTeam().equals("MANAGEMENT")) {
				managementQuestions++;
				if (q.getAnswer().length() > 0) {
					managementAnswer++;
				}
			} else if (q.getTeam().equals("IT")) {
				iTQuestions++;
				if (q.getAnswer().length() > 0) {
					iTAnswer++;
				}
			} else if (q.getTeam().equals("MANAGEMENT & FINANCE")) {
				financeManagementQuestions++;
				if (q.getAnswer().length() > 0) {
					financeManagementAnswer++;
				}
			} else if (q.getTeam().equals("OPERATIONS & IT")) {
				operationsITQuestions++;
				if (q.getAnswer().length() > 0) {
					operationsITAnswer++;
				}
			} else if (q.getTeam().equals("OPERATIONS")) {
				operationsQuestions++;
				if (q.getAnswer().length() > 0) {
					operationsAnswer++;
				}
			} else if (q.getTeam().equals("FINANCE")) {
				financeQuestions++;
				if (q.getAnswer().length() > 0) {
					financeAnswer++;
				}
			} else if (q.getTeam().equals("MANAGEMENT  & LEGAL")) {
				legalManagementQuestions++;
				if (q.getAnswer().length() > 0) {
					legalManagementAnswer++;
				}
			} else if (q.getTeam().equals("COMPLIANCE & LEGAL")) {
				complianceLegalQuestions++;
				if (q.getAnswer().length() > 0) {
					complianceLegalAnswer++;
				}
			} else if (q.getTeam().equals("RISK MANAGEMENT")) {
				riskManagementQuestions++;
				if (q.getAnswer().length() > 0) {
					riskManagementAnswer++;
				}
			} else if (q.getTeam().equals("LEGAL")) {
				legalQuestions++;
				if (q.getAnswer().length() > 0) {
					legalAnswer++;
				}
			} else if (q.getTeam().equals("BOARD/MANAGEMENT")) {
				boardQuestions++;
				if (q.getAnswer().length() > 0) {
					boardAnswer++;
				}
			} else if (q.getTeam().equals("IT & LEGAL")) {
				iTLegalQuestions++;
				if (q.getAnswer().length() > 0) {
					iTLegalAnswer++;
				}
			} else if (q.getTeam().equals("HR")) {
				hRQuestions++;
				if (q.getAnswer().length() > 0) {
					hRAnswer++;
				}
			}
		}
		qc.setGeneralQuestions(generalQuestions);
		qc.setInformationQuestions(informationQuestions);
		qc.setManagementQuestions(managementQuestions);
		qc.setITQuestions(iTQuestions);
		qc.setFinanceManagementQuestions(financeManagementQuestions);
		qc.setOperationsITQuestions(operationsITQuestions);
		qc.setOperationsQuestions(operationsQuestions);
		qc.setFinanceQuestions(financeQuestions);
		qc.setLegalManagementQuestions(legalManagementQuestions);
		qc.setComplianceLegalQuestions(complianceLegalQuestions);
		qc.setRiskManagementQuestions(riskManagementQuestions);
		qc.setLegalQuestions(legalQuestions);
		qc.setBoardQuestions(boardQuestions);
		qc.setITLegalQuestions(iTLegalQuestions);
		qc.setHRQuestions(hRQuestions);

		qc.setGeneralAnswer(generalAnswer);
		qc.setInformationAnswer(informationAnswer);
		qc.setManagementAnswer(managementAnswer);
		qc.setITAnswer(iTAnswer);
		qc.setFinanceManagementAnswer(financeManagementAnswer);
		qc.setOperationsITAnswer(operationsITAnswer);
		qc.setOperationsAnswer(operationsAnswer);
		qc.setFinanceAnswer(financeAnswer);
		qc.setLegalManagementAnswer(legalManagementAnswer);
		qc.setComplianceLegalAnswer(complianceLegalAnswer);
		qc.setRiskManagementAnswer(riskManagementAnswer);
		qc.setLegalAnswer(legalAnswer);
		qc.setBoardAnswer(boardAnswer);
		qc.setITLegalAnswer(iTLegalAnswer);
		qc.setHRAnswer(hRAnswer);

		qc.setTotalQuestions(iTLegalQuestions + generalQuestions + informationQuestions + managementQuestions
				+ iTQuestions + financeManagementQuestions + operationsITQuestions + operationsQuestions
				+ financeQuestions + legalManagementQuestions + complianceLegalQuestions + riskManagementQuestions
				+ legalQuestions + boardQuestions + hRQuestions);

		return qc;
	}

	public TechQuesCountEntity getTechQuesCountTeam(int clientID) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID).get();
		TechQuesCountEntity qc = new TechQuesCountEntity();

		int identityQuestions = 0, networkQuestions = 0, dataQuestions = 0, securityOperationQuestions = 0,
				legalQuestions = 0, complianceQuestions = 0, cloudQuestions = 0, publicQuestions = 0,
				securityAwarenessQuestions = 0, thisQuestionQuestions = 0;

		int identityAnswer = 0, networkAnswer = 0, dataAnswer = 0, securityOperationAnswer = 0, legalAnswer = 0,
				complianceAnswer = 0, cloudAnswer = 0, publicAnswer = 0, securityAwarenessAnswer = 0,
				thisQuestionAnswer = 0;

		for (TechnicalQuestionResponseEntity q : tech.getTechResponses()) {
			if (q.getTeam().equals("Identity and Access Management (IAM)")) {
				identityQuestions++;
				if (q.getAnswer().length() > 0) {
					identityAnswer++;
				}
			} else if (q.getTeam().equals("Network Security")) {
				networkQuestions++;
				if (q.getAnswer().length() > 0) {
					networkAnswer++;
				}
			} else if (q.getTeam().equals("Data Security")) {
				dataQuestions++;
				if (q.getAnswer().length() > 0) {
					dataAnswer++;
				}
			} else if (q.getTeam().equals("Security Operations Center (SOC)")) {
				securityOperationQuestions++;
				if (q.getAnswer().length() > 0) {
					securityOperationAnswer++;
				}
			} else if (q.getTeam().equals("Legal department")) {
				legalQuestions++;
				if (q.getAnswer().length() > 0) {
					legalAnswer++;
				}
			} else if (q.getTeam().equals("Compliance team")) {
				complianceQuestions++;
				if (q.getAnswer().length() > 0) {
					complianceAnswer++;
				}
			} else if (q.getTeam().equals("Cloud Security (if separate team) or Security Operations Center (SOC)")) {
				cloudQuestions++;
				if (q.getAnswer().length() > 0) {
					cloudAnswer++;
				}
			} else if (q.getTeam().equals("Public Relations")) {
				publicQuestions++;
				if (q.getAnswer().length() > 0) {
					publicAnswer++;
				}
			} else if (q.getTeam().equals("Security Awareness team")) {
				securityAwarenessQuestions++;
				if (q.getAnswer().length() > 0) {
					securityAwarenessAnswer++;
				}
			} else if (q.getTeam()
					.equals("This question may involve multiple departments like Legal, Finance, and IT")) {
				thisQuestionQuestions++;
				if (q.getAnswer().length() > 0) {
					thisQuestionAnswer++;
				}
			}
		}
		qc.setIdentityQuestions(identityQuestions);
		qc.setNetworkQuestions(networkQuestions);
		qc.setDataQuestions(dataQuestions);
		qc.setSecurityOperationQuestions(securityOperationQuestions);
		qc.setLegalQuestions(legalQuestions);
		qc.setComplianceQuestions(complianceQuestions);
		qc.setCloudQuestions(cloudQuestions);
		qc.setPublicQuestions(publicQuestions);
		qc.setSecurityAwarenessQuestions(securityAwarenessQuestions);
		qc.setThisQuestionQuestions(thisQuestionQuestions);

		qc.setIdentityAnswer(identityAnswer);
		qc.setNetworkAnswer(networkAnswer);
		qc.setDataAnswer(dataAnswer);
		qc.setSecurityOperationAnswer(securityOperationAnswer);
		qc.setLegalAnswer(legalAnswer);
		qc.setComplianceAnswer(complianceAnswer);
		qc.setCloudAnswer(cloudAnswer);
		qc.setPublicAnswer(publicAnswer);
		qc.setSecurityAwarenessAnswer(securityAwarenessAnswer);
		qc.setThisQuestionAnswer(thisQuestionAnswer);

		qc.setTotalQuestions(identityQuestions + networkQuestions + dataQuestions + securityOperationQuestions
				+ legalQuestions + complianceQuestions + cloudQuestions + publicQuestions + securityAwarenessQuestions
				+ thisQuestionQuestions);

		return qc;
	}

	public IndustryQuesCountEntity getIndustryQuesCountTeam(int clientID) {
		IndustryResponseEntity industry = industryRepo.findById(clientID).get();
		IndustryQuesCountEntity qc = new IndustryQuesCountEntity();

		int financeQuestions = 0, securityOperationsCenterQuestions = 0, dataSecurityQuestions = 0, riskQuestions = 0,
				cloudSecurityOrSecurityOperationsCenterQuestions = 0, complianceTeamQuestions = 0, otTeamQuestions = 0,
				cloudSecurityOrSecurityOperationsCenter1Questions = 0, infraQuestions = 0, operationsTechQuestions = 0,
				deviceSecurityQuestions = 0, networkSecuritySecurityOperationsCenterQuestions = 0,
				legalDepartmentQuestions = 0, legalQuestions = 0, financeOperationsQuestions = 0,
				networkSecurityQuestions = 0, financeOperations1Questions = 0, socQuestions = 0,
				cyberGovernanceQuestions = 0;

		int financeAnswer = 0, securityOperationsCenterAnswer = 0, dataSecurityAnswer = 0, riskAnswer = 0,
				cloudSecurityOrSecurityOperationsCenterAnswer = 0, complianceTeamAnswer = 0, otTeamAnswer = 0,
				cloudSecurityOrSecurityOperationsCenter1Answer = 0, infraAnswer = 0, operationsTechAnswer = 0,
				deviceSecurityAnswer = 0, networkSecuritySecurityOperationsCenterAnswer = 0, legalDepartmentAnswer = 0,
				legalAnswer = 0, financeOperationsAnswer = 0, networkSecurityAnswer = 0, financeOperations1Answer = 0,
				socAnswer = 0, cyberGovernanceAnswer = 0;

		for (IndustryQuestionResponseEntity q : industry.getIndResponses()) {
			if (q.getTeam().equals("FINANCE")) {
				financeQuestions++;
				if (q.getAnswer().length() > 0) {
					financeAnswer++;
				}
			} else if (q.getTeam().equals("Security Operations Center (SOC)")) {
				securityOperationsCenterQuestions++;
				if (q.getAnswer().length() > 0) {
					securityOperationsCenterAnswer++;
				}
			} else if (q.getTeam().equals("DATA SECURITY")) {
				dataSecurityQuestions++;
				if (q.getAnswer().length() > 0) {
					dataSecurityAnswer++;
				}
			} else if (q.getTeam().equals("RISK")) {
				riskQuestions++;
				if (q.getAnswer().length() > 0) {
					riskAnswer++;
				}
			} else if (q.getTeam().equals("Cloud Security (if separate team) or Security Operations Center (SOC)")) {
				cloudSecurityOrSecurityOperationsCenterQuestions++;
				if (q.getAnswer().length() > 0) {
					cloudSecurityOrSecurityOperationsCenterAnswer++;
				}
			} else if (q.getTeam().equals("COMPLIANCE TEAM")) {
				complianceTeamQuestions++;
				if (q.getAnswer().length() > 0) {
					complianceTeamAnswer++;
				}
			} else if (q.getTeam().equals("OT TEAM")) {
				otTeamQuestions++;
				if (q.getAnswer().length() > 0) {
					otTeamAnswer++;
				}
			} else if (q.getTeam().equals("Cloud Security or Security Operations Center (SOC)")) {
				cloudSecurityOrSecurityOperationsCenter1Questions++;
				if (q.getAnswer().length() > 0) {
					cloudSecurityOrSecurityOperationsCenter1Answer++;
				}
			} else if (q.getTeam().equals("INFRA")) {
				infraQuestions++;
				if (q.getAnswer().length() > 0) {
					infraAnswer++;
				}
			} else if (q.getTeam().equals("OPERATIONS & TECH")) {
				operationsTechQuestions++;
				if (q.getAnswer().length() > 0) {
					operationsTechAnswer++;
				}
			} else if (q.getTeam().equals("Device Security")) {
				deviceSecurityQuestions++;
				if (q.getAnswer().length() > 0) {
					deviceSecurityAnswer++;
				}
			} else if (q.getTeam().equals("Network Security & Security Operations Center (SOC)")) {
				networkSecuritySecurityOperationsCenterQuestions++;
				if (q.getAnswer().length() > 0) {
					networkSecuritySecurityOperationsCenterAnswer++;
				}
			} else if (q.getTeam().equals("Legal department")) {
				legalDepartmentQuestions++;
				if (q.getAnswer().length() > 0) {
					legalDepartmentAnswer++;
				}
			} else if (q.getTeam().equals("LEGAL")) {
				legalQuestions++;
				if (q.getAnswer().length() > 0) {
					legalAnswer++;
				}
			} else if (q.getTeam().equals("FINANCE-OPERATIONS")) {
				financeOperationsQuestions++;
				if (q.getAnswer().length() > 0) {
					financeOperationsAnswer++;
				}
			} else if (q.getTeam().equals("Network Security")) {
				networkSecurityQuestions++;
				if (q.getAnswer().length() > 0) {
					networkSecurityAnswer++;
				}
			} else if (q.getTeam().equals("FINANCE - OPERATIONS")) {
				financeOperations1Questions++;
				if (q.getAnswer().length() > 0) {
					financeOperations1Answer++;
				}
			} else if (q.getTeam().equals("SOC")) {
				socQuestions++;
				if (q.getAnswer().length() > 0) {
					socAnswer++;
				}
			} else if (q.getTeam().equals("CYBER GOVERNANCE")) {
				cyberGovernanceQuestions++;
				if (q.getAnswer().length() > 0) {
					cyberGovernanceAnswer++;
				}
			}
		}
		qc.setFinanceQuestions(financeQuestions);
		qc.setSecurityOperationsCenterQuestions(securityOperationsCenterQuestions);
		qc.setDataSecurityQuestions(dataSecurityQuestions);
		qc.setRiskQuestions(riskQuestions);
		qc.setCloudSecurityOrSecurityOperationsCenterQuestions(cloudSecurityOrSecurityOperationsCenterQuestions);
		qc.setComplianceTeamQuestions(complianceTeamQuestions);
		qc.setOtTeamQuestions(otTeamQuestions);
		qc.setCloudSecurityOrSecurityOperationsCenter1Questions(cloudSecurityOrSecurityOperationsCenter1Questions);
		qc.setInfraQuestions(infraQuestions);
		qc.setOperationsTechQuestions(operationsTechQuestions);
		qc.setDeviceSecurityQuestions(deviceSecurityQuestions);
		qc.setNetworkSecuritySecurityOperationsCenterQuestions(networkSecuritySecurityOperationsCenterQuestions);
		qc.setLegalDepartmentQuestions(legalDepartmentQuestions);
		qc.setLegalQuestions(legalQuestions);
		qc.setFinanceOperationsQuestions(financeOperationsQuestions);
		qc.setNetworkSecurityQuestions(networkSecurityQuestions);
		qc.setFinanceOperations1Questions(financeOperations1Questions);
		qc.setSocQuestions(socQuestions);
		qc.setCyberGovernanceQuestions(cyberGovernanceQuestions);

		qc.setFinanceAnswer(financeAnswer);
		qc.setSecurityOperationsCenterAnswer(securityOperationsCenterAnswer);
		qc.setDataSecurityAnswer(dataSecurityAnswer);
		qc.setRiskAnswer(riskAnswer);
		qc.setCloudSecurityOrSecurityOperationsCenterAnswer(cloudSecurityOrSecurityOperationsCenterAnswer);
		qc.setComplianceTeamAnswer(complianceTeamAnswer);
		qc.setOtTeamAnswer(otTeamAnswer);
		qc.setCloudSecurityOrSecurityOperationsCenter1Answer(cloudSecurityOrSecurityOperationsCenter1Answer);
		qc.setInfraAnswer(infraAnswer);
		qc.setOperationsTechAnswer(operationsTechAnswer);
		qc.setDeviceSecurityAnswer(deviceSecurityAnswer);
		qc.setNetworkSecuritySecurityOperationsCenterAnswer(networkSecuritySecurityOperationsCenterAnswer);
		qc.setLegalDepartmentAnswer(legalDepartmentAnswer);
		qc.setLegalAnswer(legalAnswer);
		qc.setFinanceOperationsAnswer(financeOperationsAnswer);
		qc.setNetworkSecurityAnswer(networkSecurityAnswer);
		qc.setFinanceOperations1Answer(financeOperations1Answer);
		qc.setSocAnswer(socAnswer);
		qc.setCyberGovernanceAnswer(cyberGovernanceAnswer);

		qc.setTotalQuestions(financeQuestions + securityOperationsCenterQuestions + dataSecurityQuestions
				+ riskQuestions + cloudSecurityOrSecurityOperationsCenterQuestions + complianceTeamQuestions
				+ otTeamQuestions + cloudSecurityOrSecurityOperationsCenter1Questions + infraQuestions
				+ operationsTechQuestions + deviceSecurityQuestions + networkSecuritySecurityOperationsCenterQuestions
				+ legalDepartmentQuestions + legalQuestions + financeOperationsQuestions + networkSecurityQuestions
				+ financeOperations1Questions + socQuestions + cyberGovernanceQuestions);

		return qc;
	}

	public boolean resend(int clientID) throws Exception {
		ClientEntity cl = clientRepo.findById(clientID).get();
		int days = Integer.parseInt(cl.getLinkExpiryDate());
		System.out.println(cl);
		LocalDate endDate = LocalDate.parse(cl.getCreatedDate()).plusDays(days);
		ClientSendMailOTP.mailSend(cl.getEmailID(), cl.getFirstName(),
				endDate.getDayOfMonth() + "-" + endDate.getMonth() + "-" + endDate.getYear());
		return true;
	}

	public List<ControlsCountEntity> techControlHead(String techHead, int clientID) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID).get();
		ArrayList<TechnicalQuestionResponseEntity> qr = tech.getTechResponses();
		List<String> res = new ArrayList<String>();
		for (TechnicalQuestionResponseEntity q : qr) {
			if (q.getHead().equals(techHead)) {
				res.add(q.getType());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = techControlsCountHead(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity techControlsCountHead(String techHead, int clientID) {
		TechnicalResponseEntity cl = technicalRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (TechnicalQuestionResponseEntity qr : cl.getTechResponses()) {
			if (qr.getType().equals(techHead)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	// TYPE
	public List<ControlsCountEntity> techControlType(String techType, int clientID) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID).get();
		ArrayList<TechnicalQuestionResponseEntity> qr = tech.getTechResponses();
		List<String> res = new ArrayList<String>();
		for (TechnicalQuestionResponseEntity q : qr) {
			if (q.getTechnical().equals(techType)) {
				res.add(q.getTeam());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = techControlsCountType(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity techControlsCountType(String techType, int clientID) {
		TechnicalResponseEntity cl = technicalRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (TechnicalQuestionResponseEntity qr : cl.getTechResponses()) {
			if (qr.getTeam().equals(techType)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	// section
	public List<ControlsCountEntity> techControlTeam(String techTeam, int clientID) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID).get();
		ArrayList<TechnicalQuestionResponseEntity> qr = tech.getTechResponses();
		List<String> res = new ArrayList<String>();
		for (TechnicalQuestionResponseEntity q : qr) {
			if (q.getTeam().equals(techTeam)) {
				res.add(q.getSection());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		System.out.println(res);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = techControlsCountTeam(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity techControlsCountTeam(String techTeam, int clientID) {
		TechnicalResponseEntity cl = technicalRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (TechnicalQuestionResponseEntity qr : cl.getTechResponses()) {
			if (qr.getSection().equals(techTeam)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	public TechnicalResponseEntity techControlsQuestion(String techControls, int clientID) {
		TechnicalResponseEntity cl = technicalRepo.findById(clientID).get();
		TechnicalResponseEntity res = cl;
		ArrayList<TechnicalQuestionResponseEntity> q = new ArrayList<TechnicalQuestionResponseEntity>();
		for (TechnicalQuestionResponseEntity qr : cl.getTechResponses()) {
			if (qr.getTeam().equals(techControls)) {
				q.add(qr);
			}
		}
		res.setTechResponses(q);
		return res;
	}

	public TechnicalResponseEntity techSaveRes(int index, String answer, int answerOption, int clientID, int score) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID).get();
		ArrayList<TechnicalQuestionResponseEntity> qr = tech.getTechResponses();
		qr.get(index).setAnswer(answer);
		qr.get(index).setAnswerOption(answerOption);
		qr.get(index).setScore(score);
		tech.setTechResponses(qr);
		technicalRepo.save(tech);
		return tech;
	}

	public TechnicalResponseEntity techCheckBoxRes(int index, String answer, String answer1, String answer2,
			String answer3, String answer4, String answer5, int answerOption, int clientID, int score) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID).get();
		ArrayList<TechnicalQuestionResponseEntity> qr = tech.getTechResponses();
		qr.get(index).setAnswer(answer);
		qr.get(index).setCheckBoxAnswer1(answer1);
		qr.get(index).setCheckBoxAnswer2(answer2);
		qr.get(index).setCheckBoxAnswer3(answer3);
		qr.get(index).setCheckBoxAnswer4(answer4);
		qr.get(index).setCheckBoxAnswer5(answer5);
		qr.get(index).setAnswerOption(answerOption);
		qr.get(index).setScore(score);
		tech.setTechResponses(qr);
		technicalRepo.save(tech);
		return tech;
	}

	public TechnicalResponseEntity techTextRes(int index, String answer, int clientID) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID)
				.orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + clientID));
		ArrayList<TechnicalQuestionResponseEntity> qr = tech.getTechResponses();
		qr.get(index).setAnswer(answer);
		tech.setTechResponses(qr);
		technicalRepo.save(tech);
		return tech;
	}

	public boolean techMarkQues(int index, int clientID, boolean value) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID).get();
		ArrayList<TechnicalQuestionResponseEntity> qr = tech.getTechResponses();
		qr.get(index).setMarked(value);
		tech.setTechResponses(qr);
		technicalRepo.save(tech);
		return true;
	}

	public List<ControlsCountEntity> strControlHead(String strHead, int clientID) {
		StrategicResponseEntity str = strategicRepo.findById(clientID).get();
		ArrayList<StrategicQuestionResponseEntity> qr = str.getStrResponses();
		List<String> res = new ArrayList<String>();
		for (StrategicQuestionResponseEntity q : qr) {
			if (q.getHead().equals(strHead)) {
				res.add(q.getType());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = strControlsCountHead(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity strControlsCountHead(String strHead, int clientID) {
		StrategicResponseEntity cl = strategicRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (StrategicQuestionResponseEntity qr : cl.getStrResponses()) {
			if (qr.getType().equals(strHead)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	// TYPE
	public List<ControlsCountEntity> strControlType(String strType, int clientID) {
		StrategicResponseEntity str = strategicRepo.findById(clientID).get();
		ArrayList<StrategicQuestionResponseEntity> qr = str.getStrResponses();
		List<String> res = new ArrayList<String>();
		for (StrategicQuestionResponseEntity q : qr) {
			if (q.getStrategic().equals(strType)) {
				res.add(q.getTeam());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		System.out.println(res);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = strControlsCountType(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity strControlsCountType(String strType, int clientID) {
		StrategicResponseEntity cl = strategicRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (StrategicQuestionResponseEntity qr : cl.getStrResponses()) {
			if (qr.getTeam().equals(strType)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	// section
	public List<ControlsCountEntity> strControlTeam(String strTeam, int clientID) {
		StrategicResponseEntity str = strategicRepo.findById(clientID).get();
		ArrayList<StrategicQuestionResponseEntity> qr = str.getStrResponses();
		List<String> res = new ArrayList<String>();
		for (StrategicQuestionResponseEntity q : qr) {
			if (q.getTeam().equals(strTeam)) {
				res.add(q.getSection());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		System.out.println(res);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = strControlsCountTeam(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity strControlsCountTeam(String strTeam, int clientID) {
		StrategicResponseEntity cl = strategicRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (StrategicQuestionResponseEntity qr : cl.getStrResponses()) {
			if (qr.getSection().equals(strTeam)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	public StrategicResponseEntity strControlsQuestion(String strControls, int clientID) {
		StrategicResponseEntity cl = strategicRepo.findById(clientID).get();
		StrategicResponseEntity res = cl;
		ArrayList<StrategicQuestionResponseEntity> q = new ArrayList<StrategicQuestionResponseEntity>();
		for (StrategicQuestionResponseEntity qr : cl.getStrResponses()) {
			if (qr.getTeam().equals(strControls)) {
				q.add(qr);
			}
		}
		res.setStrResponses(q);
		return res;
	}

	public StrategicResponseEntity strSaveRes(int index, String answer, int answerOption, int clientID, int score) {
		StrategicResponseEntity str = strategicRepo.findById(clientID).get();
		ArrayList<StrategicQuestionResponseEntity> qr = str.getStrResponses();
		qr.get(index).setAnswer(answer);
		qr.get(index).setAnswerOption(answerOption);
		qr.get(index).setScore(score);
		str.setStrResponses(qr);
		strategicRepo.save(str);
		return str;
	}

	public StrategicResponseEntity strCheckBoxRes(int index, String answer, String answer1, String answer2,
			String answer3, String answer4, String answer5, int answerOption, int clientID, int score) {
		StrategicResponseEntity tech = strategicRepo.findById(clientID).get();
		ArrayList<StrategicQuestionResponseEntity> qr = tech.getStrResponses();
		qr.get(index).setAnswer(answer);
		qr.get(index).setCheckBoxAnswer1(answer1);
		qr.get(index).setCheckBoxAnswer2(answer2);
		qr.get(index).setCheckBoxAnswer3(answer3);
		qr.get(index).setCheckBoxAnswer4(answer4);
		qr.get(index).setCheckBoxAnswer5(answer5);
		qr.get(index).setAnswerOption(answerOption);
		qr.get(index).setScore(score);
		tech.setStrResponses(qr);
		strategicRepo.save(tech);
		return tech;
	}

	public StrategicResponseEntity strTextRes(int index, String answer, int clientID) {
		StrategicResponseEntity tech = strategicRepo.findById(clientID)
				.orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + clientID));
		ArrayList<StrategicQuestionResponseEntity> qr = tech.getStrResponses();
		qr.get(index).setAnswer(answer);
		tech.setStrResponses(qr);
		strategicRepo.save(tech);
		return tech;
	}

	public boolean strMarkQues(int index, int clientID, boolean value) {
		StrategicResponseEntity str = strategicRepo.findById(clientID).get();
		ArrayList<StrategicQuestionResponseEntity> qr = str.getStrResponses();
		qr.get(index).setMarked(value);
		str.setStrResponses(qr);
		strategicRepo.save(str);
		return true;
	}

	// industry
	public List<ControlsCountEntity> indControlHead(String indHead, int clientID) {
		IndustryResponseEntity ind = industryRepo.findById(clientID).get();
		ArrayList<IndustryQuestionResponseEntity> qr = ind.getIndResponses();
		List<String> res = new ArrayList<String>();
		for (IndustryQuestionResponseEntity q : qr) {
			if (q.getHead().equals(indHead)) {
				res.add(q.getType());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = indControlsCountHead(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity indControlsCountHead(String indHead, int clientID) {
		IndustryResponseEntity cl = industryRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (IndustryQuestionResponseEntity qr : cl.getIndResponses()) {
			if (qr.getType().equals(indHead)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	// TYPE
	public List<ControlsCountEntity> indControlType(String indType, int clientID) {
		IndustryResponseEntity str = industryRepo.findById(clientID).get();
		ArrayList<IndustryQuestionResponseEntity> qr = str.getIndResponses();
		List<String> res = new ArrayList<String>();
		for (IndustryQuestionResponseEntity q : qr) {
			if (q.getIndustryType().equals(indType)) {
				res.add(q.getTeam());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = indControlsCountType(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity indControlsCountType(String strType, int clientID) {
		IndustryResponseEntity cl = industryRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (IndustryQuestionResponseEntity qr : cl.getIndResponses()) {
			if (qr.getTeam().equals(strType)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	// section
	public List<ControlsCountEntity> indControlTeam(String indTeam, int clientID) {
		IndustryResponseEntity str = industryRepo.findById(clientID).get();
		ArrayList<IndustryQuestionResponseEntity> qr = str.getIndResponses();
		List<String> res = new ArrayList<String>();
		for (IndustryQuestionResponseEntity q : qr) {
			if (q.getTeam().equals(indTeam)) {
				res.add(q.getSection());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		System.out.println(res);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = indControlsCountTeam(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity indControlsCountTeam(String indTeam, int clientID) {
		IndustryResponseEntity cl = industryRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (IndustryQuestionResponseEntity qr : cl.getIndResponses()) {
			if (qr.getSection().equals(indTeam)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	public IndustryResponseEntity indControlsQuestion(String indControls, int clientID) {
		IndustryResponseEntity cl = industryRepo.findById(clientID).get();
		IndustryResponseEntity res = cl;
		ArrayList<IndustryQuestionResponseEntity> q = new ArrayList<IndustryQuestionResponseEntity>();
		for (IndustryQuestionResponseEntity qr : cl.getIndResponses()) {
			if (qr.getTeam().equals(indControls)) {
				q.add(qr);
			}
		}
		res.setIndResponses(q);
		return res;
	}

	public IndustryResponseEntity indSaveRes(int index, String answer, int answerOption, int clientID, int score) {
		IndustryResponseEntity str = industryRepo.findById(clientID).get();
		ArrayList<IndustryQuestionResponseEntity> qr = str.getIndResponses();
		qr.get(index).setAnswer(answer);
		qr.get(index).setAnswerOption(answerOption);
		qr.get(index).setScore(score);
		str.setIndResponses(qr);
		industryRepo.save(str);
		return str;
	}

	public IndustryResponseEntity indCheckBoxRes(int index, String answer, String answer1, String answer2,
			String answer3, String answer4, String answer5, int answerOption, int clientID, int score) {
		IndustryResponseEntity tech = industryRepo.findById(clientID).get();
		ArrayList<IndustryQuestionResponseEntity> qr = tech.getIndResponses();
		qr.get(index).setAnswer(answer);
		qr.get(index).setCheckBoxAnswer1(answer1);
		qr.get(index).setCheckBoxAnswer2(answer2);
		qr.get(index).setCheckBoxAnswer3(answer3);
		qr.get(index).setCheckBoxAnswer4(answer4);
		qr.get(index).setCheckBoxAnswer5(answer5);
		qr.get(index).setAnswerOption(answerOption);
		qr.get(index).setScore(score);
		tech.setIndResponses(qr);
		industryRepo.save(tech);
		return tech;
	}

	public IndustryResponseEntity indTextRes(int index, String answer, int clientID) {
		IndustryResponseEntity tech = industryRepo.findById(clientID)
				.orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + clientID));
		ArrayList<IndustryQuestionResponseEntity> qr = tech.getIndResponses();
		qr.get(index).setAnswer(answer);
		tech.setIndResponses(qr);
		industryRepo.save(tech);
		return tech;
	}

	public boolean indMarkQues(int index, int clientID, boolean value) {
		IndustryResponseEntity str = industryRepo.findById(clientID).get();
		ArrayList<IndustryQuestionResponseEntity> qr = str.getIndResponses();
		qr.get(index).setMarked(value);
		str.setIndResponses(qr);
		industryRepo.save(str);
		return true;
	}

	// hippa
	public List<ControlsCountEntity> hippaControlHead(String hippaHead, int clientID) {
		HippaResponseEntity ind = hippaRepo.findById(clientID).get();
		ArrayList<HippaQuestionResponseEntity> qr = ind.getHippaResponses();
		List<String> res = new ArrayList<String>();
		for (HippaQuestionResponseEntity q : qr) {
			if (q.getHead().equals(hippaHead)) {
				res.add(q.getType());
			}
		}
		Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(res);
		res.clear();
		res.addAll(primesWithoutDuplicates);
		List<ControlsCountEntity> rs = new ArrayList<ControlsCountEntity>();
		for (String e : res) {
			ControlsCountEntity c = hippaControlsCountHead(e, clientID);
			c.setName(e);
			rs.add(c);
		}
		return rs;
	}

	public ControlsCountEntity hippaControlsCountHead(String hippaHead, int clientID) {
		HippaResponseEntity cl = hippaRepo.findById(clientID).get();
		ControlsCountEntity res = new ControlsCountEntity();
		int count = 0, progress = 0;
		for (HippaQuestionResponseEntity qr : cl.getHippaResponses()) {
			if (qr.getType().equals(hippaHead)) {
				count++;
				if (qr.getAnswer().length() > 0) {
					progress++;
				}
			}
		}
		res.setCount(count);
		double f = (double) progress / count;
		f = f * 100;
		f = Math.round(f);
		res.setProgress(f);
		return res;
	}

	public HippaResponseEntity hippaControlsQuestion(String indControls, int clientID) {
		HippaResponseEntity cl = hippaRepo.findById(clientID).get();
		HippaResponseEntity res = cl;
		ArrayList<HippaQuestionResponseEntity> q = new ArrayList<HippaQuestionResponseEntity>();
		for (HippaQuestionResponseEntity qr : cl.getHippaResponses()) {
			if (qr.getType().equals(indControls)) {
				q.add(qr);
			}
		}
		res.setHippaResponses(q);
		return res;
	}

	public HippaResponseEntity hippaSaveRes(int index, String answer, int answerOption, int clientID, int score) {
		HippaResponseEntity str = hippaRepo.findById(clientID).get();
		ArrayList<HippaQuestionResponseEntity> qr = str.getHippaResponses();
		qr.get(index).setAnswer(answer);
		qr.get(index).setAnswerOption(answerOption);
		qr.get(index).setScore(score);
		str.setHippaResponses(qr);
		hippaRepo.save(str);
		return str;
	}

	public boolean hippaMarkQues(int index, int clientID, boolean value) {
		HippaResponseEntity str = hippaRepo.findById(clientID).get();
		ArrayList<HippaQuestionResponseEntity> qr = str.getHippaResponses();
		qr.get(index).setMarked(value);
		str.setHippaResponses(qr);
		hippaRepo.save(str);
		return true;
	}

	public TechnicalResponseEntity allTechnicalQuestions(int clientID) {
		TechnicalResponseEntity tech = technicalRepo.findById(clientID).get();
		return tech;
	}

	public StrategicResponseEntity allStrategicQuestions(int clientID) {
		StrategicResponseEntity str = strategicRepo.findById(clientID).get();
		return str;
	}

	public IndustryResponseEntity allIndustryQuestions(int clientID) {
		IndustryResponseEntity industry = industryRepo.findById(clientID).get();
		return industry;
	}

	public HippaResponseEntity allHippaQuestions(int clientID) {
		HippaResponseEntity hippa = hippaRepo.findById(clientID).get();
		return hippa;
	}

	public List<StrategicQuestionEntity> strategic() {
		return strategicQuestionRepo.findAll();
	}

	public List<TechnicalQuestionEntity> technical() {
		return technicalQuestionRepo.findAll();
	}

	public List<IndustryQuestionEntity> industry() {
		return industryQuestionRepo.findAll();
	}

	public List<HippaQuestionEntity> hippa() {
		return hippaQuestionRepo.findAll();
	}

	public StrategicQuestionEntity addStrategicQuestions(StrategicQuestionEntity ques)  {
		StrategicTriggerQuestionEntity trigger = strategicTriggerQuestionRepo.findByName("AddQuestionStrategic");
		int count = trigger.getCount() + 1;
		ques.setId(trigger.getCount() + 1);
		strategicQuestionRepo.save(ques);
		trigger.setCount(count);
		strategicTriggerQuestionRepo.save(trigger);
		return ques;
	}

	public TechnicalQuestionEntity addTechnicalQuestions(TechnicalQuestionEntity ques) throws Exception {
		StrategicTriggerQuestionEntity trigger = strategicTriggerQuestionRepo.findByName("AddQuestionTechnical");
		int count = trigger.getCount() + 1;
		ques.setId(trigger.getCount() + 1);
		technicalQuestionRepo.save(ques);
		trigger.setCount(count);
		strategicTriggerQuestionRepo.save(trigger);
		return ques;
	}

	public IndustryQuestionEntity addIndustryQuestions(IndustryQuestionEntity ques) throws Exception {
		StrategicTriggerQuestionEntity trigger = strategicTriggerQuestionRepo.findByName("AddQuestionIndustry");
		int count = trigger.getCount() + 1;
		ques.setId(trigger.getCount() + 1);
		industryQuestionRepo.save(ques);
		trigger.setCount(count);
		strategicTriggerQuestionRepo.save(trigger);
		return ques;
	}

	public HippaQuestionEntity addHippaQuestions(HippaQuestionEntity ques) throws Exception {
		StrategicTriggerQuestionEntity trigger = strategicTriggerQuestionRepo.findByName("AddQuestionHippa");
		int count = trigger.getCount() + 1;
		ques.setId(trigger.getCount() + 1);
		hippaQuestionRepo.save(ques);
		trigger.setCount(count);
		strategicTriggerQuestionRepo.save(trigger);
		return ques;
	}

	public StrategicQuestionEntity editStrategicQuestions(StrategicQuestionEntity str, int id) {
		StrategicQuestionEntity editStr = strategicQuestionRepo.findById(id).get();
		editStr.setQuestion(str.getQuestion());	
		editStr.setHead(str.getHead());
		editStr.setType(str.getType());
		editStr.setTeam(str.getTeam());
		editStr.setSection(str.getSection());
		editStr.setQuestionType(str.getQuestionType());
		editStr.setOptions(str.getOptions());
		editStr.setAddedNotes(str.isAddedNotes());
		return strategicQuestionRepo.save(editStr);
	}

	public TechnicalQuestionEntity editTechnicalQuestions(TechnicalQuestionEntity tech, int id) {
		TechnicalQuestionEntity editTech = technicalQuestionRepo.findById(id).get();
		editTech.setQuestion(tech.getQuestion());	
		editTech.setHead(tech.getHead());
		editTech.setType(tech.getType());
		editTech.setTeam(tech.getTeam());
		editTech.setSection(tech.getSection());
		editTech.setQuestionType(tech.getQuestionType());
		editTech.setOptions(tech.getOptions());
		editTech.setAddedNotes(tech.isAddedNotes());
		return technicalQuestionRepo.save(editTech);
	}
	
	public IndustryQuestionEntity editIndustryQuestions(IndustryQuestionEntity ind, int id) {
		IndustryQuestionEntity editIndus = industryQuestionRepo.findById(id).get();
		editIndus.setQuestion(ind.getQuestion());	
		editIndus.setIndustry(ind.getIndustry());
		editIndus.setHead(ind.getHead());
		editIndus.setType(ind.getType());
		editIndus.setTeam(ind.getTeam());
		editIndus.setSection(ind.getSection());
		editIndus.setQuestionType(ind.getQuestionType());
		editIndus.setOptions(ind.getOptions());
		editIndus.setAddedNotes(ind.isAddedNotes());
		return industryQuestionRepo.save(editIndus);
	}
	
	public HippaQuestionEntity editHippaQuestions(HippaQuestionEntity hippa, int id) {
		HippaQuestionEntity editHippa = hippaQuestionRepo.findById(id).get();
		editHippa.setQuestion(hippa.getQuestion());	
		editHippa.setHead(hippa.getHead());
		editHippa.setType(hippa.getType());
		editHippa.setAddedNotes(hippa.isAddedNotes());
		return hippaQuestionRepo.save(editHippa);
	}
	public StrategicQuestionEntity fetchStrategicDraft(int clientID) {
		StrategicQuestionEntity cl = strategicQuestionRepo.findById(clientID).get();
		return cl;
	}

	@Override
	public TechnicalQuestionEntity fetchTechnicalDraft(int clientID) {
		TechnicalQuestionEntity cl = technicalQuestionRepo.findById(clientID).get();
		return cl;
	}

	@Override
	public IndustryQuestionEntity fetchIndustryDraft(int clientID) {
		IndustryQuestionEntity cl = industryQuestionRepo.findById(clientID).get();
		return cl;
	}
	
}
