package f.g.c.io;

import f.g.c.a.a;
import java.io.IOException;

@a
public abstract interface LineProcessor<T>
{
  public abstract Object getResult();
  
  public abstract boolean processLine(String paramString)
    throws IOException;
}
