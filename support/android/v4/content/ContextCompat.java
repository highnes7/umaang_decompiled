package support.android.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;
import java.util.HashMap;

public class ContextCompat
{
  public static final String TAG = "ContextCompat";
  public static final Object sLock = new Object();
  public static TypedValue sTempValue;
  
  public ContextCompat() {}
  
  public static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    for (File localFile = paramFile; i < j; localFile = paramFile)
    {
      String str = paramVarArgs[i];
      if (localFile == null)
      {
        paramFile = new File(str);
      }
      else
      {
        paramFile = localFile;
        if (str != null) {
          paramFile = new File(localFile, str);
        }
      }
      i += 1;
    }
    return localFile;
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    if (paramString != null) {
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
    }
    throw new IllegalArgumentException("permission is null");
  }
  
  public static Context createDeviceProtectedStorageContext(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.createDeviceProtectedStorageContext();
    }
    return null;
  }
  
  public static File createFilesDir(File paramFile)
  {
    try
    {
      if ((!paramFile.exists()) && (!paramFile.mkdirs()))
      {
        boolean bool = paramFile.exists();
        if (bool) {
          return paramFile;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to create files subdir ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.toString();
        return null;
      }
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      throw paramFile;
    }
  }
  
  public static File getCodeCacheDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getCodeCacheDir();
    }
    return createFilesDir(new File(getApplicationInfodataDir, "code_cache"));
  }
  
  public static int getColor(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  public static ColorStateList getColorStateList(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static File getDataDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.getDataDir();
    }
    paramContext = getApplicationInfodataDir;
    if (paramContext != null) {
      return new File(paramContext);
    }
    return null;
  }
  
  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  public static File[] getExternalCacheDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    return paramContext.getExternalCacheDirs();
  }
  
  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    return paramContext.getExternalFilesDirs(paramString);
  }
  
  public static File getNoBackupFilesDir(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getNoBackupFilesDir();
    }
    return createFilesDir(new File(getApplicationInfodataDir, "no_backup"));
  }
  
  public static File[] getObbDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    return paramContext.getObbDirs();
  }
  
  public static Object getSystemService(Context paramContext, Class paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getSystemService(paramClass);
    }
    paramClass = getSystemServiceName(paramContext, paramClass);
    if (paramClass != null) {
      return paramContext.getSystemService(paramClass);
    }
    return null;
  }
  
  public static String getSystemServiceName(Context paramContext, Class paramClass)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getSystemServiceName(paramClass);
    }
    return (String)ConnectionManager.instance.get(paramClass);
  }
  
  public static boolean isDeviceProtectedStorage(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramContext.isDeviceProtectedStorage();
    }
    return false;
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    startActivities(paramContext, paramArrayOfIntent, null);
    return true;
  }
  
  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    paramContext.startActivities(paramArrayOfIntent, paramBundle);
    return true;
  }
  
  public static void startActivity(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    paramContext.startActivity(paramIntent, paramBundle);
  }
  
  public static void startForegroundService(Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramContext.startForegroundService(paramIntent);
      return;
    }
    paramContext.startService(paramIntent);
  }
}
