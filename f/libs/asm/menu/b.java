package f.libs.asm.menu;

import android.content.Context;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.File;
import java.util.Set;
import l.a.a.a.Log;
import l.a.a.a.a.b.ClassWriter;
import l.a.a.a.f;

public class b
{
  public static final int STATE_SENSOR_ON_FLAG = 65536;
  public static final String TMP_FILE = ".temp";
  public static final String e = "crashlytics-userlog-";
  public static final String g = "com.crashlytics.CollectCustomLogs";
  public static final ya.b k = new ya.b(null);
  public final Context j;
  public m l;
  public final ya.a m;
  
  public b(Context paramContext, ya.a paramA)
  {
    j = paramContext;
    m = paramA;
    l = k;
    a(null);
  }
  
  public b(Context paramContext, ya.a paramA, String paramString)
  {
    j = paramContext;
    m = paramA;
    l = k;
    a(paramString);
  }
  
  private File d(String paramString)
  {
    paramString = StringBuilder.append("crashlytics-userlog-", paramString, ".temp");
    return new File(m.a(), paramString);
  }
  
  private String write(File paramFile)
  {
    paramFile = paramFile.getName();
    int i = paramFile.lastIndexOf(".temp");
    if (i == -1) {
      return paramFile;
    }
    return paramFile.substring(20, i);
  }
  
  public Label a()
  {
    return l.a();
  }
  
  public void a(long paramLong, String paramString)
  {
    l.b(paramLong, paramString);
  }
  
  public void a(File paramFile, int paramInt)
  {
    l = new h(paramFile, paramInt);
  }
  
  public final void a(String paramString)
  {
    l.b();
    l = k;
    if (paramString == null) {
      return;
    }
    if (!ClassWriter.getBoolean(j, "com.crashlytics.CollectCustomLogs", true))
    {
      f.get().d("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
      return;
    }
    a(d(paramString), 65536);
  }
  
  public void a(Set paramSet)
  {
    File[] arrayOfFile = m.a().listFiles();
    if (arrayOfFile != null)
    {
      int n = arrayOfFile.length;
      int i = 0;
      while (i < n)
      {
        File localFile = arrayOfFile[i];
        if (!paramSet.contains(write(localFile))) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public void d()
  {
    l.c();
  }
  
  public byte[] e()
  {
    return l.e();
  }
}
