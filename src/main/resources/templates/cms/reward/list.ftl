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
                			<div class="position"><span>会员</span><span>&gt;</span><span>lottery</span><span>&gt;</span><span>中奖列表</span></div>

                         <#list rewardList as memberList>
                         <div class="position" style="margin-top:20px;"><span>${memberList_index + 1} 等奖中奖结果</span></div>
                        <div class="content" style="min-height: 200px;">
                            <table class="list_table" style="font-size:13px;">
                                <thead>
                                    <tr style="height:30px;">
                                        <th width="80px">id</th>
                                        <th width="250px">微信id</th>
                                        <th width="150px">昵称</th>
                                        <th width="159px">电话</th>

                                        <th width="200px">姓名</th>


                                        <th width="180px">中奖时间</th>


                                    </tr>
                                </thead>
                                <tbody>
                                <#list memberList as user>
                                    <tr>
                                        <td>${(user.id)!}</td>
                                        <td>${(user.wxId)!}</td>
                                        <td>${user.nickName!}</td>
                                        <td>${user.phone!}</td>

                                        <td>${(user.realName)!}</td>


                                        <td>${(user.createdAt)!?datetime} </td>


                                    </tr>
                                </#list>
                                </tbody>
                            </table>

                        </div>
                        </#list>

                </div>
            </div>
        </div>

		


		</div>

	</div>

	<script type="text/javascript">
		//DOM加载完毕执行
		$(document).ready(function(){
			$("#left_menu_welcome").addClass("selected");

		});
	</script>
<script type="text/javascript" charset="UTF-8" src="/cms/script/member.js"></script>


<div style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255);"></div></body></html>