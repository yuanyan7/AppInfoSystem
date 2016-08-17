<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<style>
.dropzone{
	min-height:160px;
	padding:4px;
}
.dropzone .dz-message{
	font-size:24px;
}
.dropzone .dz-message span span{
	font-size:12px;
}
</style>
<div class="clearfix"></div>
            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>新增App基础信息 <small>${devUserSession.devName}</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
 					<div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" ></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <form action="form_upload.html" class="dropzone" style="height:100px;"></form>
                           <div class="clearfix"></div>
                        </div>
                      </div>
                       <div class="clearfix"></div>
                    <form class="form-horizontal form-label-left"   novalidate>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="name1" class="form-control col-md-7 col-xs-12" data-validate-length-range="20" data-validate-words="1" name="name" placeholder="请输入软件名称" required="required" type="text">
                        </div>
                      </div>
                      
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APK名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="name2" class="form-control col-md-7 col-xs-12" data-validate-length-range="20" data-validate-words="1" name="name" placeholder="请输入APK名称" required="required" type="text">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支持ROM <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="name3" class="form-control col-md-7 col-xs-12" data-validate-length-range="20" data-validate-words="1" name="name" placeholder="请输入支持的ROM" required="required" type="text">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">界面语言 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="name4" class="form-control col-md-7 col-xs-12" data-validate-length-range="20" data-validate-words="1" name="name" placeholder="请输入软件支持的界面语言" required="required" type="text">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">软件大小 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="number" id="number" name="number" required="required" data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      
                      
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12"  required="required" for="select">所属平台 </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="form-control">
                            <option value="1">手机</option>
                            <option value="2">平板</option>
                            <option value="3">通用</option>
                          </select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12"  required="required" for="select">一级分类 </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="form-control">
                            <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12"  required="required" for="select">一级分类 </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="form-control">
                            <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12"  required="required" for="select">二级分类 </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="form-control">
                            <option value="0">请选择</option>
                          </select>
                        </div>
                      </div>
                      
                      
                      
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <textarea id="textarea" required="required" name="textarea"   placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12"></textarea>
                        </div>
                      </div>
                      
                 
                    
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button type="submit" class="btn btn-primary">Cancel</button>
                          <button id="send" type="submit" class="btn btn-success">Submit</button>
                        </div>
                      </div>
                    </form>
                    
                    
                    
                     

                    
                  </div>
                </div>
              </div>
            </div>
            
                    
            
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/addApp.js"></script>