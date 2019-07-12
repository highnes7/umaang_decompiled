package support.android.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.Guideline;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import b.b.d.c.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ClassWriter
{
  public static final int A = 3;
  public static final int APPLICATION_EFFECTIVE_DATE = 37;
  public static final int AppCompatTheme_selectableItemBackground = 52;
  public static final int C = 0;
  public static final int CLASS = 13;
  public static final int COMPUTE_FRAMES = 2;
  public static final int COMPUTE_MAXS = 1;
  public static final int D = 0;
  public static final boolean DEFAULT_SHOW_WEEK_NUM = false;
  public static final int DOUBLE = 22;
  public static final int DPAD_LEFT = 21;
  public static final int E = 33;
  public static final int EXPIRES_ORDINAL = 17;
  public static final int F = 34;
  public static final int FIELD = 19;
  public static final int FIELDORMETH_INSN = 6;
  public static final int FILE_TYPE_DIVX = 31;
  public static final int FLOAT = 53;
  public static final int H = 36;
  public static final int I = 0;
  public static final int IINC_INSN = 10;
  public static final int IMETH = 1;
  public static final int IMPLVAR_INSN = 4;
  public static final int INT = 12;
  public static final int INTERCHANGE_PROFILE = 41;
  public static final int INT_7 = 55;
  public static final int ITFMETH_INSN = 7;
  public static final int Id_cbrt = 20;
  public static final int Id_slice = 15;
  public static final int J = 38;
  public static final int K = 39;
  public static final int L = 1;
  public static final int LABEL_INSN = 8;
  public static final int LDCW_INSN = 11;
  public static final int LDC_INSN = 9;
  public static final int LONG = 5;
  public static final int LOOK_INSN = 14;
  public static final int M = 35;
  public static final int MANA_INSN = 60;
  public static final int META_SAVEDC = 30;
  public static final int N = 4;
  public static final int NEXT_ALARM = 42;
  public static final int OUTPUT_MARKING = 27;
  public static final int QUIET_HOURS_DEFAULT_START_MINUTE = 0;
  public static final int RIGHT_M = 48;
  public static final int STATE_ROUND_2_VALIDATED = 40;
  public static final int STR = 28;
  public static final int SherlockTheme_windowMinWidthMinor = 49;
  public static final int TAG_AF_INFO_ARRAY = 18;
  public static final int TAG_AUDIO = 32;
  public static final int TA_BASELINE = 24;
  public static final int THIRD = 44;
  public static final int TLS_DHE_RSA_WITH_AES_128_CBC_SHA = 51;
  public static final int TRANSACTION_update = 29;
  public static final int TextView_drawableTop = 50;
  public static final int TextView_maxEms = 26;
  public static final int Theme_borderlessButtonStyle = 54;
  public static final int Theme_editTextBackground = 56;
  public static final int Theme_switchStyle = 57;
  public static final int Theme_textAppearanceSearchResultTitle = 58;
  public static final int Theme_toolbarNavigationButtonStyle = 59;
  public static final int b = -1;
  public static SparseIntArray bf;
  public static final int c = 46;
  public static final int d = 0;
  public static final int e = 5;
  public static final int f = 7;
  public static final int g = -2;
  public static final int[] h = { 0, 4, 8 };
  public static final int i = 3;
  public static final int j = 23;
  public static final int k = 1;
  public static final int l = 4;
  public static final int m = 45;
  public static final int n = 25;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 0;
  public static final int s = 8;
  public static final int t = 1;
  public static final String threshold = "ConstraintSet";
  public static final int u = 2;
  public static final int v = 0;
  public static final int version = 6;
  public static final int w = 47;
  public static final int x = 16;
  public static final int y = 43;
  public HashMap<Integer, c.a> a = new HashMap();
  
  static
  {
    bf = new SparseIntArray();
    bf.append(JsonReader.1.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintRight_toRightOf, 30);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintTop_toTopOf, 36);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    bf.append(JsonReader.1.ConstraintSet_layout_editor_absoluteX, 6);
    bf.append(JsonReader.1.ConstraintSet_layout_editor_absoluteY, 7);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintGuide_begin, 17);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintGuide_end, 18);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintGuide_percent, 19);
    bf.append(JsonReader.1.ConstraintSet_android_orientation, 27);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintStart_toEndOf, 32);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintStart_toStartOf, 33);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    bf.append(JsonReader.1.ConstraintSet_layout_goneMarginLeft, 13);
    bf.append(JsonReader.1.ConstraintSet_layout_goneMarginTop, 16);
    bf.append(JsonReader.1.ConstraintSet_layout_goneMarginRight, 14);
    bf.append(JsonReader.1.ConstraintSet_layout_goneMarginBottom, 11);
    bf.append(JsonReader.1.ConstraintSet_layout_goneMarginStart, 15);
    bf.append(JsonReader.1.ConstraintSet_layout_goneMarginEnd, 12);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintVertical_weight, 40);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintHorizontal_weight, 39);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintHorizontal_bias, 20);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintVertical_bias, 37);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintDimensionRatio, 5);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintLeft_creator, 60);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintTop_creator, 60);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintRight_creator, 60);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintBottom_creator, 60);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintBaseline_creator, 60);
    bf.append(JsonReader.1.ConstraintSet_android_layout_marginLeft, 24);
    bf.append(JsonReader.1.ConstraintSet_android_layout_marginRight, 28);
    bf.append(JsonReader.1.ConstraintSet_android_layout_marginStart, 31);
    bf.append(JsonReader.1.ConstraintSet_android_layout_marginEnd, 8);
    bf.append(JsonReader.1.ConstraintSet_android_layout_marginTop, 34);
    bf.append(JsonReader.1.ConstraintSet_android_layout_marginBottom, 2);
    bf.append(JsonReader.1.ConstraintSet_android_layout_width, 23);
    bf.append(JsonReader.1.ConstraintSet_android_layout_height, 21);
    bf.append(JsonReader.1.ConstraintSet_android_visibility, 22);
    bf.append(JsonReader.1.ConstraintSet_android_alpha, 43);
    bf.append(JsonReader.1.ConstraintSet_android_elevation, 44);
    bf.append(JsonReader.1.ConstraintSet_android_rotationX, 45);
    bf.append(JsonReader.1.ConstraintSet_android_rotationY, 46);
    bf.append(JsonReader.1.ConstraintSet_android_scaleX, 47);
    bf.append(JsonReader.1.ConstraintSet_android_scaleY, 48);
    bf.append(JsonReader.1.ConstraintSet_android_transformPivotX, 49);
    bf.append(JsonReader.1.ConstraintSet_android_transformPivotY, 50);
    bf.append(JsonReader.1.ConstraintSet_android_translationX, 51);
    bf.append(JsonReader.1.ConstraintSet_android_translationY, 52);
    bf.append(JsonReader.1.ConstraintSet_android_translationZ, 53);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintWidth_default, 54);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintHeight_default, 55);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintWidth_max, 56);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintHeight_max, 57);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintWidth_min, 58);
    bf.append(JsonReader.1.ConstraintSet_layout_constraintHeight_min, 59);
    bf.append(JsonReader.1.ConstraintSet_android_id, 38);
  }
  
  public ClassWriter() {}
  
  private Item a(Context paramContext, AttributeSet paramAttributeSet)
  {
    Item localItem = new Item();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, JsonReader.1.ConstraintSet);
    run(localItem, paramContext);
    paramContext.recycle();
    return localItem;
  }
  
  private Item get(int paramInt)
  {
    if (!a.containsKey(Integer.valueOf(paramInt))) {
      a.put(Integer.valueOf(paramInt), new Item());
    }
    return (Item)a.get(Integer.valueOf(paramInt));
  }
  
  private String getAlignment(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefined";
    case 7: 
      return "end";
    case 6: 
      return "start";
    case 5: 
      return "baseline";
    case 4: 
      return "bottom";
    case 3: 
      return "top";
    case 2: 
      return "right";
    }
    return "left";
  }
  
  public static int getInt(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    paramInt2 = paramTypedArray.getResourceId(paramInt1, paramInt2);
    if (paramInt2 == -1) {
      return paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  private void put(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramArrayOfInt.length >= 2)
    {
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
      }
      if (paramArrayOfFloat != null) {
        get0name = paramArrayOfFloat[0];
      }
      get0version = paramInt5;
      a(paramArrayOfInt[0], paramInt6, paramInt1, paramInt2, -1);
      paramInt1 = 1;
      while (paramInt1 < paramArrayOfInt.length)
      {
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt5 = paramInt1 - 1;
        a(paramInt2, paramInt6, paramArrayOfInt[paramInt5], paramInt7, -1);
        a(paramArrayOfInt[paramInt5], paramInt7, paramArrayOfInt[paramInt1], paramInt6, -1);
        if (paramArrayOfFloat != null) {
          getcontext = paramArrayOfFloat[paramInt1];
        }
        paramInt1 += 1;
      }
      a(paramArrayOfInt[(paramArrayOfInt.length - 1)], paramInt7, paramInt3, paramInt4, -1);
      return;
    }
    paramArrayOfInt = new IllegalArgumentException("must have 2 or more widgets in a chain");
    throw paramArrayOfInt;
  }
  
  private void run(Item paramItem, TypedArray paramTypedArray)
  {
    int i4 = paramTypedArray.getIndexCount();
    int i1 = 0;
    while (i1 < i4)
    {
      int i5 = paramTypedArray.getIndex(i1);
      int i2 = bf.get(i5);
      StringBuilder localStringBuilder;
      if (i2 != 60)
      {
        int i3;
        switch (i2)
        {
        default: 
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unknown attribute 0x");
          localStringBuilder.append(Integer.toHexString(i5));
          localStringBuilder.append("   ");
          localStringBuilder.append(bf.get(i5));
          localStringBuilder.toString();
          break;
        case 53: 
          start = paramTypedArray.getFloat(i5, start);
          break;
        case 52: 
          width = paramTypedArray.getFloat(i5, width);
          break;
        case 51: 
          value = paramTypedArray.getFloat(i5, value);
          break;
        case 50: 
          offset = paramTypedArray.getFloat(i5, offset);
          break;
        case 49: 
          line = paramTypedArray.getFloat(i5, line);
          break;
        case 48: 
          text = paramTypedArray.getFloat(i5, text);
          break;
        case 47: 
          level = paramTypedArray.getFloat(i5, level);
          break;
        case 46: 
          time = paramTypedArray.getFloat(i5, time);
          break;
        case 45: 
          channel = paramTypedArray.getFloat(i5, channel);
          break;
        case 44: 
          date = true;
          title = paramTypedArray.getFloat(i5, title);
          break;
        case 43: 
          path = paramTypedArray.getFloat(i5, path);
          break;
        case 42: 
          state = paramTypedArray.getInt(i5, state);
          break;
        case 41: 
          version = paramTypedArray.getInt(i5, version);
          break;
        case 40: 
          name = paramTypedArray.getFloat(i5, name);
          break;
        case 39: 
          context = paramTypedArray.getFloat(i5, context);
          break;
        case 38: 
          height = paramTypedArray.getResourceId(i5, height);
          break;
        case 37: 
          w = paramTypedArray.getFloat(i5, w);
          break;
        case 36: 
          i3 = paramTypedArray.getResourceId(i5, n);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          n = i2;
          break;
        case 35: 
          i3 = paramTypedArray.getResourceId(i5, e);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          e = i2;
          break;
        case 34: 
          key = paramTypedArray.getDimensionPixelSize(i5, key);
          break;
        case 33: 
          i3 = paramTypedArray.getResourceId(i5, count);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          count = i2;
          break;
        case 32: 
          i3 = paramTypedArray.getResourceId(i5, color);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          color = i2;
          break;
        case 31: 
          position = paramTypedArray.getDimensionPixelSize(i5, position);
          break;
        case 30: 
          i3 = paramTypedArray.getResourceId(i5, v);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          v = i2;
          break;
        case 29: 
          i3 = paramTypedArray.getResourceId(i5, g);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          g = i2;
          break;
        case 28: 
          t = paramTypedArray.getDimensionPixelSize(i5, t);
          break;
        case 27: 
          a = paramTypedArray.getInt(i5, a);
          break;
        case 26: 
          i3 = paramTypedArray.getResourceId(i5, j);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          j = i2;
          break;
        case 25: 
          i3 = paramTypedArray.getResourceId(i5, k);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          k = i2;
          break;
        case 24: 
          p = paramTypedArray.getDimensionPixelSize(i5, p);
          break;
        case 23: 
          r = paramTypedArray.getLayoutDimension(i5, r);
          break;
        case 22: 
          size = paramTypedArray.getInt(i5, size);
          size = h[size];
          break;
        case 21: 
          q = paramTypedArray.getLayoutDimension(i5, q);
          break;
        case 20: 
          u = paramTypedArray.getFloat(i5, u);
          break;
        case 19: 
          i = paramTypedArray.getFloat(i5, i);
          break;
        case 18: 
          m = paramTypedArray.getDimensionPixelOffset(i5, m);
          break;
        case 17: 
          h = paramTypedArray.getDimensionPixelOffset(i5, h);
          break;
        case 16: 
          current = paramTypedArray.getDimensionPixelSize(i5, current);
          break;
        case 15: 
          next = paramTypedArray.getDimensionPixelSize(i5, next);
          break;
        case 14: 
          index = paramTypedArray.getDimensionPixelSize(i5, index);
          break;
        case 13: 
          id = paramTypedArray.getDimensionPixelSize(i5, id);
          break;
        case 12: 
          data = paramTypedArray.getDimensionPixelSize(i5, data);
          break;
        case 11: 
          length = paramTypedArray.getDimensionPixelSize(i5, length);
          break;
        case 10: 
          i3 = paramTypedArray.getResourceId(i5, s);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          s = i2;
          break;
        case 9: 
          i3 = paramTypedArray.getResourceId(i5, y);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          b = i2;
          break;
        case 8: 
          x = paramTypedArray.getDimensionPixelSize(i5, x);
          break;
        case 7: 
          min = paramTypedArray.getDimensionPixelOffset(i5, min);
          break;
        case 6: 
          flags = paramTypedArray.getDimensionPixelOffset(i5, flags);
          break;
        case 5: 
          z = paramTypedArray.getString(i5);
          break;
        case 4: 
          i3 = paramTypedArray.getResourceId(i5, b);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          b = i2;
          break;
        case 3: 
          i3 = paramTypedArray.getResourceId(i5, f);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          f = i2;
          break;
        case 2: 
          type = paramTypedArray.getDimensionPixelSize(i5, type);
          break;
        case 1: 
          i3 = paramTypedArray.getResourceId(i5, c);
          i2 = i3;
          if (i3 == -1) {
            i2 = paramTypedArray.getInt(i5, -1);
          }
          c = i2;
          break;
        }
      }
      else
      {
        localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("unused attribute 0x");
        localStringBuilder.append(Integer.toHexString(i5));
        localStringBuilder.append("   ");
        localStringBuilder.append(bf.get(i5));
        localStringBuilder.toString();
      }
      i1 += 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (a.containsKey(Integer.valueOf(paramInt)))
    {
      Item localItem = (Item)a.get(Integer.valueOf(paramInt));
      int i1 = j;
      int i2 = g;
      int i3;
      if ((i1 == -1) && (i2 == -1))
      {
        i3 = color;
        i2 = s;
        if ((i3 != -1) || (i2 != -1)) {
          if ((i3 != -1) && (i2 != -1))
          {
            a(i3, 7, i2, 6, 0);
            a(i2, 6, i1, 7, 0);
          }
          else if ((i1 != -1) || (i2 != -1))
          {
            i3 = v;
            if (i3 != -1)
            {
              a(i1, 7, i3, 7, 0);
            }
            else
            {
              i1 = k;
              if (i1 != -1) {
                a(i2, 6, i1, 6, 0);
              }
            }
          }
        }
        init(paramInt, 6);
        init(paramInt, 7);
        return;
      }
      if ((i1 != -1) && (i2 != -1))
      {
        a(i1, 2, i2, 1, 0);
        a(i2, 1, i1, 2, 0);
      }
      else if ((i1 != -1) || (i2 != -1))
      {
        i3 = v;
        if (i3 != -1)
        {
          a(i1, 2, i3, 2, 0);
        }
        else
        {
          i1 = k;
          if (i1 != -1) {
            a(i2, 1, i1, 1, 0);
          }
        }
      }
      init(paramInt, 1);
      init(paramInt, 2);
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    getu = paramFloat;
  }
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Item localItem = get(paramInt);
    offset = paramFloat2;
    line = paramFloat1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    getm = paramInt2;
    geth = -1;
    geti = -1.0F;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if (paramInt2 == 0) {
      i1 = 6;
    } else {
      i1 = 7;
    }
    a(paramInt1, 6, paramInt2, i1, 0);
    if (paramInt3 == 0) {
      i1 = 7;
    } else {
      i1 = 6;
    }
    a(paramInt1, 7, paramInt3, i1, 0);
    if (paramInt2 != 0) {
      a(paramInt2, 7, paramInt1, 6, 0);
    }
    if (paramInt3 != 0) {
      a(paramInt3, 6, paramInt1, 7, 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!a.containsKey(Integer.valueOf(paramInt1))) {
      a.put(Integer.valueOf(paramInt1), new Item());
    }
    Object localObject = (Item)a.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getAlignment(paramInt2));
      ((StringBuilder)localObject).append(" to ");
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, getAlignment(paramInt4), " unknown"));
    case 7: 
      if (paramInt4 == 7)
      {
        y = paramInt3;
        s = -1;
      }
      else
      {
        if (paramInt4 != 6) {
          break label219;
        }
        s = paramInt3;
        y = -1;
      }
      x = paramInt5;
      return;
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 6: 
      if (paramInt4 == 6)
      {
        count = paramInt3;
        color = -1;
      }
      else
      {
        if (paramInt4 != 7) {
          break label294;
        }
        color = paramInt3;
        count = -1;
      }
      position = paramInt5;
      return;
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 5: 
      if (paramInt4 == 5)
      {
        c = paramInt3;
        f = -1;
        b = -1;
        n = -1;
        e = -1;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 4: 
      if (paramInt4 == 4)
      {
        f = paramInt3;
        b = -1;
        c = -1;
      }
      else
      {
        if (paramInt4 != 3) {
          break label442;
        }
        b = paramInt3;
        f = -1;
        c = -1;
      }
      type = paramInt5;
      return;
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 3: 
      if (paramInt4 == 3)
      {
        n = paramInt3;
        e = -1;
        c = -1;
      }
      else
      {
        if (paramInt4 != 4) {
          break label527;
        }
        e = paramInt3;
        n = -1;
        c = -1;
      }
      key = paramInt5;
      return;
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 2: 
      label219:
      label294:
      label442:
      label527:
      if (paramInt4 == 1)
      {
        g = paramInt3;
        v = -1;
      }
      else
      {
        if (paramInt4 != 2) {
          break label600;
        }
        v = paramInt3;
        g = -1;
      }
      t = paramInt5;
      return;
      label600:
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    }
    if (paramInt4 == 1)
    {
      k = paramInt3;
      j = -1;
    }
    else
    {
      if (paramInt4 != 2) {
        break label673;
      }
      j = paramInt3;
      k = -1;
    }
    p = paramInt5;
    return;
    label673:
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("Left to "), getAlignment(paramInt4), " undefined"));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    if (paramInt4 >= 0)
    {
      if (paramInt7 >= 0)
      {
        if ((paramFloat > 0.0F) && (paramFloat <= 1.0F))
        {
          if ((paramInt3 != 1) && (paramInt3 != 2))
          {
            if ((paramInt3 != 6) && (paramInt3 != 7))
            {
              a(paramInt1, 3, paramInt2, paramInt3, paramInt4);
              a(paramInt1, 4, paramInt5, paramInt6, paramInt7);
              a.get(Integer.valueOf(paramInt1))).w = paramFloat;
              return;
            }
            a(paramInt1, 6, paramInt2, paramInt3, paramInt4);
            a(paramInt1, 7, paramInt5, paramInt6, paramInt7);
            a.get(Integer.valueOf(paramInt1))).u = paramFloat;
            return;
          }
          a(paramInt1, 1, paramInt2, paramInt3, paramInt4);
          a(paramInt1, 2, paramInt5, paramInt6, paramInt7);
          a.get(Integer.valueOf(paramInt1))).u = paramFloat;
          return;
        }
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
      }
      throw new IllegalArgumentException("margin must be > 0");
    }
    throw new IllegalArgumentException("margin must be > 0");
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    put(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 6, 7);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    try
    {
      for (paramInt = localXmlResourceParser.getEventType(); paramInt != 1; paramInt = localXmlResourceParser.next()) {
        if (paramInt != 0)
        {
          if (paramInt == 2)
          {
            Object localObject = localXmlResourceParser.getName();
            Item localItem = a(paramContext, Xml.asAttributeSet(localXmlResourceParser));
            boolean bool = ((String)localObject).equalsIgnoreCase("Guideline");
            if (bool) {
              d = true;
            }
            localObject = a;
            paramInt = height;
            ((HashMap)localObject).put(Integer.valueOf(paramInt), localItem);
          }
        }
        else {
          localXmlResourceParser.getName();
        }
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(ConstraintLayout paramConstraintLayout)
  {
    run(paramConstraintLayout);
    paramConstraintLayout.setConstraintSet(null);
  }
  
  public void a(ClassWriter paramClassWriter)
  {
    a.clear();
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      a.put(localInteger, ((Item)a.get(localInteger)).clone());
    }
  }
  
  public void addType(int paramInt, float paramFloat)
  {
    gettext = paramFloat;
  }
  
  public void b(int paramInt)
  {
    if (a.containsKey(Integer.valueOf(paramInt)))
    {
      Item localItem = (Item)a.get(Integer.valueOf(paramInt));
      int i2 = e;
      int i1 = b;
      if ((i2 != -1) || (i1 != -1)) {
        if ((i2 != -1) && (i1 != -1))
        {
          a(i2, 4, i1, 3, 0);
          a(i1, 3, i2, 4, 0);
        }
        else if ((i2 != -1) || (i1 != -1))
        {
          int i3 = f;
          if (i3 != -1)
          {
            a(i2, 4, i3, 4, 0);
          }
          else
          {
            i2 = n;
            if (i2 != -1) {
              a(i1, 3, i2, 3, 0);
            }
          }
        }
      }
    }
    init(paramInt, 3);
    init(paramInt, 4);
  }
  
  public void b(int paramInt, float paramFloat)
  {
    geti = paramFloat;
    getm = -1;
    geth = -1;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    getr = paramInt2;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if (paramInt2 == 0) {
      i1 = 3;
    } else {
      i1 = 4;
    }
    a(paramInt1, 3, paramInt2, i1, 0);
    if (paramInt3 == 0) {
      i1 = 4;
    } else {
      i1 = 3;
    }
    a(paramInt1, 4, paramInt3, i1, 0);
    if (paramInt2 != 0) {
      a(paramInt2, 4, paramInt1, 3, 0);
    }
    if (paramInt2 != 0) {
      a(paramInt3, 3, paramInt1, 4, 0);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    a(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    a(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    a.get(Integer.valueOf(paramInt1))).w = paramFloat;
  }
  
  public void b(int paramInt, String paramString)
  {
    getz = paramString;
  }
  
  public void b(Context paramContext, int paramInt)
  {
    onDraw((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void build(int paramInt1, int paramInt2)
  {
    getdescription = paramInt2;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      a(paramInt1, 0, 3, 0, 0, 4, 0, 0.5F);
      return;
    }
    a(paramInt1, paramInt2, 4, 0, paramInt2, 3, 0, 0.5F);
  }
  
  public void end(int paramInt1, int paramInt2)
  {
    getstatus = paramInt2;
  }
  
  public void execute(int paramInt, float paramFloat)
  {
    getcontext = paramFloat;
  }
  
  public void execute(int paramInt1, int paramInt2)
  {
    getactivity = paramInt2;
  }
  
  public void generate(int paramInt, float paramFloat)
  {
    getoffset = paramFloat;
  }
  
  public void get(int paramInt, float paramFloat)
  {
    getline = paramFloat;
  }
  
  public void get(int paramInt1, int paramInt2)
  {
    getsize = paramInt2;
  }
  
  public void inflate(int paramInt, float paramFloat)
  {
    gettime = paramFloat;
  }
  
  public void init(int paramInt, float paramFloat)
  {
    gettitle = paramFloat;
    getdate = true;
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    if (a.containsKey(Integer.valueOf(paramInt1)))
    {
      Item localItem = (Item)a.get(Integer.valueOf(paramInt1));
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("unknown constraint");
      case 7: 
        s = -1;
        y = -1;
        x = -1;
        data = -1;
        return;
      case 6: 
        color = -1;
        count = -1;
        position = -1;
        next = -1;
        return;
      case 5: 
        c = -1;
        return;
      case 4: 
        b = -1;
        f = -1;
        type = -1;
        length = -1;
        return;
      case 3: 
        e = -1;
        n = -1;
        key = -1;
        current = -1;
        return;
      case 2: 
        v = -1;
        g = -1;
        t = -1;
        index = -1;
        return;
      }
      j = -1;
      k = -1;
      p = -1;
      id = -1;
    }
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
  {
    Item localItem = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      x = paramInt3;
      return;
    case 6: 
      position = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      type = paramInt3;
      return;
    case 3: 
      key = paramInt3;
      return;
    case 2: 
      t = paramInt3;
      return;
    }
    p = paramInt3;
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a.containsKey(Integer.valueOf(paramInt1))) {
      a.put(Integer.valueOf(paramInt1), new Item());
    }
    Object localObject = (Item)a.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getAlignment(paramInt2));
      ((StringBuilder)localObject).append(" to ");
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, getAlignment(paramInt4), " unknown"));
    case 7: 
      if (paramInt4 == 7)
      {
        y = paramInt3;
        s = -1;
        return;
      }
      if (paramInt4 == 6)
      {
        s = paramInt3;
        y = -1;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 6: 
      if (paramInt4 == 6)
      {
        count = paramInt3;
        color = -1;
        return;
      }
      if (paramInt4 == 7)
      {
        color = paramInt3;
        count = -1;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 5: 
      if (paramInt4 == 5)
      {
        c = paramInt3;
        f = -1;
        b = -1;
        n = -1;
        e = -1;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 4: 
      if (paramInt4 == 4)
      {
        f = paramInt3;
        b = -1;
        c = -1;
        return;
      }
      if (paramInt4 == 3)
      {
        b = paramInt3;
        f = -1;
        c = -1;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 3: 
      if (paramInt4 == 3)
      {
        n = paramInt3;
        e = -1;
        c = -1;
        return;
      }
      if (paramInt4 == 4)
      {
        e = paramInt3;
        n = -1;
        c = -1;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    case 2: 
      if (paramInt4 == 1)
      {
        g = paramInt3;
        v = -1;
        return;
      }
      if (paramInt4 == 2)
      {
        v = paramInt3;
        g = -1;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("right to "), getAlignment(paramInt4), " undefined"));
    }
    if (paramInt4 == 1)
    {
      k = paramInt3;
      j = -1;
      return;
    }
    if (paramInt4 == 2)
    {
      j = paramInt3;
      k = -1;
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append("left to "), getAlignment(paramInt4), " undefined"));
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    a(paramInt1, 6, paramInt2, paramInt3, paramInt4);
    a(paramInt1, 7, paramInt5, paramInt6, paramInt7);
    a.get(Integer.valueOf(paramInt1))).u = paramFloat;
  }
  
  public void initialize(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      a(paramInt1, 0, 1, 0, 0, 2, 0, 0.5F);
      return;
    }
    a(paramInt1, paramInt2, 2, 0, paramInt2, 1, 0, 0.5F);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    if (paramArrayOfInt.length >= 2)
    {
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
      }
      if (paramArrayOfFloat != null) {
        get0name = paramArrayOfFloat[0];
      }
      get0state = paramInt5;
      a(paramArrayOfInt[0], 3, paramInt1, paramInt2, 0);
      paramInt1 = 1;
      while (paramInt1 < paramArrayOfInt.length)
      {
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt2 = paramArrayOfInt[paramInt1];
        paramInt5 = paramInt1 - 1;
        a(paramInt2, 3, paramArrayOfInt[paramInt5], 4, 0);
        a(paramArrayOfInt[paramInt5], 4, paramArrayOfInt[paramInt1], 3, 0);
        if (paramArrayOfFloat != null) {
          getname = paramArrayOfFloat[paramInt1];
        }
        paramInt1 += 1;
      }
      a(paramArrayOfInt[(paramArrayOfInt.length - 1)], 4, paramInt3, paramInt4, 0);
      return;
    }
    paramArrayOfInt = new IllegalArgumentException("must have 2 or more widgets in a chain");
    throw paramArrayOfInt;
  }
  
  public void newString(int paramInt1, int paramInt2)
  {
    getparent = paramInt2;
  }
  
  public void onDraw(ConstraintLayout paramConstraintLayout)
  {
    int i2 = paramConstraintLayout.getChildCount();
    a.clear();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramConstraintLayout.getChildAt(i1);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      int i3 = localView.getId();
      if (!a.containsKey(Integer.valueOf(i3))) {
        a.put(Integer.valueOf(i3), new Item());
      }
      Item localItem = (Item)a.get(Integer.valueOf(i3));
      Item.a(localItem, i3, localLayoutParams);
      size = localView.getVisibility();
      i3 = Build.VERSION.SDK_INT;
      path = localView.getAlpha();
      channel = localView.getRotationX();
      time = localView.getRotationY();
      level = localView.getScaleX();
      text = localView.getScaleY();
      line = localView.getPivotX();
      offset = localView.getPivotY();
      value = localView.getTranslationX();
      width = localView.getTranslationY();
      if (Build.VERSION.SDK_INT >= 21)
      {
        start = localView.getTranslationZ();
        if (date) {
          title = localView.getElevation();
        }
      }
      i1 += 1;
    }
  }
  
  public void process(int paramInt1, int paramInt2)
  {
    getstate = paramInt2;
  }
  
  public void put(int paramInt)
  {
    a.remove(Integer.valueOf(paramInt));
  }
  
  public void put(int paramInt, float paramFloat)
  {
    getvalue = paramFloat;
  }
  
  public void put(int paramInt, float paramFloat1, float paramFloat2)
  {
    Item localItem = get(paramInt);
    value = paramFloat1;
    width = paramFloat2;
  }
  
  public void put(int paramInt1, int paramInt2)
  {
    getbuffer = paramInt2;
  }
  
  public void put(int paramInt1, int paramInt2, int paramInt3)
  {
    Item localItem = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 7: 
      data = paramInt3;
      return;
    case 6: 
      next = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 4: 
      length = paramInt3;
      return;
    case 3: 
      current = paramInt3;
      return;
    case 2: 
      index = paramInt3;
      return;
    }
    id = paramInt3;
  }
  
  public void put(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    a(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    a.get(Integer.valueOf(paramInt1))).u = paramFloat;
  }
  
  public void put(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt5)
  {
    put(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfFloat, paramInt5, 1, 2);
  }
  
  public void put(int paramInt, boolean paramBoolean)
  {
    getdate = paramBoolean;
  }
  
  public void run(ConstraintLayout paramConstraintLayout)
  {
    int i2 = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(a.keySet());
    int i1 = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (i1 < i2)
    {
      localObject2 = paramConstraintLayout.getChildAt(i1);
      int i3 = ((View)localObject2).getId();
      if (a.containsKey(Integer.valueOf(i3)))
      {
        ((HashSet)localObject1).remove(Integer.valueOf(i3));
        localObject3 = (Item)a.get(Integer.valueOf(i3));
        localObject4 = (ConstraintLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((Item)localObject3).init((ConstraintLayout.LayoutParams)localObject4);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((View)localObject2).setVisibility(size);
        i3 = Build.VERSION.SDK_INT;
        ((View)localObject2).setAlpha(path);
        ((View)localObject2).setRotationX(channel);
        ((View)localObject2).setRotationY(time);
        ((View)localObject2).setScaleX(level);
        ((View)localObject2).setScaleY(text);
        ((View)localObject2).setPivotX(line);
        ((View)localObject2).setPivotY(offset);
        ((View)localObject2).setTranslationX(value);
        ((View)localObject2).setTranslationY(width);
        if (Build.VERSION.SDK_INT >= 21)
        {
          ((View)localObject2).setTranslationZ(start);
          if (date) {
            ((View)localObject2).setElevation(title);
          }
        }
      }
      i1 += 1;
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Integer)((Iterator)localObject1).next();
      localObject2 = (Item)a.get(localObject4);
      if (d)
      {
        localObject3 = new Guideline(paramConstraintLayout.getContext());
        ((View)localObject3).setId(((Integer)localObject4).intValue());
        localObject4 = paramConstraintLayout.generateDefaultLayoutParams();
        ((Item)localObject2).init((ConstraintLayout.LayoutParams)localObject4);
        paramConstraintLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      }
    }
  }
  
  public void save(int paramInt, float paramFloat)
  {
    getname = paramFloat;
  }
  
  public void set(int paramInt, float paramFloat)
  {
    getlevel = paramFloat;
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    Item localItem = get(paramInt1);
    d = true;
    a = paramInt2;
  }
  
  public void setState(int paramInt, float paramFloat)
  {
    getwidth = paramFloat;
  }
  
  public void toByteArray(int paramInt, float paramFloat)
  {
    getw = paramFloat;
  }
  
  public void toByteArray(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      a(paramInt1, 0, 6, 0, 0, 7, 0, 0.5F);
      return;
    }
    a(paramInt1, paramInt2, 7, 0, paramInt2, 6, 0, 0.5F);
  }
  
  public boolean toByteArray(int paramInt)
  {
    return getdate;
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    geth = paramInt2;
    getm = -1;
    geti = -1.0F;
  }
  
  public void visit(int paramInt, float paramFloat)
  {
    getstart = paramFloat;
  }
  
  public void visit(int paramInt1, int paramInt2)
  {
    getversion = paramInt2;
  }
  
  public void visitFrame(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if (paramInt2 == 0) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    a(paramInt1, 1, paramInt2, i1, 0);
    if (paramInt3 == 0) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    a(paramInt1, 2, paramInt3, i1, 0);
    if (paramInt2 != 0) {
      a(paramInt2, 2, paramInt1, 1, 0);
    }
    if (paramInt3 != 0) {
      a(paramInt3, 1, paramInt1, 2, 0);
    }
  }
  
  public void visitInnerClass(int paramInt, float paramFloat)
  {
    getchannel = paramFloat;
  }
  
  public void visitInnerClass(int paramInt1, int paramInt2)
  {
    getclient = paramInt2;
  }
  
  public void visitMethodInsn(int paramInt, float paramFloat)
  {
    getpath = paramFloat;
  }
  
  public void visitSource(int paramInt1, int paramInt2)
  {
    getq = paramInt2;
  }
}
