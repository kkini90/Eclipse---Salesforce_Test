/**
 * POJO to store the user object
 * @author kkini
 *
 */
public class User {
	
	private double xCord;
	private double yCord;
	
	public User(double xCord, double yCord){
		super();
		this.xCord = xCord;
		this.yCord = yCord;
	}
	
	/**
	 * @return the xCord
	 */
	public double getxCord() {
		return xCord;
	}

	/**
	 * @param xCord the xCord to set
	 */
	public void setxCord(double xCord) {
		this.xCord = xCord;
	}

	/**
	 * @return the yCord
	 */
	public double getyCord() {
		return yCord;
	}

	/**
	 * @param yCord the yCord to set
	 */
	public void setyCord(double yCord) {
		this.yCord = yCord; 
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(xCord);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yCord);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Double.doubleToLongBits(xCord) != Double.doubleToLongBits(other.xCord))
			return false;
		if (Double.doubleToLongBits(yCord) != Double.doubleToLongBits(other.yCord))
			return false;
		return true;
	}
	
	
}
