package androidx.media;

import android.support.v4.media.AudioAttributesCompat;
import b.b.a.N;
import de.asm.ByteVector;
import support.android.v4.asm.h;

@N({b.b.a.N.a.a})
public final class AudioAttributesCompatParcelizer
{
  public AudioAttributesCompatParcelizer() {}
  
  public static AudioAttributesCompat read(ByteVector paramByteVector)
  {
    AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
    b = ((h)paramByteVector.a(b, 1));
    return localAudioAttributesCompat;
  }
  
  public static void write(AudioAttributesCompat paramAudioAttributesCompat, ByteVector paramByteVector)
  {
    paramByteVector.a(false, false);
    paramByteVector.b(b, 1);
  }
}
