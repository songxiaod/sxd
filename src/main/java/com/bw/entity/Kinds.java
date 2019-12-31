package com.bw.entity;

public class Kinds {

	private int kid;
	private String kname;
	@Override
	public String toString() {
		return "Kinds [kid=" + kid + ", kname=" + kname + "]";
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public Kinds(int kid, String kname) {
		super();
		this.kid = kid;
		this.kname = kname;
	}
	public Kinds() {
		super();
	}
	
	
}
