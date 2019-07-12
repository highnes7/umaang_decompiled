package de.asm;

import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import b.b.a.N;
import java.io.InputStream;
import java.io.OutputStream;

@N({b.b.a.N.a.b})
public class ClassReader
{
  public ClassReader() {}
  
  public static h a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof ParcelImpl)) {
      return ((ParcelImpl)paramParcelable).c();
    }
    throw new IllegalArgumentException("Invalid parcel");
  }
  
  public static h a(InputStream paramInputStream)
  {
    return new i(paramInputStream, null).d();
  }
  
  public static Parcelable b(h paramH)
  {
    return new ParcelImpl(paramH);
  }
  
  public static void b(h paramH, OutputStream paramOutputStream)
  {
    paramOutputStream = new i(null, paramOutputStream);
    paramOutputStream.b(paramH);
    paramOutputStream.c();
  }
}
