<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>答题系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="/swiper/dist/css/swiper.min.css"/>
    <link rel="stylesheet" href="/web/css/mobile.css?v=1.0"/>
    <script  src="/web/js/jquery-3.1.1.js"></script>
    <script  type="text/javascript" src="/layer/layer.js"></script>
    <!-- Swiper JS -->
    <script src="/swiper/dist/js/swiper.min.js"></script>
    <script  type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script  type="text/javascript" src="/js/wx-share.js?version=1.0"></script>
    <script src="/web/js/common.js"></script>


</head>
<body>
<!-- Swiper -->
<link rel="stylesheet" href="/web/css/user-info.css"/>

<div class="page-bg-1">
    <img class="img-bg-1" src="/web/img/page1/bg.jpg"/>
    <img class="logo-1" src="/web/img/page1/logo.png"/>

    <div class="location">
        <div class="title-1" >
            请完善个人信息
        </div>


        <div class="title-3">
            <input placeholder="请输入姓名" class="name_input" id="nick_name"/>
        </div>
        <div class="title-4">
            <!--
            <input placeholder="请输入单位" class="name_input" id="department"/>
            -->
            <select class="name_input company" id="company" onChange="setCompany(this);">
                <option value="">请选择</option>
                <option value="总部机关">总部机关</option>
                <option value="天然气省公司">天然气省公司</option>
                <option value="派出机构">派出机构</option>
                <option value="液化石油气公司">液化石油气公司</option>
                <option value="液化天然气单位">液化天然气单位</option>
                <option value="其他单位">其他单位</option>
            </select>

            <select class="name_input department" id="department">
                <option>----请选择----</option>
            </select>
            <!--
            <select class="name_input department" >
                <option value="">请选择</option>
                <option value="办公室（党委办公室、公共关系部）">办公室（党委办公室、公共关系部）</option>
                <option value="战略发展部">战略发展部</option>
                <option value="规划计划部">规划计划部</option>
                <option value="财务资产部">财务资产部</option>
                <option value="人力资源部（党委组织部）">人力资源部（党委组织部）</option>
                <option value="资本运营部（董监事办公室）">资本运营部（董监事办公室）</option>
                <option value="法律事务部">法律事务部</option>
                <option value="市场营销部（客户服务部）">市场营销部（客户服务部）</option>
                <option value="资源采购部">资源采购部</option>
                <option value="生产运行部">生产运行部</option>
                <option value="液化石油气部">液化石油气部</option>
                <option value="LNG部">LNG部</option>
                <option value="工程管理部">工程管理部</option>
                <option value="物资管理部">物资管理部</option>
                <option value="质量安全环保部">质量安全环保部</option>
                <option value="科技信息部">科技信息部</option>
                <option value="监察部（纪委办公室、党委巡察办公室）">监察部（纪委办公室、党委巡察办公室）</option>
                <option value="审计部">审计部</option>
                <option value="企业管理部">企业管理部</option>
                <option value="国际合作部">国际合作部</option>
                <option value="党群工作部（党委宣传部、企业文化部）">党群工作部（党委宣传部、企业文化部）</option>
                <option value="董事会秘书处">董事会秘书处</option>

            </select>

            <select class="name_input department" >
                <option value="">请选择</option>
                <option value="天然气黑龙江分公司">天然气黑龙江分公司</option>
                <option value="天然气吉林分公司">天然气吉林分公司</option>
                <option value="天然气辽宁分公司">天然气辽宁分公司</option>
                <option value="天然气北京分公司">天然气北京分公司</option>
                <option value="天然气天津分公司">天然气天津分公司</option>
                <option value="天然气河北分公司">天然气河北分公司</option>
                <option value="天然气山西分公司">天然气山西分公司</option>
                <option value="天然气内蒙古分公司">天然气内蒙古分公司</option>
                <option value="天然气山东分公司">天然气山东分公司</option>
                <option value="天然气河南分公司">天然气河南分公司</option>
                <option value="天然气安徽分公司">天然气安徽分公司</option>
                <option value="LNG部">LNG部</option>
                <option value="工程管理部">工程管理部</option>
                <option value="物资管理部">物资管理部</option>
                <option value="质量安全环保部">质量安全环保部</option>
                <option value="科技信息部">科技信息部</option>
                <option value="监察部（纪委办公室、党委巡察办公室）">监察部（纪委办公室、党委巡察办公室）</option>
                <option value="审计部">审计部</option>
                <option value="企业管理部">企业管理部</option>
                <option value="国际合作部">国际合作部</option>
                <option value="党群工作部（党委宣传部、企业文化部）">党群工作部（党委宣传部、企业文化部）</option>
                <option value="董事会秘书处">董事会秘书处</option>
                <option value="其他单位">其他单位</option>
                <option value="其他单位">其他单位</option>
            </select>
            -->
        </div>


        <div class="btn-1" onclick="submitUserInfo();" >
            保存设置
        </div>


        <!--
        <a class="btn-1" style="display: block; " href="/list">
            保存
        </a>

          -->

    </div>






</div>


<!-- Initialize Swiper -->
<script src="/web/js/user-info.js"></script>

<script src="/web/js/company-select.js"></script>

</body>
</html>
