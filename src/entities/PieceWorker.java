package entities;

public class PieceWorker extends Employee {

	private double wage;
	private int pieces;
	
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, Date dateLibrary,
				double wage, int pieces) {
		super(firstName, lastName, socialSecurityNumber, dateLibrary);
	
		if(pieces < 0 || wage < 0) {
			throw new IllegalArgumentException("values must be >= 0");
		}
		this.pieces = pieces;
		this.wage = wage;
		
	}
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if(wage < 0) {
			throw new IllegalArgumentException("values must be >= 0");
		}
		this.wage = wage;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		if(pieces < 0) {
			throw new IllegalArgumentException("values must be >= 0");
		}
		this.pieces = pieces;
	}

	@Override
	public double getPaymentAmount() {
		return getWage() * getPieces();
	}

	@Override
	public String toString() {
		return String.format("Piece Worker Employee: %s%n%s: $%,.2f; %s: %d", super.toString(), "wage for piece", getWage(),
				"quantity piece", getPieces());
	}

	
}
