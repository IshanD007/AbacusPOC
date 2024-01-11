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
public class RoleDto {
	
    private Integer id;
    private String roleName;
    
    public RoleDto() {
		// TODO Auto-generated constructor stub
	}
    
	public RoleDto(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
