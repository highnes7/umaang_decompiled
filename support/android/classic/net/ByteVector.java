package support.android.classic.net;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

public final class ByteVector
{
  public Object data;
  
  public ByteVector(Object paramObject)
  {
    data = paramObject;
  }
  
  public static ByteVector a(Activity paramActivity, DragEvent paramDragEvent)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramActivity = paramActivity.requestDragAndDropPermissions(paramDragEvent);
      if (paramActivity != null) {
        return new ByteVector(paramActivity);
      }
    }
    return null;
  }
  
  public void getSize()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      ((DragAndDropPermissions)data).release();
    }
  }
}
