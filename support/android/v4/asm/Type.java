package support.android.v4.asm;

import android.content.Context;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.service.media.MediaBrowserService.Result;
import b.b.a.K;
import java.lang.reflect.Field;

@K(26)
public class Type
{
  public static Field NULL;
  public static final String a = "MBSCompatApi26";
  
  static
  {
    try
    {
      Field localField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
      NULL = localField;
      localField = NULL;
      localField.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
  }
  
  public Type() {}
  
  public static Object a(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    return new o(paramContext, paramMethodVisitor);
  }
  
  public static void a(Object paramObject, String paramString, Bundle paramBundle)
  {
    ((MediaBrowserService)paramObject).notifyChildrenChanged(paramString, paramBundle);
  }
  
  public static Bundle d(Object paramObject)
  {
    return ((MediaBrowserService)paramObject).getBrowserRootHints();
  }
}
