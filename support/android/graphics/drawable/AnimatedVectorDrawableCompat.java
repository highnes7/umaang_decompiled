package support.android.graphics.drawable;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import b.b.a.K;
import b.b.m.a.c.a;
import b.b.x.n.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import support.android.v4.content.asm.Config;
import support.android.v4.content.asm.TypedArrayUtils;
import support.android.v4.internal.drawable.DrawableCompat;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;

public class AnimatedVectorDrawableCompat
  extends VectorDrawableCommon
  implements CircleDrawable
{
  public static final String ANIMATED_VECTOR = "animated-vector";
  public static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
  public static final String LOGTAG = "AnimatedVDCompat";
  public static final String TARGET = "target";
  public AnimatedVectorDrawableCompatState mAnimatedVectorState;
  public ArgbEvaluator mArgbEvaluator = null;
  public AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
  public final Drawable.Callback mCallback = new MaterialProgressDrawable.3(this);
  public android.content.Context mContext;
  public Animator.AnimatorListener mListener = null;
  public ArrayList<c.a> this$0 = null;
  
  public AnimatedVectorDrawableCompat()
  {
    this(null, null, null);
  }
  
  public AnimatedVectorDrawableCompat(android.content.Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  public AnimatedVectorDrawableCompat(android.content.Context paramContext, AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, Resources paramResources)
  {
    mContext = paramContext;
    if (paramAnimatedVectorDrawableCompatState != null)
    {
      mAnimatedVectorState = paramAnimatedVectorDrawableCompatState;
      return;
    }
    mAnimatedVectorState = new AnimatedVectorDrawableCompatState(paramContext, paramAnimatedVectorDrawableCompatState, mCallback, paramResources);
  }
  
  public static void applyTheme(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (!(paramDrawable instanceof Animatable)) {
        return;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        ((AnimatedVectorDrawable)paramDrawable).clearAnimationCallbacks();
        return;
      }
      ((AnimatedVectorDrawableCompat)paramDrawable).clearAnimationCallbacks();
    }
  }
  
  public static AnimatedVectorDrawableCompat create(android.content.Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new AnimatedVectorDrawableCompat(paramContext, null, null);
      mDelegateDrawable = Config.getDrawable(paramContext.getResources(), paramInt, paramContext.getTheme());
      mDelegateDrawable.setCallback(mCallback);
      mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(mDelegateDrawable.getConstantState());
      return localObject;
    }
    Object localObject = paramContext.getResources();
    try
    {
      localObject = ((Resources)localObject).getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2)
      {
        paramContext = createFromXmlInner(paramContext, paramContext.getResources(), (XmlPullParser)localObject, localAttributeSet, paramContext.getTheme());
        return paramContext;
      }
      paramContext = new XmlPullParserException("No start tag found");
      throw paramContext;
    }
    catch (XmlPullParserException paramContext)
    {
      return null;
    }
    catch (IOException paramContext) {}
    return null;
  }
  
  public static AnimatedVectorDrawableCompat createFromXmlInner(android.content.Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    paramContext = new AnimatedVectorDrawableCompat(paramContext, null, null);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  private void draw()
  {
    Animator.AnimatorListener localAnimatorListener = mListener;
    if (localAnimatorListener != null)
    {
      mAnimatedVectorState.animator.removeListener(localAnimatorListener);
      mListener = null;
    }
  }
  
  public static boolean draw(Drawable paramDrawable, View paramView)
  {
    if (paramDrawable != null)
    {
      if (paramView == null) {
        return false;
      }
      if (!(paramDrawable instanceof Animatable)) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 24) {
        return ((AnimatedVectorDrawable)paramDrawable).unregisterAnimationCallback(paramView.clear());
      }
      return ((AnimatedVectorDrawableCompat)paramDrawable).draw(paramView);
    }
    return false;
  }
  
  public static void setVisible(AnimatedVectorDrawable paramAnimatedVectorDrawable, View paramView)
  {
    paramAnimatedVectorDrawable.registerAnimationCallback(paramView.clear());
  }
  
  private void setupAnimatorsForTarget(String paramString, Animator paramAnimator)
  {
    paramAnimator.setTarget(mAnimatedVectorState.mVectorDrawable.getTargetByName(paramString));
    if (Build.VERSION.SDK_INT < 21) {
      setupColorAnimator(paramAnimator);
    }
    AnimatedVectorDrawableCompatState localAnimatedVectorDrawableCompatState = mAnimatedVectorState;
    if (mAnimators == null)
    {
      mAnimators = new ArrayList();
      mAnimatedVectorState.mTargetNameMap = new ArrayMap();
    }
    mAnimatedVectorState.mAnimators.add(paramAnimator);
    mAnimatedVectorState.mTargetNameMap.put(paramAnimator, paramString);
  }
  
  private void setupColorAnimator(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          setupColorAnimator((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (mArgbEvaluator == null) {
          mArgbEvaluator = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(mArgbEvaluator);
      }
    }
  }
  
  public static void start(Drawable paramDrawable, View paramView)
  {
    if (paramDrawable != null)
    {
      if (paramView == null) {
        return;
      }
      if (!(paramDrawable instanceof Animatable)) {
        return;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        ((AnimatedVectorDrawable)paramDrawable).registerAnimationCallback(paramView.clear());
        return;
      }
      ((AnimatedVectorDrawableCompat)paramDrawable).start(paramView);
    }
  }
  
  public static boolean start(AnimatedVectorDrawable paramAnimatedVectorDrawable, View paramView)
  {
    return paramAnimatedVectorDrawable.unregisterAnimationCallback(paramView.clear());
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
      return DrawableCompat.canApplyTheme(localDrawable);
    }
    return false;
  }
  
  public void clearAnimationCallbacks()
  {
    Object localObject = mDelegateDrawable;
    if (localObject != null)
    {
      ((AnimatedVectorDrawable)localObject).clearAnimationCallbacks();
      return;
    }
    draw();
    localObject = this$0;
    if (localObject == null) {
      return;
    }
    ((ArrayList)localObject).clear();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.draw(paramCanvas);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.draw(paramCanvas);
    if (mAnimatedVectorState.animator.isStarted()) {
      invalidateSelf();
    }
  }
  
  public boolean draw(View paramView)
  {
    Object localObject = mDelegateDrawable;
    if (localObject != null) {
      ((AnimatedVectorDrawable)localObject).unregisterAnimationCallback(paramView.clear());
    }
    localObject = this$0;
    boolean bool;
    if ((localObject != null) && (paramView != null))
    {
      bool = ((ArrayList)localObject).remove(paramView);
      if (this$0.size() == 0)
      {
        draw();
        return bool;
      }
    }
    else
    {
      return false;
    }
    return bool;
  }
  
  public int getAlpha()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.getAlpha(localDrawable);
    }
    return mAnimatedVectorState.mVectorDrawable.getAlpha();
  }
  
  public int getChangingConfigurations()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | mAnimatedVectorState.mChangingConfigurations;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    Drawable localDrawable = mDelegateDrawable;
    if ((localDrawable != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new AnimatedVectorDrawableDelegateState(localDrawable.getConstantState());
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return mAnimatedVectorState.mVectorDrawable.getOpacity();
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    Object localObject1 = mDelegateDrawable;
    if (localObject1 != null)
    {
      DrawableCompat.inflate((Drawable)localObject1, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    int j = paramXmlPullParser.getDepth();
    while ((i != 1) && ((paramXmlPullParser.getDepth() >= j + 1) || (i != 3)))
    {
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        Object localObject2;
        Object localObject3;
        if ("animated-vector".equals(localObject1))
        {
          localObject1 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.raw.styleable_AnimatedVectorDrawable);
          i = ((TypedArray)localObject1).getResourceId(0, 0);
          if (i != 0)
          {
            localObject2 = VectorDrawableCompat.create(paramResources, i, paramTheme);
            ((VectorDrawableCompat)localObject2).setAllowCaching(false);
            ((Drawable)localObject2).setCallback(mCallback);
            localObject3 = mAnimatedVectorState.mVectorDrawable;
            if (localObject3 != null) {
              ((Drawable)localObject3).setCallback(null);
            }
            mAnimatedVectorState.mVectorDrawable = ((VectorDrawableCompat)localObject2);
          }
          ((TypedArray)localObject1).recycle();
        }
        else if ("target".equals(localObject1))
        {
          localObject1 = paramResources.obtainAttributes(paramAttributeSet, R.raw.styleable_AnimatedVectorDrawableTarget);
          localObject2 = ((TypedArray)localObject1).getString(0);
          i = ((TypedArray)localObject1).getResourceId(1, 0);
          if (i != 0)
          {
            localObject3 = mContext;
            if (localObject3 != null)
            {
              setupAnimatorsForTarget((String)localObject2, Context.getDrawable((android.content.Context)localObject3, i));
            }
            else
            {
              ((TypedArray)localObject1).recycle();
              throw new IllegalStateException("Context can't be null when inflating animators");
            }
          }
          ((TypedArray)localObject1).recycle();
        }
      }
      i = paramXmlPullParser.next();
    }
    mAnimatedVectorState.start();
  }
  
  public boolean isAutoMirrored()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return DrawableCompat.isAutoMirrored(localDrawable);
    }
    return mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
  }
  
  public boolean isRunning()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return ((AnimatedVectorDrawable)localDrawable).isRunning();
    }
    return mAnimatedVectorState.animator.isRunning();
  }
  
  public boolean isStateful()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.isStateful();
    }
    return mAnimatedVectorState.mVectorDrawable.isStateful();
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      localDrawable.mutate();
    }
    return this;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramRect);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setBounds(paramRect);
  }
  
  public boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return mAnimatedVectorState.mVectorDrawable.setLevel(paramInt);
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    return mAnimatedVectorState.mVectorDrawable.setState(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setAlpha(paramInt);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setAutoMirrored(localDrawable, paramBoolean);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setAutoMirrored(paramBoolean);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setColorFilter(paramColorFilter);
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
    mAnimatedVectorState.mVectorDrawable.setTint(paramInt);
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setTintList(localDrawable, paramColorStateList);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setTintList(paramColorStateList);
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      DrawableCompat.setTintMode(localDrawable, paramMode);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    mAnimatedVectorState.mVectorDrawable.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void start()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).start();
      return;
    }
    if (mAnimatedVectorState.animator.isStarted()) {
      return;
    }
    mAnimatedVectorState.animator.start();
    invalidateSelf();
  }
  
  public void start(View paramView)
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).registerAnimationCallback(paramView.clear());
      return;
    }
    if (paramView == null) {
      return;
    }
    if (this$0 == null) {
      this$0 = new ArrayList();
    }
    if (this$0.contains(paramView)) {
      return;
    }
    this$0.add(paramView);
    if (mListener == null) {
      mListener = new MainActivity.29(this);
    }
    mAnimatedVectorState.animator.addListener(mListener);
  }
  
  public void stop()
  {
    Drawable localDrawable = mDelegateDrawable;
    if (localDrawable != null)
    {
      ((AnimatedVectorDrawable)localDrawable).stop();
      return;
    }
    mAnimatedVectorState.animator.end();
  }
  
  public class AnimatedVectorDrawableCompatState
    extends Drawable.ConstantState
  {
    public AnimatorSet animator;
    public ArrayList<Animator> mAnimators;
    public int mChangingConfigurations;
    public b<Animator, String> mTargetNameMap;
    public VectorDrawableCompat mVectorDrawable;
    
    public AnimatedVectorDrawableCompatState(AnimatedVectorDrawableCompatState paramAnimatedVectorDrawableCompatState, Drawable.Callback paramCallback, Resources paramResources)
    {
      if (paramAnimatedVectorDrawableCompatState != null)
      {
        mChangingConfigurations = mChangingConfigurations;
        this$1 = mVectorDrawable;
        int i = 0;
        if (this$1 != null)
        {
          this$1 = this$1.getConstantState();
          if (paramResources != null) {
            mVectorDrawable = ((VectorDrawableCompat)this$1.newDrawable(paramResources));
          } else {
            mVectorDrawable = ((VectorDrawableCompat)this$1.newDrawable());
          }
          mVectorDrawable = ((VectorDrawableCompat)mVectorDrawable.mutate());
          mVectorDrawable.setCallback(paramCallback);
          mVectorDrawable.setBounds(mVectorDrawable.getBounds());
          mVectorDrawable.setAllowCaching(false);
        }
        this$1 = mAnimators;
        if (this$1 != null)
        {
          int j = this$1.size();
          mAnimators = new ArrayList(j);
          mTargetNameMap = new ArrayMap(j);
          while (i < j)
          {
            paramCallback = (Animator)mAnimators.get(i);
            this$1 = paramCallback.clone();
            paramCallback = (String)mTargetNameMap.get(paramCallback);
            this$1.setTarget(mVectorDrawable.getTargetByName(paramCallback));
            mAnimators.add(this$1);
            mTargetNameMap.put(this$1, paramCallback);
            i += 1;
          }
          start();
        }
      }
    }
    
    public int getChangingConfigurations()
    {
      return mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 24.");
    }
    
    public void start()
    {
      if (animator == null) {
        animator = new AnimatorSet();
      }
      animator.playTogether(mAnimators);
    }
  }
  
  @K(24)
  public class AnimatedVectorDrawableDelegateState
    extends Drawable.ConstantState
  {
    public AnimatedVectorDrawableDelegateState() {}
    
    public boolean canApplyTheme()
    {
      return AnimatedVectorDrawableCompat.this.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return AnimatedVectorDrawableCompat.this.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
      mDelegateDrawable = AnimatedVectorDrawableCompat.this.newDrawable();
      mDelegateDrawable.setCallback(mCallback);
      return localAnimatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
      mDelegateDrawable = AnimatedVectorDrawableCompat.this.newDrawable(paramResources);
      mDelegateDrawable.setCallback(mCallback);
      return localAnimatedVectorDrawableCompat;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(null, null, null);
      mDelegateDrawable = AnimatedVectorDrawableCompat.this.newDrawable(paramResources, paramTheme);
      mDelegateDrawable.setCallback(mCallback);
      return localAnimatedVectorDrawableCompat;
    }
  }
}
