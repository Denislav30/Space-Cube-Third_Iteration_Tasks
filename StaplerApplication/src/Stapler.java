public interface Stapler {
    // Staple method
    void staple(int numPages);

    // Get staple capacity method
    int getStapleCapacity();

    // Reload staples method
    void reloadStaples(int newCapacity);

    // Check if stapling is possible method
    boolean canStaple();
}
