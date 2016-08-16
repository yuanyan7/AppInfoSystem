package cn.appsys.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.developer.AppVersionMapper;
import cn.appsys.pojo.AppVersion;
@Service
public class AppVersionServiceImpl implements AppVersionService {
	
	@Resource
	private  AppVersionMapper mapper;
	
	@Override
	public List<AppVersion> getAppVersionList(Integer appId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppVersionList(appId);
	}

	@Override
	public boolean add(AppVersion appVersion) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mapper.add(appVersion) > 0){
			flag = true;
		}
		return flag;
	}

}
