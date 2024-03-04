package entities;

public abstract class Employee implements Payable {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private Date birthDate;

	// construtor
	public Employee(String firstName, String lastName, String socialSecurityNumber, Date dateLibrary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = dateLibrary;
	}

	// retorna o nome
	public String getFirstName() {
		return firstName;
	}

	// retorna o sobrenome
	public String getLastName() {
		return lastName;
	}

	// retorna o número do seguro social
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	// retorna a representação de String do objeto Employee
	@Override
	public String toString() {
		return String.format("%s %s%nsocial security number: %s %s", getFirstName(), getLastName(),
				getSocialSecurityNumber(), getBirthDate());
	}

} // fim da classe abstrata Employee
