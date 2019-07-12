package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import b.b.a.N;
import java.lang.ref.WeakReference;

@N({b.b.a.N.a.b})
public class VectorEnabledTintResources
  extends Resources
{
  public static final int MAX_SDK_WHERE_REQUIRED = 20;
  public static boolean sCompatVectorFromResourcesEnabled;
  public final WeakReference<Context> mContextRef;
  
  public VectorEnabledTintResources(Context paramContext, Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    mContextRef = new WeakReference(paramContext);
  }
  
  public static boolean isCompatVectorFromResourcesEnabled()
  {
    return sCompatVectorFromResourcesEnabled;
  }
  
  public static void setCompatVectorFromResourcesEnabled(boolean paramBoolean)
  {
    sCompatVectorFromResourcesEnabled = paramBoolean;
  }
  
  public static boolean shouldBeUsed()
  {
    return (sCompatVectorFromResourcesEnabled) && (Build.VERSION.SDK_INT <= 20);
  }
  
  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Context localContext = (Context)mContextRef.get();
    if (localContext != null) {
      return AppCompatDrawableManager.get().onDrawableLoadedFromResources(localContext, this, paramInt);
    }
    return super.getDrawable(paramInt);
  }
  
  public final Drawable superGetDrawable(int paramInt)
  {
    return super.getDrawable(paramInt);
  }
}
