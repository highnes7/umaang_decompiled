package de.asm;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Label
{
  public final ByteArrayOutputStream a = new ByteArrayOutputStream();
  public final DataOutputStream d;
  public final int e;
  public final DataOutputStream f = new DataOutputStream(a);
  
  public Label(int paramInt, DataOutputStream paramDataOutputStream)
  {
    e = paramInt;
    d = paramDataOutputStream;
  }
  
  public void a()
    throws IOException
  {
    f.flush();
    int j = a.size();
    int k = e;
    int i;
    if (j >= 65535) {
      i = 65535;
    } else {
      i = j;
    }
    d.writeInt(k << 16 | i);
    if (j >= 65535) {
      d.writeInt(j);
    }
    a.writeTo(d);
  }
}
