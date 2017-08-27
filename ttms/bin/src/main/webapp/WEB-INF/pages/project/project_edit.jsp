<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form role="form" class="form editform">
  <div class="form-group">
    <label for="examplprojectecode">项目编码</label>
    <input type="text" name="code" class="form-control" id="exampleInputEmail1" placeholder="项目编码">
  </div>
  <div class="form-group">
    <label for="examplprojectename">项目名称</label>
    <input type="text" name="name" class="form-control" id="exampleInputPassword1" placeholder="项目名称">
  </div>
   <div class="form-group">
    <label for="exampleprojectcreatetime">项目开始日期</label>
    <input type="text" name="beginDate" class="form-control datepiker" id="exampleInputPassword1" placeholder="yyyy-MM-dd">
  </div>
  <div class="form-group">
    <label for="exampleprojectcreatetime">项目结束日期</label>
    <input type="text" name="endDate" class="form-control datepiker" id="exampleInputPassword1" placeholder="yyyy-MM-dd">
  </div>
  <div class="form-group">
    <label for="exampleprojectvalid">项目有效性</label>
    <fieldset>
    	<input type="radio" name="valid" value="0"/>禁用
    	<input type="radio" name="valid" value="1"/>启用
    </fieldset>
  </div>
   <div class="form-group">
    <label for="exampleprojectnote">备注</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="备注">
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>