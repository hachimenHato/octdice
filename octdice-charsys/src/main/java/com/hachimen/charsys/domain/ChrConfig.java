package com.hachimen.charsys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.hachimen.common.annotation.Excel;
import com.hachimen.common.core.domain.BaseEntity;

/**
 * 人物卡模块基础设置对象 chr_config
 * 
 * @author hachimen
 * @date 2022-11-12
 */
public class ChrConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 值 */
    @Excel(name = "值")
    private String value;

    /** 排序 */
    @Excel(name = "排序")
    private String ord;

    /** 是否停用 */
    @Excel(name = "是否停用")
    private Integer isDelete;

    /** 操作人 */
    @Excel(name = "操作人")
    private String updateUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }
    public void setOrd(String ord) 
    {
        this.ord = ord;
    }

    public String getOrd() 
    {
        return ord;
    }
    public void setIsDelete(Integer isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() 
    {
        return isDelete;
    }
    public void setUpdateUser(String updateUser) 
    {
        this.updateUser = updateUser;
    }

    public String getUpdateUser() 
    {
        return updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("name", getName())
            .append("value", getValue())
            .append("remark", getRemark())
            .append("ord", getOrd())
            .append("isDelete", getIsDelete())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
