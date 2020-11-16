package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {
	
	// Instanciar repository
	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}
	
	// Definir mètode createManagerEmployee
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}

	// Crear llista amb tots els membres de repository i passar el mètode pay() a cada un d'ells
	public void payAllEmployeers() {
		List<AbsStaffMember> allmembers = repository.getAllMembers();
		for(AbsStaffMember member:allmembers) {
			member.pay();
		}
	
	}

	// Crear llista amb tots els membres de repository, passar el mètode staffmember() a cada un d'ells,
	// guardar cada String a un Array i després passar aquest Array a un sol String
	public String getAllEmployees() {
		List<AbsStaffMember> allmembers = repository.getAllMembers();
		String[] allnames = new String[allmembers.size()];
		for(int i=0; i<allmembers.size(); i++) {
			allnames[i] = allmembers.get(i).staffmember();
		}
		String printnames = String.join("\n", allnames);
		return printnames;
	}
	
	// Definir mètode createVolunteer
	public void createVolunteer(String name, String address, String phone, String description) throws Exception{
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);		
	}
	
	
}
