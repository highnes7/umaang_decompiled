package support.android.v4.util;

import b.b.a.N;
import java.io.Writer;

@N({b.b.a.N.a.b})
public class LogWriter
  extends Writer
{
  public StringBuilder mBuilder = new StringBuilder(128);
  public final String mTag;
  
  public LogWriter(String paramString)
  {
    mTag = paramString;
  }
  
  private void flushBuilder()
  {
    if (mBuilder.length() > 0)
    {
      mBuilder.toString();
      StringBuilder localStringBuilder = mBuilder;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public void close()
  {
    flushBuilder();
  }
  
  public void flush()
  {
    flushBuilder();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        flushBuilder();
      } else {
        mBuilder.append(c);
      }
      i += 1;
    }
  }
}
