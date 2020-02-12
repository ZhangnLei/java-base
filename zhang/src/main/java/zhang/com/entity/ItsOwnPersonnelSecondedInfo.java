package zhang.com.entity;

import com.dcpms.common.core.entity.CommonField;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 自有人员借调信息表
 * </p>
 *
 * @author zhangnianlei
 * @since 2020-02-11
 */
@Entity
@Table(name = "its_own_personnel_seconded_info")
public class ItsOwnPersonnelSecondedInfo implements CommonField {

    private static final long serialVersionUID = 1L;

    @Id
    @Length(max = 6,message = "租户编号长度不能大于6")
    @Column(name = "tenants_no")
    private String tenantsNo;

    @Id
    @Length(max = 20,message = "内部自有人员借调编号长度不能大于20")
    @Column(name = "internl_ow_person_to_loan_no")
    private String internlOwPersonToLoanNo;

    @Length(max = 20,message = "内部自有人员ID长度不能大于20")
    @Column(name = "internl_ow_person_id")
    private String internlOwPersonId;

    @Length(max = 20,message = "借调部门编号长度不能大于20")
    @Column(name = "to_loan_dept_no")
    private String toLoanDeptNo;

    @Length(max = 20,message = "借调部门责任人ID长度不能大于20")
    @Column(name = "to_loan_dept_respsblt_person_id")
    private String toLoanDeptRespsbltPersonId;

    /**
     * 借调开始日期
     */
    @Column(name = "to_loan_bgn_dt")
    private String toLoanBgnDt;

    /**
     * 借调结束日期
     */
    @Column(name = "to_loan_end_dt")
    private String toLoanEndDt;

    @Length(max = 1,message = "借调状态代码长度不能大于1")
    @Column(name = "to_loan_status_cd")
    private String toLoanStatusCd;

    public String getTenantsNo() {
        return tenantsNo;
    }

    public void setTenantsNo(String tenantsNo) {
        this.tenantsNo = tenantsNo;
    }

    public String getInternlOwPersonToLoanNo() {
        return internlOwPersonToLoanNo;
    }

    public void setInternlOwPersonToLoanNo(String internlOwPersonToLoanNo) {
        this.internlOwPersonToLoanNo = internlOwPersonToLoanNo;
    }

    public String getInternlOwPersonId() {
        return internlOwPersonId;
    }

    public void setInternlOwPersonId(String internlOwPersonId) {
        this.internlOwPersonId = internlOwPersonId;
    }

    public String getToLoanDeptNo() {
        return toLoanDeptNo;
    }

    public void setToLoanDeptNo(String toLoanDeptNo) {
        this.toLoanDeptNo = toLoanDeptNo;
    }

    public String getToLoanDeptRespsbltPersonId() {
        return toLoanDeptRespsbltPersonId;
    }

    public void setToLoanDeptRespsbltPersonId(String toLoanDeptRespsbltPersonId) {
        this.toLoanDeptRespsbltPersonId = toLoanDeptRespsbltPersonId;
    }

    public String getToLoanBgnDt() {
        return toLoanBgnDt;
    }

    public void setToLoanBgnDt(String toLoanBgnDt) {
        this.toLoanBgnDt = toLoanBgnDt;
    }

    public String getToLoanEndDt() {
        return toLoanEndDt;
    }

    public void setToLoanEndDt(String toLoanEndDt) {
        this.toLoanEndDt = toLoanEndDt;
    }

    public String getToLoanStatusCd() {
        return toLoanStatusCd;
    }

    public void setToLoanStatusCd(String toLoanStatusCd) {
        this.toLoanStatusCd = toLoanStatusCd;
    }
}
