package support.android.classic.net.asm;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build.VERSION;

public final class Frame
{
  public final Buffer buffer;
  
  public Frame(Uri paramUri1, ClipDescription paramClipDescription, Uri paramUri2)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      buffer = new CharVector(paramUri1, paramClipDescription, paramUri2);
      return;
    }
    buffer = new ByteVector(paramUri1, paramClipDescription, paramUri2);
  }
  
  public Frame(Buffer paramBuffer)
  {
    buffer = paramBuffer;
  }
  
  public static Frame a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 25) {
      return null;
    }
    return new Frame(new CharVector(paramObject));
  }
  
  public Uri add()
  {
    return buffer.length();
  }
  
  public Object get()
  {
    return buffer.getArray();
  }
  
  public void init()
  {
    buffer.clear();
  }
  
  public Uri peek()
  {
    return buffer.get();
  }
  
  public ClipDescription write()
  {
    return buffer.put();
  }
  
  public void writeTo()
  {
    buffer.capacity();
  }
}
