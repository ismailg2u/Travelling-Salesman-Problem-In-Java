
import java.util.ArrayList;
import java.util.List;

public class Algorithms {
    private HelperAlgorithms helperAlgorithms = new HelperAlgorithms();
    private int cityIndex;
    private TurkishNetwork turkishNetwork = new TurkishNetwork();
    private String[] cities = turkishNetwork.getCities();
    private int[][] distances = turkishNetwork.getDistances();

    public Algorithms(int cityIndex){
        this.cityIndex = cityIndex;
    }
    public  void arbitraryInsertion(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(cityIndex);
        list.add(helperAlgorithms.nearestCityIndex(cityIndex));
        list.add(cityIndex);
        while(list.size()!=82) {
            int cityIndexToBeAdded = 0;
            int currentDistance = 0;
            int previousDistance = 200000;
            int indexThatWhereToAdded = 1;
            boolean truth1=true;
            int randomCity = (int)(Math.random() * 81);
            for (int i = 1; i < list.size() - 1; i++) {
                truth1=true;
                for (int j = 0; j < cities.length; j++) {


                    for (int k = 0; k < list.size(); k++) {
                        if (randomCity == list.get(k)) {
                            truth1=false;
                            break;

                        } else truth1=true;

                    }
                    if(truth1){
                        list.add(i, randomCity);
                        currentDistance = helperAlgorithms.tourDistance(list);
                        if (currentDistance < previousDistance) {
                            previousDistance = currentDistance;
                            indexThatWhereToAdded = i;
                            cityIndexToBeAdded = randomCity;
                        }

                        list.remove(i);

                    }

                }

            }
            if (truth1){
                list.add(indexThatWhereToAdded, cityIndexToBeAdded);}
        }
        System.out.print("Total distance:" + helperAlgorithms.tourDistance(list)+"km Tour:"+"[");
        for (int f = 0; f < list.size(); f++) {
            System.out.print(list.get(f)+"-");
        }
        System.out.print("]\nCity Names:");
        for(int i = 0;i<list.size();i++){
            System.out.print(helperAlgorithms.getCityNamesInTour(list).get(i)+"-");
        }
        System.out.println("");


    }
    public  void cheapestInsertion(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(cityIndex);
        list.add(helperAlgorithms.nearestCityIndex(cityIndex));
        list.add(cityIndex);
        while(list.size()!=82) {
            int cityIndexToBeAdded = 0;
            int currentDistance = 0;
            int previousDistance = 200000;
            int indexThatWhereToAdded = 1;
            boolean truth1=true;
            for (int i = 1; i < list.size() - 1; i++) {
                truth1=true;
                for (int j = 0; j < cities.length; j++) {
                    for (int k = 0; k < list.size(); k++) {
                        if (j == list.get(k)) {
                            truth1=false;
                            break;

                        } else truth1=true;

                    }
                    if(truth1){
                        list.add(i, j);
                        currentDistance = helperAlgorithms.tourDistance(list);
                        if (currentDistance < previousDistance) {


                            previousDistance = currentDistance;
                            indexThatWhereToAdded = i;
                            cityIndexToBeAdded = j;


                        }

                        list.remove(i);

                    }

                }

            }
            list.add(indexThatWhereToAdded, cityIndexToBeAdded);
        }
        System.out.print("Total distance:"+helperAlgorithms.tourDistance(list)+"km Tour:"+"[");
        for (int f = 0; f < list.size(); f++) {
            System.out.print(list.get(f)+"-");
        }
        System.out.print("]\nCity Names:");
        for(int i = 0;i<list.size();i++){
            System.out.print(helperAlgorithms.getCityNamesInTour(list).get(i)+"-");
        }
        System.out.println("");
    }
    public  void farthestInsertion(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(cityIndex);
        list.add(helperAlgorithms.nearestCityIndex(cityIndex));
        list.add(cityIndex);

        int currentCity=0;
        int cityIndexToBeAdded = 77;
        int currentDistance=2000;
        while(list.size()!=82){
            currentDistance=0;
            for (int i = 0 ;i < list.size(); i++) {
                currentCity = list.get(i);

                for (int j = 0; j <cities.length; j++) {
                    if (currentDistance<distances[currentCity][j]&&currentCity!=j){
                        boolean truth=true;
                        for (int k = 0; k < list.size(); k++) {
                            if(j==list.get(k)){
                                truth = false;
                            }
                            else;

                        }
                        if(truth){
                            currentDistance = distances[currentCity][j];
                            cityIndexToBeAdded = j;}

                    }
                }

            }

            int currentTourDistance = 0;
            int prevTourDistance = 200000;
            int indexThatWhereToAdded=0;

            for (int i = 1; i < list.size()-1; i++) {
                list.add(i,cityIndexToBeAdded);
                currentTourDistance = helperAlgorithms.tourDistance(list);
                if (currentTourDistance==0||currentTourDistance<prevTourDistance){
                    prevTourDistance=currentTourDistance;
                    indexThatWhereToAdded=i;}
                list.remove(i);
            }
            list.add(indexThatWhereToAdded,cityIndexToBeAdded);}
        System.out.print("Total distance:"+helperAlgorithms.tourDistance(list)+"km Tour:"+"[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"-");
        }
        System.out.print("]\nCity Names:");
        for(int i = 0;i<list.size();i++){
            System.out.print(helperAlgorithms.getCityNamesInTour(list).get(i)+"-");
        }
        System.out.println("");
    }
    public void nearestInsertion(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(cityIndex);
        list.add(helperAlgorithms.nearestCityIndex(cityIndex));
        list.add(cityIndex);
        int currentCity=0;
        int cityIndexToBeAdded = 77;
        int currentDistance=2000;
        while(list.size()!=82){
            currentDistance=2000;
            for (int i = 0 ;i < list.size(); i++) {
                currentCity = list.get(i);

                for (int j = 0; j <cities.length; j++) {
                    if (currentDistance>distances[currentCity][j] &&currentCity!=j){
                        boolean truth=true;
                        for (int k = 0; k < list.size(); k++) {
                            if(j==list.get(k)){
                                truth = false;
                            }
                            else;

                        }
                        if(truth){
                            currentDistance = distances[currentCity][j];
                            cityIndexToBeAdded = j;}

                    }
                }

            }

            int currentTourDistance = 0;
            int prevTourDistance = 200000;
            int indexThatWhereToAdded=0;

            for (int i = 1; i < list.size()-1; i++) {
                list.add(i,cityIndexToBeAdded);
                currentTourDistance = helperAlgorithms.tourDistance(list);
                if (currentTourDistance==0||currentTourDistance<prevTourDistance){
                    prevTourDistance=currentTourDistance;
                    indexThatWhereToAdded=i;}
                list.remove(i);
            }
            list.add(indexThatWhereToAdded,cityIndexToBeAdded);}
        System.out.print("Total distance:"+helperAlgorithms.tourDistance(list)+"km Tour:"+"[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"-");
        }
        System.out.print("]\nCity Names:");
        for(int i = 0;i<list.size();i++){
            System.out.print(helperAlgorithms.getCityNamesInTour(list).get(i)+"-");
        }
        System.out.println("");
    }

    public void nearestNeighboor(){
        List<Integer> list = new ArrayList<Integer>();
        int currentDistance=2000;
        int cityIndexToBeAdded=1000;
        list.add(cityIndex);
        for (int i = cityIndex; i < cities.length; i++) {

            for (int j = 0; j < cities.length; j++) {

                if (currentDistance>distances[i][j]&&i!=j){
                    boolean truth=true;
                    for (int k = 0; k < list.size(); k++) {
                        if(j==list.get(k)){
                            truth = false;
                        }
                        else;
                    }
                    if(truth){
                        currentDistance = distances[i][j];
                        cityIndexToBeAdded = j;}
                }
                else;
            }
            list.add(cityIndexToBeAdded);
            currentDistance=2000;
            i=cityIndexToBeAdded-1;
            if(list.size()==81){
                list.add(cityIndex);
                System.out.print("Total distance:"+helperAlgorithms.tourDistance(list)+"km Tour:"+"[");
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j)+"-");
                }
                System.out.print("]\nCity Names:");
                for(int k = 0;k<list.size();k++){
                    System.out.print(helperAlgorithms.getCityNamesInTour(list).get(k)+"-");
                }
                System.out.println("");
                break;
            }
        }
    }
}
