package com.facebook.internal;

import android.app.Activity;
import android.support.v4.package_7.Fragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookDialog;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Iterator;
import java.util.List;

public abstract class FacebookDialogBase<CONTENT, RESULT>
  implements FacebookDialog<CONTENT, RESULT>
{
  public static final Object BASE_AUTOMATIC_MODE = new Object();
  public static final String PAGE_KEY = "FacebookDialog";
  public final Activity activity;
  public final Fragment fragment;
  public List<FacebookDialogBase<CONTENT, RESULT>.ModeHandler> modeHandlers;
  public int requestCode;
  
  public FacebookDialogBase(Activity paramActivity, int paramInt)
  {
    Validate.notNull(paramActivity, "activity");
    activity = paramActivity;
    fragment = null;
    requestCode = paramInt;
  }
  
  public FacebookDialogBase(Fragment paramFragment, int paramInt)
  {
    Validate.notNull(paramFragment, "fragment");
    fragment = paramFragment;
    activity = null;
    requestCode = paramInt;
    if (paramFragment.getActivity() != null) {
      return;
    }
    throw new IllegalArgumentException("Cannot use a fragment that is not attached to an activity");
  }
  
  private List cachedModeHandlers()
  {
    if (modeHandlers == null) {
      modeHandlers = getOrderedModeHandlers();
    }
    return modeHandlers;
  }
  
  private AppCall createAppCallForMode(Object paramObject1, Object paramObject2)
  {
    int i;
    if (paramObject2 == BASE_AUTOMATIC_MODE) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2 = null;
    Iterator localIterator = cachedModeHandlers().iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (ModeHandler)localIterator.next();
    } while (((i == 0) && (!Utility.areObjectsEqual(((ModeHandler)localObject1).getMode(), paramObject2))) || (!((ModeHandler)localObject1).canShow(paramObject1)));
    try
    {
      localObject1 = ((ModeHandler)localObject1).createAppCall(paramObject1);
    }
    catch (FacebookException paramObject2)
    {
      paramObject1 = createBaseAppCall();
      localObject1 = paramObject1;
      DialogPresenter.setupAppCallForErrorResult(paramObject1, paramObject2);
    }
    paramObject1 = localObject1;
    if (localObject1 == null)
    {
      paramObject1 = createBaseAppCall();
      DialogPresenter.setupAppCallForCannotShowError(paramObject1);
    }
    return paramObject1;
  }
  
  public boolean canShow(Object paramObject)
  {
    return canShowImpl(paramObject, BASE_AUTOMATIC_MODE);
  }
  
  public boolean canShowImpl(Object paramObject1, Object paramObject2)
  {
    int i;
    if (paramObject2 == BASE_AUTOMATIC_MODE) {
      i = 1;
    } else {
      i = 0;
    }
    Iterator localIterator = cachedModeHandlers().iterator();
    while (localIterator.hasNext())
    {
      ModeHandler localModeHandler = (ModeHandler)localIterator.next();
      if (((i != 0) || (Utility.areObjectsEqual(localModeHandler.getMode(), paramObject2))) && (localModeHandler.canShow(paramObject1))) {
        return true;
      }
    }
    return false;
  }
  
  public abstract AppCall createBaseAppCall();
  
  public Activity getActivityContext()
  {
    Object localObject = activity;
    if (localObject != null) {
      return localObject;
    }
    localObject = fragment;
    if (localObject != null) {
      return ((Fragment)localObject).getActivity();
    }
    return null;
  }
  
  public abstract List getOrderedModeHandlers();
  
  public int getRequestCode()
  {
    return requestCode;
  }
  
  public final void registerCallback(CallbackManager paramCallbackManager, FacebookCallback paramFacebookCallback)
  {
    if ((paramCallbackManager instanceof CallbackManagerImpl))
    {
      registerCallbackImpl((CallbackManagerImpl)paramCallbackManager, paramFacebookCallback);
      return;
    }
    throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
  }
  
  public final void registerCallback(CallbackManager paramCallbackManager, FacebookCallback paramFacebookCallback, int paramInt)
  {
    setRequestCode(paramInt);
    registerCallback(paramCallbackManager, paramFacebookCallback);
  }
  
  public abstract void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, FacebookCallback paramFacebookCallback);
  
  public void setRequestCode(int paramInt)
  {
    if (!FacebookSdk.isFacebookRequestCode(paramInt))
    {
      requestCode = paramInt;
      return;
    }
    throw new IllegalArgumentException(StringBuilder.toString("Request code ", paramInt, " cannot be within the range reserved by the Facebook SDK."));
  }
  
  public void show(Object paramObject)
  {
    showImpl(paramObject, BASE_AUTOMATIC_MODE);
  }
  
  public void showImpl(Object paramObject1, Object paramObject2)
  {
    paramObject1 = createAppCallForMode(paramObject1, paramObject2);
    if (paramObject1 != null)
    {
      paramObject2 = fragment;
      if (paramObject2 != null)
      {
        paramObject2.startActivityForResult(paramObject1.getRequestIntent(), paramObject1.getRequestCode());
        paramObject1.setPending();
        return;
      }
      activity.startActivityForResult(paramObject1.getRequestIntent(), paramObject1.getRequestCode());
      paramObject1.setPending();
      return;
    }
    if (!FacebookSdk.isDebugEnabled) {
      return;
    }
    throw new IllegalStateException("No code path should ever result in a null appCall");
  }
  
  protected abstract class ModeHandler
  {
    public ModeHandler() {}
    
    public abstract boolean canShow(Object paramObject);
    
    public abstract AppCall createAppCall(Object paramObject);
    
    public Object getMode()
    {
      return FacebookDialogBase.BASE_AUTOMATIC_MODE;
    }
  }
}
