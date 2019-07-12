package android.support.v4.media;

import android.media.Rating;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import b.b.a.N;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import support.android.v4.asm.DownloadProgressInfo.1;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new DownloadProgressInfo.1();
  public static final int RATING_3_STARS = 3;
  public static final int RATING_4_STARS = 4;
  public static final int RATING_5_STARS = 5;
  public static final int RATING_HEART = 1;
  public static final int RATING_NONE = 0;
  public static final float RATING_NOT_RATED = -1.0F;
  public static final int RATING_PERCENTAGE = 6;
  public static final int RATING_THUMB_UP_DOWN = 2;
  public static final String TAG = "Rating";
  public Object mRatingObj;
  public final int mRatingStyle;
  public final float mRatingValue;
  
  public RatingCompat(int paramInt, float paramFloat)
  {
    mRatingStyle = paramInt;
    mRatingValue = paramFloat;
  }
  
  public static RatingCompat fromRating(Object paramObject)
  {
    if (paramObject != null)
    {
      int i = Build.VERSION.SDK_INT;
      Object localObject = (Rating)paramObject;
      i = ((Rating)localObject).getRatingStyle();
      if (((Rating)localObject).isRated()) {
        switch (i)
        {
        default: 
          return null;
        case 6: 
          localObject = newPercentageRating(((Rating)localObject).getPercentRating());
          break;
        case 3: 
        case 4: 
        case 5: 
          localObject = newStarRating(i, ((Rating)localObject).getStarRating());
          break;
        case 2: 
          localObject = newThumbRating(((Rating)localObject).isThumbUp());
          break;
        case 1: 
          localObject = newHeartRating(((Rating)localObject).hasHeart());
          break;
        }
      } else {
        localObject = newUnratedRating(i);
      }
      mRatingObj = paramObject;
      return localObject;
    }
    return null;
  }
  
  public static RatingCompat newHeartRating(boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    return new RatingCompat(1, f);
  }
  
  public static RatingCompat newPercentageRating(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 100.0F)) {
      return new RatingCompat(6, paramFloat);
    }
    return null;
  }
  
  public static RatingCompat newStarRating(int paramInt, float paramFloat)
  {
    float f;
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid rating style (");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(") for a star rating");
          localStringBuilder.toString();
          return null;
        }
        f = 5.0F;
      }
      else
      {
        f = 4.0F;
      }
    }
    else {
      f = 3.0F;
    }
    if (paramFloat >= 0.0F)
    {
      if (paramFloat > f) {
        return null;
      }
      return new RatingCompat(paramInt, paramFloat);
    }
    return null;
  }
  
  public static RatingCompat newThumbRating(boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    return new RatingCompat(2, f);
  }
  
  public static RatingCompat newUnratedRating(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new RatingCompat(paramInt, -1.0F);
  }
  
  public int describeContents()
  {
    return mRatingStyle;
  }
  
  public float getPercentRating()
  {
    if ((mRatingStyle == 6) && (isRated())) {
      return mRatingValue;
    }
    return -1.0F;
  }
  
  public Object getRating()
  {
    if (mRatingObj == null)
    {
      int i = Build.VERSION.SDK_INT;
      if (isRated())
      {
        i = mRatingStyle;
        switch (i)
        {
        default: 
          return null;
        case 6: 
          mRatingObj = Rating.newPercentageRating(getPercentRating());
          break;
        case 3: 
        case 4: 
        case 5: 
          mRatingObj = Rating.newStarRating(i, getStarRating());
          break;
        case 2: 
          mRatingObj = Rating.newThumbRating(isThumbUp());
          break;
        case 1: 
          mRatingObj = Rating.newHeartRating(hasHeart());
          break;
        }
      }
      else
      {
        mRatingObj = Rating.newUnratedRating(mRatingStyle);
      }
    }
    return mRatingObj;
  }
  
  public int getRatingStyle()
  {
    return mRatingStyle;
  }
  
  public float getStarRating()
  {
    int i = mRatingStyle;
    if (((i == 3) || (i == 4) || (i == 5)) && (isRated())) {
      return mRatingValue;
    }
    return -1.0F;
  }
  
  public boolean hasHeart()
  {
    if (mRatingStyle != 1) {
      return false;
    }
    return mRatingValue == 1.0F;
  }
  
  public boolean isRated()
  {
    return mRatingValue >= 0.0F;
  }
  
  public boolean isThumbUp()
  {
    if (mRatingStyle != 2) {
      return false;
    }
    return mRatingValue == 1.0F;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Rating:style=");
    localStringBuilder.append(mRatingStyle);
    localStringBuilder.append(" rating=");
    float f = mRatingValue;
    String str;
    if (f < 0.0F) {
      str = "unrated";
    } else {
      str = String.valueOf(f);
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(mRatingStyle);
    paramParcel.writeFloat(mRatingValue);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface a {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface b {}
}
