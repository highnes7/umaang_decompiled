package support.android.classic.net.asm;

import android.content.ClipDescription;
import android.net.Uri;

public abstract interface Buffer
{
  public abstract void capacity();
  
  public abstract void clear();
  
  public abstract Uri get();
  
  public abstract Object getArray();
  
  public abstract Uri length();
  
  public abstract ClipDescription put();
}
