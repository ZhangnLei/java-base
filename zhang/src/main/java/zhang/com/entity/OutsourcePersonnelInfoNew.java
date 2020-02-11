package zhang.com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 新外包人员信息表
 * </p>
 *
 * @author zhangnianlei
 * @since 2020-02-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutsourcePersonnelInfoNew对象", description="新外包人员信息表")
public class OutsourcePersonnelInfoNew implements CommonField {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户编号")
    @TableId(value = "tenants_no", type = IdType.ID_WORKER)
    private String tenantsNo;

    @ApiModelProperty(value = "内部外包人员ID")
    private String internlOutsourPersonId;

    @ApiModelProperty(value = "外包人员ID")
    private String outsourPersonId;

    @ApiModelProperty(value = "外包人员姓名")
    private String outsourPersonName;

    @ApiModelProperty(value = "证件类型代码")
    private String certfctTypCd;

    @ApiModelProperty(value = "证件号码")
    private String certfctNumbr;

    @ApiModelProperty(value = "手机号码")
    private String mobileNumbr;

    @ApiModelProperty(value = "邮箱地址")
    private String emailAddr;

    @ApiModelProperty(value = "学历代码")
    private String edctBkgCd;

    @ApiModelProperty(value = "学位代码")
    private String degreeCd;

    @ApiModelProperty(value = "性别代码")
    private String genderCd;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthDt;

    @ApiModelProperty(value = "内部供应商编号")
    private String internlSuplrNo;

    @ApiModelProperty(value = "职级代码")
    private String rankCd;

    @ApiModelProperty(value = "职位名称")
    private String positionNm;

    @ApiModelProperty(value = "合约到期日期")
    private LocalDate contrMatrDt;

    @ApiModelProperty(value = "雇佣部门编号")
    private String employDeptNo;

    @ApiModelProperty(value = "雇佣科室编号")
    private String employOffcNo;

    @ApiModelProperty(value = "雇佣科室负责人用户ID")
    private String employOffcPrincipUserId;

    @ApiModelProperty(value = "外包人员工号")
    private String outsourPersonEmployeeId;

    @ApiModelProperty(value = "内部合同编号")
    private String internlContrctNo;

    @ApiModelProperty(value = "合同到期日期")
    private LocalDate contrctMatrDt;

    @ApiModelProperty(value = "专业方向代码")
    private String profesnlDirctCd;

    @ApiModelProperty(value = "岗位代码")
    private String postCd;

    @ApiModelProperty(value = "级别代码")
    private String levlCd;

    @ApiModelProperty(value = "档次代码")
    private String gradeCd;

    @ApiModelProperty(value = "服务类型代码")
    private String servTypCd;

    @ApiModelProperty(value = "驻场类型代码")
    private String statngTypCd;

    @ApiModelProperty(value = "办公场地信息")
    private String offiPlaceInfo;

    @ApiModelProperty(value = "工位编号")
    private String workStatnNo;

    @ApiModelProperty(value = "入场日期")
    private LocalDate admissnDt;

    @ApiModelProperty(value = "离场日期")
    private LocalDate departrDt;

    @ApiModelProperty(value = "离场原因代码")
    private String departrReasnCd;

    @ApiModelProperty(value = "外包人员状态代码")
    private String outsourPersonStatusCd;

    @ApiModelProperty(value = "综合评价信息")
    private String comphsvAprsInfo;

    @ApiModelProperty(value = "简历文件路径")
    private String resumeFilePath;

}
