package support.android.v4.util;

import b.b.a.G;
import java.util.ConcurrentModificationException;

public class SimpleArrayMap<K, V>
{
  public static final int BASE_SIZE = 4;
  public static final int CACHE_SIZE = 10;
  public static final boolean DEBUG = false;
  public static final String TAG = "ArrayMap";
  public static final boolean c = true;
  @G
  public static Object[] mBaseCache;
  public static int mBaseCacheSize;
  @G
  public static Object[] mTwiceBaseCache;
  public static int mTwiceBaseCacheSize;
  public Object[] mArray;
  public int[] mHashes;
  public int mSize;
  
  public SimpleArrayMap()
  {
    mHashes = ContainerHelpers.EMPTY_INTS;
    mArray = ContainerHelpers.EMPTY_OBJECTS;
    mSize = 0;
  }
  
  public SimpleArrayMap(int paramInt)
  {
    if (paramInt == 0)
    {
      mHashes = ContainerHelpers.EMPTY_INTS;
      mArray = ContainerHelpers.EMPTY_OBJECTS;
    }
    else
    {
      allocArrays(paramInt);
    }
    mSize = 0;
  }
  
  public SimpleArrayMap(SimpleArrayMap paramSimpleArrayMap)
  {
    this();
    if (paramSimpleArrayMap != null) {
      putAll(paramSimpleArrayMap);
    }
  }
  
  private void allocArrays(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (mBaseCache != null)
        {
          Object[] arrayOfObject1 = mBaseCache;
          mArray = arrayOfObject1;
          mBaseCache = (Object[])arrayOfObject1[0];
          mHashes = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          mBaseCacheSize -= 1;
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        throw localThrowable1;
      }
    }
    if (paramInt == 4) {
      try
      {
        if (mTwiceBaseCache != null)
        {
          Object[] arrayOfObject2 = mTwiceBaseCache;
          mArray = arrayOfObject2;
          mTwiceBaseCache = (Object[])arrayOfObject2[0];
          mHashes = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          mTwiceBaseCacheSize -= 1;
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        throw localThrowable2;
      }
    }
    mHashes = new int[paramInt];
    mArray = new Object[paramInt << 1];
  }
  
