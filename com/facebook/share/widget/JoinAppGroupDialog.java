package com.facebook.share.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.package_7.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.List;

public class JoinAppGroupDialog
  extends FacebookDialogBase<String, Result>
{
  public static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupJoin.toRequestCode();
  public static final String JOIN_GAME_GROUP_DIALOG = "game_group_join";
  
  public JoinAppGroupDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
  }
  
  public JoinAppGroupDialog(Fragment paramFragment)
  {
    super(paramFragment, DEFAULT_REQUEST_CODE);
  }
  
  public static boolean canShow()
  {
    return true;
  }
  
  public static void show(Activity paramActivity, String paramString)
  {
    new JoinAppGroupDialog(paramActivity).show(paramString);
  }
  
  public static void show(Fragment paramFragment, String paramString)
  {
    new JoinAppGroupDialog(paramFragment).show(paramString);
  }
  
  public AppCall createBaseAppCall()
  {
    return new AppCall(getRequestCode());
  }
  
  public List getOrderedModeHandlers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new WebHandler(null));
    return localArrayList;
  }
  
  public void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, final FacebookCallback paramFacebookCallback)
  {
    if (paramFacebookCallback == null) {
      paramFacebookCallback = null;
    } else {
      paramFacebookCallback = new ResultProcessor(paramFacebookCallback)
      {
        public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
        {
          paramFacebookCallback.onSuccess(new JoinAppGroupDialog.Result(paramAnonymousBundle, null));
        }
      };
    }
    paramFacebookCallback = new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        return ShareInternalUtility.handleActivityResult(getRequestCode(), paramAnonymousInt, paramAnonymousIntent, paramFacebookCallback);
      }
    };
    paramCallbackManagerImpl.registerCallback(getRequestCode(), paramFacebookCallback);
  }
  
  public static final class Result
  {
    public final Bundle data;
    
    public Result(Bundle paramBundle)
    {
      data = paramBundle;
    }
    
    public Bundle getData()
    {
      return data;
    }
  }
  
  private class WebHandler
    extends FacebookDialogBase<String, JoinAppGroupDialog.Result>.ModeHandler
  {
    public WebHandler()
    {
      super();
    }
    
    public boolean canShow(String paramString)
    {
      return true;
    }
    
    public AppCall createAppCall(String paramString)
    {
      AppCall localAppCall = createBaseAppCall();
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString);
      DialogPresenter.setupAppCallForWebDialog(localAppCall, "game_group_join", localBundle);
      return localAppCall;
    }
  }
}
