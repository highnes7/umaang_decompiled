package support.android.v4.asm.session;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import b.b.x.h.b.r.b;
import b.b.x.h.b.s.a;

public class PositionMetric<T extends s.a>
  extends r.b<T>
{
  public PositionMetric(Label paramLabel)
  {
    super(paramLabel);
  }
  
  public void onPrepare()
  {
    ((Label)mCallback).b();
  }
  
  public void onPrepareFromMediaId(String paramString, Bundle paramBundle)
  {
    MediaSessionCompat.append(paramBundle);
    ((Label)mCallback).a(paramString, paramBundle);
  }
  
  public void onPrepareFromSearch(String paramString, Bundle paramBundle)
  {
    MediaSessionCompat.append(paramBundle);
    ((Label)mCallback).b(paramString, paramBundle);
  }
  
  public void onPrepareFromUri(Uri paramUri, Bundle paramBundle)
  {
    MediaSessionCompat.append(paramBundle);
    ((Label)mCallback).b(paramUri, paramBundle);
  }
}
