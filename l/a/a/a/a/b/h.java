package l.a.a.a.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import l.a.a.a.Log;
import l.a.a.a.f;

public class h
{
  public static final String A = "io.fabric.auto_initialize";
  public static final String F = "com.crashlytics.useFirebaseAppId";
  public static final String t = "google_app_id";
  
  public h() {}
  
  public boolean a(Context paramContext)
  {
    if (ClassWriter.getBoolean(paramContext, "com.crashlytics.useFirebaseAppId", false)) {
      return true;
    }
    return (c(paramContext)) && (!d(paramContext));
  }
  
  public String b(Context paramContext)
  {
    int i = ClassWriter.a(paramContext, "google_app_id", "string");
    if (i != 0)
    {
      f.get().d("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
      return b(paramContext.getResources().getString(i));
    }
    return null;
  }
  
  public String b(String paramString)
  {
    return ClassWriter.get(paramString).substring(0, 40);
  }
  
  public boolean c(Context paramContext)
  {
    int i = ClassWriter.a(paramContext, "google_app_id", "string");
    if (i == 0) {
      return false;
    }
    return TextUtils.isEmpty(paramContext.getResources().getString(i)) ^ true;
  }
  
  public boolean d(Context paramContext)
  {
    if (!TextUtils.isEmpty(new i().get(paramContext))) {
      return true;
    }
    return TextUtils.isEmpty(new i().c(paramContext)) ^ true;
  }
  
  public boolean f(Context paramContext)
  {
    int i = ClassWriter.a(paramContext, "io.fabric.auto_initialize", "bool");
    if (i == 0) {
      return false;
    }
    boolean bool = paramContext.getResources().getBoolean(i);
    if (bool) {
      f.get().d("Fabric", "Found Fabric auto-initialization flag for joint Firebase/Fabric customers");
    }
    return bool;
  }
}
