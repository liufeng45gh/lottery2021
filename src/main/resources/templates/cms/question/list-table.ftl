<table class="list_table" style="font-size:13px;">
    <thead>
    <tr style="height:30px;">
        <th width="140px">id</th>
        <th width="559px">标题</th>

        <th width="180px">类型</th>
        <th width="180px">状态</th>

        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <#list questionList as question>
    <tr>
        <td>${(question.id)!}</td>

        <td>${(question.title)!}</td>

        <td>
            <#if question.isMoreSelect == 0>
                单选
                <#else>
                多选
            </#if>
        </td>

        <td>
            <#if question.status == "0">
            disable
            <#else>
            <span style="color: green;">enable</span>

            </#if>
        </td>

    <td>
        <a href="javascript:void(0)" onclick="toEdit(${question.id?c})">编辑</a>
         <a href="javascript:void(0)" onclick="toDelete(${question.id?c})">删除</a>
        <#if question.status == "0">
        <a href="javascript:void(0)" onclick="updateStatus(${question.id?c},1)">enable</a>
        <#else>
        <a href="javascript:void(0)" onclick="updateStatus(${question.id?c},0)">disable</a>
        </#if>
    </td>
    </tr>
        </#list>
        </tbody>
</table>
