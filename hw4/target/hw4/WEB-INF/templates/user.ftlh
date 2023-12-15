<#-- @ftlvariable name="handle" type="java.lang.String" -->
<#-- @ftlvariable name="user_id" type="java.lang.Long" -->
<#import "./common.ftlh" as c>

<@c.page>

    <#if handle??>
        <#assign u_h = c.findBy(users, "handle", handle)!/>
        <@c.userpage u_h/>
    <#elseif user_id??>
        <#assign u_id = c.findBy(users, "id", user_id)!/>
        <@c.userpage u_id/>
    <#else>
        нет ничего такого уйдите
    </#if>
</@c.page>
