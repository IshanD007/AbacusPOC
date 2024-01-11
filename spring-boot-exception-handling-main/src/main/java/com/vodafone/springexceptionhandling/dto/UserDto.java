package com.vodafone.springexceptionhandling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	private int id;
	private String firstName;
    private String lastName;
    private String userCode;
    private String userCompany;
    private String userDepartment;
    private String userEmail;
    private RoleDto role;
    
    public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String firstName, String lastName, String userCode, String userCompany, String userDepartment) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userCode = userCode;
		this.userCompany = userCompany;
		this.userDepartment = userDepartment;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}
}
