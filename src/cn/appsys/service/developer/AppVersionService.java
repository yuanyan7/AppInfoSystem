package cn.appsys.service.developer;

import java.util.List;
import cn.appsys.pojo.AppVersion;

public interface AppVersionService {
	/**
	 * 根据appId查询相应的app版本列表
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public List<AppVersion> getAppVersionList(Integer appId)throws Exception;
	/**
	 * 新增app版本信息
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean add(AppVersion appVersion)throws Exception;
}
