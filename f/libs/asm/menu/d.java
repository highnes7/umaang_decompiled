package f.libs.asm.menu;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import l.a.a.a.a.g.f;

public class d
{
  public final ac a;
  public final AlertDialog.Builder b;
  
  public d(AlertDialog.Builder paramBuilder, ac paramAc)
  {
    a = paramAc;
    b = paramBuilder;
  }
  
  public static d a(Activity paramActivity, f paramF, Sequence paramSequence)
  {
    ac localAc = new ac();
    MethodWriter localMethodWriter = new MethodWriter(paramActivity, paramF);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    paramActivity = onCreateView(paramActivity, localMethodWriter.d());
    AbstractMainActivity.1 local1 = new AbstractMainActivity.1(localAc);
    localBuilder.setView(paramActivity).setTitle(localMethodWriter.a()).setCancelable(false).setNeutralButton(localMethodWriter.b(), local1);
    if (w)
    {
      paramActivity = new n(localAc);
      localBuilder.setNegativeButton(localMethodWriter.f(), paramActivity);
    }
    if (f)
    {
      paramActivity = new FileBrowserHelper.2(paramSequence, localAc);
      localBuilder.setPositiveButton(localMethodWriter.c(), paramActivity);
    }
    return new d(localBuilder, localAc);
  }
  
  public static int dpToPx(float paramFloat, int paramInt)
  {
    return (int)(paramFloat * paramInt);
  }
  
  public static ScrollView onCreateView(Activity paramActivity, String paramString)
  {
    float f = getResourcesgetDisplayMetricsdensity;
    int i = dpToPx(f, 5);
    TextView localTextView = new TextView(paramActivity);
    localTextView.setAutoLinkMask(15);
    localTextView.setText(paramString);
    localTextView.setTextAppearance(paramActivity, 16973892);
    localTextView.setPadding(i, i, i, i);
    localTextView.setFocusable(false);
    paramActivity = new ScrollView(paramActivity);
    paramActivity.setPadding(dpToPx(f, 14), dpToPx(f, 2), dpToPx(f, 10), dpToPx(f, 12));
    paramActivity.addView(localTextView);
    return paramActivity;
  }
  
  public boolean a()
  {
    return a.a();
  }
  
  public void b()
  {
    b.show();
  }
  
  public void c()
  {
    a.get();
  }
}
