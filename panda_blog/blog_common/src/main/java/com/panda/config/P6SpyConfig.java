package com.panda.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import com.panda.common.util.DateUtils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * @Auther: wl
 * @Date: 2019/11/8 16:58
 * @Description:
 */
public class P6SpyConfig implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return StringUtils.isNotBlank(sql) ? DateUtils.formatFullTime(LocalDateTime.now(), DateUtils.YYYY_MM_DD_HH_MM_SS)
                + " | 耗时 " + elapsed + " ms | SQL 语句：" + StringUtils.LF + sql.replaceAll("[\\s]+", StringUtils.SPACE) + ";" : "";
    }
}
