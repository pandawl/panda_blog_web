package com.panda.admin.properties;

public class ShiroProperties {

    private String anonUrl;

    /**
     * token默认有效时间 1天
     */
    private Long jwtTimeOut = 86400L;


    /**
     * 令牌默认刷新时间
     */
    private Long refreshCheckTime = 120L;

    public String getAnonUrl() {
        return anonUrl;
    }

    public void setAnonUrl(String anonUrl) {
        this.anonUrl = anonUrl;
    }

    public Long getJwtTimeOut() {
        return jwtTimeOut;
    }

    public void setJwtTimeOut(Long jwtTimeOut) {
        this.jwtTimeOut = jwtTimeOut;
    }

    public Long getRefreshCheckTime() {
        return refreshCheckTime;
    }

    public void setRefreshCheckTime(Long refreshCheckTime) {
        this.refreshCheckTime = refreshCheckTime;
    }
}
