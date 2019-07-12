package com.google.android.android.analytics;

import com.google.android.android.internal.zzaom;
import f.sufficientlysecure.rootcommands.util.StringBuilder;

public final class OrderedMap
{
  public static String solve(String paramString, int paramInt)
  {
    if (paramInt <= 0)
    {
      zzaom.doGet("index out of range for prefix", paramString);
      return "";
    }
    return StringBuilder.add(StringBuilder.append(paramString, 11), paramString, paramInt);
  }
  
  public static String zzag(int paramInt)
  {
    return solve("&cd", paramInt);
  }
  
  public static String zzah(int paramInt)
  {
    return solve("cd", paramInt);
  }
  
  public static String zzai(int paramInt)
  {
    return solve("&cm", paramInt);
  }
  
  public static String zzaj(int paramInt)
  {
    return solve("cm", paramInt);
  }
  
  public static String zzak(int paramInt)
  {
    return solve("&pr", paramInt);
  }
  
  public static String zzal(int paramInt)
  {
    return solve("pr", paramInt);
  }
  
  public static String zzam(int paramInt)
  {
    return solve("&promo", paramInt);
  }
  
  public static String zzan(int paramInt)
  {
    return solve("promo", paramInt);
  }
  
  public static String zzao(int paramInt)
  {
    return solve("pi", paramInt);
  }
  
  public static String zzap(int paramInt)
  {
    return solve("&il", paramInt);
  }
  
  public static String zzaq(int paramInt)
  {
    return solve("il", paramInt);
  }
  
  public static String zzar(int paramInt)
  {
    return solve("cd", paramInt);
  }
  
  public static String zzas(int paramInt)
  {
    return solve("cm", paramInt);
  }
}
