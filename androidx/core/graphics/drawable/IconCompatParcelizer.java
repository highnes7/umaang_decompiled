package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.v4.graphics.drawable.IconCompat;
import b.b.a.N;
import de.asm.ByteVector;

@N({b.b.a.N.a.a})
public class IconCompatParcelizer
{
  public IconCompatParcelizer() {}
  
  public static IconCompat read(ByteVector paramByteVector)
  {
    IconCompat localIconCompat = new IconCompat();
    c = paramByteVector.add(c, 1);
    s = paramByteVector.write(s, 2);
    left = paramByteVector.add(left, 3);
    a = paramByteVector.add(a, 4);
    b = paramByteVector.add(b, 5);
    state = ((ColorStateList)paramByteVector.add(state, 6));
    i = paramByteVector.get(i, 7);
    localIconCompat.init();
    return localIconCompat;
  }
  
  public static void write(IconCompat paramIconCompat, ByteVector paramByteVector)
  {
    paramByteVector.a(true, true);
    paramIconCompat.encode(paramByteVector.processBytes());
    paramByteVector.put(c, 1);
    paramByteVector.a(s, 2);
    paramByteVector.put(left, 3);
    paramByteVector.put(a, 4);
    paramByteVector.put(b, 5);
    paramByteVector.put(state, 6);
    paramByteVector.a(i, 7);
  }
}
