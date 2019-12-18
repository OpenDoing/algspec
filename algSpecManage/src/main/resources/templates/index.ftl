<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mongo DB</title>
</head>
<body>
<h1>Mongo DB</h1>
<button onclick="window.location.href = '/insertspec'">新增</button>  新增一条数据<br/>
<button onclick="window.location.href = '/save'">保存</button>  将最后新增的数据parameter4改为3000<br/>
<button onclick="window.location.href = '/delete'">删除</button>  删除最先增加的数据<br/>
<button onclick="window.location.href = '/update'">更新</button>  将全部parameter2改为"update"<br/>
<button onclick="window.location.href = '/find'">查询</button><br/>
<#if findTestList??>
    <h2>find</h2>所有数据按时间倒序排列
    <table border="1">
        <tr>
            <th>parameter1</th>
            <th>parameter2</th>
            <th>parameter3</th>
            <th>parameter4</th>
            <th>parameter5</th>
            <th>parameter6</th>
        </tr>
        <#list findTestList as findTest>
            <tr>
                <td>
                   <#if findTest.parameter1??> ${findTest.parameter1}</#if>
                </td>
                <td>
                    <#if findTest.parameter2??> ${findTest.parameter2}</#if>
                </td>
                <td>
                    <#if findTest.parameter3??> ${findTest.parameter3?string('yyyy-MM-dd HH:mm:ss S')}</#if>
                </td>
                <td>
                    <#if findTest.parameter4??> ${findTest.parameter4}</#if>
                </td>
                <td>
                    <#if findTest.parameter5??>
                        <#list findTest.parameter5 as findTest1>
                            ${findTest1.id} - ${findTest1.parameter1} <br/>
                        </#list>
                    </#if>
                </td>
                <td>
                    <#if findTest.parameter6??> ${findTest.parameter6}</#if>
                </td>
            </tr>
        </#list>
    <table/>
</#if>

<#if findOneTest??>
    <h2>findOne</h2>返回最上面的一条
    <table border="1">
        <tr>
            <th>parameter1</th>
            <th>parameter2</th>
            <th>parameter3</th>
            <th>parameter4</th>
            <th>parameter5</th>
            <th>parameter6</th>
        </tr>
        <tr>
            <td>
               <#if findOneTest.parameter1??> ${findOneTest.parameter1}</#if>
            </td>
            <td>
                <#if findOneTest.parameter2??> ${findOneTest.parameter2}</#if>
            </td>
            <td>
                <#if findOneTest.parameter3??> ${findOneTest.parameter3?string('yyyy-MM-dd HH:mm:ss S')}</#if>
            </td>
            <td>
                <#if findOneTest.parameter4??> ${findOneTest.parameter4}</#if>
            </td>
            <td>
                <#if findOneTest.parameter5??>
                    <#list findOneTest.parameter5 as findOneTest1>
                        ${findOneTest1.id} - ${findOneTest1.parameter1} <br/>
                    </#list>
                </#if>
            </td>
            <td>
                <#if findOneTest.parameter6??> ${findOneTest.parameter6}</#if>
            </td>
        </tr>
    <table/>
</#if>

<#if findTestList1??>
    <h2>模糊查询</h2>parameter2包含"es"的数据
    <table border="1">
        <tr>
            <th>parameter1</th>
            <th>parameter2</th>
            <th>parameter3</th>
            <th>parameter4</th>
            <th>parameter5</th>
            <th>parameter6</th>
        </tr>
    <#list findTestList1 as findTest>
            <tr>
                <td>
                   <#if findTest.parameter1??> ${findTest.parameter1}</#if>
                </td>
                <td>
                    <#if findTest.parameter2??> ${findTest.parameter2}</#if>
                </td>
                <td>
                    <#if findTest.parameter3??> ${findTest.parameter3?string('yyyy-MM-dd HH:mm:ss S')}</#if>
                </td>
                <td>
                    <#if findTest.parameter4??> ${findTest.parameter4}</#if>
                </td>
                <td>
                    <#if findTest.parameter5??>
                        <#list findTest.parameter5 as findTest1>
                            ${findTest1.id} - ${findTest1.parameter1} <br/>
                        </#list>
                    </#if>
                </td>
                <td>
                    <#if findTest.parameter6??> ${findTest.parameter6}</#if>
                </td>
            </tr>
    </#list>
    <table/>
</#if>

<#if page??>
    <h2>分页查询</h2>
    每页 <#if page.size??>${page.size}</#if>行&nbsp;
    共 <#if page.totalElements??>${page.totalElements}</#if> 行&nbsp;
    第 <#if page.number??>${page.number+1}</#if>页&nbsp;
    共 <#if page.totalPages??>${page.totalPages}</#if>页&nbsp;
    <table border="1">
        <tr>
            <th>parameter1</th>
            <th>parameter2</th>
            <th>parameter3</th>
            <th>parameter4</th>
            <th>parameter5</th>
            <th>parameter6</th>
        </tr>
        <#list page.content as findTest>
            <tr>
                <td>
                   <#if findTest.parameter1??> ${findTest.parameter1}</#if>
                </td>
                <td>
                    <#if findTest.parameter2??> ${findTest.parameter2}</#if>
                </td>
                <td>
                    <#if findTest.parameter3??> ${findTest.parameter3?string('yyyy-MM-dd HH:mm:ss S')}</#if>
                </td>
                <td>
                    <#if findTest.parameter4??> ${findTest.parameter4}</#if>
                </td>
                <td>
                    <#if findTest.parameter5??>
                        <#list findTest.parameter5 as findTest1>
                            ${findTest1.id} - ${findTest1.parameter1} <br/>
                        </#list>
                    </#if>
                </td>
                <td>
                    <#if findTest.parameter6??> ${findTest.parameter6}</#if>
                </td>
            </tr>
        </#list>
    <table/>
</#if>

<#if findTestList3??>
    <h2>分页查询</h2>通过起始行和数量也可以自己实现分页逻辑
    <table border="1">
        <tr>
            <th>parameter1</th>
            <th>parameter2</th>
            <th>parameter3</th>
            <th>parameter4</th>
            <th>parameter5</th>
            <th>parameter6</th>
        </tr>
        <#list findTestList3 as findTest>
            <tr>
                <td>
                   <#if findTest.parameter1??> ${findTest.parameter1}</#if>
                </td>
                <td>
                    <#if findTest.parameter2??> ${findTest.parameter2}</#if>
                </td>
                <td>
                    <#if findTest.parameter3??> ${findTest.parameter3?string('yyyy-MM-dd HH:mm:ss S')}</#if>
                </td>
                <td>
                    <#if findTest.parameter4??> ${findTest.parameter4}</#if>
                </td>
                <td>
                    <#if findTest.parameter5??>
                        <#list findTest.parameter5 as findTest1>
                            ${findTest1.id} - ${findTest1.parameter1} <br/>
                        </#list>
                    </#if>
                </td>
                <td>
                    <#if findTest.parameter6??> ${findTest.parameter6}</#if>
                </td>
            </tr>
        </#list>
    <table/>
</#if>


</body>
</html>