package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import support.android.asm.Contact;
import support.android.asm.Edit;
import support.android.asm.Frame;
import support.android.asm.GA;
import support.android.asm.MaterialRippleLayout.5;
import support.android.asm.R.id;
import support.android.asm.R.styleable;
import support.android.asm.ScrollingTabContainerView.VisibilityAnimListener;
import support.android.asm.UnivariatePeriodicInterpolator;
import support.android.asm.ValueAnimatorCompat;
import support.android.asm.b;
import support.android.asm.f;
import support.android.asm.k;
import support.android.asm.l;
import support.android.v4.content.asm.TypedArrayUtils;
import support.android.v4.view.ViewCompat;

public class ChangeTransform
  extends Transition
{
  public static final String ACTION_SHOW_PLAYER = "android:changeTransform:matrix";
  public static final String ACTION_UPDATE_ALL = "android:changeTransform:intermediateParentMatrix";
  public static final String EVENTLOG_URL = "android:changeTransform:transforms";
  public static final String EXTRA_LOCALE = "android:changeTransform:parentMatrix";
  public static final String FRAG_TAG_TIME_PICKER = "android:changeTransform:intermediateMatrix";
  public static final String PAGE_KEY = "android:changeTransform:parent";
  public static final Property<b, float[]> a;
  public static final Property<b, PointF> c;
  public static final boolean l;
  public static final String[] s = { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
  public boolean b = true;
  public boolean g = true;
  public Matrix m = new Matrix();
  
  static
  {
    a = new Contact([F.class, "nonTranslations");
    c = new MaterialRippleLayout.5(PointF.class, "translations");
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    l = bool;
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Toolbar);
    paramAttributeSet = (XmlPullParser)paramAttributeSet;
    b = TypedArrayUtils.getBoolean(paramContext, paramAttributeSet, "reparentWithOverlay", 1, true);
    g = TypedArrayUtils.getBoolean(paramContext, paramAttributeSet, "reparent", 0, true);
    paramContext.recycle();
  }
  
  private void add(Edit paramEdit1, Edit paramEdit2)
  {
    Matrix localMatrix1 = (Matrix)values.get("android:changeTransform:parentMatrix");
    view.setTag(R.id.parent_matrix, localMatrix1);
    Matrix localMatrix2 = m;
    localMatrix2.reset();
    localMatrix1.invert(localMatrix2);
    localMatrix1 = (Matrix)values.get("android:changeTransform:matrix");
    paramEdit2 = localMatrix1;
    if (localMatrix1 == null)
    {
      paramEdit2 = new Matrix();
      values.put("android:changeTransform:matrix", paramEdit2);
    }
    paramEdit2.postConcat((Matrix)values.get("android:changeTransform:parentMatrix"));
    paramEdit2.postConcat(localMatrix2);
  }
  
  private void captureValues(Edit paramEdit)
  {
    View localView = view;
    if (localView.getVisibility() == 8) {
      return;
    }
    values.put("android:changeTransform:parent", localView.getParent());
    Object localObject = new c(localView);
    values.put("android:changeTransform:transforms", localObject);
    localObject = localView.getMatrix();
    if ((localObject != null) && (!((Matrix)localObject).isIdentity())) {
      localObject = new Matrix((Matrix)localObject);
    } else {
      localObject = null;
    }
    values.put("android:changeTransform:matrix", localObject);
    if (g)
    {
      localObject = new Matrix();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Frame.a.b(localViewGroup, (Matrix)localObject);
      ((Matrix)localObject).preTranslate(-localViewGroup.getScrollX(), -localViewGroup.getScrollY());
      values.put("android:changeTransform:parentMatrix", localObject);
      values.put("android:changeTransform:intermediateMatrix", localView.getTag(R.id.transition_transform));
      values.put("android:changeTransform:intermediateParentMatrix", localView.getTag(R.id.parent_matrix));
    }
  }
  
  private void onCreate(ViewGroup paramViewGroup, Edit paramEdit1, Edit paramEdit2)
  {
    View localView = view;
    Object localObject = new Matrix((Matrix)values.get("android:changeTransform:parentMatrix"));
    Frame.a.draw(paramViewGroup, (Matrix)localObject);
    b localB = k.a(localView, paramViewGroup, (Matrix)localObject);
    if (localB == null) {
      return;
    }
    localB.a((ViewGroup)values.get("android:changeTransform:parent"), view);
    for (paramViewGroup = this;; paramViewGroup = (ViewGroup)localObject)
    {
      localObject = mParent;
      if (localObject == null) {
        break;
      }
    }
    paramViewGroup.addListener(new a(localView, localB));
    if (l)
    {
      paramViewGroup = view;
      if (paramViewGroup != view) {
        Frame.a.a(paramViewGroup, 0.0F);
      }
      Frame.a.a(localView, 1.0F);
    }
  }
  
  private boolean previous(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    if ((isValidTarget(paramViewGroup1)) && (isValidTarget(paramViewGroup2)))
    {
      paramViewGroup1 = getMatchedTransitionValues(paramViewGroup1, true);
      if ((paramViewGroup1 == null) || (paramViewGroup2 != view)) {}
    }
    else
    {
      while (paramViewGroup1 == paramViewGroup2) {
        return true;
      }
    }
    return false;
  }
  
  public static void set(View paramView)
  {
    setValue(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public static void setValue(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    ViewCompat.postInvalidateOnAnimation(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  private ObjectAnimator start(Edit paramEdit1, Edit paramEdit2, boolean paramBoolean)
  {
    paramEdit1 = (Matrix)values.get("android:changeTransform:matrix");
    Object localObject2 = (Matrix)values.get("android:changeTransform:matrix");
    Object localObject1 = paramEdit1;
    if (paramEdit1 == null) {
      localObject1 = GA.values;
    }
    paramEdit1 = (Edit)localObject2;
    if (localObject2 == null) {
      paramEdit1 = GA.values;
    }
    if (((Matrix)localObject1).equals(paramEdit1)) {
      return null;
    }
    localObject2 = (c)values.get("android:changeTransform:transforms");
    paramEdit2 = view;
    set(paramEdit2);
    Object localObject3 = new float[9];
    ((Matrix)localObject1).getValues((float[])localObject3);
    float[] arrayOfFloat = new float[9];
    paramEdit1.getValues(arrayOfFloat);
    localObject1 = new b(paramEdit2, (float[])localObject3);
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofObject(a, new UnivariatePeriodicInterpolator(new float[9]), new float[][] { localObject3, arrayOfFloat });
    localObject3 = getPathMotion().draw(localObject3[2], localObject3[5], arrayOfFloat[2], arrayOfFloat[5]);
    localObject3 = ObjectAnimator.ofPropertyValuesHolder(localObject1, new PropertyValuesHolder[] { localPropertyValuesHolder, ValueAnimatorCompat.ofFloat(c, (Path)localObject3) });
    paramEdit1 = new ScrollingTabContainerView.VisibilityAnimListener(this, paramBoolean, paramEdit1, paramEdit2, (c)localObject2, (b)localObject1);
    ((Animator)localObject3).addListener(paramEdit1);
    int i = Build.VERSION.SDK_INT;
    ((Animator)localObject3).addPauseListener(paramEdit1);
    return localObject3;
  }
  
  public void b(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public boolean b()
  {
    return g;
  }
  
  public void captureEndValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    captureValues(paramEdit);
    if (!l) {
      ((ViewGroup)view.getParent()).startViewTransition(view);
    }
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, Edit paramEdit1, Edit paramEdit2)
  {
    Object localObject;
    if ((paramEdit1 != null) && (paramEdit2 != null) && (values.containsKey("android:changeTransform:parent")) && (values.containsKey("android:changeTransform:parent")))
    {
      ViewGroup localViewGroup = (ViewGroup)values.get("android:changeTransform:parent");
      localObject = (ViewGroup)values.get("android:changeTransform:parent");
      boolean bool;
      if ((g) && (!previous(localViewGroup, (ViewGroup)localObject))) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = (Matrix)values.get("android:changeTransform:intermediateMatrix");
      if (localObject != null) {
        values.put("android:changeTransform:matrix", localObject);
      }
      localObject = (Matrix)values.get("android:changeTransform:intermediateParentMatrix");
      if (localObject != null) {
        values.put("android:changeTransform:parentMatrix", localObject);
      }
      if (bool) {
        add(paramEdit1, paramEdit2);
      }
      localObject = start(paramEdit1, paramEdit2, bool);
      if ((bool) && (localObject != null) && (b))
      {
        onCreate(paramViewGroup, paramEdit1, paramEdit2);
        return localObject;
      }
      if (!l)
      {
        localViewGroup.endViewTransition(view);
        return localObject;
      }
    }
    else
    {
      return null;
    }
    return localObject;
  }
  
  public String[] getTransitionProperties()
  {
    return s;
  }
  
  public void goTo(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public boolean n()
  {
    return b;
  }
  
  private static class a
    extends f
  {
    public b c;
    public View v;
    
    public a(View paramView, b paramB)
    {
      v = paramView;
      c = paramB;
    }
    
    public void a(Transition paramTransition)
    {
      paramTransition.removeListener(this);
      k.a(v);
      v.setTag(R.id.transition_transform, null);
      v.setTag(R.id.parent_matrix, null);
    }
    
    public void b(Transition paramTransition)
    {
      c.setVisibility(4);
    }
    
    public void c(Transition paramTransition)
    {
      c.setVisibility(0);
    }
  }
  
  private static class b
  {
    public float e;
    public final Matrix m = new Matrix();
    public float n;
    public final float[] v;
    public final View w;
    
    public b(View paramView, float[] paramArrayOfFloat)
    {
      w = paramView;
      v = ((float[])paramArrayOfFloat.clone());
      paramView = v;
      e = paramView[2];
      n = paramView[5];
      a();
    }
    
    private void a()
    {
      Object localObject = v;
      localObject[2] = e;
      localObject[5] = n;
      m.setValues((float[])localObject);
      localObject = w;
      Matrix localMatrix = m;
      Frame.a.a((View)localObject, localMatrix);
    }
    
    public void a(PointF paramPointF)
    {
      e = x;
      n = y;
      a();
    }
    
    public Matrix get()
    {
      return m;
    }
    
    public void visitFrame(float[] paramArrayOfFloat)
    {
      System.arraycopy(paramArrayOfFloat, 0, v, 0, paramArrayOfFloat.length);
      a();
    }
  }
  
  private static class c
  {
    public final float a;
    public final float b;
    public final float black;
    public final float cyan;
    public final float g;
    public final float magenta;
    public final float r;
    public final float yellow;
    
    public c(View paramView)
    {
      a = paramView.getTranslationX();
      r = paramView.getTranslationY();
      g = ViewCompat.setElevation(paramView);
      b = paramView.getScaleX();
      cyan = paramView.getScaleY();
      magenta = paramView.getRotationX();
      yellow = paramView.getRotationY();
      black = paramView.getRotation();
    }
    
    public void equals(View paramView)
    {
      ChangeTransform.setValue(paramView, a, r, g, b, cyan, magenta, yellow, black);
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      return (a == a) && (r == r) && (g == g) && (b == b) && (cyan == cyan) && (magenta == magenta) && (yellow == yellow) && (black == black);
    }
    
    public int hashCode()
    {
      float f = a;
      int i3 = 0;
      int i;
      if (f != 0.0F) {
        i = Float.floatToIntBits(f);
      } else {
        i = 0;
      }
      f = r;
      int j;
      if (f != 0.0F) {
        j = Float.floatToIntBits(f);
      } else {
        j = 0;
      }
      f = g;
      int k;
      if (f != 0.0F) {
        k = Float.floatToIntBits(f);
      } else {
        k = 0;
      }
      f = b;
      int m;
      if (f != 0.0F) {
        m = Float.floatToIntBits(f);
      } else {
        m = 0;
      }
      f = cyan;
      int n;
      if (f != 0.0F) {
        n = Float.floatToIntBits(f);
      } else {
        n = 0;
      }
      f = magenta;
      int i1;
      if (f != 0.0F) {
        i1 = Float.floatToIntBits(f);
      } else {
        i1 = 0;
      }
      f = yellow;
      int i2;
      if (f != 0.0F) {
        i2 = Float.floatToIntBits(f);
      } else {
        i2 = 0;
      }
      f = black;
      if (f != 0.0F) {
        i3 = Float.floatToIntBits(f);
      }
      return ((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
    }
  }
}
