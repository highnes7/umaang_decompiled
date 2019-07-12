package f.libs.asm.menu;

import java.io.File;
import java.io.FilenameFilter;

public class ClassReader
  implements FilenameFilter
{
  public final String a;
  
  public ClassReader(String paramString)
  {
    a = paramString;
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.contains(a)) && (!paramString.endsWith(".cls_temp"));
  }
}
