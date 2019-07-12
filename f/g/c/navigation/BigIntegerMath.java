package f.g.c.navigation;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.a.d;
import f.g.c.package_10.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@a
@b(emulated=true)
public final class BigIntegerMath
{
  public static final double LN_10 = Math.log(10.0D);
  public static final double LN_2 = Math.log(2.0D);
  @d
  public static final BigInteger SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
  @d
  public static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;
  
  public BigIntegerMath() {}
  
  public static BigInteger binomial(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("n", paramInt1);
    MathPreconditions.checkNonNegative("k", paramInt2);
    int j = 1;
    boolean bool;
    if (paramInt2 <= paramInt1) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "k (%s) > n (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    int i = paramInt2;
    if (paramInt2 > paramInt1 >> 1) {
      i = paramInt1 - paramInt2;
    }
    Object localObject = LongMath.biggestBinomials;
    if ((i < localObject.length) && (paramInt1 <= localObject[i])) {
      return BigInteger.valueOf(LongMath.binomial(paramInt1, i));
    }
    localObject = BigInteger.ONE;
    long l1 = paramInt1;
    long l2 = 1L;
    int k = LongMath.log2(l1, RoundingMode.CEILING);
    paramInt2 = j;
    j = k;
    for (;;)
    {
      if (paramInt2 >= i) {
        break label199;
      }
      int m = paramInt1 - paramInt2;
      paramInt2 += 1;
      j += k;
      if (j >= 63)
      {
        localObject = ((BigInteger)localObject).multiply(BigInteger.valueOf(l1)).divide(BigInteger.valueOf(l2));
        l1 = m;
        l2 = paramInt2;
        break;
      }
      l1 *= m;
      l2 *= paramInt2;
    }
    label199:
    return ((BigInteger)localObject).multiply(BigInteger.valueOf(l1)).divide(BigInteger.valueOf(l2));
  }
  
  public static BigInteger divide(BigInteger paramBigInteger1, BigInteger paramBigInteger2, RoundingMode paramRoundingMode)
  {
    return new BigDecimal(paramBigInteger1).divide(new BigDecimal(paramBigInteger2), 0, paramRoundingMode).toBigIntegerExact();
  }
  
