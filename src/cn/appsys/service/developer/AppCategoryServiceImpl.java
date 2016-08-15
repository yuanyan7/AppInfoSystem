package cn.appsys.service.developer;

import java.util.List;
import javax.annotation.Resource;
import cn.appsys.dao.developer.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;

public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryMapper mapper;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppCategoryListByParentId(parentId);
	}

}
