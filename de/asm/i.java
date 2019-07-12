package de.asm;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.util.SparseArray;
import b.b.a.N;
import c.b.i.b;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

@N({b.b.a.N.a.a})
public class i
  extends ByteVector
{
  public static final int CODE_PLAYLISTMEMBER = 11;
  public static final int Id_pow = 14;
  public static final int Id_uneval = 13;
  public static final int STATE_PAUSED_ROAMING = 12;
  public static final int TRANSACTION_addSpeechFile = 7;
  public static final Charset buffer = Charset.forName("UTF-16");
  public static final int c = 3;
  public static final int d = 0;
  public static final int g = 9;
  public static final int i = 6;
  public static final int j = 10;
  public static final int l = 4;
  public static final int r = 5;
  public static final int t = 1;
  public static final int u = 2;
  public static final int w = 8;
  public DataOutputStream a;
  public Label b;
  public DataInputStream data;
  public final DataInputStream e;
  public final DataOutputStream f;
  public boolean h;
  public final SparseArray<i.b> v = new SparseArray();
  
  public i(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    Object localObject = null;
    if (paramInputStream != null) {
      paramInputStream = new DataInputStream(paramInputStream);
    } else {
      paramInputStream = null;
    }
    e = paramInputStream;
    paramInputStream = localObject;
    if (paramOutputStream != null) {
      paramInputStream = new DataOutputStream(paramOutputStream);
    }
    f = paramInputStream;
    data = e;
    a = f;
  }
  
  private void add(int paramInt, String paramString, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unknown type ", paramInt));
    case 14: 
      paramBundle.putFloatArray(paramString, copy());
      return;
    case 13: 
      paramBundle.putFloat(paramString, close());
      return;
    case 12: 
      paramBundle.putLongArray(paramString, put());
      return;
    case 11: 
      paramBundle.putLong(paramString, position());
      return;
    case 10: 
      paramBundle.putIntArray(paramString, getChecked());
      return;
    case 9: 
      paramBundle.putInt(paramString, size());
      return;
    case 8: 
      paramBundle.putDoubleArray(paramString, getContent());
      return;
    case 7: 
      paramBundle.putDouble(paramString, clear());
      return;
    case 6: 
      paramBundle.putBooleanArray(paramString, remove());
      return;
    case 5: 
      paramBundle.putBoolean(paramString, a());
      return;
    case 4: 
      paramBundle.putStringArray(paramString, (String[])a(new String[0]));
      return;
    case 3: 
      paramBundle.putString(paramString, getValue());
      return;
    case 2: 
      paramBundle.putBundle(paramString, add());
      return;
    case 1: 
      paramBundle.putBundle(paramString, add());
      return;
    }
    paramBundle.putParcelable(paramString, null);
  }
  
  private void write(Object paramObject)
  {
    if (paramObject == null)
    {
      add(0);
      return;
    }
    if ((paramObject instanceof Bundle))
    {
      add(1);
      a((Bundle)paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      add(3);
      a((String)paramObject);
      return;
    }
    if ((paramObject instanceof String[]))
    {
      add(4);
      write((String[])paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      add(5);
      a(((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      add(6);
      add((boolean[])paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      add(7);
      a(((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof double[]))
    {
      add(8);
      a((double[])paramObject);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      add(9);
      add(((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof int[]))
    {
      add(10);
      add((int[])paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      add(11);
      a(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof long[]))
    {
      add(12);
      write((long[])paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      add(13);
      a(((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof float[]))
    {
      add(14);
      write((float[])paramObject);
      return;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unsupported type ");
    localStringBuilder.append(paramObject.getClass());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void a(double paramDouble)
  {
    DataOutputStream localDataOutputStream = a;
    try
    {
      localDataOutputStream.writeDouble(paramDouble);
      return;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public void a(float paramFloat)
  {
    DataOutputStream localDataOutputStream = a;
    try
    {
      localDataOutputStream.writeFloat(paramFloat);
      return;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public void a(long paramLong)
  {
    DataOutputStream localDataOutputStream = a;
    try
    {
      localDataOutputStream.writeLong(paramLong);
      return;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    try
    {
      Object localObject1 = paramBundle.keySet();
      Object localObject2 = a;
      ((DataOutputStream)localObject2).writeInt(((Set)localObject1).size());
      localObject1 = ((Set)localObject1).iterator();
      for (;;)
      {
        boolean bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        localObject2 = ((Iterator)localObject1).next();
        localObject2 = (String)localObject2;
        a((String)localObject2);
        write(paramBundle.get((String)localObject2));
      }
      paramBundle = a;
      paramBundle.writeInt(-1);
      return;
    }
    catch (IOException paramBundle)
    {
      paramBundle = new List(paramBundle);
      throw paramBundle;
    }
  }
  
  public void a(IBinder paramIBinder)
  {
    if (h) {
      return;
    }
    throw new RuntimeException("Binders cannot be written to an OutputStream");
  }
  
  public void a(IInterface paramIInterface)
  {
    if (h) {
      return;
    }
    throw new RuntimeException("Binders cannot be written to an OutputStream");
  }
  
  public void a(Parcelable paramParcelable)
  {
    if (h) {
      return;
    }
    throw new RuntimeException("Parcelables cannot be written to an OutputStream");
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (paramString != null) {
      localObject = buffer;
    }
    try
    {
      paramString = paramString.getBytes((Charset)localObject);
      localObject = a;
      int k = paramString.length;
      ((DataOutputStream)localObject).writeInt(k);
      localObject = a;
      ((DataOutputStream)localObject).write(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new List(paramString);
    }
    paramString = a;
    paramString.writeInt(-1);
  }
  
  public void a(boolean paramBoolean)
  {
    DataOutputStream localDataOutputStream = a;
    try
    {
      localDataOutputStream.writeBoolean(paramBoolean);
      return;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      h = paramBoolean2;
      return;
    }
    throw new RuntimeException("Serialization of this object is not allowed");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    DataOutputStream localDataOutputStream;
    int k;
    if (paramArrayOfByte != null)
    {
      localDataOutputStream = a;
      k = paramArrayOfByte.length;
    }
    try
    {
      localDataOutputStream.writeInt(k);
      localDataOutputStream = a;
      localDataOutputStream.write(paramArrayOfByte);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new List(paramArrayOfByte);
    }
    paramArrayOfByte = a;
    paramArrayOfByte.writeInt(-1);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    DataOutputStream localDataOutputStream;
    if (paramArrayOfByte != null) {
      localDataOutputStream = a;
    }
    try
    {
      localDataOutputStream.writeInt(paramInt2);
      localDataOutputStream = a;
      localDataOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new List(paramArrayOfByte);
    }
    paramArrayOfByte = a;
    paramArrayOfByte.writeInt(-1);
  }
  
  public boolean a()
  {
    DataInputStream localDataInputStream = data;
    try
    {
      boolean bool = localDataInputStream.readBoolean();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = (e)v.get(paramInt);
    if (localObject != null)
    {
      v.remove(paramInt);
      data = a;
      return true;
    }
    for (;;)
    {
      localObject = e;
      try
      {
        int n = ((DataInputStream)localObject).readInt();
        int m = n & 0xFFFF;
        int k = m;
        if (m == 65535)
        {
          localObject = e;
          k = ((DataInputStream)localObject).readInt();
        }
        localObject = e;
        localObject = new e(n >> 16 & 0xFFFF, k, (DataInputStream)localObject);
        if (e == paramInt)
        {
          data = a;
          return true;
        }
        SparseArray localSparseArray = v;
        k = e;
        localSparseArray.put(k, localObject);
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    return false;
  }
  
  public Bundle add()
  {
    int m = size();
    if (m < 0) {
      return null;
    }
    Bundle localBundle = new Bundle();
    int k = 0;
    while (k < m)
    {
      String str = getValue();
      add(size(), str, localBundle);
      k += 1;
    }
    return localBundle;
  }
  
  public void add(int paramInt)
  {
    DataOutputStream localDataOutputStream = a;
    try
    {
      localDataOutputStream.writeInt(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public ByteVector b()
  {
    return new i(data, a);
  }
  
  public void c()
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = a;
      try
      {
        int k = ((ByteArrayOutputStream)localObject).size();
        if (k != 0)
        {
          localObject = b;
          ((Label)localObject).a();
        }
        b = null;
        return;
      }
      catch (IOException localIOException)
      {
        throw new List(localIOException);
      }
    }
  }
  
  public double clear()
  {
    DataInputStream localDataInputStream = data;
    try
    {
      double d1 = localDataInputStream.readDouble();
      return d1;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public float close()
  {
    DataInputStream localDataInputStream = data;
    try
    {
      float f1 = localDataInputStream.readFloat();
      return f1;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public void e(int paramInt)
  {
    c();
    b = new Label(paramInt, f);
    a = b.f;
  }
  
  public Parcelable get()
  {
    return null;
  }
  
  public String getValue()
  {
    Object localObject1 = data;
    try
    {
      int k = ((DataInputStream)localObject1).readInt();
      if (k > 0)
      {
        localObject1 = new byte[k];
        Object localObject2 = data;
        ((DataInputStream)localObject2).readFully((byte[])localObject1);
        localObject2 = buffer;
        localObject1 = new String((byte[])localObject1, (Charset)localObject2);
        return localObject1;
      }
      return null;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public long position()
  {
    DataInputStream localDataInputStream = data;
    try
    {
      long l1 = localDataInputStream.readLong();
      return l1;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public boolean processBytes()
  {
    return true;
  }
  
  public byte[] readString()
  {
    Object localObject = data;
    try
    {
      int k = ((DataInputStream)localObject).readInt();
      if (k > 0)
      {
        localObject = new byte[k];
        DataInputStream localDataInputStream = data;
        localDataInputStream.readFully((byte[])localObject);
        return localObject;
      }
      return null;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
  
  public IBinder s()
  {
    return null;
  }
  
  public int size()
  {
    DataInputStream localDataInputStream = data;
    try
    {
      int k = localDataInputStream.readInt();
      return k;
    }
    catch (IOException localIOException)
    {
      throw new List(localIOException);
    }
  }
}
