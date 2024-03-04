package entities;

public class BasePlusCommissionEmployee extends CommissionEmployee {

	private double baseSalary; // salário de base por semana

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
			double grossSales, double commissionRate, double baseSalary, Date dateLibrary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, dateLibrary);

		if (baseSalary < 0.0) // valida baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	// configura o salário-base
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) // valida baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	// retorna o salário-base continua
	public double getBaseSalary() {
		return baseSalary;
	}

	// calcula os vencimentos; sobrescreve o método earnings em CommissionEmployeeÿ
	@Override
	public double getPaymentAmount() {
		return getBaseSalary() + super.getPaymentAmount();
	}

	// retorna a representação String do objeto BasePlusCommissionEmployeeÿ
	@Override
	public String toString() {
		return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
} // fim da classe BasePlusCommissionEmployee
