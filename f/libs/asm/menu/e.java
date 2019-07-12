package f.libs.asm.menu;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import l.a.a.a.a.b.f;

public class e
{
  public final String a;
  public final String b;
  public final String c;
  public final String e;
  public final String f;
  public final String g;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a = paramString1;
    f = paramString2;
    g = paramString3;
    e = paramString4;
    c = paramString5;
    b = paramString6;
  }
  
  public static e a(Context paramContext, f paramF, String paramString1, String paramString2)
    throws PackageManager.NameNotFoundException
  {
    String str1 = paramContext.getPackageName();
    String str2 = paramF.b();
    paramContext = paramContext.getPackageManager().getPackageInfo(str1, 0);
    String str3 = Integer.toString(versionCode);
    paramF = versionName;
    paramContext = paramF;
    if (paramF == null) {
      paramContext = "0.0";
    }
    return new e(paramString1, paramString2, str2, str1, str3, paramContext);
  }
}
