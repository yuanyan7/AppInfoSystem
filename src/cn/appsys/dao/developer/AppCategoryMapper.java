package cn.appsys.dao.developer;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryMapper {
	
	public List<AppCategory> getAppCategoryListByParentId(@RequestParam("parentId")Integer parentId)throws Exception;
}
