public class StandardStapler implements Stapler {

    private int capacity;

    // Constructor
    public StandardStapler(int capacity) {
        this.capacity = capacity;
    }

    // Staple method
    @Override
    public void staple(int numPages) {
        // Check if stapling is possible
        if (canStaple() && capacity > 0) {
            System.out.println("Stapling " + numPages + " pages using one staple.");
            capacity -= 1;
        } else {
            System.out.println("ERROR: Insufficient staples or stapler capacity exceeded!");
        }
    }

    // Get staple capacity method
    @Override
    public int getStapleCapacity() {
        return capacity;
    }

    // Reload staples method
    @Override
    public void reloadStaples(int newCapacity) {
        System.out.println("Stapler is reloading...");
        capacity = newCapacity;
        System.out.println("Stapler is ready to use with a capacity of: " + capacity + " staples.");
    }

    // Check if stapling is possible method
    @Override
    public boolean canStaple() {
        // Check if there are staples left
        if (capacity > 0) {
            System.out.println("Stapler capacity: " + capacity);
            System.out.println();
            return true;
        } else {
            System.out.println("ERROR: No staples left. Please reload!");
            return false;
        }
    }
}