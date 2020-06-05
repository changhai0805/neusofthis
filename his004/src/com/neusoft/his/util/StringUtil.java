package com.neusoft.his.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.chart.PieChart.Data;

public class StringUtil {

  /* 
   * 判断字符串是否为空值
   *  */
  public static boolean  isBlank(String str) {
    
    if(null == str || str.trim().equals("")) {
      return true;
    } else {
      return false;
    }
  }
  
  /* 
   * 字符串转换为日期
   *  */
  public static Date strToDate(String str) {
    Date date = null;
    if(isBlank(str)) {
      return null;
    } else {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      try {
        date = sdf.parse(str);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return date;
    }
  }
  
  
  /* 
   * 日期转换为字符串
   *  */
  public static String dateToStr(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(date);
  }
  
}
