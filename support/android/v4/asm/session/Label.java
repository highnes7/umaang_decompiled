package support.android.v4.asm.session;

import android.net.Uri;
import android.os.Bundle;

public abstract interface Label
  extends MediaSessionCompatApi23.Callback
{
  public abstract void a(String paramString, Bundle paramBundle);
  
  public abstract void b();
  
  public abstract void b(Uri paramUri, Bundle paramBundle);
  
  public abstract void b(String paramString, Bundle paramBundle);
}
