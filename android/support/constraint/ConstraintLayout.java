package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import support.android.view.ClassWriter;
import support.android.view.JsonReader.1;
import support.android.view.asm.asm.ByteVector;
import support.android.view.asm.asm.Integer;
import support.android.view.asm.asm.Label;
import support.android.view.asm.asm.XLayoutStyle;
import support.android.view.asm.asm.c;
import support.android.view.asm.asm.d;
import support.android.view.asm.asm.i;

public class ConstraintLayout
  extends ViewGroup
{
  public static final String ACTION_UPDATE_ALL = "ConstraintLayout";
  public static final boolean IS_ICS = false;
  public static final String PAGE_KEY = "ConstraintLayout-1.0.0";
  public static final boolean TYPE_EXPANDED = true;
  public int a = 2;
  public support.android.view.asm.asm.f b = new support.android.view.asm.asm.f();
  public int f = 0;
  public int h = 0;
  public int k = Integer.MAX_VALUE;
  public int p = Integer.MAX_VALUE;
  public ClassWriter q = null;
  public SparseArray<View> v = new SparseArray();
  public boolean w = true;
  public final ArrayList<b.b.d.a.a.f> x = new ArrayList(100);
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private final i a(int paramInt)
  {
    if (paramInt == 0) {
      return b;
    }
    View localView = (View)v.get(paramInt);
    if (localView == this) {
      return b;
    }
    if (localView == null) {
      return null;
    }
    return getLayoutParamsa;
  }
  
  private final i a(View paramView)
  {
    if (paramView == this) {
      return b;
    }
    if (paramView == null) {
      return null;
    }
    return getLayoutParamsa;
  }
  
  private void a()
  {
    int n = getChildCount();
    int m = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = m;
      if (i >= n) {
        break;
      }
      if (getChildAt(i).isLayoutRequested())
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j != 0)
    {
      x.clear();
      run();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = i;
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    Integer localInteger1 = Integer.data;
    getLayoutParams();
    if (i1 != Integer.MIN_VALUE)
    {
      if (i1 != 0) {
        if (i1 == 1073741824) {}
      }
      for (localInteger2 = localInteger1;; localInteger2 = Integer.p)
      {
        paramInt1 = 0;
        break;
        paramInt1 = Math.min(k, paramInt1) - (i3 + i2);
        localInteger2 = localInteger1;
        break;
      }
    }
    Integer localInteger2 = Integer.p;
    if (j != Integer.MIN_VALUE)
    {
      if (j != 0) {
        if (j == 1073741824) {}
      }
      for (;;)
      {
        paramInt2 = 0;
        break;
        paramInt2 = Math.min(p, i) - (n + m);
        break;
        localInteger1 = Integer.p;
      }
    }
    localInteger1 = Integer.p;
    b.g(0);
    b.l(0);
    b.a(localInteger2);
    b.get(paramInt1);
    b.add(localInteger1);
    b.append(paramInt2);
    b.g(f - getPaddingLeft() - getPaddingRight());
    b.l(h - getPaddingTop() - getPaddingBottom());
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    b.a(this);
    v.put(getId(), this);
    q = null;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, JsonReader.1.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int m = paramAttributeSet.getIndex(i);
        if (m == JsonReader.1.ConstraintLayout_Layout_android_minWidth)
        {
          f = paramAttributeSet.getDimensionPixelOffset(m, f);
        }
        else if (m == JsonReader.1.ConstraintLayout_Layout_android_minHeight)
        {
          h = paramAttributeSet.getDimensionPixelOffset(m, h);
        }
        else if (m == JsonReader.1.ConstraintLayout_Layout_android_maxWidth)
        {
          k = paramAttributeSet.getDimensionPixelOffset(m, k);
        }
        else if (m == JsonReader.1.ConstraintLayout_Layout_android_maxHeight)
        {
          p = paramAttributeSet.getDimensionPixelOffset(m, p);
        }
        else if (m == JsonReader.1.ConstraintLayout_Layout_layout_optimizationLevel)
        {
          a = paramAttributeSet.getInt(m, a);
        }
        else if (m == JsonReader.1.ConstraintLayout_Layout_constraintSet)
        {
          m = paramAttributeSet.getResourceId(m, 0);
          q = new ClassWriter();
          q.a(getContext(), m);
        }
        i += 1;
      }
      paramAttributeSet.recycle();
    }
    b.f(a);
  }
  
  private void measureHorizontal(int paramInt1, int paramInt2)
  {
    int i = getPaddingTop();
    int i3 = getPaddingBottom() + i;
    i = getPaddingLeft();
    int i4 = getPaddingRight() + i;
    int i5 = getChildCount();
    int m = 0;
    while (m < i5)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i localI = a;
        if (!x)
        {
          int i1 = width;
          int i2 = height;
          boolean bool = width;
          int j = 1;
          if ((!bool) && (!height) && ((bool) || (description != 1)) && (width != -1) && ((height) || ((max != 1) && (height != -1)))) {
            i = 0;
          } else {
            i = 1;
          }
          int n;
          if (i != 0)
          {
            if ((i1 != 0) && (i1 != -1))
            {
              n = ViewGroup.getChildMeasureSpec(paramInt1, i4, i1);
              i = 0;
            }
            else
            {
              n = ViewGroup.getChildMeasureSpec(paramInt1, i4, -2);
              i = 1;
            }
            if ((i2 != 0) && (i2 != -1))
            {
              i1 = ViewGroup.getChildMeasureSpec(paramInt2, i3, i2);
              j = 0;
            }
            else
            {
              i1 = ViewGroup.getChildMeasureSpec(paramInt2, i3, -2);
            }
            localView.measure(n, i1);
            i1 = localView.getMeasuredWidth();
            n = localView.getMeasuredHeight();
          }
          else
          {
            i = 0;
            j = 0;
            n = i2;
          }
          localI.get(i1);
          localI.append(n);
          if (i != 0) {
            localI.set(i1);
          }
          if (j != 0) {
            localI.clear(n);
          }
          if (weight)
          {
            i = localView.getBaseline();
            if (i != -1) {
              localI.e(i);
            }
          }
        }
      }
      m += 1;
    }
  }
  
  private void run()
  {
    Object localObject1 = q;
    if (localObject1 != null) {
      ((ClassWriter)localObject1).run(this);
    }
    int j = getChildCount();
    b.setEnabled();
    int i = 0;
    while (i < j)
    {
      Object localObject3 = getChildAt(i);
      Object localObject2 = a((View)localObject3);
      if (localObject2 != null)
      {
        do
        {
          for (;;)
          {
            localObject1 = (LayoutParams)((View)localObject3).getLayoutParams();
            ((i)localObject2).init();
            ((i)localObject2).getItem(((View)localObject3).getVisibility());
            ((i)localObject2).a(localObject3);
            b.close((i)localObject2);
            if ((!height) || (!width)) {
              x.add(localObject2);
            }
            if (!x) {
              break;
            }
            localObject2 = (ByteVector)localObject2;
            m = h;
            if (m != -1) {
              ((ByteVector)localObject2).b(m);
            }
            m = m;
            if (m != -1) {
              ((ByteVector)localObject2).write(m);
            }
            f1 = i;
            if (f1 != -1.0F) {
              ((ByteVector)localObject2).write(f1);
            }
          }
        } while ((type == -1) && (position == -1) && (size == -1) && (offset == -1) && (n == -1) && (e == -1) && (d == -1) && (f == -1) && (c == -1) && (flags == -1) && (min == -1) && (width != -1) && (height != -1));
        int m = type;
        int n = position;
        int i1 = size;
        int i2 = offset;
        int i3 = g;
        int i4 = p;
        float f1 = l;
        int i5 = Build.VERSION.SDK_INT;
        Object localObject4;
        if (m != -1)
        {
          localObject3 = a(m);
          if (localObject3 != null)
          {
            localObject4 = c.a;
            ((i)localObject2).a((c)localObject4, (i)localObject3, (c)localObject4, leftMargin, i3);
          }
        }
        else if (n != -1)
        {
          localObject3 = a(n);
          if (localObject3 != null) {
            ((i)localObject2).a(c.a, (i)localObject3, c.c, leftMargin, i3);
          }
        }
        if (i1 != -1)
        {
          localObject3 = a(i1);
          if (localObject3 != null) {
            ((i)localObject2).a(c.c, (i)localObject3, c.a, rightMargin, i4);
          }
        }
        else if (i2 != -1)
        {
          localObject3 = a(i2);
          if (localObject3 != null)
          {
            localObject4 = c.c;
            ((i)localObject2).a((c)localObject4, (i)localObject3, (c)localObject4, rightMargin, i4);
          }
        }
        m = n;
        if (m != -1)
        {
          localObject3 = a(m);
          if (localObject3 != null)
          {
            localObject4 = c.d;
            ((i)localObject2).a((c)localObject4, (i)localObject3, (c)localObject4, topMargin, s);
          }
        }
        else
        {
          m = e;
          if (m != -1)
          {
            localObject3 = a(m);
            if (localObject3 != null) {
              ((i)localObject2).a(c.d, (i)localObject3, c.b, topMargin, s);
            }
          }
        }
        m = d;
        if (m != -1)
        {
          localObject3 = a(m);
          if (localObject3 != null) {
            ((i)localObject2).a(c.b, (i)localObject3, c.d, bottomMargin, u);
          }
        }
        else
        {
          m = f;
          if (m != -1)
          {
            localObject3 = a(m);
            if (localObject3 != null)
            {
              localObject4 = c.b;
              ((i)localObject2).a((c)localObject4, (i)localObject3, (c)localObject4, bottomMargin, u);
            }
          }
        }
        m = c;
        if (m != -1)
        {
          localObject4 = (View)v.get(m);
          localObject3 = a(c);
          if ((localObject3 != null) && (localObject4 != null) && ((((View)localObject4).getLayoutParams() instanceof LayoutParams)))
          {
            localObject4 = (LayoutParams)((View)localObject4).getLayoutParams();
            weight = true;
            weight = true;
            ((i)localObject2).a(c.e).a(((i)localObject3).a(c.e), 0, -1, XLayoutStyle.b, 0, true);
            ((i)localObject2).a(c.d).b();
            ((i)localObject2).a(c.b).b();
          }
        }
        if ((f1 >= 0.0F) && (f1 != 0.5F)) {
          ((i)localObject2).add(f1);
        }
        f1 = w;
        if ((f1 >= 0.0F) && (f1 != 0.5F)) {
          ((i)localObject2).a(f1);
        }
        if ((isInEditMode()) && ((flags != -1) || (min != -1))) {
          ((i)localObject2).set(flags, min);
        }
        if (!width)
        {
          if (width == -1)
          {
            ((i)localObject2).a(Integer.a);
            aai = leftMargin;
            aci = rightMargin;
          }
          else
          {
            ((i)localObject2).a(Integer.left);
            ((i)localObject2).get(0);
          }
        }
        else
        {
          ((i)localObject2).a(Integer.data);
          ((i)localObject2).get(width);
        }
        if (!height)
        {
          if (height == -1)
          {
            ((i)localObject2).add(Integer.a);
            adi = topMargin;
            abi = bottomMargin;
          }
          else
          {
            ((i)localObject2).add(Integer.left);
            ((i)localObject2).append(0);
          }
        }
        else
        {
          ((i)localObject2).add(Integer.data);
          ((i)localObject2).append(height);
        }
        localObject3 = data;
        if (localObject3 != null) {
          ((i)localObject2).parse((String)localObject3);
        }
        ((i)localObject2).e(context);
        ((i)localObject2).b(title);
        ((i)localObject2).i(version);
        ((i)localObject2).push(state);
        ((i)localObject2).b(description, current, index);
        ((i)localObject2).add(max, buffer, key);
      }
      i += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    paramInt = Build.VERSION.SDK_INT;
  }
  
  public void b()
  {
    b.add();
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getMaxHeight()
  {
    return p;
  }
  
  public int getMaxWidth()
  {
    return k;
  }
  
  public int getMinHeight()
  {
    return h;
  }
  
  public int getMinWidth()
  {
    return f;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramBoolean = isInEditMode();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      Object localObject = (LayoutParams)localView.getLayoutParams();
      if ((localView.getVisibility() != 8) || (x) || (paramBoolean))
      {
        localObject = a;
        paramInt3 = ((i)localObject).e();
        paramInt4 = ((i)localObject).iterator();
        localView.layout(paramInt3, paramInt4, ((i)localObject).getValue() + paramInt3, ((i)localObject).size() + paramInt4);
      }
      paramInt1 += 1;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getPaddingLeft();
    int m = getPaddingTop();
    b.next(j);
    b.put(m);
    a(paramInt1, paramInt2);
    boolean bool = w;
    int i = 0;
    int i2 = 0;
    if (bool)
    {
      w = false;
      a();
    }
    measureHorizontal(paramInt1, paramInt2);
    if (getChildCount() > 0) {
      b();
    }
    int i6 = x.size();
    int i4 = getPaddingBottom() + m;
    int i5 = getPaddingRight() + j;
    if (i6 > 0)
    {
      if (b.invoke() == Integer.p) {
        n = 1;
      } else {
        n = 0;
      }
      int i1;
      if (b.isEmpty() == Integer.p) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      j = 0;
      i = 0;
      while (i2 < i6)
      {
        i localI = (i)x.get(i2);
        View localView;
        if (!(localI instanceof ByteVector))
        {
          localView = (View)localI.isVisible();
          if ((localView != null) && (localView.getVisibility() == 8)) {}
        }
        else
        {
          LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (width == -2) {
            m = ViewGroup.getChildMeasureSpec(paramInt1, i5, width);
          } else {
            m = View.MeasureSpec.makeMeasureSpec(localI.getValue(), 1073741824);
          }
          if (height == -2) {
            i3 = ViewGroup.getChildMeasureSpec(paramInt2, i4, height);
          } else {
            i3 = View.MeasureSpec.makeMeasureSpec(localI.size(), 1073741824);
          }
          localView.measure(m, i3);
          m = localView.getMeasuredWidth();
          int i3 = localView.getMeasuredHeight();
          if (m != localI.getValue())
          {
            localI.get(m);
            if ((n != 0) && (localI.getItemId() > b.getValue()))
            {
              j = localI.getItemId();
              m = localI.a(c.c).a();
              b.get(Math.max(f, m + j));
            }
            j = 1;
          }
          m = j;
          if (i3 != localI.size())
          {
            localI.append(i3);
            if ((i1 != 0) && (localI.d() > b.size()))
            {
              j = localI.d();
              m = localI.a(c.b).a();
              b.append(Math.max(h, m + j));
            }
            m = 1;
          }
          j = m;
          if (weight)
          {
            i3 = localView.getBaseline();
            j = m;
            if (i3 != -1)
            {
              j = m;
              if (i3 != localI.getVerticalMargins())
              {
                localI.e(i3);
                j = 1;
              }
            }
          }
          m = Build.VERSION.SDK_INT;
          i = View.combineMeasuredStates(i, localView.getMeasuredState());
        }
        i2 += 1;
      }
      if (j != 0) {
        b();
      }
    }
    m = b.getValue();
    j = b.size();
    int n = Build.VERSION.SDK_INT;
    paramInt1 = View.resolveSizeAndState(m + i5, paramInt1, i);
    paramInt2 = View.resolveSizeAndState(j + i4, paramInt2, i << 16);
    paramInt1 = Math.min(k, paramInt1);
    i = Math.min(p, paramInt2);
    paramInt2 = paramInt1 & 0xFFFFFF;
    i &= 0xFFFFFF;
    paramInt1 = paramInt2;
    if (b.close()) {
      paramInt1 = paramInt2 | 0x1000000;
    }
    paramInt2 = i;
    if (b.m()) {
      paramInt2 = i | 0x1000000;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void onViewAdded(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    super.onViewAdded(paramView);
    Object localObject = a(paramView);
    if (((paramView instanceof Guideline)) && (!(localObject instanceof ByteVector)))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      a = new ByteVector();
      x = true;
      ((ByteVector)a).a(b);
      localObject = a;
    }
    v.put(paramView.getId(), paramView);
    w = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    super.onViewRemoved(paramView);
    v.remove(paramView.getId());
    b.c(a(paramView));
    w = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    int i = Build.VERSION.SDK_INT;
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    w = true;
  }
  
  public void setConstraintSet(ClassWriter paramClassWriter)
  {
    q = paramClassWriter;
  }
  
  public void setId(int paramInt)
  {
    v.remove(getId());
    super.setId(paramInt);
    v.put(getId(), this);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (paramInt == p) {
      return;
    }
    p = paramInt;
    requestLayout();
  }
  
  public void setMaxWidth(int paramInt)
  {
    if (paramInt == k) {
      return;
    }
    k = paramInt;
    requestLayout();
  }
  
  public void setMinHeight(int paramInt)
  {
    if (paramInt == h) {
      return;
    }
    h = paramInt;
    requestLayout();
  }
  
  public void setMinWidth(int paramInt)
  {
    if (paramInt == f) {
      return;
    }
    f = paramInt;
    requestLayout();
  }
  
  public void setOptimizationLevel(int paramInt)
  {
    b.f(paramInt);
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final int ACTION_DOWN = 0;
    public static final int ACTIVITY_SETTINGS = 2;
    public static final int DIALOG_CANCEL = 5;
    public static final int INITIALISATION_VECTOR_FIELD_NUMBER = 1;
    public static final int MENU_DOWN = 1;
    public static final int NOT_A_TOUCH_COORDINATE = -1;
    public static final int PRIORITY_MIDHIGH = 7;
    public static final int PROMOTE_DIALOG = 0;
    public static final int RECENT_CONTACT = 1;
    public static final int RESULT_EDITBOARD = 0;
    public static final int SORT_MENU_ITEM = 3;
    public static final int STATE_NEW = 0;
    public static final int TYPE_DIALOG = 2;
    public static final int TYPE_EXPANDED = 1;
    public static final int UPDATE_CONTEXT = 6;
    public static final int VIEW_LIST = 0;
    public static final int VIEW_SERIEDETAILS_CONTEXT = 4;
    public i a = new i();
    public int b = -1;
    public int buffer = 0;
    public int c = -1;
    public int color = -1;
    public float context = 0.0F;
    public int count = -1;
    public int current = 0;
    public int d = -1;
    public String data = null;
    public int description = 0;
    public int e = -1;
    public int f = -1;
    public int flags = -1;
    public int g = -1;
    public int h = -1;
    public boolean height = true;
    public float i = -1.0F;
    public int id = 1;
    public int index = 0;
    public int j = -1;
    public int k = -1;
    public int key = 0;
    public float l = 0.5F;
    public int limit = -1;
    public int m = -1;
    public int max = 0;
    public int min = -1;
    public int mode = -1;
    public int n = -1;
    public int o = -1;
    public int offset = -1;
    public int p = -1;
    public int position = -1;
    public int r = -1;
    public int s = -1;
    public int size = -1;
    public int state = 0;
    public int t = -1;
    public float title = 0.0F;
    public int type = -1;
    public int u = -1;
    public int v = -1;
    public float value = 0.0F;
    public int version = 0;
    public float w = 0.5F;
    public boolean weight = false;
    public boolean width = true;
    public int wrap = -1;
    public boolean x = false;
    public float y = 0.5F;
    public int z = -1;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, JsonReader.1.ConstraintLayout_Layout);
      int i3 = paramContext.getIndexCount();
      int i1 = 0;
      while (i1 < i3)
      {
        int i2 = paramContext.getIndex(i1);
        String str;
        if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf)
        {
          k = paramContext.getResourceId(i2, k);
          if (k == -1) {
            k = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintLeft_toRightOf)
        {
          j = paramContext.getResourceId(i2, j);
          if (j == -1) {
            j = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintRight_toLeftOf)
        {
          wrap = paramContext.getResourceId(i2, wrap);
          if (wrap == -1) {
            wrap = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintRight_toRightOf)
        {
          mode = paramContext.getResourceId(i2, mode);
          if (mode == -1) {
            mode = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintTop_toTopOf)
        {
          n = paramContext.getResourceId(i2, n);
          if (n == -1) {
            n = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintTop_toBottomOf)
        {
          e = paramContext.getResourceId(i2, e);
          if (e == -1) {
            e = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintBottom_toTopOf)
        {
          d = paramContext.getResourceId(i2, d);
          if (d == -1) {
            d = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf)
        {
          f = paramContext.getResourceId(i2, f);
          if (f == -1) {
            f = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf)
        {
          c = paramContext.getResourceId(i2, c);
          if (c == -1) {
            c = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_editor_absoluteX)
        {
          flags = paramContext.getDimensionPixelOffset(i2, flags);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_editor_absoluteY)
        {
          min = paramContext.getDimensionPixelOffset(i2, min);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintGuide_begin)
        {
          h = paramContext.getDimensionPixelOffset(i2, h);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintGuide_end)
        {
          m = paramContext.getDimensionPixelOffset(i2, m);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintGuide_percent)
        {
          i = paramContext.getFloat(i2, i);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_android_orientation)
        {
          b = paramContext.getInt(i2, b);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintStart_toEndOf)
        {
          color = paramContext.getResourceId(i2, color);
          if (color == -1) {
            color = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintStart_toStartOf)
        {
          count = paramContext.getResourceId(i2, count);
          if (count == -1) {
            count = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintEnd_toStartOf)
        {
          limit = paramContext.getResourceId(i2, limit);
          if (limit == -1) {
            limit = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintEnd_toEndOf)
        {
          z = paramContext.getResourceId(i2, z);
          if (z == -1) {
            z = paramContext.getInt(i2, -1);
          }
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_goneMarginLeft)
        {
          r = paramContext.getDimensionPixelSize(i2, r);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_goneMarginTop)
        {
          s = paramContext.getDimensionPixelSize(i2, s);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_goneMarginRight)
        {
          o = paramContext.getDimensionPixelSize(i2, o);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_goneMarginBottom)
        {
          u = paramContext.getDimensionPixelSize(i2, u);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_goneMarginStart)
        {
          v = paramContext.getDimensionPixelSize(i2, v);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_goneMarginEnd)
        {
          t = paramContext.getDimensionPixelSize(i2, t);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintHorizontal_bias)
        {
          y = paramContext.getFloat(i2, y);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintVertical_bias)
        {
          w = paramContext.getFloat(i2, w);
        }
        else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintDimensionRatio)
        {
          data = paramContext.getString(i2);
          value = NaN.0F;
          id = -1;
          paramAttributeSet = data;
          if (paramAttributeSet == null) {
            break label1802;
          }
          int i4 = paramAttributeSet.length();
          i2 = data.indexOf(',');
          if ((i2 > 0) && (i2 < i4 - 1))
          {
            paramAttributeSet = data.substring(0, i2);
            if (paramAttributeSet.equalsIgnoreCase("W")) {
              id = 0;
            } else if (paramAttributeSet.equalsIgnoreCase("H")) {
              id = 1;
            }
            i2 += 1;
          }
          else
          {
            i2 = 0;
          }
          int i5 = data.indexOf(':');
          if ((i5 >= 0) && (i5 < i4 - 1))
          {
            paramAttributeSet = data.substring(i2, i5);
            str = data.substring(i5 + 1);
            if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
              break label1802;
            }
          }
        }
        try
        {
          f1 = Float.parseFloat(paramAttributeSet);
          float f2 = Float.parseFloat(str);
          if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
            break label1802;
          }
          if (id == 1)
          {
            f1 = f2 / f1;
            f1 = Math.abs(f1);
            value = f1;
          }
          else
          {
            f1 /= f2;
            f1 = Math.abs(f1);
            value = f1;
          }
        }
        catch (NumberFormatException paramAttributeSet)
        {
          float f1;
          for (;;) {}
        }
        paramAttributeSet = data.substring(i2);
        if (paramAttributeSet.length() > 0) {}
        try
        {
          f1 = Float.parseFloat(paramAttributeSet);
          value = f1;
        }
        catch (NumberFormatException paramAttributeSet)
        {
          label1802:
          for (;;) {}
        }
        if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
          context = paramContext.getFloat(i2, 0.0F);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintVertical_weight) {
          title = paramContext.getFloat(i2, 0.0F);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
          version = paramContext.getInt(i2, 0);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
          state = paramContext.getInt(i2, 0);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintWidth_default) {
          description = paramContext.getInt(i2, 0);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintHeight_default) {
          max = paramContext.getInt(i2, 0);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintWidth_min) {
          current = paramContext.getDimensionPixelSize(i2, current);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintWidth_max) {
          index = paramContext.getDimensionPixelSize(i2, index);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintHeight_min) {
          buffer = paramContext.getDimensionPixelSize(i2, buffer);
        } else if (i2 == JsonReader.1.ConstraintLayout_Layout_layout_constraintHeight_max) {
          key = paramContext.getDimensionPixelSize(i2, key);
        } else if ((i2 != JsonReader.1.ConstraintLayout_Layout_layout_constraintLeft_creator) && (i2 != JsonReader.1.ConstraintLayout_Layout_layout_constraintTop_creator) && (i2 != JsonReader.1.ConstraintLayout_Layout_layout_constraintRight_creator) && (i2 != JsonReader.1.ConstraintLayout_Layout_layout_constraintBottom_creator)) {
          i2 = JsonReader.1.ConstraintLayout_Layout_layout_constraintBaseline_creator;
        }
        i1 += 1;
      }
      paramContext.recycle();
      add();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      h = h;
      m = m;
      i = i;
      k = k;
      j = j;
      wrap = wrap;
      mode = mode;
      n = n;
      e = e;
      d = d;
      f = f;
      c = c;
      color = color;
      count = count;
      limit = limit;
      z = z;
      r = r;
      s = s;
      o = o;
      u = u;
      v = v;
      t = t;
      y = y;
      w = w;
      data = data;
      value = value;
      id = id;
      context = context;
      title = title;
      version = version;
      state = state;
      description = description;
      max = max;
      current = current;
      index = index;
      buffer = buffer;
      key = key;
      flags = flags;
      min = min;
      b = b;
      width = width;
      height = height;
      weight = weight;
      x = x;
      type = type;
      position = position;
      size = size;
      offset = offset;
      g = g;
      p = p;
      l = l;
      a = a;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public void add()
    {
      x = false;
      width = true;
      height = true;
      if ((width == 0) || (width == -1)) {
        width = false;
      }
      if ((height == 0) || (height == -1)) {
        height = false;
      }
      if ((i != -1.0F) || (h != -1) || (m != -1))
      {
        x = true;
        width = true;
        height = true;
        if (!(a instanceof ByteVector)) {
          a = new ByteVector();
        }
        ((ByteVector)a).a(b);
      }
    }
    
    public void resolveLayoutDirection(int paramInt)
    {
      super.resolveLayoutDirection(paramInt);
      size = -1;
      offset = -1;
      type = -1;
      position = -1;
      g = -1;
      p = -1;
      g = r;
      p = o;
      l = y;
      int i1 = getLayoutDirection();
      paramInt = 1;
      if (1 != i1) {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        paramInt = color;
        if (paramInt != -1)
        {
          size = paramInt;
        }
        else
        {
          paramInt = count;
          if (paramInt != -1) {
            offset = paramInt;
          }
        }
        paramInt = limit;
        if (paramInt != -1) {
          position = paramInt;
        }
        paramInt = z;
        if (paramInt != -1) {
          type = paramInt;
        }
        paramInt = v;
        if (paramInt != -1) {
          p = paramInt;
        }
        paramInt = t;
        if (paramInt != -1) {
          g = paramInt;
        }
        l = (1.0F - y);
      }
      else
      {
        paramInt = color;
        if (paramInt != -1) {
          position = paramInt;
        }
        paramInt = count;
        if (paramInt != -1) {
          type = paramInt;
        }
        paramInt = limit;
        if (paramInt != -1) {
          size = paramInt;
        }
        paramInt = z;
        if (paramInt != -1) {
          offset = paramInt;
        }
        paramInt = v;
        if (paramInt != -1) {
          g = paramInt;
        }
        paramInt = t;
        if (paramInt != -1) {
          p = paramInt;
        }
      }
      if ((limit == -1) && (z == -1))
      {
        paramInt = wrap;
        if (paramInt != -1)
        {
          size = paramInt;
        }
        else
        {
          paramInt = mode;
          if (paramInt != -1) {
            offset = paramInt;
          }
        }
      }
      if ((count == -1) && (color == -1))
      {
        paramInt = k;
        if (paramInt != -1)
        {
          type = paramInt;
          return;
        }
        paramInt = j;
        if (paramInt != -1) {
          position = paramInt;
        }
      }
    }
  }
}
