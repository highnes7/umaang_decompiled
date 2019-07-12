package de.asm;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class e
{
  public final DataInputStream a;
  public final int d;
  public final int e;
  
  public e(int paramInt1, int paramInt2, DataInputStream paramDataInputStream)
    throws IOException
  {
    d = paramInt2;
    e = paramInt1;
    byte[] arrayOfByte = new byte[d];
    paramDataInputStream.readFully(arrayOfByte);
    a = new DataInputStream(new ByteArrayInputStream(arrayOfByte));
  }
}
