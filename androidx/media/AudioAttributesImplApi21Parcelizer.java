package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import b.b.a.N;
import de.asm.ByteVector;
import support.android.v4.asm.b;

@N({b.b.a.N.a.a})
public final class AudioAttributesImplApi21Parcelizer
{
  public AudioAttributesImplApi21Parcelizer() {}
  
  public static b read(ByteVector paramByteVector)
  {
    b localB = new b();
    b = ((AudioAttributes)paramByteVector.add((Parcelable)b, 1));
    c = paramByteVector.add(c, 2);
    return localB;
  }
  
  public static void write(b paramB, ByteVector paramByteVector)
  {
    paramByteVector.a(false, false);
    paramByteVector.put((Parcelable)b, 1);
    paramByteVector.put(c, 2);
  }
}
