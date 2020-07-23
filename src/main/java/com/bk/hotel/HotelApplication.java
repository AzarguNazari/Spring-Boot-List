package com.bk.hotel;

import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) throws IOException {
		String s = Files.probeContentType(Paths.get("profile.jpg.png"));
		System.out.println(s);
		MimeType m = MimeTypeUtils.APPLICATION_OCTET_STREAM;

		System.out.println("type:    " + type.getType());
		System.out.println("subtype: " + type.getSubtype());
		//SpringApplication.run(HotelApplication.class, args);
	}
	
//	@Bean
//	public List<String> roomTypes(){
//		return Arrays.asList("Single", "Double", "Suite");
//	}
}
