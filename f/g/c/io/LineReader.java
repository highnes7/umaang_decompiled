package f.g.c.io;

import f.g.c.a.a;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

@a
public final class LineReader
{
  public final char[] buf = new char['?'];
  public final CharBuffer cbuf = CharBuffer.wrap(buf);
  public final TokenFormulaParser lineBuf = new TokenFormulaParser()
  {
    public void handleLine(String paramAnonymousString1, String paramAnonymousString2)
    {
      lines.add(paramAnonymousString1);
    }
  };
  public final Queue<String> lines = new LinkedList();
  public final Readable readable;
  public final Reader reader;
  
  public LineReader(Readable paramReadable)
  {
    if (paramReadable != null)
    {
      readable = paramReadable;
      if ((paramReadable instanceof Reader)) {
        paramReadable = (Reader)paramReadable;
      } else {
        paramReadable = null;
      }
      reader = paramReadable;
      return;
    }
    throw new NullPointerException();
  }
  
  public String readLine()
    throws IOException
  {
    while (lines.peek() == null)
    {
      cbuf.clear();
      Reader localReader = reader;
      int i;
      if (localReader != null)
      {
        char[] arrayOfChar = buf;
        i = localReader.read(arrayOfChar, 0, arrayOfChar.length);
      }
      else
      {
        i = readable.read(cbuf);
      }
      if (i == -1)
      {
        lineBuf.parse();
        break;
      }
      lineBuf.parse(buf, 0, i);
    }
    return (String)lines.poll();
  }
}
