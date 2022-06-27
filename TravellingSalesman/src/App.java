public class App {
    public static void main(String[] args){
        //You can change start city //
        //Start city index must be 0-80//
        int startCity =0;
        Algorithms algorithms = new Algorithms(startCity);
        System.out.print("ArbitraryInsertion: ");
        algorithms.arbitraryInsertion();
        System.out.print("\nCheapestInsertion: ");
        algorithms.cheapestInsertion();
        System.out.print("\nFarthestInsertion: ");
        algorithms.farthestInsertion();
        System.out.print("\nNearestInsertion: ");
        algorithms.nearestInsertion();
        System.out.print("\nNearestNeighbor: ");
        algorithms.nearestNeighboor();
    }
}
