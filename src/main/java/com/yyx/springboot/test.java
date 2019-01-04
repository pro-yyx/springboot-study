package com.yyx.springboot;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Description:
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/12/13 16:25
 */
public class test {

    private static BigDecimal bigDecimalAdd(BigDecimal... numbers) {
        BigDecimal result = new BigDecimal(0.00);
        if (numbers.length <= 0) {
            return result;
        }
        int i=numbers.length;
        while (i > 0) {
            i--;
            result= result.add(numbers[i] == null ? new BigDecimal(0.00) : numbers[i]);

        }
        return result;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
       Optional.ofNullable(test).ifPresent(str-> System.out.println(str));

    }
}
