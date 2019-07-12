package com.facebook.login.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.R.dimen;
import com.facebook.R.drawable;
import com.facebook.R.styleable;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;

public class ProfilePictureView
  extends FrameLayout
{
  public static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
  public static final String BITMAP_KEY = "ProfilePictureView_bitmap";
  public static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
  public static final int CUSTOM = -1;
  public static final boolean IS_CROPPED_DEFAULT_VALUE = true;
  public static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
  public static final int LARGE = -4;
  public static final String LOG_TAG = "ProfilePictureView";
  public static final int MIN_SIZE = 1;
  public static final int NORMAL = -3;
  public static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
  public static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
  public static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
  public static final int SMALL = -2;
  public static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
  public Bitmap customizedDefaultProfilePicture = null;
  public ImageView image;
  public Bitmap imageContents;
  public boolean isCropped = true;
  public ImageRequest lastRequest;
  public OnErrorListener onErrorListener;
  public int presetSizeType = -1;
  public String profileId;
  public int queryHeight = 0;
  public int queryWidth = 0;
  
  public ProfilePictureView(Context paramContext)
  {
    super(paramContext);
    initialize(paramContext);
  }
  
  public ProfilePictureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialize(paramContext);
    parseAttributes(paramAttributeSet);
  }
  
  public ProfilePictureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialize(paramContext);
    parseAttributes(paramAttributeSet);
  }
  
  private int getPresetSizeInPixels(boolean paramBoolean)
  {
    int i = presetSizeType;
    if (i != -4)
    {
      if (i != -3)
      {
        if (i != -2)
        {
          if (i != -1) {
            return 0;
          }
          if (!paramBoolean) {
            return 0;
          }
          i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
        }
        else
        {
          i = R.dimen.com_facebook_profilepictureview_preset_size_small;
        }
      }
      else {
        i = R.dimen.com_facebook_profilepictureview_preset_size_normal;
      }
    }
    else {
      i = R.dimen.com_facebook_profilepictureview_preset_size_large;
    }
    return getResources().getDimensionPixelSize(i);
  }
  
  private void initialize(Context paramContext)
  {
    removeAllViews();
    image = new ImageView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    image.setLayoutParams(paramContext);
    image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView(image);
  }
  
  private void parseAttributes(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_profile_picture_view);
    setPresetSize(paramAttributeSet.getInt(R.styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
    isCropped = paramAttributeSet.getBoolean(R.styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true);
    paramAttributeSet.recycle();
  }
  
  private void processResponse(ImageResponse paramImageResponse)
  {
    if (paramImageResponse.getRequest() == lastRequest)
    {
      lastRequest = null;
      Object localObject2 = paramImageResponse.getBitmap();
      Object localObject1 = paramImageResponse.getError();
      if (localObject1 != null)
      {
        paramImageResponse = onErrorListener;
        if (paramImageResponse != null)
        {
          localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Error in downloading profile picture for profileId: ");
          ((StringBuilder)localObject2).append(getProfileId());
          paramImageResponse.onError(new FacebookException(((StringBuilder)localObject2).toString(), (Throwable)localObject1));
          return;
        }
        Logger.e(LoggingBehavior.REQUESTS, 6, LOG_TAG, ((Exception)localObject1).toString());
        return;
      }
      if (localObject2 != null)
      {
        localObject1 = image;
        if (localObject1 != null)
        {
          imageContents = ((Bitmap)localObject2);
          ((ImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        }
        if (paramImageResponse.isCachedRedirect()) {
          sendImageRequest(false);
        }
      }
    }
  }
  
  private void refreshImage(boolean paramBoolean)
  {
    boolean bool = updateImageQueryParameters();
    String str = profileId;
    if ((str != null) && (str.length() != 0) && ((queryWidth != 0) || (queryHeight != 0)))
    {
      if ((bool) || (paramBoolean)) {
        sendImageRequest(true);
      }
    }
    else {
      setBlankProfilePicture();
    }
  }
  
  private void sendImageRequest(boolean paramBoolean)
  {
    ImageRequest localImageRequest1 = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUri(profileId, queryWidth, queryHeight)).setAllowCachedRedirects(paramBoolean).setCallerTag(this).setCallback(new ImageRequest.Callback()
    {
      public void onCompleted(ImageResponse paramAnonymousImageResponse)
      {
        ProfilePictureView.access$000(ProfilePictureView.this, paramAnonymousImageResponse);
      }
    }).build();
    ImageRequest localImageRequest2 = lastRequest;
    if (localImageRequest2 != null) {
      ImageDownloader.cancelRequest(localImageRequest2);
    }
    lastRequest = localImageRequest1;
    ImageDownloader.downloadAsync(localImageRequest1);
  }
  
  private void setBlankProfilePicture()
  {
    ImageRequest localImageRequest = lastRequest;
    if (localImageRequest != null) {
      ImageDownloader.cancelRequest(localImageRequest);
    }
    if (customizedDefaultProfilePicture == null)
    {
      int i;
      if (isCropped()) {
        i = R.drawable.com_facebook_profile_picture_blank_square;
      } else {
        i = R.drawable.com_facebook_profile_picture_blank_portrait;
      }
      setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
      return;
    }
    updateImageQueryParameters();
    setImageBitmap(Bitmap.createScaledBitmap(customizedDefaultProfilePicture, queryWidth, queryHeight, false));
  }
  
  private void setImageBitmap(Bitmap paramBitmap)
  {
    ImageView localImageView = image;
    if ((localImageView != null) && (paramBitmap != null))
    {
      imageContents = paramBitmap;
      localImageView.setImageBitmap(paramBitmap);
    }
  }
  
  private boolean updateImageQueryParameters()
  {
    int k = getHeight();
    int i = k;
    int m = getWidth();
    int j = m;
    boolean bool2 = true;
    if (m >= 1)
    {
      if (k < 1) {
        return false;
      }
      k = getPresetSizeInPixels(false);
      if (k != 0)
      {
        i = k;
        j = k;
      }
      if (j <= i)
      {
        if (isCropped()) {
          i = j;
        } else {
          i = 0;
        }
      }
      else if (isCropped()) {
        j = i;
      } else {
        j = 0;
      }
      boolean bool1 = bool2;
      if (j == queryWidth) {
        if (i != queryHeight) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      queryWidth = j;
      queryHeight = i;
      return bool1;
    }
    return false;
  }
  
  public final OnErrorListener getOnErrorListener()
  {
    return onErrorListener;
  }
  
  public final int getPresetSize()
  {
    return presetSizeType;
  }
  
  public final String getProfileId()
  {
    return profileId;
  }
  
  public final boolean isCropped()
  {
    return isCropped;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    lastRequest = null;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    refreshImage(false);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    int i = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int j;
    if ((View.MeasureSpec.getMode(paramInt2) != 1073741824) && (height == -2))
    {
      paramInt2 = getPresetSizeInPixels(true);
      i = paramInt2;
      j = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      paramInt2 = 1;
    }
    else
    {
      k = 0;
      j = paramInt2;
      paramInt2 = k;
    }
    int n = i1;
    int m = paramInt2;
    int k = paramInt1;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824)
    {
      n = i1;
      m = paramInt2;
      k = paramInt1;
      if (width == -2)
      {
        paramInt2 = getPresetSizeInPixels(true);
        paramInt1 = paramInt2;
        k = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        m = 1;
        n = paramInt1;
      }
    }
    if (m != 0)
    {
      setMeasuredDimension(n, i);
      measureChildren(k, j);
      return;
    }
    super.onMeasure(k, j);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (paramParcelable.getClass() != Bundle.class)
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (Bundle)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getParcelable("ProfilePictureView_superState"));
    profileId = paramParcelable.getString("ProfilePictureView_profileId");
    presetSizeType = paramParcelable.getInt("ProfilePictureView_presetSize");
    isCropped = paramParcelable.getBoolean("ProfilePictureView_isCropped");
    queryWidth = paramParcelable.getInt("ProfilePictureView_width");
    queryHeight = paramParcelable.getInt("ProfilePictureView_height");
    setImageBitmap((Bitmap)paramParcelable.getParcelable("ProfilePictureView_bitmap"));
    if (paramParcelable.getBoolean("ProfilePictureView_refresh")) {
      refreshImage(true);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ProfilePictureView_superState", localParcelable);
    localBundle.putString("ProfilePictureView_profileId", profileId);
    localBundle.putInt("ProfilePictureView_presetSize", presetSizeType);
    localBundle.putBoolean("ProfilePictureView_isCropped", isCropped);
    localBundle.putParcelable("ProfilePictureView_bitmap", imageContents);
    localBundle.putInt("ProfilePictureView_width", queryWidth);
    localBundle.putInt("ProfilePictureView_height", queryHeight);
    boolean bool;
    if (lastRequest != null) {
      bool = true;
    } else {
      bool = false;
    }
    localBundle.putBoolean("ProfilePictureView_refresh", bool);
    return localBundle;
  }
  
  public final void setCropped(boolean paramBoolean)
  {
    isCropped = paramBoolean;
    refreshImage(false);
  }
  
  public final void setDefaultProfilePicture(Bitmap paramBitmap)
  {
    customizedDefaultProfilePicture = paramBitmap;
  }
  
  public final void setOnErrorListener(OnErrorListener paramOnErrorListener)
  {
    onErrorListener = paramOnErrorListener;
  }
  
  public final void setPresetSize(int paramInt)
  {
    if ((paramInt != -4) && (paramInt != -3) && (paramInt != -2) && (paramInt != -1)) {
      throw new IllegalArgumentException("Must use a predefined preset size");
    }
    presetSizeType = paramInt;
    requestLayout();
  }
  
  public final void setProfileId(String paramString)
  {
    boolean bool;
    if ((!Utility.isNullOrEmpty(profileId)) && (profileId.equalsIgnoreCase(paramString)))
    {
      bool = false;
    }
    else
    {
      setBlankProfilePicture();
      bool = true;
    }
    profileId = paramString;
    refreshImage(bool);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract void onError(FacebookException paramFacebookException);
  }
}
