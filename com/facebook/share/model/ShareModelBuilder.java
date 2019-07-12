package com.facebook.share.model;

import android.os.Parcel;
import com.facebook.share.ShareBuilder;

public abstract interface ShareModelBuilder<P extends ShareModel, E extends ShareModelBuilder>
  extends ShareBuilder<P, E>
{
  public abstract ShareModelBuilder readFrom(Parcel paramParcel);
  
  public abstract ShareModelBuilder readFrom(ShareModel paramShareModel);
}
