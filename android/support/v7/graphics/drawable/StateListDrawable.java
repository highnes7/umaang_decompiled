package android.support.v7.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.StateSet;
import b.b.a.N;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.v4.content.asm.TypedArrayUtils;

@N({b.b.a.N.a.b})
public class StateListDrawable
  extends DrawableContainer
{
  public static final boolean DEBUG = false;
  public static final String TAG = "StateListDrawable";
  public boolean mMutated;
  public StateListState mStateListState;
  
  public StateListDrawable()
  {
    this(null, null);
  }
  
  public StateListDrawable(StateListState paramStateListState)
  {
    if (paramStateListState != null) {
      setConstantState(paramStateListState);
    }
  }
  
  public StateListDrawable(StateListState paramStateListState, Resources paramResources)
  {
    setConstantState(new StateListState(paramStateListState, this, paramResources));
    onStateChange(getState());
  }
  
  private void inflateChildElements(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    StateListState localStateListState = mStateListState;
    int i = paramXmlPullParser.getDepth() + 1;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        Object localObject = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawableItem);
        Drawable localDrawable = null;
        j = ((TypedArray)localObject).getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
        if (j > 0) {
          localDrawable = AppCompatResources.getDrawable(paramContext, j);
        }
        ((TypedArray)localObject).recycle();
        int[] arrayOfInt = extractStateSet(paramAttributeSet);
        localObject = localDrawable;
        if (localDrawable == null)
        {
          do
          {
            j = paramXmlPullParser.next();
          } while (j == 4);
          if (j == 2)
          {
            if (Build.VERSION.SDK_INT >= 21) {
              localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
            } else {
              localObject = Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet);
            }
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append(paramXmlPullParser.getPositionDescription());
            paramContext.append(": <item> tag requires a 'drawable' attribute or ");
            paramContext.append("child tag defining a drawable");
            throw new XmlPullParserException(paramContext.toString());
          }
        }
        localStateListState.addStateSet(arrayOfInt, (Drawable)localObject);
      }
    }
  }
  
  private void updateStateFromTypedArray(TypedArray paramTypedArray)
  {
    StateListState localStateListState = mStateListState;
    if (Build.VERSION.SDK_INT >= 21) {
      mChangingConfigurations |= paramTypedArray.getChangingConfigurations();
    }
    mVariablePadding = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, mVariablePadding);
    mConstantSize = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, mConstantSize);
    mEnterFadeDuration = paramTypedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, mEnterFadeDuration);
    mExitFadeDuration = paramTypedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, mExitFadeDuration);
    mDither = paramTypedArray.getBoolean(R.styleable.StateListDrawable_android_dither, mDither);
  }
  
  public void addState(int[] paramArrayOfInt, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      mStateListState.addStateSet(paramArrayOfInt, paramDrawable);
      onStateChange(getState());
    }
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    mDrawableContainerState.applyTheme(paramTheme);
    onStateChange(getState());
  }
  
  public void clearMutated()
  {
    super.clearMutated();
    mMutated = false;
  }
  
  public StateListState cloneConstantState()
  {
    return new StateListState(mStateListState, this, null);
  }
  
  public int[] extractStateSet(AttributeSet paramAttributeSet)
  {
    int i1 = paramAttributeSet.getAttributeCount();
    int[] arrayOfInt = new int[i1];
    int i = 0;
    int k;
    for (int j = 0; i < i1; j = k)
    {
      int n = paramAttributeSet.getAttributeNameResource(i);
      int m = n;
      k = j;
      if (n != 0)
      {
        k = j;
        if (n != 16842960)
        {
          k = j;
          if (n != 16843161)
          {
            if (!paramAttributeSet.getAttributeBooleanValue(i, false)) {
              m = -n;
            }
            arrayOfInt[j] = m;
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    return StateSet.trimStateSet(arrayOfInt, j);
  }
  
  public int getStateCount()
  {
    return mStateListState.getChildCount();
  }
  
  public Drawable getStateDrawable(int paramInt)
  {
    return mStateListState.getChild(paramInt);
  }
  
  public int getStateDrawableIndex(int[] paramArrayOfInt)
  {
    return mStateListState.indexOfStateSet(paramArrayOfInt);
  }
  
  public StateListState getStateListState()
  {
    return mStateListState;
  }
  
  public int[] getStateSet(int paramInt)
  {
    return mStateListState.mStateSets[paramInt];
  }
  
  public void inflate(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.StateListDrawable);
    setVisible(localTypedArray.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
    updateStateFromTypedArray(localTypedArray);
    updateDensity(paramResources);
    localTypedArray.recycle();
    inflateChildElements(paramContext, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    onStateChange(getState());
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public Drawable mutate()
  {
    if (!mMutated)
    {
      super.mutate();
      mStateListState.mutate();
      mMutated = true;
    }
    return this;
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = super.onStateChange(paramArrayOfInt);
    int j = mStateListState.indexOfStateSet(paramArrayOfInt);
    int i = j;
    if (j < 0) {
      i = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    }
    return (selectDrawable(i)) || (bool);
  }
  
  public void setConstantState(DrawableContainer.DrawableContainerState paramDrawableContainerState)
  {
    super.setConstantState(paramDrawableContainerState);
    if ((paramDrawableContainerState instanceof StateListState)) {
      mStateListState = ((StateListState)paramDrawableContainerState);
    }
  }
  
  public static class StateListState
    extends DrawableContainer.DrawableContainerState
  {
    public int[][] mStateSets;
    
    public StateListState(StateListState paramStateListState, StateListDrawable paramStateListDrawable, Resources paramResources)
    {
      super(paramStateListDrawable, paramResources);
      if (paramStateListState != null)
      {
        mStateSets = mStateSets;
        return;
      }
      mStateSets = new int[getCapacity()][];
    }
    
    public int addStateSet(int[] paramArrayOfInt, Drawable paramDrawable)
    {
      int i = addChild(paramDrawable);
      mStateSets[i] = paramArrayOfInt;
      return i;
    }
    
    public void growArray(int paramInt1, int paramInt2)
    {
      super.growArray(paramInt1, paramInt2);
      int[][] arrayOfInt = new int[paramInt2][];
      System.arraycopy(mStateSets, 0, arrayOfInt, 0, paramInt1);
      mStateSets = arrayOfInt;
    }
    
    public int indexOfStateSet(int[] paramArrayOfInt)
    {
      int[][] arrayOfInt = mStateSets;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        if (StateSet.stateSetMatches(arrayOfInt[i], paramArrayOfInt)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    public void mutate()
    {
      Object localObject = mStateSets;
      int[][] arrayOfInt = new int[localObject.length][];
      int i = localObject.length - 1;
      while (i >= 0)
      {
        localObject = mStateSets;
        if (localObject[i] != null) {
          localObject = (int[])localObject[i].clone();
        } else {
          localObject = null;
        }
        arrayOfInt[i] = localObject;
        i -= 1;
      }
      mStateSets = arrayOfInt;
    }
    
    public Drawable newDrawable()
    {
      return new StateListDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new StateListDrawable(this, paramResources);
    }
  }
}
