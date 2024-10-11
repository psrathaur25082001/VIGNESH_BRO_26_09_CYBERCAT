package com.cybercat.user.service;

import java.util.List;

import com.cybercat.user.entity.LatestActiveEntity;

public interface LatestActiveService {

	List<LatestActiveEntity> getLatestActive();

	LatestActiveEntity createLatestActive(LatestActiveEntity latest);

}
