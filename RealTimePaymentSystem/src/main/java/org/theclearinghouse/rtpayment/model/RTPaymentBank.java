package org.theclearinghouse.rtpayment.model;

public class RTPaymentBank {
	private int ID;
	private String bankName;
	private String type;
	private String state;
	private String city;
	private int zipCode;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public RTPaymentBank(int ID, String bankName, String type, String state, String city, int zipCode) {
		this.ID = ID;
		this.bankName = bankName;
		this.type = type;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
	}

	public String toString() {
		return String.format("%-3d -%20s -%8s -%17s -%4s %6d", getID(), getBankName(), getType(), getState(), getCity(),
				getZipCode());
	}
}
