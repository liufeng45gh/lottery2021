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
                    <div class="position"><span>问题</span><span>&gt;</span><span>问题列表</span></div>
                    <div class="operating">
                        <div class="search f_l">
                            <form  action="" method="get">
                                标题
                                <input class="small" name="title" type="text" style="width: 260px;" value="${title!}"/>


                                <button class="btn" type="submit"><span class="sch">搜 索</span></button>
                            </form>
                        </div>
                    </div>

                    <div class="content" style="min-height: 200px;">

                        <#include "list-table.ftl"/>
                    </div>

                    ${pageDiv}

                </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    //DOM加载完毕执行
    $(document).ready(function(){
        $("#left_menu_list").addClass("selected");
    });
</script>
<script type="text/javascript" charset="UTF-8" src="/cms/script/question/list.js"></script>
</body></html>