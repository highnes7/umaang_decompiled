package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum OpenGraphActionDialogFeature
  implements DialogFeature
{
  OG_ACTION_DIALOG(20130618);
  
  public int minVersion;
  
  public OpenGraphActionDialogFeature(int paramInt)
  {
    minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
  }
  
  public int getMinVersion()
  {
    return minVersion;
  }
}
