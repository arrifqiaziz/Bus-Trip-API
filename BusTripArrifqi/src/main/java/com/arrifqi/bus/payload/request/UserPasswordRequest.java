package com.arrifqi.bus.payload.request;
import io.swagger.annotations.ApiModelProperty;

public class UserPasswordRequest {
    @ApiModelProperty(hidden = true)
	private Long id;

    private String password;

    public UserPasswordRequest() {
	}

	public UserPasswordRequest(String password) {
		this.password = password;
	}

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
