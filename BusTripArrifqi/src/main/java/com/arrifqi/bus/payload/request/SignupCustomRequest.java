package com.arrifqi.bus.payload.request;
import java.util.Set;
import javax.validation.constraints.*;

public class SignupCustomRequest {
    @NotBlank
	@Size(min = 3, max = 50)
	private String username;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 120)
	private String firstName;
	
	@NotBlank
	@Size(max = 120)
	private String lastName;
	
	@NotBlank
	@Size(max = 120)
	private String mobileNumber;
	
	private Set<String> role;
	
	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

    private String code;

    private String details;

    private String name;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
