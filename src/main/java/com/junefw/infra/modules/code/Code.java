package com.junefw.infra.modules.code;

public class Code {  // 쿼리는 부르는 함수들임
	

//------------ dto 영역
	private String ifcgSeq;
	private String ifcgName;
	private Integer ifcgDelNy;    // Integer은 Null 가능한데 int 는 불가함
	
//------------
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public Integer getIfcgDelNy() {
		return ifcgDelNy;
	}
	public void setIfcgDelNy(Integer ifcgDelNy) {
		this.ifcgDelNy = ifcgDelNy;
	}
	
	
}