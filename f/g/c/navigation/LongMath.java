package f.g.c.navigation;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.a.c;
import f.g.c.a.d;
import f.g.c.package_10.Preconditions;
import java.math.RoundingMode;

@a
@b(emulated=true)
public final class LongMath
{
  @c("TODO")
  @d
  public static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
  @d
  public static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
  public static final int[] biggestBinomials = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66 };
  @d
  public static final int[] biggestSimpleBinomials = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61 };
  public static final long[] factorials;
  @c("TODO")
  @d
  public static final long[] halfPowersOf10;
  @d
  public static final byte[] maxLog10ForLeadingZeros = { 19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0 };
  @c("TODO")
  @d
  public static final long[] powersOf10 = { 1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L };
  
  static
  {
    halfPowersOf10 = new long[] { 3L, 31L, 316L, 3162L, 31622L, 316227L, 3162277L, 31622776L, 316227766L, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L };
    factorials = new long[] { 1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L };
  }
  
  public LongMath() {}
  
  public static long binomial(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("n", paramInt1);
    MathPreconditions.checkNonNegative("k", paramInt2);
    int k = 0;
    int m = 1;
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
    int[] arrayOfInt = biggestBinomials;
    long l2;
    if ((i < arrayOfInt.length) && (paramInt1 <= arrayOfInt[i]))
    {
      long l1 = 1L;
      arrayOfInt = biggestSimpleBinomials;
      paramInt2 = m;
      l2 = l1;
      int j = paramInt1;
      if (i < arrayOfInt.length)
      {
        paramInt2 = m;
        l2 = l1;
        j = paramInt1;
        if (paramInt1 <= arrayOfInt[i])
        {
          paramInt2 = k;
          while (paramInt2 < i)
          {
            l2 = paramInt1 - paramInt2;
            paramInt2 += 1;
            l1 = l1 * l2 / paramInt2;
          }
        }
      }
      while (paramInt2 <= i)
      {
        paramInt1 = IntMath.gcd(j, paramInt2);
        l2 = l2 / (paramInt2 / paramInt1) * (j / paramInt1);
        paramInt2 += 1;
        j -= 1;
      }
      return l1;
    }
    return Long.MAX_VALUE;
    return l2;
  }
  
  public static long checkedAdd(long paramLong1, long paramLong2)
  {
    long l = paramLong1 + paramLong2;
    int j = 1;
    int i;
    if ((paramLong2 ^ paramLong1) < 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramLong1 ^ l) < 0L) {
      j = 0;
    }
    MathPreconditions.checkNoOverflow(i | j);
    return l;
  }
  
  public static long checkedMultiply(long paramLong1, long paramLong2)
  {
    int i = Long.numberOfLeadingZeros(paramLong1);
    int j = Long.numberOfLeadingZeros(paramLong1);
    int k = Long.numberOfLeadingZeros(paramLong2);
    i = Long.numberOfLeadingZeros(0xFFFFFFFFFFFFFFFF ^ paramLong2) + (k + (j + i));
    if (i > 65) {
      return paramLong1 * paramLong2;
    }
    boolean bool2 = true;
    if (i >= 64) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    MathPreconditions.checkNoOverflow(bool1);
    if (paramLong1 >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramLong2 != Long.MIN_VALUE) {
      j = 1;
    } else {
      j = 0;
    }
    MathPreconditions.checkNoOverflow(i | j);
    long l = paramLong1 * paramLong2;
    boolean bool1 = bool2;
    if (paramLong1 != 0L) {
      if (l / paramLong1 == paramLong2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    MathPreconditions.checkNoOverflow(bool1);
    return l;
  }
  
  public static long checkedPow(long paramLong, int paramInt)
  {
    MathPreconditions.checkNonNegative("exponent", paramInt);
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if (paramLong >= -2L) {
      i = 1;
    } else {
      i = 0;
    }
    int k;
    if (paramLong <= 2L) {
      k = 1;
    } else {
      k = 0;
    }
    long l3 = 1L;
    long l1 = l3;
    long l2 = paramLong;
    int j = paramInt;
    if ((i & k) != 0)
    {
      i = (int)paramLong;
      if (i != -2)
      {
        if (i != -1)
        {
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                l1 = l3;
                l2 = paramLong;
                j = paramInt;
              }
              else
              {
                if (paramInt < 63) {
                  bool1 = true;
                }
                MathPreconditions.checkNoOverflow(bool1);
                return 1L << paramInt;
              }
            }
            else {
              return 1L;
            }
          }
          else
          {
            if (paramInt == 0) {
              return 1L;
            }
            return 0L;
          }
        }
        else
        {
          if ((paramInt & 0x1) == 0) {
            return 1L;
          }
          return -1L;
        }
      }
      else
      {
        bool1 = bool2;
        if (paramInt < 64) {
          bool1 = true;
        }
        MathPreconditions.checkNoOverflow(bool1);
        if ((paramInt & 0x1) == 0) {
          return 1L << paramInt;
        }
        return -1L << paramInt;
      }
    }
    while (j != 0) {
      if (j != 1)
      {
        paramLong = l1;
        if ((j & 0x1) != 0) {
          paramLong = checkedMultiply(l1, l2);
        }
        paramInt = j >> 1;
        l1 = paramLong;
        j = paramInt;
        if (paramInt > 0)
        {
          if (l2 <= 3037000499L) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          MathPreconditions.checkNoOverflow(bool1);
          l2 *= l2;
          l1 = paramLong;
          j = paramInt;
        }
      }
      else
      {
        return checkedMultiply(l1, l2);
      }
    }
    return l1;
  }
  
  public static long checkedSubtract(long paramLong1, long paramLong2)
  {
    long l = paramLong1 - paramLong2;
    int j = 1;
    int i;
    if ((paramLong2 ^ paramLong1) >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramLong1 ^ l) < 0L) {
      j = 0;
    }
    MathPreconditions.checkNoOverflow(i | j);
    return l;
  }
  
  public static long divide(long paramLong1, long paramLong2, RoundingMode paramRoundingMode)
  {
    long l1;
    if (paramRoundingMode != null)
    {
      l1 = paramLong1 / paramLong2;
      long l2 = paramLong1 - paramLong2 * l1;
      if (l2 == 0L) {
        return l1;
      }
      int i = (int)((paramLong1 ^ paramLong2) >> 63);
      boolean bool = true;
      int j = 1;
      int k = 1;
      int m = i | 0x1;
      i = j;
      switch (IntMath.1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
      {
      default: 
        throw new AssertionError();
      case 6: 
      case 7: 
      case 8: 
        paramLong1 = Math.abs(l2);
        paramLong1 -= Math.abs(paramLong2) - paramLong1;
        if (paramLong1 == 0L)
        {
          if (paramRoundingMode == RoundingMode.HALF_UP) {
            i = 1;
          } else {
            i = 0;
          }
          if (paramRoundingMode == RoundingMode.HALF_EVEN) {
            j = 1;
          } else {
            j = 0;
          }
          if ((1L & l1) == 0L) {
            k = 0;
          }
          i = k & j | i;
        }
        else if (paramLong1 > 0L)
        {
          i = j;
        }
        break;
      case 5: 
        if (m > 0) {
          i = j;
        }
        break;
      case 3: 
        if (m < 0) {
          i = j;
        }
        break;
      case 1: 
        if (l2 != 0L) {
          bool = false;
        }
        MathPreconditions.checkRoundingUnnecessary(bool);
      case 2: 
        i = 0;
      }
      if (i != 0) {
        return l1 + m;
      }
    }
    else
    {
      throw new NullPointerException();
    }
    return l1;
  }
  
  public static long factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    long[] arrayOfLong = factorials;
    if (paramInt < arrayOfLong.length) {
      return arrayOfLong[paramInt];
    }
    return Long.MAX_VALUE;
  }
  
  public static boolean fitsInInt(long paramLong)
  {
    return (int)paramLong == paramLong;
  }
  
  public static long gcd(long paramLong1, long paramLong2)
  {
    MathPreconditions.checkNonNegative("a", paramLong1);
    MathPreconditions.checkNonNegative("b", paramLong2);
    if (paramLong1 == 0L) {
      return paramLong2;
    }
    if (paramLong2 == 0L) {
      return paramLong1;
    }
    int i = Long.numberOfTrailingZeros(paramLong1);
    long l = paramLong1 >> i;
    int j = Long.numberOfTrailingZeros(paramLong2);
    paramLong1 = paramLong2 >> j;
    for (paramLong2 = l; paramLong2 != paramLong1; paramLong2 = l >> Long.numberOfTrailingZeros(l))
    {
      l = paramLong2 - paramLong1;
      paramLong2 = l >> 63 & l;
      l = l - paramLong2 - paramLong2;
      paramLong1 += paramLong2;
    }
    return paramLong2 << Math.min(i, j);
  }
  
  public static boolean isPowerOfTwo(long paramLong)
  {
    int j = 1;
    int i;
    if (paramLong > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramLong & paramLong - 1L) != 0L) {
      j = 0;
    }
    return i & j;
  }
  
  public static int log10(long paramLong, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramLong);
    if (fitsInInt(paramLong)) {
      return IntMath.log10((int)paramLong, paramRoundingMode);
    }
    int i = log10Floor(paramLong);
    long l = powersOf10[i];
    switch (IntMath.1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 6: 
    case 7: 
    case 8: 
      if (paramLong <= halfPowersOf10[i]) {
        return i;
      }
      return i + 1;
    case 4: 
    case 5: 
      if (paramLong == l) {
        return i;
      }
      return i + 1;
    case 1: 
      boolean bool;
      if (paramLong == l) {
        bool = true;
      } else {
        bool = false;
      }
      MathPreconditions.checkRoundingUnnecessary(bool);
    }
    return i;
  }
  
  public static int log10Floor(long paramLong)
  {
    int i = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(paramLong)];
    return i - (int)(paramLong - powersOf10[i] >>> 63);
  }
  
  public static int log2(long paramLong, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramLong);
    switch (IntMath.1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError("impossible");
    case 6: 
    case 7: 
    case 8: 
      int i = Long.numberOfLeadingZeros(paramLong);
      int j = 63 - i;
      if (paramLong <= -5402926248376769404L >>> i) {
        return j;
      }
      return j + 1;
    case 4: 
    case 5: 
      return 64 - Long.numberOfLeadingZeros(paramLong - 1L);
    case 1: 
      MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramLong));
    }
    return 63 - Long.numberOfLeadingZeros(paramLong);
  }
  
  public static int mod(long paramLong, int paramInt)
  {
    return (int)mod(paramLong, paramInt);
  }
  
  public static long mod(long paramLong1, long paramLong2)
  {
    if (paramLong2 > 0L)
    {
      paramLong1 %= paramLong2;
      if (paramLong1 >= 0L) {
        return paramLong1;
      }
      return paramLong1 + paramLong2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Modulus ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" must be > 0");
    throw new ArithmeticException(localStringBuilder.toString());
  }
  
  public static long pow(long paramLong, int paramInt)
  {
    MathPreconditions.checkNonNegative("exponent", paramInt);
    if ((-2L <= paramLong) && (paramLong <= 2L))
    {
      int i = (int)paramLong;
      if (i != -2)
      {
        if (i != -1)
        {
          if (i != 0)
          {
            if (i != 1)
            {
              if (i == 2)
              {
                if (paramInt >= 64) {
                  break label159;
                }
                return 1L << paramInt;
              }
            }
            else {
              return 1L;
            }
          }
          else
          {
            if (paramInt == 0) {
              return 1L;
            }
            return 0L;
          }
        }
        else
        {
          if ((paramInt & 0x1) == 0) {
            return 1L;
          }
          return -1L;
        }
      }
      else
      {
        if (paramInt < 64)
        {
          if ((paramInt & 0x1) == 0) {
            return 1L << paramInt;
          }
          return -(1L << paramInt);
        }
        return 0L;
      }
    }
    long l1 = 1L;
    for (;;)
    {
      if (paramInt == 0) {
        break label161;
      }
      if (paramInt == 1) {
        break;
      }
      long l2;
      if ((paramInt & 0x1) == 0) {
        l2 = 1L;
      } else {
        l2 = paramLong;
      }
      l1 *= l2;
      paramLong *= paramLong;
      paramInt >>= 1;
    }
    return l1 * paramLong;
    label159:
    return 0L;
    label161:
    return l1;
  }
  
  public static long sqrt(long paramLong, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkNonNegative("x", paramLong);
    if (fitsInInt(paramLong)) {
      return IntMath.sqrt((int)paramLong, paramRoundingMode);
    }
    long l1 = sqrtFloor(paramLong);
    int i = IntMath.1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()];
    boolean bool = true;
    int j = 1;
    switch (i)
    {
    default: 
      throw new AssertionError();
    case 6: 
    case 7: 
    case 8: 
      Long.signum(l1);
      long l2 = l1 * l1 + l1;
      if (l2 >= paramLong) {
        i = 1;
      } else {
        i = 0;
      }
      if (l2 >= 0L) {
        j = 0;
      }
      if ((i | j) != 0) {
        return l1;
      }
      return l1 + 1L;
    case 4: 
    case 5: 
      if (l1 * l1 == paramLong) {
        return l1;
      }
      return l1 + 1L;
    case 1: 
      if (l1 * l1 != paramLong) {
        bool = false;
      }
      MathPreconditions.checkRoundingUnnecessary(bool);
    }
    return l1;
  }
  
  public static long sqrtFloor(long paramLong)
  {
    long l3 = Math.sqrt(paramLong);
    long l2 = paramLong / l3 + l3 >> 1;
    long l1 = l2;
    if (l2 == l3) {
      return l3;
    }
    for (;;)
    {
      l2 = paramLong / l1 + l1 >> 1;
      if (l2 >= l1) {
        return l1;
      }
      l1 = l2;
    }
  }
}
