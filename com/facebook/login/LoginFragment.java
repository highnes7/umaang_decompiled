package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.package_7.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.R.id;
import com.facebook.R.layout;

public class LoginFragment
  extends Fragment
{
  public static final String EXTRA_REQUEST = "request";
  public static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";
  public static final String RESULT_KEY = "com.facebook.LoginFragment:Result";
  public static final String SAVED_LOGIN_CLIENT = "loginClient";
  public static final String domain = "LoginFragment";
  public String callingPackage;
  public LoginClient loginClient;
  public LoginClient.Request request;
  
  public LoginFragment() {}
  
  private void initializeCallingPackage(Activity paramActivity)
  {
    paramActivity = paramActivity.getCallingActivity();
    if (paramActivity == null) {
      return;
    }
    callingPackage = paramActivity.getPackageName();
  }
  
  private void onLoginClientCompleted(LoginClient.Result paramResult)
  {
    request = null;
    int i;
    if (code == LoginClient.Result.Code.CANCEL) {
      i = 0;
    } else {
      i = -1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.facebook.LoginFragment:Result", paramResult);
    paramResult = new Intent();
    paramResult.putExtras(localBundle);
    if (isAdded())
    {
      getActivity().setResult(i, paramResult);
      getActivity().finish();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    loginClient.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      loginClient = ((LoginClient)paramBundle.getParcelable("loginClient"));
      loginClient.setFragment(this);
    }
    else
    {
      loginClient = new LoginClient(this);
    }
    loginClient.setOnCompletedListener(new LoginClient.OnCompletedListener()
    {
      public void onCompleted(LoginClient.Result paramAnonymousResult)
      {
        LoginFragment.access$000(LoginFragment.this, paramAnonymousResult);
      }
    });
    paramBundle = getActivity();
    if (paramBundle == null) {
      return;
    }
    initializeCallingPackage(paramBundle);
    if (paramBundle.getIntent() != null) {
      request = ((LoginClient.Request)paramBundle.getIntent().getParcelableExtra("request"));
    }
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.com_facebook_login_fragment, paramViewGroup, false);
    loginClient.setBackgroundProcessingListener(new LoginClient.BackgroundProcessingListener()
    {
      public void onBackgroundProcessingStarted()
      {
        paramLayoutInflater.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(0);
      }
      
      public void onBackgroundProcessingStopped()
      {
        paramLayoutInflater.findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
      }
    });
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    loginClient.cancelCurrentHandler();
    super.onDestroy();
  }
  
  public void onPause()
  {
    mCalled = true;
    getActivity().findViewById(R.id.com_facebook_login_activity_progress_bar).setVisibility(8);
  }
  
  public void onResume()
  {
    mCalled = true;
    if (callingPackage == null)
    {
      getActivity().finish();
      return;
    }
    loginClient.startOrContinueAuth(request);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("loginClient", loginClient);
  }
}
