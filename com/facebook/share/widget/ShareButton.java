package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.facebook.R.style;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;

public final class ShareButton
  extends ShareButtonBase
{
  public ShareButton(Context paramContext)
  {
    super(paramContext, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
  }
  
  public ShareButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0, "fb_share_button_create", "fb_share_button_did_tap");
  }
  
  public ShareButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, "fb_share_button_create", "fb_share_button_did_tap");
  }
  
  public int getDefaultRequestCode()
  {
    return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
  }
  
  public int getDefaultStyleResource()
  {
    return R.style.com_facebook_button_share;
  }
  
  public FacebookDialogBase getDialog()
  {
    if (getFragment() != null) {
      return new ShareDialog(getFragment(), getRequestCode());
    }
    return new ShareDialog(getActivity(), getRequestCode());
  }
}
