package android.support.v4.graphics.drawable;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import b.b.a.N;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import support.android.v4.content.ContextCompat;
import support.android.v4.content.asm.Config;
import support.android.v4.internal.drawable.DrawableCompat;

public class IconCompat
  extends CustomVersionedParcelable
{
  public static final String ACTION_SHOW_PLAYER = "tint_mode";
  public static final String ACTION_UPDATE_ALL = "tint_list";
  public static final String COL_TYPE = "type";
  public static final String EVENTLOG_URL = "int1";
  public static final String EXTRA_LOCALE = "int2";
  public static final int KEYCODE_B = 30;
  public static final int NOT_A_TOUCH_COORDINATE = -1;
  public static final String PAGE_KEY = "IconCompat";
  public static final float SELECTION_FADE_PERCENTAGE = 0.25F;
  public static final String SQL_UPDATE_6_4 = "obj";
  public static final PorterDuff.Mode context = PorterDuff.Mode.SRC_IN;
  public static final float mCoeffX = 0.6666667F;
  public static final float offScreenRadius = 0.9166667F;
  public static final int pad = 61;
  public static final float size5 = 0.010416667F;
  public static final float widthScale = 0.020833334F;
  @N({b.b.a.N.a.a})
  public int a;
  @N({b.b.a.N.a.a})
  public int b;
  @N({b.b.a.N.a.a})
  public int c;
  @N({b.b.a.N.a.a})
  public String i;
  @N({b.b.a.N.a.a})
  public Parcelable left;
  @N({b.b.a.N.a.a})
  public byte[] s;
  @N({b.b.a.N.a.a})
  public ColorStateList state = null;
  public PorterDuff.Mode type = context;
  public Object x;
  
  public IconCompat() {}
  
  public IconCompat(int paramInt)
  {
    c = paramInt;
  }
  
  public static int a(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getType();
    }
    try
    {
      Object localObject = paramIcon.getClass();
      localObject = ((Class)localObject).getMethod("getType", new Class[0]);
      localObject = ((Method)localObject).invoke(paramIcon, new Object[0]);
      localObject = (Integer)localObject;
      int j = ((Integer)localObject).intValue();
      return j;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unable to get icon type ", paramIcon);
    return -1;
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unable to get icon type ", paramIcon);
    return -1;
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unable to get icon type ", paramIcon);
    return -1;
  }
  
  public static IconCompat a(Context paramContext, int paramInt)
  {
    if (paramContext != null) {
      return a(paramContext.getResources(), paramContext.getPackageName(), paramInt);
    }
    throw new IllegalArgumentException("Context must not be null.");
  }
  
  public static IconCompat a(Resources paramResources, String paramString, int paramInt)
  {
    IconCompat localIconCompat;
    if (paramString != null) {
      if (paramInt != 0)
      {
        localIconCompat = new IconCompat(2);
        a = paramInt;
        if (paramResources == null) {}
      }
    }
    try
    {
      paramResources = paramResources.getResourceName(paramInt);
      x = paramResources;
      return localIconCompat;
    }
    catch (Resources.NotFoundException paramResources)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Icon resource cannot be found");
    x = paramString;
    return localIconCompat;
    throw new IllegalArgumentException("Drawable resource ID must not be 0");
    throw new IllegalArgumentException("Package must not be null.");
  }
  
  public static IconCompat a(Uri paramUri)
  {
    if (paramUri != null) {
      return b(paramUri.toString());
    }
    throw new IllegalArgumentException("Uri must not be null.");
  }
  
  public static IconCompat addBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      IconCompat localIconCompat = new IconCompat(5);
      x = paramBitmap;
      return localIconCompat;
    }
    throw new IllegalArgumentException("Bitmap must not be null.");
  }
  
  public static int b(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getResId();
    }
    try
    {
      Object localObject = paramIcon.getClass();
      localObject = ((Class)localObject).getMethod("getResId", new Class[0]);
      paramIcon = ((Method)localObject).invoke(paramIcon, new Object[0]);
      paramIcon = (Integer)paramIcon;
      int j = paramIcon.intValue();
      return j;
    }
    catch (IllegalAccessException paramIcon)
    {
      return 0;
    }
    catch (InvocationTargetException paramIcon)
    {
      return 0;
    }
    catch (NoSuchMethodException paramIcon) {}
    return 0;
  }
  
  public static IconCompat b(Context paramContext, Icon paramIcon)
  {
    String str;
    if (paramIcon != null)
    {
      int j = a(paramIcon);
      if (j != 2)
      {
        if (j != 4)
        {
          paramContext = new IconCompat(-1);
          x = paramIcon;
          return paramContext;
        }
        return a(toString(paramIcon));
      }
      str = get(paramIcon);
    }
    try
    {
      paramContext = a(get(paramContext, str), str, b(paramIcon));
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Icon resource cannot be found");
    throw new NullPointerException();
  }
  
  public static IconCompat b(String paramString)
  {
    if (paramString != null)
    {
      IconCompat localIconCompat = new IconCompat(4);
      x = paramString;
      return localIconCompat;
    }
    throw new IllegalArgumentException("Uri must not be null.");
  }
  
  public static IconCompat b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      IconCompat localIconCompat = new IconCompat(3);
      x = paramArrayOfByte;
      a = paramInt1;
      b = paramInt2;
      return localIconCompat;
    }
    throw new IllegalArgumentException("Data must not be null.");
  }
  
  public static IconCompat c(Icon paramIcon)
  {
    if (paramIcon != null)
    {
      int j = a(paramIcon);
      if (j != 2)
      {
        if (j != 4)
        {
          IconCompat localIconCompat = new IconCompat(-1);
          x = paramIcon;
          return localIconCompat;
        }
        return a(toString(paramIcon));
      }
      return a(null, get(paramIcon), b(paramIcon));
    }
    throw new NullPointerException();
  }
  
  private Drawable doInBackground(Context paramContext)
  {
    int j = c;
    Object localObject2;
    if (j != 1) {
      if (j != 2) {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5) {
              return null;
            }
            return new BitmapDrawable(paramContext.getResources(), transform((Bitmap)x, false));
          }
          localObject2 = Uri.parse((String)x);
          localObject1 = ((Uri)localObject2).getScheme();
          if ((!"content".equals(localObject1)) && (!"file".equals(localObject1))) {
            localObject1 = (String)x;
          }
        }
      }
    }
    try
    {
      localObject1 = new FileInputStream(new File((String)localObject1));
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;) {}
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unable to load image from path: ", localObject2);
    try
    {
      localObject1 = paramContext.getContentResolver().openInputStream((Uri)localObject2);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unable to load image from URI: ", localObject2);
    Object localObject1 = null;
    if (localObject1 != null)
    {
      return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeStream((InputStream)localObject1));
      return new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeByteArray((byte[])x, a, b));
      localObject2 = get();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramContext.getPackageName();
      }
      localObject1 = get(paramContext, (String)localObject1);
      try
      {
        paramContext = Config.getDrawable((Resources)localObject1, a, paramContext.getTheme());
        return paramContext;
      }
      catch (RuntimeException paramContext)
      {
        for (;;) {}
      }
      String.format("Unable to load resource 0x%08x from pkg=%s", new Object[] { Integer.valueOf(a), x });
      return null;
      return new BitmapDrawable(paramContext.getResources(), (Bitmap)x);
    }
    return null;
  }
  
  public static Resources get(Context paramContext, String paramString)
  {
    if ("android".equals(paramString)) {
      return Resources.getSystem();
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo(paramString, 8192);
      if (localApplicationInfo != null)
      {
        paramContext = paramContext.getResourcesForApplication(localApplicationInfo);
        return paramContext;
      }
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    String.format("Unable to find pkg=%s for icon", new Object[] { paramString });
    return null;
  }
  
  public static String get(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getResPackage();
    }
    try
    {
      Object localObject = paramIcon.getClass();
      localObject = ((Class)localObject).getMethod("getResPackage", new Class[0]);
      paramIcon = ((Method)localObject).invoke(paramIcon, new Object[0]);
      return (String)paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      return null;
    }
    catch (NoSuchMethodException paramIcon) {}
    return null;
  }
  
  public static String getType(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return "UNKNOWN";
            }
            return "BITMAP_MASKABLE";
          }
          return "URI";
        }
        return "DATA";
      }
      return "RESOURCE";
    }
    return "BITMAP";
  }
  
  public static IconCompat setValue(Bundle paramBundle)
  {
    int j = paramBundle.getInt("type");
    IconCompat localIconCompat = new IconCompat(j);
    a = paramBundle.getInt("int1");
    b = paramBundle.getInt("int2");
    if (paramBundle.containsKey("tint_list")) {
      state = ((ColorStateList)paramBundle.getParcelable("tint_list"));
    }
    if (paramBundle.containsKey("tint_mode")) {
      type = PorterDuff.Mode.valueOf(paramBundle.getString("tint_mode"));
    }
    if ((j != -1) && (j != 1))
    {
      if (j != 2) {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j == 5) {
              break label143;
            }
            f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unknown type ", j);
            return null;
          }
        }
        else
        {
          x = paramBundle.getByteArray("obj");
          return localIconCompat;
        }
      }
      x = paramBundle.getString("obj");
      return localIconCompat;
    }
    label143:
    x = paramBundle.getParcelable("obj");
    return localIconCompat;
  }
  
  public static IconCompat shrink(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      IconCompat localIconCompat = new IconCompat(1);
      x = paramBitmap;
      return localIconCompat;
    }
    throw new IllegalArgumentException("Bitmap must not be null.");
  }
  
  public static Uri toString(Icon paramIcon)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramIcon.getUri();
    }
    try
    {
      Object localObject = paramIcon.getClass();
      localObject = ((Class)localObject).getMethod("getUri", new Class[0]);
      paramIcon = ((Method)localObject).invoke(paramIcon, new Object[0]);
      return (Uri)paramIcon;
    }
    catch (IllegalAccessException paramIcon)
    {
      return null;
    }
    catch (InvocationTargetException paramIcon)
    {
      return null;
    }
    catch (NoSuchMethodException paramIcon) {}
    return null;
  }
  
  public static Bitmap transform(Bitmap paramBitmap, boolean paramBoolean)
  {
    int j = (int)(Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) * 0.6666667F);
    Bitmap localBitmap = Bitmap.createBitmap(j, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint(3);
    float f1 = j;
    float f2 = 0.5F * f1;
    float f3 = 0.9166667F * f2;
    if (paramBoolean)
    {
      float f4 = 0.010416667F * f1;
      localPaint.setColor(0);
      localPaint.setShadowLayer(f4, 0.0F, f1 * 0.020833334F, 1023410176);
      localCanvas.drawCircle(f2, f2, f3, localPaint);
      localPaint.setShadowLayer(f4, 0.0F, 0.0F, 503316480);
      localCanvas.drawCircle(f2, f2, f3, localPaint);
      localPaint.clearShadowLayer();
    }
    localPaint.setColor(-16777216);
    Object localObject = Shader.TileMode.CLAMP;
    localObject = new BitmapShader(paramBitmap, (Shader.TileMode)localObject, (Shader.TileMode)localObject);
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-(paramBitmap.getWidth() - j) / 2, -(paramBitmap.getHeight() - j) / 2);
    ((Shader)localObject).setLocalMatrix(localMatrix);
    localPaint.setShader((Shader)localObject);
    localCanvas.drawCircle(f2, f2, f3, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }
  
  public int a()
  {
    if ((c == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return b((Icon)x);
    }
    if (c == 2) {
      return a;
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("called getResId() on ", this));
  }
  
  public IconCompat a(int paramInt)
  {
    return a(ColorStateList.valueOf(paramInt));
  }
  
  public IconCompat a(ColorStateList paramColorStateList)
  {
    state = paramColorStateList;
    return this;
  }
  
  public IconCompat a(PorterDuff.Mode paramMode)
  {
    type = paramMode;
    return this;
  }
  
  public void a(Context paramContext)
  {
    if (c == 2)
    {
      String str3 = (String)x;
      if (!str3.contains(":")) {
        return;
      }
      String str2 = str3.split(":", -1)[1];
      String str1 = str2.split("/", -1)[0];
      str2 = str2.split("/", -1)[1];
      str3 = str3.split(":", -1)[0];
      int j = get(paramContext, str3).getIdentifier(str2, str1, str3);
      if (a != j)
      {
        paramContext = new StringBuilder();
        paramContext.append("Id has changed for ");
        paramContext.append(str3);
        paramContext.append("/");
        paramContext.append(str2);
        paramContext.toString();
        a = j;
      }
    }
  }
  
  public void a(Intent paramIntent, Drawable paramDrawable, Context paramContext)
  {
    a(paramContext);
    int j = c;
    Object localObject;
    int k;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j == 5) {
          paramContext = transform((Bitmap)x, true);
        } else {
          throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
        }
      }
      else {
        try
        {
          paramContext = paramContext.createPackageContext(get(), 0);
          if (paramDrawable == null)
          {
            j = a;
            paramIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, j));
            return;
          }
          j = a;
          localObject = ContextCompat.getDrawable(paramContext, j);
          j = ((Drawable)localObject).getIntrinsicWidth();
          if (j > 0)
          {
            j = ((Drawable)localObject).getIntrinsicHeight();
            if (j > 0)
            {
              j = ((Drawable)localObject).getIntrinsicWidth();
              k = ((Drawable)localObject).getIntrinsicHeight();
              paramContext = Bitmap.Config.ARGB_8888;
              paramContext = Bitmap.createBitmap(j, k, paramContext);
              break label193;
            }
          }
          paramContext = paramContext.getSystemService("activity");
          paramContext = (ActivityManager)paramContext;
          j = paramContext.getLauncherLargeIconSize();
          paramContext = Bitmap.Config.ARGB_8888;
          paramContext = Bitmap.createBitmap(j, j, paramContext);
          label193:
          ((Drawable)localObject).setBounds(0, 0, paramContext.getWidth(), paramContext.getHeight());
          ((Drawable)localObject).draw(new Canvas(paramContext));
        }
        catch (PackageManager.NameNotFoundException paramIntent)
        {
          paramDrawable = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Can't find package ");
          paramDrawable.append(x);
          throw new IllegalArgumentException(paramDrawable.toString(), paramIntent);
        }
      }
    }
    else
    {
      localObject = (Bitmap)x;
      paramContext = (Context)localObject;
      if (paramDrawable != null) {
        paramContext = ((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true);
      }
    }
    if (paramDrawable != null)
    {
      j = paramContext.getWidth();
      k = paramContext.getHeight();
      paramDrawable.setBounds(j / 2, k / 2, j, k);
      paramDrawable.draw(new Canvas(paramContext));
    }
    paramIntent.putExtra("android.intent.extra.shortcut.ICON", paramContext);
  }
  
  public int b()
  {
    if ((c == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return a((Icon)x);
    }
    return c;
  }
  
  public Uri clear()
  {
    if ((c == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return toString((Icon)x);
    }
    return Uri.parse((String)x);
  }
  
  public void encode(boolean paramBoolean)
  {
    i = type.name();
    int j = c;
    if (j != -1)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5) {}
            }
            else {
              s = x.toString().getBytes(Charset.forName("UTF-16"));
            }
          }
          else {
            s = ((byte[])x);
          }
        }
        else
        {
          s = ((String)x).getBytes(Charset.forName("UTF-16"));
          return;
        }
      }
      if (paramBoolean)
      {
        Bitmap localBitmap = (Bitmap)x;
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, localByteArrayOutputStream);
        s = localByteArrayOutputStream.toByteArray();
        return;
      }
      left = ((Parcelable)x);
      return;
    }
    if (!paramBoolean)
    {
      left = ((Parcelable)x);
      return;
    }
    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
  }
  
  public String get()
  {
    if ((c == -1) && (Build.VERSION.SDK_INT >= 23)) {
      return get((Icon)x);
    }
    if (c == 2) {
      return ((String)x).split(":", -1)[0];
    }
    throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("called getResPackage() on ", this));
  }
  
  public Drawable getDrawable(Context paramContext)
  {
    a(paramContext);
    if (Build.VERSION.SDK_INT >= 23) {
      return remove().loadDrawable(paramContext);
    }
    paramContext = doInBackground(paramContext);
    if ((paramContext != null) && ((state != null) || (type != context)))
    {
      paramContext.mutate();
      DrawableCompat.setTintList(paramContext, state);
      DrawableCompat.setTintMode(paramContext, type);
    }
    return paramContext;
  }
  
  public void init()
  {
    type = PorterDuff.Mode.valueOf(i);
    int j = c;
    if (j != -1)
    {
      if (j != 1)
      {
        if (j != 2) {
          if (j != 3)
          {
            if (j != 4) {
              if (j == 5) {
                break label78;
              }
            }
          }
          else
          {
            x = s;
            return;
          }
        }
        x = new String(s, Charset.forName("UTF-16"));
        return;
      }
      label78:
      localObject = left;
      if (localObject != null)
      {
        x = localObject;
        return;
      }
      localObject = s;
      x = localObject;
      c = 3;
      a = 0;
      b = localObject.length;
      return;
    }
    Object localObject = left;
    if (localObject != null)
    {
      x = localObject;
      return;
    }
    throw new IllegalArgumentException("Invalid icon");
  }
  
  public Icon remove()
  {
    int j = c;
    Object localObject;
    if (j != -1)
    {
      Icon localIcon;
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5)
              {
                if (Build.VERSION.SDK_INT >= 26) {
                  localIcon = Icon.createWithAdaptiveBitmap((Bitmap)x);
                } else {
                  localIcon = Icon.createWithBitmap(transform((Bitmap)x, false));
                }
              }
              else {
                throw new IllegalArgumentException("Unknown type");
              }
            }
            else {
              localIcon = Icon.createWithContentUri((String)x);
            }
          }
          else {
            localIcon = Icon.createWithData((byte[])x, a, b);
          }
        }
        else {
          localIcon = Icon.createWithResource(get(), a);
        }
      }
      else {
        localIcon = Icon.createWithBitmap((Bitmap)x);
      }
      localObject = state;
      if (localObject != null) {
        localIcon.setTintList((ColorStateList)localObject);
      }
      PorterDuff.Mode localMode = type;
      localObject = localIcon;
      if (localMode != context)
      {
        localIcon.setTintMode(localMode);
        return localIcon;
      }
    }
    else
    {
      localObject = (Icon)x;
    }
    return localObject;
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    int j = c;
    if (j != -1)
    {
      if (j != 1)
      {
        if (j != 2) {
          if (j != 3)
          {
            if (j != 4)
            {
              if (j == 5) {
                break label89;
              }
              throw new IllegalArgumentException("Invalid icon");
            }
          }
          else
          {
            localBundle.putByteArray("obj", (byte[])x);
            break label118;
          }
        }
        localBundle.putString("obj", (String)x);
        break label118;
      }
      label89:
      localBundle.putParcelable("obj", (Bitmap)x);
    }
    else
    {
      localBundle.putParcelable("obj", (Parcelable)x);
    }
    label118:
    localBundle.putInt("type", c);
    localBundle.putInt("int1", a);
    localBundle.putInt("int2", b);
    Object localObject = state;
    if (localObject != null) {
      localBundle.putParcelable("tint_list", (Parcelable)localObject);
    }
    localObject = type;
    if (localObject != context) {
      localBundle.putString("tint_mode", ((Enum)localObject).name());
    }
    return localBundle;
  }
  
  public String toString()
  {
    if (c == -1) {
      return String.valueOf(x);
    }
    StringBuilder localStringBuilder = new StringBuilder("Icon(typ=");
    localStringBuilder.append(getType(c));
    int j = c;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5) {
              break label235;
            }
          }
          else
          {
            localStringBuilder.append(" uri=");
            localStringBuilder.append(x);
            break label235;
          }
        }
        else
        {
          localStringBuilder.append(" len=");
          localStringBuilder.append(a);
          if (b == 0) {
            break label235;
          }
          localStringBuilder.append(" off=");
          localStringBuilder.append(b);
          break label235;
        }
      }
      else
      {
        localStringBuilder.append(" pkg=");
        localStringBuilder.append(get());
        localStringBuilder.append(" id=");
        localStringBuilder.append(String.format("0x%08x", new Object[] { Integer.valueOf(a()) }));
        break label235;
      }
    }
    localStringBuilder.append(" size=");
    localStringBuilder.append(((Bitmap)x).getWidth());
    localStringBuilder.append("x");
    localStringBuilder.append(((Bitmap)x).getHeight());
    label235:
    if (state != null)
    {
      localStringBuilder.append(" tint=");
      localStringBuilder.append(state);
    }
    if (type != context)
    {
      localStringBuilder.append(" mode=");
      localStringBuilder.append(type);
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.a})
  public static @interface a {}
}
