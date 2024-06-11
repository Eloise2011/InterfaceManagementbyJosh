package elo.pra.vo;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-05-13 13:36
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * API信息
 *
 * @author EX_HUANGSL1
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiInfo extends ApiInfoPK {
    private String resourceId;
    private String schemaName;
    private String tableName;
    private String description;
    private Integer statusFlag;
    private String createBy;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String updateBy;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Long moduleId;
    //@JsonIgnore
    private ApiResourceInfo apiResourceInfo;
    @JsonIgnore
    private ApiModule apiModule;
    private Long versionNum;
    @JsonIgnore
    private Integer trashFlag;
    @JsonIgnore
    private String trashBy;
    @JsonIgnore
    private Date trashTime;

    @JsonIgnore
    public String getStatusFlagDesc() {
        return 1 == statusFlag ? "启用" : "停用";
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(Integer statusFlag) {
        this.statusFlag = statusFlag;
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

    public ApiResourceInfo getApiResourceInfo() {
        return apiResourceInfo;
    }

    public void setApiResourceInfo(ApiResourceInfo apiResourceInfo) {
        this.apiResourceInfo = apiResourceInfo;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public ApiModule getApiModule() {
        return apiModule;
    }

    public void setApiModule(ApiModule apiModule) {
        this.apiModule = apiModule;
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

    @Override
    public String toString() {
        return "ApiInfo [resourceId=" + resourceId + ", schemaName=" + schemaName + ", tableName=" + tableName
                + ", description=" + description + ", statusFlag=" + statusFlag + ", createBy=" + createBy
                + ", createTime=" + createTime + ", updateBy=" + updateBy + ", updateTime=" + updateTime + ", moduleId="
                + moduleId + ", apiResourceInfo=" + apiResourceInfo + ", apiModule=" + apiModule + ", versionNum="
                + versionNum + ", trashFlag=" + trashFlag + ", trashBy=" + trashBy + ", trashTime=" + trashTime + "]";
    }

}