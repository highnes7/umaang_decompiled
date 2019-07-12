package f.libs.asm.menu;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import l.a.a.a.Log;
import l.a.a.a.f;

public class Segment
  implements p
{
  public final File current;
  public final File[] line;
  public final Map<String, String> next;
  
  public Segment(File paramFile)
  {
    this(paramFile, Collections.emptyMap());
  }
  
  public Segment(File paramFile, Map paramMap)
  {
    current = paramFile;
    line = new File[] { paramFile };
    next = new HashMap(paramMap);
    if (current.length() == 0L) {
      next.putAll(Plot.next);
    }
  }
  
  public File a()
  {
    return current;
  }
  
  public String getFileName()
  {
    return a().getName();
  }
  
  public Pa.a getType()
  {
    return Pa.a.ATOM;
  }
  
  public File[] getValue()
  {
    return line;
  }
  
  public String next()
  {
    String str = getFileName();
    return str.substring(0, str.lastIndexOf('.'));
  }
  
  public void remove()
  {
    Log localLog = f.get();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Removing report at ");
    localStringBuilder.append(current.getPath());
    localLog.d("CrashlyticsCore", localStringBuilder.toString());
    current.delete();
  }
  
  public Map split()
  {
    return Collections.unmodifiableMap(next);
  }
}
