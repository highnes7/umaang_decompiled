package f.libs.asm.menu;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import l.a.a.a.a.b.ClassWriter;

public class ListMenuItemView
  implements aa
{
  public ListMenuItemView() {}
  
  public static String a(String paramString)
    throws IOException
  {
    Object localObject = null;
    try
    {
      paramString = new BufferedInputStream(new FileInputStream(paramString));
      try
      {
        String str = ClassWriter.a(paramString);
        ClassWriter.close(paramString);
        return str;
      }
      catch (Throwable localThrowable1) {}
      ClassWriter.close(paramString);
    }
    catch (Throwable localThrowable2)
    {
      paramString = localObject;
    }
    throw localThrowable2;
  }
  
  public String a(File paramFile)
    throws IOException
  {
    return a(paramFile.getPath());
  }
}
