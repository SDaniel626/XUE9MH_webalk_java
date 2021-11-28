package hu.me.iit.webalk.demo.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaveLicitDto {
	@NotNull
	@Min(1)
	private Integer licit;
	@NotNull
	@Min(1)
	private Integer userId;
	
	
	public Integer getLicit() {
		return licit;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setLicit(Integer licit) {
		this.licit = licit;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
