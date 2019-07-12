package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.package_7.Fragment;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LikeDialog
  extends FacebookDialogBase<LikeContent, Result>
{
  public static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();
  public static final String PAGE_KEY = "LikeDialog";
  
  public LikeDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
  }
  
  public LikeDialog(Fragment paramFragment)
  {
    super(paramFragment, DEFAULT_REQUEST_CODE);
  }
  
  public static boolean canShowNativeDialog()
  {
    return DialogPresenter.canPresentNativeDialogWithFeature(LikeDialogFeature.LIKE_DIALOG);
  }
  
  public static boolean canShowWebFallback()
  {
    return DialogPresenter.canPresentWebFallbackDialogWithFeature(LikeDialogFeature.LIKE_DIALOG);
  }
  
  public static Bundle createParameters(LikeContent paramLikeContent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("object_id", paramLikeContent.getObjectId());
    localBundle.putString("object_type", paramLikeContent.getObjectType());
    return localBundle;
  }
  
  public static DialogFeature getFeature()
  {
    return LikeDialogFeature.LIKE_DIALOG;
  }
  
  public AppCall createBaseAppCall()
  {
    return new AppCall(getRequestCode());
  }
  
  public List getOrderedModeHandlers()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new NativeHandler(null));
    localArrayList.add(new WebFallbackHandler(null));
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
          paramFacebookCallback.onSuccess(new LikeDialog.Result(paramAnonymousBundle));
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
  
  private class NativeHandler
    extends FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler
  {
    public NativeHandler()
    {
      super();
    }
    
    public boolean canShow(LikeContent paramLikeContent)
    {
      return (paramLikeContent != null) && (LikeDialog.canShowNativeDialog());
    }
    
    public AppCall createAppCall(LikeContent paramLikeContent)
    {
      AppCall localAppCall = createBaseAppCall();
      Object localObject = LikeDialog.access$300();
      Context localContext = FacebookSdk.getApplicationContext();
      String str = ((DialogFeature)localObject).getAction();
      int i = DialogPresenter.getProtocolVersionForNativeDialog((DialogFeature)localObject);
      if (i != -1)
      {
        if (NativeProtocol.isVersionCompatibleWithBucketedIntent(i)) {
          paramLikeContent = LikeDialog.createParameters(paramLikeContent);
        } else {
          paramLikeContent = new Bundle();
        }
        localObject = paramLikeContent;
        if (paramLikeContent == null) {
          localObject = new Bundle();
        }
        paramLikeContent = NativeProtocol.createPlatformActivityIntent(localContext, localAppCall.getCallId().toString(), str, i, (Bundle)localObject);
        if (paramLikeContent != null)
        {
          localAppCall.setRequestIntent(paramLikeContent);
          return localAppCall;
        }
        throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
      }
      throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
    }
  }
  
  public static final class Result
  {
    public final Bundle bundle;
    
    public Result(Bundle paramBundle)
    {
      bundle = paramBundle;
    }
    
    public Bundle getData()
    {
      return bundle;
    }
  }
  
  private class WebFallbackHandler
    extends FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler
  {
    public WebFallbackHandler()
    {
      super();
    }
    
    public boolean canShow(LikeContent paramLikeContent)
    {
      return (paramLikeContent != null) && (LikeDialog.canShowWebFallback());
    }
    
    public AppCall createAppCall(LikeContent paramLikeContent)
    {
      AppCall localAppCall = createBaseAppCall();
      DialogPresenter.setupAppCallForWebFallbackDialog(localAppCall, LikeDialog.createParameters(paramLikeContent), LikeDialog.access$300());
      return localAppCall;
    }
  }
}
