package com.cybercat.user.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Response {

	public int responseCode;
	public String message;
	public boolean status;
	public Object responsedata;
}

