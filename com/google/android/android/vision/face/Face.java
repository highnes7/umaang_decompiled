package com.google.android.android.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

public class Face
{
  public static final float UNCOMPUTED_PROBABILITY = -1.0F;
  public int mUserId;
  public float zziiv;
  public float zziiw;
  public PointF zzkim;
  public float zzkin;
  public float zzkio;
  public List<com.google.android.gms.vision.face.Landmark> zzkip;
  public float zzkiq;
  public float zzkir;
  public float zzkis;
  
  public Face(int paramInt, PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Landmark[] paramArrayOfLandmark, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    mUserId = paramInt;
    zzkim = paramPointF;
    zziiv = paramFloat1;
    zziiw = paramFloat2;
    zzkin = paramFloat3;
    zzkio = paramFloat4;
    zzkip = Arrays.asList(paramArrayOfLandmark);
    if ((paramFloat5 >= 0.0F) && (paramFloat5 <= 1.0F)) {
      zzkiq = paramFloat5;
    } else {
      zzkiq = -1.0F;
    }
    if ((paramFloat6 >= 0.0F) && (paramFloat6 <= 1.0F)) {
      zzkir = paramFloat6;
    } else {
      zzkir = -1.0F;
    }
    if ((paramFloat7 >= 0.0F) && (paramFloat7 <= 1.0F))
    {
      zzkis = paramFloat7;
      return;
    }
    zzkis = -1.0F;
  }
  
  public float getEulerY()
  {
    return zzkin;
  }
  
  public float getEulerZ()
  {
    return zzkio;
  }
  
  public float getHeight()
  {
    return zziiw;
  }
  
  public int getId()
  {
    return mUserId;
  }
  
  public float getIsLeftEyeOpenProbability()
  {
    return zzkiq;
  }
  
  public float getIsRightEyeOpenProbability()
  {
    return zzkir;
  }
  
  public float getIsSmilingProbability()
  {
    return zzkis;
  }
  
  public List getLandmarks()
  {
    return zzkip;
  }
  
  public PointF getPosition()
  {
    PointF localPointF = zzkim;
    return new PointF(x - zziiv / 2.0F, y - zziiw / 2.0F);
  }
  
  public float getWidth()
  {
    return zziiv;
  }
}
