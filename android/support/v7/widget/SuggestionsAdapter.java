package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import support.android.v4.content.ContextCompat;
import support.android.v4.widget.CursorAdapter;
import support.android.v4.widget.ResourceCursorAdapter;

public class SuggestionsAdapter
  extends ResourceCursorAdapter
  implements View.OnClickListener
{
  public static final boolean DBG = false;
  public static final int INVALID_INDEX = -1;
  public static final String LOG_TAG = "SuggestionsAdapter";
  public static final int QUERY_LIMIT = 50;
  public static final int REFINE_ALL = 2;
  public static final int REFINE_BY_ENTRY = 1;
  public static final int REFINE_NONE = 0;
  public boolean mClosed = false;
  public final int mCommitIconResId;
  public int mFlagsCol = -1;
  public int mIconName1Col = -1;
  public int mIconName2Col = -1;
  public final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
  public final Context mProviderContext;
  public int mQueryRefinement = 1;
  public final SearchManager mSearchManager = (SearchManager)mContext.getSystemService("search");
  public final SearchView mSearchView;
  public final SearchableInfo mSearchable;
  public int mText1Col = -1;
  public int mText2Col = -1;
  public int mText2UrlCol = -1;
  public ColorStateList mUrlColor;
  
  public SuggestionsAdapter(Context paramContext, SearchView paramSearchView, SearchableInfo paramSearchableInfo, WeakHashMap paramWeakHashMap)
  {
    super(paramContext, paramSearchView.getSuggestionRowLayout(), null, true);
    mSearchView = paramSearchView;
    mSearchable = paramSearchableInfo;
    mCommitIconResId = paramSearchView.getSuggestionCommitIconResId();
    mProviderContext = paramContext;
    mOutsideDrawablesCache = paramWeakHashMap;
  }
  
  private Drawable checkIconCache(String paramString)
  {
    paramString = (Drawable.ConstantState)mOutsideDrawablesCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.newDrawable();
  }
  
  private CharSequence formatUrl(CharSequence paramCharSequence)
  {
    if (mUrlColor == null)
    {
      localObject = new TypedValue();
      mContext.getTheme().resolveAttribute(R.attr.textColorSearchUrl, (TypedValue)localObject, true);
      mUrlColor = mContext.getResources().getColorStateList(resourceId);
    }
    Object localObject = new SpannableString(paramCharSequence);
    ((SpannableString)localObject).setSpan(new TextAppearanceSpan(null, 0, 0, mUrlColor, null), 0, paramCharSequence.length(), 33);
    return localObject;
  }
  
  private Drawable getActivityIcon(ComponentName paramComponentName)
  {
    Object localObject = mContext.getPackageManager();
    try
    {
      ActivityInfo localActivityInfo = ((PackageManager)localObject).getActivityInfo(paramComponentName, 128);
      int i = localActivityInfo.getIconResource();
      if (i == 0) {
        return null;
      }
      localObject = ((PackageManager)localObject).getDrawable(paramComponentName.getPackageName(), i, applicationInfo);
      if (localObject == null)
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Invalid icon resource ", i, " for ");
        ((StringBuilder)localObject).append(paramComponentName.flattenToShortString());
        ((StringBuilder)localObject).toString();
        return null;
      }
      return localObject;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      paramComponentName.toString();
    }
    return null;
  }
  
  private Drawable getActivityIconWithCache(ComponentName paramComponentName)
  {
    String str = paramComponentName.flattenToShortString();
    boolean bool = mOutsideDrawablesCache.containsKey(str);
    Object localObject = null;
    if (bool)
    {
      paramComponentName = (Drawable.ConstantState)mOutsideDrawablesCache.get(str);
      if (paramComponentName == null) {
        return null;
      }
      return paramComponentName.newDrawable(mProviderContext.getResources());
    }
    Drawable localDrawable = getActivityIcon(paramComponentName);
    if (localDrawable == null) {
      paramComponentName = localObject;
    } else {
      paramComponentName = localDrawable.getConstantState();
    }
    mOutsideDrawablesCache.put(str, paramComponentName);
    return localDrawable;
  }
  
  public static String getColumnString(Cursor paramCursor, String paramString)
  {
    return getStringOrNull(paramCursor, paramCursor.getColumnIndex(paramString));
  }
  
  private Drawable getDefaultIcon1(Cursor paramCursor)
  {
    paramCursor = getActivityIconWithCache(mSearchable.getSearchActivity());
    if (paramCursor != null) {
      return paramCursor;
    }
    return mContext.getPackageManager().getDefaultActivityIcon();
  }
  
  private Drawable getDrawable(Uri paramUri)
  {
    try
    {
      localObject1 = paramUri.getScheme();
      boolean bool = "android.resource".equals(localObject1);
      if (!bool) {}
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject1;
      label25:
      Object localObject2;
      label93:
      paramUri = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Icon not found: ", paramUri, ", ");
      paramUri.append(((FileNotFoundException)localFileNotFoundException).getMessage());
      paramUri.toString();
      return null;
    }
    try
    {
      localObject1 = getDrawableFromResourceUri(paramUri);
      return localObject1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      break label25;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Resource does not exist: ");
    ((StringBuilder)localObject1).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject1).toString());
    localObject1 = mProviderContext;
    localObject2 = ((Context)localObject1).getContentResolver().openInputStream(paramUri);
    if (localObject2 != null) {
      try
      {
        localObject1 = Drawable.createFromStream((InputStream)localObject2, null);
      }
      catch (Throwable localThrowable) {}
    }
    try
    {
      ((InputStream)localObject2).close();
      return localObject1;
    }
    catch (IOException localIOException1)
    {
      break label93;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Error closing icon stream for ");
    ((StringBuilder)localObject2).append(paramUri);
    ((StringBuilder)localObject2).toString();
    return localObject1;
    try
    {
      ((InputStream)localObject2).close();
    }
    catch (IOException localIOException2)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Error closing icon stream for ");
    ((StringBuilder)localObject2).append(paramUri);
    ((StringBuilder)localObject2).toString();
    throw localThrowable;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed to open ");
    localStringBuilder.append(paramUri);
    throw new FileNotFoundException(localStringBuilder.toString());
  }
  
  private Drawable getDrawableFromResourceValue(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if ("0".equals(paramString)) {
        return null;
      }
      try
      {
        int i = Integer.parseInt(paramString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("android.resource://");
        Object localObject2 = mProviderContext;
        ((StringBuilder)localObject1).append(((Context)localObject2).getPackageName());
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(i);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = checkIconCache((String)localObject1);
        if (localObject2 != null) {
          return localObject2;
        }
        localObject2 = mProviderContext;
        localObject2 = ContextCompat.getDrawable((Context)localObject2, i);
        storeInIconCache((String)localObject1, (Drawable)localObject2);
        return localObject2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject1;
        for (;;) {}
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;) {}
      }
      f.sufficientlysecure.rootcommands.util.StringBuilder.get("Icon resource not found: ", paramString);
      return null;
      localObject1 = checkIconCache(paramString);
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = getDrawable(Uri.parse(paramString));
      storeInIconCache(paramString, (Drawable)localObject1);
      return localObject1;
    }
    return null;
  }
  
  private Drawable getIcon1(Cursor paramCursor)
  {
    int i = mIconName1Col;
    if (i == -1) {
      return null;
    }
    Drawable localDrawable = getDrawableFromResourceValue(paramCursor.getString(i));
    if (localDrawable != null) {
      return localDrawable;
    }
    return getDefaultIcon1(paramCursor);
  }
  
  private Drawable getIcon2(Cursor paramCursor)
  {
    int i = mIconName2Col;
    if (i == -1) {
      return null;
    }
    return getDrawableFromResourceValue(paramCursor.getString(i));
  }
  
  public static String getStringOrNull(Cursor paramCursor, int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    try
    {
      paramCursor = paramCursor.getString(paramInt);
      return paramCursor;
    }
    catch (Exception paramCursor) {}
    return null;
  }
  
  private void setViewDrawable(ImageView paramImageView, Drawable paramDrawable, int paramInt)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      paramImageView.setVisibility(paramInt);
      return;
    }
    paramImageView.setVisibility(0);
    paramDrawable.setVisible(false, false);
    paramDrawable.setVisible(true, false);
  }
  
  private void setViewText(TextView paramTextView, CharSequence paramCharSequence)
  {
    paramTextView.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
  }
  
  private void storeInIconCache(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      mOutsideDrawablesCache.put(paramString, paramDrawable.getConstantState());
    }
  }
  
  private void updateSpinnerState(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor = paramCursor.getExtras();
    } else {
      paramCursor = null;
    }
    if ((paramCursor != null) && (paramCursor.getBoolean("in_progress"))) {}
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    paramContext = (ChildViewCache)paramView.getTag();
    int i = mFlagsCol;
    if (i != -1) {
      i = paramCursor.getInt(i);
    } else {
      i = 0;
    }
    if (mText1 != null)
    {
      paramView = getStringOrNull(paramCursor, mText1Col);
      setViewText(mText1, paramView);
    }
    if (mText2 != null)
    {
      paramView = getStringOrNull(paramCursor, mText2UrlCol);
      if (paramView != null) {
        paramView = formatUrl(paramView);
      } else {
        paramView = getStringOrNull(paramCursor, mText2Col);
      }
      TextView localTextView;
      if (TextUtils.isEmpty((CharSequence)paramView))
      {
        localTextView = mText1;
        if (localTextView != null)
        {
          localTextView.setSingleLine(false);
          mText1.setMaxLines(2);
        }
      }
      else
      {
        localTextView = mText1;
        if (localTextView != null)
        {
          localTextView.setSingleLine(true);
          mText1.setMaxLines(1);
        }
      }
      setViewText(mText2, (CharSequence)paramView);
    }
    paramView = mIcon1;
    if (paramView != null) {
      setViewDrawable(paramView, getIcon1(paramCursor), 4);
    }
    paramView = mIcon2;
    if (paramView != null) {
      setViewDrawable(paramView, getIcon2(paramCursor), 8);
    }
    int j = mQueryRefinement;
    if ((j != 2) && ((j != 1) || ((i & 0x1) == 0)))
    {
      mIconRefine.setVisibility(8);
      return;
    }
    mIconRefine.setVisibility(0);
    mIconRefine.setTag(mText1.getText());
    mIconRefine.setOnClickListener(this);
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    if (mClosed)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    else {
      try
      {
        Cursor localCursor = swapCursor(paramCursor);
        if (localCursor != null) {
          localCursor.close();
        }
        if (paramCursor != null)
        {
          int i = paramCursor.getColumnIndex("suggest_text_1");
          mText1Col = i;
          i = paramCursor.getColumnIndex("suggest_text_2");
          mText2Col = i;
          i = paramCursor.getColumnIndex("suggest_text_2_url");
          mText2UrlCol = i;
          i = paramCursor.getColumnIndex("suggest_icon_1");
          mIconName1Col = i;
          i = paramCursor.getColumnIndex("suggest_icon_2");
          mIconName2Col = i;
          i = paramCursor.getColumnIndex("suggest_flags");
          mFlagsCol = i;
          return;
        }
      }
      catch (Exception paramCursor) {}
    }
  }
  
  public void close()
  {
    changeCursor(null);
    mClosed = true;
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    String str = getStringOrNull(paramCursor, paramCursor.getColumnIndex("suggest_intent_query"));
    if (str != null) {
      return str;
    }
    if (mSearchable.shouldRewriteQueryFromData())
    {
      str = getStringOrNull(paramCursor, paramCursor.getColumnIndex("suggest_intent_data"));
      if (str != null) {
        return str;
      }
    }
    if (mSearchable.shouldRewriteQueryFromText())
    {
      paramCursor = getStringOrNull(paramCursor, paramCursor.getColumnIndex("suggest_text_1"));
      if (paramCursor != null) {
        return paramCursor;
      }
    }
    return null;
  }
  
  public Drawable getDrawableFromResourceUri(Uri paramUri)
    throws FileNotFoundException
  {
    Object localObject2 = paramUri.getAuthority();
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = mContext;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getPackageManager().getResourcesForApplication((String)localObject2);
        localList = paramUri.getPathSegments();
        if (localList != null)
        {
          i = localList.size();
          if (i != 1) {}
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        List localList;
        int i;
        continue;
      }
      try
      {
        localObject2 = localList.get(0);
        localObject2 = (String)localObject2;
        i = Integer.parseInt((String)localObject2);
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    throw new FileNotFoundException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Single path segment is not a resource ID: ", paramUri));
    if (i == 2)
    {
      i = ((Resources)localObject1).getIdentifier((String)localList.get(1), (String)localList.get(0), (String)localObject2);
      if (i != 0) {
        return ((Resources)localObject1).getDrawable(i);
      }
      throw new FileNotFoundException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("No resource found for: ", paramUri));
    }
    throw new FileNotFoundException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("More than two path segments: ", paramUri));
    throw new FileNotFoundException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("No path: ", paramUri));
    throw new FileNotFoundException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("No package found for authority: ", paramUri));
    throw new FileNotFoundException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("No authority: ", paramUri));
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = newDropDownView(mContext, mCursor, paramViewGroup);
      if (paramViewGroup != null) {
        getTagmText1.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public int getQueryRefinement()
  {
    return mQueryRefinement;
  }
  
  public Cursor getSearchManagerSuggestions(SearchableInfo paramSearchableInfo, String paramString, int paramInt)
  {
    Object localObject1 = null;
    if (paramSearchableInfo == null) {
      return null;
    }
    Object localObject2 = paramSearchableInfo.getSuggestAuthority();
    if (localObject2 == null) {
      return null;
    }
    localObject2 = new Uri.Builder().scheme("content").authority((String)localObject2).query("").fragment("");
    String str = paramSearchableInfo.getSuggestPath();
    if (str != null) {
      ((Uri.Builder)localObject2).appendEncodedPath(str);
    }
    ((Uri.Builder)localObject2).appendPath("search_suggest_query");
    str = paramSearchableInfo.getSuggestSelection();
    if (str != null)
    {
      paramSearchableInfo = new String[1];
      paramSearchableInfo[0] = paramString;
    }
    else
    {
      ((Uri.Builder)localObject2).appendPath(paramString);
      paramSearchableInfo = localObject1;
    }
    if (paramInt > 0) {
      ((Uri.Builder)localObject2).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    paramString = ((Uri.Builder)localObject2).build();
    return mContext.getContentResolver().query(paramString, null, str, paramSearchableInfo, null);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    try
    {
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    catch (RuntimeException paramView)
    {
      paramViewGroup = newView(mContext, mCursor, paramViewGroup);
      if (paramViewGroup != null) {
        getTagmText1.setText(paramView.toString());
      }
    }
    return paramViewGroup;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    paramContext = mInflater.inflate(mLayout, paramViewGroup, false);
    paramContext.setTag(new ChildViewCache(paramContext));
    ((ImageView)paramContext.findViewById(R.id.edit_query)).setImageResource(mCommitIconResId);
    return paramContext;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    updateSpinnerState(getCursor());
  }
  
  public void notifyDataSetInvalidated()
  {
    super.notifyDataSetInvalidated();
    updateSpinnerState(getCursor());
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof CharSequence)) {
      mSearchView.onQueryRefine((CharSequence)paramView);
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    } else {
      paramCharSequence = paramCharSequence.toString();
    }
    if (mSearchView.getVisibility() == 0) {
      if (mSearchView.getWindowVisibility() != 0) {
        return null;
      }
    }
    try
    {
      paramCharSequence = getSearchManagerSuggestions(mSearchable, paramCharSequence, 50);
      if (paramCharSequence == null) {
        break label68;
      }
      paramCharSequence.getCount();
      return paramCharSequence;
    }
    catch (RuntimeException paramCharSequence) {}
    return null;
    label68:
    return null;
  }
  
  public void setQueryRefinement(int paramInt)
  {
    mQueryRefinement = paramInt;
  }
  
  private static final class ChildViewCache
  {
    public final ImageView mIcon1;
    public final ImageView mIcon2;
    public final ImageView mIconRefine;
    public final TextView mText1;
    public final TextView mText2;
    
    public ChildViewCache(View paramView)
    {
      mText1 = ((TextView)paramView.findViewById(16908308));
      mText2 = ((TextView)paramView.findViewById(16908309));
      mIcon1 = ((ImageView)paramView.findViewById(16908295));
      mIcon2 = ((ImageView)paramView.findViewById(16908296));
      mIconRefine = ((ImageView)paramView.findViewById(R.id.edit_query));
    }
  }
}
