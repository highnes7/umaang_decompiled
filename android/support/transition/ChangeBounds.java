package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import support.android.asm.AnimatorSet.1;
import support.android.asm.CircularProgressDrawable.1;
import support.android.asm.CircularProgressDrawable.2;
import support.android.asm.Edit;
import support.android.asm.Frame;
import support.android.asm.GlowPadView.4;
import support.android.asm.MaterialRippleLayout.1;
import support.android.asm.MaterialRippleLayout.4;
import support.android.asm.MethodWriter;
import support.android.asm.Node;
import support.android.asm.R.styleable;
import support.android.asm.RefList;
import support.android.asm.TextLabelWidget;
import support.android.asm.Type;
import support.android.asm.ValueAnimatorCompat;
import support.android.asm.a;
import support.android.asm.l;
import support.android.asm.p;
import support.android.asm.x;
import support.android.v4.content.asm.TypedArrayUtils;
import support.android.v4.view.ViewCompat;

public class ChangeBounds
  extends Transition
{
  public static final String ACTION_ERROR = "android:changeBounds:windowY";
  public static final Property<View, PointF> Archive = new RefList(PointF.class, "position");
  public static final String CANCEL_MENU = "android:changeBounds:parent";
  public static final Property<a, PointF> DEFAULT_ANIMATOR_CREATOR;
  public static final Property<View, PointF> DEFAULT_DELEGATE;
  public static final String EVENTLOG_URL = "android:changeBounds:windowX";
  public static final Property<View, PointF> Favorite;
  public static final Property<a, PointF> IMPL;
  public static final String MODULE_PACKAGE = "android:changeBounds:clip";
  public static final String PAGE_KEY = "android:changeBounds:bounds";
  public static final Property<Drawable, PointF> TRANSFORM;
  public static final String[] suVersion = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  public static Node view = new Node();
  public boolean added = false;
  public boolean contact = false;
  public int[] values = new int[2];
  
  static
  {
    TRANSFORM = new a(PointF.class, "boundsOrigin");
    DEFAULT_ANIMATOR_CREATOR = new CircularProgressDrawable.1(PointF.class, "topLeft");
    IMPL = new MaterialRippleLayout.1(PointF.class, "bottomRight");
    DEFAULT_DELEGATE = new MaterialRippleLayout.4(PointF.class, "bottomRight");
    Favorite = new CircularProgressDrawable.2(PointF.class, "topLeft");
  }
  
  public ChangeBounds() {}
  
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Spinner);
    boolean bool = TypedArrayUtils.getBoolean(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    start(bool);
  }
  
  private void captureValues(Edit paramEdit)
  {
    View localView = view;
    if ((ViewCompat.isLaidOut(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      values.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      values.put("android:changeBounds:parent", view.getParent());
      if (contact)
      {
        view.getLocationInWindow(values);
        values.put("android:changeBounds:windowX", Integer.valueOf(values[0]));
        values.put("android:changeBounds:windowY", Integer.valueOf(values[1]));
      }
      if (added) {
        values.put("android:changeBounds:clip", ViewCompat.create(localView));
      }
    }
  }
  
  private boolean update(View paramView1, View paramView2)
  {
    if (contact)
    {
      Edit localEdit = getMatchedTransitionValues(paramView1, true);
      if (localEdit == null) {
        if (paramView1 == paramView2) {
          return true;
        }
      }
      while (paramView2 != view) {
        return false;
      }
    }
    return true;
  }
  
  public void captureEndValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    captureValues(paramEdit);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, Edit paramEdit1, Edit paramEdit2)
  {
    if ((paramEdit1 != null) && (paramEdit2 != null))
    {
      Object localObject2 = values;
      Object localObject1 = values;
      localObject2 = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
      Object localObject3 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
      if ((localObject2 != null) && (localObject3 != null))
      {
        localObject1 = view;
        int k;
        int m;
        int j;
        int i;
        if (update((View)localObject2, (View)localObject3))
        {
          paramViewGroup = (Rect)values.get("android:changeBounds:bounds");
          localObject2 = (Rect)values.get("android:changeBounds:bounds");
          k = left;
          m = left;
          int n = top;
          int i1 = top;
          int i2 = right;
          int i3 = right;
          int i4 = bottom;
          int i5 = bottom;
          int i6 = i2 - k;
          int i7 = i4 - n;
          int i8 = i3 - m;
          int i9 = i5 - i1;
          localObject3 = (Rect)values.get("android:changeBounds:clip");
          localObject2 = (Rect)values.get("android:changeBounds:clip");
          if (((i6 != 0) && (i7 != 0)) || ((i8 != 0) && (i9 != 0)))
          {
            if ((k == m) && (n == i1)) {
              j = 0;
            } else {
              j = 1;
            }
            if (i2 == i3)
            {
              i = j;
              if (i4 == i5) {}
            }
            else
            {
              i = j + 1;
            }
          }
          else
          {
            i = 0;
          }
          if ((localObject3 == null) || (((Rect)localObject3).equals(localObject2)))
          {
            j = i;
            if (localObject3 == null)
            {
              j = i;
              if (localObject2 == null) {}
            }
          }
          else
          {
            j = i + 1;
          }
          if (j > 0)
          {
            if (!added)
            {
              Frame.set((View)localObject1, k, n, i2, i4);
              if (j == 2)
              {
                if ((i6 == i8) && (i7 == i9))
                {
                  paramViewGroup = getPathMotion().draw(k, n, m, i1);
                  paramViewGroup = support.android.asm.PropertyValuesHolder.ofFloat(localObject1, Archive, paramViewGroup);
                }
                else
                {
                  paramEdit1 = new a((View)localObject1);
                  paramViewGroup = getPathMotion().draw(k, n, m, i1);
                  paramEdit2 = support.android.asm.PropertyValuesHolder.ofFloat(paramEdit1, DEFAULT_ANIMATOR_CREATOR, paramViewGroup);
                  paramViewGroup = getPathMotion().draw(i2, i4, i3, i5);
                  localObject2 = support.android.asm.PropertyValuesHolder.ofFloat(paramEdit1, IMPL, paramViewGroup);
                  paramViewGroup = new AnimatorSet();
                  paramViewGroup.playTogether(new Animator[] { paramEdit2, localObject2 });
                  paramViewGroup.addListener(new TextLabelWidget(this, paramEdit1));
                }
              }
              else if ((k == m) && (n == i1))
              {
                paramViewGroup = getPathMotion().draw(i2, i4, i3, i5);
                paramViewGroup = support.android.asm.PropertyValuesHolder.ofFloat(localObject1, DEFAULT_DELEGATE, paramViewGroup);
              }
              else
              {
                paramViewGroup = getPathMotion().draw(k, n, m, i1);
                paramViewGroup = support.android.asm.PropertyValuesHolder.ofFloat(localObject1, Favorite, paramViewGroup);
              }
            }
            else
            {
              Frame.set((View)localObject1, k, n, Math.max(i6, i8) + k, Math.max(i7, i9) + n);
              if ((k == m) && (n == i1))
              {
                paramViewGroup = null;
              }
              else
              {
                paramViewGroup = getPathMotion().draw(k, n, m, i1);
                paramViewGroup = support.android.asm.PropertyValuesHolder.ofFloat(localObject1, Archive, paramViewGroup);
              }
              paramEdit1 = (Edit)localObject3;
              if (localObject3 == null) {
                paramEdit1 = new Rect(0, 0, i6, i7);
              }
              if (localObject2 == null) {
                paramEdit2 = new Rect(0, 0, i8, i9);
              } else {
                paramEdit2 = (Edit)localObject2;
              }
              if (!paramEdit1.equals(paramEdit2))
              {
                ViewCompat.get((View)localObject1, paramEdit1);
                paramEdit2 = ObjectAnimator.ofObject(localObject1, "clipBounds", view, new Object[] { paramEdit1, paramEdit2 });
                paramEdit1 = paramEdit2;
                paramEdit2.addListener(new AnimatorSet.1(this, (View)localObject1, (Rect)localObject2, m, i1, i3, i5));
              }
              else
              {
                paramEdit1 = null;
              }
              paramViewGroup = Type.loadAnimator(paramViewGroup, paramEdit1);
            }
            if (!(((View)localObject1).getParent() instanceof ViewGroup)) {
              return paramViewGroup;
            }
            paramEdit1 = (ViewGroup)((View)localObject1).getParent();
            i = Build.VERSION.SDK_INT;
            MethodWriter.a(paramEdit1, true);
            addListener(new p(this, paramEdit1));
            return paramViewGroup;
          }
        }
        else
        {
          i = ((Integer)values.get("android:changeBounds:windowX")).intValue();
          j = ((Integer)values.get("android:changeBounds:windowY")).intValue();
          k = ((Integer)values.get("android:changeBounds:windowX")).intValue();
          m = ((Integer)values.get("android:changeBounds:windowY")).intValue();
          if ((i != k) || (j != m)) {
            break label957;
          }
        }
        return null;
        label957:
        paramViewGroup.getLocationInWindow(values);
        paramEdit1 = Bitmap.createBitmap(((View)localObject1).getWidth(), ((View)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        ((View)localObject1).draw(new Canvas(paramEdit1));
        paramEdit1 = new BitmapDrawable(paramEdit1);
        float f = Frame.d((View)localObject1);
        Frame.a.a((View)localObject1, 0.0F);
        Frame.a(paramViewGroup).a(paramEdit1);
        paramEdit2 = getPathMotion();
        localObject2 = values;
        paramEdit2 = paramEdit2.draw(i - localObject2[0], j - localObject2[1], k - localObject2[0], m - localObject2[1]);
        paramEdit2 = ObjectAnimator.ofPropertyValuesHolder(paramEdit1, new android.animation.PropertyValuesHolder[] { ValueAnimatorCompat.ofFloat(TRANSFORM, paramEdit2) });
        paramEdit2.addListener(new GlowPadView.4(this, paramViewGroup, paramEdit1, (View)localObject1, f));
        return paramEdit2;
      }
    }
    return null;
    return paramViewGroup;
  }
  
  public String[] getTransitionProperties()
  {
    return suVersion;
  }
  
  public boolean isAdded()
  {
    return added;
  }
  
  public void start(boolean paramBoolean)
  {
    added = paramBoolean;
  }
  
  private static class a
  {
    public int h;
    public View i;
    public int j;
    public int k;
    public int l;
    public int o;
    public int w;
    
    public a(View paramView)
    {
      i = paramView;
    }
    
    private void a()
    {
      Frame.set(i, h, k, w, l);
      o = 0;
      j = 0;
    }
    
    public void a(PointF paramPointF)
    {
      h = Math.round(x);
      k = Math.round(y);
      o += 1;
      if (o == j) {
        a();
      }
    }
    
    public void b(PointF paramPointF)
    {
      w = Math.round(x);
      l = Math.round(y);
      j += 1;
      if (o == j) {
        a();
      }
    }
  }
}
