// Custom exception for handling invalid stock operations
public class InvalidStockException extends Exception {
    public InvalidStockException(String message) {
        super(message);
    }
}