package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.package_7.Fragment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.Validate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LoginManager
{
  public static final String MANAGE_PERMISSION_PREFIX = "manage";
  public static final Set<String> OTHER_PUBLISH_PERMISSIONS = ;
  public static final String PUBLISH_PERMISSION_PREFIX = "publish";
  public static volatile LoginManager instance;
  public DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
  public LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
  
  public LoginManager()
  {
    Validate.sdkInitialized();
  }
  
  public static LoginResult computeLoginResult(LoginClient.Request paramRequest, AccessToken paramAccessToken)
  {
    Set localSet = paramRequest.getPermissions();
    HashSet localHashSet = new HashSet(paramAccessToken.getPermissions());
    if (paramRequest.isRerequest()) {
      localHashSet.retainAll(localSet);
    }
    paramRequest = new HashSet(localSet);
    paramRequest.removeAll(localHashSet);
    return new LoginResult(paramAccessToken, localHashSet, paramRequest);
  }
  
  private LoginClient.Request createLoginRequest(Collection paramCollection)
  {
    LoginBehavior localLoginBehavior = loginBehavior;
    if (paramCollection != null) {
      paramCollection = new HashSet(paramCollection);
    } else {
      paramCollection = new HashSet();
    }
    paramCollection = new LoginClient.Request(localLoginBehavior, Collections.unmodifiableSet(paramCollection), defaultAudience, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
    boolean bool;
    if (AccessToken.getCurrentAccessToken() != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramCollection.setRerequest(bool);
    return paramCollection;
  }
  
  private LoginClient.Request createLoginRequestFromResponse(GraphResponse paramGraphResponse)
  {
    Validate.notNull(paramGraphResponse, "response");
    paramGraphResponse = paramGraphResponse.getRequest().getAccessToken();
    if (paramGraphResponse != null) {
      paramGraphResponse = paramGraphResponse.getPermissions();
    } else {
      paramGraphResponse = null;
    }
    return createLoginRequest(paramGraphResponse);
  }
  
  private void finishLogin(AccessToken paramAccessToken, LoginClient.Request paramRequest, FacebookException paramFacebookException, boolean paramBoolean, FacebookCallback paramFacebookCallback)
  {
    if (paramAccessToken != null)
    {
      AccessToken.setCurrentAccessToken(paramAccessToken);
      Profile.fetchProfileForCurrentAccessToken();
    }
    if (paramFacebookCallback != null)
    {
      if (paramAccessToken != null) {
        paramRequest = computeLoginResult(paramRequest, paramAccessToken);
      } else {
        paramRequest = null;
      }
      if ((!paramBoolean) && ((paramRequest == null) || (paramRequest.getRecentlyGrantedPermissions().size() != 0)))
      {
        if (paramFacebookException != null)
        {
          paramFacebookCallback.onError(paramFacebookException);
          return;
        }
        if (paramAccessToken != null) {
          paramFacebookCallback.onSuccess(paramRequest);
        }
      }
      else
      {
        paramFacebookCallback.onCancel();
      }
    }
  }
  
  private Intent getFacebookActivityIntent(LoginClient.Request paramRequest)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    localIntent.setAction(paramRequest.getLoginBehavior().toString());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("request", paramRequest);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public static LoginManager getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new LoginManager();
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return instance;
  }
  
  public static Set getOtherPublishPermissions()
  {
    Collections.unmodifiableSet(new HashSet() {});
  }
  
  public static boolean isPublishPermission(String paramString)
  {
    return (paramString != null) && ((paramString.startsWith("publish")) || (paramString.startsWith("manage")) || (OTHER_PUBLISH_PERMISSIONS.contains(paramString)));
  }
  
  private void logCompleteLogin(Context paramContext, LoginClient.Result.Code paramCode, Map paramMap, Exception paramException, boolean paramBoolean, LoginClient.Request paramRequest)
  {
    LoginLogger localLoginLogger = LoginLoggerHolder.getLogger(paramContext);
    if (localLoginLogger == null) {
      return;
    }
    if (paramRequest == null)
    {
      localLoginLogger.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {
      paramContext = "1";
    } else {
      paramContext = "0";
    }
    localHashMap.put("try_login_activity", paramContext);
    localLoginLogger.logCompleteLogin(paramRequest.getAuthId(), localHashMap, paramCode, paramMap, paramException);
  }
  
  private void logStartLogin(Context paramContext, LoginClient.Request paramRequest)
  {
    paramContext = LoginLoggerHolder.getLogger(paramContext);
    if ((paramContext != null) && (paramRequest != null)) {
      paramContext.logStartLogin(paramRequest);
    }
  }
  
  private boolean resolveIntent(Intent paramIntent)
  {
    return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(paramIntent, 0) != null;
  }
  
  private void startLogin(StartActivityDelegate paramStartActivityDelegate, LoginClient.Request paramRequest)
    throws FacebookException
  {
    logStartLogin(paramStartActivityDelegate.getActivityContext(), paramRequest);
    CallbackManagerImpl.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback()
    {
      public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        return LoginManager.this.onActivityResult(paramAnonymousInt, paramAnonymousIntent);
      }
    });
    if (tryFacebookActivity(paramStartActivityDelegate, paramRequest)) {
      return;
    }
    FacebookException localFacebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
    logCompleteLogin(paramStartActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, localFacebookException, false, paramRequest);
    throw localFacebookException;
  }
  
  private boolean tryFacebookActivity(StartActivityDelegate paramStartActivityDelegate, LoginClient.Request paramRequest)
  {
    paramRequest = getFacebookActivityIntent(paramRequest);
    if (!resolveIntent(paramRequest)) {
      return false;
    }
    try
    {
      paramStartActivityDelegate.startActivityForResult(paramRequest, LoginClient.getLoginRequestCode());
      return true;
    }
    catch (ActivityNotFoundException paramStartActivityDelegate) {}
    return false;
  }
  
  private void validatePublishPermissions(Collection paramCollection)
  {
    if (paramCollection == null) {
      return;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (!isPublishPermission(str)) {
        throw new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[] { str }));
      }
    }
  }
  
  private void validateReadPermissions(Collection paramCollection)
  {
    if (paramCollection == null) {
      return;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (isPublishPermission(str)) {
        throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[] { str }));
      }
    }
  }
  
  public DefaultAudience getDefaultAudience()
  {
    return defaultAudience;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    return loginBehavior;
  }
  
  public void logInWithPublishPermissions(Activity paramActivity, Collection paramCollection)
  {
    validatePublishPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new ActivityStartActivityDelegate(paramActivity), paramCollection);
  }
  
  public void logInWithPublishPermissions(Fragment paramFragment, Collection paramCollection)
  {
    validatePublishPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new FragmentStartActivityDelegate(paramFragment), paramCollection);
  }
  
  public void logInWithReadPermissions(Activity paramActivity, Collection paramCollection)
  {
    validateReadPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new ActivityStartActivityDelegate(paramActivity), paramCollection);
  }
  
  public void logInWithReadPermissions(Fragment paramFragment, Collection paramCollection)
  {
    validateReadPermissions(paramCollection);
    paramCollection = createLoginRequest(paramCollection);
    startLogin(new FragmentStartActivityDelegate(paramFragment), paramCollection);
  }
  
  public void logOut()
  {
    AccessToken.setCurrentAccessToken(null);
    Profile.setCurrentProfile(null);
  }
  
  public boolean onActivityResult(int paramInt, Intent paramIntent)
  {
    return onActivityResult(paramInt, paramIntent, null);
  }
  
  public boolean onActivityResult(int paramInt, Intent paramIntent, FacebookCallback paramFacebookCallback)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a45 = a44\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, final FacebookCallback paramFacebookCallback)
  {
    if ((paramCallbackManager instanceof CallbackManagerImpl))
    {
      ((CallbackManagerImpl)paramCallbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback()
      {
        public boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          return onActivityResult(paramAnonymousInt, paramAnonymousIntent, paramFacebookCallback);
        }
      });
      return;
    }
    throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
  }
  
  public void resolveError(Activity paramActivity, GraphResponse paramGraphResponse)
  {
    startLogin(new ActivityStartActivityDelegate(paramActivity), createLoginRequestFromResponse(paramGraphResponse));
  }
  
  public void resolveError(Fragment paramFragment, GraphResponse paramGraphResponse)
  {
    startLogin(new FragmentStartActivityDelegate(paramFragment), createLoginRequestFromResponse(paramGraphResponse));
  }
  
  public LoginManager setDefaultAudience(DefaultAudience paramDefaultAudience)
  {
    defaultAudience = paramDefaultAudience;
    return this;
  }
  
  public LoginManager setLoginBehavior(LoginBehavior paramLoginBehavior)
  {
    loginBehavior = paramLoginBehavior;
    return this;
  }
  
  private static class ActivityStartActivityDelegate
    implements StartActivityDelegate
  {
    public final Activity activity;
    
    public ActivityStartActivityDelegate(Activity paramActivity)
    {
      Validate.notNull(paramActivity, "activity");
      activity = paramActivity;
    }
    
    public Activity getActivityContext()
    {
      return activity;
    }
    
    public void startActivityForResult(Intent paramIntent, int paramInt)
    {
      activity.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  private static class FragmentStartActivityDelegate
    implements StartActivityDelegate
  {
    public final Fragment fragment;
    
    public FragmentStartActivityDelegate(Fragment paramFragment)
    {
      Validate.notNull(paramFragment, "fragment");
      fragment = paramFragment;
    }
    
    public Activity getActivityContext()
    {
      return fragment.getActivity();
    }
    
    public void startActivityForResult(Intent paramIntent, int paramInt)
    {
      fragment.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  private static class LoginLoggerHolder
  {
    public static volatile LoginLogger logger;
    
    public LoginLoggerHolder() {}
    
    public static LoginLogger getLogger(Context paramContext)
    {
      if (paramContext == null) {}
      try
      {
        paramContext = FacebookSdk.getApplicationContext();
        if (paramContext == null) {
          return null;
        }
        if (logger == null) {
          logger = new LoginLogger(paramContext, FacebookSdk.getApplicationId());
        }
        paramContext = logger;
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        throw paramContext;
      }
    }
  }
}
