package pet.coffeemash.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseItem{
	private String date;
	private String localName;
	private List<String> types;
	private Object launchYear;
	private String countryCode;
	private String name;
	private boolean fixed;
	private boolean global;
	private Object counties;
}

