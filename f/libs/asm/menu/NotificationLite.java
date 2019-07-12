package f.libs.asm.menu;

import java.io.File;

public final class NotificationLite
  extends ClassReader
{
  public NotificationLite(String paramString)
  {
    super(paramString);
  }
  
  public boolean accept(File paramFile, String paramString)
  {
    return (super.accept(paramFile, paramString)) && (paramString.endsWith(".cls"));
  }
}
