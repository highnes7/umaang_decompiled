package support.android.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import b.b.a.K;
import b.b.m.a.n.d;
import b.b.x.n.b;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.v4.content.asm.Attribute;
import support.android.v4.content.asm.Config;
import support.android.v4.content.asm.TypedArrayUtils;
import support.android.v4.internal.PathParser;
import support.android.v4.internal.PathParser.PathDataNode;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public class VectorDrawableCompat
  extends VectorDrawableCommon
{
  public static final boolean DBG_VECTOR_DRAWABLE = false;
  public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  public static final int LINECAP_BUTT = 0;
  public static final int LINECAP_ROUND = 1;
  public static final int LINECAP_SQUARE = 2;
  public static final int LINEJOIN_BEVEL = 2;
  public static final int LINEJOIN_MITER = 0;
  public static final int LINEJOIN_ROUND = 1;
  public static final String LOGTAG = "VectorDrawableCompat";
  public static final int MAX_CACHED_BITMAP_SIZE = 2048;
  public static final String SHAPE_CLIP_PATH = "clip-path";
  public static final String SHAPE_GROUP = "group";
  public static final String SHAPE_PATH = "path";
  public static final String SHAPE_VECTOR = "vector";
  public boolean mAllowCaching = true;
  public Drawable.ConstantState mCachedConstantStateDelegate;
  public ColorFilter mColorFilter;
  public boolean mMutated;
  public PorterDuffColorFilter mTintFilter;
  public final Rect mTmpBounds = new Rect();
  public final float[] mTmpFloats = new float[9];
  public final Matrix mTmpMatrix = new Matrix();
  public VectorDrawableCompatState mVectorState;
  
  public VectorDrawableCompat()
  {
    mVectorState = new VectorDrawableCompatState();
  }
  
  public VectorDrawableCompat(VectorDrawableCompatState paramVectorDrawableCompatState)
  {
    mVectorState = paramVectorDrawableCompatState;
    mTintFilter = updateTintFilter(mTintFilter, mTint, mTintMode);
  }
  
  public static int access$getAlpha(int paramInt, float paramFloat)
  {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  public static VectorDrawableCompat create(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new VectorDrawableCompat();
      mDelegateDrawable = Config.getDrawable(paramResources, paramInt, paramTheme);
      mCachedConstantStateDelegate = new VectorDrawableDelegateState(mDelegateDrawable.getConstantState());
      return localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2)
      {
        paramResources = createFromXmlInner(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
        return paramResources;
      }
      paramResources = new XmlPullParserException("No start tag found");
      throw paramResources;
    }
    catch (XmlPullParserException paramResources)
    {
      for (;;) {}
    }
    catch (IOException paramResources)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static VectorDrawableCompat createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
    localVectorDrawableCompat.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localVectorDrawableCompat;
  }
  
  private boolean draw()
  {
    int i = Build.VERSION.SDK_INT;
    return (isAutoMirrored()) && (DrawableCompat.getLayoutDirection(this) == 1);
  }
  
  private void inflateInternal(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    VectorDrawableCompatState localVectorDrawableCompatState = mVectorState;
    VPathRenderer localVPathRenderer = mVPathRenderer;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(mRootGroup);
    int k = paramXmlPullParser.getEventType();
    int m = paramXmlPullParser.getDepth();
    int j;
    for (int i = 1; (k != 1) && ((paramXmlPullParser.getDepth() >= m + 1) || (k != 3)); i = j)
    {
      if (k == 2)
      {
        Object localObject = paramXmlPullParser.getName();
        VGroup localVGroup = (VGroup)localArrayDeque.peek();
        if ("path".equals(localObject))
        {
          localObject = new VFullPath();
          ((VFullPath)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          mChildren.add(localObject);
          if (((VPath)localObject).getPathName() != null) {
            mVGTargetsMap.put(((VPath)localObject).getPathName(), localObject);
          }
          j = 0;
          i = mChangingConfigurations;
          mChangingConfigurations = (mChangingConfigurations | i);
        }
        else if ("clip-path".equals(localObject))
        {
          localObject = new VClipPath();
          ((VClipPath)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          mChildren.add(localObject);
          if (((VPath)localObject).getPathName() != null) {
            mVGTargetsMap.put(((VPath)localObject).getPathName(), localObject);
          }
          j = mChangingConfigurations;
          mChangingConfigurations = (mChangingConfigurations | j);
          j = i;
        }
        else
        {
          j = i;
          if ("group".equals(localObject))
          {
            localObject = new VGroup();
            ((VGroup)localObject).inflate(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
            mChildren.add(localObject);
            localArrayDeque.push(localObject);
            if (((VGroup)localObject).getGroupName() != null) {
              mVGTargetsMap.put(((VGroup)localObject).getGroupName(), localObject);
            }
            j = mChangingConfigurations;
            mChangingConfigurations = (mChangingConfigurations | j);
            j = i;
          }
        }
      }
      else
      {
        j = i;
        if (k == 3)
        {
          j = i;
          if ("group".equals(paramXmlPullParser.getName()))
          {
            localArrayDeque.pop();
            j = i;
          }
        }
      }
      k = paramXmlPullParser.next();
    }
    if (i == 0) {
      return;
    }
    paramResources = new XmlPullParserException("no path defined");
    throw paramResources;
  }
  
  public static PorterDuff.Mode parseTintModeCompat(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  private void printGroupTree(VGroup paramVGroup, int paramInt)
  {
    int j = 0;
    Object localObject = "";
    int i = 0;
    while (i < paramInt)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, "    ");
      i += 1;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject, "current group is :");
    localStringBuilder.append(paramVGroup.getGroupName());
    localStringBuilder.append(" rotation is ");
    localStringBuilder.append(mRotate);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("matrix is :");
    localStringBuilder.append(paramVGroup.getLocalMatrix().toString());
    localStringBuilder.toString();
    i = j;
    while (i < mChildren.size())
    {
      localObject = (Series)mChildren.get(i);
      if ((localObject instanceof VGroup)) {
        printGroupTree((VGroup)localObject, paramInt + 1);
      } else {
        ((VPath)localObject).printVPath(paramInt + 1);
      }
      i += 1;
    }
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    VectorDrawableCompatState localVectorDrawableCompatState = mVectorState;
    VPathRenderer localVPathRenderer = mVPathRenderer;
    mTintMode = parseTintModeCompat(TypedArrayUtils.getString(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    ColorStateList localColorStateList = paramTypedArray.getColorStateList(1);
    if (localColorStateList != null) {
      mTint = localColorStateList;
    }
    mAutoMirrored = TypedArrayUtils.getBoolean(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, mAutoMirrored);
    mViewportWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, mViewportWidth);
    mViewportHeight = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, mViewportHeight);
    if (mViewportWidth > 0.0F)
    {
      if (mViewportHeight > 0.0F)
      {
        mBaseWidth = paramTypedArray.getDimension(3, mBaseWidth);
        mBaseHeight = paramTypedArray.getDimension(2, mBaseHeight);
        if (mBaseWidth > 0.0F)
        {
          if (mBaseHeight > 0.0F)
          {
            localVPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "alpha", 4, localVPathRenderer.getAlpha()));
            paramTypedArray = paramTypedArray.getString(0);
            if (paramTypedArray != null)
            {
              mRootName = paramTypedArray;
              mVGTargetsMap.put(paramTypedArray, localVPathRenderer);
            }
          }
          else
          {
            paramXmlPullParser = new StringBuilder();
            paramXmlPullParser.append(paramTypedArray.getPositionDescription());
            paramXmlPullParser.append("<vector> tag requires height > 0");
            throw new XmlPullParserException(paramXmlPullParser.toString());
          }
        }
        else
        {
          paramXmlPullParser = new StringBuilder();
          paramXmlPullParser.append(paramTypedArray.getPositionDescription());
          paramXmlPullParser.append("<vector> tag requires width > 0");
          throw new XmlPullParserException(paramXmlPullParser.toString());
        }
      }
      else
      {
        paramXmlPullParser = new StringBuilder();
        paramXmlPullParser.append(paramTypedArray.getPositionDescription());
        paramXmlPullParser.append("<vector> tag requires viewportHeight > 0");
        throw new XmlPullParserException(paramXmlPullParser.toString());
      }
    }
    else
    {
      paramXmlPullParser = new StringBuilder();
      paramXmlPullParser.append(paramTypedArray.getPositionDescription());
      paramXmlPullParser.append("<vector> tag requires viewportWidth > 0");
      throw new XmlPullParserException(paramXmlPullParser.toString());
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      DrawableCompat.applyTheme(localDrawable, paramTheme);
    }
  }
  
  public boolean canApplyTheme()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      DrawableCompat.canApplyTheme(localDrawable);
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject1 = mDelegateDrawable;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).draw(paramCanvas);
      return;
    }
    copyBounds(mTmpBounds);
    if (mTmpBounds.width() > 0)
    {
      if (mTmpBounds.height() <= 0) {
        return;
      }
      Object localObject2 = mColorFilter;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = mTintFilter;
      }
      paramCanvas.getMatrix(mTmpMatrix);
      mTmpMatrix.getValues(mTmpFloats);
      float f1 = Math.abs(mTmpFloats[0]);
      float f2 = Math.abs(mTmpFloats[4]);
      float f4 = Math.abs(mTmpFloats[1]);
      float f3 = Math.abs(mTmpFloats[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      int i = (int)(mTmpBounds.width() * f1);
      int j = (int)(mTmpBounds.height() * f2);
      i = Math.min(2048, i);
      j = Math.min(2048, j);
      if (i > 0)
      {
        if (j <= 0) {
          return;
        }
        int k = paramCanvas.save();
        localObject2 = mTmpBounds;
        paramCanvas.translate(left, top);
        if (draw())
        {
          paramCanvas.translate(mTmpBounds.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        mTmpBounds.offsetTo(0, 0);
        mVectorState.createCachedBitmapIfNeeded(i, j);
        if (!mAllowCaching)
        {
          mVectorState.updateCachedBitmap(i, j);
        }
        else if (!mVectorState.canReuseCache())
        {
          mVectorState.updateCachedBitmap(i, j);
          mVectorState.updateCacheStates();
        }
        mVectorState.drawCachedBitmapWithRootAlpha(paramCanvas, (ColorFilter)localObject1, mTmpBounds);
        paramCanvas.restoreToCount(k);
      }
    }
  }
  
  public int getAlpha()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.getAlpha(localDrawable);
    }
    return mVectorState.mVPathRenderer.getRootAlpha();
  }
  
  public int getChangingConfigurations()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | mVectorState.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    Drawable localDrawable = mDelegateDrawable;
    if ((localDrawable != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new VectorDrawableDelegateState(localDrawable.getConstantState());
    }
    mVectorState.mChangingConfigurations = getChangingConfigurations();
    return mVectorState;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return (int)mVectorState.mVPathRenderer.mBaseHeight;
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return (int)mVectorState.mVPathRenderer.mBaseWidth;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return -3;
  }
  
  public float getPixelSize()
  {
    Object localObject = mVectorState;
    if (localObject != null)
    {
      localObject = mVPathRenderer;
      if (localObject != null)
      {
        float f1 = mBaseWidth;
        if (f1 != 0.0F)
        {
          float f2 = mBaseHeight;
          if (f2 != 0.0F)
          {
            float f3 = mViewportHeight;
            if (f3 != 0.0F)
            {
              float f4 = mViewportWidth;
              if (f4 != 0.0F) {
                return Math.min(f4 / f1, f3 / f2);
              }
            }
          }
        }
      }
    }
    return 1.0F;
  }
  
  public Object getTargetByName(String paramString)
  {
    return mVectorState.mVPathRenderer.mVGTargetsMap.get(paramString);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    Object localObject = mDelegateDrawable;
    if (localObject != null)
    {
      DrawableCompat.inflate((Drawable)localObject, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    localObject = mVectorState;
    mVPathRenderer = new VPathRenderer();
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.raw.styleable_VectorDrawableTypeArray);
    updateStateFromTypedArray(localTypedArray, paramXmlPullParser);
    localTypedArray.recycle();
    mChangingConfigurations = getChangingConfigurations();
    mCacheDirty = true;
    inflateInternal(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    mTintFilter = updateTintFilter(mTintFilter, mTint, mTintMode);
  }
  
  public void invalidateSelf()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.isAutoMirrored(localDrawable);
    }
    return mVectorState.mAutoMirrored;
  }
  
  public boolean isStateful()
  {
    Object localObject = mDelegateDrawable;
    if (localObject != null) {
      return ((Drawable)localObject).isStateful();
    }
    if (!super.isStateful())
    {
      localObject = mVectorState;
      if (localObject != null)
      {
        if (!((VectorDrawableCompatState)localObject).updateCachedBitmap())
        {
          localObject = mVectorState.mTint;
          if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {}
        }
      }
      else {
        return false;
      }
    }
    return true;
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.mutate();
      return this;
    }
    if ((!mMutated) && (super.mutate() == this))
    {
      mVectorState = new VectorDrawableCompatState(mVectorState);
      mMutated = true;
    }
    return this;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    Object localObject = mDelegateDrawable;
    if (localObject != null) {
      return ((Drawable)localObject).setState(paramArrayOfInt);
    }
    boolean bool2 = false;
    localObject = mVectorState;
    ColorStateList localColorStateList = mTint;
    boolean bool1 = bool2;
    if (localColorStateList != null)
    {
      PorterDuff.Mode localMode = mTintMode;
      bool1 = bool2;
      if (localMode != null)
      {
        mTintFilter = updateTintFilter(mTintFilter, localColorStateList, localMode);
        invalidateSelf();
        bool1 = true;
      }
    }
    if ((((VectorDrawableCompatState)localObject).updateCachedBitmap()) && (((VectorDrawableCompatState)localObject).draw(paramArrayOfInt)))
    {
      invalidateSelf();
      return true;
    }
    return bool1;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAllowCaching(boolean paramBoolean)
  {
    mAllowCaching = paramBoolean;
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    if (mVectorState.mVPathRenderer.getRootAlpha() != paramInt)
    {
      mVectorState.mVPathRenderer.setRootAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setAutoMirrored(localDrawable, paramBoolean);
      return;
    }
    mVectorState.mAutoMirrored = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    mColorFilter = paramColorFilter;
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      localDrawable.setFilterBitmap(paramBoolean);
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      DrawableCompat.setHotspot(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      DrawableCompat.setHotspotBounds(localDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTint(int paramInt)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setTint(localDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Object localObject = mDelegateDrawable;
    if (localObject != null)
    {
      DrawableCompat.setTintList((Drawable)localObject, paramColorStateList);
      return;
    }
    localObject = mVectorState;
    if (mTint != paramColorStateList)
    {
      mTint = paramColorStateList;
      mTintFilter = updateTintFilter(mTintFilter, paramColorStateList, mTintMode);
      invalidateSelf();
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    Object localObject = mDelegateDrawable;
    if (localObject != null)
    {
      DrawableCompat.setTintMode((Drawable)localObject, paramMode);
      return;
    }
    localObject = mVectorState;
    if (mTintMode != paramMode)
    {
      mTintMode = paramMode;
      mTintFilter = updateTintFilter(mTintFilter, mTint, paramMode);
      invalidateSelf();
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  public class VClipPath
    extends VectorDrawableCompat.VPath
  {
    public VClipPath() {}
    
    public VClipPath()
    {
      super();
    }
    
    private void updateStateFromTypedArray(TypedArray paramTypedArray)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        mPathName = str;
      }
      paramTypedArray = paramTypedArray.getString(1);
      if (paramTypedArray != null) {
        mNodes = PathParser.createNodesFromPathData(paramTypedArray);
      }
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      if (!TypedArrayUtils.get(paramXmlPullParser, "pathData")) {
        return;
      }
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.raw.styleable_VectorDrawableClipPath);
      updateStateFromTypedArray(paramResources);
      paramResources.recycle();
    }
    
    public boolean isClipPath()
    {
      return true;
    }
  }
  
  public class VFullPath
    extends VectorDrawableCompat.VPath
  {
    public static final int mFillRule = 0;
    public Attribute a;
    public float mFillAlpha = 1.0F;
    public int mFillColor = 0;
    public float mStrokeAlpha = 1.0F;
    public Attribute mStrokeColor;
    public Paint.Cap mStrokeLineCap = Paint.Cap.BUTT;
    public Paint.Join mStrokeLineJoin = Paint.Join.MITER;
    public float mStrokeMiterlimit = 4.0F;
    public float mStrokeWidth = 0.0F;
    public int[] mThemeAttrs;
    public float mTrimPathEnd = 1.0F;
    public float mTrimPathOffset = 0.0F;
    public float mTrimPathStart = 0.0F;
    
    public VFullPath() {}
    
    public VFullPath()
    {
      super();
      mThemeAttrs = mThemeAttrs;
      mStrokeColor = mStrokeColor;
      mStrokeWidth = mStrokeWidth;
      mStrokeAlpha = mStrokeAlpha;
      a = a;
      mFillColor = mFillColor;
      mFillAlpha = mFillAlpha;
      mTrimPathStart = mTrimPathStart;
      mTrimPathEnd = mTrimPathEnd;
      mTrimPathOffset = mTrimPathOffset;
      mStrokeLineCap = mStrokeLineCap;
      mStrokeLineJoin = mStrokeLineJoin;
      mStrokeMiterlimit = mStrokeMiterlimit;
    }
    
    private Paint.Cap getStrokeLineCap(int paramInt, Paint.Cap paramCap)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return paramCap;
          }
          return Paint.Cap.SQUARE;
        }
        return Paint.Cap.ROUND;
      }
      return Paint.Cap.BUTT;
    }
    
    private Paint.Join getStrokeLineJoin(int paramInt, Paint.Join paramJoin)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return paramJoin;
          }
          return Paint.Join.BEVEL;
        }
        return Paint.Join.ROUND;
      }
      return Paint.Join.MITER;
    }
    
    private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      mThemeAttrs = null;
      if (!TypedArrayUtils.get(paramXmlPullParser, "pathData")) {
        return;
      }
      String str = paramTypedArray.getString(0);
      if (str != null) {
        mPathName = str;
      }
      str = paramTypedArray.getString(2);
      if (str != null) {
        mNodes = PathParser.createNodesFromPathData(str);
      }
      a = TypedArrayUtils.a(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1, 0);
      mFillAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, mFillAlpha);
      mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getString(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1), mStrokeLineCap);
      mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getString(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1), mStrokeLineJoin);
      mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, mStrokeMiterlimit);
      mStrokeColor = TypedArrayUtils.a(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3, 0);
      mStrokeAlpha = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, mStrokeAlpha);
      mStrokeWidth = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, mStrokeWidth);
      mTrimPathEnd = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, mTrimPathEnd);
      mTrimPathOffset = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, mTrimPathOffset);
      mTrimPathStart = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, mTrimPathStart);
      mFillColor = TypedArrayUtils.getString(paramTypedArray, paramXmlPullParser, "fillType", 13, mFillColor);
    }
    
    public void applyTheme(Resources.Theme paramTheme)
    {
      if (mThemeAttrs == null) {}
    }
    
    public boolean canApplyTheme()
    {
      return mThemeAttrs != null;
    }
    
    public boolean draw()
    {
      return (a.equals()) || (mStrokeColor.equals());
    }
    
    public boolean draw(int[] paramArrayOfInt)
    {
      boolean bool = a.a(paramArrayOfInt);
      return mStrokeColor.a(paramArrayOfInt) | bool;
    }
    
    public float getFillAlpha()
    {
      return mFillAlpha;
    }
    
    public int getFillColor()
    {
      return a.getColor();
    }
    
    public float getStrokeAlpha()
    {
      return mStrokeAlpha;
    }
    
    public int getStrokeColor()
    {
      return mStrokeColor.getColor();
    }
    
    public float getStrokeWidth()
    {
      return mStrokeWidth;
    }
    
    public float getTrimPathEnd()
    {
      return mTrimPathEnd;
    }
    
    public float getTrimPathOffset()
    {
      return mTrimPathOffset;
    }
    
    public float getTrimPathStart()
    {
      return mTrimPathStart;
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.raw.styleable_VectorDrawablePath);
      updateStateFromTypedArray(paramResources, paramXmlPullParser, paramTheme);
      paramResources.recycle();
    }
    
    public void setFillAlpha(float paramFloat)
    {
      mFillAlpha = paramFloat;
    }
    
    public void setFillColor(int paramInt)
    {
      a.a(paramInt);
    }
    
    public void setStrokeAlpha(float paramFloat)
    {
      mStrokeAlpha = paramFloat;
    }
    
    public void setStrokeColor(int paramInt)
    {
      mStrokeColor.a(paramInt);
    }
    
    public void setStrokeWidth(float paramFloat)
    {
      mStrokeWidth = paramFloat;
    }
    
    public void setTrimPathEnd(float paramFloat)
    {
      mTrimPathEnd = paramFloat;
    }
    
    public void setTrimPathOffset(float paramFloat)
    {
      mTrimPathOffset = paramFloat;
    }
    
    public void setTrimPathStart(float paramFloat)
    {
      mTrimPathStart = paramFloat;
    }
  }
  
  public class VGroup
    extends Series
  {
    public int mChangingConfigurations;
    public final ArrayList<n.d> mChildren = new ArrayList();
    public String mGroupName = null;
    public final Matrix mLocalMatrix = new Matrix();
    public float mPivotX = 0.0F;
    public float mPivotY = 0.0F;
    public float mRotate = 0.0F;
    public float mScaleX = 1.0F;
    public float mScaleY = 1.0F;
    public final Matrix mStackedMatrix = new Matrix();
    public int[] mThemeAttrs;
    public float mTranslateX = 0.0F;
    public float mTranslateY = 0.0F;
    
    public VGroup()
    {
      super();
    }
    
    public VGroup(ArrayMap paramArrayMap) {}
    
    private void updateLocalMatrix()
    {
      mLocalMatrix.reset();
      mLocalMatrix.postTranslate(-mPivotX, -mPivotY);
      mLocalMatrix.postScale(mScaleX, mScaleY);
      mLocalMatrix.postRotate(mRotate, 0.0F, 0.0F);
      mLocalMatrix.postTranslate(mTranslateX + mPivotX, mTranslateY + mPivotY);
    }
    
    private void updateStateFromTypedArray(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      mThemeAttrs = null;
      mRotate = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "rotation", 5, mRotate);
      mPivotX = paramTypedArray.getFloat(1, mPivotX);
      mPivotY = paramTypedArray.getFloat(2, mPivotY);
      mScaleX = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleX", 3, mScaleX);
      mScaleY = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "scaleY", 4, mScaleY);
      mTranslateX = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateX", 6, mTranslateX);
      mTranslateY = TypedArrayUtils.getNamedFloat(paramTypedArray, paramXmlPullParser, "translateY", 7, mTranslateY);
      paramTypedArray = paramTypedArray.getString(0);
      if (paramTypedArray != null) {
        mGroupName = paramTypedArray;
      }
      updateLocalMatrix();
    }
    
    public boolean draw()
    {
      int i = 0;
      while (i < mChildren.size())
      {
        if (((Series)mChildren.get(i)).draw()) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public boolean draw(int[] paramArrayOfInt)
    {
      int i = 0;
      boolean bool = false;
      while (i < mChildren.size())
      {
        bool |= ((Series)mChildren.get(i)).draw(paramArrayOfInt);
        i += 1;
      }
      return bool;
    }
    
    public String getGroupName()
    {
      return mGroupName;
    }
    
    public Matrix getLocalMatrix()
    {
      return mLocalMatrix;
    }
    
    public float getPivotX()
    {
      return mPivotX;
    }
    
    public float getPivotY()
    {
      return mPivotY;
    }
    
    public float getRotation()
    {
      return mRotate;
    }
    
    public float getScaleX()
    {
      return mScaleX;
    }
    
    public float getScaleY()
    {
      return mScaleY;
    }
    
    public float getTranslateX()
    {
      return mTranslateX;
    }
    
    public float getTranslateY()
    {
      return mTranslateY;
    }
    
    public void inflate(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.raw.styleable_VectorDrawableGroup);
      updateStateFromTypedArray(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
    
    public void setPivotX(float paramFloat)
    {
      if (paramFloat != mPivotX)
      {
        mPivotX = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setPivotY(float paramFloat)
    {
      if (paramFloat != mPivotY)
      {
        mPivotY = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setRotation(float paramFloat)
    {
      if (paramFloat != mRotate)
      {
        mRotate = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setScaleX(float paramFloat)
    {
      if (paramFloat != mScaleX)
      {
        mScaleX = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setScaleY(float paramFloat)
    {
      if (paramFloat != mScaleY)
      {
        mScaleY = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setTranslateX(float paramFloat)
    {
      if (paramFloat != mTranslateX)
      {
        mTranslateX = paramFloat;
        updateLocalMatrix();
      }
    }
    
    public void setTranslateY(float paramFloat)
    {
      if (paramFloat != mTranslateY)
      {
        mTranslateY = paramFloat;
        updateLocalMatrix();
      }
    }
  }
  
  public abstract class VPath
    extends Series
  {
    public int mChangingConfigurations;
    public PathParser.PathDataNode[] mNodes = null;
    public String mPathName;
    
    public VPath()
    {
      super();
    }
    
    public VPath()
    {
      super();
      mPathName = mPathName;
      mChangingConfigurations = mChangingConfigurations;
      mNodes = PathParser.deepCopyNodes(mNodes);
    }
    
    public String NodesToString(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      Object localObject = " ";
      int i = 0;
      while (i < paramArrayOfPathDataNode.length)
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject);
        ((StringBuilder)localObject).append(type);
        ((StringBuilder)localObject).append(":");
        localObject = ((StringBuilder)localObject).toString();
        float[] arrayOfFloat = params;
        int j = 0;
        while (j < arrayOfFloat.length)
        {
          localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject);
          ((StringBuilder)localObject).append(arrayOfFloat[j]);
          ((StringBuilder)localObject).append(",");
          localObject = ((StringBuilder)localObject).toString();
          j += 1;
        }
        i += 1;
      }
      return localObject;
    }
    
    public void applyTheme(Resources.Theme paramTheme) {}
    
    public boolean canApplyTheme()
    {
      return false;
    }
    
    public PathParser.PathDataNode[] getPathData()
    {
      return mNodes;
    }
    
    public String getPathName()
    {
      return mPathName;
    }
    
    public boolean isClipPath()
    {
      return false;
    }
    
    public void printVPath(int paramInt)
    {
      Object localObject = "";
      int i = 0;
      while (i < paramInt)
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, "    ");
        i += 1;
      }
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject, "current path is :");
      ((StringBuilder)localObject).append(mPathName);
      ((StringBuilder)localObject).append(" pathData is ");
      ((StringBuilder)localObject).append(NodesToString(mNodes));
      ((StringBuilder)localObject).toString();
    }
    
    public void setPathData(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      if (!PathParser.canMorph(mNodes, paramArrayOfPathDataNode))
      {
        mNodes = PathParser.deepCopyNodes(paramArrayOfPathDataNode);
        return;
      }
      PathParser.updateNodes(mNodes, paramArrayOfPathDataNode);
    }
    
    public void toPath(Path paramPath)
    {
      paramPath.reset();
      PathParser.PathDataNode[] arrayOfPathDataNode = mNodes;
      if (arrayOfPathDataNode != null) {
        PathParser.PathDataNode.nodesToPath(arrayOfPathDataNode, paramPath);
      }
    }
  }
  
  public class VPathRenderer
  {
    public static final Matrix IDENTITY_MATRIX = new Matrix();
    public float mBaseHeight = 0.0F;
    public float mBaseWidth = 0.0F;
    public int mChangingConfigurations;
    public Paint mFillPaint;
    public final Matrix mFinalPathMatrix = new Matrix();
    public Boolean mGenerated = null;
    public final Path mPath;
    public PathMeasure mPathMeasure;
    public final Path mRenderPath;
    public int mRootAlpha = 255;
    public final VectorDrawableCompat.VGroup mRootGroup;
    public String mRootName = null;
    public Paint mStrokePaint;
    public final b<String, Object> mVGTargetsMap = new ArrayMap();
    public float mViewportHeight = 0.0F;
    public float mViewportWidth = 0.0F;
    
    public VPathRenderer()
    {
      mRootGroup = new VectorDrawableCompat.VGroup();
      mPath = new Path();
      mRenderPath = new Path();
    }
    
    public VPathRenderer()
    {
      mRootGroup = new VectorDrawableCompat.VGroup(mRootGroup, mVGTargetsMap);
      mPath = new Path(mPath);
      mRenderPath = new Path(mRenderPath);
      mBaseWidth = mBaseWidth;
      mBaseHeight = mBaseHeight;
      mViewportWidth = mViewportWidth;
      mViewportHeight = mViewportHeight;
      mChangingConfigurations = mChangingConfigurations;
      mRootAlpha = mRootAlpha;
      mRootName = mRootName;
      String str = mRootName;
      if (str != null) {
        mVGTargetsMap.put(str, this);
      }
      mGenerated = mGenerated;
    }
    
    public static float cross(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
    }
    
    private void drawGroupTree(VectorDrawableCompat.VGroup paramVGroup, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      mStackedMatrix.set(paramMatrix);
      mStackedMatrix.preConcat(mLocalMatrix);
      paramCanvas.save();
      int i = 0;
      while (i < mChildren.size())
      {
        paramMatrix = (Series)mChildren.get(i);
        if ((paramMatrix instanceof VectorDrawableCompat.VGroup)) {
          drawGroupTree((VectorDrawableCompat.VGroup)paramMatrix, mStackedMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        } else if ((paramMatrix instanceof VectorDrawableCompat.VPath)) {
          drawPath(paramVGroup, (VectorDrawableCompat.VPath)paramMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
        i += 1;
      }
      paramCanvas.restore();
    }
    
    private void drawPath(VectorDrawableCompat.VGroup paramVGroup, VectorDrawableCompat.VPath paramVPath, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      float f2 = paramInt1 / mViewportWidth;
      float f3 = paramInt2 / mViewportHeight;
      float f1 = Math.min(f2, f3);
      paramVGroup = mStackedMatrix;
      mFinalPathMatrix.set(paramVGroup);
      mFinalPathMatrix.postScale(f2, f3);
      f2 = getMatrixScale(paramVGroup);
      if (f2 == 0.0F) {
        return;
      }
      paramVPath.toPath(mPath);
      paramVGroup = mPath;
      mRenderPath.reset();
      if (paramVPath.isClipPath())
      {
        mRenderPath.addPath(paramVGroup, mFinalPathMatrix);
        paramCanvas.clipPath(mRenderPath);
        return;
      }
      paramVPath = (VectorDrawableCompat.VFullPath)paramVPath;
      if ((mTrimPathStart != 0.0F) || (mTrimPathEnd != 1.0F))
      {
        float f6 = mTrimPathStart;
        float f4 = mTrimPathOffset;
        float f5 = mTrimPathEnd;
        if (mPathMeasure == null) {
          mPathMeasure = new PathMeasure();
        }
        mPathMeasure.setPath(mPath, false);
        f3 = mPathMeasure.getLength();
        f6 = (f6 + f4) % 1.0F * f3;
        f4 = (f5 + f4) % 1.0F * f3;
        paramVGroup.reset();
        if (f6 > f4)
        {
          mPathMeasure.getSegment(f6, f3, paramVGroup, true);
          mPathMeasure.getSegment(0.0F, f4, paramVGroup, true);
        }
        else
        {
          mPathMeasure.getSegment(f6, f4, paramVGroup, true);
        }
        paramVGroup.rLineTo(0.0F, 0.0F);
      }
      mRenderPath.addPath(paramVGroup, mFinalPathMatrix);
      Object localObject1;
      Object localObject2;
      if (a.a())
      {
        paramVGroup = a;
        if (mFillPaint == null)
        {
          mFillPaint = new Paint(1);
          mFillPaint.setStyle(Paint.Style.FILL);
        }
        localObject1 = mFillPaint;
        if (paramVGroup.size())
        {
          paramVGroup = paramVGroup.getValue();
          paramVGroup.setLocalMatrix(mFinalPathMatrix);
          ((Paint)localObject1).setShader(paramVGroup);
          ((Paint)localObject1).setAlpha(Math.round(mFillAlpha * 255.0F));
        }
        else
        {
          ((Paint)localObject1).setColor(VectorDrawableCompat.access$getAlpha(paramVGroup.getColor(), mFillAlpha));
        }
        ((Paint)localObject1).setColorFilter(paramColorFilter);
        localObject2 = mRenderPath;
        if (mFillColor == 0) {
          paramVGroup = Path.FillType.WINDING;
        } else {
          paramVGroup = Path.FillType.EVEN_ODD;
        }
        ((Path)localObject2).setFillType(paramVGroup);
        paramCanvas.drawPath(mRenderPath, (Paint)localObject1);
      }
      if (mStrokeColor.a())
      {
        localObject1 = mStrokeColor;
        if (mStrokePaint == null)
        {
          mStrokePaint = new Paint(1);
          mStrokePaint.setStyle(Paint.Style.STROKE);
        }
        paramVGroup = mStrokePaint;
        localObject2 = mStrokeLineJoin;
        if (localObject2 != null) {
          paramVGroup.setStrokeJoin((Paint.Join)localObject2);
        }
        localObject2 = mStrokeLineCap;
        if (localObject2 != null) {
          paramVGroup.setStrokeCap((Paint.Cap)localObject2);
        }
        paramVGroup.setStrokeMiter(mStrokeMiterlimit);
        if (((Attribute)localObject1).size())
        {
          localObject1 = ((Attribute)localObject1).getValue();
          ((Shader)localObject1).setLocalMatrix(mFinalPathMatrix);
          paramVGroup.setShader((Shader)localObject1);
          paramVGroup.setAlpha(Math.round(mStrokeAlpha * 255.0F));
        }
        else
        {
          paramVGroup.setColor(VectorDrawableCompat.access$getAlpha(((Attribute)localObject1).getColor(), mStrokeAlpha));
        }
        paramVGroup.setColorFilter(paramColorFilter);
        paramVGroup.setStrokeWidth(mStrokeWidth * (f1 * f2));
        paramCanvas.drawPath(mRenderPath, paramVGroup);
      }
    }
    
    private float getMatrixScale(Matrix paramMatrix)
    {
      float[] arrayOfFloat = new float[4];
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 1.0F;
      arrayOfFloat[2] = 1.0F;
      arrayOfFloat[3] = 0.0F;
      paramMatrix.mapVectors(arrayOfFloat);
      float f2 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f3 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f1 = cross(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      f2 = Math.max(f2, f3);
      if (f2 > 0.0F) {
        return Math.abs(f1) / f2;
      }
      return 0.0F;
    }
    
    public void draw(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      drawGroupTree(mRootGroup, IDENTITY_MATRIX, paramCanvas, paramInt1, paramInt2, paramColorFilter);
    }
    
    public boolean draw()
    {
      if (mGenerated == null) {
        mGenerated = Boolean.valueOf(mRootGroup.draw());
      }
      return mGenerated.booleanValue();
    }
    
    public boolean draw(int[] paramArrayOfInt)
    {
      return mRootGroup.draw(paramArrayOfInt);
    }
    
    public float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public int getRootAlpha()
    {
      return mRootAlpha;
    }
    
    public void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(paramFloat * 255.0F));
    }
    
    public void setRootAlpha(int paramInt)
    {
      mRootAlpha = paramInt;
    }
  }
  
  public class VectorDrawableCompatState
    extends Drawable.ConstantState
  {
    public boolean mAutoMirrored;
    public boolean mCacheDirty;
    public boolean mCachedAutoMirrored;
    public Bitmap mCachedBitmap;
    public int mCachedRootAlpha;
    public int[] mCachedThemeAttrs;
    public ColorStateList mCachedTint;
    public PorterDuff.Mode mCachedTintMode;
    public int mChangingConfigurations;
    public Paint mTempPaint;
    public ColorStateList mTint = null;
    public PorterDuff.Mode mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
    public VectorDrawableCompat.VPathRenderer mVPathRenderer;
    
    public VectorDrawableCompatState()
    {
      mVPathRenderer = new VectorDrawableCompat.VPathRenderer();
    }
    
    public VectorDrawableCompatState()
    {
      if (this$1 != null)
      {
        mChangingConfigurations = mChangingConfigurations;
        mVPathRenderer = new VectorDrawableCompat.VPathRenderer(mVPathRenderer);
        Paint localPaint = mVPathRenderer.mFillPaint;
        if (localPaint != null) {
          mVPathRenderer.mFillPaint = new Paint(localPaint);
        }
        localPaint = mVPathRenderer.mStrokePaint;
        if (localPaint != null) {
          mVPathRenderer.mStrokePaint = new Paint(localPaint);
        }
        mTint = mTint;
        mTintMode = mTintMode;
        mAutoMirrored = mAutoMirrored;
      }
    }
    
    public boolean canReuseBitmap(int paramInt1, int paramInt2)
    {
      return (paramInt1 == mCachedBitmap.getWidth()) && (paramInt2 == mCachedBitmap.getHeight());
    }
    
    public boolean canReuseCache()
    {
      return (!mCacheDirty) && (mCachedTint == mTint) && (mCachedTintMode == mTintMode) && (mCachedAutoMirrored == mAutoMirrored) && (mCachedRootAlpha == mVPathRenderer.getRootAlpha());
    }
    
    public void createCachedBitmapIfNeeded(int paramInt1, int paramInt2)
    {
      if ((mCachedBitmap == null) || (!canReuseBitmap(paramInt1, paramInt2)))
      {
        mCachedBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        mCacheDirty = true;
      }
    }
    
    public boolean draw(int[] paramArrayOfInt)
    {
      boolean bool = mVPathRenderer.draw(paramArrayOfInt);
      mCacheDirty |= bool;
      return bool;
    }
    
    public void drawCachedBitmapWithRootAlpha(Canvas paramCanvas, ColorFilter paramColorFilter, Rect paramRect)
    {
      paramColorFilter = getPaint(paramColorFilter);
      paramCanvas.drawBitmap(mCachedBitmap, null, paramRect, paramColorFilter);
    }
    
    public int getChangingConfigurations()
    {
      return mChangingConfigurations;
    }
    
    public Paint getPaint(ColorFilter paramColorFilter)
    {
      if ((!hasTranslucentRoot()) && (paramColorFilter == null)) {
        return null;
      }
      if (mTempPaint == null)
      {
        mTempPaint = new Paint();
        mTempPaint.setFilterBitmap(true);
      }
      mTempPaint.setAlpha(mVPathRenderer.getRootAlpha());
      mTempPaint.setColorFilter(paramColorFilter);
      return mTempPaint;
    }
    
    public boolean hasTranslucentRoot()
    {
      return mVPathRenderer.getRootAlpha() < 255;
    }
    
    public Drawable newDrawable()
    {
      return new VectorDrawableCompat(this);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new VectorDrawableCompat(this);
    }
    
    public void updateCacheStates()
    {
      mCachedTint = mTint;
      mCachedTintMode = mTintMode;
      mCachedRootAlpha = mVPathRenderer.getRootAlpha();
      mCachedAutoMirrored = mAutoMirrored;
      mCacheDirty = false;
    }
    
    public void updateCachedBitmap(int paramInt1, int paramInt2)
    {
      mCachedBitmap.eraseColor(0);
      Canvas localCanvas = new Canvas(mCachedBitmap);
      mVPathRenderer.draw(localCanvas, paramInt1, paramInt2, null);
    }
    
    public boolean updateCachedBitmap()
    {
      return mVPathRenderer.draw();
    }
  }
  
  @K(24)
  public class VectorDrawableDelegateState
    extends Drawable.ConstantState
  {
    public VectorDrawableDelegateState() {}
    
    public boolean canApplyTheme()
    {
      return VectorDrawableCompat.this.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return VectorDrawableCompat.this.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
      mDelegateDrawable = ((Drawable)VectorDrawableCompat.this.newDrawable());
      return localVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
      mDelegateDrawable = ((Drawable)VectorDrawableCompat.this.newDrawable(paramResources));
      return localVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      VectorDrawableCompat localVectorDrawableCompat = new VectorDrawableCompat();
      mDelegateDrawable = ((Drawable)VectorDrawableCompat.this.newDrawable(paramResources, paramTheme));
      return localVectorDrawableCompat;
    }
  }
}
