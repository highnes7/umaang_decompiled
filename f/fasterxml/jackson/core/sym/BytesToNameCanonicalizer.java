package f.fasterxml.jackson.core.sym;

import f.d.a.a.e.a.b;
import f.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class BytesToNameCanonicalizer
{
  public static final int DEFAULT_T_SIZE = 64;
  public static final int INITIAL_COLLISION_LEN = 32;
  public static final int LAST_VALID_BUCKET = 254;
  public static final int MAX_COLL_CHAIN_FOR_REUSE = 63;
  public static final int MAX_COLL_CHAIN_LENGTH = 255;
  public static final int MAX_ENTRIES_FOR_REUSE = 6000;
  public static final int MAX_TABLE_SIZE = 65536;
  public static final int MIN_HASH_SIZE = 16;
  public static final int MULT = 33;
  public static final int MULT2 = 65599;
  public static final int MULT3 = 31;
  public int _collCount;
  public int _collEnd;
  public Bucket[] _collList;
  public boolean _collListShared;
  public int _count;
  public final int _hashSeed;
  public final boolean _intern;
  public int _longestCollisionList;
  public int[] _mainHash;
  public int _mainHashMask;
  public boolean _mainHashShared;
  public Name[] _mainNames;
  public boolean _mainNamesShared;
  public transient boolean _needRehash;
  public final BytesToNameCanonicalizer _parent;
  public final AtomicReference<a.b> _tableInfo;
  
  public BytesToNameCanonicalizer(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    _parent = null;
    _hashSeed = paramInt2;
    _intern = paramBoolean;
    paramInt2 = 16;
    int i;
    if (paramInt1 < 16)
    {
      i = paramInt2;
    }
    else
    {
      if ((paramInt1 - 1 & paramInt1) != 0) {
        for (;;)
        {
          i = paramInt2;
          if (paramInt2 >= paramInt1) {
            break;
          }
          paramInt2 += paramInt2;
        }
      }
      i = paramInt1;
    }
    _tableInfo = new AtomicReference(initTableInfo(i));
  }
  
  public BytesToNameCanonicalizer(BytesToNameCanonicalizer paramBytesToNameCanonicalizer, boolean paramBoolean, int paramInt, TableInfo paramTableInfo)
  {
    _parent = paramBytesToNameCanonicalizer;
    _hashSeed = paramInt;
    _intern = paramBoolean;
    _tableInfo = null;
    _count = count;
    _mainHashMask = mainHashMask;
    _mainHash = mainHash;
    _mainNames = mainNames;
    _collList = collList;
    _collCount = collCount;
    _collEnd = collEnd;
    _longestCollisionList = longestCollisionList;
    _needRehash = false;
    _mainHashShared = true;
    _mainNamesShared = true;
    _collListShared = true;
  }
  
  private void _addSymbol(int paramInt, Name paramName)
  {
    if (_mainHashShared) {
      unshareMain();
    }
    if (_needRehash) {
      rehash();
    }
    _count += 1;
    int j = _mainHashMask & paramInt;
    if (_mainNames[j] == null)
    {
      _mainHash[j] = (paramInt << 8);
      if (_mainNamesShared) {
        unshareNames();
      }
      _mainNames[j] = paramName;
    }
    else
    {
      if (_collListShared) {
        unshareCollision();
      }
      _collCount += 1;
      int k = _mainHash[j];
      paramInt = k & 0xFF;
      if (paramInt == 0)
      {
        i = _collEnd;
        if (i <= 254)
        {
          _collEnd = (i + 1);
          paramInt = i;
          if (i >= _collList.length)
          {
            expandCollision();
            paramInt = i;
          }
        }
        else
        {
          paramInt = findBestBucket();
        }
        _mainHash[j] = (k & 0xFF00 | paramInt + 1);
      }
      else
      {
        paramInt -= 1;
      }
      paramName = new Bucket(paramName, _collList[paramInt]);
      _collList[paramInt] = paramName;
      _longestCollisionList = Math.max(paramName.length(), _longestCollisionList);
      if (_longestCollisionList > 255) {
        reportTooManyCollisions(255);
      }
    }
    paramInt = _mainHash.length;
    int i = _count;
    if (i > paramInt >> 1)
    {
      j = paramInt >> 2;
      if (i > paramInt - j)
      {
        _needRehash = true;
        return;
      }
      if (_collCount >= j) {
        _needRehash = true;
      }
    }
  }
  
  public static int[] calcQuads(byte[] paramArrayOfByte)
  {
    int n = paramArrayOfByte.length;
    int[] arrayOfInt = new int[(n + 3) / 4];
    int j;
    for (int i = 0; i < n; i = j + 1)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      int m = i + 1;
      j = m;
      i = k;
      if (m < n)
      {
        k = k << 8 | paramArrayOfByte[m] & 0xFF;
        m += 1;
        j = m;
        i = k;
        if (m < n)
        {
          k = k << 8 | paramArrayOfByte[m] & 0xFF;
          m += 1;
          j = m;
          i = k;
          if (m < n)
          {
            i = k << 8 | paramArrayOfByte[m] & 0xFF;
            j = m;
          }
        }
      }
      arrayOfInt[(j >> 2)] = i;
    }
    return arrayOfInt;
  }
  
  public static Name constructName(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return new Name1(paramString, paramInt1, paramInt2);
    }
    return new Name2(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public static Name constructName(int paramInt1, String paramString, int[] paramArrayOfInt, int paramInt2)
  {
    int i = 0;
    if (paramInt2 < 4) {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 == 3) {
            return new ValueMarker(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
          }
        }
        else {
          return new Name2(paramString, paramInt1, paramArrayOfInt[0], paramArrayOfInt[1]);
        }
      }
      else {
        return new Name1(paramString, paramInt1, paramArrayOfInt[0]);
      }
    }
    int[] arrayOfInt = new int[paramInt2];
    while (i < paramInt2)
    {
      arrayOfInt[i] = paramArrayOfInt[i];
      i += 1;
    }
    return new Name3(paramString, paramInt1, arrayOfInt, paramInt2);
  }
  
  public static BytesToNameCanonicalizer createRoot()
  {
    long l = System.currentTimeMillis();
    return createRoot((int)l + (int)(l >>> 32) | 0x1);
  }
  
  public static BytesToNameCanonicalizer createRoot(int paramInt)
  {
    return new BytesToNameCanonicalizer(64, true, paramInt);
  }
  
  private void expandCollision()
  {
    Bucket[] arrayOfBucket = _collList;
    int i = arrayOfBucket.length;
    _collList = new Bucket[i + i];
    System.arraycopy(arrayOfBucket, 0, _collList, 0, i);
  }
  
  private int findBestBucket()
  {
    Bucket[] arrayOfBucket = _collList;
    int i1 = _collEnd;
    int j = Integer.MAX_VALUE;
    int k = -1;
    int i = 0;
    while (i < i1)
    {
      int n = arrayOfBucket[i].length();
      int m = j;
      if (n < j)
      {
        if (n == 1) {
          return i;
        }
        k = i;
        m = n;
      }
      i += 1;
      j = m;
    }
    return k;
  }
  
  public static Name getEmptyName()
  {
    return Name1.getEmptyName();
  }
  
  private TableInfo initTableInfo(int paramInt)
  {
    return new TableInfo(0, paramInt - 1, new int[paramInt], new Name[paramInt], null, 0, 0, 0);
  }
  
  private void mergeChild(TableInfo paramTableInfo)
  {
    int i = count;
    TableInfo localTableInfo2 = (TableInfo)_tableInfo.get();
    if (i <= count) {
      return;
    }
    TableInfo localTableInfo1;
    if (i <= 6000)
    {
      localTableInfo1 = paramTableInfo;
      if (longestCollisionList <= 63) {}
    }
    else
    {
      localTableInfo1 = initTableInfo(64);
    }
    _tableInfo.compareAndSet(localTableInfo2, localTableInfo1);
  }
  
  private void nukeSymbols()
  {
    _count = 0;
    _longestCollisionList = 0;
    Arrays.fill(_mainHash, 0);
    Arrays.fill(_mainNames, null);
    Arrays.fill(_collList, null);
    _collCount = 0;
    _collEnd = 0;
  }
  
  private void rehash()
  {
    int m = 0;
    _needRehash = false;
    _mainNamesShared = false;
    int n = _mainHash.length;
    int i = n + n;
    if (i > 65536)
    {
      nukeSymbols();
      return;
    }
    _mainHash = new int[i];
    _mainHashMask = (i - 1);
    Object localObject1 = _mainNames;
    _mainNames = new Name[i];
    int j = 0;
    for (i = 0; j < n; i = k)
    {
      arrayOfBucket = localObject1[j];
      k = i;
      if (arrayOfBucket != null)
      {
        k = i + 1;
        i = arrayOfBucket.hashCode();
        i1 = _mainHashMask & i;
        _mainNames[i1] = arrayOfBucket;
        _mainHash[i1] = (i << 8);
      }
      j += 1;
    }
    int i1 = _collEnd;
    if (i1 == 0)
    {
      _longestCollisionList = 0;
      return;
    }
    _collCount = 0;
    _collEnd = 0;
    _collListShared = false;
    Bucket[] arrayOfBucket = _collList;
    _collList = new Bucket[arrayOfBucket.length];
    int k = 0;
    j = m;
    while (j < i1)
    {
      localObject1 = arrayOfBucket[j];
      while (localObject1 != null)
      {
        m = i + 1;
        Object localObject2 = _name;
        i = ((Name)localObject2).hashCode();
        int i2 = _mainHashMask & i;
        int[] arrayOfInt = _mainHash;
        int i3 = arrayOfInt[i2];
        Name[] arrayOfName = _mainNames;
        if (arrayOfName[i2] == null)
        {
          arrayOfInt[i2] = (i << 8);
          arrayOfName[i2] = localObject2;
        }
        else
        {
          _collCount += 1;
          i = i3 & 0xFF;
          if (i == 0)
          {
            n = _collEnd;
            if (n <= 254)
            {
              _collEnd = (n + 1);
              i = n;
              if (n >= _collList.length)
              {
                expandCollision();
                i = n;
              }
            }
            else
            {
              i = findBestBucket();
            }
            _mainHash[i2] = (i3 & 0xFF00 | i + 1);
          }
          else
          {
            i -= 1;
          }
          localObject2 = new Bucket((Name)localObject2, _collList[i]);
          _collList[i] = localObject2;
          k = Math.max(k, ((Bucket)localObject2).length());
        }
        localObject1 = _next;
        i = m;
      }
      j += 1;
    }
    _longestCollisionList = k;
    if (i == _count) {
      return;
    }
    localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Internal error: count after rehash ", i, "; should be ");
    ((StringBuilder)localObject1).append(_count);
    localObject1 = new RuntimeException(((StringBuilder)localObject1).toString());
    throw ((Throwable)localObject1);
  }
  
  private void unshareCollision()
  {
    Bucket[] arrayOfBucket = _collList;
    if (arrayOfBucket == null)
    {
      _collList = new Bucket[32];
    }
    else
    {
      int i = arrayOfBucket.length;
      _collList = new Bucket[i];
      System.arraycopy(arrayOfBucket, 0, _collList, 0, i);
    }
    _collListShared = false;
  }
  
  private void unshareMain()
  {
    int[] arrayOfInt = _mainHash;
    int i = arrayOfInt.length;
    _mainHash = new int[i];
    System.arraycopy(arrayOfInt, 0, _mainHash, 0, i);
    _mainHashShared = false;
  }
  
  private void unshareNames()
  {
    Name[] arrayOfName = _mainNames;
    int i = arrayOfName.length;
    _mainNames = new Name[i];
    System.arraycopy(arrayOfName, 0, _mainNames, 0, i);
    _mainNamesShared = false;
  }
  
  public Name addName(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (_intern) {
      str = InternCache.instance.intern(paramString);
    }
    int i;
    if (paramInt2 == 0) {
      i = calcHash(paramInt1);
    } else {
      i = calcHash(paramInt1, paramInt2);
    }
    paramString = constructName(i, str, paramInt1, paramInt2);
    _addSymbol(i, paramString);
    return paramString;
  }
  
  public Name addName(String paramString, int[] paramArrayOfInt, int paramInt)
  {
    String str = paramString;
    if (_intern) {
      str = InternCache.instance.intern(paramString);
    }
    int i;
    if (paramInt < 3)
    {
      if (paramInt == 1) {
        i = calcHash(paramArrayOfInt[0]);
      } else {
        i = calcHash(paramArrayOfInt[0], paramArrayOfInt[1]);
      }
    }
    else {
      i = calcHash(paramArrayOfInt, paramInt);
    }
    paramString = constructName(i, str, paramArrayOfInt, paramInt);
    _addSymbol(i, paramString);
    return paramString;
  }
  
  public int bucketCount()
  {
    return _mainHash.length;
  }
  
  public int calcHash()
  {
    return _hashSeed;
  }
  
  public int calcHash(int paramInt)
  {
    paramInt ^= _hashSeed;
    paramInt += (paramInt >>> 15);
    return paramInt ^ paramInt >>> 9;
  }
  
  public int calcHash(int paramInt1, int paramInt2)
  {
    paramInt1 = _hashSeed ^ paramInt2 * 33 + (paramInt1 ^ paramInt1 >>> 15);
    return paramInt1 + (paramInt1 >>> 7);
  }
  
  public int calcHash(int[] paramArrayOfInt, int paramInt)
  {
    int i = 3;
    if (paramInt >= 3)
    {
      int j = paramArrayOfInt[0] ^ _hashSeed;
      j = ((j + (j >>> 9)) * 33 + paramArrayOfInt[1]) * 65599;
      j = j + (j >>> 15) ^ paramArrayOfInt[2];
      j += (j >>> 17);
      while (i < paramInt)
      {
        j = j * 31 ^ paramArrayOfInt[i];
        j += (j >>> 3);
        j ^= j << 7;
        i += 1;
      }
      paramInt = j + (j >>> 15);
      return paramInt << 9 ^ paramInt;
    }
    paramArrayOfInt = new IllegalArgumentException();
    throw paramArrayOfInt;
  }
  
  public int collisionCount()
  {
    return _collCount;
  }
  
  public Name findName(int paramInt)
  {
    int i = calcHash(paramInt);
    int j = _mainHashMask & i;
    int k = _mainHash[j];
    Object localObject;
    if ((k >> 8 ^ i) << 8 == 0)
    {
      localObject = _mainNames[j];
      if (localObject == null) {
        return null;
      }
      if (((Name)localObject).equals(paramInt)) {
        return localObject;
      }
    }
    else if (k == 0)
    {
      return null;
    }
    j = k & 0xFF;
    if (j > 0)
    {
      localObject = _collList[(j - 1)];
      if (localObject != null) {
        return ((Bucket)localObject).find(i, paramInt, 0);
      }
    }
    return null;
  }
  
  public Name findName(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 == 0) {
      i = calcHash(paramInt1);
    } else {
      i = calcHash(paramInt1, paramInt2);
    }
    int j = _mainHashMask & i;
    int k = _mainHash[j];
    Object localObject;
    if ((k >> 8 ^ i) << 8 == 0)
    {
      localObject = _mainNames[j];
      if (localObject == null) {
        return null;
      }
      if (((Name)localObject).equals(paramInt1, paramInt2)) {
        return localObject;
      }
    }
    else if (k == 0)
    {
      return null;
    }
    j = k & 0xFF;
    if (j > 0)
    {
      localObject = _collList[(j - 1)];
      if (localObject != null) {
        return ((Bucket)localObject).find(i, paramInt1, paramInt2);
      }
    }
    return null;
  }
  
  public Name findName(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt < 3)
    {
      i = 0;
      j = paramArrayOfInt[0];
      if (paramInt < 2) {
        paramInt = i;
      } else {
        paramInt = paramArrayOfInt[1];
      }
      return findName(j, paramInt);
    }
    int i = calcHash(paramArrayOfInt, paramInt);
    int j = _mainHashMask & i;
    int k = _mainHash[j];
    Object localObject;
    if ((k >> 8 ^ i) << 8 == 0)
    {
      localObject = _mainNames[j];
      if (localObject == null) {
        break label145;
      }
      if (((Name)localObject).equals(paramArrayOfInt, paramInt)) {
        return localObject;
      }
    }
    else if (k == 0)
    {
      return null;
    }
    j = k & 0xFF;
    if (j > 0)
    {
      localObject = _collList[(j - 1)];
      if (localObject != null) {
        return ((Bucket)localObject).find(i, paramArrayOfInt, paramInt);
      }
    }
    else
    {
      return null;
      label145:
      return localObject;
    }
    return null;
  }
  
  public BytesToNameCanonicalizer makeChild(boolean paramBoolean1, boolean paramBoolean2)
  {
    return new BytesToNameCanonicalizer(this, paramBoolean2, _hashSeed, (TableInfo)_tableInfo.get());
  }
  
  public int maxCollisionLength()
  {
    return _longestCollisionList;
  }
  
  public boolean maybeDirty()
  {
    return _mainHashShared ^ true;
  }
  
  public void release()
  {
    if ((_parent != null) && (maybeDirty()))
    {
      _parent.mergeChild(new TableInfo());
      _mainHashShared = true;
      _mainNamesShared = true;
      _collListShared = true;
    }
  }
  
  public void reportTooManyCollisions(int paramInt)
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Longest collision chain in symbol table (of size ");
    localStringBuilder.append(_count);
    localStringBuilder.append(") now exceeds maximum, ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" -- suspect a DoS attack based on hash collisions");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public int size()
  {
    AtomicReference localAtomicReference = _tableInfo;
    if (localAtomicReference != null) {
      return getcount;
    }
    return _count;
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
    
    public Name find(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((hashCode() == paramInt1) && (equals(paramInt2, paramInt3))) {
        return BytesToNameCanonicalizer.this;
      }
      for (Bucket localBucket = _next; localBucket != null; localBucket = _next)
      {
        Name localName = _name;
        if ((localName.hashCode() == paramInt1) && (localName.equals(paramInt2, paramInt3))) {
          return localName;
        }
      }
      return null;
    }
    
    public Name find(int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      if ((hashCode() == paramInt1) && (equals(paramArrayOfInt, paramInt2))) {
        return BytesToNameCanonicalizer.this;
      }
      for (Bucket localBucket = _next; localBucket != null; localBucket = _next)
      {
        Name localName = _name;
        if ((localName.hashCode() == paramInt1) && (localName.equals(paramArrayOfInt, paramInt2))) {
          return localName;
        }
      }
      return null;
    }
    
    public int length()
    {
      return _length;
    }
  }
  
  public final class TableInfo
  {
    public final int collCount;
    public final int collEnd;
    public final BytesToNameCanonicalizer.Bucket[] collList;
    public final int count;
    public final int longestCollisionList;
    public final int[] mainHash;
    public final int mainHashMask;
    public final Name[] mainNames;
    
    public TableInfo(int paramInt1, int[] paramArrayOfInt, Name[] paramArrayOfName, BytesToNameCanonicalizer.Bucket[] paramArrayOfBucket, int paramInt2, int paramInt3, int paramInt4)
    {
      count = this$1;
      mainHashMask = paramInt1;
      mainHash = paramArrayOfInt;
      mainNames = paramArrayOfName;
      collList = paramArrayOfBucket;
      collCount = paramInt2;
      collEnd = paramInt3;
      longestCollisionList = paramInt4;
    }
    
    public TableInfo()
    {
      count = _count;
      mainHashMask = _mainHashMask;
      mainHash = _mainHash;
      mainNames = _mainNames;
      collList = _collList;
      collCount = _collCount;
      collEnd = _collEnd;
      longestCollisionList = _longestCollisionList;
    }
  }
}
