package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("com.robohorse.robopojogenerator")
public class BodyResponse {

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("salary")
	private int salary;

	@JsonProperty("name")
	private String name;

	@JsonProperty("surname")
	private String surname;
}