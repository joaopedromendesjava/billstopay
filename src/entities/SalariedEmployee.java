package entities;

public class SalariedEmployee extends Employee {

	private double weeklySalary;

	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary,
			Date dateLibrary) {
		super(firstName, lastName, socialSecurityNumber, dateLibrary);

		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");

		this.weeklySalary = weeklySalary;
	}

	// configura o salário
	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");

		this.weeklySalary = weeklySalary;
	}

	// retorna o salário
	public double getWeeklySalary() {
		return weeklySalary;
	}

	// calcula os rendimentos; sobrescreve o método earnings em Employee
	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}

	// retorna a representação String do objeto SalariedEmployee 
	@Override
	public String toString() {
		return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
	}
} // fim da classe SalariedEmployee
