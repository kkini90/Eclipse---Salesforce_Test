import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the CoffeeShops.CSV file 
 * path for the file is relative
 * @author kkini
 *
 */
public class FileReader {
	
	private static final String LINE_SEPARATOR= System.getProperty("line.separator");
	private static final String FILE_SEPARATOR= ",";
	
	/**
	 * Check if I can read the file correctly 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(readCSVFile(System.getProperty("user.dir") + "/CoffeeShops.csv"));
	}

	/**
	 * Marshall list of coffee shop objects
	 * @param filePath
	 * @return coffee shop list
	 */
	public static List<CoffeeShop> readCSVFile(String filePath) {
		List<CoffeeShop> coffeeShopList = new ArrayList<>();
		String fileContent = readFile(filePath);
		try{
			String[] coffeeStrings = fileContent.split(LINE_SEPARATOR);
			for(String coffeeString : coffeeStrings){
				String[] shopValues = coffeeString.split(FILE_SEPARATOR);
				coffeeShopList.add(new CoffeeShop(shopValues[0], Double.parseDouble(shopValues[1]), Double.parseDouble(shopValues[2])));
			}
		}catch(Exception e){
			System.out.println("Cannot read CSV file as it is Malformed " +e.getMessage());
		}
		
		return coffeeShopList;
	}
	
	/**
	 * Read file as string blob
	 * @param filePath
	 * @return file as string
	 */
	private static String readFile(String filePath) {
		File file = new File(filePath);
		String fileElements;
		FileInputStream in = null;
		
		if(file.exists()){
			try {
				in = new FileInputStream(file);
				byte[] fileBytes =  new byte[(int)file.length()];
				in.read(fileBytes);
				fileElements = new String(fileBytes);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				fileElements = "";
			} catch(IOException io){
				io.printStackTrace();
				fileElements = "";
			}
		}else{
			fileElements="";
		}
		return fileElements;
	}

}
