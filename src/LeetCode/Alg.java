package LeetCode;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface Alg {
	public String type();
	public String com();
	public String level();
	public int num();
}
//e.g. @Alg(type=DP", com="AA", level="med", num=xx)
