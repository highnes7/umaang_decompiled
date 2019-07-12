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
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;

public class GameRequestDialog
  extends FacebookDialogBase<GameRequestContent, Result>
{
  public static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();
  public static final String GAME_REQUEST_DIALOG = "apprequests";
  
  public GameRequestDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
  }
  
  public GameRequestDialog(Fragment paramFragment)
  {
    super(paramFragment, DEFAULT_REQUEST_CODE);
  }
  
  public static boolean canShow()
  {
    return true;
  }
  
  public static void show(Activity paramActivity, GameRequestContent paramGameRequestContent)
  {
    new GameRequestDialog(paramActivity).show(paramGameRequestContent);
  }
  
  public static void show(Fragment paramFragment, GameRequestContent paramGameRequestContent)
  {
    new GameRequestDialog(paramFragment).show(paramGameRequestContent);
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
          if (paramAnonymousBundle != null)
          {
            paramFacebookCallback.onSuccess(new GameRequestDialog.Result(paramAnonymousBundle));
            return;
          }
          onCancel(paramAnonymousAppCall);
        }
      };
    }
    paramCallbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        return ShareInternalUtility.handleActivityResult(getRequestCode(), paramAnonymousInt, paramAnonymousIntent, paramFacebookCallback);
      }
    });
  }
  
  public static final class Result
  {
    public List<String> mDataList;
    public String requestId;
    
    public Result(Bundle paramBundle)
    {
      requestId = paramBundle.getString("request");
      mDataList = new ArrayList();
      while (paramBundle.containsKey(String.format("to[%d]", new Object[] { Integer.valueOf(mDataList.size()) })))
      {
        List localList = mDataList;
        localList.add(paramBundle.getString(String.format("to[%d]", new Object[] { Integer.valueOf(localList.size()) })));
      }
    }
    
    public String getRequestId()
    {
      return requestId;
    }
    
    public List getRequestRecipients()
    {
      return mDataList;
    }
  }
  
  private class WebHandler
    extends FacebookDialogBase<GameRequestContent, GameRequestDialog.Result>.ModeHandler
  {
    public WebHandler()
    {
      super();
    }
    
    public boolean canShow(GameRequestContent paramGameRequestContent)
    {
      return true;
    }
    
    public AppCall createAppCall(GameRequestContent paramGameRequestContent)
    {
      GameRequestValidation.validate(paramGameRequestContent);
      AppCall localAppCall = createBaseAppCall();
      DialogPresenter.setupAppCallForWebDialog(localAppCall, "apprequests", WebDialogParameters.create(paramGameRequestContent));
      return localAppCall;
    }
  }
}
