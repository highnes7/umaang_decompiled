package f.g.c.navigation;

import f.g.c.a.a;
import f.g.c.a.d;
import f.g.c.j.b;
import f.g.c.package_10.Preconditions;
import java.math.BigInteger;
import java.math.RoundingMode;

@a
public final class DoubleMath
{
  public static final double LN_2 = Math.log(2.0D);
  @d
  public static final int MAX_FACTORIAL = 170;
  public static final double MAX_INT_AS_DOUBLE = 2.147483647E9D;
  public static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18D;
  public static final double MIN_INT_AS_DOUBLE = -2.147483648E9D;
  public static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18D;
  @d
  public static final double[] everySixteenthFactorial = { 1.0D, 2.0922789888E13D, 2.631308369336935E35D, 1.2413915592536073E61D, 1.2688693218588417E89D, 7.156945704626381E118D, 9.916779348709496E149D, 1.974506857221074E182D, 3.856204823625804E215D, 5.5502938327393044E249D, 4.7147236359920616E284D };
  
  public DoubleMath() {}
  
  public static double factorial(int paramInt)
  {
    MathPreconditions.checkNonNegative("n", paramInt);
    if (paramInt > 170) {
      return Double.POSITIVE_INFINITY;
    }
    double d1 = 1.0D;
    int i = paramInt & 0xFFFFFFF0;
    for (;;)
    {
      i += 1;
      if (i > paramInt) {
        break;
      }
      double d2 = i;
      Double.isNaN(d2);
      d1 *= d2;
    }
    return d1 * everySixteenthFactorial[(paramInt >> 4)];
  }
  
  public static int fuzzyCompare(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (fuzzyEquals(paramDouble1, paramDouble2, paramDouble3)) {
      return 0;
    }
    if (paramDouble1 < paramDouble2) {
      return -1;
    }
    if (paramDouble1 > paramDouble2) {
      return 1;
    }
    return b.a(Double.isNaN(paramDouble1), Double.isNaN(paramDouble2));
  }
  
