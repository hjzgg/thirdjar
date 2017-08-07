package com.hjzgg.test.thirdjar.common.util;


import com.hjzgg.test.thirdjar.common.exception.BaseException;

public interface ParamsCopyHandler<O,N>{
	
	N handle(O obj) throws BaseException;
}