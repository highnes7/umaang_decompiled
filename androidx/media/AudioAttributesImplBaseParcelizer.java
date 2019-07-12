package androidx.media;

import b.b.a.N;
import de.asm.ByteVector;
import support.android.v4.asm.Attribute;

@N({b.b.a.N.a.a})
public final class AudioAttributesImplBaseParcelizer
{
  public AudioAttributesImplBaseParcelizer() {}
  
  public static Attribute read(ByteVector paramByteVector)
  {
    Attribute localAttribute = new Attribute();
    a = paramByteVector.add(a, 1);
    type = paramByteVector.add(type, 2);
    b = paramByteVector.add(b, 3);
    c = paramByteVector.add(c, 4);
    return localAttribute;
  }
  
  public static void write(Attribute paramAttribute, ByteVector paramByteVector)
  {
    paramByteVector.a(false, false);
    paramByteVector.put(a, 1);
    paramByteVector.put(type, 2);
    paramByteVector.put(b, 3);
    paramByteVector.put(c, 4);
  }
}
