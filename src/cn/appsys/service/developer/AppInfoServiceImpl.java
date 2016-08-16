package cn.appsys.service.developer;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.appsys.dao.developer.AppInfoMapper;
import cn.appsys.pojo.AppInfo;

@Service
public class AppInfoServiceImpl implements AppInfoService {
	@Resource
	private AppInfoMapper mapper;
	
	@Override
	public boolean add(AppInfo appInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mapper.add(appInfo) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean modify(AppInfo appInfo) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mapper.modify(appInfo) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteAppInfoById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mapper.deleteAppInfoById(delId) > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public AppInfo getAppInfo(Integer id,String APKName) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppInfo(id,APKName);
	}

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName,
			Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3,
			Integer queryFlatformId, Integer devId, Integer currentPageNo,
			Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
	}

	@Override
	public int getAppInfoCount(String querySoftwareName, Integer queryStatus,
			Integer queryCategoryLevel1, Integer queryCategoryLevel2,
			Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId);
	}

	@Override
	public boolean deleteAppLogo(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mapper.deleteAppLogo(id) > 0){
			flag = true;
		}
		return flag;
	}

}
