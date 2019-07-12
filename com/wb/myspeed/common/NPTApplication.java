package com.wb.myspeed.common;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import f.p.a.SocketAddress;
import f.p.a.b.f;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class NPTApplication
  extends Application
{
  public static String a;
  public static boolean b;
  public static File d;
  public static ApplicationInfo mInfo;
  public static String packageName;
  public static boolean showIcons;
  public static boolean transport_tcp;
  public static boolean transport_tls;
  public static String versionName;
  public static boolean y;
  
  public NPTApplication() {}
  
  public static void doInBackground(Context paramContext)
  {
    f.p.a.b.ClassWriter.i = f.parseFeed();
    Object localObject = new ContextWrapper(paramContext);
    if (!b)
    {
      d = ((ContextWrapper)localObject).getDir("NPT", 0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramContext.getString(SocketAddress.app_name));
      d = new File(((StringBuilder)localObject).toString());
    }
    if (!d.exists()) {
      d.mkdir();
    }
    try
    {
      localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      versionName = versionName;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    packageName = f.getString(paramContext, "uuid", "");
    paramContext = paramContext.getPackageManager().getInstalledApplications(0).iterator();
    while (paramContext.hasNext())
    {
      localObject = (ApplicationInfo)paramContext.next();
      if (packageName.equals("com.rma.myspeed"))
      {
        mInfo = (ApplicationInfo)localObject;
        return;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    f.p.a.b.ClassWriter.i = f.parseFeed();
    Object localObject = new ContextWrapper(this);
    if (!b)
    {
      d = ((ContextWrapper)localObject).getDir("NPT", 0);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(getString(SocketAddress.app_name));
      d = new File(((StringBuilder)localObject).toString());
    }
    if (!d.exists()) {
      d.mkdir();
    }
    try
    {
      localObject = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
      versionName = versionName;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    packageName = f.getString(this, "uuid", "");
    localObject = getPackageManager().getInstalledApplications(0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApplicationInfo localApplicationInfo = (ApplicationInfo)((Iterator)localObject).next();
      if (packageName.equals("com.rma.myspeed"))
      {
        mInfo = localApplicationInfo;
        return;
      }
    }
  }
}
