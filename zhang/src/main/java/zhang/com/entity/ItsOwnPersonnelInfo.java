package zhang.com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 自有人员信息表
 * </p>
 *
 * @author zhangnianlei
 * @since 2020-02-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ItsOwnPersonnelInfo对象", description="自有人员信息表")
public class ItsOwnPersonnelInfo implements CommonField {

    private static final long serialVersionUID = 1L;

    @Id
    @Length(max = 6, message = "租户编号长度不能大于6")
    @Column(name = "tenants_no")
    private String tenantsNo;

    @Id
    @Length(max = 20, message = "内部自有人员ID长度不能大于20")
    @Column(name = "internl_sys_no")
    private String internlOwPersonId;

    @ApiModelProperty(value = "自有人员ID")
    private String owPersonId;

    @ApiModelProperty(value = "自有人员姓名")
    private String owPersonName;

    @ApiModelProperty(value = "自有人员工号")
    private String owPersonEmployeeId;

    @ApiModelProperty(value = "部门编号")
    private String deptNo;

    @ApiModelProperty(value = "手机号码")
    private String mobileNumbr;

    @ApiModelProperty(value = "邮箱地址")
    private String emailAddr;

    @ApiModelProperty(value = "职务名称")
    private String dutyNm;

    @ApiModelProperty(value = "职级代码")
    private String rankCd;

    @ApiModelProperty(value = "职位名称")
    private String positionNm;

    @ApiModelProperty(value = "岗位代码")
    private String postCd;

    @ApiModelProperty(value = "办公场地信息")
    private String offiPlaceInfo;

}
