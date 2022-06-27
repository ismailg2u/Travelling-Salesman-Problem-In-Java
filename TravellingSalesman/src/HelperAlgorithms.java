import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class HelperAlgorithms {
    private TurkishNetwork turkishNetwork = new TurkishNetwork();
    private String[] cities = turkishNetwork.getCities();
    private int[][] distances = turkishNetwork.getDistances();


    public  int nearestCityIndex(int cityIndex){
        int distanceBetweenTwoCity = 2000;
        int nearestIndex=8888;
        for (int j = 0; j < cities.length; j++) {
            if(distanceBetweenTwoCity>distances[cityIndex][j]&&cityIndex!=j){
                distanceBetweenTwoCity=distances[cityIndex][j];
                nearestIndex=j;
            }
        }
        return nearestIndex;
    }

    public int tourDistance(List<Integer> list){
        int tourDistance = 0;
        for (int j = 1; j < list.size(); j++) {
            tourDistance+=distances[list.get(j-1)][list.get(j)];
        }
        return tourDistance;
    }
    public List<String> getCityNamesInTour(List<Integer> list){
        List<String> cityList = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
         cityList.add(cities[list.get(i)]);
        }
        return cityList;

    }





}
