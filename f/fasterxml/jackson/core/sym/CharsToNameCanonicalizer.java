package f.fasterxml.jackson.core.sym;

import f.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;

public final class CharsToNameCanonicalizer
{
  public static final int DEFAULT_T_SIZE = 64;
  public static final int HASH_MULT = 33;
  public static final int MAX_COLL_CHAIN_FOR_REUSE = 63;
  public static final int MAX_COLL_CHAIN_LENGTH = 255;
  public static final int MAX_ENTRIES_FOR_REUSE = 12000;
  public static final int MAX_TABLE_SIZE = 65536;
  public static final CharsToNameCanonicalizer sBootstrapSymbolTable = new CharsToNameCanonicalizer();
  public Bucket[] _buckets;
  public final boolean _canonicalize;
  public boolean _dirty;
  public final int _hashSeed;
  public int _indexMask;
  public final boolean _intern;
  public int _longestCollisionList;
  public CharsToNameCanonicalizer _parent;
  public int _size;
  public int _sizeThreshold;
  public String[] _symbols;
  
  public CharsToNameCanonicalizer()
  {
    _canonicalize = true;
    _intern = true;
    _dirty = true;
    _hashSeed = 0;
    _longestCollisionList = 0;
    initTables(64);
  }
  
  public CharsToNameCanonicalizer(CharsToNameCanonicalizer paramCharsToNameCanonicalizer, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Bucket[] paramArrayOfBucket, int paramInt1, int paramInt2, int paramInt3)
  {
    _parent = paramCharsToNameCanonicalizer;
    _canonicalize = paramBoolean1;
    _intern = paramBoolean2;
    _symbols = paramArrayOfString;
    _buckets = paramArrayOfBucket;
    _size = paramInt1;
    _hashSeed = paramInt2;
    paramInt1 = paramArrayOfString.length;
    _sizeThreshold = (paramInt1 - (paramInt1 >> 2));
    _indexMask = (paramInt1 - 1);
    _longestCollisionList = paramInt3;
    _dirty = false;
  }
  
  public static int _thresholdSize(int paramInt)
  {
    return paramInt - (paramInt >> 2);
  }
  
  private void copyArrays()
  {
    Object localObject = _symbols;
    int i = localObject.length;
    _symbols = new String[i];
    System.arraycopy(localObject, 0, _symbols, 0, i);
    localObject = _buckets;
    i = localObject.length;
    _buckets = new Bucket[i];
    System.arraycopy(localObject, 0, _buckets, 0, i);
  }
  
  public static CharsToNameCanonicalizer createRoot()
  {
    long l = System.currentTimeMillis();
    return createRoot((int)l + (int)(l >>> 32) | 0x1);
  }
  
  public static CharsToNameCanonicalizer createRoot(int paramInt)
  {
    return sBootstrapSymbolTable.makeOrphan(paramInt);
  }
  
  private void initTables(int paramInt)
  {
    _symbols = new String[paramInt];
    _buckets = new Bucket[paramInt >> 1];
    _indexMask = (paramInt - 1);
    _size = 0;
    _longestCollisionList = 0;
    _sizeThreshold = (paramInt - (paramInt >> 2));
  }
  
  private CharsToNameCanonicalizer makeOrphan(int paramInt)
  {
    return new CharsToNameCanonicalizer(null, true, true, _symbols, _buckets, _size, paramInt, _longestCollisionList);
  }
  
  private void mergeChild(CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    if ((paramCharsToNameCanonicalizer.size() <= 12000) && (_longestCollisionList <= 63))
    {
      if (paramCharsToNameCanonicalizer.size() <= size()) {
        return;
      }
      try
      {
        _symbols = _symbols;
        _buckets = _buckets;
        _size = _size;
        _sizeThreshold = _sizeThreshold;
        _indexMask = _indexMask;
        _longestCollisionList = _longestCollisionList;
        _dirty = false;
        return;
      }
      catch (Throwable paramCharsToNameCanonicalizer)
      {
        throw paramCharsToNameCanonicalizer;
      }
    }
    try
    {
      initTables(64);
      _dirty = false;
      return;
    }
    catch (Throwable paramCharsToNameCanonicalizer)
    {
      throw paramCharsToNameCanonicalizer;
    }
  }
  
