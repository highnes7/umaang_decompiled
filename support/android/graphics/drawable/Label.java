package support.android.graphics.drawable;

import android.animation.TypeEvaluator;
import b.b.x.d.d.b;
import support.android.v4.internal.PathParser;
import support.android.v4.internal.PathParser.PathDataNode;

public class Label
  implements TypeEvaluator<d.b[]>
{
  public PathParser.PathDataNode[] f;
  
  public Label() {}
  
  public Label(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    f = paramArrayOfPathDataNode;
  }
  
  public PathParser.PathDataNode[] a(float paramFloat, PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2)
  {
    if (PathParser.canMorph(paramArrayOfPathDataNode1, paramArrayOfPathDataNode2))
    {
      PathParser.PathDataNode[] arrayOfPathDataNode = f;
      if ((arrayOfPathDataNode == null) || (!PathParser.canMorph(arrayOfPathDataNode, paramArrayOfPathDataNode1))) {
        f = PathParser.deepCopyNodes(paramArrayOfPathDataNode1);
      }
      int i = 0;
      while (i < paramArrayOfPathDataNode1.length)
      {
        f[i].interpolatePathDataNode(paramArrayOfPathDataNode1[i], paramArrayOfPathDataNode2[i], paramFloat);
        i += 1;
      }
      return f;
    }
    paramArrayOfPathDataNode1 = new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    throw paramArrayOfPathDataNode1;
  }
}
