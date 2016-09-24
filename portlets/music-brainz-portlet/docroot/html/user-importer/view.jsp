<%@ include file="/html/common/init.jsp" %>

<portlet:actionURL name="importUsers" var="importUsersURL">
</portlet:actionURL>

<aui:form method="post" name="fm" action="${importUsersURL}">

    <aui:input name="filePath"/>

    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>
</aui:form>