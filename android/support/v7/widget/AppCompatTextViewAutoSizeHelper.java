package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AppCompatTextViewAutoSizeHelper
{
  public static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
  public static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
  public static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
  public static final String PAGE_KEY = "ACTVAutoSizeHelper";
  public static final RectF TEMP_RECTF = new RectF();
  public static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0F;
  public static final int VERY_WIDE = 1048576;
  public static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap();
  public float mAutoSizeMaxTextSizeInPx = -1.0F;
  public float mAutoSizeMinTextSizeInPx = -1.0F;
  public float mAutoSizeStepGranularityInPx = -1.0F;
  public int[] mAutoSizeTextSizesInPx = new int[0];
  public int mAutoSizeTextType = 0;
  public final Context mContext;
  public boolean mHasPresetAutoSizeValues = false;
  public boolean mNeedsAutoSizeText = false;
  public TextPaint mTempTextPaint;
  public final TextView mTextView;
  
  public AppCompatTextViewAutoSizeHelper(TextView paramTextView)
  {
    mTextView = paramTextView;
    mContext = mTextView.getContext();
  }
  
  private int[] cleanupAutoSizePresetSizes(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    if (k == 0) {
      return paramArrayOfInt;
    }
    Arrays.sort(paramArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      int m = paramArrayOfInt[i];
      if ((m > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(m)) < 0)) {
        localArrayList.add(Integer.valueOf(m));
      }
      i += 1;
    }
    if (k == localArrayList.size()) {
      return paramArrayOfInt;
    }
    k = localArrayList.size();
    paramArrayOfInt = new int[k];
    i = j;
    while (i < k)
    {
      paramArrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    return paramArrayOfInt;
  }
  
  private void clearAutoSizeConfiguration()
  {
    mAutoSizeTextType = 0;
    mAutoSizeMinTextSizeInPx = -1.0F;
    mAutoSizeMaxTextSizeInPx = -1.0F;
    mAutoSizeStepGranularityInPx = -1.0F;
    mAutoSizeTextSizesInPx = new int[0];
    mNeedsAutoSizeText = false;
  }
  
  private StaticLayout createStaticLayoutForMeasuring(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)invokeAndReturnWithDefault(mTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), mTempTextPaint, paramInt1).setAlignment(paramAlignment).setLineSpacing(mTextView.getLineSpacingExtra(), mTextView.getLineSpacingMultiplier()).setIncludePad(mTextView.getIncludeFontPadding()).setBreakStrategy(mTextView.getBreakStrategy()).setHyphenationFrequency(mTextView.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = Integer.MAX_VALUE;
    }
    return paramCharSequence.setMaxLines(paramInt1).setTextDirection(localTextDirectionHeuristic).build();
  }
  
  private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    float f1 = mTextView.getLineSpacingMultiplier();
    float f2 = mTextView.getLineSpacingExtra();
    boolean bool = mTextView.getIncludeFontPadding();
    return new StaticLayout(paramCharSequence, mTempTextPaint, paramInt, paramAlignment, f1, f2, bool);
  }
  
  private int findLargestTextSizeWhichFits(RectF paramRectF)
  {
    int i = mAutoSizeTextSizesInPx.length;
    if (i != 0)
    {
      int k = i - 1;
      i = 1;
      int j = 0;
      while (i <= k)
      {
        int m = (i + k) / 2;
        if (suggestedSizeFitsInSpace(mAutoSizeTextSizesInPx[m], paramRectF))
        {
          j = i;
          i = m + 1;
        }
        else
        {
          j = m - 1;
          k = j;
        }
      }
      return mAutoSizeTextSizesInPx[j];
    }
    paramRectF = new IllegalStateException("No available text sizes to choose from.");
    throw paramRectF;
  }
  
  private Method getTextViewMethod(String paramString)
  {
    Object localObject = sTextViewMethodByNameCache;
    try
    {
      localObject = ((ConcurrentHashMap)localObject).get(paramString);
      Method localMethod = (Method)localObject;
      localObject = localMethod;
      if (localMethod != null) {
        return localObject;
      }
      localMethod = TextView.class.getDeclaredMethod(paramString, new Class[0]);
      localObject = localMethod;
      if (localMethod == null) {
        return localObject;
      }
      localMethod.setAccessible(true);
      localObject = sTextViewMethodByNameCache;
      ((ConcurrentHashMap)localObject).put(paramString, localMethod);
      return localMethod;
    }
    catch (Exception localException)
    {
      for (;;) {}
      return localException;
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Failed to retrieve TextView#", paramString, "() method");
    return null;
  }
  
  private Object invokeAndReturnWithDefault(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      Method localMethod = getTextViewMethod(paramString);
      paramObject1 = localMethod.invoke(paramObject1, new Object[0]);
      return paramObject1;
    }
    catch (Throwable paramObject1)
    {
      break label60;
      paramObject1 = new StringBuilder();
      paramObject1.append("Failed to invoke TextView#");
      paramObject1.append(paramString);
      paramObject1.append("() method");
      paramObject1.toString();
      return paramObject2;
      throw paramObject1;
    }
    catch (Exception paramObject1)
    {
      label60:
      for (;;) {}
    }
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != mTextView.getPaint().getTextSize())
    {
      mTextView.getPaint().setTextSize(paramFloat);
      int i = Build.VERSION.SDK_INT;
      boolean bool = mTextView.isInLayout();
      if (mTextView.getLayout() != null)
      {
        mNeedsAutoSizeText = false;
        try
        {
          Method localMethod = getTextViewMethod("nullLayouts");
          if (localMethod != null)
          {
            TextView localTextView = mTextView;
            localMethod.invoke(localTextView, new Object[0]);
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        if (!bool) {
          mTextView.requestLayout();
        } else {
          mTextView.forceLayout();
        }
        mTextView.invalidate();
        return;
      }
    }
  }
  
  private boolean setupAutoSizeText()
  {
    boolean bool = supportsAutoSizeText();
    int j = 0;
    if ((bool) && (mAutoSizeTextType == 1))
    {
      if ((!mHasPresetAutoSizeValues) || (mAutoSizeTextSizesInPx.length == 0))
      {
        float f = Math.round(mAutoSizeMinTextSizeInPx);
        int i = 1;
        while (Math.round(mAutoSizeStepGranularityInPx + f) <= Math.round(mAutoSizeMaxTextSizeInPx))
        {
          i += 1;
          f += mAutoSizeStepGranularityInPx;
        }
        int[] arrayOfInt = new int[i];
        f = mAutoSizeMinTextSizeInPx;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f);
          f += mAutoSizeStepGranularityInPx;
          j += 1;
        }
        mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      }
      mNeedsAutoSizeText = true;
    }
    else
    {
      mNeedsAutoSizeText = false;
    }
    return mNeedsAutoSizeText;
  }
  
  private void setupAutoSizeUniformPresetSizes(TypedArray paramTypedArray)
  {
    int j = paramTypedArray.length();
    int[] arrayOfInt = new int[j];
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        arrayOfInt[i] = paramTypedArray.getDimensionPixelSize(i, -1);
        i += 1;
      }
      mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      setupAutoSizeUniformPresetSizesConfiguration();
    }
  }
  
  private boolean setupAutoSizeUniformPresetSizesConfiguration()
  {
    int i = mAutoSizeTextSizesInPx.length;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    mHasPresetAutoSizeValues = bool;
    if (mHasPresetAutoSizeValues)
    {
      mAutoSizeTextType = 1;
      int[] arrayOfInt = mAutoSizeTextSizesInPx;
      mAutoSizeMinTextSizeInPx = arrayOfInt[0];
      mAutoSizeMaxTextSizeInPx = arrayOfInt[(i - 1)];
      mAutoSizeStepGranularityInPx = -1.0F;
    }
    return mHasPresetAutoSizeValues;
  }
  
  private boolean suggestedSizeFitsInSpace(int paramInt, RectF paramRectF)
  {
    CharSequence localCharSequence = mTextView.getText();
    Object localObject2 = localCharSequence;
    TransformationMethod localTransformationMethod = mTextView.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localTransformationMethod != null)
    {
      localCharSequence = localTransformationMethod.getTransformation(localCharSequence, mTextView);
      localObject1 = localObject2;
      if (localCharSequence != null) {
        localObject1 = localCharSequence;
      }
    }
    int i = Build.VERSION.SDK_INT;
    i = mTextView.getMaxLines();
    localObject2 = mTempTextPaint;
    if (localObject2 == null) {
      mTempTextPaint = new TextPaint();
    } else {
      ((Paint)localObject2).reset();
    }
    mTempTextPaint.set(mTextView.getPaint());
    mTempTextPaint.setTextSize(paramInt);
    localObject2 = (Layout.Alignment)invokeAndReturnWithDefault(mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = createStaticLayoutForMeasuring((CharSequence)localObject1, (Layout.Alignment)localObject2, Math.round(right), i);
    } else {
      localObject2 = createStaticLayoutForMeasuringPre23((CharSequence)localObject1, (Layout.Alignment)localObject2, Math.round(right));
    }
    if (i != -1)
    {
      if (((StaticLayout)localObject2).getLineCount() > i) {
        break label245;
      }
      if (((Layout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) != ((CharSequence)localObject1).length()) {
        return false;
      }
    }
    return ((Layout)localObject2).getHeight() <= bottom;
    label245:
    return false;
  }
  
  private boolean supportsAutoSizeText()
  {
    return !(mTextView instanceof AppCompatEditText);
  }
  
  private void validateAndSetAutoSizeTextTypeUniformConfiguration(float paramFloat1, float paramFloat2, float paramFloat3)
    throws IllegalArgumentException
  {
    if (paramFloat1 > 0.0F)
    {
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat3 > 0.0F)
        {
          mAutoSizeTextType = 1;
          mAutoSizeMinTextSizeInPx = paramFloat1;
          mAutoSizeMaxTextSizeInPx = paramFloat2;
          mAutoSizeStepGranularityInPx = paramFloat3;
          mHasPresetAutoSizeValues = false;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("The auto-size step granularity (");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Maximum auto-size text size (");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("px) is less or equal to minimum auto-size ");
      localStringBuilder.append("text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Minimum auto-size text size (");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void autoSizeText()
  {
    if (!isAutoSizeEnabled()) {
      return;
    }
    if (mNeedsAutoSizeText)
    {
      if (mTextView.getMeasuredHeight() <= 0) {
        return;
      }
      if (mTextView.getMeasuredWidth() <= 0) {
        return;
      }
      int i;
      if (((Boolean)invokeAndReturnWithDefault(mTextView, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
        i = 1048576;
      } else {
        i = mTextView.getMeasuredWidth() - mTextView.getTotalPaddingLeft() - mTextView.getTotalPaddingRight();
      }
      int j = mTextView.getHeight() - mTextView.getCompoundPaddingBottom() - mTextView.getCompoundPaddingTop();
      if (i <= 0) {
        return;
      }
      if (j <= 0) {
        return;
      }
      RectF localRectF = TEMP_RECTF;
      try
      {
        TEMP_RECTF.setEmpty();
        TEMP_RECTFright = i;
        TEMP_RECTFbottom = j;
        float f = findLargestTextSizeWhichFits(TEMP_RECTF);
        if (f != mTextView.getTextSize()) {
          setTextSizeInternal(0, f);
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    mNeedsAutoSizeText = true;
  }
  
  public int getAutoSizeMaxTextSize()
  {
    return Math.round(mAutoSizeMaxTextSizeInPx);
  }
  
  public int getAutoSizeMinTextSize()
  {
    return Math.round(mAutoSizeMinTextSizeInPx);
  }
  
  public int getAutoSizeStepGranularity()
  {
    return Math.round(mAutoSizeStepGranularityInPx);
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    return mAutoSizeTextSizesInPx;
  }
  
  public int getAutoSizeTextType()
  {
    return mAutoSizeTextType;
  }
  
  public boolean isAutoSizeEnabled()
  {
    return (supportsAutoSizeText()) && (mAutoSizeTextType != 0);
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
      mAutoSizeTextType = paramAttributeSet.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
    }
    float f1;
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    } else {
      f1 = -1.0F;
    }
    float f2;
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    } else {
      f2 = -1.0F;
    }
    float f3;
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    } else {
      f3 = -1.0F;
    }
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes))
    {
      paramInt = paramAttributeSet.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
      if (paramInt > 0)
      {
        TypedArray localTypedArray = paramAttributeSet.getResources().obtainTypedArray(paramInt);
        setupAutoSizeUniformPresetSizes(localTypedArray);
        localTypedArray.recycle();
      }
    }
    paramAttributeSet.recycle();
    if (supportsAutoSizeText())
    {
      if (mAutoSizeTextType == 1)
      {
        if (!mHasPresetAutoSizeValues)
        {
          paramAttributeSet = mContext.getResources().getDisplayMetrics();
          float f4 = f2;
          if (f2 == -1.0F) {
            f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
          }
          f2 = f3;
          if (f3 == -1.0F) {
            f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
          }
          f3 = f1;
          if (f1 == -1.0F) {
            f3 = 1.0F;
          }
          validateAndSetAutoSizeTextTypeUniformConfiguration(f4, f2, f3);
        }
        setupAutoSizeText();
      }
    }
    else {
      mAutoSizeTextType = 0;
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (supportsAutoSizeText())
    {
      DisplayMetrics localDisplayMetrics = mContext.getResources().getDisplayMetrics();
      validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (setupAutoSizeText()) {
        autoSizeText();
      }
    }
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (supportsAutoSizeText())
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      if (j > 0)
      {
        int[] arrayOfInt = new int[j];
        Object localObject;
        if (paramInt == 0)
        {
          localObject = Arrays.copyOf(paramArrayOfInt, j);
        }
        else
        {
          DisplayMetrics localDisplayMetrics = mContext.getResources().getDisplayMetrics();
          for (;;)
          {
            localObject = arrayOfInt;
            if (i >= j) {
              break;
            }
            arrayOfInt[i] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i], localDisplayMetrics));
            i += 1;
          }
        }
        mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes((int[])localObject);
        if (!setupAutoSizeUniformPresetSizesConfiguration())
        {
          localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("None of the preset sizes is valid: ");
          ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        mHasPresetAutoSizeValues = false;
      }
      if (setupAutoSizeText()) {
        autoSizeText();
      }
    }
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (supportsAutoSizeText()) {
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          DisplayMetrics localDisplayMetrics = mContext.getResources().getDisplayMetrics();
          validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
          if (setupAutoSizeText()) {
            autoSizeText();
          }
        }
        else
        {
          throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unknown auto-size text type: ", paramInt));
        }
      }
      else {
        clearAutoSizeConfiguration();
      }
    }
  }
  
  public void setTextSizeInternal(int paramInt, float paramFloat)
  {
    Object localObject = mContext;
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
}