  public static boolean fuzzyEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    MathPreconditions.checkNonNegative("tolerance", paramDouble3);
    return (DoubleUtils.copySign(paramDouble1 - paramDouble2, 1.0D) <= paramDouble3) || (paramDouble1 == paramDouble2) || ((paramDouble1 != paramDouble1) && (paramDouble2 != paramDouble2));
  }
  
  public static boolean isMathematicalInteger(double paramDouble)
  {
    return (DoubleUtils.isFinite(paramDouble)) && ((paramDouble == 0.0D) || (52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(paramDouble)) <= DoubleUtils.getExponent(paramDouble)));
  }
  
  public static boolean isPowerOfTwo(double paramDouble)
  {
    return (paramDouble > 0.0D) && (DoubleUtils.isFinite(paramDouble)) && (LongMath.isPowerOfTwo(DoubleUtils.getSignificand(paramDouble)));
  }
  
  public static double log2(double paramDouble)
  {
    return Math.log(paramDouble) / LN_2;
  }
  
  public static int log2(double paramDouble, RoundingMode paramRoundingMode)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    boolean bool4;
    if ((paramDouble > 0.0D) && (DoubleUtils.isFinite(paramDouble))) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    Preconditions.checkArgument(bool4, "x must be positive and finite");
    int j = DoubleUtils.getExponent(paramDouble);
    if (!DoubleUtils.isNormal(paramDouble)) {
      return log2(paramDouble * 4.503599627370496E15D, paramRoundingMode) - 52;
    }
    boolean bool1 = bool3;
    switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
    {
    default: 
      throw new AssertionError();
    case 6: 
    case 7: 
    case 8: 
      paramDouble = DoubleUtils.scaleNormalize(paramDouble);
      bool1 = bool3;
      if (paramDouble * paramDouble > 2.0D) {
        bool1 = true;
      }
      break;
    case 5: 
      bool1 = i;
      if (j >= 0) {
        bool1 = true;
      }
      bool4 = isPowerOfTwo(paramDouble);
      break;
    case 4: 
      bool1 = bool2;
      if (j < 0) {
        bool1 = true;
      }
      bool4 = isPowerOfTwo(paramDouble);
      bool1 &= (bool4 ^ true);
      break;
    case 3: 
      bool1 = isPowerOfTwo(paramDouble) ^ true;
      break;
    case 1: 
      MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(paramDouble));
      bool1 = bool3;
    }
    i = j;
    if (bool1) {
      i = j + 1;
    }
    return i;
  }
  
  public static double roundIntermediate(double paramDouble, RoundingMode paramRoundingMode)
  {
    double d;
    if (DoubleUtils.isFinite(paramDouble))
    {
      switch (1.$SwitchMap$java$math$RoundingMode[paramRoundingMode.ordinal()])
      {
      default: 
        throw new AssertionError();
      case 8: 
        d = Math.rint(paramDouble);
        if (Math.abs(paramDouble - d) == 0.5D) {
          return paramDouble;
        }
        return d;
      case 7: 
        d = Math.rint(paramDouble);
        if (Math.abs(paramDouble - d) != 0.5D) {
          break;
        }
      case 6: 
      case 5: 
        for (d = DoubleUtils.copySign(0.5D, paramDouble);; d = DoubleUtils.copySign(1.0D, paramDouble))
        {
          return d + paramDouble;
          return Math.rint(paramDouble);
          if (isMathematicalInteger(paramDouble)) {
            return paramDouble;
          }
        }
      case 4: 
        return paramDouble;
      case 3: 
        if (paramDouble <= 0.0D) {
          return paramDouble;
        }
        if (isMathematicalInteger(paramDouble)) {
          return paramDouble;
        }
        return paramDouble + 1.0D;
      case 2: 
        if (paramDouble >= 0.0D) {
          return paramDouble;
        }
        if (isMathematicalInteger(paramDouble)) {
          return paramDouble;
        }
        return paramDouble - 1.0D;
      case 1: 
        MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(paramDouble));
        return paramDouble;
      }
    }
    else
    {
      paramRoundingMode = new ArithmeticException("input is infinite or NaN");
      throw paramRoundingMode;
    }
    return d;
    return paramDouble;
  }
  
  public static BigInteger roundToBigInteger(double paramDouble, RoundingMode paramRoundingMode)
  {
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int j = 1;
    if (-9.223372036854776E18D - paramDouble < 1.0D) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramDouble >= 9.223372036854776E18D) {
      j = 0;
    }
    if ((j & i) != 0) {
      return BigInteger.valueOf(paramDouble);
    }
    int i = DoubleUtils.getExponent(paramDouble);
    BigInteger localBigInteger = BigInteger.valueOf(DoubleUtils.getSignificand(paramDouble)).shiftLeft(i - 52);
    paramRoundingMode = localBigInteger;
    if (paramDouble < 0.0D) {
      paramRoundingMode = localBigInteger.negate();
    }
    return paramRoundingMode;
  }
  
  public static int roundToInt(double paramDouble, RoundingMode paramRoundingMode)
  {
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int j = 1;
    int i;
    if (paramDouble > -2.147483649E9D) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramDouble >= 2.147483648E9D) {
      j = 0;
    }
    MathPreconditions.checkInRange(j & i);
    return (int)paramDouble;
  }
  
  public static long roundToLong(double paramDouble, RoundingMode paramRoundingMode)
  {
    paramDouble = roundIntermediate(paramDouble, paramRoundingMode);
    int j = 1;
    int i;
    if (-9.223372036854776E18D - paramDouble < 1.0D) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramDouble >= 9.223372036854776E18D) {
      j = 0;
    }
    MathPreconditions.checkInRange(j & i);
    return paramDouble;
  }
}
