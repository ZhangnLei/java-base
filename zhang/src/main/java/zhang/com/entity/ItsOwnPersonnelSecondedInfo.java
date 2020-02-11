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
 * 自有人员借调信息表
 * </p>
 *
 * @author zhangnianlei
 * @since 2020-02-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ItsOwnPersonnelSecondedInfo对象", description="自有人员借调信息表")
public class ItsOwnPersonnelSecondedInfo implements CommonField {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户编号")
    @TableId(value = "tenants_no", type = IdType.ID_WORKER)
    private String tenantsNo;

    @ApiModelProperty(value = "内部自有人员借调编号")
    private String internlOwPersonToLoanNo;

    @ApiModelProperty(value = "内部自有人员ID")
    private String internlOwPersonId;

    @ApiModelProperty(value = "借调部门编号")
    private String toLoanDeptNo;

    @ApiModelProperty(value = "借调部门责任人ID")
    private String toLoanDeptRespsbltPersonId;

    @ApiModelProperty(value = "借调开始日期")
    private LocalDate toLoanBgnDt;

    @ApiModelProperty(value = "借调结束日期")
    private LocalDate toLoanEndDt;

    @ApiModelProperty(value = "借调状态代码")
    private String toLoanStatusCd;

}
