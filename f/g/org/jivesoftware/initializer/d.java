package f.g.org.jivesoftware.initializer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class d
{
  public static final String A = "https://www.googleapis.com/auth/cloud-platform";
  public static final String F = "https://www.googleapis.com/auth/cloud-platform.read-only";
  public static final String e = "https://www.googleapis.com/auth/devstorage.full_control";
  public static final String g = "https://www.googleapis.com/auth/devstorage.read_only";
  public static final String m = "https://www.googleapis.com/auth/devstorage.read_write";
  public static final String t = "https://www.googleapis.com/auth/bigquery.insertdata";
  public static final String w = "https://www.googleapis.com/auth/bigquery";
  
  public d() {}
  
  public static Set getFeatures()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("https://www.googleapis.com/auth/bigquery");
    localHashSet.add("https://www.googleapis.com/auth/bigquery.insertdata");
    localHashSet.add("https://www.googleapis.com/auth/cloud-platform");
    localHashSet.add("https://www.googleapis.com/auth/cloud-platform.read-only");
    localHashSet.add("https://www.googleapis.com/auth/devstorage.full_control");
    localHashSet.add("https://www.googleapis.com/auth/devstorage.read_only");
    localHashSet.add("https://www.googleapis.com/auth/devstorage.read_write");
    return Collections.unmodifiableSet(localHashSet);
  }
}
