package support.android.v4.asm;

import android.content.Context;
import android.service.media.MediaBrowserService.Result;

public class FieldVisitor
  extends Unit
{
  public FieldVisitor(Context paramContext, AnnotationVisitor paramAnnotationVisitor)
  {
    super(paramContext, paramAnnotationVisitor);
  }
  
  public void onLoadItem(String paramString, MediaBrowserService.Result paramResult)
  {
    ((AnnotationVisitor)INSTANCE).visitArray(paramString, new MediaBrowserCompat.MediaBrowserImplBase(paramResult));
  }
}
