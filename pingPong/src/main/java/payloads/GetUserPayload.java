package payloads;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class GetUserPayload {

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("name")
    private String name;

    @JsonProperty("salary")
    private int salary;

    @JsonProperty("surname")
    private String surname;

}
