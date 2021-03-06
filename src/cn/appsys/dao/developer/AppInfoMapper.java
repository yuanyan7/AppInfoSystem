package cn.appsys.dao.developer;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.appsys.pojo.AppInfo;

public interface AppInfoMapper {
	
	public int add(AppInfo appInfo) throws Exception;
	
	public int modify(AppInfo appInfo)throws Exception;
	
	public int deleteAppInfoById(@Param(value="id")Integer delId)throws Exception;
	
	public List<AppInfo> getAppInfoList(@Param(value="softwareName")String querySoftwareName,
										@Param(value="status")Integer queryStatus,
										@Param(value="categoryLevel1")Integer queryCategoryLevel1,
										@Param(value="categoryLevel2")Integer queryCategoryLevel2,
										@Param(value="categoryLevel3")Integer queryCategoryLevel3,
										@Param(value="flatformId")Integer queryFlatformId,
										@Param(value="devId")Integer devId,
										@Param(value="currentPageNo")Integer currentPageNo,
										@Param(value="pageSize")Integer pageSize)throws Exception;
	
	public int getAppInfoCount(@Param(value="softwareName")String querySoftwareName,
							   @Param(value="status")Integer queryStatus,
							   @Param(value="categoryLevel1")Integer queryCategoryLevel1,
							   @Param(value="categoryLevel2")Integer queryCategoryLevel2,
							   @Param(value="categoryLevel3")Integer queryCategoryLevel3,
							   @Param(value="flatformId")Integer queryFlatformId)throws Exception;
	
	public AppInfo getAppInfoById(@Param(value="id")Integer id)throws Exception;

}
