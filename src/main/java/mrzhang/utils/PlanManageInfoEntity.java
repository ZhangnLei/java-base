package mrzhang.utils;


import lombok.Data;
import org.apache.commons.lang.time.DateUtils;

import java.util.Objects;

/**
 *
 * @Description: 计划实体
 * @CopyRightInformation : 数云
 * @Prject: 数云PMS
 * @ApplicationName: dcpms-common-core
 * @Title: PlanManageInfoEntity.java
 * @Package: com.dcpms.common.core.db.entity
 * @author: Frank
 * @date: 2019年1月11日 上午11:35:05
 * @version: V1.0
 */
@Data
public class PlanManageInfoEntity implements Comparable{

	private static final long serialVersionUID = -4971141112895360664L;

	private String orgAcct;			//机构号

	private String projectNo;		//项目编号

	private String planItemInnerNo;	//内部计划编号

	private String planItemOuterNo;		//外部计划编号

	private String planItemName;		//计划名称

	private String planItemDesc;			//计划描述

	private String planItemLevel;		//计划级别

	private String pPlanNos;		//计划祖先节点集合

	private String pPlanName;		//父计划名称

	private String workGroupNo;		//工作组编号

	private String workGroupName;		//工作组名称

	private String planLevelNo;		//计划级别编号

	private String planLevelName;		//计划级别名称

	private String planBeginTime;		//计划开始时间

	private Integer referenceProcess;	//参考进度

	private Integer process;	//进度

	private String planEndTime;		//计划结束时间

	private Integer dutyUserId;		//责任人id

	private String dutyUserName;		//责任人姓名

	private String stakeholderIds;		//干系人id

	private String commentArea;		//评论区

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PlanManageInfoEntity)) return false;
		PlanManageInfoEntity that = (PlanManageInfoEntity) o;
		return orgAcct.equals(that.orgAcct) &&
				projectNo.equals(that.projectNo) &&
				planItemInnerNo.equals(that.planItemInnerNo) &&
				Objects.equals(planItemOuterNo, that.planItemOuterNo) &&
				Objects.equals(planItemName, that.planItemName) &&
				Objects.equals(planItemDesc, that.planItemDesc) &&
				Objects.equals(planItemLevel, that.planItemLevel) &&
				Objects.equals(pPlanNos, that.pPlanNos) &&
				Objects.equals(pPlanName, that.pPlanName) &&
				Objects.equals(workGroupNo, that.workGroupNo) &&
				Objects.equals(workGroupName, that.workGroupName) &&
				Objects.equals(planLevelNo, that.planLevelNo) &&
				Objects.equals(planLevelName, that.planLevelName) &&
				Objects.equals(planBeginTime, that.planBeginTime) &&
				Objects.equals(referenceProcess, that.referenceProcess) &&
				Objects.equals(process, that.process) &&
				Objects.equals(planEndTime, that.planEndTime) &&
				Objects.equals(dutyUserId, that.dutyUserId) &&
				Objects.equals(dutyUserName, that.dutyUserName) &&
				Objects.equals(stakeholderIds, that.stakeholderIds) &&
				Objects.equals(commentArea, that.commentArea);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orgAcct, projectNo, planItemInnerNo);
	}

	public PlanManageInfoEntity(String planItemInnerNo) {
		this.planItemInnerNo = planItemInnerNo;
	}

	@Override
	public int compareTo(Object o) {
		PlanManageInfoEntity p = (PlanManageInfoEntity)o;
		return this.planItemInnerNo.compareTo(p.planItemInnerNo);                      // 升序排列，反之降序
	}
}
