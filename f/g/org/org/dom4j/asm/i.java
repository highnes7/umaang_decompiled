package f.g.org.org.dom4j.asm;

import f.g.b.a.g.h;
import java.io.IOException;

@Deprecated
@h
public final class i
  implements e
{
  public final String b;
  public final f d;
  
  public i(String paramString, f paramF)
  {
    if (paramString != null)
    {
      b = paramString;
      if (paramF != null)
      {
        d = paramF;
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public void a(ClassWriter paramClassWriter, Plot paramPlot)
    throws IOException
  {
    b(paramClassWriter);
  }
  
  public void b(ClassWriter paramClassWriter)
    throws IOException
  {
    d.b(b, paramClassWriter);
  }
  
  public void clear(ClassWriter paramClassWriter, Set paramSet)
    throws IOException
  {
    b(paramClassWriter);
  }
  
  public f q()
  {
    return d;
  }
}
