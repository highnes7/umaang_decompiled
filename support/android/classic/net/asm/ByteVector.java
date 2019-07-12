package support.android.classic.net.asm;

import android.content.ClipDescription;
import android.net.Uri;
import b.b.a.F;
import b.b.a.G;

public final class ByteVector
  implements Buffer
{
  @F
  public final ClipDescription buffer;
  @F
  public final Uri data;
  @G
  public final Uri length;
  
  public ByteVector(Uri paramUri1, ClipDescription paramClipDescription, Uri paramUri2)
  {
    data = paramUri1;
    buffer = paramClipDescription;
    length = paramUri2;
  }
  
  public void capacity() {}
  
  public void clear() {}
  
  public Uri get()
  {
    return data;
  }
  
  public Object getArray()
  {
    return null;
  }
  
  public Uri length()
  {
    return length;
  }
  
  public ClipDescription put()
  {
    return buffer;
  }
}
