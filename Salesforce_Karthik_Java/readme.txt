Run the application in run -> run configurations -> arguments
47.6 -122.4 CoffeeShops.csv

Assumption :
CSV file will be the relative path of the program as mentioned in the comment section of code.

Description of the class:
1.User.java POJO
Represent user as an object which has  x and y co-ordinates of user location

2.Coffeshop.java POJO
Represent coffee shop as an object which has coffee shop name and x , y co-ordinates of shop location

3.UserDistanceToShop.java POJO
Contains  shop name and distance of each shop from user.

4.FileReader.java
This class reads the csv file containing coffee shop name and x,y co-ordinates of shop and returns list of coffee shops

5.CoffeeShopFinder.java
This class calculates the top n (my case its 3) nearest coffee shops to the user.

Time complexity of the algorithm is (nlogn)
Basic idea behind this logic is we are using priority queue where we are inserting list of UserDistanceToShop pojo. The priority queue sorts the 
coffee shop based on the distance calculated from the user location where we are using custom comparator and we are picking the top N coffee shops

We iterate over the list of coffee shops calculating the distance of each shop from user which takes O(n) time ,n is no of coffee shops.And then we select 
top 3 coffee shops after sorting ( nearest to fartest).

Time complexity is O(nlogn), as priority queue takes O(nlogn) time to sort the elements.    

