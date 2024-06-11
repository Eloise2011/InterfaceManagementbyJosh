package elo.pra.vo;

import lombok.*;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-15 23:40
 */
public class ApiInfoPK {
    private String kpiCode;
    private String bdIdentify;

    public ApiInfoPK() {
        super();
    }

    public ApiInfoPK(String kpiCode, String bdIdentify) {
        super();
        this.kpiCode = kpiCode;
        this.bdIdentify = bdIdentify;
    }

    public String getKpiCode() {
        return kpiCode;
    }

    public void setKpiCode(String kpiCode) {
        this.kpiCode = kpiCode;
    }

    public String getBdIdentify() {
        return bdIdentify;
    }

    public void setBdIdentify(String bdIdentify) {
        this.bdIdentify = bdIdentify;
    }

    @Override
    public String toString() {
        return "ApiInfoPK [kpiCode=" + kpiCode + ", bdIdentify=" + bdIdentify + "]";
    }

}
