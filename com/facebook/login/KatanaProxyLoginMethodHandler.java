package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.package_7.Fragment;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import java.util.Collection;

public class KatanaProxyLoginMethodHandler
  extends LoginMethodHandler
{
  public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new Parcelable.Creator()
  {
    public KatanaProxyLoginMethodHandler createFromParcel(Parcel paramAnonymousParcel)
    {
      return new KatanaProxyLoginMethodHandler(paramAnonymousParcel);
    }
    
    public KatanaProxyLoginMethodHandler[] newArray(int paramAnonymousInt)
    {
      return new KatanaProxyLoginMethodHandler[paramAnonymousInt];
    }
  };
  
  public KatanaProxyLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public KatanaProxyLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  private String getError(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("error");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString("error_type");
    }
    return str1;
  }
  
  private String getErrorMessage(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("error_message");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString("error_description");
    }
    return str1;
  }
  
  private LoginClient.Result handleResultCancel(LoginClient.Request paramRequest, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    String str1 = getError(paramIntent);
    String str2 = paramIntent.getString("error_code");
    if ("CONNECTION_FAILURE".equals(str2)) {
      return LoginClient.Result.createErrorResult(paramRequest, str1, getErrorMessage(paramIntent), str2);
    }
    return LoginClient.Result.createCancelResult(paramRequest, str1);
  }
  
  private LoginClient.Result handleResultOk(LoginClient.Request paramRequest, Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    Object localObject1 = getError(paramIntent);
    Object localObject2 = paramIntent.getString("error_code");
    String str1 = getErrorMessage(paramIntent);
    String str2 = paramIntent.getString("e2e");
    if (!Utility.isNullOrEmpty(str2)) {
      logWebLoginCompleted(str2);
    }
    if ((localObject1 == null) && (localObject2 == null) && (str1 == null)) {
      try
      {
        localObject1 = paramRequest.getPermissions();
        localObject2 = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
        paramIntent = LoginClient.Result.createTokenResult(paramRequest, LoginMethodHandler.createAccessTokenFromWebBundle((Collection)localObject1, paramIntent, (AccessTokenSource)localObject2, paramRequest.getApplicationId()));
        return paramIntent;
      }
      catch (FacebookException paramIntent)
      {
        return LoginClient.Result.createErrorResult(paramRequest, null, paramIntent.getMessage());
      }
    }
    if (ServerProtocol.errorsProxyAuthDisabled.contains(localObject1)) {
      return null;
    }
    if (ServerProtocol.errorsUserCanceled.contains(localObject1)) {
      return LoginClient.Result.createCancelResult(paramRequest, null);
    }
    return LoginClient.Result.createErrorResult(paramRequest, (String)localObject1, str1, (String)localObject2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getNameForLogging()
  {
    return "katana_proxy_auth";
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    LoginClient.Request localRequest = loginClient.getPendingRequest();
    if (paramIntent == null) {
      paramIntent = LoginClient.Result.createCancelResult(localRequest, "Operation canceled");
    } else if (paramInt2 == 0) {
      paramIntent = handleResultCancel(localRequest, paramIntent);
    } else if (paramInt2 != -1) {
      paramIntent = LoginClient.Result.createErrorResult(localRequest, "Unexpected resultCode from authorization.", null);
    } else {
      paramIntent = handleResultOk(localRequest, paramIntent);
    }
    if (paramIntent != null) {
      loginClient.completeAndValidate(paramIntent);
    } else {
      loginClient.tryNextHandler();
    }
    return true;
  }
  
  public boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    String str = LoginClient.getE2E();
    paramRequest = NativeProtocol.createProxyAuthIntent(loginClient.getActivity(), paramRequest.getApplicationId(), paramRequest.getPermissions(), str, paramRequest.isRerequest(), paramRequest.hasPublishPermission(), paramRequest.getDefaultAudience());
    addLoggingExtra("e2e", str);
    return tryIntent(paramRequest, LoginClient.getLoginRequestCode());
  }
  
  public boolean tryIntent(Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {
      return false;
    }
    LoginClient localLoginClient = loginClient;
    try
    {
      localLoginClient.getFragment().startActivityForResult(paramIntent, paramInt);
      return true;
    }
    catch (ActivityNotFoundException paramIntent) {}
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Utility.writeStringMapToParcel(paramParcel, methodLoggingExtras);
  }
}