  public static int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = ContainerHelpers.binarySearch(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      for (;;) {}
    }
    throw new ConcurrentModificationException();
  }
  
  public static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (mBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label118;
          mBaseCache = paramArrayOfObject;
          mBaseCacheSize += 1;
        }
        return;
      }
      catch (Throwable paramArrayOfInt)
      {
        throw paramArrayOfInt;
      }
    }
    if (paramArrayOfInt.length == 4) {}
    for (;;)
    {
      try
      {
        if (mTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          mTwiceBaseCache = paramArrayOfObject;
          mTwiceBaseCacheSize += 1;
        }
        return;
      }
      catch (Throwable paramArrayOfInt)
      {
        throw paramArrayOfInt;
      }
      return;
      label118:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  public void clear()
  {
    int i = mSize;
    if (i > 0)
    {
      int[] arrayOfInt = mHashes;
      Object[] arrayOfObject = mArray;
      mHashes = ContainerHelpers.EMPTY_INTS;
      mArray = ContainerHelpers.EMPTY_OBJECTS;
      mSize = 0;
      freeArrays(arrayOfInt, arrayOfObject, i);
    }
    if (mSize <= 0) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean containsKey(Object paramObject)
  {
    return indexOfKey(paramObject) >= 0;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return indexOfValue(paramObject) >= 0;
  }
  
  public void ensureCapacity(int paramInt)
  {
    int i = mSize;
    int[] arrayOfInt = mHashes;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = mArray;
      allocArrays(paramInt);
      if (mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, mHashes, 0, i);
        System.arraycopy(arrayOfObject, 0, mArray, 0, i << 1);
      }
      freeArrays(arrayOfInt, arrayOfObject, i);
    }
    if (mSize == i) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  /* Error */
  public boolean equals(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: if_acmpne +5 -> 7
    //   5: iconst_1
    //   6: ireturn
    //   7: aload_1
    //   8: instanceof 2
    //   11: ifeq +105 -> 116
    //   14: aload_1
    //   15: checkcast 2	support/android/v4/util/SimpleArrayMap
    //   18: astore_1
    //   19: aload_0
    //   20: invokevirtual 111	support/android/v4/util/SimpleArrayMap:size	()I
    //   23: aload_1
    //   24: invokevirtual 111	support/android/v4/util/SimpleArrayMap:size	()I
    //   27: if_icmpeq +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_2
    //   34: aload_0
    //   35: getfield 47	support/android/v4/util/SimpleArrayMap:mSize	I
    //   38: istore_3
    //   39: iload_2
    //   40: iload_3
    //   41: if_icmpge +73 -> 114
    //   44: aload_0
    //   45: iload_2
    //   46: invokevirtual 115	support/android/v4/util/SimpleArrayMap:keyAt	(I)Ljava/lang/Object;
    //   49: astore 5
    //   51: aload_0
    //   52: iload_2
    //   53: invokevirtual 118	support/android/v4/util/SimpleArrayMap:get	(I)Ljava/lang/Object;
    //   56: astore 6
    //   58: aload_1
    //   59: aload 5
    //   61: invokevirtual 121	support/android/v4/util/SimpleArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: astore 7
    //   66: aload 6
    //   68: ifnonnull +23 -> 91
    //   71: aload 7
    //   73: ifnonnull +170 -> 243
    //   76: aload_1
    //   77: aload 5
    //   79: invokevirtual 123	support/android/v4/util/SimpleArrayMap:containsKey	(Ljava/lang/Object;)Z
    //   82: istore 4
    //   84: iload 4
    //   86: ifne +21 -> 107
    //   89: iconst_0
    //   90: ireturn
    //   91: aload 6
    //   93: aload 7
    //   95: invokevirtual 125	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   98: istore 4
    //   100: iload 4
    //   102: ifne +5 -> 107
    //   105: iconst_0
    //   106: ireturn
    //   107: iload_2
    //   108: iconst_1
    //   109: iadd
    //   110: istore_2
    //   111: goto -77 -> 34
    //   114: iconst_1
    //   115: ireturn
    //   116: aload_1
    //   117: instanceof 127
    //   120: ifeq +111 -> 231
    //   123: aload_1
    //   124: checkcast 127	java/util/Map
    //   127: astore_1
    //   128: aload_0
    //   129: invokevirtual 111	support/android/v4/util/SimpleArrayMap:size	()I
    //   132: aload_1
    //   133: invokeinterface 128 1 0
    //   138: if_icmpeq +5 -> 143
    //   141: iconst_0
    //   142: ireturn
    //   143: iconst_0
    //   144: istore_2
    //   145: aload_0
    //   146: getfield 47	support/android/v4/util/SimpleArrayMap:mSize	I
    //   149: istore_3
    //   150: iload_2
    //   151: iload_3
    //   152: if_icmpge +77 -> 229
    //   155: aload_0
    //   156: iload_2
    //   157: invokevirtual 115	support/android/v4/util/SimpleArrayMap:keyAt	(I)Ljava/lang/Object;
    //   160: astore 5
    //   162: aload_0
    //   163: iload_2
    //   164: invokevirtual 118	support/android/v4/util/SimpleArrayMap:get	(I)Ljava/lang/Object;
    //   167: astore 6
    //   169: aload_1
    //   170: aload 5
    //   172: invokeinterface 129 2 0
    //   177: astore 7
    //   179: aload 6
    //   181: ifnonnull +25 -> 206
    //   184: aload 7
    //   186: ifnonnull +57 -> 243
    //   189: aload_1
    //   190: aload 5
    //   192: invokeinterface 130 2 0
    //   197: istore 4
    //   199: iload 4
    //   201: ifne +21 -> 222
    //   204: iconst_0
    //   205: ireturn
    //   206: aload 6
    //   208: aload 7
    //   210: invokevirtual 125	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   213: istore 4
    //   215: iload 4
    //   217: ifne +5 -> 222
    //   220: iconst_0
    //   221: ireturn
    //   222: iload_2
    //   223: iconst_1
    //   224: iadd
    //   225: istore_2
    //   226: goto -81 -> 145
    //   229: iconst_1
    //   230: ireturn
    //   231: iconst_0
    //   232: ireturn
    //   233: astore_1
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_1
    //   237: iconst_0
    //   238: ireturn
    //   239: astore_1
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_1
    //   243: iconst_0
    //   244: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	SimpleArrayMap
    //   0	245	1	paramObject	Object
    //   33	193	2	i	int
    //   38	115	3	j	int
    //   82	134	4	bool	boolean
    //   49	142	5	localObject1	Object
    //   56	151	6	localObject2	Object
    //   64	145	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	233	java/lang/NullPointerException
    //   44	66	233	java/lang/NullPointerException
    //   76	84	233	java/lang/NullPointerException
    //   91	100	233	java/lang/NullPointerException
    //   44	66	236	java/lang/ClassCastException
    //   76	84	236	java/lang/ClassCastException
    //   91	100	236	java/lang/ClassCastException
    //   145	150	239	java/lang/NullPointerException
    //   155	179	239	java/lang/NullPointerException
    //   189	199	239	java/lang/NullPointerException
    //   206	215	239	java/lang/NullPointerException
    //   155	179	242	java/lang/ClassCastException
    //   189	199	242	java/lang/ClassCastException
    //   206	215	242	java/lang/ClassCastException
  }
  
  public Object get(int paramInt)
  {
    return mArray[((paramInt << 1) + 1)];
  }
  
  public Object get(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      return mArray[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = mHashes;
    Object[] arrayOfObject = mArray;
    int n = mSize;
    int j = 0;
    int k = 0;
    int i = 1;
    while (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = localObject.hashCode();
      }
      k += (m ^ i1);
      j += 1;
      i += 2;
    }
    return k;
  }
  
  public int indexOf(Object paramObject, int paramInt)
  {
    int j = mSize;
    if (j == 0) {
      return -1;
    }
    int k = binarySearch(mHashes, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(mArray[(k << 1)])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (mHashes[i] == paramInt))
    {
      if (paramObject.equals(mArray[(i << 1)])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (mHashes[j] == paramInt))
    {
      if (paramObject.equals(mArray[(j << 1)])) {
        return j;
      }
      j -= 1;
    }
    return i;
  }
  
  public int indexOfKey(Object paramObject)
  {
    if (paramObject == null) {
      return indexOfNull();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public int indexOfNull()
  {
    int j = mSize;
    if (j == 0) {
      return -1;
    }
    int k = binarySearch(mHashes, j, 0);
    if (k < 0) {
      return k;
    }
    if (mArray[(k << 1)] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (mHashes[i] == 0))
    {
      if (mArray[(i << 1)] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (mHashes[j] == 0))
    {
      if (mArray[(j << 1)] == null) {
        return j;
      }
      j -= 1;
    }
    return i;
  }
  
  public int indexOfValue(Object paramObject)
  {
    int j = mSize * 2;
    Object[] arrayOfObject = mArray;
    if (paramObject == null)
    {
      i = 1;
      while (i < j)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    int i = 1;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i])) {
        return i >> 1;
      }
      i += 2;
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return mSize <= 0;
  }
  
  public Object keyAt(int paramInt)
  {
    return mArray[(paramInt << 1)];
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    int k = mSize;
    int j;
    if (paramObject1 == null)
    {
      i = indexOfNull();
      j = 0;
    }
    else
    {
      j = paramObject1.hashCode();
      i = indexOf(paramObject1, j);
    }
    Object localObject;
    if (i >= 0)
    {
      i = (i << 1) + 1;
      paramObject1 = mArray;
      localObject = paramObject1[i];
      paramObject1[i] = paramObject2;
      return localObject;
    }
    int m = i;
    if (k >= mHashes.length)
    {
      i = 4;
      if (k >= 8) {
        i = (k >> 1) + k;
      } else if (k >= 4) {
        i = 8;
      }
      localObject = mHashes;
      Object[] arrayOfObject = mArray;
      allocArrays(i);
      if (k == mSize)
      {
        int[] arrayOfInt = mHashes;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
          System.arraycopy(arrayOfObject, 0, mArray, 0, arrayOfObject.length);
        }
        freeArrays((int[])localObject, arrayOfObject, k);
      }
      else
      {
        throw new ConcurrentModificationException();
      }
    }
    if (m < k)
    {
      localObject = mHashes;
      i = m + 1;
      System.arraycopy(localObject, m, localObject, i, k - m);
      localObject = mArray;
      System.arraycopy(localObject, m << 1, localObject, i << 1, mSize - m << 1);
    }
    int i = mSize;
    if (k == i)
    {
      localObject = mHashes;
      if (m < localObject.length)
      {
        localObject[m] = j;
        localObject = mArray;
        j = m << 1;
        localObject[j] = paramObject1;
        localObject[(j + 1)] = paramObject2;
        mSize = (i + 1);
        return null;
      }
    }
    throw new ConcurrentModificationException();
  }
  
  public void putAll(SimpleArrayMap paramSimpleArrayMap)
  {
    int j = mSize;
    ensureCapacity(mSize + j);
    int k = mSize;
    int i = 0;
    if (k == 0)
    {
      if (j > 0)
      {
        System.arraycopy(mHashes, 0, mHashes, 0, j);
        System.arraycopy(mArray, 0, mArray, 0, j << 1);
        mSize = j;
      }
    }
    else {
      while (i < j)
      {
        put(paramSimpleArrayMap.keyAt(i), paramSimpleArrayMap.get(i));
        i += 1;
      }
    }
  }
  
  public Object remove(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      return removeAt(i);
    }
    return null;
  }
  
  public Object removeAt(int paramInt)
  {
    Object localObject2 = mArray;
    int m = paramInt << 1;
    Object localObject1 = localObject2[(m + 1)];
    int k = mSize;
    int i;
    if (k <= 1)
    {
      freeArrays(mHashes, (Object[])localObject2, k);
      mHashes = ContainerHelpers.EMPTY_INTS;
      mArray = ContainerHelpers.EMPTY_OBJECTS;
      i = 0;
    }
    else
    {
      int j = k - 1;
      localObject2 = mHashes;
      int n = localObject2.length;
      i = 8;
      if ((n > 8) && (k < localObject2.length / 3))
      {
        if (k > 8) {
          i = k + (k >> 1);
        }
        localObject2 = mHashes;
        Object[] arrayOfObject = mArray;
        allocArrays(i);
        if (k == mSize)
        {
          if (paramInt > 0)
          {
            System.arraycopy(localObject2, 0, mHashes, 0, paramInt);
            System.arraycopy(arrayOfObject, 0, mArray, 0, m);
          }
          i = j;
          if (paramInt < j)
          {
            i = paramInt + 1;
            int[] arrayOfInt = mHashes;
            n = j - paramInt;
            System.arraycopy(localObject2, i, arrayOfInt, paramInt, n);
            System.arraycopy(arrayOfObject, i << 1, mArray, m, n << 1);
            i = j;
          }
        }
        else
        {
          throw new ConcurrentModificationException();
        }
      }
      else
      {
        if (paramInt < j)
        {
          localObject2 = mHashes;
          i = paramInt + 1;
          n = j - paramInt;
          System.arraycopy(localObject2, i, localObject2, paramInt, n);
          localObject2 = mArray;
          System.arraycopy(localObject2, i << 1, localObject2, m, n << 1);
        }
        localObject2 = mArray;
        paramInt = j << 1;
        localObject2[paramInt] = null;
        localObject2[(paramInt + 1)] = null;
        i = j;
      }
    }
    if (k == mSize)
    {
      mSize = i;
      return localObject1;
    }
    throw new ConcurrentModificationException();
  }
  
  public Object setValueAt(int paramInt, Object paramObject)
  {
    paramInt = (paramInt << 1) + 1;
    Object[] arrayOfObject = mArray;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramObject;
    return localObject;
  }
  
  public int size()
  {
    return mSize;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(mSize * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = keyAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      localStringBuilder.append('=');
      localObject = get(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
