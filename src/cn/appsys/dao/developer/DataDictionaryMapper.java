package cn.appsys.dao.developer;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryMapper {
	
	public List<DataDictionary> getDataDictionaryList(@RequestParam("typeCode")String typeCode)throws Exception;
}
