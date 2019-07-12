package f.g.c.navigation;

import f.g.c.a.b;
import java.math.BigInteger;

@b
public final class MathPreconditions
{
  public MathPreconditions() {}
  
  public static void checkInRange(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new ArithmeticException("not in range");
  }
  
  public static void checkNoOverflow(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new ArithmeticException("overflow");
  }
  
  public static double checkNonNegative(String paramString, double paramDouble)
  {
    if (paramDouble >= 0.0D) {
      return paramDouble;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(") must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static int checkNonNegative(String paramString, int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(") must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static long checkNonNegative(String paramString, long paramLong)
  {
    if (paramLong >= 0L) {
      return paramLong;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(") must be >= 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static BigInteger checkNonNegative(String paramString, BigInteger paramBigInteger)
  {
    if (paramBigInteger != null)
    {
      if (paramBigInteger.signum() >= 0) {
        return paramBigInteger;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" (");
      localStringBuilder.append(paramBigInteger);
      localStringBuilder.append(") must be >= 0");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new NullPointerException();
  }
  
  public static int checkPositive(String paramString, int paramInt)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(") must be > 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static long checkPositive(String paramString, long paramLong)
  {
    if (paramLong > 0L) {
      return paramLong;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(") must be > 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static BigInteger checkPositive(String paramString, BigInteger paramBigInteger)
  {
    if (paramBigInteger.signum() > 0) {
      return paramBigInteger;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramBigInteger);
    localStringBuilder.append(") must be > 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static void checkRoundingUnnecessary(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
  }
}
