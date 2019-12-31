package com.bw.entity;

public class Goods {

	private int gid;
	private String gname;
	private String gnames;
	private int size;
	private int money;
	private int num;
	private String inss;
	private String image;
	private int bid;
	private int kid;
	private String bname;
	private String kname;
	private int status;
	
		
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gnames=" + gnames + ", size=" + size + ", money=" + money
				+ ", num=" + num + ", inss=" + inss + ", image=" + image + ", bid=" + bid + ", kid=" + kid + ", bname="
				+ bname + ", kname=" + kname + ", status=" + status + "]";
	}


	
	public Goods(int gid, String gname, String gnames, int size, int money, int num, String inss, String image, int bid,
			int kid, String bname, String kname, int status) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gnames = gnames;
		this.size = size;
		this.money = money;
		this.num = num;
		this.inss = inss;
		this.image = image;
		this.bid = bid;
		this.kid = kid;
		this.bname = bname;
		this.kname = kname;
		this.status = status;
	}



	public int getGid() {
		return gid;
	}



	public void setGid(int gid) {
		this.gid = gid;
	}



	public String getGname() {
		return gname;
	}



	public void setGname(String gname) {
		this.gname = gname;
	}



	public String getGnames() {
		return gnames;
	}



	public void setGnames(String gnames) {
		this.gnames = gnames;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public int getMoney() {
		return money;
	}



	public void setMoney(int money) {
		this.money = money;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getInss() {
		return inss;
	}



	public void setInss(String inss) {
		this.inss = inss;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public int getBid() {
		return bid;
	}



	public void setBid(int bid) {
		this.bid = bid;
	}



	public int getKid() {
		return kid;
	}



	public void setKid(int kid) {
		this.kid = kid;
	}



	public String getBname() {
		return bname;
	}



	public void setBname(String bname) {
		this.bname = bname;
	}



	public String getKname() {
		return kname;
	}



	public void setKname(String kname) {
		this.kname = kname;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public Goods() {
		super();
	}

	
}
