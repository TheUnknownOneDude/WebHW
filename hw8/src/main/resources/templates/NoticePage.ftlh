<#-- @ftlvariable name="noticeForm" type="ru.itmo.wp.form.NoticeForm" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="notice form-box">
        <div class="header">Notice</div>
        <div class="body">
            <form method="post" action="">
                <div class="field">
                    <div class="name">
                        <label for="notice">Notice content</label>
                    </div>
                    <div class="value">
                        <textarea id="notice" name="content">
                        </textarea>
                    </div>
                    <div class="button-field">
                        <input type="submit" value="Create">
                    </div>
                    <@c.error "noticeForm.content"/>
                </div>
            </form>
        </div>
    </div>
</@c.page>