  private void rehash()
  {
    Object localObject1 = _symbols;
    int i2 = localObject1.length;
    int i = i2 + i2;
    int i1 = 0;
    if (i > 65536)
    {
      _size = 0;
      Arrays.fill((Object[])localObject1, null);
      Arrays.fill(_buckets, null);
      _dirty = true;
      return;
    }
    Bucket[] arrayOfBucket = _buckets;
    _symbols = new String[i];
    _buckets = new Bucket[i >> 1];
    _indexMask = (i - 1);
    _sizeThreshold = (i - (i >> 2));
    int k = 0;
    int j = 0;
    Object localObject2;
    String[] arrayOfString;
    for (i = 0; k < i2; i = m)
    {
      localObject2 = localObject1[k];
      int n = j;
      m = i;
      if (localObject2 != null)
      {
        n = j + 1;
        j = _hashToIndex(calcHash((String)localObject2));
        arrayOfString = _symbols;
        if (arrayOfString[j] == null)
        {
          arrayOfString[j] = localObject2;
          m = i;
        }
        else
        {
          j >>= 1;
          localObject2 = new Bucket((String)localObject2, _buckets[j]);
          _buckets[j] = localObject2;
          m = Math.max(i, ((Bucket)localObject2).length());
        }
      }
      k += 1;
      j = n;
    }
    int m = i;
    i = i1;
    k = j;
    while (i < i2 >> 1)
    {
      localObject1 = arrayOfBucket[i];
      j = m;
      while (localObject1 != null)
      {
        k += 1;
        localObject2 = ((Bucket)localObject1).getSymbol();
        m = _hashToIndex(calcHash((String)localObject2));
        arrayOfString = _symbols;
        if (arrayOfString[m] == null)
        {
          arrayOfString[m] = localObject2;
        }
        else
        {
          m >>= 1;
          localObject2 = new Bucket((String)localObject2, _buckets[m]);
          _buckets[m] = localObject2;
          j = Math.max(j, ((Bucket)localObject2).length());
        }
        localObject1 = ((Bucket)localObject1).getNext();
      }
      i += 1;
      m = j;
    }
    _longestCollisionList = m;
    if (k == _size) {
      return;
    }
    localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Internal error on SymbolTable.rehash(): had ");
    ((StringBuilder)localObject1).append(_size);
    ((StringBuilder)localObject1).append(" entries; now have ");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append(".");
    localObject1 = new Error(((StringBuilder)localObject1).toString());
    throw ((Throwable)localObject1);
  }
  
  public int _hashToIndex(int paramInt)
  {
    return paramInt + (paramInt >>> 15) & _indexMask;
  }
  
  public int bucketCount()
  {
    return _symbols.length;
  }
  
  public int calcHash(String paramString)
  {
    int k = paramString.length();
    int j = _hashSeed;
    int i = 0;
    while (i < k)
    {
      j = j * 33 + paramString.charAt(i);
      i += 1;
    }
    if (j == 0) {
      return 1;
    }
    return j;
  }
  
