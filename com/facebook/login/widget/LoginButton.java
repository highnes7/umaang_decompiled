package com.facebook.login.widget;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.R.color;
import com.facebook.R.string;
import com.facebook.R.style;
import com.facebook.R.styleable;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class LoginButton
  extends FacebookButtonBase
{
  public static final String EVENTLOG_URL = "com.facebook.login.widget.LoginButton";
  public AccessTokenTracker accessTokenTracker;
  public boolean confirmLogout;
  public String loginLogoutEventName = "fb_login_view_usage";
  public LoginManager loginManager;
  public String loginText;
  public String logoutText;
  public LoginButtonProperties properties = new LoginButtonProperties();
  public boolean toolTipChecked;
  public long toolTipDisplayTime = 6000L;
  public ToolTipMode toolTipMode;
  public ToolTipPopup toolTipPopup;
  public ToolTipPopup.Style toolTipStyle = ToolTipPopup.Style.BLUE;
  
  public LoginButton(Context paramContext)
  {
    super(paramContext, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
  }
  
  public LoginButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
  }
  
  public LoginButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0, "fb_login_button_create", "fb_login_button_did_tap");
  }
  
  private void checkToolTipSettings()
  {
    int i = toolTipMode.ordinal();
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      displayToolTip(getResources().getString(R.string.com_facebook_tooltip_default));
      return;
    }
    final String str = Utility.getMetadataApplicationId(getContext());
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public void run()
      {
        final Utility.FetchedAppSettings localFetchedAppSettings = Utility.queryAppSettings(str, false);
        LoginButton.access$100(LoginButton.this).runOnUiThread(new Runnable()
        {
          public void run()
          {
            LoginButton.access$000(LoginButton.this, localFetchedAppSettings);
          }
        });
      }
    });
  }
  
  private void displayToolTip(String paramString)
  {
    toolTipPopup = new ToolTipPopup(paramString, this);
    toolTipPopup.setStyle(toolTipStyle);
    toolTipPopup.setNuxDisplayTime(toolTipDisplayTime);
    toolTipPopup.show();
  }
  
  private int measureButtonWidth(String paramString)
  {
    int i = measureTextWidth(paramString);
    int j = getCompoundPaddingLeft();
    int k = getCompoundDrawablePadding();
    return getCompoundPaddingRight() + (k + j + i);
  }
  
  private void parseLoginButtonAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    toolTipMode = ToolTipMode.DEFAULT;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_login_view, paramInt1, paramInt2);
    try
    {
      confirmLogout = paramContext.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
      loginText = paramContext.getString(R.styleable.com_facebook_login_view_com_facebook_login_text);
      logoutText = paramContext.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text);
      toolTipMode = ToolTipMode.fromInt(paramContext.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.DEFAULT.getValue()));
      paramContext.recycle();
      return;
    }
    catch (Throwable paramAttributeSet)
    {
      paramContext.recycle();
      throw paramAttributeSet;
    }
  }
  
  private void setButtonText()
  {
    Resources localResources = getResources();
    if ((!isInEditMode()) && (AccessToken.getCurrentAccessToken() != null))
    {
      localObject1 = logoutText;
      if (localObject1 == null) {
        localObject1 = localResources.getString(R.string.com_facebook_loginview_log_out_button);
      }
      setText((CharSequence)localObject1);
      return;
    }
    Object localObject1 = loginText;
    if (localObject1 != null)
    {
      setText((CharSequence)localObject1);
      return;
    }
    String str = localResources.getString(R.string.com_facebook_loginview_log_in_button_long);
    localObject1 = str;
    int i = getWidth();
    Object localObject2 = localObject1;
    if (i != 0)
    {
      localObject2 = localObject1;
      if (measureButtonWidth(str) > i) {
        localObject2 = localResources.getString(R.string.com_facebook_loginview_log_in_button);
      }
    }
    setText((CharSequence)localObject2);
  }
  
  private void showToolTipPerSettings(Utility.FetchedAppSettings paramFetchedAppSettings)
  {
    if ((paramFetchedAppSettings != null) && (paramFetchedAppSettings.getNuxEnabled()) && (getVisibility() == 0)) {
      displayToolTip(paramFetchedAppSettings.getNuxContent());
    }
  }
  
  public void clearPermissions()
  {
    properties.clearPermissions();
  }
  
  public void configureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super.configureButton(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setInternalOnClickListener(new LoginClickListener(null));
    parseLoginButtonAttributes(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (isInEditMode())
    {
      setBackgroundColor(getResources().getColor(R.color.com_facebook_blue));
      loginText = "Log in with Facebook";
    }
    else
    {
      accessTokenTracker = new AccessTokenTracker()
      {
        public void onCurrentAccessTokenChanged(AccessToken paramAnonymousAccessToken1, AccessToken paramAnonymousAccessToken2)
        {
          LoginButton.access$300(LoginButton.this);
        }
      };
    }
    setButtonText();
  }
  
  public void dismissToolTip()
  {
    ToolTipPopup localToolTipPopup = toolTipPopup;
    if (localToolTipPopup != null)
    {
      localToolTipPopup.dismiss();
      toolTipPopup = null;
    }
  }
  
  public DefaultAudience getDefaultAudience()
  {
    return properties.getDefaultAudience();
  }
  
  public int getDefaultRequestCode()
  {
    return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
  }
  
  public int getDefaultStyleResource()
  {
    return R.style.com_facebook_loginview_default_style;
  }
  
  public LoginBehavior getLoginBehavior()
  {
    return properties.getLoginBehavior();
  }
  
  public LoginManager getLoginManager()
  {
    if (loginManager == null) {
      loginManager = LoginManager.getInstance();
    }
    return loginManager;
  }
  
  public List getPermissions()
  {
    return properties.getPermissions();
  }
  
  public long getToolTipDisplayTime()
  {
    return toolTipDisplayTime;
  }
  
  public ToolTipMode getToolTipMode()
  {
    return toolTipMode;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    AccessTokenTracker localAccessTokenTracker = accessTokenTracker;
    if ((localAccessTokenTracker != null) && (!localAccessTokenTracker.isTracking()))
    {
      accessTokenTracker.startTracking();
      setButtonText();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AccessTokenTracker localAccessTokenTracker = accessTokenTracker;
    if (localAccessTokenTracker != null) {
      localAccessTokenTracker.stopTracking();
    }
    dismissToolTip();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!toolTipChecked) && (!isInEditMode()))
    {
      toolTipChecked = true;
      checkToolTipSettings();
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    setButtonText();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = getPaint().getFontMetrics();
    paramInt2 = getCompoundPaddingTop();
    float f = Math.abs(top);
    int i = (int)Math.ceil(Math.abs(bottom) + f);
    int j = getCompoundPaddingBottom();
    Resources localResources = getResources();
    String str = loginText;
    localObject = str;
    if (str == null)
    {
      str = localResources.getString(R.string.com_facebook_loginview_log_in_button_long);
      localObject = str;
      k = measureButtonWidth(str);
      if (View.resolveSize(k, paramInt1) < k) {
        localObject = localResources.getString(R.string.com_facebook_loginview_log_in_button);
      }
    }
    int k = measureButtonWidth((String)localObject);
    str = logoutText;
    localObject = str;
    if (str == null) {
      localObject = localResources.getString(R.string.com_facebook_loginview_log_out_button);
    }
    setMeasuredDimension(View.resolveSize(Math.max(k, measureButtonWidth((String)localObject)), paramInt1), j + (paramInt2 + i));
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      dismissToolTip();
    }
  }
  
  public void registerCallback(CallbackManager paramCallbackManager, FacebookCallback paramFacebookCallback)
  {
    getLoginManager().registerCallback(paramCallbackManager, paramFacebookCallback);
  }
  
  public void setDefaultAudience(DefaultAudience paramDefaultAudience)
  {
    properties.setDefaultAudience(paramDefaultAudience);
  }
  
  public void setLoginBehavior(LoginBehavior paramLoginBehavior)
  {
    properties.setLoginBehavior(paramLoginBehavior);
  }
  
  public void setLoginManager(LoginManager paramLoginManager)
  {
    loginManager = paramLoginManager;
  }
  
  public void setProperties(LoginButtonProperties paramLoginButtonProperties)
  {
    properties = paramLoginButtonProperties;
  }
  
  public void setPublishPermissions(List paramList)
  {
    properties.setPublishPermissions(paramList);
  }
  
  public void setPublishPermissions(String... paramVarArgs)
  {
    properties.setPublishPermissions(Arrays.asList(paramVarArgs));
  }
  
  public void setReadPermissions(List paramList)
  {
    properties.setReadPermissions(paramList);
  }
  
  public void setReadPermissions(String... paramVarArgs)
  {
    properties.setReadPermissions(Arrays.asList(paramVarArgs));
  }
  
  public void setToolTipDisplayTime(long paramLong)
  {
    toolTipDisplayTime = paramLong;
  }
  
  public void setToolTipMode(ToolTipMode paramToolTipMode)
  {
    toolTipMode = paramToolTipMode;
  }
  
  public void setToolTipStyle(ToolTipPopup.Style paramStyle)
  {
    toolTipStyle = paramStyle;
  }
  
  public static class LoginButtonProperties
  {
    public LoginAuthorizationType authorizationType = null;
    public DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    public LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    public List<String> permissions = Collections.emptyList();
    
    public LoginButtonProperties() {}
    
    public void clearPermissions()
    {
      permissions = null;
      authorizationType = null;
    }
    
    public DefaultAudience getDefaultAudience()
    {
      return defaultAudience;
    }
    
    public LoginBehavior getLoginBehavior()
    {
      return loginBehavior;
    }
    
    public List getPermissions()
    {
      return permissions;
    }
    
    public void setDefaultAudience(DefaultAudience paramDefaultAudience)
    {
      defaultAudience = paramDefaultAudience;
    }
    
    public void setLoginBehavior(LoginBehavior paramLoginBehavior)
    {
      loginBehavior = paramLoginBehavior;
    }
    
    public void setPublishPermissions(List paramList)
    {
      if (!LoginAuthorizationType.READ.equals(authorizationType))
      {
        if (!Utility.isNullOrEmpty(paramList))
        {
          permissions = paramList;
          authorizationType = LoginAuthorizationType.PUBLISH;
          return;
        }
        throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
      }
      throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
    }
    
    public void setReadPermissions(List paramList)
    {
      if (!LoginAuthorizationType.PUBLISH.equals(authorizationType))
      {
        permissions = paramList;
        authorizationType = LoginAuthorizationType.READ;
        return;
      }
      throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
    }
  }
  
  private class LoginClickListener
    implements View.OnClickListener
  {
    public LoginClickListener() {}
    
    public void onClick(View paramView)
    {
      LoginButton.access$400(LoginButton.this, paramView);
      Object localObject2 = getContext();
      AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
      int i = 0;
      if (localAccessToken != null)
      {
        if (LoginButton.access$500(LoginButton.this))
        {
          localObject1 = getResources().getString(R.string.com_facebook_loginview_log_out_action);
          String str = getResources().getString(R.string.com_facebook_loginview_cancel_action);
          paramView = Profile.getCurrentProfile();
          if ((paramView != null) && (paramView.getName() != null)) {
            paramView = String.format(getResources().getString(R.string.com_facebook_loginview_logged_in_as), new Object[] { paramView.getName() });
          } else {
            paramView = getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
          }
          localObject2 = new AlertDialog.Builder((Context)localObject2);
          ((AlertDialog.Builder)localObject2).setMessage(paramView).setCancelable(true).setPositiveButton((CharSequence)localObject1, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              getLoginManager().logOut();
            }
          }).setNegativeButton(str, null);
          ((AlertDialog.Builder)localObject2).create().show();
        }
        else
        {
          getLoginManager().logOut();
        }
      }
      else
      {
        paramView = getLoginManager();
        paramView.setDefaultAudience(getDefaultAudience());
        paramView.setLoginBehavior(getLoginBehavior());
        if (LoginAuthorizationType.PUBLISH.equals(access$600authorizationType))
        {
          if (getFragment() != null) {
            paramView.logInWithPublishPermissions(getFragment(), access$600permissions);
          } else {
            paramView.logInWithPublishPermissions(LoginButton.access$900(LoginButton.this), access$600permissions);
          }
        }
        else if (getFragment() != null) {
          paramView.logInWithReadPermissions(getFragment(), access$600permissions);
        } else {
          paramView.logInWithReadPermissions(LoginButton.access$1000(LoginButton.this), access$600permissions);
        }
      }
      paramView = AppEventsLogger.newLogger(getContext());
      Object localObject1 = new Bundle();
      if (localAccessToken == null) {
        i = 1;
      }
      ((Bundle)localObject1).putInt("logging_in", i);
      paramView.logSdkEvent(LoginButton.access$1100(LoginButton.this), null, (Bundle)localObject1);
    }
  }
  
  public static enum ToolTipMode
  {
    public static ToolTipMode DEFAULT;
    public int intValue;
    public String stringValue;
    
    static
    {
      ToolTipMode localToolTipMode = AUTOMATIC;
      $VALUES = new ToolTipMode[] { localToolTipMode, DISPLAY_ALWAYS, NEVER_DISPLAY };
      DEFAULT = localToolTipMode;
    }
    
    public ToolTipMode(String paramString, int paramInt)
    {
      stringValue = paramString;
      intValue = paramInt;
    }
    
    public static ToolTipMode fromInt(int paramInt)
    {
      ToolTipMode[] arrayOfToolTipMode = values();
      int j = arrayOfToolTipMode.length;
      int i = 0;
      while (i < j)
      {
        ToolTipMode localToolTipMode = arrayOfToolTipMode[i];
        if (localToolTipMode.getValue() == paramInt) {
          return localToolTipMode;
        }
        i += 1;
      }
      return null;
    }
    
    public int getValue()
    {
      return intValue;
    }
    
    public String toString()
    {
      return stringValue;
    }
  }
}
