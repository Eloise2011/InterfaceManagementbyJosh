package elo.pra.vo;

import java.util.Date;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-15 23:43
 */
public class ApiModule {
    private Long id;
    private String name;
    private Integer sortFlag;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

    private List<ApiInfo> apiInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortFlag() {
        return sortFlag;
    }

    public void setSortFlag(Integer sortFlag) {
        this.sortFlag = sortFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<ApiInfo> getApiInfos() {
        return apiInfos;
    }

    public void setApiInfos(List<ApiInfo> apiInfos) {
        this.apiInfos = apiInfos;
    }

    @Override
    public String toString() {
        return "ApiModule [id=" + id + ", name=" + name + ", sortFlag=" + sortFlag + ", createBy=" + createBy
                + ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime + ", apiInfos="
                + apiInfos + "]";
    }

}

