package android.support.v7.widget;

public class RtlSpacingHelper
{
  public static final int UNDEFINED = Integer.MIN_VALUE;
  public int mEnd = Integer.MIN_VALUE;
  public int mExplicitLeft = 0;
  public int mExplicitRight = 0;
  public boolean mIsRelative = false;
  public boolean mIsRtl = false;
  public int mLeft = 0;
  public int mRight = 0;
  public int mStart = Integer.MIN_VALUE;
  
  public RtlSpacingHelper() {}
  
  public int getEnd()
  {
    if (mIsRtl) {
      return mLeft;
    }
    return mRight;
  }
  
  public int getLeft()
  {
    return mLeft;
  }
  
  public int getRight()
  {
    return mRight;
  }
  
  public int getStart()
  {
    if (mIsRtl) {
      return mRight;
    }
    return mLeft;
  }
  
  public void setAbsolute(int paramInt1, int paramInt2)
  {
    mIsRelative = false;
    if (paramInt1 != Integer.MIN_VALUE)
    {
      mExplicitLeft = paramInt1;
      mLeft = paramInt1;
    }
    if (paramInt2 != Integer.MIN_VALUE)
    {
      mExplicitRight = paramInt2;
      mRight = paramInt2;
    }
  }
  
  public void setDirection(boolean paramBoolean)
  {
    if (paramBoolean == mIsRtl) {
      return;
    }
    mIsRtl = paramBoolean;
    if (mIsRelative)
    {
      if (paramBoolean)
      {
        i = mEnd;
        if (i == Integer.MIN_VALUE) {
          i = mExplicitLeft;
        }
        mLeft = i;
        i = mStart;
        if (i == Integer.MIN_VALUE) {
          i = mExplicitRight;
        }
        mRight = i;
        return;
      }
      int i = mStart;
      if (i == Integer.MIN_VALUE) {
        i = mExplicitLeft;
      }
      mLeft = i;
      i = mEnd;
      if (i == Integer.MIN_VALUE) {
        i = mExplicitRight;
      }
      mRight = i;
      return;
    }
    mLeft = mExplicitLeft;
    mRight = mExplicitRight;
  }
  
  public void setRelative(int paramInt1, int paramInt2)
  {
    mStart = paramInt1;
    mEnd = paramInt2;
    mIsRelative = true;
    if (mIsRtl)
    {
      if (paramInt2 != Integer.MIN_VALUE) {
        mLeft = paramInt2;
      }
      if (paramInt1 != Integer.MIN_VALUE) {
        mRight = paramInt1;
      }
    }
    else
    {
      if (paramInt1 != Integer.MIN_VALUE) {
        mLeft = paramInt1;
      }
      if (paramInt2 != Integer.MIN_VALUE) {
        mRight = paramInt2;
      }
    }
  }
}
