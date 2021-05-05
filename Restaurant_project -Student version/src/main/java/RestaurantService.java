import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class RestaurantService {
    private static final List<Restaurant> restaurants = new ArrayList();

    public RestaurantService() {
    }

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        Iterator var2 = restaurants.iterator();

        Restaurant restaurant;
        do {
            if (!var2.hasNext()) {
                throw new restaurantNotFoundException(restaurantName);
            }
            restaurant = (Restaurant)var2.next();
        } while(!restaurant.getName().equals(restaurantName));

        return restaurant;
    }
    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }
    public void removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = this.findRestaurantByName(restaurantName);
        if (restaurantToBeRemoved == null) {
            throw new restaurantNotFoundException(restaurantName);
        } else {
            restaurants.remove(restaurantToBeRemoved);
        }
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
