<%@ include file="/WEB-INF/jsp/header.jsp"%>
<div><%@ include file="/WEB-INF/jsp/nav.jsp"%></div>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
    <h1> Edition de l'adresse</h1>

    <form:form method="post" action="/editAdress/${id}">

        <form:errors path="*" cssClass="alert alert-danger" element="div" />

        <div class="form-group">
            <label for="ligne"> Tapez l'adresse : </label>
            <form:input path="ligne" class="form-control" />
            <form:errors path="ligne" cssClass="alert alert-warning" element="div" />
        </div>
        <div>
            <td><input type="submit" value="Update" /></td>
        </div>


    </form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>

