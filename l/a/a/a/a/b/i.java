package l.a.a.a.a.b;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import l.a.a.a.Log;
import l.a.a.a.f;

public class i
{
  public static final String e = "@string/twitter_consumer_secret";
  public static final String g = "io.fabric.ApiKey";
  public static final String t = "com.crashlytics.ApiKey";
  
  public i() {}
  
  public static String b(Context paramContext, boolean paramBoolean)
  {
    f.get().remove("Fabric", "getApiKey(context, debug) is deprecated, please upgrade kit(s) to the latest version.");
    return new i().a(paramContext);
  }
  
  public static String d(Context paramContext)
  {
    f.get().remove("Fabric", "getApiKey(context) is deprecated, please upgrade kit(s) to the latest version.");
    return new i().a(paramContext);
  }
  
  public String a(Context paramContext)
  {
    Object localObject2 = get(paramContext);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = c(paramContext);
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = b(paramContext);
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      close(paramContext);
    }
    return localObject2;
  }
  
  public String b(Context paramContext)
  {
    return new h().b(paramContext);
  }
  
  public String c(Context paramContext)
  {
    int j = ClassWriter.a(paramContext, "io.fabric.ApiKey", "string");
    int i = j;
    if (j == 0)
    {
      f.get().d("Fabric", "Falling back to Crashlytics key lookup from Strings");
      i = ClassWriter.a(paramContext, "com.crashlytics.ApiKey", "string");
    }
    if (i != 0) {
      return paramContext.getResources().getString(i);
    }
    return null;
  }
  
  public void close(Context paramContext)
  {
    if ((!f.d()) && (!ClassWriter.isDebugMode(paramContext)))
    {
      f.get().e("Fabric", getTitle());
      return;
    }
    throw new IllegalArgumentException(getTitle());
  }
  
  public String get(Context paramContext)
  {
    StringBuilder localStringBuilder = null;
    Object localObject2 = null;
    Object localObject1 = localStringBuilder;
    try
    {
      Object localObject3 = paramContext.getPackageName();
      localObject1 = localStringBuilder;
      paramContext = paramContext.getPackageManager().getApplicationInfo((String)localObject3, 128);
      localObject3 = metaData;
      if (localObject3 == null) {
        break label168;
      }
      localObject1 = localStringBuilder;
      paramContext = ((Bundle)localObject3).getString("io.fabric.ApiKey");
      try
      {
        boolean bool = "@string/twitter_consumer_secret".equals(paramContext);
        if (bool)
        {
          f.get().d("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
          paramContext = localObject2;
        }
        if (paramContext != null) {
          return paramContext;
        }
        localObject1 = paramContext;
        f.get().d("Fabric", "Falling back to Crashlytics key lookup from Manifest");
        localObject1 = paramContext;
        paramContext = ((Bundle)localObject3).getString("com.crashlytics.ApiKey");
        return paramContext;
      }
      catch (Exception localException)
      {
        localObject1 = paramContext;
        paramContext = localException;
      }
      localLog = f.get();
    }
    catch (Exception paramContext) {}
    Log localLog;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Caught non-fatal exception while retrieving apiKey: ");
    localStringBuilder.append(paramContext);
    localLog.d("Fabric", localStringBuilder.toString());
    return localObject1;
    label168:
    return null;
    return paramContext;
  }
  
  public String getTitle()
  {
    return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
  }
}
