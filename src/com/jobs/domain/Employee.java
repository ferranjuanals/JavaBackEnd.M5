package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}
	
	// Sobreescriure mètode "getter" staffmember afegint el salari i el total pagat
	@Override
	public String staffmember() {
		String staffmember = super.staffmember() + "; Phone: " + phone + "; Salary: " + salaryPerMonth + "€; Paid: " + totalPaid + "€";
		return staffmember;
	}

}