  public int calcHash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = _hashSeed;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      i = i * 33 + paramArrayOfChar[paramInt1];
      paramInt1 += 1;
    }
    if (i == 0) {
      return 1;
    }
    return i;
  }
  
  public int collisionCount()
  {
    Bucket[] arrayOfBucket = _buckets;
    int m = arrayOfBucket.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Bucket localBucket = arrayOfBucket[i];
      k = j;
      if (localBucket != null) {
        k = localBucket.length() + j;
      }
      i += 1;
    }
    return j;
  }
  
  public String findSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 1) {
      return "";
    }
    if (!_canonicalize) {
      return new String(paramArrayOfChar, paramInt1, paramInt2);
    }
    int k = _hashToIndex(paramInt3);
    int i = k;
    Object localObject = _symbols[k];
    if (localObject != null)
    {
      if (((String)localObject).length() == paramInt2)
      {
        paramInt3 = 0;
        while (((String)localObject).charAt(paramInt3) == paramArrayOfChar[(paramInt1 + paramInt3)])
        {
          int j = paramInt3 + 1;
          paramInt3 = j;
          if (j >= paramInt2) {
            paramInt3 = j;
          }
        }
        if (paramInt3 == paramInt2) {
          return localObject;
        }
      }
      localObject = _buckets[(k >> 1)];
      if (localObject != null)
      {
        localObject = ((Bucket)localObject).find(paramArrayOfChar, paramInt1, paramInt2);
        if (localObject != null) {
          return localObject;
        }
      }
    }
    if (!_dirty)
    {
      copyArrays();
      _dirty = true;
    }
    else if (_size >= _sizeThreshold)
    {
      rehash();
      i = _hashToIndex(calcHash(paramArrayOfChar, paramInt1, paramInt2));
    }
    localObject = new String(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = (char[])localObject;
    if (_intern) {
      paramArrayOfChar = InternCache.instance.intern((String)localObject);
    }
    _size += 1;
    localObject = _symbols;
    if (localObject[i] == null)
    {
      localObject[i] = paramArrayOfChar;
      return paramArrayOfChar;
    }
    paramInt1 = i >> 1;
    localObject = new Bucket(paramArrayOfChar, _buckets[paramInt1]);
    _buckets[paramInt1] = localObject;
    _longestCollisionList = Math.max(((Bucket)localObject).length(), _longestCollisionList);
    if (_longestCollisionList > 255) {
      reportTooManyCollisions(255);
    }
    return paramArrayOfChar;
  }
  
  public int hashSeed()
  {
    return _hashSeed;
  }
  
  public CharsToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      String[] arrayOfString = _symbols;
      Bucket[] arrayOfBucket = _buckets;
      int i = _size;
      int j = _hashSeed;
      int k = _longestCollisionList;
      return new CharsToNameCanonicalizer(this, paramBoolean1, paramBoolean2, arrayOfString, arrayOfBucket, i, j, k);
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int maxCollisionLength()
  {
    return _longestCollisionList;
  }
  
  public boolean maybeDirty()
  {
    return _dirty;
  }
  
  public void release()
  {
    if (!maybeDirty()) {
      return;
    }
    CharsToNameCanonicalizer localCharsToNameCanonicalizer = _parent;
    if (localCharsToNameCanonicalizer != null)
    {
      localCharsToNameCanonicalizer.mergeChild(this);
      _dirty = false;
    }
  }
  
  public void reportTooManyCollisions(int paramInt)
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Longest collision chain in symbol table (of size ");
    localStringBuilder.append(_size);
    localStringBuilder.append(") now exceeds maximum, ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" -- suspect a DoS attack based on hash collisions");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int size()
  {
    return _size;
  }
  
  public final class Bucket
  {
    public final int _length;
    public final Bucket _next;
    
    public Bucket(Bucket paramBucket)
    {
      _next = paramBucket;
      int i = 1;
      if (paramBucket != null) {
        i = 1 + _length;
      }
      _length = i;
    }
    
    public String find(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      String str = CharsToNameCanonicalizer.this;
      for (Bucket localBucket = _next;; localBucket = localBucket.getNext())
      {
        if (str.length() == paramInt2)
        {
          int i = 0;
          while (str.charAt(i) == paramArrayOfChar[(paramInt1 + i)])
          {
            int j = i + 1;
            i = j;
            if (j >= paramInt2) {
              i = j;
            }
          }
          if (i == paramInt2) {
            return str;
          }
        }
        if (localBucket == null) {
          return null;
        }
        str = localBucket.getSymbol();
      }
    }
    
    public Bucket getNext()
    {
      return _next;
    }
    
    public String getSymbol()
    {
      return CharsToNameCanonicalizer.this;
    }
    
    public int length()
    {
      return _length;
    }
  }
}
