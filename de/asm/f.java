package de.asm;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import b.b.a.N;
import c.b.h;

@N({b.b.a.N.a.a})
public class f
  extends ByteVector
{
  public static final boolean D = false;
  public static final String t = "VersionedParcelParcel";
  public final SparseIntArray a = new SparseIntArray();
  public final Parcel buffer;
  public int c = 0;
  public final String d;
  public int k = -1;
  public final int s;
  public final int x;
  
  public f(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "");
  }
  
  public f(Parcel paramParcel, int paramInt1, int paramInt2, String paramString)
  {
    buffer = paramParcel;
    s = paramInt1;
    x = paramInt2;
    c = s;
    d = paramString;
  }
  
  private int b(int paramInt)
  {
    int j;
    do
    {
      int i = c;
      if (i >= x) {
        break;
      }
      buffer.setDataPosition(i);
      i = buffer.readInt();
      j = buffer.readInt();
      c += i;
    } while (j != paramInt);
    return buffer.dataPosition();
    return -1;
  }
  
  public void a(double paramDouble)
  {
    buffer.writeDouble(paramDouble);
  }
  
  public void a(float paramFloat)
  {
    buffer.writeFloat(paramFloat);
  }
  
  public void a(long paramLong)
  {
    buffer.writeLong(paramLong);
  }
  
  public void a(Bundle paramBundle)
  {
    buffer.writeBundle(paramBundle);
  }
  
  public void a(IBinder paramIBinder)
  {
    buffer.writeStrongBinder(paramIBinder);
  }
  
  public void a(IInterface paramIInterface)
  {
    buffer.writeStrongInterface(paramIInterface);
  }
  
  public void a(Parcelable paramParcelable)
  {
    buffer.writeParcelable(paramParcelable, 0);
  }
  
  public void a(String paramString)
  {
    buffer.writeString(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      buffer.writeInt(paramArrayOfByte.length);
      buffer.writeByteArray(paramArrayOfByte);
      return;
    }
    buffer.writeInt(-1);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      buffer.writeInt(paramArrayOfByte.length);
      buffer.writeByteArray(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    buffer.writeInt(-1);
  }
  
  public boolean a()
  {
    return buffer.readInt() != 0;
  }
  
  public boolean a(int paramInt)
  {
    paramInt = b(paramInt);
    if (paramInt == -1) {
      return false;
    }
    buffer.setDataPosition(paramInt);
    return true;
  }
  
  public Bundle add()
  {
    return buffer.readBundle(h.class.getClassLoader());
  }
  
  public void add(int paramInt)
  {
    buffer.writeInt(paramInt);
  }
  
  public ByteVector b()
  {
    Parcel localParcel = buffer;
    int m = localParcel.dataPosition();
    int j = c;
    int i = j;
    if (j == s) {
      i = x;
    }
    return new f(localParcel, m, i, f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), d, "  "));
  }
  
  public void c()
  {
    int i = k;
    if (i >= 0)
    {
      i = a.get(i);
      int j = buffer.dataPosition();
      buffer.setDataPosition(i);
      buffer.writeInt(j - i);
      buffer.setDataPosition(j);
    }
  }
  
  public double clear()
  {
    return buffer.readDouble();
  }
  
  public float close()
  {
    return buffer.readFloat();
  }
  
  public void e(int paramInt)
  {
    c();
    k = paramInt;
    a.put(paramInt, buffer.dataPosition());
    add(0);
    add(paramInt);
  }
  
  public Parcelable get()
  {
    return buffer.readParcelable(h.class.getClassLoader());
  }
  
  public String getValue()
  {
    return buffer.readString();
  }
  
  public long position()
  {
    return buffer.readLong();
  }
  
  public byte[] readString()
  {
    int i = buffer.readInt();
    if (i < 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    buffer.readByteArray(arrayOfByte);
    return arrayOfByte;
  }
  
  public IBinder s()
  {
    return buffer.readStrongBinder();
  }
  
  public int size()
  {
    return buffer.readInt();
  }
}
