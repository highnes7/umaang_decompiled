package f.libs.asm.menu;

import java.io.File;
import java.util.Map;
import l.a.a.a.Log;
import l.a.a.a.f;

public class ActivatingIterator
  implements p
{
  public final File f;
  
  public ActivatingIterator(File paramFile)
  {
    f = paramFile;
  }
  
  public File a()
  {
    return null;
  }
  
  public String getFileName()
  {
    return null;
  }
  
  public Pa.a getType()
  {
    return Pa.a.INVALID;
  }
  
  public File[] getValue()
  {
    return f.listFiles();
  }
  
  public String next()
  {
    return f.getName();
  }
  
  public void remove()
  {
    Object localObject = getValue();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder1 = localObject[i];
      Log localLog = f.get();
      StringBuilder localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Removing native report file at ");
      localStringBuilder2.append(localStringBuilder1.getPath());
      localLog.d("CrashlyticsCore", localStringBuilder2.toString());
      localStringBuilder1.delete();
      i += 1;
    }
    localObject = f.get();
    StringBuilder localStringBuilder1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Removing native report directory at ");
    localStringBuilder1.append(f);
    ((Log)localObject).d("CrashlyticsCore", localStringBuilder1.toString());
    f.delete();
  }
  
  public Map split()
  {
    return null;
  }
}
