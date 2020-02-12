package zhang.com.entity;

import com.dcpms.common.core.entity.CommonField;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * 新外包人员信息表
 * </p>
 *
 * <note>
 * 没有使用lombok,需要手动添加getterandsetter方法
 * </note>
 *
 * @author zhangnianlei
 * @since 2020-02-11
 */
@Entity
@Table(name = "outsource_personnel_info_new")
public class OutsourcePersonnelInfoNew implements CommonField {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Length(max = 6,message = "租户编号长度不能大于6")
    @Column(name = "tenants_no")
    private String tenantsNo;

    @Id
    @Length(max = 20,message = "内部外包人员ID长度不能大于20")
    @Column(name = "internl_outsour_person_id")
    private String internlOutsourPersonId;

    @Length(max = 20,message = "外包人员ID长度不能大于20")
    @Column(name = "outsour_person_id")
    private String outsourPersonId;

    @Length(max = 60,message = "外包人员姓名长度不能大于60")
    @Column(name = "outsour_person_name")
    private String outsourPersonName;

    @Length(max = 2,message = "证件类型代码长度不能大于2")
    @Column(name = "certfct_typ_cd")
    private String certfctTypCd;

    @Length(max = 20,message = "证件号码长度不能大于20")
    @Column(name = "certfct_numbr")
    private String certfctNumbr;

    @Length(max = 20,message = "手机号码长度不能大于20")
    @Column(name = "mobile_numbr")
    private String mobileNumbr;

    @Length(max = 200,message = "邮箱地址长度不能大于200")
    @Column(name = "email_addr")
    private String emailAddr;

    @Length(max = 2,message = "学历代码长度不能大于2")
    @Column(name = "edct_bkg_cd")
    private String edctBkgCd;

    @Length(max = 1,message = "学位代码长度不能大于1")
    @Column(name = "degree_cd")
    private String degreeCd;

    @Length(max = 1,message = "性别代码长度不能大于1")
    @Column(name = "gender_cd")
    private String genderCd;

    /**
     * 出生日期
     */
    @Column(name = "birth_dt")
    private String birthDt;

    @Length(max = 20,message = "内部供应商编号长度不能大于20")
    @Column(name = "internl_suplr_no")
    private String internlSuplrNo;

    @Length(max = 1,message = "职级代码长度不能大于1")
    @Column(name = "rank_cd")
    private String rankCd;

    @Length(max = 120,message = "职位名称长度不能大于120")
    @Column(name = "position_nm")
    private String positionNm;

    /**
     * 合约到期日
     */
    @Column(name = "contr_matr_dt")
    private String contrMatrDt;

    @Length(max = 20,message = "雇佣部门编号长度不能大于20")
    @Column(name = "employ_dept_no")
    private String employDeptNo;

    @Length(max = 20,message = "雇佣科室编号长度不能大于20")
    @Column(name = "employ_offc_no")
    private String employOffcNo;

    @Length(max = 20,message = "雇佣科室负责人用户ID长度不能大于20")
    @Column(name = "employ_offc_princip_user_id")
    private String employOffcPrincipUserId;

    @Length(max = 20,message = "外包人员工号长度不能大于20")
    @Column(name = "outsour_person_employee_id")
    private String outsourPersonEmployeeId;

    @Length(max = 20,message = "内部合同编号长度不能大于20")
    @Column(name = "internl_contrct_no")
    private String internlContrctNo;

    /**
     * 合同到期日期
     */
    @Column(name = "contrct_matr_dt")
    private String contrctMatrDt;

    @Length(max = 2,message = "专业方向代码长度不能大于2")
    @Column(name = "profesnl_dirct_cd")
    private String profesnlDirctCd;

    @Length(max = 1,message = "岗位代码长度不能大于1")
    @Column(name = "post_cd")
    private String postCd;

    @Length(max = 1,message = "级别代码长度不能大于1")
    @Column(name = "levl_cd")
    private String levlCd;

    @Length(max = 1,message = "档次代码长度不能大于1")
    @Column(name = "grade_cd")
    private String gradeCd;

    @Length(max = 1,message = "服务类型代码长度不能大于1")
    @Column(name = "serv_typ_cd")
    private String servTypCd;

    @Length(max = 1,message = "驻场类型代码长度不能大于1")
    @Column(name = "statng_typ_cd")
    private String statngTypCd;

    @Length(max = 200,message = "办公场地信息长度不能大于200")
    @Column(name = "offi_place_info")
    private String offiPlaceInfo;

    @Length(max = 20,message = "工位编号长度不能大于20")
    @Column(name = "work_statn_no")
    private String workStatnNo;

    /**
     * 入场日期
     */
    @Column(name = "admissn_dt")
    private String admissnDt;

    /**
     * 离场日期
     */
    @Column(name = "departr_dt")
    private String departrDt;

    @Length(max = 1,message = "离场原因代码长度不能大于1")
    @Column(name = "departr_reasn_cd")
    private String departrReasnCd;

    @Length(max = 1,message = "外包人员状态代码长度不能大于1")
    @Column(name = "outsour_person_status_cd")
    private String outsourPersonStatusCd;

    @Length(max = 500,message = "综合评价信息长度不能大于500")
    @Column(name = "comphsv_aprs_info")
    private String comphsvAprsInfo;

    @Length(max = 60,message = "简历文件路径长度不能大于60")
    @Column(name = "resume_file_path")
    private String resumeFilePath;

    public String getTenantsNo() {
        return tenantsNo;
    }

    public void setTenantsNo(String tenantsNo) {
        this.tenantsNo = tenantsNo;
    }

    public String getInternlOutsourPersonId() {
        return internlOutsourPersonId;
    }

