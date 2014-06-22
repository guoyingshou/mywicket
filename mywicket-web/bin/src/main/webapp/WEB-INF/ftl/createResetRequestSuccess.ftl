<#import "spring.ftl" as spring />
<#import "siteGadgets.ftl" as site />

<#assign title="signin" in site>

<@site.layout>
    <@site.siteLogo/>

    <div id="page-main-wrapper">
        <div class="info">
            <@spring.message "Success.resetRequest" />
        </div>
    </div>

</@site.layout>

