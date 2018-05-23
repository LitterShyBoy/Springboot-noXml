package com.sszh.base.utils;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author WangJianGuo
 * @Title: $SimpleSelectInLangDriver
 * @Package com.sszh.pzycxw.utils
 * @Description: 注解in用法用具类
 * @date 2018/3/1413:34
 */
public class SimpleSelectInLangDriver extends XMLLanguageDriver implements LanguageDriver {

	private static final Pattern INPATTERN = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

	@Override
	public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {

		Matcher matcher = INPATTERN.matcher(script);
		if (matcher.find()) {
			script = matcher.replaceAll("<foreach collection=\"$1\" item=\"_item\" open=\"(\" " +
					"separator=\",\" close=\")\" >#{_item}</foreach>");
		}
		script = "<script>" + script + "</script>";
		return super.createSqlSource(configuration, script, parameterType);
	}
}