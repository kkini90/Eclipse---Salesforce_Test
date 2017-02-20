/**
 * POJO to store Coffeeshop object
 * which has coffee name, x and y co-ordinates
 * @author kkini
 *
 */
public class CoffeeShop {
	private String coffeeShopName;
	private double xCord;
	private double yCord; 
	
	public CoffeeShop(String coffeeShopName,double xCord,double yCord){
		super();
		this.coffeeShopName = coffeeShopName;
		this.xCord = xCord;
		this.yCord = yCord;
	}
	
	/**
	 * @return the coffeeShopName
	 */
	public String getCoffeeShopName() {
		return coffeeShopName;
	}

	/**
	 * @param coffeeShopName the coffeeShopName to set
	 */
	public void setCoffeeShopName(String coffeeShopName) {
		this.coffeeShopName = coffeeShopName;
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
		result = prime * result + ((coffeeShopName == null) ? 0 : coffeeShopName.hashCode());
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
		CoffeeShop other = (CoffeeShop) obj;
		if (coffeeShopName == null) {
			if (other.coffeeShopName != null)
				return false;
		} else if (!coffeeShopName.equals(other.coffeeShopName))
			return false;
		if (Double.doubleToLongBits(xCord) != Double.doubleToLongBits(other.xCord))
			return false;
		if (Double.doubleToLongBits(yCord) != Double.doubleToLongBits(other.yCord))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return "CoffeeShopName ["+coffeeShopName+" ,xCord =" + xCord + " ,yCord =" + yCord +"]" ;
	}
	
	
}
