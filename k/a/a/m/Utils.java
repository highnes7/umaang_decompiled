package k.a.a.m;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Utils
{
  public Utils() {}
  
  public static boolean checkRootMethod2()
  {
    String[] arrayOfString = new String[9];
    arrayOfString[0] = "/system/app/Superuser.apk";
    arrayOfString[1] = "/sbin/su";
    arrayOfString[2] = "/system/bin/su";
    arrayOfString[3] = "/system/xbin/su";
    arrayOfString[4] = "/data/local/xbin/su";
    arrayOfString[5] = "/data/local/bin/su";
    arrayOfString[6] = "/system/sd/xbin/su";
    arrayOfString[7] = "/system/bin/failsafe/su";
    arrayOfString[8] = "/data/local/su";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (new File(arrayOfString[i]).exists()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean checkRootMethod3()
  {
    Object localObject = null;
    try
    {
      Process localProcess = Runtime.getRuntime().exec(new String[] { "/system/xbin/which", "su" });
      localObject = localProcess;
      String str = new BufferedReader(new InputStreamReader(localProcess.getInputStream())).readLine();
      if (str != null)
      {
        localProcess.destroy();
        return true;
      }
      localProcess.destroy();
      return false;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    if (localObject != null)
    {
      localObject.destroy();
      return false;
    }
    return false;
  }
  
  public static boolean isDeviceRooted()
  {
    return (checkRootMethod2()) || (checkRootMethod3());
  }
}
