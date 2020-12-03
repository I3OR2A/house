package com.mooc.house.common.model;


import java.util.Date;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class User {

	private Long id;
	
	private String email;
	
	private String phone;
	
	private String name;
}
