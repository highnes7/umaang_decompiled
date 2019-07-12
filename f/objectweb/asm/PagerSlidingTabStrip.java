package f.objectweb.asm;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import b.b.a.G;

@SuppressLint({"ViewConstructor"})
public class PagerSlidingTabStrip
  extends View
{
  @G
  public SpannableStringBuilder A;
  public int B;
  public final int C;
  public boolean D = false;
  public ValueAnimator[] E = { mZoomInAnimation, mZoomOutAnimation, animator, mAnimator };
  public boolean I;
  public final int Radius;
  public final Paint a;
  public final ValueAnimator animator = new GenericRequestBuilder(false).animate(250L).setInterpolator(new AccelerateDecelerateInterpolator()).animate(new LazilyLoadedCtor(this)).animate(new TextInputDialog.1(this)).setDuration();
  public final f b;
  public final int bottom;
  @G
  public Paint c;
  public boolean d = false;
  public d data;
  public final int e;
  public final int f;
  public boolean g;
  public boolean h = true;
  public final FixedStepHandler handler = new StepNormalizer(this);
  public int height;
  public final ViewManager i;
  public Bitmap image;
  public float index;
  @G
  public final ViewGroup info;
  public int j;
  public boolean k;
  public int l;
  public final int left;
  public final int length;
  public int level;
  public int m;
  public final ValueAnimator mAnimator = new GenericRequestBuilder(true).animate(250L).setInterpolator(new AccelerateDecelerateInterpolator()).animate(new NativeWith(this)).animate(new TimePicker.4(this)).setDuration();
  public final Paint mCenterPaint;
  public final Paint mPaint;
  public Path mPath;
  public final ValueAnimator mZoomInAnimation = new GenericRequestBuilder(false).animate(250L).setDuration(250L).setInterpolator(new AccelerateDecelerateInterpolator()).animate(new ClassWriter(this)).animate(new FilenameDialog.1(this)).setDuration();
  public final ValueAnimator mZoomOutAnimation = new GenericRequestBuilder(false).animate(1000L).animate(-1).setInterpolator(new AccelerateDecelerateInterpolator()).animate(new NumberPicker.TwoDigitFormatter(this)).setDuration();
  @G
  public ViewOutlineProvider n;
  public final int name;
  @G
  public DynamicLayout o;
  public final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
  public final Paint p;
  public float pager;
  public final TextPaint paint;
  public final int pointCount;
  public int q;
  public Rect r;
  public Rect rect;
  public boolean s;
  public final int start;
  public float t;
  public CharSequence text;
  @G
  public StaticLayout textHeight;
  @G
  public StaticLayout textLayout;
  public final TextPaint textPaint;
  public final Rect this$0;
  @G
  public CharSequence top;
  public boolean transform;
  public boolean u;
  public int v;
  public float w;
  public float width;
  public int[] x;
  public final int y;
  @G
  public TextPaint z;
  
  public PagerSlidingTabStrip(Context paramContext, ViewManager paramViewManager, ViewGroup paramViewGroup, f paramF, d paramD)
  {
    super(paramContext);
    if (paramF != null)
    {
      b = paramF;
      i = paramViewManager;
      info = paramViewGroup;
      if (paramD == null) {
        paramD = new d();
      }
      data = paramD;
      text = u;
      top = g;
      bottom = Label.getColor(paramContext, 20);
      f = Label.getColor(paramContext, 40);
      e = Label.getColor(paramContext, d);
      start = Label.getColor(paramContext, 40);
      Radius = Label.getColor(paramContext, 8);
      left = Label.getColor(paramContext, 360);
      length = Label.getColor(paramContext, 20);
      C = Label.getColor(paramContext, 88);
      y = Label.getColor(paramContext, 8);
      pointCount = Label.getColor(paramContext, 1);
      name = ((int)(e * 0.1F));
      mPath = new Path();
      this$0 = new Rect();
      rect = new Rect();
      paint = new TextPaint();
      paint.setTextSize(paramF.add(paramContext));
      paint.setTypeface(Typeface.create("sans-serif-medium", 0));
      paint.setAntiAlias(true);
      textPaint = new TextPaint();
      textPaint.setTextSize(paramF.d(paramContext));
      textPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
      textPaint.setAntiAlias(true);
      textPaint.setAlpha(137);
      mPaint = new Paint();
      mPaint.setAntiAlias(true);
      mPaint.setAlpha((int)(y * 255.0F));
      mCenterPaint = new Paint();
      mCenterPaint.setAntiAlias(true);
      mCenterPaint.setAlpha(50);
      mCenterPaint.setStyle(Paint.Style.STROKE);
      mCenterPaint.setStrokeWidth(pointCount);
      mCenterPaint.setColor(-16777216);
      a = new Paint();
      a.setAntiAlias(true);
      p = new Paint();
      p.setAntiAlias(true);
      a(paramContext);
      onGlobalLayoutListener = new w(this, paramF, paramViewGroup, paramContext);
      getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
      setFocusableInTouchMode(true);
      setClickable(true);
      setOnClickListener(new DashboardFragment.1(this));
      setOnLongClickListener(new TextCandidatesViewManager.3(this));
      return;
    }
    throw new IllegalArgumentException("Target cannot be null");
  }
  
  public static PagerSlidingTabStrip a(Activity paramActivity, f paramF)
  {
    return a(paramActivity, paramF, null);
  }
  
  public static PagerSlidingTabStrip a(Activity paramActivity, f paramF, d paramD)
  {
    if (paramActivity != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      paramActivity = new PagerSlidingTabStrip(paramActivity, localViewGroup, (ViewGroup)localViewGroup.findViewById(16908290), paramF, paramD);
      localViewGroup.addView(paramActivity, localLayoutParams);
      return paramActivity;
    }
    throw new IllegalArgumentException("Activity is null");
  }
  
  public static PagerSlidingTabStrip a(Dialog paramDialog, f paramF)
  {
    return a(paramDialog, paramF, null);
  }
  
  public static PagerSlidingTabStrip a(Dialog paramDialog, f paramF, d paramD)
  {
    if (paramDialog != null)
    {
      Context localContext = paramDialog.getContext();
      paramDialog = (WindowManager)localContext.getSystemService("window");
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      type = 2;
      format = 1;
      flags = 0;
      gravity = 8388659;
      x = 0;
      y = 0;
      width = -1;
      height = -1;
      paramF = new PagerSlidingTabStrip(localContext, paramDialog, null, paramF, paramD);
      paramDialog.addView(paramF, localLayoutParams);
      return paramF;
    }
    throw new IllegalArgumentException("Dialog is null");
  }
  
  public float a(float paramFloat)
  {
    if (paramFloat < 0.5F) {
      return paramFloat / 0.5F;
    }
    return (1.0F - paramFloat) / 0.5F;
  }
  
  public int a(int paramInt1, int paramInt2, Rect paramRect1, Rect paramRect2)
  {
    int i1 = paramRect2.centerX();
    int i2 = paramRect2.centerY();
    int i3 = (int)(e * 1.1F);
    paramRect2 = new Rect(i1, i2, i1, i2);
    i1 = -i3;
    paramRect2.inset(i1, i1);
    return Math.max(getColor(paramInt1, paramInt2, paramRect1), getColor(paramInt1, paramInt2, paramRect2)) + f;
  }
  
  public void a()
  {
    r = getTextBounds();
    x = getOuterCircleCenterPoint();
    int[] arrayOfInt = x;
    m = a(arrayOfInt[0], arrayOfInt[1], r, this$0);
  }
  
  public void a(Context paramContext)
  {
    Object localObject = b;
    g = f;
    s = w;
    u = q;
    if ((s) && (Build.VERSION.SDK_INT >= 21) && (!k))
    {
      n = new FloatingActionButton.1(this);
      setOutlineProvider(n);
      setElevation(y);
    }
    int i1;
    if ((s) && (n == null)) {
      i1 = Build.VERSION.SDK_INT;
    }
    setLayerType(2, null);
    localObject = paramContext.getTheme();
    boolean bool;
    if (Label.getColor(paramContext, "isLightTheme") == 0) {
      bool = true;
    } else {
      bool = false;
    }
    k = bool;
    Integer localInteger = b.b(paramContext);
    if (localInteger != null) {
      mPaint.setColor(localInteger.intValue());
    } else if (localObject != null) {
      mPaint.setColor(Label.getColor(paramContext, "colorPrimary"));
    } else {
      mPaint.setColor(-1);
    }
    localObject = b.e(paramContext);
    int i2 = -16777216;
    if (localObject != null)
    {
      a.setColor(((Integer)localObject).intValue());
    }
    else
    {
      localObject = a;
      if (k) {
        i1 = -16777216;
      } else {
        i1 = -1;
      }
      ((Paint)localObject).setColor(i1);
    }
    if (b.k) {
      a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
    p.setColor(a.getColor());
    localObject = b.c(paramContext);
    if (localObject != null) {
      B = Label.a(((Integer)localObject).intValue(), 0.3F);
    } else {
      B = -1;
    }
    localObject = b.a(paramContext);
    if (localObject != null)
    {
      paint.setColor(((Integer)localObject).intValue());
    }
    else
    {
      localObject = paint;
      if (k) {
        i1 = i2;
      } else {
        i1 = -1;
      }
      ((Paint)localObject).setColor(i1);
    }
    paramContext = b.clear(paramContext);
    if (paramContext != null) {
      textPaint.setColor(paramContext.intValue());
    } else {
      textPaint.setColor(paint.getColor());
    }
    paramContext = b.h;
    if (paramContext != null) {
      paint.setTypeface(paramContext);
    }
    paramContext = b.z;
    if (paramContext != null) {
      textPaint.setTypeface(paramContext);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (c == null)
    {
      c = new Paint();
      c.setARGB(255, 255, 0, 0);
      c.setStyle(Paint.Style.STROKE);
      c.setStrokeWidth(Label.getColor(getContext(), 1));
    }
    if (z == null)
    {
      z = new TextPaint();
      z.setColor(-65536);
      z.setTextSize(Label.b(getContext(), 16));
    }
    c.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRect(r, c);
    paramCanvas.drawRect(this$0, c);
    Object localObject = x;
    paramCanvas.drawCircle(localObject[0], localObject[1], 10.0F, c);
    localObject = x;
    paramCanvas.drawCircle(localObject[0], localObject[1], m - f, c);
    paramCanvas.drawCircle(this$0.centerX(), this$0.centerY(), e + bottom, c);
    c.setStyle(Paint.Style.FILL);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Text bounds: ");
    ((StringBuilder)localObject).append(r.toShortString());
    ((StringBuilder)localObject).append("\nTarget bounds: ");
    ((StringBuilder)localObject).append(this$0.toShortString());
    ((StringBuilder)localObject).append("\nCenter: ");
    ((StringBuilder)localObject).append(x[0]);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(x[1]);
    ((StringBuilder)localObject).append("\nView size: ");
    ((StringBuilder)localObject).append(getWidth());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(getHeight());
    ((StringBuilder)localObject).append("\nTarget bounds: ");
    ((StringBuilder)localObject).append(this$0.toShortString());
    localObject = ((StringBuilder)localObject).toString();
    SpannableStringBuilder localSpannableStringBuilder = A;
    if (localSpannableStringBuilder == null)
    {
      A = new SpannableStringBuilder((CharSequence)localObject);
    }
    else
    {
      localSpannableStringBuilder.clear();
      A.append((CharSequence)localObject);
    }
    if (o == null) {
      o = new DynamicLayout((CharSequence)localObject, z, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    }
    int i1 = paramCanvas.save();
    c.setARGB(220, 0, 0, 0);
    paramCanvas.translate(0.0F, j);
    paramCanvas.drawRect(0.0F, 0.0F, o.getWidth(), o.getHeight(), c);
    c.setARGB(255, 255, 0, 0);
    o.draw(paramCanvas);
    paramCanvas.restoreToCount(i1);
  }
  
  public void a(Rect paramRect)
  {
    invalidate(paramRect);
    if ((n != null) && (Build.VERSION.SDK_INT >= 21)) {
      invalidateOutline();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (D) {
      return;
    }
    d = false;
    D = true;
    Object localObject = E;
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localOnGlobalLayoutListener = localObject[i1];
      localOnGlobalLayoutListener.cancel();
      localOnGlobalLayoutListener.removeAllUpdateListeners();
      i1 += 1;
    }
    localObject = getViewTreeObserver();
    ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = onGlobalLayoutListener;
    i1 = Build.VERSION.SDK_INT;
    ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener(localOnGlobalLayoutListener);
    I = false;
    localObject = data;
    if (localObject != null) {
      ((d)localObject).c(this, paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    int i1 = l;
    if (i1 > 0)
    {
      int i2 = C;
      if ((paramInt < i2) || (paramInt > i1 - i2)) {
        return true;
      }
    }
    else if ((paramInt < C) || (paramInt > getHeight() - C))
    {
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return (!D) && (I);
  }
  
  public double distance(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = Math.pow(paramInt3 - paramInt1, 2.0D);
    return Math.sqrt(Math.pow(paramInt4 - paramInt2, 2.0D) + d1);
  }
  
  public void draw()
  {
    int i1 = Math.min(getWidth(), left) - start * 2;
    if (i1 <= 0) {
      return;
    }
    textLayout = new StaticLayout(text, paint, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    CharSequence localCharSequence = top;
    if (localCharSequence != null)
    {
      textHeight = new StaticLayout(localCharSequence, textPaint, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
      return;
    }
    textHeight = null;
  }
  
  public int getColor(int paramInt1, int paramInt2, Rect paramRect)
  {
    return (int)Math.max(distance(paramInt1, paramInt2, left, top), Math.max(distance(paramInt1, paramInt2, right, top), Math.max(distance(paramInt1, paramInt2, left, bottom), distance(paramInt1, paramInt2, right, bottom))));
  }
  
  public int[] getOuterCircleCenterPoint()
  {
    if (a(this$0.centerY())) {
      return new int[] { this$0.centerX(), this$0.centerY() };
    }
    int i2 = Math.max(this$0.width(), this$0.height()) / 2 + bottom;
    int i4 = getTotalTextHeight();
    int i1;
    if (this$0.centerY() - e - bottom - i4 > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i3 = Math.min(r.left, this$0.left - i2);
    int i5 = Math.max(r.right, this$0.right + i2);
    StaticLayout localStaticLayout = textLayout;
    if (localStaticLayout == null) {
      i2 = 0;
    } else {
      i2 = localStaticLayout.getHeight();
    }
    if (i1 != 0) {
      i1 = this$0.centerY() - e - bottom - i4 + i2;
    } else {
      i1 = this$0.centerY() + e + bottom + i2;
    }
    return new int[] { (i3 + i5) / 2, i1 };
  }
  
  public Rect getTextBounds()
  {
    int i3 = getTotalTextHeight();
    int i4 = getTotalTextWidth();
    int i1 = this$0.centerY() - e - bottom - i3;
    if (i1 <= j) {
      i1 = this$0.centerY() + e + bottom;
    }
    if (getWidth() / 2 - this$0.centerX() < 0) {
      i2 = -length;
    } else {
      i2 = length;
    }
    int i2 = Math.max(start, this$0.centerX() - i2 - i4);
    return new Rect(i2, i1, Math.min(getWidth() - start, i4 + i2), i3 + i1);
  }
  
  public int getTotalTextHeight()
  {
    StaticLayout localStaticLayout = textLayout;
    if (localStaticLayout == null) {
      return 0;
    }
    if (textHeight == null) {
      return localStaticLayout.getHeight() + Radius;
    }
    int i1 = localStaticLayout.getHeight();
    return textHeight.getHeight() + i1 + Radius;
  }
  
  public int getTotalTextWidth()
  {
    StaticLayout localStaticLayout = textLayout;
    if (localStaticLayout == null) {
      return 0;
    }
    if (textHeight == null) {
      return localStaticLayout.getWidth();
    }
    return Math.max(localStaticLayout.getWidth(), textHeight.getWidth());
  }
  
  public void onCreate()
  {
    Drawable localDrawable = b.a;
    if ((g) && (localDrawable != null))
    {
      if (image != null) {
        return;
      }
      image = Bitmap.createBitmap(localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(image);
      localDrawable.setColorFilter(new PorterDuffColorFilter(mPaint.getColor(), PorterDuff.Mode.SRC_ATOP));
      localDrawable.draw(localCanvas);
      localDrawable.setColorFilter(null);
      return;
    }
    image = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a(false);
  }
  
  public void onDraw()
  {
    int[] arrayOfInt = x;
    if (arrayOfInt == null) {
      return;
    }
    rect.left = ((int)Math.max(0.0F, arrayOfInt[0] - width));
    rect.top = ((int)Math.min(0.0F, x[1] - width));
    rect.right = ((int)Math.min(getWidth(), x[0] + width + f));
    rect.bottom = ((int)Math.min(getHeight(), x[1] + width + f));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (!D)
    {
      if (x == null) {
        return;
      }
      int i1 = j;
      if ((i1 > 0) && (l > 0)) {
        paramCanvas.clipRect(0, i1, getWidth(), l);
      }
      i1 = B;
      if (i1 != -1) {
        paramCanvas.drawColor(i1);
      }
      mPaint.setAlpha(level);
      if ((s) && (n == null))
      {
        i1 = paramCanvas.save();
        paramCanvas.clipPath(mPath, Region.Op.DIFFERENCE);
        update(paramCanvas);
        paramCanvas.restoreToCount(i1);
      }
      Object localObject = x;
      paramCanvas.drawCircle(localObject[0], localObject[1], width, mPaint);
      a.setAlpha(v);
      i1 = q;
      if (i1 > 0)
      {
        p.setAlpha(i1);
        paramCanvas.drawCircle(this$0.centerX(), this$0.centerY(), w, p);
      }
      paramCanvas.drawCircle(this$0.centerX(), this$0.centerY(), t, a);
      i1 = paramCanvas.save();
      localObject = r;
      paramCanvas.translate(left, top);
      paint.setAlpha(height);
      localObject = textLayout;
      if (localObject != null) {
        ((Layout)localObject).draw(paramCanvas);
      }
      if (textHeight != null)
      {
        localObject = textLayout;
        if (localObject != null)
        {
          paramCanvas.translate(0.0F, ((Layout)localObject).getHeight() + Radius);
          textPaint.setAlpha((int)(b.B * height));
          textHeight.draw(paramCanvas);
        }
      }
      paramCanvas.restoreToCount(i1);
      i1 = paramCanvas.save();
      if (image != null)
      {
        paramCanvas.translate(this$0.centerX() - image.getWidth() / 2, this$0.centerY() - image.getHeight() / 2);
        paramCanvas.drawBitmap(image, 0.0F, 0.0F, a);
      }
      else if (b.a != null)
      {
        paramCanvas.translate(this$0.centerX() - b.a.getBounds().width() / 2, this$0.centerY() - b.a.getBounds().height() / 2);
        b.a.setAlpha(a.getAlpha());
        b.a.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(i1);
      if (transform) {
        a(paramCanvas);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((b()) && (u) && (paramInt == 4))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((b()) && (h) && (u) && (paramInt == 4) && (paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
    {
      h = false;
      paramKeyEvent = data;
      if (paramKeyEvent != null) {
        paramKeyEvent.b(this);
      } else {
        show(false);
      }
      return true;
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    index = paramMotionEvent.getX();
    pager = paramMotionEvent.getY();
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public float set(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < paramFloat2) {
      return 0.0F;
    }
    return (paramFloat1 - paramFloat2) / (1.0F - paramFloat2);
  }
  
  public void setDrawDebug(boolean paramBoolean)
  {
    if (transform != paramBoolean)
    {
      transform = paramBoolean;
      postInvalidate();
    }
  }
  
  public void show(boolean paramBoolean)
  {
    d = true;
    mZoomOutAnimation.cancel();
    mZoomInAnimation.cancel();
    if (paramBoolean)
    {
      animator.start();
      return;
    }
    mAnimator.start();
  }
  
  public void update(Canvas paramCanvas)
  {
    float f1 = level * 0.2F;
    mCenterPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    mCenterPaint.setAlpha((int)f1);
    int[] arrayOfInt = x;
    paramCanvas.drawCircle(arrayOfInt[0], arrayOfInt[1] + y, width, mCenterPaint);
    mCenterPaint.setStyle(Paint.Style.STROKE);
    int i1 = 6;
    while (i1 > 0)
    {
      mCenterPaint.setAlpha((int)(i1 / 7.0F * f1));
      arrayOfInt = x;
      paramCanvas.drawCircle(arrayOfInt[0], arrayOfInt[1] + y, width + (7 - i1) * pointCount, mCenterPaint);
      i1 -= 1;
    }
  }
}