  public static BigInteger factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    Object localObject = LongMath.factorials;
    if (paramInt < localObject.length) {
      return BigInteger.valueOf(localObject[paramInt]);
    }
    localObject = new ArrayList(IntMath.divide(IntMath.log2(paramInt, RoundingMode.CEILING) * paramInt, 64, RoundingMode.CEILING));
    long[] arrayOfLong = LongMath.factorials;
    int k = arrayOfLong.length;
    long l1 = arrayOfLong[(k - 1)];
    int i = Long.numberOfTrailingZeros(l1);
    int j = i;
    l1 >>= i;
    i = LongMath.log2(l1, RoundingMode.FLOOR) + 1;
    long l2 = k;
    int m = LongMath.log2(l2, RoundingMode.FLOOR) + 1;
    for (int n = 1 << m - 1; l2 <= paramInt; n = k)
    {
      int i1 = m;
      k = n;
      if ((n & l2) != 0L)
      {
        k = n << 1;
        i1 = m + 1;
      }
      m = Long.numberOfTrailingZeros(l2);
      j += m;
      long l3 = l1;
      if (i1 - m + i >= 64)
      {
        ((ArrayList)localObject).add(BigInteger.valueOf(l1));
        l3 = 1L;
      }
      l1 = l3 * (l2 >> m);
      i = LongMath.log2(l1, RoundingMode.FLOOR) + 1;
      l2 += 1L;
      m = i1;
    }
    if (l1 > 1L) {
      ((ArrayList)localObject).add(BigInteger.valueOf(l1));
    }
    return listProduct((List)localObject, 0, ((List)localObject).size()).shiftLeft(j);
  }
  
  public static boolean fitsInLong(BigInteger paramBigInteger)
  {
    return paramBigInteger.bitLength() <= 63;
  }
  
  public static boolean isPowerOfTwo(BigInteger paramBigInteger)
  {
    if (paramBigInteger != null) {
      return (paramBigInteger.signum() > 0) && (paramBigInteger.getLowestSetBit() == paramBigInteger.bitLength() - 1);
    }
    throw new NullPointerException();
  }
  
  public static BigInteger listProduct(List paramList)
  {
    return listProduct(paramList, 0, paramList.size());
  }
  
  public static BigInteger listProduct(List paramList, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            i = paramInt2 + paramInt1 >>> 1;
            return listProduct(paramList, paramInt1, i).multiply(listProduct(paramList, i, paramInt2));
          }
          return ((BigInteger)paramList.get(paramInt1)).multiply((BigInteger)paramList.get(paramInt1 + 1)).multiply((BigInteger)paramList.get(paramInt1 + 2));
        }
        return ((BigInteger)paramList.get(paramInt1)).multiply((BigInteger)paramList.get(paramInt1 + 1));
      }
      return (BigInteger)paramList.get(paramInt1);
    }
    return BigInteger.ONE;
  }
  
  public static int log10(BigInteger paramBigInteger, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramBigInteger);
    if (fitsInLong(paramBigInteger)) {
      return LongMath.log10(paramBigInteger.longValue(), paramRoundingMode);
    }
    double d1 = log2(paramBigInteger, RoundingMode.FLOOR);
    double d2 = LN_2;
    Double.isNaN(d1);
    int j = (int)(d1 * d2 / LN_10);
    Object localObject2 = BigInteger.TEN.pow(j);
    Object localObject1 = localObject2;
    int k = ((BigInteger)localObject2).compareTo(paramBigInteger);
    int m;
    int i;
    if (k > 0)
    {
      localObject2 = localObject1;
      do
      {
        m = j - 1;
        localObject2 = ((BigInteger)localObject2).divide(BigInteger.TEN);
        localObject1 = localObject2;
        k = ((BigInteger)localObject2).compareTo(paramBigInteger);
        i = k;
        j = m;
        localObject2 = localObject1;
      } while (k > 0);
      k = i;
    }
    else
    {
      localObject2 = BigInteger.TEN.multiply((BigInteger)localObject2);
      for (i = ((BigInteger)localObject2).compareTo(paramBigInteger);; i = m)
      {
        m = j;
        if (i > 0) {
          break;
        }
        j += 1;
        BigInteger localBigInteger = BigInteger.TEN.multiply((BigInteger)localObject2);
        m = localBigInteger.compareTo(paramBigInteger);
        localObject1 = localObject2;
        localObject2 = localBigInteger;
        k = i;
      }
    }
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 6: 
    case 7: 
    case 8: 
      if (paramBigInteger.pow(2).compareTo(localObject1.pow(2).multiply(BigInteger.TEN)) <= 0) {
        return m;
      }
      return m + 1;
    case 4: 
    case 5: 
      if (localObject1.equals(paramBigInteger)) {
        return m;
      }
      return m + 1;
    case 1: 
      boolean bool;
      if (k == 0) {
        bool = true;
      } else {
        bool = false;
      }
      MathPreconditions.checkRoundingUnnecessary(bool);
    }
    return m;
  }
  
  public static int log2(BigInteger paramBigInteger, RoundingMode paramRoundingMode)
  {
    if (paramBigInteger != null)
    {
      MathPreconditions.checkPositive("x", paramBigInteger);
      int i = paramBigInteger.bitLength() - 1;
      switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
      {
      default: 
        throw new AssertionError();
      case 6: 
      case 7: 
      case 8: 
        if (i < 256)
        {
          if (paramBigInteger.compareTo(SQRT2_PRECOMPUTED_BITS.shiftRight(256 - i)) <= 0) {
            return i;
          }
          return i + 1;
        }
        if (paramBigInteger.pow(2).bitLength() - 1 < i * 2 + 1) {
          return i;
        }
        return i + 1;
      case 4: 
      case 5: 
        if (isPowerOfTwo(paramBigInteger)) {
          return i;
        }
        return i + 1;
      case 1: 
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramBigInteger));
      }
      return i;
    }
    throw new NullPointerException();
  }
  
  public static BigInteger sqrt(BigInteger paramBigInteger, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkNonNegative("x", paramBigInteger);
    if (fitsInLong(paramBigInteger)) {
      return BigInteger.valueOf(LongMath.sqrt(paramBigInteger.longValue(), paramRoundingMode));
    }
    BigInteger localBigInteger = sqrtFloor(paramBigInteger);
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 6: 
    case 7: 
    case 8: 
      if (localBigInteger.pow(2).add(localBigInteger).compareTo(paramBigInteger) >= 0) {
        return localBigInteger;
      }
      return localBigInteger.add(BigInteger.ONE);
    case 4: 
    case 5: 
      if (localBigInteger.pow(2).equals(paramBigInteger)) {
        return localBigInteger;
      }
      return localBigInteger.add(BigInteger.ONE);
    case 1: 
      MathPreconditions.checkRoundingUnnecessary(localBigInteger.pow(2).equals(paramBigInteger));
    }
    return localBigInteger;
  }
  
  public static BigInteger sqrtApproxWithDoubles(BigInteger paramBigInteger)
  {
    return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(paramBigInteger)), RoundingMode.HALF_EVEN);
  }
  
  public static BigInteger sqrtFloor(BigInteger paramBigInteger)
  {
    int i = log2(paramBigInteger, RoundingMode.FLOOR);
    BigInteger localBigInteger1;
    if (i < 1023)
    {
      localBigInteger1 = sqrtApproxWithDoubles(paramBigInteger);
    }
    else
    {
      i = i - 52 & 0xFFFFFFFE;
      localBigInteger1 = sqrtApproxWithDoubles(paramBigInteger.shiftRight(i)).shiftLeft(i >> 1);
    }
    BigInteger localBigInteger3 = localBigInteger1.add(paramBigInteger.divide(localBigInteger1)).shiftRight(1);
    BigInteger localBigInteger2 = localBigInteger3;
    if (localBigInteger1.equals(localBigInteger3)) {
      return localBigInteger1;
    }
    for (;;)
    {
      localBigInteger1 = localBigInteger2.add(paramBigInteger.divide(localBigInteger2)).shiftRight(1);
      if (localBigInteger1.compareTo(localBigInteger2) >= 0) {
        return localBigInteger2;
      }
      localBigInteger2 = localBigInteger1;
    }
  }
}
