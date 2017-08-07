package com.hjzgg.test.thirdjar.common.util.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelExtend {
	String headerName() default "";
}
