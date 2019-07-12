package support.android.v4.app;

import android.os.Build.VERSION;

public class g
{
  public g() {}
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 28;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 27;
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
  
  public static boolean isScanAlawaysAvailable()
  {
    return Build.VERSION.SDK_INT >= 25;
  }
  
  public static boolean onItemClick()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static boolean parse()
  {
    return (Build.VERSION.CODENAME.length() == 1) && (Build.VERSION.CODENAME.charAt(0) >= 'Q') && (Build.VERSION.CODENAME.charAt(0) <= 'Z');
  }
}
