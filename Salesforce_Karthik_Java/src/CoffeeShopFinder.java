import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CoffeeShopFinder {
	
	private static final String USRDIR = System.getProperty("user.dir");
	private static final String SEPARATOR = "/";
	
	/**
	 * Using customer comparator
	 */
	private static final Comparator<UserDistanceToShop> COMPARATOR = new Comparator<UserDistanceToShop>(){
		
		public int compare(UserDistanceToShop object1,UserDistanceToShop object2){
			if(object1.getDistanceToUser() < object2.getDistanceToUser()){
				return -1;
			}else if(object1.getDistanceToUser() > object2.getDistanceToUser()){
				return 1;
			}else{
				if(object1.getShopName().compareTo(object2.getShopName())<0){
					return -1;
				}else if(object1.getShopName().compareTo(object2.getShopName())>0){
					return 1;
				}else{
					return 0; 
				}
			}
		}
	};
	
	public static void main(String[] args) {
		CoffeeShopFinder  coffeeShopFinder = new CoffeeShopFinder();
		DecimalFormat decimalFormat = new DecimalFormat("#.####");
		 
		if(args.length <3){
			System.out.println("Error:Follow the format --> <userycoordinate> <userxcoordinate> <shopdatafilename>");
		}else{
			List<UserDistanceToShop> userDistanceToShop = coffeeShopFinder.find(args);
			for(UserDistanceToShop distance :userDistanceToShop){
				System.out.println(distance.getShopName() + ","+ decimalFormat.format(distance.getDistanceToUser()));
			}
		}
		
	}
	
	/**
	 * pass the arguments from command line to find() and extract suitable arguments
	 * @param args
	 * @return three nearest coffee shops
	 */
	public List<UserDistanceToShop> find(String[] args) {
		User user = createUser(args[0],args[1]);
		List<CoffeeShop> coffeeShopList = createCoffeShopList(args[2]);
		PriorityQueue<UserDistanceToShop> userDistanceToShops = getUserDistancetoShop(user, coffeeShopList);
		return threeNearShops(userDistanceToShops);
	}
	
	/**
	 * Get three nearest coffee shops
	 * @param userDistanceToShops
	 * @return list if top 3 nearest coffee shops
	 */
	private List<UserDistanceToShop> threeNearShops(PriorityQueue<UserDistanceToShop> userDistanceToShops) {
		
		return getNNearestShops(userDistanceToShops,3);
	}
	
	/**
	 * Get the N nearest coffee shops 
	 * @param userDistanceToShops
	 * @param n
	 * @return top three nearest coffee shops to user
	 */
	
	private List<UserDistanceToShop> getNNearestShops(PriorityQueue<UserDistanceToShop> userDistanceToShops,int n) {
		
		List<UserDistanceToShop> distanceToShops = new ArrayList<>();
		for(int i=1;i<=n;i++){
			if(userDistanceToShops.isEmpty()){
				break;
			}
			distanceToShops.add(userDistanceToShops.poll());
		}
		return distanceToShops;
	}
	
	/**
	 * 
	 * @param user
	 * @param coffeeShopList
	 * @return distance of shops from user
	 */
	private PriorityQueue<UserDistanceToShop> getUserDistancetoShop(User user, List<CoffeeShop> coffeeShopList) {
		PriorityQueue<UserDistanceToShop> userDistanceToShops = new PriorityQueue<>(COMPARATOR);
		for(CoffeeShop coffeeShop : coffeeShopList){
			userDistanceToShops.add(getEuclidDistance(user, coffeeShop));
		}
		return userDistanceToShops;
	}
	
	/**
	 * Calculates the distance from user to each of coffee shops
	 * @param user
	 * @param coffeeShop
	 * @return UserDistanceToShop
	 */
	private UserDistanceToShop getEuclidDistance(User user, CoffeeShop coffeeShop) {
		
		double euclidDistance = Math.sqrt(Math.pow(user.getxCord() - coffeeShop.getxCord(),2) + 
				Math.pow(user.getyCord() - coffeeShop.getyCord(),2));
		return new UserDistanceToShop(coffeeShop.getCoffeeShopName(),euclidDistance);
	}
	
	/**
	 * Returns a list of coffee
	 * File name is relative
	 * @param fileName
	 * @return list of coffee shop
	 */
	private List<CoffeeShop> createCoffeShopList(String fileName) {
		String filePath = USRDIR+SEPARATOR+fileName;
		List<CoffeeShop> coffeeShopList = FileReader.readCSVFile(filePath);
		return coffeeShopList;
	}

	/**
	 * Create a user POJO
	 * @param yCord
	 * @param xCord
	 * @return User Object
	 */
	private User createUser(String yCord, String xCord) {
		
		return new User(Double.parseDouble(yCord),Double.parseDouble(xCord));
	}

}
