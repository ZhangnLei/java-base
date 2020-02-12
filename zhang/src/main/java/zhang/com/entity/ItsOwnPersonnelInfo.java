package zhang.com.entity;

import com.dcpms.common.core.entity.CommonField;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 自有人员信息表
 * </p>
 *
 * @author zhangnianlei
 * @since 2020-02-11
 */
@Entity
@Table(name = "its_own_personnel_info")
public class ItsOwnPersonnelInfo implements CommonField {

    private static final long serialVersionUID = 1L;

    @Id
    @Length(max = 6, message = "租户编号长度不能大于6")
    @Column(name = "tenants_no")
    private String tenantsNo;

    @Id
    @Length(max = 20, message = "内部自有人员ID长度不能大于")
    @Column("internl_ow_person_id")
    private String internlOwPersonId;

    @Length(max = 20, message = "自有人员ID长度不能大于20")
    @Column("ow_person_id")
    private String owPersonId;

    @Length(max = 60, message = "自有人员姓名长度不能大于60")
    @Column("ow_person_name")
    private String owPersonName;

    @Length(max = 20, message = "自有人员工号长度不能大于20")
    @Column("ow_person_employee_id")
    private String owPersonEmployeeId;

    @Length(max = 20, message = "部门编号长度不能大于20")
    @Column("dept_no")
    private String deptNo;

    @Length(max = 20, message = "手机号码长度不能大于20")
    @Column("mobile_numbr")
    private String mobileNumbr;

    @Length(max = 200, message = "邮箱地址长度不能大于200")
    @Column("email_addr")
    private String emailAddr;

    @Length(max = 120, message = "职务名称长度不能大于120")
    @Column("duty_nm")
    private String dutyNm;

    @Length(max = 1, message = "职级代码长度不能大于1")
    @Column("rank_cd")
    private String rankCd;

    @Length(max = 120, message = "职位名称长度不能大于120")
    @Column("position_nm")
    private String positionNm;

    @Length(max = 1, message = "岗位代码长度不能大于1")
    @Column("post_cd")
    private String postCd;

    @Length(max = 200, message = "办公场地信息长度不能大于200")
    @Column("offi_place_info")
    private String offiPlaceInfo;

    public String getTenantsNo() {
        return tenantsNo;
    }

    public void setTenantsNo(String tenantsNo) {
        this.tenantsNo = tenantsNo;
    }

    public String getInternlOwPersonId() {
        return internlOwPersonId;
    }

    public void setInternlOwPersonId(String internlOwPersonId) {
        this.internlOwPersonId = internlOwPersonId;
    }

    public String getOwPersonId() {
        return owPersonId;
    }

    public void setOwPersonId(String owPersonId) {
        this.owPersonId = owPersonId;
    }

    public String getOwPersonName() {
        return owPersonName;
    }

    public void setOwPersonName(String owPersonName) {
        this.owPersonName = owPersonName;
    }

    public String getOwPersonEmployeeId() {
        return owPersonEmployeeId;
    }

    public void setOwPersonEmployeeId(String owPersonEmployeeId) {
        this.owPersonEmployeeId = owPersonEmployeeId;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getMobileNumbr() {
        return mobileNumbr;
    }

    public void setMobileNumbr(String mobileNumbr) {
        this.mobileNumbr = mobileNumbr;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getDutyNm() {
        return dutyNm;
    }

    public void setDutyNm(String dutyNm) {
        this.dutyNm = dutyNm;
    }

    public String getRankCd() {
        return rankCd;
    }

    public void setRankCd(String rankCd) {
        this.rankCd = rankCd;
    }

    public String getPositionNm() {
        return positionNm;
    }

    public void setPositionNm(String positionNm) {
        this.positionNm = positionNm;
    }

    public String getPostCd() {
        return postCd;
    }

    public void setPostCd(String postCd) {
        this.postCd = postCd;
    }

    public String getOffiPlaceInfo() {
        return offiPlaceInfo;
    }

    public void setOffiPlaceInfo(String offiPlaceInfo) {
        this.offiPlaceInfo = offiPlaceInfo;
    }
}
