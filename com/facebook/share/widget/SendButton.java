package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import com.facebook.R.style;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FacebookDialogBase;

public final class SendButton
  extends ShareButtonBase
{
  public SendButton(Context paramContext)
  {
    super(paramContext, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
  }
  
  public SendButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0, "fb_send_button_create", "fb_send_button_did_tap");
  }
  
  public SendButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, "fb_send_button_create", "fb_send_button_did_tap");
  }
  
  public int getDefaultRequestCode()
  {
    return CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
  }
  
  public int getDefaultStyleResource()
  {
    return R.style.com_facebook_button_send;
  }
  
  public FacebookDialogBase getDialog()
  {
    if (getFragment() != null) {
      return new MessageDialog(getFragment(), getRequestCode());
    }
    return new MessageDialog(getActivity(), getRequestCode());
  }
}
