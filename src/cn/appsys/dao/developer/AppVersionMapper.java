package cn.appsys.dao.developer;

import java.util.List;

import cn.appsys.pojo.AppVersion;

public interface AppVersionMapper {
	
	public List<AppVersion> getAppVersionList(Integer appId) throws Exception;
	
	public int add(AppVersion appVersion)throws Exception;
}
