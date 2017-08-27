<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form role="form" id="editformId" class="form editform">
  <input type="hidden" class="proId" name="id"/>
  <div class="form-group">
    <label for="examplprojectecode">项目编码</label>
    <input type="text" name="code" class="form-code required" id="code" placeholder="项目编码">
  </div>
  <div class="form-group">
    <label for="examplprojectename">项目名称</label>
    <input type="text" name="name" class="form-name" id="name" placeholder="项目名称">
  </div>
   <div class="form-group">
    <label for="exampleprojectcreatetime">项目开始日期</label>
    <input type="text" name="beginDate" class="form-beginDate datepiker" id="beginDate" placeholder="yyyy-MM-dd">
  </div>
  <div class="form-group">
    <label for="exampleprojectcreatetime">项目结束日期</label>
    <input type="text" name="endDate" class="form-endDate datepiker" id="endDate" placeholder="yyyy-MM-dd">
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
    <input type="text" name="note" class="form-note" id="note" placeholder="备注">
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
<script>
/**模态框显示日期*/
	$(".editform .datepiker").datepicker({
		format:"yyyy-mm-dd",
		autoclose:true
	});
</script>