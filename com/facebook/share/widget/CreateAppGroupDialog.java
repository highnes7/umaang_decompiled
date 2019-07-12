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
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.AppGroupCreationContent;
import java.util.ArrayList;
import java.util.List;

public class CreateAppGroupDialog
  extends FacebookDialogBase<AppGroupCreationContent, Result>
{
  public static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppGroupCreate.toRequestCode();
  public static final String GAME_GROUP_CREATION_DIALOG = "game_group_create";
  
  public CreateAppGroupDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
  }
  
  public CreateAppGroupDialog(Fragment paramFragment)
  {
    super(paramFragment, DEFAULT_REQUEST_CODE);
  }
  
  public static boolean canShow()
  {
    return true;
  }
  
  public static void show(Activity paramActivity, AppGroupCreationContent paramAppGroupCreationContent)
  {
    new CreateAppGroupDialog(paramActivity).show(paramAppGroupCreationContent);
  }
  
  public static void show(Fragment paramFragment, AppGroupCreationContent paramAppGroupCreationContent)
  {
    new CreateAppGroupDialog(paramFragment).show(paramAppGroupCreationContent);
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
          paramFacebookCallback.onSuccess(new CreateAppGroupDialog.Result(paramAnonymousBundle.getString("id"), null));
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
    public final String mUserId;
    
    public Result(String paramString)
    {
      mUserId = paramString;
    }
    
    public String getId()
    {
      return mUserId;
    }
  }
  
  private class WebHandler
    extends FacebookDialogBase<AppGroupCreationContent, CreateAppGroupDialog.Result>.ModeHandler
  {
    public WebHandler()
    {
      super();
    }
    
    public boolean canShow(AppGroupCreationContent paramAppGroupCreationContent)
    {
      return true;
    }
    
    public AppCall createAppCall(AppGroupCreationContent paramAppGroupCreationContent)
    {
      AppCall localAppCall = createBaseAppCall();
      DialogPresenter.setupAppCallForWebDialog(localAppCall, "game_group_create", WebDialogParameters.create(paramAppGroupCreationContent));
      return localAppCall;
    }
  }
}
