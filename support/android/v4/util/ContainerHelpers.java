package support.android.v4.util;

public class ContainerHelpers
{
  public static final int[] EMPTY_INTS = new int[0];
  public static final long[] EMPTY_LONGS = new long[0];
  public static final Object[] EMPTY_OBJECTS = new Object[0];
  
  public ContainerHelpers() {}
  
  public static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramInt1 -= 1;
    int i = 0;
    while (i <= paramInt1)
    {
      int j = i + paramInt1 >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2) {
        i = j + 1;
      } else if (k > paramInt2) {
        paramInt1 = j - 1;
      } else {
        return j;
      }
    }
    return i;
  }
  
  public static int binarySearch(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    paramInt -= 1;
    int i = 0;
    while (i <= paramInt)
    {
      int j = i + paramInt >>> 1;
      long l = paramArrayOfLong[j];
      if (l < paramLong) {
        i = j + 1;
      } else if (l > paramLong) {
        paramInt = j - 1;
      } else {
        return j;
      }
    }
    return i;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    int i = 4;
    while (i < 32)
    {
      int j = (1 << i) - 12;
      if (paramInt <= j) {
        return j;
      }
      i += 1;
    }
    return paramInt;
  }
  
  public static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}
