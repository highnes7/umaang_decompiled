package com.google.android.android.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

public final class ContextCompat
{
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
        paramFile = String.valueOf(paramFile.getPath());
        if (paramFile.length() != 0) {
          "Unable to create no-backup dir ".concat(paramFile);
        } else {
          new String("Unable to create no-backup dir ");
        }
        return null;
      }
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      throw paramFile;
    }
  }
  
  public static File getNoBackupFilesDir(Context paramContext)
  {
    if (KeyguardManager.zzalj()) {
      return paramContext.getNoBackupFilesDir();
    }
    return createFilesDir(new File(getApplicationInfodataDir, "no_backup"));
  }
}
