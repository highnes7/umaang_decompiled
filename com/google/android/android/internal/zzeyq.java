package com.google.android.android.internal;

import java.io.IOException;

public final class zzeyq
{
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static int zzotu;
  public static int zzotv;
  public static int zzotw;
  public static int zzotx;
  public static final int[] zzoty = new int[0];
  public static final long[] zzotz = new long[0];
  public static final float[] zzoua = new float[0];
  public static double[] zzoub = new double[0];
  public static final boolean[] zzouc = new boolean[0];
  public static final byte[][] zzoud = new byte[0][];
  public static final byte[] zzoue = new byte[0];
  
  public static final int getRepeatedFieldArrayLength(zzeye paramZzeye, int paramInt)
    throws IOException
  {
    int j = paramZzeye.getPosition();
    paramZzeye.zzjl(paramInt);
    int i = 1;
    while (paramZzeye.zzcsn() == paramInt)
    {
      paramZzeye.zzjl(paramInt);
      i += 1;
    }
    paramZzeye.zzaj(j, paramInt);
    return i;
  }
}
