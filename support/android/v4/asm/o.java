package support.android.v4.asm;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService.Result;
import android.support.v4.media.session.MediaSessionCompat;

public class o
  extends FieldVisitor
{
  public o(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    super(paramContext, paramMethodVisitor);
  }
  
  public void onLoadChildren(String paramString, MediaBrowserService.Result paramResult, Bundle paramBundle)
  {
    MediaSessionCompat.append(paramBundle);
    ((MethodVisitor)INSTANCE).d(paramString, new SimpleArrayMap(paramResult), paramBundle);
  }
}
