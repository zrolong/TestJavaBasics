package com.example.generic;

/**
 * 接口中泛型字母只能用在方法中，不能用在使用在全局常量中
 *
 * @author 北飞的候鸟
 *
 * @param <T>
 */
public interface ItComparator<T> {

	int A = 2;
	void comparator(T a);
}
