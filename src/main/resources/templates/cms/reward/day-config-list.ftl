<!DOCTYPE html>
<html>
<head>
	<title>后台管理</title>
    <#include "../common_header.ftl"/>
	
</head>
<body style="zoom: 1;">
	<div class="b-container">
		<#include "../top_menu.ftl"/>
        <#include "../quick_menu.ftl"/>
		<div id="wrap">
            <div class="outer with-side with-transition" style="min-height: 600px;">
                <#include "left_menu.ftl"/>

                <div id="admin_right">
                			<div class="content_box" style="border:none">
                			<div class="position"><span>会员</span><span>&gt;</span><span>lottery</span><span>&gt;</span><span>每天细则</span></div>



                        <div class="content" style="min-height: 200px;">
                            <table class="list_table" style="font-size:13px;">
                                <thead>
                                    <tr style="height:30px;">
                                        <th width="80px">day</th>
                                        <th width="80px">奖项</th>
                                        <th width="150px">rate</th>
                                        <th width="159px">count</th>




                                    </tr>
                                </thead>
                                <tbody>
                                <#list awardDayConfigList as config>
                                    <tr>
                                        <td>${(config.day)!}</td>
                                        <td>${(config.configId)!}</td>
                                        <td>${config.rate!}</td>
                                        <td>${config.count!}</td>

                                    </tr>
                                </#list>
                                </tbody>
                            </table>

                        </div>


                </div>
            </div>
        </div>

		


		</div>

	</div>

	<script type="text/javascript">
		//DOM加载完毕执行
		$(document).ready(function(){
			$("#left_menu_day_config").addClass("selected");

		});
	</script>
<script type="text/javascript" charset="UTF-8" src="/cms/script/member.js"></script>


<div style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255);"></div></body></html>