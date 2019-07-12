package support.android.classic.net.asm;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
import b.b.a.F;
import b.b.a.K;

@K(25)
public final class CharVector
  implements Buffer
{
  @F
  public final InputContentInfo array;
  
  public CharVector(Uri paramUri1, ClipDescription paramClipDescription, Uri paramUri2)
  {
    array = new InputContentInfo(paramUri1, paramClipDescription, paramUri2);
  }
  
  public CharVector(Object paramObject)
  {
    array = ((InputContentInfo)paramObject);
  }
  
  public void capacity()
  {
    array.releasePermission();
  }
  
  public void clear()
  {
    array.requestPermission();
  }
  
  public Uri get()
  {
    return array.getContentUri();
  }
  
  public Object getArray()
  {
    return array;
  }
  
  public Uri length()
  {
    return array.getLinkUri();
  }
  
  public ClipDescription put()
  {
    return array.getDescription();
  }
}
