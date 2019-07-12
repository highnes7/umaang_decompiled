package support.android.v4.asm;

import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.service.media.MediaBrowserService.Result;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleArrayMap
{
  public MediaBrowserService.Result this$0;
  
  public SimpleArrayMap(MediaBrowserService.Result paramResult)
  {
    this$0 = paramResult;
  }
  
  public void clear()
  {
    this$0.detach();
  }
  
  public void get(List paramList, int paramInt)
  {
    Field localField = Type.NULL;
    MediaBrowserService.Result localResult = this$0;
    try
    {
      localField.setInt(localResult, paramInt);
      this$0.sendResult(onLoadChildren(paramList));
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  public List onLoadChildren(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Parcel localParcel = (Parcel)paramList.next();
      localParcel.setDataPosition(0);
      localArrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(localParcel));
      localParcel.recycle();
    }
    return localArrayList;
  }
}
