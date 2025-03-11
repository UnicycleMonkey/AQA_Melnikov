public class MyArraySizeException extends IllegalArgumentException {
  private final int  currentSize;
  public MyArraySizeException(String message, int size) {
    super(message);
    currentSize=size;
  }

  public int getArrayCurrentSize() {
    return currentSize;
  }
}
