package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class TintResources
  extends ResourcesWrapper
{
  public final WeakReference<Context> mContextRef;
  
  public TintResources(Context paramContext, Resources paramResources)
  {
    super(paramResources);
    mContextRef = new WeakReference(paramContext);
  }
  
  public Drawable getDrawable(int paramInt)
    throws Resources.NotFoundException
  {
    Drawable localDrawable = mResources.getDrawable(paramInt);
    Context localContext = (Context)mContextRef.get();
    if ((localDrawable != null) && (localContext != null))
    {
      AppCompatDrawableManager.get();
      AppCompatDrawableManager.tintDrawableUsingColorFilter(localContext, paramInt, localDrawable);
    }
    return localDrawable;
  }
}
