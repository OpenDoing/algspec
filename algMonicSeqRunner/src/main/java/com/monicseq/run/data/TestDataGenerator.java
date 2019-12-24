package com.monicseq.run.data;

import com.monicseq.run.data.generator.DateGenerator;
import com.monicseq.run.data.generator.DoubleGenerator;
import com.monicseq.run.data.generator.IntegerGenerator;
import com.monicseq.run.data.generator.StringGenerator;
import com.monicseq.run.util.StringCon;

/**
 * 随机策略生成数据
 *
 * @author Duyining
 * @date 2019/12/9
 */
public class TestDataGenerator {

    public static Object typeRunner(String type) {
        if (StringCon.INTERGER.equals(type)){
            return new IntegerGenerator();
        } else if (StringCon.STRING.equals(type)){
            return new StringGenerator();
        } else if (StringCon.DATE.equals(type)){
            return new DateGenerator();
        } else if (StringCon.Double.equals(type)){
            return new DoubleGenerator();
        }
        return null;
    }


}
