package org.spongycastle.math.ec;

import java.math.BigInteger;

public abstract interface ECConstants
{
  public static final BigInteger EIGHT = BigInteger.valueOf(8L);
  public static final BigInteger FOUR;
  public static final BigInteger ONE;
  public static final BigInteger THREE;
  public static final BigInteger TWO;
  public static final BigInteger ZERO = BigInteger.valueOf(0L);
  
  static
  {
    ONE = BigInteger.valueOf(1L);
    TWO = BigInteger.valueOf(2L);
    THREE = BigInteger.valueOf(3L);
    FOUR = BigInteger.valueOf(4L);
  }
}
