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
                			<div class="position"><span>会员</span><span>&gt;</span><span>lottery</span><span>&gt;</span><span>祝福列表</span></div>
                            <div class="operating">
                                <div class="search f_l">
                                    <form  action="" method="get">
                                        是否显示 (1 | 0)
                                        <input class="small" name="status" type="text" value="${(param.status)!}"/>


                                        <button class="btn" type="submit"><span class="sch">搜 索</span></button>
                                    </form>
                                </div>
                            </div>
                        <div class="content" style="min-height: 200px;">
                            <table class="list_table" style="font-size:13px;">
                                <thead>
                                    <tr style="height:30px;">
                                        <th width="80px">id</th>

                                        <th width="150px">昵称</th>
                                        <th width="250px">内容</th>

                                        <th width="180px">状态</th>

                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <#list wishList as user>
                                    <tr>
                                        <td>${(user.id)!}</td>

                                        <td>${user.nickName!}</td>


                                        <td>${(user.text)!}</td>


                                        <td>${user.isShow?default(0)}<#if user.isShow?default(0) = 0>  不显示 <#else> 显示  </#if>  </td>

                                        <td>

                                            <#if user.isShow?default(0) = 0>
                                                <a href="javascript:void(0)" onclick="setShow(${user.id?c})">设为显示</a>
                                            <#else>
                                                <a href="javascript:void(0)" onclick="setHide(${user.id?c})">隐藏</a>
                                            </#if>

                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>

                        </div>


                	${pageDiv}
                </div>
            </div>
        </div>

		


		</div>

	</div>

	<script type="text/javascript">
		//DOM加载完毕执行
		$(document).ready(function(){
			$("#left_menu_wish").addClass("selected");
		});
	</script>
<script type="text/javascript" charset="UTF-8" src="/cms/script/lottery/wish.js"></script>


<div style="display: none; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; cursor: move; opacity: 0; background: rgb(255, 255, 255);"></div></body></html>