public class MyArrayDataException extends IllegalArgumentException{
  private final int[]  indexes;

  public MyArrayDataException(String message, int[] indexes) {
      super(message);
      this.indexes=indexes;
  }

  public int[] getIndexes() {
    return indexes;
  }
}
