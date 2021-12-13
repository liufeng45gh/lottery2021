<table class="table_new">
    <tbody>
    <tr><th width="20%"></th><td><span style="color:${KEY_RESULT_MESSAGE_COLOR?default("")};">${KEY_RESULT_MESSAGE?default("")}</span></td></tr>
    <tr>
        <th width="20%" style="text-align:right; vertical-align: middle;">问题标题:</th>
        <td>
            <input type="hidden" id="id_input" value="${(question.id)!}"/>
            <input id="title_input"  class="form-control" style="display:inline-block;" value="${(question.title)!}" />
            <label id="account_input_info" style="display:inline-block;">* 问题标题</label>
        </td>
    </tr>
    <tr>
        <th width="20%" style="text-align:right;">单选/多选:</th>
        <td>

            <select id = "isMoreSelect">
                <option value="0"> 单选</option>
                <option value="1">多选</option>
            </select>
            <!--
             <input type="hidden" id="isMoreSelect" name="isMoreSelect"/>
            <input id="isMoreSelect_input" readonly="readonly" class="form-control" name="category" style="display:inline-block;"/><label id="isMoreSelect_input_info" style="display:inline-block;">* 单选/多选</label>
             -->
        </td>
    </tr>

</tbody>
        </table>
<table style="display:none;" >
<tbody id="answer-template" >
<tr class="add-new">
    <th width="20%" style="text-align:right;vertical-align: middle;"><label  style="display:inline-block;float:right;">*  答案内容</label></th>
    <td>
        <input  class="form-control option"  style="width: 70px;display:inline-block;"/>
        <input  class="form-control content"  style="display:inline-block;margin-left:3px;"/>
        <a href="javascript:void(0)" onclick="removeAnswerThis(this);"  class="delete-a">删除</a>
        <label  style="display:inline-block;"></label>
    </td>
</tr>
</tbody>

</table>
<table class="table_new">
<tbody id="answer-body">
    <tr>
        <th width="20%" style="text-align:right;"></th>
        <td>
            <button class="btn btn-primary" type="button" onclick="addAnswer();">添加答案</button>
        </td>
    </tr>
    <#if answerList??>
        <#list answerList as answer>
            <tr class="add-new">
                <th width="20%" style="text-align:right;vertical-align: middle;"><label  style="display:inline-block;float:right;">*  答案内容</label></th>
                <td>
                    <input  class="form-control option"  style="width: 70px;display:inline-block;" value="${(answer.option)!}"/>
                    <input  class="form-control content"  style="display:inline-block;margin-left:3px;" value="${(answer.content)!}"/>
                    <a href="javascript:void(0)" onclick="removeAnswerThis(this);" class="delete-a">删除</a>
                    <label  style="display:inline-block;"></label>
                </td>
            </tr>
        </#list>
    </#if>
</tbody>
</table>
<table class="table_new">
<tbody>
<tr>
    <th width="20%" style="text-align:right;">正确答案:</th>
    <td>
        <input id="right_answer"  class="form-control"  style="display:inline-block;" value="${(question.rightAnswer)!}"/>
        <label id="right_answer_input_info" style="display:inline-block;">* 正确答案</label>
    </td>
</tr>
<tr>
    <th width="20%" style="text-align:right;">填写正确答案描述:</th>
    <td>
        <textarea id="editor" style="width:1024px;height:500px;" name="content">${(question.rightAnswerDescription)!?html}</textarea>
    </td>
</tr>
<tr>
    <th></th>
    <td>
        <button class="btn btn-primary"   id="btn-submit">保存设置</button>
    </td>
</tr>
</tbody>
</table>
<script type="text/javascript" charset="UTF-8" src="/cms/script/question/form_filed.js"></script>