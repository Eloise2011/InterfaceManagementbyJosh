package elo.pra.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import elo.pra.utils.MarkdownUtil;
import org.apache.commons.lang3.BooleanUtils;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-15 23:44
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResourceInfo {
    private final String supportName = "支持";
    private final String notSupportName = "不支持";

    private String id;
    private String name;
    /** 数据源ID */
    private String dataSourceId;
    private String sql;
    private String docContent;
    private String exampleParameters;
    private String createBy;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String updateBy;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Long versionNum;
    @JsonIgnore
    private Integer trashFlag;
    @JsonIgnore
    private String trashBy;
    //@JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private Date trashTime;
    private Boolean batchNoSupport;
    /** 是否支持后置脚本 */
    private Boolean postpositionSupport;
    private String postpositionScript;
    private Boolean cacheSupport;

    @JsonIgnore
    List<ApiInfo> apiInfos;

    /**
     * 将文档内容由markdown格式转为html格式
     *
     * @return
     */
    @JsonIgnore
    public String getDocContentAsHtml() {
        if (null == docContent || "".equals(docContent)) {
            return "";
        }
        return MarkdownUtil.render(docContent);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getDocContent() {
        return docContent;
    }

    public void setDocContent(String docContent) {
        this.docContent = docContent;
    }

    public String getExampleParameters() {
        return exampleParameters;
    }

    public void setExampleParameters(String exampleParameters) {
        this.exampleParameters = exampleParameters;
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

    public Long getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Long versionNum) {
        this.versionNum = versionNum;
    }

    public Integer getTrashFlag() {
        return trashFlag;
    }

    public void setTrashFlag(Integer trashFlag) {
        this.trashFlag = trashFlag;
    }

    public String getTrashBy() {
        return trashBy;
    }

    public void setTrashBy(String trashBy) {
        this.trashBy = trashBy;
    }

    public Date getTrashTime() {
        return trashTime;
    }

    public void setTrashTime(Date trashTime) {
        this.trashTime = trashTime;
    }

    public List<ApiInfo> getApiInfos() {
        return apiInfos;
    }

    public void setApiInfos(List<ApiInfo> apiInfos) {
        this.apiInfos = apiInfos;
    }

    public Boolean getBatchNoSupport() {
        return BooleanUtils.isTrue(batchNoSupport);
    }

    public void setBatchNoSupport(Boolean batchNoSupport) {
        this.batchNoSupport = batchNoSupport;
    }

    public Boolean getPostpositionSupport() {
        return BooleanUtils.isTrue(postpositionSupport);
    }

    public void setPostpositionSupport(Boolean postpositionSupport) {
        this.postpositionSupport = postpositionSupport;
    }

    public String getPostpositionScript() {
        return postpositionScript;
    }

    public void setPostpositionScript(String postpositionScript) {
        this.postpositionScript = postpositionScript;
    }

    public Boolean getCacheSupport() {
        return BooleanUtils.isTrue(cacheSupport);
    }

    public void setCacheSupport(Boolean cacheSupport) {
        this.cacheSupport = cacheSupport;
    }

    @Override
    public String toString() {
        return "ApiResourceInfo [supportName=" + supportName + ", notSupportName=" + notSupportName + ", id=" + id
                + ", name=" + name + ", dataSourceId=" + dataSourceId + ", sql=" + sql + ", docContent=" + docContent
                + ", exampleParameters=" + exampleParameters + ", createBy=" + createBy + ", createTime=" + createTime
                + ", updateBy=" + updateBy + ", updateTime=" + updateTime + ", versionNum=" + versionNum
                + ", trashFlag=" + trashFlag + ", trashBy=" + trashBy + ", trashTime=" + trashTime + ", batchNoSupport="
                + batchNoSupport + ", postpositionSupport=" + postpositionSupport + ", postpositionScript="
                + postpositionScript + ", cacheSupport=" + cacheSupport + ", apiInfos=" + apiInfos + "]";
    }

    @JsonIgnore
    public String getBatchNoSupportDesc() {
        return getBatchNoSupport() ? supportName : notSupportName;
    }

    @JsonIgnore
    public String getPostpositionSupportDesc() {
        return getPostpositionSupport() ? supportName : notSupportName;
    }

    @JsonIgnore
    public String getCacheSupportDesc() {
        return getCacheSupport() ? supportName : notSupportName;
    }

}
