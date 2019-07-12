package com.facebook.login;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.package_7.DialogFragment;
import android.support.v4.package_7.Fragment;
import android.support.v4.package_7.FragmentActivity;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import java.util.Locale;

public class WebViewLoginMethodHandler
  extends LoginMethodHandler
{
  public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator()
  {
    public WebViewLoginMethodHandler createFromParcel(Parcel paramAnonymousParcel)
    {
      return new WebViewLoginMethodHandler(paramAnonymousParcel);
    }
    
    public WebViewLoginMethodHandler[] newArray(int paramAnonymousInt)
    {
      return new WebViewLoginMethodHandler[paramAnonymousInt];
    }
  };
  public static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
  public static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
  public WebDialog loginDialog;
  public String searchTerm;
  
  public WebViewLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
    searchTerm = paramParcel.readString();
  }
  
  public WebViewLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  private String loadCookieToken()
  {
    return loginClient.getActivity().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
  }
  
  private void saveCookieToken(String paramString)
  {
    loginClient.getActivity().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", paramString).apply();
  }
  
  public void cancel()
  {
    WebDialog localWebDialog = loginDialog;
    if (localWebDialog != null)
    {
      localWebDialog.cancel();
      loginDialog = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getNameForLogging()
  {
    return "web_view";
  }
  
  public boolean needsInternetPermission()
  {
    return true;
  }
  
  public void onWebDialogComplete(LoginClient.Request paramRequest, Bundle paramBundle, FacebookException paramFacebookException)
  {
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("e2e")) {
        searchTerm = paramBundle.getString("e2e");
      }
      try
      {
        paramFacebookException = paramRequest.getPermissions();
        AccessTokenSource localAccessTokenSource = AccessTokenSource.WEB_VIEW;
        paramBundle = LoginMethodHandler.createAccessTokenFromWebBundle(paramFacebookException, paramBundle, localAccessTokenSource, paramRequest.getApplicationId());
        paramRequest = loginClient;
        paramRequest = LoginClient.Result.createTokenResult(paramRequest.getPendingRequest(), paramBundle);
        paramFacebookException = loginClient;
        CookieSyncManager.createInstance(paramFacebookException.getActivity()).sync();
        saveCookieToken(paramBundle.getToken());
      }
      catch (FacebookException paramRequest)
      {
        paramRequest = LoginClient.Result.createErrorResult(loginClient.getPendingRequest(), null, paramRequest.getMessage());
      }
    }
    else if ((paramFacebookException instanceof FacebookOperationCanceledException))
    {
      paramRequest = LoginClient.Result.createCancelResult(loginClient.getPendingRequest(), "User canceled log in.");
    }
    else
    {
      searchTerm = null;
      paramBundle = paramFacebookException.getMessage();
      if ((paramFacebookException instanceof FacebookServiceException))
      {
        paramBundle = ((FacebookServiceException)paramFacebookException).getRequestError();
        paramRequest = String.format(Locale.ROOT, "%d", new Object[] { Integer.valueOf(paramBundle.getErrorCode()) });
        paramBundle = paramBundle.toString();
      }
      else
      {
        paramRequest = null;
      }
      paramRequest = LoginClient.Result.createErrorResult(loginClient.getPendingRequest(), null, paramBundle, paramRequest);
    }
    if (!Utility.isNullOrEmpty(searchTerm)) {
      logWebLoginCompleted(searchTerm);
    }
    loginClient.completeAndValidate(paramRequest);
  }
  
  public boolean tryAuthorize(final LoginClient.Request paramRequest)
  {
    Bundle localBundle = new Bundle();
    if (!Utility.isNullOrEmpty(paramRequest.getPermissions()))
    {
      localObject = TextUtils.join(",", paramRequest.getPermissions());
      localBundle.putString("scope", (String)localObject);
      addLoggingExtra("scope", localObject);
    }
    localBundle.putString("default_audience", paramRequest.getDefaultAudience().getNativeProtocolAudience());
    Object localObject = AccessToken.getCurrentAccessToken();
    if (localObject != null) {
      localObject = ((AccessToken)localObject).getToken();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((String)localObject).equals(loadCookieToken())))
    {
      localBundle.putString("access_token", (String)localObject);
      addLoggingExtra("access_token", "1");
    }
    else
    {
      Utility.clearFacebookCookies(loginClient.getActivity());
      addLoggingExtra("access_token", "0");
    }
    WebDialog.OnCompleteListener local1 = new WebDialog.OnCompleteListener()
    {
      public void onComplete(Bundle paramAnonymousBundle, FacebookException paramAnonymousFacebookException)
      {
        onWebDialogComplete(paramRequest, paramAnonymousBundle, paramAnonymousFacebookException);
      }
    };
    searchTerm = LoginClient.getE2E();
    addLoggingExtra("e2e", searchTerm);
    localObject = loginClient.getActivity();
    loginDialog = new AuthDialogBuilder((Context)localObject, paramRequest.getApplicationId(), localBundle).setE2E(searchTerm).setIsRerequest(paramRequest.isRerequest()).setOnCompleteListener(local1).setTheme(FacebookSdk.getWebDialogTheme()).build();
    paramRequest = new FacebookDialogFragment();
    paramRequest.setRetainInstance(true);
    paramRequest.setDialog(loginDialog);
    paramRequest.show(((FragmentActivity)localObject).getSupportFragmentManager(), "FacebookDialogFragment");
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Utility.writeStringMapToParcel(paramParcel, methodLoggingExtras);
    paramParcel.writeString(searchTerm);
  }
  
  public static class AuthDialogBuilder
    extends WebDialog.Builder
  {
    public static final String OAUTH_DIALOG = "oauth";
    public static final String REDIRECT_URI = "fbconnect://success";
    public boolean isRerequest;
    public String replyText;
    
    public AuthDialogBuilder(Context paramContext, String paramString, Bundle paramBundle)
    {
      super(paramString, "oauth", paramBundle);
    }
    
    public WebDialog build()
    {
      Bundle localBundle = getParameters();
      localBundle.putString("redirect_uri", "fbconnect://success");
      localBundle.putString("client_id", getApplicationId());
      localBundle.putString("e2e", replyText);
      localBundle.putString("response_type", "token,signed_request");
      localBundle.putString("return_scopes", "true");
      if (isRerequest) {
        localBundle.putString("auth_type", "rerequest");
      }
      return new WebDialog(getContext(), "oauth", localBundle, getTheme(), getListener());
    }
    
    public AuthDialogBuilder setE2E(String paramString)
    {
      replyText = paramString;
      return this;
    }
    
    public AuthDialogBuilder setIsRerequest(boolean paramBoolean)
    {
      isRerequest = paramBoolean;
      return this;
    }
  }
}
