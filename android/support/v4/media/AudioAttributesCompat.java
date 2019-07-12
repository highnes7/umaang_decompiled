package android.support.v4.media;

import android.media.AudioAttributes;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseIntArray;
import b.b.a.N;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import support.android.v4.asm.Attribute;
import support.android.v4.asm.b;

public class AudioAttributesCompat
  implements de.asm.h
{
  public static final int ABOUT_MENU_ITEM = 4;
  public static final String ACTION_SHOW_PLAYER = "android.support.v4.media.audio_attrs.CONTENT_TYPE";
  public static final String ACTION_UPDATE_ALL = "AudioAttributesCompat";
  public static final int ACTIVITY_SETTINGS = 2;
  public static final int COLUMN_CODE = 2;
  public static final int CONTEXT_MENU_DELETE_ID = 16;
  public static final int CV_CAP_PROP_BACKLIGHT = 32;
  public static final int DATA_CACHE_SIZE = 256;
  public static final int DEFAULT_BUFFER = 512;
  public static final int DELETE_CONTEXT = 8;
  public static final int DIALOG_CANCEL = 5;
  public static final int DIALOG_ID_NO_FILE_MANAGER_AVAILABLE = 2;
  public static final int DISK_CACHE_VERSION = 9;
  public static final String EVENTLOG_URL = "android.support.v4.media.audio_attrs.FRAMEWORKS";
  public static final int EXPONENT_BIAS = 1023;
  public static final String EXTRA_LOCALE = "android.support.v4.media.audio_attrs.FLAGS";
  public static final String FRAG_TAG_TIME_PICKER = "android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE";
  public static final int INITIALISATION_VECTOR_FIELD_NUMBER = 1;
  public static final int KEYCODE_MEDIA_CLOSE = 128;
  public static final int LOCATE = 8;
  public static final int MENU_DISCARD = 3;
  public static final int MENU_DOWN = 1;
  public static final int MENU_GROUP_MUSIC_FOLDER = 10;
  public static final int MENU_SPIDER = 14;
  public static final int MUSIC_NEXT = 4;
  public static final int NOT_A_TOUCH_COORDINATE = -1;
  public static final String PAGE_KEY = "android.support.v4.media.audio_attrs.USAGE";
  public static final int PES_SCRATCH_SIZE = 64;
  public static final int PRIORITY_MIDHIGH = 7;
  public static final int PROMOTE_DIALOG = 0;
  public static final int RB = 11;
  public static final int RECENT_CONTACT = 1;
  public static final int SDLK_AC_REFRESH = 273;
  public static final int SELECT_FOLDER = 12;
  public static final int SORT_MENU_ITEM = 3;
  public static final int TRANSACTION_stat = 16;
  public static final int TRANSLATE = 15;
  public static final int TYPE_DIALOG = 2;
  public static final int TYPE_EXPANDED = 1;
  public static final int TYPE_WILDCARD = 13;
  public static final int UPDATE_CONTEXT = 6;
  public static final int VIEW_LIST = 0;
  public static final int VIEW_SERIEDETAILS_CONTEXT = 4;
  public static boolean c;
  public static final SparseIntArray filterPositions = new SparseIntArray();
  public static final int[] tbl = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16 };
  public support.android.v4.asm.h b;
  
  static
  {
    filterPositions.put(5, 1);
    filterPositions.put(6, 2);
    filterPositions.put(7, 2);
    filterPositions.put(8, 1);
    filterPositions.put(9, 1);
    filterPositions.put(10, 1);
  }
  
  public AudioAttributesCompat() {}
  
  public AudioAttributesCompat(support.android.v4.asm.h paramH)
  {
    b = paramH;
  }
  
  public static int a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1)
    {
      if (paramBoolean) {
        return 1;
      }
      return 7;
    }
    int i = 0;
    if ((paramInt1 & 0x4) == 4)
    {
      if (paramBoolean) {
        return 0;
      }
      return 6;
    }
    paramInt1 = i;
    switch (paramInt2)
    {
    default: 
      break;
    case 15: 
      if (paramBoolean) {
        break label224;
      }
      return 3;
    case 13: 
      return 1;
    case 11: 
      return 10;
    case 6: 
      return 2;
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      if (paramBoolean) {
        return 0;
      }
      paramInt1 = 8;
    case 2: 
      return paramInt1;
    case 1: 
    case 12: 
    case 14: 
    case 16: 
      return 3;
    }
    if (paramBoolean)
    {
      return Integer.MIN_VALUE;
      label224:
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unknown usage value ", paramInt2, " in audio attributes"));
    }
    return 3;
  }
  
  public static AudioAttributesCompat a(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramBundle = b.c(paramBundle);
    } else {
      paramBundle = Attribute.a(paramBundle);
    }
    if (paramBundle == null) {
      return null;
    }
    return new AudioAttributesCompat(paramBundle);
  }
  
  public static AudioAttributesCompat a(Object paramObject)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (!c))
    {
      paramObject = new b((AudioAttributes)paramObject);
      AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
      b = paramObject;
      return localAudioAttributesCompat;
    }
    return null;
  }
  
  public static int b(boolean paramBoolean, AudioAttributesCompat paramAudioAttributesCompat)
  {
    return a(paramBoolean, paramAudioAttributesCompat.getFlags(), paramAudioAttributesCompat.e());
  }
  
  public static void b(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static String evaluate(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 15: 
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString("unknown usage ", paramInt);
    case 16: 
      return "USAGE_ASSISTANT";
    case 14: 
      return "USAGE_GAME";
    case 13: 
      return "USAGE_ASSISTANCE_SONIFICATION";
    case 12: 
      return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
    case 11: 
      return "USAGE_ASSISTANCE_ACCESSIBILITY";
    case 10: 
      return "USAGE_NOTIFICATION_EVENT";
    case 9: 
      return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
    case 8: 
      return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
    case 7: 
      return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
    case 6: 
      return "USAGE_NOTIFICATION_RINGTONE";
    case 5: 
      return "USAGE_NOTIFICATION";
    case 4: 
      return "USAGE_ALARM";
    case 3: 
      return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
    case 2: 
      return "USAGE_VOICE_COMMUNICATION";
    case 1: 
      return "USAGE_MEDIA";
    }
    return "USAGE_UNKNOWN";
  }
  
  public static int getType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 9: 
      return 0;
    case 10: 
      return 11;
    case 8: 
      return 3;
    case 6: 
      return 2;
    case 5: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      return 1;
    case 2: 
      return 6;
    case 1: 
    case 7: 
      return 13;
    }
    return 2;
  }
  
  public Object b()
  {
    return b.b();
  }
  
  public int c()
  {
    return b.c();
  }
  
  public int d()
  {
    return b.d();
  }
  
  public int e()
  {
    return b.e();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesCompat)) {
      return false;
    }
    paramObject = (AudioAttributesCompat)paramObject;
    support.android.v4.asm.h localH = b;
    if (localH == null)
    {
      if (b == null) {
        return true;
      }
    }
    else {
      return localH.equals(b);
    }
    return false;
  }
  
  public int findItem()
  {
    return b.a();
  }
  
  public int getContentType()
  {
    return b.getContentType();
  }
  
  public int getFlags()
  {
    return b.getFlags();
  }
  
  public int hashCode()
  {
    return b.hashCode();
  }
  
  public Bundle toBundle()
  {
    return b.toBundle();
  }
  
  public String toString()
  {
    return b.toString();
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface a {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface b {}
  
  public static abstract class c
  {
    public static final int DISK_CACHE_VERSION = 9;
    public static final int MENU_GROUP_MUSIC_FOLDER = 10;
    public static final int PRIORITY_MIDHIGH = 7;
    public static final int UPDATE_CONTEXT = 6;
    
    public c() {}
  }
  
  public static class d
  {
    public int b = -1;
    public int i = 0;
    public int k = 0;
    public int m = 0;
    
    public d() {}
    
    public d(AudioAttributesCompat paramAudioAttributesCompat)
    {
      i = paramAudioAttributesCompat.e();
      k = paramAudioAttributesCompat.getContentType();
      m = paramAudioAttributesCompat.getFlags();
      b = paramAudioAttributesCompat.d();
    }
    
    public d a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        i = 0;
        return this;
      case 16: 
        if ((!AudioAttributesCompat.c) && (Build.VERSION.SDK_INT > 25))
        {
          i = paramInt;
          return this;
        }
        i = 12;
        return this;
      }
      i = paramInt;
      return this;
    }
    
    public AudioAttributesCompat a()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
    }
    
    public d b(int paramInt)
    {
      if (paramInt != 10)
      {
        b = paramInt;
        d localD = this;
        if (Build.VERSION.SDK_INT >= 21) {
          localD = c(paramInt);
        }
        return localD;
      }
      throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
    }
    
    public d c(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid stream type ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" for AudioAttributesCompat");
        localStringBuilder.toString();
        break;
      case 10: 
        k = 1;
        break;
      case 9: 
        k = 4;
        break;
      case 8: 
        k = 4;
        break;
      case 7: 
        m = (0x1 | m);
        break;
      case 6: 
        k = 1;
        m |= 0x4;
        break;
      case 5: 
        k = 4;
        break;
      case 4: 
        k = 4;
        break;
      case 3: 
        k = 2;
        break;
      case 2: 
        k = 4;
        break;
      case 1: 
        k = 4;
        break;
      }
      k = 1;
      i = AudioAttributesCompat.getType(paramInt);
      return this;
    }
    
    public d f(int paramInt)
    {
      m = (paramInt & 0x3FF | m);
      return this;
    }
    
    public d init(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4))
      {
        i = 0;
        return this;
      }
      k = paramInt;
      return this;
    }
  }
}
