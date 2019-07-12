package f.g.c.io;

import f.g.c.a.a;
import java.io.IOException;

@a
public abstract interface ByteProcessor<T>
{
  public abstract Object getResult();
  
  public abstract boolean processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
}
