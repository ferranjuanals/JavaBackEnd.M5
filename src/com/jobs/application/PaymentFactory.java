package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				// Tornar el salari amb una reducci� del 15% 
				return salaryPerMonth*0.85;
			}
		};
	}
	
	// Definir m�tode createPaymentRateManager
	public static IPaymentRate createPaymentRateManager() {
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				// Tornar el salari amb un 10% m�s
				return salaryPerMonth*1.1;
			}
		};
	}
}
