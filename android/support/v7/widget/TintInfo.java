package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;

public class TintInfo
{
  public boolean mHasTintList;
  public boolean mHasTintMode;
  public ColorStateList mTintList;
  public PorterDuff.Mode mTintMode;
  
  public TintInfo() {}
  
  public void clear()
  {
    mTintList = null;
    mHasTintList = false;
    mTintMode = null;
    mHasTintMode = false;
  }
}
