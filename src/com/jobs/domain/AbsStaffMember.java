package com.jobs.domain;

public abstract class AbsStaffMember {

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;

	private static int COUNTER_MEMBERS = 1;

	public AbsStaffMember(String name, String address, String phone) throws Exception {
		if (name.equals(""))
			throw new Exception();
		if (address.equals(""))
			throw new Exception();
		if (phone.equals(""))
			throw new Exception();

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = COUNTER_MEMBERS; 
		COUNTER_MEMBERS++;
	}

	public abstract void pay();
	
	// Definir mètode "getter" staffmember que retorni un String amb el nom, adreça i telèfon
	public String staffmember() {
		String staffmember = "Name: " + name + "; Address: " + address + "; Phone: " + phone;
		return staffmember;
	}
}
