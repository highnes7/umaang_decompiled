package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.package_7.Fragment;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.UUID;

public class DialogPresenter
{
  public DialogPresenter() {}
  
  public static boolean canPresentNativeDialogWithFeature(DialogFeature paramDialogFeature)
  {
    return getProtocolVersionForNativeDialog(paramDialogFeature) != -1;
  }
  
  public static boolean canPresentWebFallbackDialogWithFeature(DialogFeature paramDialogFeature)
  {
    return getDialogWebFallbackUri(paramDialogFeature) != null;
  }
  
  public static Uri getDialogWebFallbackUri(DialogFeature paramDialogFeature)
  {
    String str = paramDialogFeature.name();
    paramDialogFeature = paramDialogFeature.getAction();
    paramDialogFeature = Utility.getDialogFeatureConfig(FacebookSdk.getApplicationId(), paramDialogFeature, str);
    if (paramDialogFeature != null) {
      return paramDialogFeature.getFallbackUrl();
    }
    return null;
  }
  
  public static int getProtocolVersionForNativeDialog(DialogFeature paramDialogFeature)
  {
    String str1 = FacebookSdk.getApplicationId();
    String str2 = paramDialogFeature.getAction();
    return NativeProtocol.getLatestAvailableProtocolVersionForAction(str2, getVersionSpecForFeature(str1, str2, paramDialogFeature));
  }
  
  public static int[] getVersionSpecForFeature(String paramString1, String paramString2, DialogFeature paramDialogFeature)
  {
    paramString1 = Utility.getDialogFeatureConfig(paramString1, paramString2, paramDialogFeature.name());
    if (paramString1 != null) {
      return paramString1.getVersionSpec();
    }
    return new int[] { paramDialogFeature.getMinVersion() };
  }
  
  public static void logDialogActivity(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = AppEventsLogger.newLogger(paramContext);
    Bundle localBundle = new Bundle();
    localBundle.putString("fb_dialog_outcome", paramString2);
    paramContext.logSdkEvent(paramString1, null, localBundle);
  }
  
  public static void present(AppCall paramAppCall, Activity paramActivity)
  {
    paramActivity.startActivityForResult(paramAppCall.getRequestIntent(), paramAppCall.getRequestCode());
    paramAppCall.setPending();
  }
  
  public static void present(AppCall paramAppCall, Fragment paramFragment)
  {
    paramFragment.startActivityForResult(paramAppCall.getRequestIntent(), paramAppCall.getRequestCode());
    paramAppCall.setPending();
  }
  
  public static void setupAppCallForCannotShowError(AppCall paramAppCall)
  {
    setupAppCallForErrorResult(paramAppCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
  }
  
  public static void setupAppCallForErrorResult(AppCall paramAppCall, FacebookException paramFacebookException)
  {
    if (paramFacebookException == null) {
      return;
    }
    Validate.hasFacebookActivity(FacebookSdk.getApplicationContext(), true);
    Intent localIntent = new Intent();
    localIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    localIntent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
    NativeProtocol.setupProtocolRequestIntent(localIntent, paramAppCall.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(paramFacebookException));
    paramAppCall.setRequestIntent(localIntent);
  }
  
  public static void setupAppCallForNativeDialog(AppCall paramAppCall, ParameterProvider paramParameterProvider, DialogFeature paramDialogFeature)
  {
    Context localContext = FacebookSdk.getApplicationContext();
    String str = paramDialogFeature.getAction();
    int i = getProtocolVersionForNativeDialog(paramDialogFeature);
    if (i != -1)
    {
      if (NativeProtocol.isVersionCompatibleWithBucketedIntent(i)) {
        paramParameterProvider = paramParameterProvider.getParameters();
      } else {
        paramParameterProvider = paramParameterProvider.getLegacyParameters();
      }
      paramDialogFeature = paramParameterProvider;
      if (paramParameterProvider == null) {
        paramDialogFeature = new Bundle();
      }
      paramParameterProvider = NativeProtocol.createPlatformActivityIntent(localContext, paramAppCall.getCallId().toString(), str, i, paramDialogFeature);
      if (paramParameterProvider != null)
      {
        paramAppCall.setRequestIntent(paramParameterProvider);
        return;
      }
      throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
    }
    throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
  }
  
  public static void setupAppCallForValidationError(AppCall paramAppCall, FacebookException paramFacebookException)
  {
    setupAppCallForErrorResult(paramAppCall, paramFacebookException);
  }
  
  public static void setupAppCallForWebDialog(AppCall paramAppCall, String paramString, Bundle paramBundle)
  {
    Validate.hasFacebookActivity(FacebookSdk.getApplicationContext(), true);
    Validate.hasInternetPermissions(FacebookSdk.getApplicationContext(), true);
    Bundle localBundle = new Bundle();
    localBundle.putString("action", paramString);
    localBundle.putBundle("params", paramBundle);
    paramBundle = new Intent();
    NativeProtocol.setupProtocolRequestIntent(paramBundle, paramAppCall.getCallId().toString(), paramString, NativeProtocol.getLatestKnownVersion(), localBundle);
    paramBundle.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    paramBundle.setAction("FacebookDialogFragment");
    paramAppCall.setRequestIntent(paramBundle);
  }
  
  public static void setupAppCallForWebFallbackDialog(AppCall paramAppCall, Bundle paramBundle, DialogFeature paramDialogFeature)
  {
    Validate.hasFacebookActivity(FacebookSdk.getApplicationContext(), true);
    Validate.hasInternetPermissions(FacebookSdk.getApplicationContext(), true);
    String str = paramDialogFeature.name();
    Object localObject = getDialogWebFallbackUri(paramDialogFeature);
    if (localObject != null)
    {
      int i = NativeProtocol.getLatestKnownVersion();
      paramBundle = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(paramAppCall.getCallId().toString(), i, paramBundle);
      if (paramBundle != null)
      {
        if (((Uri)localObject).isRelative()) {
          paramBundle = Utility.buildUri(ServerProtocol.getDialogAuthority(), ((Uri)localObject).toString(), paramBundle);
        } else {
          paramBundle = Utility.buildUri(((Uri)localObject).getAuthority(), ((Uri)localObject).getPath(), paramBundle);
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("url", paramBundle.toString());
        ((Bundle)localObject).putBoolean("is_fallback", true);
        paramBundle = new Intent();
        NativeProtocol.setupProtocolRequestIntent(paramBundle, paramAppCall.getCallId().toString(), paramDialogFeature.getAction(), NativeProtocol.getLatestKnownVersion(), (Bundle)localObject);
        paramBundle.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        paramBundle.setAction("FacebookDialogFragment");
        paramAppCall.setRequestIntent(paramBundle);
        return;
      }
      throw new FacebookException("Unable to fetch the app's key-hash");
    }
    throw new FacebookException(StringBuilder.append("Unable to fetch the Url for the DialogFeature : '", str, "'"));
  }
  
  public static abstract interface ParameterProvider
  {
    public abstract Bundle getLegacyParameters();
    
    public abstract Bundle getParameters();
  }
}
