package com.google.android.android.tagmanager;

import android.os.Build.VERSION;
import java.io.File;

public final class zzbs
{
  public static int version()
  {
    String str = Build.VERSION.SDK;
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    str = String.valueOf(Build.VERSION.SDK);
    if (str.length() != 0) {
      str = "Invalid version number: ".concat(str);
    } else {
      str = new String("Invalid version number: ");
    }
    zzdj.zzjss.get(str);
    return 0;
  }
  
  public static boolean zzlr(String paramString)
  {
    if (version() < 9) {
      return false;
    }
    paramString = new File(paramString);
    paramString.setReadable(false, false);
    paramString.setWritable(false, false);
    paramString.setReadable(true, true);
    paramString.setWritable(true, true);
    return true;
  }
}
