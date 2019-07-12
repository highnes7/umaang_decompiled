package f.libs.asm.menu;

import java.io.File;
import java.io.IOException;
import l.a.a.a.a.f.a;
import l.a.a.a.f;

public class Log
{
  public final a b;
  public final String c;
  
  public Log(String paramString, a paramA)
  {
    c = paramString;
    b = paramA;
  }
  
  private File d()
  {
    return new File(b.a(), c);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = d().createNewFile();
      return bool;
    }
    catch (IOException localIOException)
    {
      l.a.a.a.Log localLog = f.get();
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Error creating marker: ");
      localStringBuilder.append(c);
      localLog.d("CrashlyticsCore", localStringBuilder.toString(), localIOException);
    }
    return false;
  }
  
  public boolean delete()
  {
    return d().delete();
  }
  
  public boolean log()
  {
    return d().exists();
  }
}
