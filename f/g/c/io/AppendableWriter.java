package f.g.c.io;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class AppendableWriter
  extends Writer
{
  public boolean closed;
  public final Appendable target;
  
  public AppendableWriter(Appendable paramAppendable)
  {
    target = paramAppendable;
  }
  
  private void checkNotClosed()
    throws IOException
  {
    if (!closed) {
      return;
    }
    throw new IOException("Cannot write to a closed writer.");
  }
  
  public Writer append(char paramChar)
    throws IOException
  {
    checkNotClosed();
    target.append(paramChar);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence)
    throws IOException
  {
    checkNotClosed();
    target.append(paramCharSequence);
    return this;
  }
  
  public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    throws IOException
  {
    checkNotClosed();
    target.append(paramCharSequence, paramInt1, paramInt2);
    return this;
  }
  
  public void close()
    throws IOException
  {
    closed = true;
    Appendable localAppendable = target;
    if ((localAppendable instanceof Closeable)) {
      ((Closeable)localAppendable).close();
    }
  }
  
  public void flush()
    throws IOException
  {
    checkNotClosed();
    Appendable localAppendable = target;
    if ((localAppendable instanceof Flushable)) {
      ((Flushable)localAppendable).flush();
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    checkNotClosed();
    target.append((char)paramInt);
  }
  
  public void write(String paramString)
    throws IOException
  {
    checkNotClosed();
    target.append(paramString);
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    checkNotClosed();
    target.append(paramString, paramInt1, paramInt2 + paramInt1);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    checkNotClosed();
    target.append(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
}
