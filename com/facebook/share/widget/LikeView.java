package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.package_7.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookException;
import com.facebook.R.color;
import com.facebook.R.dimen;
import com.facebook.R.styleable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeActionController.CreationCallback;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeBoxCountView.LikeBoxCountViewCaretPosition;
import com.facebook.share.internal.LikeButton;
import support.android.v4.content.LocalBroadcastManager;

public class LikeView
  extends FrameLayout
{
  public static final int NO_FOREGROUND_COLOR = -1;
  public AuxiliaryViewPosition auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
  public BroadcastReceiver broadcastReceiver;
  public LinearLayout containerView;
  public LikeActionControllerCreationCallback creationCallback;
  public int edgePadding;
  public boolean explicitlyDisabled;
  public int foregroundColor = -1;
  public HorizontalAlignment horizontalAlignment = HorizontalAlignment.DEFAULT;
  public int internalPadding;
  public LikeActionController likeActionController;
  public LikeBoxCountView likeBoxCountView;
  public LikeButton likeButton;
  public Style likeViewStyle = Style.DEFAULT;
  public String objectId;
  public ObjectType objectType;
  public OnErrorListener onErrorListener;
  public Fragment parentFragment;
  public TextView socialSentenceView;
  
  public LikeView(Context paramContext)
  {
    super(paramContext);
    initialize(paramContext);
  }
  
  public LikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    parseAttributes(paramAttributeSet);
    initialize(paramContext);
  }
  
  private void associateWithLikeActionController(LikeActionController paramLikeActionController)
  {
    likeActionController = paramLikeActionController;
    broadcastReceiver = new LikeControllerBroadcastReceiver(null);
    paramLikeActionController = LocalBroadcastManager.getInstance(getContext());
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
    localIntentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
    paramLikeActionController.registerReceiver(broadcastReceiver, localIntentFilter);
  }
  
  private Activity getActivity()
  {
    boolean bool;
    for (Object localObject = getContext();; localObject = ((ContextWrapper)localObject).getBaseContext())
    {
      bool = localObject instanceof Activity;
      if ((bool) || (!(localObject instanceof ContextWrapper))) {
        break;
      }
    }
    if (bool) {
      return (Activity)localObject;
    }
    localObject = new FacebookException("Unable to get Activity.");
    throw ((Throwable)localObject);
  }
  
  private Bundle getAnalyticsParameters()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("style", likeViewStyle.toString());
    localBundle.putString("auxiliary_position", auxiliaryViewPosition.toString());
    localBundle.putString("horizontal_alignment", horizontalAlignment.toString());
    localBundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(objectId, ""));
    localBundle.putString("object_type", objectType.toString());
    return localBundle;
  }
  
  private void initialize(Context paramContext)
  {
    edgePadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
    internalPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
    if (foregroundColor == -1) {
      foregroundColor = getResources().getColor(R.color.com_facebook_likeview_text_color);
    }
    setBackgroundColor(0);
    containerView = new LinearLayout(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    containerView.setLayoutParams(localLayoutParams);
    initializeLikeButton(paramContext);
    initializeSocialSentenceView(paramContext);
    initializeLikeCountView(paramContext);
    containerView.addView(likeButton);
    containerView.addView(socialSentenceView);
    containerView.addView(likeBoxCountView);
    addView(containerView);
    setObjectIdAndTypeForced(objectId, objectType);
    updateLikeStateAndLayout();
  }
  
  private void initializeLikeButton(Context paramContext)
  {
    LikeActionController localLikeActionController = likeActionController;
    boolean bool;
    if ((localLikeActionController != null) && (localLikeActionController.isObjectLiked())) {
      bool = true;
    } else {
      bool = false;
    }
    likeButton = new LikeButton(paramContext, bool);
    likeButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        LikeView.access$300(LikeView.this);
      }
    });
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    likeButton.setLayoutParams(paramContext);
  }
  
  private void initializeLikeCountView(Context paramContext)
  {
    likeBoxCountView = new LikeBoxCountView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    likeBoxCountView.setLayoutParams(paramContext);
  }
  
  private void initializeSocialSentenceView(Context paramContext)
  {
    socialSentenceView = new TextView(paramContext);
    socialSentenceView.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
    socialSentenceView.setMaxLines(2);
    socialSentenceView.setTextColor(foregroundColor);
    socialSentenceView.setGravity(17);
    paramContext = new LinearLayout.LayoutParams(-2, -1);
    socialSentenceView.setLayoutParams(paramContext);
  }
  
  private void parseAttributes(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      if (getContext() == null) {
        return;
      }
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_like_view);
      if (paramAttributeSet == null) {
        return;
      }
      objectId = Utility.coerceValueIfNullOrEmpty(paramAttributeSet.getString(R.styleable.com_facebook_like_view_com_facebook_object_id), null);
      objectType = ObjectType.fromInt(paramAttributeSet.getInt(R.styleable.com_facebook_like_view_com_facebook_object_type, ObjectType.DEFAULT.getValue()));
      likeViewStyle = Style.fromInt(paramAttributeSet.getInt(R.styleable.com_facebook_like_view_com_facebook_style, Style.access$000(Style.DEFAULT)));
      if (likeViewStyle != null)
      {
        auxiliaryViewPosition = AuxiliaryViewPosition.fromInt(paramAttributeSet.getInt(R.styleable.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.access$100(AuxiliaryViewPosition.DEFAULT)));
        if (auxiliaryViewPosition != null)
        {
          horizontalAlignment = HorizontalAlignment.fromInt(paramAttributeSet.getInt(R.styleable.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.access$200(HorizontalAlignment.DEFAULT)));
          if (horizontalAlignment != null)
          {
            foregroundColor = paramAttributeSet.getColor(R.styleable.com_facebook_like_view_com_facebook_foreground_color, -1);
            paramAttributeSet.recycle();
            return;
          }
          throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
        }
        throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
      }
      throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
    }
  }
  
  private void setObjectIdAndTypeForced(String paramString, ObjectType paramObjectType)
  {
    tearDownObjectAssociations();
    objectId = paramString;
    objectType = paramObjectType;
    if (Utility.isNullOrEmpty(paramString)) {
      return;
    }
    creationCallback = new LikeActionControllerCreationCallback(null);
    if (!isInEditMode()) {
      LikeActionController.getControllerForObjectId(paramString, paramObjectType, creationCallback);
    }
  }
  
  private void tearDownObjectAssociations()
  {
    if (broadcastReceiver != null)
    {
      LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);
      broadcastReceiver = null;
    }
    LikeActionControllerCreationCallback localLikeActionControllerCreationCallback = creationCallback;
    if (localLikeActionControllerCreationCallback != null)
    {
      localLikeActionControllerCreationCallback.cancel();
      creationCallback = null;
    }
    likeActionController = null;
  }
  
  private void toggleLike()
  {
    if (likeActionController != null)
    {
      Activity localActivity = null;
      if (parentFragment == null) {
        localActivity = getActivity();
      }
      likeActionController.toggleLike(localActivity, parentFragment, getAnalyticsParameters());
    }
  }
  
  private void updateBoxCountCaretPosition()
  {
    int i = auxiliaryViewPosition.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM);
        return;
      }
      LikeBoxCountView localLikeBoxCountView = likeBoxCountView;
      LikeBoxCountView.LikeBoxCountViewCaretPosition localLikeBoxCountViewCaretPosition;
      if (horizontalAlignment == HorizontalAlignment.RIGHT) {
        localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT;
      } else {
        localLikeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT;
      }
      localLikeBoxCountView.setCaretPosition(localLikeBoxCountViewCaretPosition);
      return;
    }
    likeBoxCountView.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.MIDDLE);
  }
  
  private void updateLayout()
  {
    Object localObject1 = (FrameLayout.LayoutParams)containerView.getLayoutParams();
    Object localObject2 = (LinearLayout.LayoutParams)likeButton.getLayoutParams();
    HorizontalAlignment localHorizontalAlignment = horizontalAlignment;
    int i;
    if (localHorizontalAlignment == HorizontalAlignment.LEFT) {
      i = 3;
    } else if (localHorizontalAlignment == HorizontalAlignment.CENTER) {
      i = 1;
    } else {
      i = 5;
    }
    gravity = (i | 0x30);
    gravity = i;
    socialSentenceView.setVisibility(8);
    likeBoxCountView.setVisibility(8);
    if (likeViewStyle == Style.STANDARD)
    {
      localObject1 = likeActionController;
      if ((localObject1 != null) && (!Utility.isNullOrEmpty(((LikeActionController)localObject1).getSocialSentence())))
      {
        localObject1 = socialSentenceView;
        break label164;
      }
    }
    if (likeViewStyle == Style.BOX_COUNT)
    {
      localObject1 = likeActionController;
      if ((localObject1 != null) && (!Utility.isNullOrEmpty(((LikeActionController)localObject1).getLikeCountString())))
      {
        updateBoxCountCaretPosition();
        localObject1 = likeBoxCountView;
        label164:
        int j = 0;
        ((View)localObject1).setVisibility(0);
        getLayoutParamsgravity = i;
        localObject2 = containerView;
        if (auxiliaryViewPosition == AuxiliaryViewPosition.INLINE) {
          i = j;
        } else {
          i = 1;
        }
        ((LinearLayout)localObject2).setOrientation(i);
        localObject2 = auxiliaryViewPosition;
        if ((localObject2 != AuxiliaryViewPosition.CURSOR) && ((localObject2 != AuxiliaryViewPosition.INLINE) || (horizontalAlignment != HorizontalAlignment.RIGHT)))
        {
          containerView.removeView((View)localObject1);
          containerView.addView((View)localObject1);
        }
        else
        {
          containerView.removeView(likeButton);
          containerView.addView(likeButton);
        }
        i = auxiliaryViewPosition.ordinal();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2) {
              return;
            }
            i = edgePadding;
            ((View)localObject1).setPadding(i, i, i, internalPadding);
            return;
          }
          if (horizontalAlignment == HorizontalAlignment.RIGHT)
          {
            i = edgePadding;
            ((View)localObject1).setPadding(i, i, internalPadding, i);
            return;
          }
          i = internalPadding;
          j = edgePadding;
          ((View)localObject1).setPadding(i, j, j, j);
          return;
        }
        i = edgePadding;
        ((View)localObject1).setPadding(i, internalPadding, i, i);
      }
    }
  }
  
  private void updateLikeStateAndLayout()
  {
    boolean bool = explicitlyDisabled ^ true;
    LikeActionController localLikeActionController = likeActionController;
    if (localLikeActionController == null)
    {
      likeButton.setSelected(false);
      socialSentenceView.setText(null);
      likeBoxCountView.setText(null);
    }
    else
    {
      likeButton.setSelected(localLikeActionController.isObjectLiked());
      socialSentenceView.setText(likeActionController.getSocialSentence());
      likeBoxCountView.setText(likeActionController.getLikeCountString());
      bool &= likeActionController.shouldEnableView();
    }
    super.setEnabled(bool);
    likeButton.setEnabled(bool);
    updateLayout();
  }
  
  public OnErrorListener getOnErrorListener()
  {
    return onErrorListener;
  }
  
  public void onDetachedFromWindow()
  {
    setObjectIdAndType(null, ObjectType.UNKNOWN);
    super.onDetachedFromWindow();
  }
  
  public void setAuxiliaryViewPosition(AuxiliaryViewPosition paramAuxiliaryViewPosition)
  {
    if (paramAuxiliaryViewPosition == null) {
      paramAuxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    }
    if (auxiliaryViewPosition != paramAuxiliaryViewPosition)
    {
      auxiliaryViewPosition = paramAuxiliaryViewPosition;
      updateLayout();
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    explicitlyDisabled = (paramBoolean ^ true);
    updateLikeStateAndLayout();
  }
  
  public void setForegroundColor(int paramInt)
  {
    if (foregroundColor != paramInt) {
      socialSentenceView.setTextColor(paramInt);
    }
  }
  
  public void setFragment(Fragment paramFragment)
  {
    parentFragment = paramFragment;
  }
  
  public void setHorizontalAlignment(HorizontalAlignment paramHorizontalAlignment)
  {
    if (paramHorizontalAlignment == null) {
      paramHorizontalAlignment = HorizontalAlignment.DEFAULT;
    }
    if (horizontalAlignment != paramHorizontalAlignment)
    {
      horizontalAlignment = paramHorizontalAlignment;
      updateLayout();
    }
  }
  
  public void setLikeViewStyle(Style paramStyle)
  {
    if (paramStyle == null) {
      paramStyle = Style.DEFAULT;
    }
    if (likeViewStyle != paramStyle)
    {
      likeViewStyle = paramStyle;
      updateLayout();
    }
  }
  
  public void setObjectIdAndType(String paramString, ObjectType paramObjectType)
  {
    paramString = Utility.coerceValueIfNullOrEmpty(paramString, null);
    if (paramObjectType == null) {
      paramObjectType = ObjectType.DEFAULT;
    }
    if ((!Utility.areObjectsEqual(paramString, objectId)) || (paramObjectType != objectType))
    {
      setObjectIdAndTypeForced(paramString, paramObjectType);
      updateLikeStateAndLayout();
    }
  }
  
  public void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    onErrorListener = paramOnErrorListener;
  }
  
  public static enum AuxiliaryViewPosition
  {
    public static AuxiliaryViewPosition DEFAULT;
    public int intValue;
    public String stringValue;
    
    static
    {
      CURSOR = new AuxiliaryViewPosition("TOP", 2, "top", 2);
      AuxiliaryViewPosition localAuxiliaryViewPosition = BOTTOM;
      $VALUES = new AuxiliaryViewPosition[] { localAuxiliaryViewPosition, INLINE, CURSOR };
      DEFAULT = localAuxiliaryViewPosition;
    }
    
    public AuxiliaryViewPosition(String paramString, int paramInt)
    {
      stringValue = paramString;
      intValue = paramInt;
    }
    
    public static AuxiliaryViewPosition fromInt(int paramInt)
    {
      AuxiliaryViewPosition[] arrayOfAuxiliaryViewPosition = values();
      int j = arrayOfAuxiliaryViewPosition.length;
      int i = 0;
      while (i < j)
      {
        AuxiliaryViewPosition localAuxiliaryViewPosition = arrayOfAuxiliaryViewPosition[i];
        if (intValue == paramInt) {
          return localAuxiliaryViewPosition;
        }
        i += 1;
      }
      return null;
    }
    
    private int getValue()
    {
      return intValue;
    }
    
    public String toString()
    {
      return stringValue;
    }
  }
  
  public static enum HorizontalAlignment
  {
    public static HorizontalAlignment DEFAULT;
    public int intValue;
    public String stringValue;
    
    static
    {
      HorizontalAlignment localHorizontalAlignment = CENTER;
      $VALUES = new HorizontalAlignment[] { localHorizontalAlignment, LEFT, RIGHT };
      DEFAULT = localHorizontalAlignment;
    }
    
    public HorizontalAlignment(String paramString, int paramInt)
    {
      stringValue = paramString;
      intValue = paramInt;
    }
    
    public static HorizontalAlignment fromInt(int paramInt)
    {
      HorizontalAlignment[] arrayOfHorizontalAlignment = values();
      int j = arrayOfHorizontalAlignment.length;
      int i = 0;
      while (i < j)
      {
        HorizontalAlignment localHorizontalAlignment = arrayOfHorizontalAlignment[i];
        if (intValue == paramInt) {
          return localHorizontalAlignment;
        }
        i += 1;
      }
      return null;
    }
    
    private int getValue()
    {
      return intValue;
    }
    
    public String toString()
    {
      return stringValue;
    }
  }
  
  private class LikeActionControllerCreationCallback
    implements LikeActionController.CreationCallback
  {
    public boolean isCancelled;
    
    public LikeActionControllerCreationCallback() {}
    
    public void cancel()
    {
      isCancelled = true;
    }
    
    public void onComplete(LikeActionController paramLikeActionController, FacebookException paramFacebookException)
    {
      if (isCancelled) {
        return;
      }
      FacebookException localFacebookException = paramFacebookException;
      if (paramLikeActionController != null)
      {
        if (!paramLikeActionController.shouldEnableView()) {
          paramFacebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
        }
        LikeView.access$1100(LikeView.this, paramLikeActionController);
        LikeView.access$700(LikeView.this);
        localFacebookException = paramFacebookException;
      }
      if ((localFacebookException != null) && (LikeView.access$800(LikeView.this) != null)) {
        LikeView.access$800(LikeView.this).onError(localFacebookException);
      }
      LikeView.access$1202(LikeView.this, null);
    }
  }
  
  private class LikeControllerBroadcastReceiver
    extends BroadcastReceiver
  {
    public LikeControllerBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      paramIntent = paramIntent.getExtras();
      int j = 1;
      int i = j;
      if (paramIntent != null)
      {
        String str = paramIntent.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
        i = j;
        if (!Utility.isNullOrEmpty(str)) {
          if (Utility.areObjectsEqual(LikeView.access$600(LikeView.this), str)) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      if (i == 0) {
        return;
      }
      if ("com.facebook.sdk.LikeActionController.UPDATED".equals(paramContext))
      {
        LikeView.access$700(LikeView.this);
        return;
      }
      if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(paramContext))
      {
        if (LikeView.access$800(LikeView.this) != null) {
          LikeView.access$800(LikeView.this).onError(NativeProtocol.getExceptionFromErrorData(paramIntent));
        }
      }
      else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(paramContext))
      {
        paramContext = LikeView.this;
        LikeView.access$1000(paramContext, LikeView.access$600(paramContext), LikeView.access$900(LikeView.this));
        LikeView.access$700(LikeView.this);
      }
    }
  }
  
  public static enum ObjectType
  {
    public static ObjectType DEFAULT;
    public int intValue;
    public String stringValue;
    
    static
    {
      OPEN_GRAPH = new ObjectType("OPEN_GRAPH", 1, "open_graph", 1);
      PAGE = new ObjectType("PAGE", 2, "page", 2);
      ObjectType localObjectType = UNKNOWN;
      $VALUES = new ObjectType[] { localObjectType, OPEN_GRAPH, PAGE };
      DEFAULT = localObjectType;
    }
    
    public ObjectType(String paramString, int paramInt)
    {
      stringValue = paramString;
      intValue = paramInt;
    }
    
    public static ObjectType fromInt(int paramInt)
    {
      ObjectType[] arrayOfObjectType = values();
      int j = arrayOfObjectType.length;
      int i = 0;
      while (i < j)
      {
        ObjectType localObjectType = arrayOfObjectType[i];
        if (localObjectType.getValue() == paramInt) {
          return localObjectType;
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
  
  public static abstract interface OnErrorListener
  {
    public abstract void onError(FacebookException paramFacebookException);
  }
  
  public static enum Style
  {
    public static Style DEFAULT;
    public int intValue;
    public String stringValue;
    
    static
    {
      BUTTON = new Style("BUTTON", 1, "button", 1);
      BOX_COUNT = new Style("BOX_COUNT", 2, "box_count", 2);
      Style localStyle = STANDARD;
      $VALUES = new Style[] { localStyle, BUTTON, BOX_COUNT };
      DEFAULT = localStyle;
    }
    
    public Style(String paramString, int paramInt)
    {
      stringValue = paramString;
      intValue = paramInt;
    }
    
    public static Style fromInt(int paramInt)
    {
      Style[] arrayOfStyle = values();
      int j = arrayOfStyle.length;
      int i = 0;
      while (i < j)
      {
        Style localStyle = arrayOfStyle[i];
        if (intValue == paramInt) {
          return localStyle;
        }
        i += 1;
      }
      return null;
    }
    
    private int getValue()
    {
      return intValue;
    }
    
    public String toString()
    {
      return stringValue;
    }
  }
}
