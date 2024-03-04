package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.BasePlusCommissionEmployee;
import entities.CommissionEmployee;
import entities.Date;
import entities.Employee;
import entities.HourlyEmployee;
import entities.Invoice;
import entities.Payable;
import entities.PieceWorker;
import entities.SalariedEmployee;

public class PayrollSystem {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		
		// cria objetos de subclasse e implementações
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00,
				new Date(3, 1, 2002));
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222",
				new Date(2, 1, 2002), 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333",
				10000, .06, new Date(2, 1, 2002));
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob",
				"Lewis", "444-44-4444", 5000, .04, 300, new Date(3, 1, 2002));
		PieceWorker pieceWorkerLibrary = new PieceWorker("João Pedro", "Mendes Silva",
				"777-77-777", new Date(1, 2, 2002), 2.90, 150);
		Invoice invoice = new Invoice("01234", "seat", 2, 375.00);
		
		System.out.println("Employees processed individually:");

		System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.getPaymentAmount());
		System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.getPaymentAmount());
		System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.getPaymentAmount());
		System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned",
				basePlusCommissionEmployee.getPaymentAmount());
		System.out.printf("%s%n%s: $%,.2f%n%n", pieceWorkerLibrary, "earned", pieceWorkerLibrary.getPaymentAmount());
		System.out.printf("%s%n%s: $%,.2f%n%n", invoice, "earned", invoice.getPaymentAmount());
		// cria um arrayList Payable 
		List<Payable> payables = new ArrayList<>();
		
		// adiciona na lista
		payables.add(salariedEmployee);
		payables.add(hourlyEmployee);
		payables.add(commissionEmployee);
		payables.add(basePlusCommissionEmployee);
		payables.add(pieceWorkerLibrary);
		payables.add(invoice);
		
		
		System.out.printf("Employees processed polymorphically:%n%n");

		// processa genericamente cada elemento no payable
		for (Payable currentPayable : payables) {
			System.out.println(currentPayable); // invoca toString

			if (currentPayable instanceof Employee) {
				Employee currentEmployee = (Employee) currentPayable;
				
				if(currentEmployee instanceof BasePlusCommissionEmployee) {
					BasePlusCommissionEmployee baseComEmployee =	(BasePlusCommissionEmployee) currentEmployee;
					
					baseComEmployee.setBaseSalary(1.10 * baseComEmployee.getBaseSalary());
					System.out.printf("new base salary with 10%% increase is: "
							+ "$%,.2f%n", baseComEmployee.getPaymentAmount());
					
					if(date.getMonth().getValue() == (currentEmployee.getBirthDate().getMonth())) {
						double earning = baseComEmployee.getPaymentAmount() + 100.00;
						System.out.printf("with birthday salary bonus $%,.2f%n%n", earning);
					}else {
						System.out.printf("earned $%,.2f%n%n", baseComEmployee.getPaymentAmount());
					}
					
				}else if(date.getMonth().getValue() == (currentEmployee.getBirthDate().getMonth())) {
					
					double earning = currentEmployee.getPaymentAmount() + 100.00;
					System.out.printf("with birthday salary bonus $%,.2f%n%n", earning);
				}else {
					System.out.printf("earned $%,.2f%n%n", currentEmployee.getPaymentAmount());
				}
			}
			else {
				System.out.printf("earned $%,.2f%n%n", currentPayable.getPaymentAmount());
			}
		} 
	} 
} 
