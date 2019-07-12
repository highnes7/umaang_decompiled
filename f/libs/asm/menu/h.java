package f.libs.asm.menu;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import l.a.a.a.Log;
import l.a.a.a.a.b.C;
import l.a.a.a.a.b.ClassWriter;
import l.a.a.a.f;

public class h
  implements m
{
  public C a;
  public final int b;
  public final File f;
  
  public h(File paramFile, int paramInt)
  {
    f = paramFile;
    b = paramInt;
  }
  
  private void d()
  {
    if (a == null)
    {
      Object localObject = f;
      try
      {
        localObject = new C((File)localObject);
        a = ((C)localObject);
        return;
      }
      catch (IOException localIOException)
      {
        Log localLog = f.get();
        StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Could not open log file: ");
        localStringBuilder.append(f);
        localLog.d("CrashlyticsCore", localStringBuilder.toString(), localIOException);
      }
    }
  }
  
  private Ma.a f()
  {
    if (!f.exists()) {
      return null;
    }
    d();
    Object localObject = a;
    if (localObject == null) {
      return null;
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    localObject = new byte[((C)localObject).y()];
    C localC = a;
    try
    {
      localC.a(new JSON.ConvertableOutput(this, (byte[])localObject, arrayOfInt));
    }
    catch (IOException localIOException)
    {
      f.get().d("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", localIOException);
    }
    return new Ma.a(this, (byte[])localObject, arrayOfInt[0]);
  }
  
  private void write(long paramLong, String paramString)
  {
    if (a == null) {
      return;
    }
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "null";
    }
    int i = b / 4;
    try
    {
      int j = ((String)localObject).length();
      paramString = (String)localObject;
      if (j > i)
      {
        paramString = new StringBuilder();
        paramString.append("...");
        j = ((String)localObject).length();
        paramString.append(((String)localObject).substring(j - i));
        paramString = paramString.toString();
      }
      paramString = paramString.replaceAll("\r", " ").replaceAll("\n", " ");
      localObject = Locale.US;
      paramString = String.format((Locale)localObject, "%d %s%n", new Object[] { Long.valueOf(paramLong), paramString }).getBytes("UTF-8");
      localObject = a;
      ((C)localObject).a(paramString);
      for (;;)
      {
        paramString = a;
        boolean bool = paramString.v();
        if (bool) {
          break;
        }
        paramString = a;
        i = paramString.y();
        if (i <= b) {
          break;
        }
        paramString = a;
        paramString.x();
      }
      return;
    }
    catch (IOException paramString)
    {
      f.get().d("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", paramString);
    }
  }
  
  public Label a()
  {
    Ma.a localA = f();
    if (localA == null) {
      return null;
    }
    return Label.a(d, 0, j);
  }
  
  public void b()
  {
    ClassWriter.close((Closeable)a, "There was a problem closing the Crashlytics log file.");
    a = null;
  }
  
  public void b(long paramLong, String paramString)
  {
    d();
    write(paramLong, paramString);
  }
  
  public void c()
  {
    b();
    f.delete();
  }
  
  public byte[] e()
  {
    Ma.a localA = f();
    if (localA == null) {
      return null;
    }
    return d;
  }
}
