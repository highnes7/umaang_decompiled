package f.g.c.navigation;

import f.g.c.package_10.Preconditions;
import java.math.BigInteger;

public final class DoubleUtils
{
  public static final int AppCompatTheme_selectableItemBackground = 52;
  public static final int EXPONENT_BIAS = 1023;
  public static final long EXPONENT_MASK = 9218868437227405312L;
  public static final long IMPLICIT_BIT = 4503599627370496L;
  public static final int MAX_CLIENT_PORT = 1023;
  public static final long ONE_BITS = Double.doubleToRawLongBits(1.0D);
  public static final int SIGNIFICAND_BITS = -1022;
  public static final long SIGNIFICAND_MASK = 4503599627370495L;
  public static final long SIGN_MASK = Long.MIN_VALUE;
  
  public DoubleUtils() {}
  
  public static double bigToDouble(BigInteger paramBigInteger)
  {
    BigInteger localBigInteger = paramBigInteger.abs();
    int i = localBigInteger.bitLength();
    int j = 1;
    int k = i - 1;
    if (k < 63) {
      return paramBigInteger.longValue();
    }
    if (k > 1023)
    {
      double d = paramBigInteger.signum();
      Double.isNaN(d);
      return d * Double.POSITIVE_INFINITY;
    }
    int m = k - 52 - 1;
    long l1 = localBigInteger.shiftRight(m).longValue();
    long l2 = l1 >> 1 & 0xFFFFFFFFFFFFF;
    if ((l1 & 1L) != 0L)
    {
      i = j;
      if ((l2 & 1L) != 0L) {
        break label128;
      }
      if (localBigInteger.getLowestSetBit() < m)
      {
        i = j;
        break label128;
      }
    }
    i = 0;
    label128:
    l1 = l2;
    if (i != 0) {
      l1 = l2 + 1L;
    }
    return Double.longBitsToDouble((k + 1023 << 52) + l1 | paramBigInteger.signum() & 0x8000000000000000);
  }
  
  public static double copySign(double paramDouble1, double paramDouble2)
  {
    return Double.longBitsToDouble(Double.doubleToRawLongBits(paramDouble1) & 0x7FFFFFFFFFFFFFFF | Double.doubleToRawLongBits(paramDouble2) & 0x8000000000000000);
  }
  
  public static double ensureNonNegative(double paramDouble)
  {
    Preconditions.checkArgument(Double.isNaN(paramDouble) ^ true);
    if (paramDouble > 0.0D) {
      return paramDouble;
    }
    return 0.0D;
  }
  
  public static int getExponent(double paramDouble)
  {
    return (int)((Double.doubleToRawLongBits(paramDouble) & 0x7FF0000000000000) >>> 52) - 1023;
  }
  
  public static long getSignificand(double paramDouble)
  {
    Preconditions.checkArgument(isFinite(paramDouble), "not a normal value");
    int i = getExponent(paramDouble);
    long l = Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFFFFFFF;
    if (i == 64513) {
      return l << 1;
    }
    return l | 0x10000000000000;
  }
  
  public static boolean isFinite(double paramDouble)
  {
    return getExponent(paramDouble) <= 1023;
  }
  
  public static boolean isNormal(double paramDouble)
  {
    return getExponent(paramDouble) >= 64514;
  }
  
  public static double nextDown(double paramDouble)
  {
    return -nextUp(-paramDouble);
  }
  
  public static double nextUp(double paramDouble)
  {
    if (!isFinite(paramDouble)) {
      return paramDouble;
    }
    if (paramDouble == 0.0D) {
      return Double.MIN_VALUE;
    }
    long l = Double.doubleToRawLongBits(paramDouble);
    return Double.longBitsToDouble(l + (l >> 63 | 1L));
  }
  
  public static double scaleNormalize(double paramDouble)
  {
    return Double.longBitsToDouble(Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFFFFFFF | ONE_BITS);
  }
}
