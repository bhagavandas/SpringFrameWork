package com.example.demo;

public class ResponseEntity {
	
	Object obj;
	String msg;
	
	public ResponseEntity(Object obj, String msg) {
		
		this.obj = obj;
		this.msg = msg;
	}
	
	public ResponseEntity() {
		
	}
	
	
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
