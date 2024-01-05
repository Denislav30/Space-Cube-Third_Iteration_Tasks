public class Main {
    public static void main(String[] args) {
        System.out.println("Page stapling begins!");
        System.out.println();

        // Create a stapler with an initial capacity of 3 staples
        Stapler stapler = new StandardStapler(3);

        // Staple 5 pages
        stapler.staple(5);

        // Staple 10 pages
        stapler.staple(10);

        // Staple 3 pages
        stapler.staple(3);

        // Display remaining staple capacity
        System.out.println("Stapler capacity: " + stapler.getStapleCapacity());
        System.out.println();

        // Try to staple 10 more pages (should show an error message)
        stapler.staple(10);
    }
}