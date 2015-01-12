package com.pinyin;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/12
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 */
public class DemoPinYin {
    public static void main(String args[])
    {
        String str = "我是一二三45678";
        System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITH_TONE_MARK)); // nǐ,hǎo,shì,jiè
        System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITH_TONE_NUMBER)); // ni3,hao3,shi4,jie4
        System.out.println(PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITHOUT_TONE)); // ni,hao,shi,jie
        System.out.println(PinyinHelper.getShortPinyin(str)); // nhsj
    }
}
