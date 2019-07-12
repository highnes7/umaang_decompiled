package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum OpenGraphMessageDialogFeature
  implements DialogFeature
{
  OG_MESSAGE_DIALOG(20140204);
  
  public int minVersion;
  
  public OpenGraphMessageDialogFeature(int paramInt)
  {
    minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
  }
  
  public int getMinVersion()
  {
    return minVersion;
  }
}
