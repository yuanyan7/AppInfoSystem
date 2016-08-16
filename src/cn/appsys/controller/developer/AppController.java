package cn.appsys.controller.developer;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.AppCategoryService;
import cn.appsys.service.developer.AppInfoService;
import cn.appsys.service.developer.AppVersionService;
import cn.appsys.service.developer.DataDictionaryService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;

@Controller
@RequestMapping(value="/dev/flatform/app")
public class AppController {
	private Logger logger = Logger.getLogger(AppController.class);
	@Resource
	private AppInfoService appInfoService;
	@Resource 
	private DataDictionaryService dataDictionaryService;
	@Resource 
	private AppCategoryService appCategoryService;
	@Resource
	private AppVersionService appVersionService;
	
	@RequestMapping(value="/list")
	public String getAppInfoList(Model model,HttpSession session,
							@RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
							@RequestParam(value="queryStatus",required=false) String _queryStatus,
							@RequestParam(value="queryCategoryLevel1",required=false) String _queryCategoryLevel1,
							@RequestParam(value="queryCategoryLevel2",required=false) String _queryCategoryLevel2,
							@RequestParam(value="queryCategoryLevel3",required=false) String _queryCategoryLevel3,
							@RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
							@RequestParam(value="pageIndex",required=false) String pageIndex){
		
		logger.info("getAppInfoList -- > querySoftwareName: " + querySoftwareName);
		logger.info("getAppInfoList -- > queryStatus: " + _queryStatus);
		logger.info("getAppInfoList -- > queryCategoryLevel1: " + _queryCategoryLevel1);
		logger.info("getAppInfoList -- > queryCategoryLevel2: " + _queryCategoryLevel2);
		logger.info("getAppInfoList -- > queryCategoryLevel3: " + _queryCategoryLevel3);
		logger.info("getAppInfoList -- > queryFlatformId: " + _queryFlatformId);
		logger.info("getAppInfoList -- > pageIndex: " + pageIndex);
		
		Integer devId = ((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId();
		List<AppInfo> appInfoList = null;
		List<DataDictionary> statusList = null;
		List<DataDictionary> flatFormList = null;
		List<AppCategory> categoryLevel1List = null;//列出一级分类列表，注：二级和三级分类列表通过异步ajax获取
		//页面容量
		int pageSize = Constants.pageSize;
		//当前页码
		Integer currentPageNo = 1;
		
		if(pageIndex != null){
			try{
				currentPageNo = Integer.valueOf(pageIndex);
			}catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		Integer queryStatus = null;
		if(_queryStatus != null && !_queryStatus.equals("")){
			queryStatus = Integer.parseInt(_queryStatus);
		}
		Integer queryCategoryLevel1 = null;
		if(_queryCategoryLevel1 != null && !_queryCategoryLevel1.equals("")){
			queryCategoryLevel1 = Integer.parseInt(_queryCategoryLevel1);
		}
		Integer queryCategoryLevel2 = null;
		if(_queryCategoryLevel2 != null && !_queryCategoryLevel2.equals("")){
			queryCategoryLevel2 = Integer.parseInt(_queryCategoryLevel2);
		}
		Integer queryCategoryLevel3 = null;
		if(_queryCategoryLevel3 != null && !_queryCategoryLevel3.equals("")){
			queryCategoryLevel3 = Integer.parseInt(_queryCategoryLevel3);
		}
		Integer queryFlatformId = null;
		if(_queryFlatformId != null && !_queryFlatformId.equals("")){
			queryFlatformId = Integer.parseInt(_queryFlatformId);
		}
		
		//总数量（表）
		int totalCount = 0;
		try {
			totalCount = appInfoService.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		//控制首页和尾页
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		try {
			appInfoList = appInfoService.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
			statusList = dataDictionaryService.getDataDictionaryList("APP_STATUS");
			flatFormList = dataDictionaryService.getDataDictionaryList("APP_FLATFORM");
			categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		return "developer/appinfolist";
	}
	
	/**
	 * 根据parentId查询出相应的分类级别列表
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/categorylevellist.json",method=RequestMethod.GET)
	@ResponseBody
	public List<AppCategory> getAppCategoryList (@RequestParam String pid){
		List<AppCategory> categoryLevelList = null;
		try {
			categoryLevelList = appCategoryService.getAppCategoryListByParentId(Integer.parseInt(pid));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryLevelList;
	}
	/**
	 * 增加app信息（跳转到新增appinfo页面）
	 * @param appInfo
	 * @return
	 */
	@RequestMapping(value="/appinfoadd",method=RequestMethod.GET)
	public String add(@ModelAttribute("appInfo") AppInfo appInfo){
		return "developer/appinfoadd";
	}
	
	/**
	 * 保存新增appInfo（主表）的数据--上传app的LOGO图片
	 * @param appInfo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/appinfoaddsave",method=RequestMethod.POST)
	public String addSave(AppInfo appInfo,HttpSession session,HttpServletRequest request,
					@RequestParam(value="a_logoPicPath",required= false) MultipartFile attach){		
		
		String logoPicPath =  null;
		String logoLocPath =  null;
		if(!attach.isEmpty()){
			String path = request.getSession().getServletContext().getRealPath("statics"+java.io.File.separator+"uploadfiles");
			logger.info("uploadFile path: " + path);
			String oldFileName = attach.getOriginalFilename();//原文件名
			String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
			if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
			   ||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")){//上传图片格式
				 String fileName = appInfo.getAPKName() + ".jpg";//上传LOGO图片命名:apk名称.apk
				 File targetFile = new File(path,fileName);
				 if(!targetFile.exists()){
					 targetFile.mkdirs();
				 }
				 try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("fileUploadError", " * 上传失败！");
					return "developer/appinfoadd";
				} 
				 logoPicPath = request.getContextPath()+"/statics/uploadfiles/"+fileName;
				 logoLocPath = path+File.separator+fileName;
			}else{
				request.setAttribute("fileUploadError", " * 上传LOGO图片格式不正确！");
				return "developer/appinfoadd";
			}
		}
		appInfo.setCreatedBy(((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId());
		appInfo.setCreationDate(new Date());
		appInfo.setLogoPicPath(logoPicPath);
		appInfo.setLogoLocPath(logoLocPath);
		try {
			if(appInfoService.add(appInfo)){
				return "redirect:/dev/flatform/app/list";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "developer/appinfoadd";
	}
	
	/**
	 * 增加appversion信息（跳转到新增app版本页面）
	 * @param appInfo
	 * @return
	 */
	@RequestMapping(value="/appversionadd/{id}",method=RequestMethod.GET)
	public String addVersion(@PathVariable String id,Model model){
		AppVersion appVersion = new AppVersion();
		appVersion.setAppId(Integer.parseInt(id));
		model.addAttribute(appVersion);
		List<AppVersion> appVersionList = null;
		try {
			appVersionList = appVersionService.getAppVersionList(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("appVersionList", appVersionList);
		return "developer/appversionadd";
	}
	/**
	 * 保存新增appversion数据（子表）-上传该版本的apk包
	 * @param appInfo
	 * @param appVersion
	 * @param session
	 * @param request
	 * @param attach
	 * @return
	 */
	@RequestMapping(value="/addversionsave",method=RequestMethod.POST)
	public String addVersionSave(AppVersion appVersion,HttpSession session,HttpServletRequest request,
						@RequestParam(value="a_downloadLink",required= false) MultipartFile attach ){		
		String downloadLink =  null;
		String apkLocPath = null;
		if(!attach.isEmpty()){
			String path = request.getSession().getServletContext().getRealPath("statics"+java.io.File.separator+"uploadfiles");
			logger.info("uploadFile path: " + path);
			String oldFileName = attach.getOriginalFilename();//原文件名
			String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
			if(prefix.equalsIgnoreCase("apk")){//apk文件命名：apk名称+版本号+.apk
				 String apkName = null;
				 try {
					apkName = appInfoService.getAppInfo(appVersion.getAppId(),null).getAPKName();
				 } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				 }
				 if(apkName == null || "".equals(apkName)){
					 request.setAttribute("fileUploadError", " * APK信息不完整！");
					 return "developer/appversionadd";
				 }
				 String fileName = apkName + appVersion.getVersionNo() + ".apk";
				 File targetFile = new File(path,fileName);
				 if(!targetFile.exists()){
					 targetFile.mkdirs();
				 }
				 try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("fileUploadError", " * 上传失败！");
					return "developer/appversionadd";
				} 
				downloadLink = request.getContextPath()+"/statics/uploadfiles/"+fileName;
				apkLocPath = path+File.separator+fileName;
			}else{
				request.setAttribute("fileUploadError", " * 上传apk文件格式不正确！");
				return "developer/appversionadd";
			}
		}
		appVersion.setCreatedBy(((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId());
		appVersion.setCreationDate(new Date());
		appVersion.setDownloadLink(downloadLink);
		appVersion.setApkLocPath(apkLocPath);
		try {
			if(appVersionService.add(appVersion)){
				return "redirect:/dev/flatform/app/list";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "developer/appversionadd";
	}
	
	/**
	 * 判断APKName是否唯一
	 * @param apkName
	 * @return
	 */
	@RequestMapping(value="/apkexist.json",method=RequestMethod.GET)
	@ResponseBody
	public Object apkNameIsExit(@RequestParam String APKName){
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if(StringUtils.isNullOrEmpty(APKName)){
			resultMap.put("APKName", "empty");
		}else{
			AppInfo appInfo = null;
			try {
				appInfo = appInfoService.getAppInfo(null, APKName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(null != appInfo)
				resultMap.put("APKName", "exist");
			else
				resultMap.put("APKName", "noexist");
		}
		return JSONArray.toJSONString(resultMap);
	}
	
	/**
	 * 查看app信息，包括app基本信息和版本信息列表（跳转到查看页面）
	 * @param appInfo
	 * @return
	 */
	@RequestMapping(value="/appview/{id}",method=RequestMethod.GET)
	public String view(@PathVariable String id,Model model){
		AppInfo appInfo = null;
		List<AppVersion> appVersionList = null;
		try {
			appInfo = appInfoService.getAppInfo(Integer.parseInt(id),null);
			appVersionList = appVersionService.getAppVersionList(Integer.parseInt(id));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("appVersionList", appVersionList);
		model.addAttribute(appInfo);
		return "developer/appinfoview";
	}
	
	/**
	 * 修改app信息，包括：修改app基本信息（appInfo）和修改版本信息（appVersion）
	 * 分为两步实现：
	 * 1 修改app基本信息（appInfo）
	 * 2 修改版本信息（appVersion）
	 */
	
	/**
	 * 修改appInfo信息（跳转到修改appInfo页面）
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/appinfomodify/{id}",method=RequestMethod.GET)
	public String modifyAppInfo(@PathVariable String id,Model model){
		AppInfo appInfo = null;
		try {
			appInfo = appInfoService.getAppInfo(Integer.parseInt(id),null);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute(appInfo);
		return "developer/appinfomodify";
	}
	
	/**
	 * 上传logo图片（修改操作）
	 * @param attach
	 * @param APKName
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadlogo")  
	@ResponseBody
    public Object uploadLogo(@RequestParam(value="m_logoPicPath",required= false) MultipartFile attach, 
    						@RequestParam String APKName,HttpServletRequest request) {  
		String logoPicPath =  null;
		String logoLocPath =  null;
		if(!attach.isEmpty()){
			String path = request.getSession().getServletContext().getRealPath("statics"+java.io.File.separator+"uploadfiles");
			logger.info("uploadFile path: " + path);
			String oldFileName = attach.getOriginalFilename();//原文件名
			String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
			int filesize = 50000;
			if(attach.getSize() > filesize){//上传大小不得超过 50k
            	return "1";//上传LOGO图片大小超过50K
            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
			   ||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")){//上传图片格式
				 String fileName = APKName + ".jpg";//上传LOGO图片命名:apk名称.apk
				 File targetFile = new File(path,fileName);
				 if(!targetFile.exists()){
					 targetFile.mkdirs();
				 }
				 try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} 
				 logoPicPath = request.getContextPath()+"/statics/uploadfiles/"+fileName;
				 logoLocPath = path+File.separator+fileName;
				 return logoPicPath+","+logoLocPath;
			}else{
				return "2";//上传LOGO图片格式不正确
			}
		}
		return null;
	}
	
	/**
	 * 修改appInfo操作时，删除logo图片，并更新数据库
	 * @param logoPicPath
	 * @param logoLocPath
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/dellogo")
	@ResponseBody
	public String delFile(@RequestParam(value="logopicpath",required=false) String logoPicPath,
						 @RequestParam(value="logolocpath",required=false) String logoLocPath,
						 @RequestParam(value="id",required=false) String id){
		String result= "failed" ;
		if((logoPicPath == null || logoPicPath.equals("")) &&
			(logoLocPath == null || logoLocPath.equals(""))){
			result = "success"; 
		}else{
			File file = new File(logoLocPath);
		    if(file.exists())
		     if(file.delete()){//删除服务器存储的物理文件
		    	 try {
					if(appInfoService.deleteAppLogo(Integer.parseInt(id))){//更新表
						 result = "success";
					 }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
		return result;
	}
	
	/**
	 * 保存修改后的appInfo？？？得不到appInfo？？？
	 * @param appInfo
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/appinfomodifysave",method=RequestMethod.POST)
	public String modifySave(AppInfo appInfo,HttpSession session){		
		appInfo.setModifyBy(((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId());
		appInfo.setModifyDate(new Date());
		try {
			if(appInfoService.modify(appInfo)){
				return "redirect:/dev/flatform/app/list";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "developer/appinfomodify";
	}
}
