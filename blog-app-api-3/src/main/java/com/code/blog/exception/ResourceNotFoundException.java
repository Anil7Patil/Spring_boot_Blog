package com.code.blog.exception;

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fildName;
	long fildValue;
	public ResourceNotFoundException(String resourceName, String fildName, long fildValue) {
		super(String.format("%s user not found with %s : %s",resourceName,fildName,fildValue));
		this.resourceName = resourceName;
		this.fildName = fildName;
		this.fildValue = fildValue;
		
		
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFildName() {
		return fildName;
	}
	public void setFildName(String fildName) {
		this.fildName = fildName;
	}
	public long getFildValue() {
		return fildValue;
	}
	public void setFildValue(long fildValue) {
		this.fildValue = fildValue;
	}
	
	
}