    public void setInternlOutsourPersonId(String internlOutsourPersonId) {
        this.internlOutsourPersonId = internlOutsourPersonId;
    }

    public String getOutsourPersonId() {
        return outsourPersonId;
    }

    public void setOutsourPersonId(String outsourPersonId) {
        this.outsourPersonId = outsourPersonId;
    }

    public String getOutsourPersonName() {
        return outsourPersonName;
    }

    public void setOutsourPersonName(String outsourPersonName) {
        this.outsourPersonName = outsourPersonName;
    }

    public String getCertfctTypCd() {
        return certfctTypCd;
    }

    public void setCertfctTypCd(String certfctTypCd) {
        this.certfctTypCd = certfctTypCd;
    }

    public String getCertfctNumbr() {
        return certfctNumbr;
    }

    public void setCertfctNumbr(String certfctNumbr) {
        this.certfctNumbr = certfctNumbr;
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

    public String getEdctBkgCd() {
        return edctBkgCd;
    }

    public void setEdctBkgCd(String edctBkgCd) {
        this.edctBkgCd = edctBkgCd;
    }

    public String getDegreeCd() {
        return degreeCd;
    }

    public void setDegreeCd(String degreeCd) {
        this.degreeCd = degreeCd;
    }

    public String getGenderCd() {
        return genderCd;
    }

    public void setGenderCd(String genderCd) {
        this.genderCd = genderCd;
    }

    public String getBirthDt() {
        return birthDt;
    }

    public void setBirthDt(String birthDt) {
        this.birthDt = birthDt;
    }

    public String getInternlSuplrNo() {
        return internlSuplrNo;
    }

    public void setInternlSuplrNo(String internlSuplrNo) {
        this.internlSuplrNo = internlSuplrNo;
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

    public String getContrMatrDt() {
        return contrMatrDt;
    }

    public void setContrMatrDt(String contrMatrDt) {
        this.contrMatrDt = contrMatrDt;
    }

    public String getEmployDeptNo() {
        return employDeptNo;
    }

    public void setEmployDeptNo(String employDeptNo) {
        this.employDeptNo = employDeptNo;
    }

    public String getEmployOffcNo() {
        return employOffcNo;
    }

    public void setEmployOffcNo(String employOffcNo) {
        this.employOffcNo = employOffcNo;
    }

    public String getEmployOffcPrincipUserId() {
        return employOffcPrincipUserId;
    }

    public void setEmployOffcPrincipUserId(String employOffcPrincipUserId) {
        this.employOffcPrincipUserId = employOffcPrincipUserId;
    }

    public String getOutsourPersonEmployeeId() {
        return outsourPersonEmployeeId;
    }

    public void setOutsourPersonEmployeeId(String outsourPersonEmployeeId) {
        this.outsourPersonEmployeeId = outsourPersonEmployeeId;
    }

    public String getInternlContrctNo() {
        return internlContrctNo;
    }

    public void setInternlContrctNo(String internlContrctNo) {
        this.internlContrctNo = internlContrctNo;
    }

    public String getContrctMatrDt() {
        return contrctMatrDt;
    }

    public void setContrctMatrDt(String contrctMatrDt) {
        this.contrctMatrDt = contrctMatrDt;
    }

    public String getProfesnlDirctCd() {
        return profesnlDirctCd;
    }

    public void setProfesnlDirctCd(String profesnlDirctCd) {
        this.profesnlDirctCd = profesnlDirctCd;
    }

    public String getPostCd() {
        return postCd;
    }

    public void setPostCd(String postCd) {
        this.postCd = postCd;
    }

    public String getLevlCd() {
        return levlCd;
    }

    public void setLevlCd(String levlCd) {
        this.levlCd = levlCd;
    }

    public String getGradeCd() {
        return gradeCd;
    }

    public void setGradeCd(String gradeCd) {
        this.gradeCd = gradeCd;
    }

    public String getServTypCd() {
        return servTypCd;
    }

    public void setServTypCd(String servTypCd) {
        this.servTypCd = servTypCd;
    }

    public String getStatngTypCd() {
        return statngTypCd;
    }

    public void setStatngTypCd(String statngTypCd) {
        this.statngTypCd = statngTypCd;
    }

    public String getOffiPlaceInfo() {
        return offiPlaceInfo;
    }

    public void setOffiPlaceInfo(String offiPlaceInfo) {
        this.offiPlaceInfo = offiPlaceInfo;
    }

    public String getWorkStatnNo() {
        return workStatnNo;
    }

    public void setWorkStatnNo(String workStatnNo) {
        this.workStatnNo = workStatnNo;
    }

    public String getAdmissnDt() {
        return admissnDt;
    }

    public void setAdmissnDt(String admissnDt) {
        this.admissnDt = admissnDt;
    }

    public String getDepartrDt() {
        return departrDt;
    }

    public void setDepartrDt(String departrDt) {
        this.departrDt = departrDt;
    }

    public String getDepartrReasnCd() {
        return departrReasnCd;
    }

    public void setDepartrReasnCd(String departrReasnCd) {
        this.departrReasnCd = departrReasnCd;
    }

    public String getOutsourPersonStatusCd() {
        return outsourPersonStatusCd;
    }

    public void setOutsourPersonStatusCd(String outsourPersonStatusCd) {
        this.outsourPersonStatusCd = outsourPersonStatusCd;
    }

    public String getComphsvAprsInfo() {
        return comphsvAprsInfo;
    }

    public void setComphsvAprsInfo(String comphsvAprsInfo) {
        this.comphsvAprsInfo = comphsvAprsInfo;
    }

    public String getResumeFilePath() {
        return resumeFilePath;
    }

    public void setResumeFilePath(String resumeFilePath) {
        this.resumeFilePath = resumeFilePath;
    }
}
