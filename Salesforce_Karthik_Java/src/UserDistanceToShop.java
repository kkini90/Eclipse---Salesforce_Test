/**
 * POJO which has shop name and shop to user distance
 * @author kkini
 *
 */
public class UserDistanceToShop {
	private String shopName;
	private double distanceToUser;
	
	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the distanceToUser
	 */
	public double getDistanceToUser() {
		return distanceToUser;
	}

	/**
	 * @param distanceToUser the distanceToUser to set
	 */
	public void setDistanceToUser(double distanceToUser) {
		this.distanceToUser = distanceToUser;
	}

	
	
	public UserDistanceToShop(String shopName,double distanceToUser){
		this.shopName = shopName;
		this.distanceToUser = distanceToUser;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distanceToUser);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((shopName == null) ? 0 : shopName.hashCode());
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
		UserDistanceToShop other = (UserDistanceToShop) obj;
		if (Double.doubleToLongBits(distanceToUser) != Double.doubleToLongBits(other.distanceToUser))
			return false;
		if (shopName == null) {
			if (other.shopName != null)
				return false;
		} else if (!shopName.equals(other.shopName))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return shopName + "," + distanceToUser;
	}
	
}
