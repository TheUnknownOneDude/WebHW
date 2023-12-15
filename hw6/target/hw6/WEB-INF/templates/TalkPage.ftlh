<#-- @ftlvariable name="targetUserId" type="Number" -->
<#-- @ftlvariable name="error" type="String" -->
<#-- @ftlvariable name="messageText" type="String" -->
<#-- @ftlvariable name="users" type="ru.itmo.wp.model.domain.User[]" -->
<#-- @ftlvariable name="talks" type="ru.itmo.wp.model.domain.Talk[]" -->

<#import "commons.ftlh" as c>

<@c.page>
    <div class="form-box">
        <div class="header">Send Message</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="sendMessageToTarget"/>
                <div class="field">
                    <div class="name">
                        <label for="targetUserId">Target User</label>
                    </div>
                    <div class="value">
                        <input id="targetUserId" name="targetUserId" value="${targetUserId!}"/>
                    </div>
                </div>
                <div class="field">
                    <div class="name">

                        <label for="messageText">Message text</label>
                    </div>
                    <div class="value">
                        <input id="messageText" name="messageText" value="${messageText!}"/>
                    </div>
                </div>
                <#if error??>
                    <div class="error">
                        ${error!}
                    </div>
                </#if>
                <div class="button-field">
                    <input type="submit" value="Enter">
                </div>
            </form>
        </div>
    </div>
    <div class="datatable">
        <div class="caption">Messages to and from you</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>From</th>
                <th>To</th>
            </tr>
            </thead>
            <tbody>
            <#list talks as talk>
                <tr>
<#--                    <#assign userName=c.findBy(users, "id", targetUserId)>-->
                    <td>${talk.sourceUserId}</td>
                    <td>${talk.targetUserId}</td>
                    <td>${talk.text}</td>
                    <td>${talk.creationTime}</td>
                </tr>
            </#list>^
            </tbody>
        </table>
    </div>
</@c.page>