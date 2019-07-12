package f.g.c.navigation;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.a.d;
import f.g.c.package_10.Preconditions;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.math.RoundingMode;

@a
@b(emulated=true)
public final class IntMath
{
  @d
  public static final int FLOOR_SQRT_MAX_INT = 46340;
  @d
  public static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
  @d
  public static int[] biggestBinomials = { Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33 };
  public static final int[] factorials;
  @d
  public static final int[] halfPowersOf10;
  @d
  public static final byte[] maxLog10ForLeadingZeros = { 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0 };
  @d
  public static final int[] powersOf10 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
  
  static
  {
    halfPowersOf10 = new int[] { 3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE };
    factorials = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };
  }
  
  public IntMath() {}
  
  public static int binomial(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("n", paramInt1);
    MathPreconditions.checkNonNegative("k", paramInt2);
    int j = 0;
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
    if ((i < arrayOfInt.length) && (paramInt1 <= arrayOfInt[i]))
    {
      if (i != 0)
      {
        if (i != 1)
        {
          long l1 = 1L;
          paramInt2 = j;
          while (paramInt2 < i)
          {
            long l2 = paramInt1 - paramInt2;
            paramInt2 += 1;
            l1 = l1 * l2 / paramInt2;
          }
          return (int)l1;
        }
      }
      else {
        return 1;
      }
    }
    else {
      return Integer.MAX_VALUE;
    }
    return paramInt1;
  }
  
  public static int checkedAdd(int paramInt1, int paramInt2)
  {
    long l = paramInt1 + paramInt2;
    paramInt1 = (int)l;
    boolean bool;
    if (l == paramInt1) {
      bool = true;
    } else {
      bool = false;
    }
    MathPreconditions.checkNoOverflow(bool);
    return paramInt1;
  }
  
  public static int checkedMultiply(int paramInt1, int paramInt2)
  {
    long l = paramInt1 * paramInt2;
    paramInt1 = (int)l;
    boolean bool;
    if (l == paramInt1) {
      bool = true;
    } else {
      bool = false;
    }
    MathPreconditions.checkNoOverflow(bool);
    return paramInt1;
  }
  
  public static int checkedPow(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    boolean bool2 = false;
    boolean bool1 = false;
    int j;
    if (paramInt1 != -2)
    {
      if (paramInt1 != -1)
      {
        if (paramInt1 != 0)
        {
          if (paramInt1 != 1)
          {
            if (paramInt1 != 2)
            {
              j = 1;
              int i = paramInt2;
              for (;;)
              {
                if (i == 0) {
                  break label196;
                }
                if (i == 1) {
                  break;
                }
                paramInt2 = j;
                if ((i & 0x1) != 0) {
                  paramInt2 = checkedMultiply(j, paramInt1);
                }
                int k = i >> 1;
                j = paramInt2;
                i = k;
                if (k > 0)
                {
                  if (-46340 <= paramInt1) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  if (paramInt1 <= 46340) {
                    j = 1;
                  } else {
                    j = 0;
                  }
                  MathPreconditions.checkNoOverflow(i & j);
                  paramInt1 *= paramInt1;
                  j = paramInt2;
                  i = k;
                }
              }
              return checkedMultiply(j, paramInt1);
            }
            if (paramInt2 < 31) {
              bool1 = true;
            }
            MathPreconditions.checkNoOverflow(bool1);
            return 1 << paramInt2;
          }
          return 1;
        }
        if (paramInt2 == 0) {
          return 1;
        }
      }
      else
      {
        if ((paramInt2 & 0x1) != 0) {
          break label200;
        }
        return 1;
      }
    }
    else
    {
      bool1 = bool2;
      if (paramInt2 < 32) {
        bool1 = true;
      }
      MathPreconditions.checkNoOverflow(bool1);
      if ((paramInt2 & 0x1) == 0) {
        return 1 << paramInt2;
      }
      return -1 << paramInt2;
      label196:
      return j;
    }
    return 0;
    label200:
    return -1;
  }
  
  public static int checkedSubtract(int paramInt1, int paramInt2)
  {
    long l = paramInt1 - paramInt2;
    paramInt1 = (int)l;
    boolean bool;
    if (l == paramInt1) {
      bool = true;
    } else {
      bool = false;
    }
    MathPreconditions.checkNoOverflow(bool);
    return paramInt1;
  }
  
  public static int divide(int paramInt1, int paramInt2, RoundingMode paramRoundingMode)
  {
    int j;
    if (paramRoundingMode != null)
    {
      if (paramInt2 != 0)
      {
        j = paramInt1 / paramInt2;
        int m = paramInt1 - paramInt2 * j;
        if (m == 0) {
          return j;
        }
        int i = 1;
        boolean bool = true;
        int k = (paramInt1 ^ paramInt2) >> 31 | 0x1;
        paramInt1 = i;
        switch (LongMath.1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
        {
        default: 
          throw new AssertionError();
        case 6: 
        case 7: 
        case 8: 
          paramInt1 = Math.abs(m);
          paramInt1 -= Math.abs(paramInt2) - paramInt1;
          if (paramInt1 == 0)
          {
            paramInt1 = i;
            if (paramRoundingMode == RoundingMode.HALF_UP) {
              break label253;
            }
            if (paramRoundingMode == RoundingMode.HALF_EVEN) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            if ((j & 0x1) != 0) {
              paramInt2 = 1;
            } else {
              paramInt2 = 0;
            }
            if ((paramInt1 & paramInt2) != 0)
            {
              paramInt1 = i;
              break label253;
            }
          }
          else if (paramInt1 > 0)
          {
            paramInt1 = i;
          }
          break;
        case 5: 
          if (k > 0) {
            paramInt1 = i;
          }
          break;
        case 3: 
          if (k < 0) {
            paramInt1 = i;
          }
          break;
        case 1: 
          if (m != 0) {
            bool = false;
          }
          MathPreconditions.checkRoundingUnnecessary(bool);
        case 2: 
          paramInt1 = 0;
        }
        label253:
        if (paramInt1 != 0) {
          return j + k;
        }
      }
      else
      {
        throw new ArithmeticException("/ by zero");
      }
    }
    else {
      throw new NullPointerException();
    }
    return j;
  }
  
  public static int factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    int[] arrayOfInt = factorials;
    if (paramInt < arrayOfInt.length) {
      return arrayOfInt[paramInt];
    }
    return Integer.MAX_VALUE;
  }
  
  public static int gcd(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("a", paramInt1);
    MathPreconditions.checkNonNegative("b", paramInt2);
    if (paramInt1 == 0) {
      return paramInt2;
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    int j = Integer.numberOfTrailingZeros(paramInt1);
    int i = paramInt1 >> j;
    int k = Integer.numberOfTrailingZeros(paramInt2);
    paramInt1 = paramInt2 >> k;
    for (paramInt2 = i; paramInt2 != paramInt1; paramInt2 = i >> Integer.numberOfTrailingZeros(i))
    {
      i = paramInt2 - paramInt1;
      paramInt2 = i >> 31 & i;
      i = i - paramInt2 - paramInt2;
      paramInt1 += paramInt2;
    }
    return paramInt2 << Math.min(j, k);
  }
  
  public static boolean isPowerOfTwo(int paramInt)
  {
    int j = 0;
    int i;
    if (paramInt > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt & paramInt - 1) == 0) {
      j = 1;
    }
    return i & j;
  }
  
  public static int log10(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramInt);
    int i = log10Floor(paramInt);
    int j = powersOf10[i];
    switch (LongMath.1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 6: 
    case 7: 
    case 8: 
      if (paramInt <= halfPowersOf10[i]) {
        return i;
      }
      return i + 1;
    case 4: 
    case 5: 
      if (paramInt == j) {
        return i;
      }
      return i + 1;
    case 1: 
      boolean bool;
      if (paramInt == j) {
        bool = true;
      } else {
        bool = false;
      }
      MathPreconditions.checkRoundingUnnecessary(bool);
    }
    return i;
  }
  
  public static int log10Floor(int paramInt)
  {
    int i = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(paramInt)];
    return i - (paramInt - powersOf10[i] >>> 31);
  }
  
  public static int log2(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkPositive("x", paramInt);
    switch (LongMath.1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 6: 
    case 7: 
    case 8: 
      int i = Integer.numberOfLeadingZeros(paramInt);
      int j = 31 - i;
      if (paramInt <= -1257966797 >>> i) {
        return j;
      }
      return j + 1;
    case 4: 
    case 5: 
      return 32 - Integer.numberOfLeadingZeros(paramInt - 1);
    case 1: 
      MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramInt));
    }
    return 31 - Integer.numberOfLeadingZeros(paramInt);
  }
  
  public static int mod(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      paramInt1 %= paramInt2;
      if (paramInt1 >= 0) {
        return paramInt1;
      }
      return paramInt1 + paramInt2;
    }
    throw new ArithmeticException(StringBuilder.toString("Modulus ", paramInt2, " must be > 0"));
  }
  
  public static int pow(int paramInt1, int paramInt2)
  {
    MathPreconditions.checkNonNegative("exponent", paramInt2);
    if (paramInt1 != -2)
    {
      if (paramInt1 != -1)
      {
        if (paramInt1 != 0)
        {
          if (paramInt1 != 1)
          {
            if (paramInt1 != 2)
            {
              int i = 1;
              while (paramInt2 != 0) {
                if (paramInt2 != 1)
                {
                  int j;
                  if ((paramInt2 & 0x1) == 0) {
                    j = 1;
                  } else {
                    j = paramInt1;
                  }
                  i *= j;
                  paramInt1 *= paramInt1;
                  paramInt2 >>= 1;
                }
                else
                {
                  return paramInt1 * i;
                }
              }
              return i;
            }
            if (paramInt2 < 32) {
              return 1 << paramInt2;
            }
          }
          else
          {
            return 1;
          }
        }
        else if (paramInt2 == 0) {
          return 1;
        }
      }
      else
      {
        if ((paramInt2 & 0x1) != 0) {
          break label126;
        }
        return 1;
      }
    }
    else if (paramInt2 < 32)
    {
      if ((paramInt2 & 0x1) == 0) {
        return 1 << paramInt2;
      }
      return -(1 << paramInt2);
    }
    return 0;
    label126:
    return -1;
  }
  
  public static int sqrt(int paramInt, RoundingMode paramRoundingMode)
  {
    MathPreconditions.checkNonNegative("x", paramInt);
    int j = sqrtFloor(paramInt);
    int k = LongMath.1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()];
    boolean bool = false;
    int i = 0;
    switch (k)
    {
    default: 
      throw new AssertionError();
    case 6: 
    case 7: 
    case 8: 
      k = j * j + j;
      if (paramInt <= k) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (k < 0) {
        i = 1;
      }
      if ((paramInt | i) != 0) {
        return j;
      }
      return j + 1;
    case 4: 
    case 5: 
      if (j * j == paramInt) {
        return j;
      }
      return j + 1;
    case 1: 
      if (j * j == paramInt) {
        bool = true;
      }
      MathPreconditions.checkRoundingUnnecessary(bool);
    }
    return j;
  }
  
  public static int sqrtFloor(int paramInt)
  {
    return (int)Math.sqrt(paramInt);
  }
}
