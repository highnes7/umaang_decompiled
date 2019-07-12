package m.a.javac;

import java.lang.annotation.Annotation;

public abstract interface JavacASTVisitor<A extends Annotation>
{
  public abstract CommentInfo.StartConnection preventNullAnalysis(Annotation paramAnnotation, Object paramObject);
}
