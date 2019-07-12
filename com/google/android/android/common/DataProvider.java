package com.google.android.android.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.internal.zzbec;
import com.google.android.android.internal.zzbed;

public class DataProvider
{
  public static DataProvider zzfgc;
  public final Context mContext;
  
  public DataProvider(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
  }
  
  public static Vector2D add(PackageInfo paramPackageInfo, Vector2D... paramVarArgs)
  {
    paramPackageInfo = signatures;
    if (paramPackageInfo == null) {
      return null;
    }
    if (paramPackageInfo.length != 1) {
      return null;
    }
    int i = 0;
    paramPackageInfo = new ZipOutputStream(paramPackageInfo[0].toByteArray());
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean add(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    Object localObject = signatures;
    if (localObject.length != 1) {
      return false;
    }
    localObject = new ZipOutputStream(localObject[0].toByteArray());
    paramPackageInfo = packageName;
    boolean bool;
    if (paramBoolean) {
      bool = Vector3.set(paramPackageInfo, (Vector2D)localObject);
    } else {
      bool = Vector3.add(paramPackageInfo, (Vector2D)localObject);
    }
    if (!bool)
    {
      paramPackageInfo = new StringBuilder(27);
      paramPackageInfo.append("Cert not in list. atk=");
      paramPackageInfo.append(paramBoolean);
      paramPackageInfo.toString();
    }
    return bool;
  }
  
  public static boolean backup(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (signatures != null))
    {
      if (paramBoolean) {
        paramPackageInfo = add(paramPackageInfo, Bookshelf.zzffs);
      } else {
        paramPackageInfo = add(paramPackageInfo, new Vector2D[] { Bookshelf.zzffs[0] });
      }
      if (paramPackageInfo != null) {
        return true;
      }
    }
    return false;
  }
  
  public static DataProvider zzbz(Context paramContext)
  {
    zzbp.append(paramContext);
    try
    {
      if (zzfgc == null)
      {
        Vector3.zzbx(paramContext);
        zzfgc = new DataProvider(paramContext);
      }
      return zzfgc;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private final boolean zzfs(String paramString)
  {
    Context localContext = mContext;
    boolean bool;
    try
    {
      paramString = zzbed.zzcr(localContext).getPackageInfo(paramString, 64);
      if (paramString == null) {
        return false;
      }
      localContext = mContext;
      bool = TransactionInput.zzby(localContext);
      if (bool)
      {
        bool = add(paramString, true);
        return bool;
      }
      bool = add(paramString, false);
      if (!bool)
      {
        add(paramString, true);
        return bool;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      return false;
    }
    return bool;
  }
  
  public final boolean backup(PackageManager paramPackageManager, PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo != null)
    {
      if (backup(paramPackageInfo, false)) {
        return true;
      }
      if ((backup(paramPackageInfo, true)) && (TransactionInput.zzby(mContext))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean zzbo(int paramInt)
  {
    String[] arrayOfString = zzbed.zzcr(mContext).getPackagesForUid(paramInt);
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return false;
      }
      int i = arrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (zzfs(arrayOfString[paramInt])) {
          return true;
        }
        paramInt += 1;
      }
    }
    return false;
  }
}
